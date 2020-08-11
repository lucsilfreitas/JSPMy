<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testes JSP</title>
</head>
<body>

<% 

String nome = "Nome recebido: " + request.getParameter("nome");

out.print(nome); 

%>

<h5>Expressão</h5> <!--Outro modo com expressão-->

<%= "sucesso garantido.." %>

<%= "Nome recebido: " + request.getParameter("nome") %>

<h5>Expressão com contas</h5>

<%! int cont = 2; %>

<h5>Expressão com metodo</h5> 

<%! int cont1 = 2;

public int retorna(int n){
	return n*3;
}
%>

<%= cont1 %>

<%=retorna(8) %>

<br>



 <h5>Session</h5>
 <% session.getAttribute("aluno");%>
 
 

</body>
</html>