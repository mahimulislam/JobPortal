package com.jobportal.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class PostJobDaoClient {
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
		String sql ="SELECT * FROM JobDetails;";

		resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
		i=resultSet.getString("jobNo");
		}
		
		} catch (Exception e) {
		e.printStackTrace();
		}
	
	return i;
}
public boolean check(String postingdate,String category,String details,String title,String shortdet,String
		clientno,String id){
		try{
			String sql1="insert into JobDetails VALUES (?,?,?,?,?,?,?,?);";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url,username,password);
			PreparedStatement st1=con.prepareStatement(sql1);
			st1.setString(1,  id);
			st1.setString(2, "Active");
			st1.setString(3, postingdate);
			st1.setString(4, category);
			st1.setString(5, clientno);
			st1.setString(6, details);
			st1.setString(7, title);
			st1.setString(8,  shortdet);
			
			st1.executeUpdate();
				
			con.setAutoCommit(true);
			return true;
		}
		
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
}
