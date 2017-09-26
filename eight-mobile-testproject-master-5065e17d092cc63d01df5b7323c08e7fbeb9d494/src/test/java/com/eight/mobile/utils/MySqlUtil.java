/**
 * 连接mysql数据库
 * @author leogle
 */
package com.eight.mobile.utils;











import com.mysql.jdbc.Driver;

import  java.sql.DriverManager;
import  java.sql.Connection;
import  java.sql.SQLException;
import  java.sql.Statement;
import  java.sql.ResultSet;

public class MySqlUtil {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private  String url;
	private  String name;
	private  String password;
	private  Connection con = null;
	private  Statement  stm = null;
	private  ResultSet  res = null;
	private  static Driver driver;
	static{

			try {
				driver = new Driver();
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}
	
	/**
	 * 构造方法
	 * @param  url        数据库地址
	 * @param  name       数据库用户名
	 * @param  password   数据库密码
	 */


	public  MySqlUtil(String url,String name,String password){
		this.url = url;
		this.name = name;
		this.password = password;
	}
	
	/**
	 * 连接mysql数据库
	 * 
	 */
	public  boolean Connect(){
		try{
			con = DriverManager.getConnection("jdbc:mysql://" + url,name,password);
			stm = con.createStatement();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;	
	}
	
	/**
	 * 数据库查询
	 * 
	 */
	public  ResultSet Query(String cmd){
		try{
			res = stm.executeQuery(cmd);
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * 数据库插入
	 *
	 */
	public  boolean insert(String cmd){
		try{
			stm.executeUpdate(cmd);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 数据库更新
	 * 
	 */
	public  boolean update(String cmd){
		try{
			stm.executeUpdate(cmd);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 数据库删除
	 * 
	 */
	public  boolean delete(String cmd){
		try{
			stm.executeUpdate(cmd);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	
		return true;
	}
	
	/**
	 * 关闭连接
	 * 
	 */
	public  boolean Close(){
		try{
			
			if(res != null){
				res.close();
				res = null;
			}
			
			if(stm != null){
				stm.close();
				stm = null;
			}
			
			if(con != null){
				con.close();
				con = null;
			}
				
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

