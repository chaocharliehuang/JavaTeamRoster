<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Roster</title>
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
	<p><a href="/TeamRoster/newteam">New Team</a></p>
	<h1>Prototype Roster</h1>
	<c:if test="${teams.size() > 0}">
		<table>
			<tr>
				<th>Team</th>
				<th>Players</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="i" begin="0" end="${teams.size()-1}" step="1">
				<tr>
					<td>${teams.get(i).getTeam_name()}</td>
					<td>${teams.get(i).getNumberOfPlayers()}</td>
					<td>
						<a href="/TeamRoster/teams?id=${i}">Details</a> | 
						<a href="/TeamRoster/removeteam?id=${i}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>