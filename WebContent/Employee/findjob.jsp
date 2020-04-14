<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ include file="headeremployee.jsp" %>

<%
String emails = request.getParameter("email");
System.out.println(emails);


String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "jobportaldb";
String userId = "root";
String password = "Valoakash1234";

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
<body style="background-color:powderblue;">

<h1 align="center"><font><strong>Jobs Posted</strong></font></h1>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM JobDetails where status = 'Active' ;";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<h1> <a href="specificjob.jsp?email=<%=emails%>&jobno=<%=resultSet.getString("jobno") %>"><%=resultSet.getString("title") %></a> </h1>
<p>Job Category: <%=resultSet.getString("category") %></p>
<p>Short Details: <%=resultSet.getString("shortdetails")%></p>
<p>Posting Date: <%=resultSet.getString("postingdate") %></p>
<p>Client No: <%=resultSet.getString("cno") %></p>
<% }
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>