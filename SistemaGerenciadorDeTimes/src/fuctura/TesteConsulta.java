package fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import fuctura.dao.JogadorDAO;
import fuctura.model.Jogador;

public class TesteConsulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// URL, USUARIO e SENHA
		Connection minhaConexao;
		try {
			minhaConexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "fuctura", "123");
			JogadorDAO dao = new JogadorDAO();
			ArrayList<Jogador> jogadoresDaMinhaTabela = dao.obterTodos(minhaConexao);
			
			for (Jogador jogador : jogadoresDaMinhaTabela) {
				System.out.println("Nome: " + jogador.getNome());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
