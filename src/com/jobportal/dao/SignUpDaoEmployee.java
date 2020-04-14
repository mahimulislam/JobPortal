package com.jobportal.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class SignUpDaoEmployee {
String url="jdbc:mysql://localhost:3306/jobportaldb";
String username="root";
String password="Valoakash1234";

String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "jobportaldb";
String userId = "root";

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
public String id(){
	String i="";
	
	try{ 
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection(url,username,password);
		statement=(Statement) con.createStatement();
		String sql ="SELECT * FROM EmployeeDetails;";

		resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
		i=resultSet.getString("eid");
		}
		
		} catch (Exception e) {
		e.printStackTrace();
		}
	
	return i;
}
public boolean check(String uname,String dateofbirth,String address,String email,String pass,String mobile,String id){
		try{
			String sql1="insert into EmployeeDetails VALUES (?,?,?,?,?,?);";
			
			String sql2="insert into EmployeeLogin VALUES (?,?,?);";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url,username,password);
			PreparedStatement st1=con.prepareStatement(sql1);
			st1.setString(1, uname);
			st1.setString(2, address);
			st1.setString(3, dateofbirth);
			st1.setString(4, mobile);
			st1.setString(5,  email);
			st1.setString(6,  id);
			
			st1.executeUpdate();
			
			PreparedStatement st2=con.prepareStatement(sql2);
			st2.setString(1,  id);
			st2.setString(2, email);
			st2.setString(3, pass);
			st2.executeUpdate();
			
			con.setAutoCommit(true);
			return true;
		}
		
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
}
