<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="br.com.model.Jogador"%>

<%
	System.out.println("Criando o HTML que irá listar os jogadores");
	List<Jogador> resultadoDaConsulta = (List<Jogador>) request.getAttribute("jogadores");
	
	if(resultadoDaConsulta == null){
		resultadoDaConsulta = new ArrayList<>();
	}
%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/estilo/estilo.css">
</head>
<body>
	
	<div>
		<ul class="a">
			<li><a href="<%=request.getContextPath()%>/jogador/cadastrar">Cadastrar Jogador</a></li>
			<li><a href="<%=request.getContextPath()%>/jogador/listar">Listares Jogador</a></li>
		</ul>
	</div>
	
	<div>
		<h2>Jogadores Cadastrados</h2>
	
		<table>
			<tr>
				<th>Nome</th>
				<th>Idade</th>
				<th>Foto</th>
				<th>Editar</th>
				<th>Excluir</th>
			</tr>
	
			<% 
			int id = 0;
			for(Jogador jogador : resultadoDaConsulta){ %>
				<tr>
					<td><%=jogador.getNome()%></td>
					<td><%=jogador.getIdade()%></td>
					<td><img src="<%=request.getContextPath()%>/images/<%=jogador.getNomeDaImagem()%>"/></td>
					<td><a href="./alterar?id=<%=id%>"><img src="<%=request.getContextPath()%>/images/editar.png"/></a></td>
					<td><a href="./excluir?id=<%=id%>"><img src="<%=request.getContextPath()%>/images/delete.png"/></a></td>
				</tr>
			<%
				id++;
			} %>	
		</table>
	</div>
</body>
</html>