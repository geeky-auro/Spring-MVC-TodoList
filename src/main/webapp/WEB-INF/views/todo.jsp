<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a Todo</title>
<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>Add a TODO</h1>
		<form:form method="post" commandName="todo">
			<form:hidden path="id"/>
			
			<fieldset class="form-group" >
				<form:label path="desc">Add Description:</form:label> <form:input type="text" path="desc"
					class="form-control" required="required" />
				<form:errors path="desc" cssClass="text-warning" />
			</fieldset>
			<br> <input type="submit" value="Submit"
				class="btn btn-success">
		</form:form>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>