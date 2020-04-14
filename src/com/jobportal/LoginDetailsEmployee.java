package com.jobportal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.dao.LoginDaoEmployee;

public class LoginDetailsEmployee extends HttpServlet
{

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		String formemailw=req.getParameter("email");
		String formpass=req.getParameter("pass");
		LoginDaoEmployee dao=new LoginDaoEmployee();
		
		if(dao.check(formemailw, formpass)){
			PrintWriter out=res.getWriter();
			out.println("Login Successful");
			RequestDispatcher rd=req.getRequestDispatcher("loggedinemployee.jsp?email="+formemailw);
			req.setAttribute("formemail", formemailw);
			rd.forward(req, res);
					}
		else{
			PrintWriter out=res.getWriter();
			res.sendRedirect("loginunsuccessful.jsp");
		}		
	
	}
}
