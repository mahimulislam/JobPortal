package com.jobportal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.dao.ApplyJobDaoEmployee;

public class ApplyJobEmployee extends HttpServlet
{

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{

		String formcno=req.getParameter("clientno");
		String formjobno=req.getParameter("jobno");
		String formemail=req.getParameter("email");

		ApplyJobDaoEmployee dao=new ApplyJobDaoEmployee();		
		
		String id = dao.id();
		
		int iid=Integer.parseInt(id);
		iid=iid+1;
		id=String.valueOf(iid);
		
		System.out.println(id);
		System.out.println(formemail);
		
		String formeno = dao.empno(formemail);
		
		System.out.println(formeno);
		System.out.println("&UPSLO");
		
		if(dao.check(formcno,formeno,id,formjobno)){
			RequestDispatcher rd=req.getRequestDispatcher("findjob.jsp?email="+formemail);
			rd.forward(req, res);
		}
		else{
			PrintWriter out=res.getWriter();
			out.println("Apply UnSuccessful");
			//res.sendRedirect("loginunsuccessful.html");
		}	
	
	}
}
