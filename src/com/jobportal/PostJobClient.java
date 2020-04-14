package com.jobportal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.dao.PostJobDaoClient;

public class PostJobClient extends HttpServlet
{

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		String formpostingdate=req.getParameter("postingdate");

		String formcategory=req.getParameter("category");

		String formdetails=req.getParameter("details");

		String formtitle=req.getParameter("title");

		String formshortdet=req.getParameter("shortdet");

		String formclientno=req.getParameter("clientno");
		
		String formemail=req.getParameter("eqmail");
		System.out.println(formemail);
		PostJobDaoClient dao=new PostJobDaoClient();		
		
		String id= dao.id();
		int iid=Integer.parseInt(id);
		iid=iid+1;
		id=String.valueOf(iid);
		if(dao.check(formpostingdate,formcategory,formdetails,formtitle,formshortdet,formclientno,id)){
			RequestDispatcher rd=req.getRequestDispatcher("loggedinclient.jsp?email="+formemail);
			
			rd.forward(req, res);
		}
		else{
			PrintWriter out=res.getWriter();
			out.println("Signup UnSuccessful");
			//res.sendRedirect("loginunsuccessful.html");
		}	
	
	}
}
