<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="headerclient.jsp" %>
<%
String emailss = request.getParameter("email");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
</br>
     </br> 
     
    <form action="postjob" method="POST">
      <h1>Post New Job</h1>>
     </br>
     </br> 
      <p>Posting Date</p><br/>
      <input type="text" id="postingdate" name="postingdate" />
 	  <p>Category</p><br/>
 	  <input type="text" id="category" name="category" />
 	  <p>Details</p><br/>
 	  <input type="text" id="details" name="details" />
 	  <p>Title</p><br/>
 	  <input type="text" id="title" name="title" />
 	   <p>Short Details</p><br/>
 	  <input type="text" id="shortdetail" name="shortdet" />
	  <p>Client No</p><br/>
 	  <input type="text" id="clientno" name="clientno" /> 	 
 	  <input type="hidden" id="myField" name="eqmail" value="<%=emailss %>" />
      <input type="submit" value="Submit" />
    </form>
  </body>
</html>