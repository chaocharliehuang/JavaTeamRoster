<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:out value="${teamName}"/>: New Player</title>
</head>
<body>
	<h1>Add a player to team <c:out value="${teamName}"/></h1>
	<form action="/TeamRoster/addplayer" method="POST">
		<input type="hidden" name="teamID" value="${teamID}">
		First Name: <input type="text" name="firstName">
		<br><br>
		Last Name: <input type="text" name="lastName">
		<br><br>
		Age: <input type="number" name="age" min="18" max="120">
		<br><br>
		<input type="submit" value="Add">
	</form>
</body>
</html>