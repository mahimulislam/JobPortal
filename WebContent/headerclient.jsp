<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String emailsaa = request.getParameter("email");
%>
<% request.setAttribute("email",emailsaa); %>
<head>
    <title>Online Job Portal </title>
    <link href="style.css"rel="stylesheet" type="text/css" >
    <link href="img/download.png" type="img/icon" rel="icon">
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
                    <li><a href=<%="\"postnewjob.jsp?email=" + emailsaa + "\"" %>>Post New Job</a></li>
                    <li><a href="#">Inbox</a></li>
                    <li><a href=<%="\"profileclient?email=" + emailsaa + "\"" %>>View Profile</a></li>
                    <li><a href=<%="\"pastprojectsclient?email=" + emailsaa + "\"" %>>View Past Project</a></li>
                    <li><a href="index.jsp">Sign Out</a></li>	            
                </ul>
            </div>
        </div>

</body>
</html>