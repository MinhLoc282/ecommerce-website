<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="../assets/css/style.css" >

<title>Admin Login</title>
</head>
<body>
	<div align="center">
		<h1>Ecommerce Website Administration</h1>
		<h2>Admin Login</h2>
		
		<c:if test="${message != null}">
			<div align="center">
				<h4>${message}</h4>
			</div>
		</c:if>
		
		<form action="login" method="post">
			<table style="border: 0">
				<tr>
					<td>Email:</td>
					<td><input type="email" name="email" size="20" required="required" minlength="6" maxlength="30"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" size="20" required="required" minlength="5" maxlength="30"></td>
				</tr>		
				<tr>
					<td colspan="2" align="center">
						<button type="submit">Login</button>
					</td>
				</tr>		
			</table>
		</form>
	</div>
</body>
</html>