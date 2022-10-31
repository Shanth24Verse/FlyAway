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
<h1>Airline List</h1>

<h2><%String s;
		s=request.getParameter("Source");
		out.println(s);%>
		
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
	<%String d;
		d=request.getParameter("Dest");
		out.println(d);%></h2>
	<br>
	<h2><%=request.getParameter("datetime")%></h2>
	<br>


<%-- The above can be printed using JSTL with below coding

<c:out value="${param.Source}" />
<c:out value="${param.Dest}" />  --%>

<sql:query dataSource="${db}" var="rda">
	select * from airline_list;
	</sql:query>

	
	
		<table> 
 				<c:forEach var="data" items="${rda.rows}" >
 				
 				<tr> 
 					<td>
						<p><c:out value="${data.Aname}"/></p>
					</td>
					
					
					<td>
					<sql:query dataSource="${db}" var="rsourc">
						select Sid from source_location where Sname = ?;
						<sql:param value="${param.Source}" />
					</sql:query>
					
					<sql:query dataSource="${db}" var="rdest">
						select Did from destination_location where Dname = ?;
						<sql:param value="${param.Dest}" />
					</sql:query>
					
					<c:forEach var="data" items="${rsourc.rows}" >
						<%-- <p><c:out value="${data.Sid}"/></p> --%>
						<c:set var="SV" value="${data.Sid}"/> 
					</c:forEach>
					
					<c:forEach var="data" items="${rdest.rows}" >
						<%-- p><c:out value="${data.Did}"/></p> --%>
						<c:set var="DV" value="${data.Did}"/>						
					</c:forEach>
					
					<c:set var="dif" value="${SV-DV}"/> 
					<%-- <c:out value ="${Math.abs(dif)}"/>  --%>
					<c:set var="difpos" value="${Math.abs(dif)}"/> 
					<%-- <c:out value="${difpos}"/> --%>
					
<%-- 					<%String ph =(String)pageContext.getAttribute("${difpos}"); 
					out.println(ph);%>
			
					<% int tp = 10000,i;%>
					<%for ( i = 1; i <= 3; i++){ %>
         				<%tp=tp+2000; %>
      				<%}%>
					<%out.println(tp);
					tp = 10000;%> --%>
					
					
					<c:set var="tp" value="10000"/>
					<c:if test="${tp > 0}">
						<c:out value="${tp + (difpos*2000)}"/>
					</c:if>
					
					</td>
					
					<td><a href = "passenger.jsp">Select</a>
					</td>
				</tr>
			
				</c:forEach>
		</table>

</center>

</body>
</html>