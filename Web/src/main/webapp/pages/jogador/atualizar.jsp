<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.com.model.Jogador"%>

<%
	Jogador jogador = (Jogador) request.getAttribute("jogador");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/estilo/estilo.css">
	<title>Atualizar Jogador</title>
</head>
<body>
	<div>
		<ul class="a">
			<li><a href="<%=request.getContextPath()%>/jogador/cadastrar">Cadastrar Jogador</a></li>
			<li><a href="<%=request.getContextPath()%>/jogador/listar">Listares Jogador</a></li>
		</ul>
	</div>
	<div>
		<form action="../jogador/alterar" method="post" >
			<input type="hidden" id="id" name="id" value="<%=jogador.getId()%>"><br> 
			<label for="nome">Nome:</label><br> 
			<input type="text" id="nome" name="nome" placeholder="Nome" value="<%=jogador.getNome()%>"><br> 
			
			<label for="idade">Idade:</label><br> 
			<input type="text" id="idade" name="idade" placeholder="Idade" value="<%=jogador.getIdade()%>" ><br>
	
			<br> 
			<input type="submit" value="Submit">
		</form>
	</div>
	
</body>
</html>