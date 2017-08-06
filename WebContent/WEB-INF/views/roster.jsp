<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Team</title>
	<style>
		table {
			border-collapse: collapse;
			width: 100%;
		}
		
		td, th {
			border: 1px solid #dddddd;
			text-align: left;
			padding: 8px;
		}
		
		tr:nth-child(even) {
			background-color: #dddddd;
		}
	</style>
</head>
<body>
	<p>
		<a href="/TeamRoster/addplayer?id=${teamID}">New Player</a> | 
		<a href="/TeamRoster">Home</a>
	</p>
	<h1><c:out value="${team.getTeam_name()}"/></h1>
	<c:if test="${team.getNumberOfPlayers() > 0}">
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Action</th>
			</tr>
			<c:forEach var="i" begin="0" end="${team.getNumberOfPlayers()-1}" step="1">
				<tr>
					<td><c:out value="${team.getPlayers().get(i).getFirst_name()}"/></td>
					<td><c:out value="${team.getPlayers().get(i).getLast_name()}"/></td>
					<td><c:out value="${team.getPlayers().get(i).getAge()}"/></td>
					<td><a href="/TeamRoster/removeplayer?teamID=${teamID}&playerID=${i}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>