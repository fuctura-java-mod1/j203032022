package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.model.Jogador;

public class JogadorDAO {

	
	
	public ArrayList<Jogador> obterTodos(Connection minhaConexao) {
		
		System.out.println("Consultando no banco de dados");
		
		String comandoSQL = " select nome, idade, camisa from jogador";
		
		ArrayList<Jogador> jogadoresDaMinhaTabela = new ArrayList<Jogador>();
		
		try {
			PreparedStatement ps = minhaConexao.prepareStatement(comandoSQL);
			ResultSet resultadoDaConsulta =  ps.executeQuery();
			
			while( resultadoDaConsulta.next() ) {
				String nome = resultadoDaConsulta.getString("nome");
				long idade = resultadoDaConsulta.getLong("idade");
				int camisa = resultadoDaConsulta.getInt("camisa");
				
				Jogador j = new Jogador();
				
				j.setNome(nome);
				j.setIdade(idade);
				j.setCamisa(camisa);
				
				jogadoresDaMinhaTabela.add(j);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jogadoresDaMinhaTabela;
	}
	
	public void excluir() {
		
	}
	
}
