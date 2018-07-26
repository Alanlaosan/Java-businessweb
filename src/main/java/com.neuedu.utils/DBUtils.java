package com.neuedu.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {

	static Properties ps=new Properties();
	
	//静态代码块
	static {
		//加载驱动
		try {
			ps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties"));
			Class.forName(ps.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	
		
	}
	
	//获取连接
	public  static   Connection  getConnection() throws SQLException {
		
		 String  url=ps.getProperty("url");
		 String  user=ps.getProperty("username");
		 String password=ps.getProperty("password");
		 return DriverManager.getConnection(url, user, password);
		
	}
	
	//关闭链接
	public  static  void  close(Connection conn,Statement st) throws SQLException {
		if(conn!=null) {
			conn.close();
		}
		if(st!=null) {
			st.close();
		}
	}
	public  static  void  close(Connection conn,Statement st,ResultSet rs) throws SQLException {
		if(conn!=null) {
			conn.close();
		}
		if(st!=null) {
			st.close();
		}
		if(rs!=null) {
			rs.close();
		}
	}
	
	
	
	
	
	
}
