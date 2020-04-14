<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Client Login</title>
</head>
<body style="background-color:powderblue;">
<div id="banner">
            <div id="form">
             <form action="clientlogin" method="post">
            <label for="emails"> Client Email</label><br />
    <input type="text" id="Email" name="email" placeholder="Your Email.."><br />

    <label for="passwo">Password</label><br />
    <input type="password" id="Pass" name="pass" required placeholder="Your Password..">	<br/>
	<script>
	document.getElementById("Pass").style.width = "29%"; 
	document.getElementById("Pass").style.height = "25px"; 
	</script>
	<input type="checkbox" onclick="myFunction()">Show Password 
    <script>
function myFunction() {
  var x = document.getElementById("Pass");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>
    <label for="Submit"></label><br />
    <input type="submit" value="Submit"><br />
            </form>
          
        </div>
        </div>
</body>
</html>