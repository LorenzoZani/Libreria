<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${libro.getTitolo() }</h1>
	<h3>${libro.getDescrizione() }</h3>

	<a
		href="${pageContext.request.contextPath}/LibroDeleteServlet?id=${id}">Cancella</a>
	<a href="#">Modifica</a>

</body>
</html>