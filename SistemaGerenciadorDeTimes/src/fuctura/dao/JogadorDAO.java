package fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
	public void excluir() {
		
	}
	
}
