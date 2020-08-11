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

  <h5>JTSL</h5>
  
  <c:out value="${'bem vindo ao JSTL'}"/><br/>
  
  	 <c:set var="numero" value="${100/2}"/>
  	 
  	 <c:forEach var="n" begin="1" end="${numero}">
  	 	Item: ${n}
  	 	<br>
  	 </c:forEach>
  	 

  
  


</body>
</html>