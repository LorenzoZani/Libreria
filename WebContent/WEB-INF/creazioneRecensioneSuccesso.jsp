<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recensione Inserita</title>
</head>
<body>
	complimenti la tua recensione con valutazione :	${recensione.getValutazione()}, e testo: ${recensione.getTesto()} è
		stata aggiunta
	<a href="${pageContext.request.contextPath}/AutoreServlet">Torna agli autori
		</a>

</body>
</html>