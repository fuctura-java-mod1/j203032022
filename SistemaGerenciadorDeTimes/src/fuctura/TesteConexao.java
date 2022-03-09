package fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteConexao {

	public static void main(String[] args) {

		try {
			//URL, USUARIO e SENHA
			Connection minhaConexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "fuctura", "123");
																		  //1, 2, 3	
			String sql = "insert into jogador(nome, idade, camisa) values (?, ?, ?)";
			
			PreparedStatement ps = minhaConexao.prepareStatement(sql);
		
			//usar o scanner pra capturar os dados digitados pelo o usuário
		
			ps.setString(1, "Messi");
			ps.setInt(2, 33);
			ps.setInt(3, 10);
			
			ps.execute();
			
			System.out.println("Resgistro Inserido Com Sucesso!");
		
		} catch (SQLException e) {
			System.out.println("Ocorreu um problema ao acessar o Banco de Dados");
			e.printStackTrace();
		}

	}

}
