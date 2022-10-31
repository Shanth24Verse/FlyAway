<%@page import="java.util.Date" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="fstyle.css">
</head>
<body>

<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost/simplilearn" user="root" password="1234" />

<center>
	<h1>FlyAway</h1>
	<h2>(An Airline booking Portal)</h2>
	<br><br>
	<a href = "login.jsp">Admin Login</a>
	<br><br><br>
<form action = "airlinelist.jsp">
	<table>
	<th>Date</th>
	<th>Source</th>
	<th>Destination</th>
	<th>No. of Persons</th>
	
	<tr><td>  <% Date datetime = new Date(); %>   <input type = "date" name = "datetime" required></td>
		
	<td>
	<sql:query dataSource="${db}" var="rs">
	select * from source_location;
	</sql:query>

	
		<form action="" >
  			<input list="Sources" name="Source" id="Source" required>
			<datalist id="Sources">
				<c:forEach var="data" items="${rs.rows}" >
					<option value="${data.Sname}"></option>
				</c:forEach>
			</datalist> 
	</td>
	
	<td>
	<sql:query dataSource="${db}" var="rds">
	select * from Destination_location;
	</sql:query>

	
		<form action="" >
  			<input list="Dests" name="Dest" id="Dest" required>
			<datalist id="Dests">
				<c:forEach var="data" items="${rds.rows}" >
					<option value="${data.Dname}"></option>
				</c:forEach>
			</datalist> 
	</td>
	
	<td><input type = "text" name = "person" required></td></tr>	
	</table>
	<br><br>
	
	<input type = "Submit" >
	</form> 
</center>

</body>
</html>