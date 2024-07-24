<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	Welcome ${kname} 
	View Your Todo List. -> <a href="/list-todos?name=${kname}">Your List</a>
	<form action="/list-todos.do" method="get">
		<input type="submit" value="Show Todos"/>
	</form>
</body>
</html>