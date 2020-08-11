<jsp:useBean id="calcula" class="beans.BeansCursoJSP" type="beans.BeansCursoJSP" scope="page"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <jsp:setProperty property="*" name="calcula"/>
  <h1>Cabeçalho</h1>
  <jsp:getProperty property="nome" name="calcula"/><br/>
  <jsp:getProperty property="ano" name="calcula"/><br/>
  <jsp:getProperty property="sexo" name="calcula"/><br/>
  <br/>
  <h1>Outra forma</h1>
  Nome : ${param.nome}<br/>
  Ano : ${param.ano}<br/>
  Sexo : ${param.sexo}<br/>
  
  ${sessionScope.user}
