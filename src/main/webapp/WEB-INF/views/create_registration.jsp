<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<style>
	body{
		background-color: yellow;
		text-align:center;
	}
</style>
</head>
<body>
	<h1>Registration Here..</h1>
	<form action="saveRegistation" method="post">
		<pre>
			Name: <input type="text" name="name"/>
			Course: <input type="text" name="course"/>
			Email: <input type="text" name="email"/>
			Mobile: <input type="text" name="mobile"/>
			 <input type="submit" value="save"/>
		</pre>
	</form>
	
	<%
		if(request.getAttribute("msg")!=null){
			out.println(request.getAttribute("msg"));
		}
	%>
	
	
</body>
</html>