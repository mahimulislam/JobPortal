<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ include file="headeremployee.jsp" %>

<%
String emails = request.getParameter("email");
String jobn=request.getParameter("jobno");

String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "jobportaldb";
String userId = "root";
String password = "Valoakash1234";
String clientno="";
String employeeno="";
try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
String empid="";
%>
</br>
</br>
<body style="background-color:powderblue;">

<h1 align="center"><font><strong>Job Details</strong></font></h1>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM JobDetails where jobNo = '"+jobn+"' ;";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
	clientno=resultSet.getString("cno");
%>
</br>
<h1>Title: <%=resultSet.getString("title") %></h1>
<h2>Job No: <%=resultSet.getString("jobNo") %></h2>
<h2>Posting Date: <%=resultSet.getString("postingdate") %></h2>
<h2>Category: <%=resultSet.getString("category") %></h2>
<h2>Client: <%=resultSet.getString("cno") %></h2>
<h2>Job Details: </h2><p></br><%=resultSet.getString("details") %></p>

<% 

}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
<html>
  <body>
  <h1>Apply on this job</h1>
    <form action="applyjob?email=<%=emails%>&jobno=<%=jobn%>&clientno=<%=clientno%>" method="POST">
    <input type="hidden" id="myField1" name="jobno" value="<%=jobn %>" />
    <input type="hidden" id="myField2" name="clientno" value="<%=clientno %>" />   	  
    <input type="submit" value="Submit" />
    </form>
</form>         
  </body>

</html>
