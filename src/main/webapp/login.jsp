<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<% String name = (String)request.getAttribute("name"); %>
	
	<% if(name!=null){ %>
	<h1> hello <%= name %></h1>
	<% } %>
	
	
	
	<form action="login" method="post">
	name:<input type="text" name="name"><br>
	password:<input type="password" name="pass"><br>
	SUBMIT:<input type="submit">
	
	</form>
	
	
</body>
</html>