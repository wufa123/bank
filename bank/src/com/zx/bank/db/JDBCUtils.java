package com.zx.bank.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.zx.bank.exception.BaseInfoException;

public class JDBCUtils {

	/**
	 * 取得数据库的连接
	 */
	public static Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			// 得到类加载对象
			ClassLoader cl = JDBCUtils.class.getClassLoader();
			// 通过类加载器对象得到指定的资源文件字节流
			InputStream is = cl.getResourceAsStream("jdbc.properties");
			Properties dbconfig = new Properties();
			dbconfig.load(is);

			Class.forName(dbconfig.getProperty("jdbc.driver"));
			String url = dbconfig.getProperty("jdbc.url");
			String user = dbconfig.getProperty("jdbc.user");
			String pwd = dbconfig.getProperty("jdbc.password");

			conn = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseInfoException("数据库连接错误!");
		}
		return conn;
	}

	/**
	 * 关闭数据库
	 */
	public static void closeConnection(Connection conn, PreparedStatement pre, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pre != null) {
				pre.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BaseInfoException("数据库连接错误!");
		}
	}

}
