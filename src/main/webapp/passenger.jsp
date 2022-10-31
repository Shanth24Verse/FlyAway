<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="fstyle.css">

<style>
input[type=text]{
  width: 40%;
background-color: #d9f7ca;
}
</style>

</head>
<body>

<center>
	<h1>Passenger Booking Registration</h1>
	<br>
<form action = "addPass" method = "post">
	First Name: <br><input type = "text" name = "fname" required><br><br>
	Last Name: <br><input type = "text" name = "lname" required><br><br>
	Mobile Number: <br><input type = "text" name = "mnum" required><br><br>
	
	<input type = "submit">
</form>
</center>

</body>
</html>