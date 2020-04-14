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
public class ViewPastProjectClient extends HttpServlet
{
	
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "jobportaldb";
String userId = "root";
String password = "Valoakash1234";
String empid="";
String postingdate="";
String category="";
String details="";
String title="";
String shortdetails="";


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
		empid=resultSet.getString("cid");
		}}
	catch(Exception ex){
		
		ex.printStackTrace();
	}
	try{ 
		connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
		statement=connection.createStatement();
		
		String sql ="SELECT * FROM JobDetails where cno = '"+empid+"'and status='Deactive';";
		resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
		
			postingdate=resultSet.getString("postingdate");

			category=resultSet.getString("category");

			details=resultSet.getString("details");

			title=resultSet.getString("title");

			shortdetails=resultSet.getString("shortdetails");


		}}
	catch(Exception ex){
		
		ex.printStackTrace();
	}
		System.out.println(title);
		req.setAttribute("postingdate",postingdate);
		req.setAttribute("category",category);
		req.setAttribute("details",details);
		req.setAttribute("title",title);
		req.setAttribute("shortdetails",shortdetails);
		req.setAttribute("empids",empid);
		RequestDispatcher rd=req.getRequestDispatcher("viewpastprojectclient.jsp?postingdate="+postingdate+"&category="+category+"&details="+details+"&title="+title+"&shortdetails="+shortdetails);
		rd.forward(req, res); 
	}
}
