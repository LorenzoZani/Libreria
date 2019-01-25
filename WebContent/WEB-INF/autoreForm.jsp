<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuovo Autore</title>
</head>
<body>
<h1>Inserimento nuovo Autore</h1>
	<form action="${pageContext.request.contextPath}/AutoreFormServlet"
		method="POST">
		Nome:<input type="text" name="nome" /> Cognome:<input type="text"
			name="cognome" /> <input type="submit" value="invia" />
	</form>

</body>
</html>