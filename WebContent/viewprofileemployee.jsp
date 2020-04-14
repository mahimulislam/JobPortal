<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="headeremployee.jsp" %>
<%

String eemail = request.getParameter("email");
String ename = request.getParameter("ename");
String edob = request.getParameter("edob");
String eaddress = request.getParameter("eaddress");
String emobile = request.getParameter("emobile");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<div class="card">
  <img src="file/<%=eemail%>profilepic.jpg" alt="ProfilePicture" style="width:100%">
  <h1><%=ename%></h1>
  <p>Date Of Birth: <%=edob%></p>
  <p>Address: <%=eaddress%></p>
  <p>Email: <%=eemail%></p>
  <p>Mobile No: <%=emobile%></p>
 
</div>
  <head>
    <title>Update Your Details</title>
  </head>
  <body style="background-color:powderblue;">
  </body>
</html>
<html>

    <form action="profileupdate" method="POST">
      <h1>Update Your Details</h1>
      <label for="name">Name</label><br />
    <input type="text" id="fname" name="name" placeholder="Your name.."><br />

    <label for="dobs">Date Of Birth</label><br />
    <input type="text" id="Date Of Birth" name="dob" placeholder="Your Date Of Birth..(dd/mm/yy)"><br />

	<label for="adds">Address</label><br />
    <input type="text" id="Address" name="address" placeholder="Your Address.."><br />

    <label for="mobilenums">Mobile Number</label><br />
    <input type="text" id="Mobile" name="mobile" placeholder="Your Mobile Number.."><br />  
 	  <input type="hidden" id="myField" name="eqmail" value="<%=eemail %>" />
 	  
      <input type="submit" value="Submit" />
    </form>
 <h1>Change Your DP!</h1>
 <form action="FileUploadHandler?email=<%=eemail%>&name=<%=ename%>&dob=<%=edob%>&address=<%=eaddress%>&mobile=<%=emobile%>" enctype="multipart/form-data" method="post">
Select<input type="file" name="file2" /><br>
 <input type="submit" value="upload" />
 </form> 
 <%
 String file_name=(String)request.getParameter("filename");
 if(file_name!=null){
 out.println(file_name+" File uploaded successfuly");
 }
 %>
 
 <h1>UpdateYourCV</h1>
 <form action="ApplyJobHandler?email=<%=eemail%>&name=<%=ename%>&dob=<%=edob%>&address=<%=eaddress%>&mobile=<%=emobile%>" enctype="multipart/form-data" method="post">
Select<input type="file" name="file2" /><br>
 <input type="submit" value="upload" />
 </form> 

  </body>
</html>