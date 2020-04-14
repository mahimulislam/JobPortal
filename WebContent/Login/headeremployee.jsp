<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String email = request.getParameter("email");
%>
<% request.setAttribute("email",email); %>
<head>
    <title>Online Job Portal </title>
    <link href="../style.css"rel="stylesheet" type="text/css" >
    <link href="../img/download.png" type="img/icon" rel="icon">
</head>
<body>
    <div id="full">
        <div id = "header">
            <div id= "logo">
                <h1 align="center"><font color="#33312a"> Online Job Portal</font></h1>
            </div>
        <div class="container">
	        <div class="center"id="nav">
                <ul >
                    <li><a href=<%= "\"findjob.jsp?email=" + email + "\"" %>>Search Jobs</a></li>
                    <li><a href=# >Inbox</a></li>
                    <li><a href=<%= "\"pastprojectsemployee?email=" + email + "\"" %>>View PastProjects</a></li>
                    <li><a href=<%= "\"profile?email=" + email + "\"" %>>View Profile</a></li>
					<li><a href="login.jsp">Sign Out</a></li>
                </ul>
            </div>
        </div>

</body>
</html>