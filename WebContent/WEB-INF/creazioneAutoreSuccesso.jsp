<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>Complimenti, il tuo autore  ${autore.getNome()} ${autore.getCognome()} è stato inserito con successo!</h1>
  
  <div><a href="${pageContext.request.contextPath}/AutoreServlet">Torna Alla Lista</a></div>
  
  <div><a href="${pageContext.request.contextPath}/AutoreFormServlet">Inserisci Un Nuovo Autore</a></div>
  
</body>
</html>