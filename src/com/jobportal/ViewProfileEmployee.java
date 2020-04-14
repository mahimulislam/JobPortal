package com.jobportal;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
public class ViewProfileEmployee extends HttpServlet
{
	
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "jobportaldb";
String userId = "root";
String password = "Valoakash1234";
String ename="";
String edob="";
String eaddress="";
String eemail="";
String emobile="";
String empid="";


	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		//String formemail=req.getParameter("email");
		String formemail=req.getParameter("email");
		System.out.println(formemail);
		try {
	Class.forName(driverName);
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	}

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	try{ 
		connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
		statement=connection.createStatement();
		String sql ="SELECT * FROM EmployeeDetails where eemail = '"+formemail+"';";

		resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
		ename=resultSet.getString("ename");
		edob=resultSet.getString("edob");
		eaddress=resultSet.getString("eaddress");
		eemail=resultSet.getString("eemail");
		emobile=resultSet.getString("emobile");
		empid=resultSet.getString("eid");
		}}
	catch(Exception ex){
		
		ex.printStackTrace();
	}
			
		System.out.println(ename);
		System.out.println(edob);
		System.out.println(eaddress);
		System.out.println(eemail);
		System.out.println(empid);
		req.setAttribute("enames",ename);
		req.setAttribute("edobs",edob);
		req.setAttribute("eaddresss",eaddress);
		req.setAttribute("emobiles",emobile);
		req.setAttribute("eemails",eemail);
		req.setAttribute("empids",empid);
		RequestDispatcher rd=req.getRequestDispatcher("viewprofileemployee.jsp?ename="+ename+"&edob="+edob+"&email="+eemail+"&eaddress="+eaddress+"&emobile="+emobile);
		rd.forward(req, res); 
	}
}
