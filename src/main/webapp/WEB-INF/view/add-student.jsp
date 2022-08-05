<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/student-management/urltostaticresource/css/mss.css">
<link rel="stylesheet" type="text/css" href="/student-management/urltostaticresource/css/background.css">
</head>
<body>
<h1 align="center">Add Student</h1>
<hr>
<div align="center">
<form:form action="save-process" modelAttribute="student" method="POST">
<form:hidden path="ID"/>
<label for="sname">Name:</label>
<form:input id="sname" path="name"/><br>
<label for="smobile">Mobile:</label>
<form:input id="smobile" path="mobile"/><br>
<label for="scountry">Country:</label>
<form:input id="scountry" path="country"/><br>
<input type="submit" value="submit" class="myButtons">
</form:form>
</div>
</body>
</html>