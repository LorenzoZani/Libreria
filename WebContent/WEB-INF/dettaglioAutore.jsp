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
	<h1>${autore.getNome() }  ${autore.getCognome() }</h1>

	<ul>

		<c:forEach items="${libri }" var="libro">
			<li><a href="${pageContext.request.contextPath}/LibroDettaglioServlet?id=${libro.getId()}">
					titolo: ${libro.getTitolo() }    descrizione: ${libro.getDescrizione() }
				</a></li>
		</c:forEach>
	</ul>


	<a
		href="${pageContext.request.contextPath}/AutoreDeleteServlet?id=${id}">Cancella</a>
	<a
		href="${pageContext.request.contextPath}/AutoreUpdateServlet?id=${id}">Modifica</a>



</body>
</html>