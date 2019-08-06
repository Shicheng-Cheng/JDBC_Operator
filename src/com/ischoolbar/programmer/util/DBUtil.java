package com.ischoolbar.programmer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
	private String dbUrl="jdbc:mysql://localhost:3306/db1";
	private String dbUser="root";
	private String dbPassword="admin";
	private String dbDriver="com.mysql.cj.jdbc.Driver";
	private Connection connection=null;
	public Connection getConnection() {
		
		try {
			Class.forName(dbDriver);
			connection=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
			System.out.println("数据库连接成功");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
		
	public void closeConnection() {
		if(connection!=null) {
			try {
				connection.close();
				System.out.println("数据库成功关闭");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBUtil dbUtil=new DBUtil();
		dbUtil.getConnection();
		
	}

}
