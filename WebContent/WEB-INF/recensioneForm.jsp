<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuova Recensione</title>
</head>
<body>
	<h1>Aggiungi recensione</h1>

	<form
		action="${pageContext.request.contextPath}/FormRecensioneServlet?id=${id}"
		method="POST">
		Valutazione:<select name="valutazione" >
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
			<option>5</option>
		</select> 
		Recensione:<input type="text" name="testo" /> 
		<input type="submit"
			value="invia" />
			<input type="hidden" name="id" value="${id }" />

	</form>

</body>
</html>