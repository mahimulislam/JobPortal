<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="headeremployee.jsp" %>
<%
String emailss = request.getParameter("cemail");
String ename = request.getParameter("postingdate");
String edob = request.getParameter("category");
String eaddress = request.getParameter("details");
String emobile = request.getParameter("title");
String shortdet = request.getParameter("shortdetails");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <title>Update Your Details</title>
  </head>
  <body style="background-color:powderblue;">
  <h1 align="center"><font><strong>Your Past Projects</strong></font></h1>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>
</tr>
<tr bgcolor="#A52A2A">
<td><b>Posting Date</b></td>
<td><b>Category</b></td>
<td><b>Details</b></td>
<td><b>Title</b></td>
<td><b>Shortdetails</b></td>
</tr>

<tr bgcolor="#DEB887">
<td><b><%=ename%></b></td>
<td><b><%=edob%></b></td>
<td><b><%=eaddress%></b></td>
<td><b><%=emobile%></b></td>
<td><b><%=shortdet%></b></td>
</tr>
</html>
