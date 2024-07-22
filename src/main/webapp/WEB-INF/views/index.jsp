<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Store</title>
</head>
<body>

    <a href="addProduct.html">Add new product</a>

    <form action="#" th:action="@{/redirectToAddProd}">
        <input type="submit" value="Submit"/>
    </form>

</body>
</html>