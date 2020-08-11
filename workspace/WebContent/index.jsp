<jsp:useBean id="calcula" class="beans.BeansCursoJSP" type="beans.BeansCursoJSP" scope="page"/>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




<h1>Teste</h1>


<br>

<form action="receber-nome.jsp">
<input type="text" id="nome" name="nome">
<input type="submit" value="Enviar"/>

</form>

 <h5>Session</h5>
 <% session.setAttribute("aluno", "luciano freitas"); %>

<%@ include file="footer.jsp" %>

 <h5>Calculo com Java Beans</h5>
 
 <%= calcula.calcula(50) %>
 
  <h5>GET SET</h5>
 
  <form action="header.jsp" method="post">
  <% session.setAttribute("user", "Luciano"); %>
  
  	<input type="text" id="nome" name="nome" value="nome"><br/>
  	<input type="text" id="ano" name="ano" value="ano"><br/>
  	<input type="text" id="sexo" name="sexo" value="sexo"><br/>
  	<input type="submit" value="testar"/>
  
  
  </form>

  <a href="login.jsp">Acesso ao login</a>
 
 
 


</body>
</html>