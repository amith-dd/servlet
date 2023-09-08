<%@page import="studentdetails.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% List<Student> students =  (List)request.getAttribute("students"); %>
	
	<table border="2px">
	<tr>
	<th>id</th>
	<th>name</th>
	<th>dept</th>
	<th>contact</th>
	<th>city</th>
	<th>pass</th>
	<th>edit</th>
	<th>delete</th>
	</tr>
	
	<% for(Student student:students){ %>
	
	<tr>
	<td><%= student.getId() %></td>
	<td><%= student.getName() %></td>
	<td><%= student.getDept() %></td>
	<td><%= student.getContact() %></td>
	<td><%= student.getCity() %></td>
	<td><%= student.getPass() %></td>
	<td><a href="edit?id=<%= student.getId() %>">edit</a></td>
	<td><a href="delete?id=<%= student.getId() %>">delete</a></td>
	</tr>
	
	<% } %>
	</table>


</body>
</html>