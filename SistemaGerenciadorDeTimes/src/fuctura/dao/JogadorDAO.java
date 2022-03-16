package fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fuctura.model.Jogador;

public class JogadorDAO {

	//salvar
	public void salvar(Connection minhaConexao, Jogador jogador) {
		
		String sql = "insert into jogador(nome, idade, camisa) values (?, ?, ?)";
		
		PreparedStatement ps;
		
		try {
			
			ps = minhaConexao.prepareStatement(sql);
			ps.setString(1, jogador.getNome());
			ps.setInt(2, jogador.getIdade());
			ps.setInt(3, jogador.getCamisa());
			
			ps.execute();
			
		} catch (SQLException e) {
			System.out.println("Deu erro quando foi salvar");
			e.printStackTrace();
		}
		
		System.out.println("Resgistro Inserido Com Sucesso!");
		
	}
	//excluir
	//atualizar
	//recuperar
	
	public ArrayList<Jogador> obterTodos(Connection minhaConexao) {
		
		System.out.println("Consultando no banco de dados");
		
		String comandoSQL = " select nome, idade, camisa from jogador";
		
		ArrayList<Jogador> jogadoresDaMinhaTabela = new ArrayList<Jogador>();
		
		try {
			PreparedStatement ps = minhaConexao.prepareStatement(comandoSQL);
			ResultSet resultadoDaConsulta =  ps.executeQuery();
			
			while( resultadoDaConsulta.next() ) {
				String nome = resultadoDaConsulta.getString("nome");
				int idade = resultadoDaConsulta.getInt("idade");
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
	
	public void excluir(Connection conexao, Jogador jogadorQueEuQueroExcluir) {
															  //1
		String comandoSQL = "delete from jogador where codigo = ?";
		
		int chavePrimaria = jogadorQueEuQueroExcluir.getCodigo();
		
		try {
			
			PreparedStatement ps = conexao.prepareStatement(comandoSQL);
			
			ps.setInt(1, chavePrimaria);
			
			ps.execute();			
			
		} catch (SQLException e) {
			System.out.println("Não foi possível excluir o jogador");
			e.printStackTrace();
		}
		
	}
	
	public void atualizar(Connection conexao, Jogador jogadorQueEuQueroAtualizar) {
		try {
														//1          //2          //3    //4       
			String comandoSQL = "UPDATE jogador SET nome = ?, idade = ?, camisa = ? where codigo = ?;";
			
			PreparedStatement ps = conexao.prepareStatement(comandoSQL);

			ps.setString(1, jogadorQueEuQueroAtualizar.getNome());
			
			ps.setInt(2, jogadorQueEuQueroAtualizar.getIdade());
			
			ps.setInt(3, jogadorQueEuQueroAtualizar.getCamisa());
			
			ps.setInt(4, jogadorQueEuQueroAtualizar.getCodigo());
			
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
