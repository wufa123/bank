package com.zx.bank.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zx.bank.dao.AccountDao;
import com.zx.bank.db.JdbcTemplate;
import com.zx.bank.db.RowMapper;
import com.zx.bank.entity.Account;

public class AccountDaoImpl extends JdbcTemplate implements AccountDao {

	@Override
	public Account getAccount(String accountId) {
		// TODO Auto-generated method stub
		String sql ="select account_id, password, remaining from account where account_id=?";
		List<Account> list = new ArrayList<Account>();
		Object[] params = new Object[]{accountId};
		list = this.queryForList(new RowMapper<Account>(){

			@Override
			public Account mappingRow(ResultSet rs, int rownum) throws SQLException {
				// TODO Auto-generated method stub
				Account account = new Account();
				account.setAccountId(rs.getString("account_id"));
				account.setPassword(rs.getString("password"));
				account.setRemaining(rs.getBigDecimal("remaining"));
				return account;
			}
			
		}, sql, params);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}else {
			return null;
		}
	}

}
