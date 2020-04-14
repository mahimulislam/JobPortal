package com.jobportal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.dao.LoginDaoEmployee;

public class IndexHandling extends HttpServlet
{

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		String loginselected="";
		loginselected=req.getParameter("loginbtn");
		String signupselected="";
		signupselected=req.getParameter("signupbtn");
		if(loginselected!=null)
		{
			res.sendRedirect("loginemployee.html");
			
		}
	
		else if(signupselected!=null)
		{res.sendRedirect("signupemployee.html");
		
		}
	}
}
