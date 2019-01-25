<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Libri</title>
</head>
<body>
	<h1>Lista Libri</h1>
	<ul>
		<c:forEach var="libro" items="${libri }">
			<li>
				<a href="${pageContext.request.contextPath}/LibroDettaglioServlet?id=${libro.getId()}">
					titolo: ${libro.getTitolo() }
					descrizione: ${libro.getDescrizione() }
				</a>
			</li>
		</c:forEach>
	</ul>

	<a href="${pageContext.request.contextPath}/LibroFormServlet">Nuovo
		Libro</a>
</body>
</html>