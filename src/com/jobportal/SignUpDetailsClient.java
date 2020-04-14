package com.jobportal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.dao.SignUpDaoClient;

public class SignUpDetailsClient extends HttpServlet
{

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		String formname=req.getParameter("name");

		String formdateofbirth=req.getParameter("dob");

		String formaddress=req.getParameter("address");


		String formemail=req.getParameter("email");

		String formpassword=req.getParameter("pass");
		
		String formmobile=req.getParameter("mobile");
		
		
		SignUpDaoClient dao=new SignUpDaoClient();		
		
		String id= dao.id();
		int iid=Integer.parseInt(id);
		iid=iid+1;
		id=String.valueOf(iid);
		if(dao.check(formname,formdateofbirth,formaddress,formemail,formpassword,formmobile,id)){
			res.sendRedirect("login.jsp");
			PrintWriter out=res.getWriter();
			out.println("Signup Successful");
		}
		else{
			PrintWriter out=res.getWriter();
			out.println("Signup UnSuccessful");
			//res.sendRedirect("loginunsuccessful.html");
		}	
	
	}
}
