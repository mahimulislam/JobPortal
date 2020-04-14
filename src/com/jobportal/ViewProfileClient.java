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
public class ViewProfileClient extends HttpServlet
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
		String sql ="SELECT * FROM ClientDetails where cemail = '"+formemail+"';";

		resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
		ename=resultSet.getString("cname");
		edob=resultSet.getString("cdob");
		eaddress=resultSet.getString("caddress");
		eemail=resultSet.getString("cemail");
		emobile=resultSet.getString("cmobile");
		empid=resultSet.getString("cid");
		}}
	catch(Exception ex){
		
		ex.printStackTrace();
	}
			
		System.out.println(ename);
		System.out.println(edob);
		System.out.println(eaddress);
		System.out.println(eemail);
		System.out.println(empid);
		req.setAttribute("cname",ename);
		req.setAttribute("cdob",edob);
		req.setAttribute("caddress",eaddress);
		req.setAttribute("cmobile",emobile);
		req.setAttribute("cemail",eemail);
		req.setAttribute("cid",empid);
		RequestDispatcher rd=req.getRequestDispatcher("viewprofileclient.jsp?cname="+ename+"&cdob="+edob+"&cemail="+eemail+"&caddress="+eaddress+"&cmobile="+emobile);
		rd.forward(req, res); 
	}
}
