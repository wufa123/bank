package com.zx.bank.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zx.bank.dao.TradeDao;
import com.zx.bank.db.JDBCUtils;
import com.zx.bank.db.JdbcTemplate;
import com.zx.bank.db.RowMapper;
import com.zx.bank.entity.Trade;
import com.zx.bank.exception.BaseInfoException;

public class TradeDaoImpl extends JdbcTemplate implements TradeDao {

	@Override
	public void transferAccount(String receiveAccount, BigDecimal receiveMoney, String fromAccount) {
		// TODO Auto-generated method stub
		Connection conn = null; // 一个数据库连接
		PreparedStatement pre = null; // 预编译对象
		ResultSet rs = null; // 结果集
		
		try {
			conn = JDBCUtils.getConnection();
			conn.setAutoCommit(false);
			//1：修改转出账户金额
			String fromsql = "update account set remaining = remaining - ? where account_id = ?";
			Object[] params = new Object[]{receiveMoney, fromAccount};
			pre = conn.prepareStatement(fromsql);
			//设置sql所需要的参数
			setParams(params, pre);
			pre.executeUpdate();
			
			String insertsql1 = "insert into trade(account_id, trade_type, trade_money, "
					+ "trade_time, trade_digest) values(?, ?, ?, now(), ?)";
			Object[] inparams = new Object[]{fromAccount, "转出", receiveMoney, "接收账户" + receiveAccount};
			pre = conn.prepareStatement(insertsql1);
			//设置sql所需要的参数
			setParams(inparams, pre);
			pre.executeUpdate();
			
			String tosql = "update account set remaining = remaining + ? where account_id = ?";
			Object[] params1 = new Object[]{receiveMoney, receiveAccount};
			pre = conn.prepareStatement(tosql);
			//设置sql所需要的参数
			setParams(params1, pre);
			pre.executeUpdate();
			
			
			String insertsql2 = "insert into trade(account_id, trade_type, trade_money, "
					+ "trade_time, trade_digest) values(?, ?, ?, now(), ?)";
			Object[] inparams2 = new Object[]{receiveAccount, "转入", receiveMoney, "转出账户" + fromAccount};
			pre = conn.prepareStatement(insertsql2);
			//设置sql所需要的参数
			setParams(inparams2, pre);
			pre.executeUpdate();
			
			
			
			conn.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new BaseInfoException("转账不成功！");
		}finally{
			JDBCUtils.closeConnection(conn, pre, rs);
		}
	}
	


	@Override
	public List<Trade> getTradeList(String startTime, String endTime, String accountId) {
		// TODO Auto-generated method stub
		String sql ="select * from trade where account_id=? and trade_time>? and trade_time<? order by trade_time desc";
		List<Trade> list = new ArrayList<Trade>();
		Object[] params = new Object[]{accountId, startTime, endTime};
		list = this.queryForList(new RowMapper<Trade>(){

			@Override
			public Trade mappingRow(ResultSet rs, int rownum) throws SQLException {
				// TODO Auto-generated method stub
				Trade trade = new Trade();
				trade.setId(rs.getInt("id"));
				trade.setAccountId(rs.getString("account_id"));
				trade.setTradeType(rs.getString("trade_type"));
				trade.setTradeMoney(rs.getBigDecimal("trade_money"));
				trade.setTradeTime(rs.getTimestamp("trade_time"));
				trade.setTradeDigest(rs.getString("trade_digest"));
				return trade;
			}
			
		}, sql, params);
		return list;
	}

}
