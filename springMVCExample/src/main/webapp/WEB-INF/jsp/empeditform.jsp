<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/springMVCExample/editsave" method="post">
<table>
<tr>
<td>Name</td>
<td><input type="text" name="name" value="${command.name }"></td>
</tr>
<tr>
<td>Salary</td>
<td><input type="text" name="salary" value="${command.salary }"></td>
</tr>

<tr>
<td>Desg</td>
<td><input type="text" name="desg" value="${command.desg }">
<input type="hidden" name="id" value="${command.id }">
</td>
</tr>

<tr>

<td><input type="submit" name="action" value="update"></td>
</tr>

</table>
</form>
</body>
</html>