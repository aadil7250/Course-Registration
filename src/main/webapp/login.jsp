<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
	body{
		background-color: yellow;
		text-align:center;
	}
</style>
</head>
<body>
	<h1>Login Here..</h1>
	<form action="verfiylogin" method="post">
		Email: <input type="text" name="email"/>
		Password: <input type="password" name="password"/>
			<input type="submit" value="Login"/>
	</form>
	<%
		if(request.getAttribute("errorMsg")!=null){
			out.println(request.getAttribute("errorMsg"));
		}
	%>
</body>
</html>