<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>Salary</th>
<th>Desg</th>
</tr>
<c:forEach var="list" items="${list }">
<tr>
<td>${list.id }</td>
<td>${list.name }</td>
<td>${list.salary }</td>
<td>${list.desg }</td>
<td ><a href="editemp/${list.id }">Edit</a></td>
<td><a href="deleteemp/${list.id }">Delete</a></td>

</tr>

</c:forEach>

</table>

</body>
</html>