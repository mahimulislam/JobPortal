<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <div class="container2">
  <form action="signupemployee" method="POST">
  <h1> Employee Details</h1>
    <body style="background-color:powderblue;">
    
    <label for="name">Employee Name</label><br />
    <input type="text" id="fname" name="name" placeholder="Your name.."><br />

    <label for="dobs">Date Of Birth</label><br />
    <input type="text" id="Date Of Birth" name="dob" placeholder="Your Date Of Birth..(dd/mm/yy)"><br />

	<label for="adds">Address</label><br />
    <input type="text" id="Address" name="address" placeholder="Your Address.."><br />

    <label for="mobilenums">Mobile Number</label><br />
    <input type="text" id="Mobile" name="mobile" placeholder="Your Mobile Number.."><br />

	<label for="emails">Employee Email</label><br />
    <input type="text" id="Email" name="email" placeholder="Your Email.."><br />

    <label for="passwo">Password</label><br />
    <input type="password" id="Pass" name="pass" minlength="8" required placeholder="Your Password..">	<br/>
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
    
  </body>
</html>