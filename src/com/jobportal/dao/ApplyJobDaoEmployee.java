package com.jobportal.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class ApplyJobDaoEmployee {
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
		String sql ="SELECT * FROM JobApplications;";

		resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
		i=resultSet.getString("appid");
		}
		
		} catch (Exception e) {
		e.printStackTrace();
		}
	
	return i;
}
public String empno(String email){
	String i="";
	try{ 
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection(url,username,password);
		statement=(Statement) con.createStatement();
		String sql ="SELECT * FROM EmployeeDetails where eemail ='"+email+"';";

		resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
		int p;
			p=resultSet.getInt("eid");
			i=Integer.toString(p);
		}
		
		} catch (Exception e) {
		e.printStackTrace();
		}
	
	return i;
}
public boolean check(String formcno,String formeno,String id,String jobno){
		try{
			String sql1="insert into JobApplications VALUES (?,?,?,?);";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url,username,password);
			PreparedStatement st1=con.prepareStatement(sql1);
			st1.setString(1,  id);
			st1.setString(2, jobno);
			st1.setString(3, formcno);
			st1.setString(4, formeno);
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
