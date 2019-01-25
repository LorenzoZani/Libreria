<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>creazione libro errore</title>
</head>
<body>
	<h1>Il tuo libro esiste già </h1>
	<br>
	<a href="${pageContext.request.contextPath}/AutoreServlet">Torna
		alla lista degli autori</a>
	<br>
	<a href="${pageContext.request.contextPath}/LibroFormServlet">Crea
		un nuovo libro</a>
</body>
</html>