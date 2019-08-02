package com.zx.bank.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {

	/**
	 * 查询的封装方法
	 * T 是一个抽象的javabean,实体类
	 * 
	 */
	public <T> List<T> queryForList(RowMapper<T> mapper, String sql, Object[] params){
		List<T> returnResult = new ArrayList<T>();
		Connection conn = null; // 一个数据库连接
		PreparedStatement pre = null; // 预编译对象
		ResultSet rs = null; // 结果集
		
		try {
			conn = JDBCUtils.getConnection();
			pre = conn.prepareStatement(sql);
			//设置sql所需要的参数
			setParams(params, pre);
			rs = pre.executeQuery();
			int rownum = 0;
			while(rs.next()){
				rownum++;
				returnResult.add(mapper.mappingRow(rs, rownum));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeConnection(conn, pre, rs);
		}
		
		
		return returnResult;
	}
	
	/**
	 * 封装增删改的模板方法
	 */
	public int updateTemplate(String sql, Object[] params){
		int rows = 0;
		Connection conn = null; // 一个数据库连接
		PreparedStatement pre = null; // 预编译对象
		ResultSet rs = null; // 结果集
		
		try {
			conn = JDBCUtils.getConnection();
			pre = conn.prepareStatement(sql);
			//设置sql所需要的参数
			setParams(params, pre);
			rows = pre.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.closeConnection(conn, pre, rs);
		}
		
		return rows;
	}
	
	/**
	 * 动态设置参数
	 */
	protected void setParams(Object[] params, PreparedStatement pre) throws SQLException{
		if(params != null){
			for(int i = 0; i < params.length; i++){
				pre.setObject(i+1, params[i]);
			}
		}
	}
	
}
