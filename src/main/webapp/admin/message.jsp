<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="../assets/css/style.css">

<title>Ecommerce Website Administration</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<div align="center">
		<h3>${message}</h3>
		<a href="javascript:history.go(-1);">Go Back</a>
	</div>
	
	<div align="center">
        <h3>${requestScope.message}</h3>
    </div>
	
</body>
</html>