package com.jobportal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
 public class UpdateProfileClient extends HttpServlet
{

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		String ids=req.getParameter("empoid");
		String name=req.getParameter("name");

		Connection connection = null;
		Statement statement = null;  

		String driverName = "com.mysql.jdbc.Driver";
		String connectionUrl = "jdbc:mysql://localhost:3306/";
		String dbName = "jobportaldb";
		String userId = "root";
		String password = "Valoakash1234";
		//String address=req.getParameter("address");
		//String city=req.getParameter("city");
		String mobile=req.getParameter("mobile");
		String formemail=req.getParameter("eqmail");
		String eaddress=req.getParameter("address");
		String edob=req.getParameter("dob");

		String sql = "update ClientDetails set cname = '"+name+"' ,cmobile = '"+mobile+"', caddress = '"+eaddress+"',cdob = ' "+edob+"' where cemail='"+formemail+"';";
	    try {
	    		connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
	    		statement=connection.createStatement(); 
	      statement.executeUpdate(sql);
	      System.out.println("Database updated successfully ");
	      RequestDispatcher rd=req.getRequestDispatcher("viewprofileclient.jsp?enames="+name+"&edobs="+edob+"&eemail="+formemail+"&eaddresss="+eaddress+"&emobiles="+mobile);
			rd.forward(req, res);
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	}
		
	}

