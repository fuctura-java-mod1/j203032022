package fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import fuctura.dao.JogadorDAO;
import fuctura.model.Jogador;

public class TesteAtualizacao {

	public static void main(String[] args) {

		try {
			Connection minhaConexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "fuctura",
					"123");
			JogadorDAO dao = new JogadorDAO();

			ArrayList<Jogador> todos = dao.obterTodos(minhaConexao);

			for (Jogador jogador : todos) {
				System.out.println("Codigo: " + jogador.getCodigo());
				System.out.println("Nome: " + jogador.getNome());
			}

			System.out.println("Digite o código do jogador escolhido: ");

			int codigoDoJogadorSelecionado = 1;// recuperar com scanner

			Jogador jogadorSelecionado = new Jogador();
			
			dao.atualizar(minhaConexao, jogadorSelecionado);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
