<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todos</title>

<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css"
	rel="stylesheet">


</head>
<body>
	Hi ${kname},
	<br> Your TodoList
	<br>
	<div class="container">
	<table border="1" class="table table-stripped">
		<caption>Your Todos are</caption>
		<thead class="heading">
			<tr>
				<td>Description</td>
				<td>Target Date</td>
				<td>Is Completed?</td>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.desc}</td>
					<td>${todo.date}</td>
					<td>${todo.done}</td>
					<td><a class="btn btn-danger" href="/delete-todo?id=${todo.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
		<a class="btn btn-success" href="/add-todo">Add</a>
	</div>

	<div>

	
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>