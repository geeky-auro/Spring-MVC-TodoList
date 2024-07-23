<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Yahoo from JSP</title>
</head>
<body>
	<form action="/login.do" method="post">
	Name :<input type="text" name="kname"/>
	Password: <input type="password" name="pwd" />
	<input type="submit" value="Submit Query" />
		<p><font color="red">${errorMessage}</font></p>
	</form>
</body>
</html>