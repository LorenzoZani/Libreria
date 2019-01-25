<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${libro.getTitolo() }</h1>
	<h3>${libro.getDescrizione() }</h3>
	
	
	
	<ul>

		<c:forEach items="${recensioni }" var="recensione">
			<li>
			<h3>Valutazione: ${recensione.getValutazione() }</h3>
			<h3>Recensione: ${recensione.getTesto() }</h3>
			<a href="${pageContext.request.contextPath}/RecensioneDeleteServlet?recensione_id=${recensione.getId()}">Cancella recensione</a>
			</li>
		</c:forEach>
	</ul>
	
	
	
	<a href="${pageContext.request.contextPath}/FormRecensioneServlet?id=${id}">Aggiungi recensione</a>
	<a
		href="${pageContext.request.contextPath}/LibroDeleteServlet?id=${libro.getId()}">Cancella Libro</a>
	
	<a href="#">Modifica</a>

</body>
</html>