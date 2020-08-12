<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acesso</title>
</head>
<body>

  <h5>Login</h5>
 
 
 <form action="LoginServlet" method="post">
	Login:
	<input type="text" id="login" name="login"><br/>
	
	Senha:
	<input type="text" id="senha" name="senha"><br/>
	<input type="submit" value="Enviar"/>

</form>

  


</body>
</html>