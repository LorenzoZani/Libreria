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
	<h1>Lista degli autori</h1>
	<ul>

		<c:forEach items="${autori }" var="autore">
			<li><a
				href="${pageContext.request.contextPath}/AutoreDettaglioServlet?id=${autore.getId()}">
					${autore.getNome() } ${autore.getCognome()}
				</a>
			</li>
		</c:forEach>
	</ul>

	<a href="${pageContext.request.contextPath}/AutoreFormServlet">Nuovo
		Autore</a>
	<a href="${pageContext.request.contextPath}/LibroServlet">Lista dei libri</a>
	
	<a href="${pageContext.request.contextPath}/DownloadAutoriServlet">Download csv</a>


</body>
</html>
