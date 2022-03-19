package br.com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JPAUtil {

	private static Connection conexao;

	public static Connection getInstancia() throws ClassNotFoundException {
		if (conexao == null) {
			try {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "fuctura", "123");
				System.out.println("Abriu a conexao");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conexao;
	}

	/*
	 * private static EntityManagerFactory emf;
	 * 
	 * static { emf = Persistence.createEntityManagerFactory("Fuctura-PU"); }
	 * 
	 * public static EntityManagerFactory getInstancia() { if( emf == null ) { emf =
	 * Persistence.createEntityManagerFactory("Fuctura-PU"); } return emf; }
	 */
}
