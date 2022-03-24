<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/estilo/estilo.css">
	<title>Cadastrar Jogador</title>
</head>
<body>
	<div>
		<ul class="a">
			<li><a href="<%=request.getContextPath()%>/jogador/cadastrar">Cadastrar Jogador</a></li>
			<li><a href="<%=request.getContextPath()%>/jogador/listar">Listares Jogador</a></li>
		</ul>
	</div>
	<div>
		<form action="../jogador/cadastrar" method="post">
			<label for="nome">Nome:</label><br> 
			<input type="text" id="nome" name="nome" placeholder="Nome"><br> 
				
			<label for="idade">Idade:</label><br>
			<input type="text" id="idade" name="idade" placeholder="Idade"><br>
			
			<label for="camisa">Camisa:</label><br>
			<input type="text" id="camisa" name="camisa" placeholder="Camisa"><br>
			
			<br> <input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>