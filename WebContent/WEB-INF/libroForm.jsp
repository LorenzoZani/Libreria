<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuovo Libro</title>
</head>
<body>
	<h1>Inserimento nuovo libro</h1>
	<form action="${pageContext.request.contextPath}/LibroFormServlet"
		method="POST">
		<p>Titolo</p>
		<input type="text" name="titolo"> <br>
		<p>Descrizione</p>
		<input type="text" name="descrizione"> <br>
		<p>Autore</p>
		<select name="autoreId">
			<c:forEach items="${autori}" var="autore">
				<option value="${autore.getId()}">${autore.getNome()}   ${autore.getCognome()}</option>
			</c:forEach>
		</select> <input type="submit"
			value="crea">
	</form>
</body>
</html>