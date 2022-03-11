package fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fuctura.dao.JogadorDAO;
import fuctura.model.Jogador;

public class TesteConexao {

	public static void main(String[] args) {

		try {
			//URL, USUARIO e SENHA
			Connection minhaConexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "fuctura", "123");
																		  //1, 2, 3	
			JogadorDAO dao = new JogadorDAO();
			
			String nome = "Denis Marques";
			int idade = 45;
			int camisa = 10;
			
			Jogador j1 = new Jogador();
			j1.setNome("Denis Marques");
			j1.setIdade(45);
			j1.setCamisa(10);
			
			dao.salvar(minhaConexao, j1);
			
			nome = "Cristiano Ronaldo";
			idade = 33;
			camisa = 10;

			Jogador j2 = new Jogador();
			j2.setNome(nome);
			j2.setIdade(idade);
			j2.setCamisa(camisa);
			
			dao.salvar(minhaConexao, j2);
		
			dao.obterTodos(minhaConexao);
			
		} catch (SQLException e) {
			System.out.println("Ocorreu um problema ao acessar o Banco de Dados");
			e.printStackTrace();
		}

	}

}
