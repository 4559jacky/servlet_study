package com.gn.common.sql;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		try {
			String path = JDBCTemplate.class.getResource("driver.properties").getPath();
			prop.load(new FileReader(path));
			
			Class.forName(prop.getProperty("driver"));
			String url = prop.getProperty("url");
			String user = prop.getProperty("username");
			String pw = prop.getProperty("userpw");
			
			conn = DriverManager.getConnection(url,user,pw);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void commit(Connection conn){
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn){
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null && conn.isClosed() == false) {
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Statement와 PreparedStatement 모두 사용 가능(다형성)
	public static void close(Statement stmt) {
		try {
			if(stmt != null && stmt.isClosed() == false) {
				stmt.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs!= null && rs.isClosed() == false) {
				rs.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// State와 ResultSet을 한번에 close
	public static void close(Statement stmt, ResultSet rs) {
		try {
			if(stmt!= null && stmt.isClosed() == false) {
				stmt.close();
			}
			if(rs!= null && rs.isClosed() == false) {
				rs.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
