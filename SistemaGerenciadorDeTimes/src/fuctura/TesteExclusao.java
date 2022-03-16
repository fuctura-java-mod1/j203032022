package fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import fuctura.dao.JogadorDAO;
import fuctura.model.Jogador;

public class TesteExclusao {
	public static void main(String[] args) {
		
		//URL, USUARIO e SENHA
		try {
			Connection minhaConexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "fuctura", "123");
			JogadorDAO dao = new JogadorDAO();
			
			
			ArrayList<Jogador> todos =	dao.obterTodos(minhaConexao);
			
			for( Jogador jogador : todos) {
				System.out.println("Codigo: " + jogador.getCodigo());
				System.out.println("Nome: " + jogador.getNome());
			}
			
			System.out.println("Digite o código do jogador escolhido: ");
			
			int codigoDoJogadorSelecionado = 1;//recuperar com scanner
			
			Jogador excluir = new Jogador();
			excluir.setCodigo(codigoDoJogadorSelecionado);
			
			dao.excluir(minhaConexao, excluir);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
