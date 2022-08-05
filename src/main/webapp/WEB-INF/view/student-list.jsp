<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/student-management/urltostaticresource/css/mss.css">
<link rel="stylesheet" type="text/css" href="/student-management/urltostaticresource/css/background.css">
</head>
<body>
<h1 align="center">All Students Information</h1>
<hr>
<hr>
<div align="center">
<form action="add-student">
<input type="submit" value="ADD" class="myButtons">
</form>
<table border="1">
<thead>
<tr>
<th>Student_id</th>
<th>Name</th>
<th>Mobile</th>
<th>Country</th>
<th>Update</th>
<th>Delete</th>
</tr>
</thead>
<c:forEach var="student" items="${students}" >
<tr>
<td>${student.ID}</td>
<td>${student.name}</td>
<td>${student.mobile}</td>
<td>${student.country}</td>
<td><a href="/student-management/updateStudent?UserID=${student.ID}">Update</a></td>
<td><a href="/student-management/deleteStudent?UserID=${student.ID}" onclick="if(!(confirm('Are you sure to delete this record!'))) return false">Delete</a></td>
</tr>
</c:forEach>
</table>
<img alt="sp" src="/student-management/urltostaticresource/images/student1.png" width="490" height="300" style="vertical-align:middle">
</div>
</body>
</html>