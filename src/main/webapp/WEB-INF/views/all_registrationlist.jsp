<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Registration</title>
<style>
	body{
		background-color: yellow;
		text-align:center;
	}
</style>
</head>
<body>
	<h1>All Registrations List...</h1>
	<table>
	<tr>
		<th>Name</th>
		<th>Course</th>
		<th>Email</th>
		<th>Mobile</th>
		<th>Delete</th>
		<th>Update</th>
	</tr>
		<%
			ResultSet result = (ResultSet)request.getAttribute("result");
			while(result.next()){
		%>
		<tr>
			<td><%=result.getString(1) %></td>
			<td><%=result.getString(2) %></td>
			<td><%=result.getString(3) %></td>
			<td><%=result.getString(4) %></td>
			<td><a href="deleteReg?emailId=<%=result.getString(3)%>">delete</a></td>
			<td><a href="updateReg?emailId=<%=result.getString(3)%>&mobile=<%=result.getString(4)%>">Update</a></td>			
		</tr>
		
		<%} %>
	</table>
</body>
</html>