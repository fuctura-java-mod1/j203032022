package br.com.controllers.jogador;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.model.Jogador;
import br.com.util.JPAUtil;

/**
 * Servlet implementation class JogadorCadastrar
 */
@WebServlet("/jogador/cadastrar")
public class CadastrarJogador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarJogador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("../pages/jogador/cadastrar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recebi os dados digitados na página
		//Os dados chegam sempre como String
		String nome  = request.getParameter("nome");
		String idade = request.getParameter("idade");
		String camisa = request.getParameter("camisa");
				
		System.out.println("Nome do jogador: " + nome);
		System.out.println("Idade do jogador: " + idade);
		System.out.println("Camisa do jogador: " + camisa);

		
		//crio um novo objeto jogador
		Jogador novoJogador = new Jogador();
		
		//salvar o jogador no banco de dados
		//EntityManagerFactory fabrica = JPAUtil.getEntityManagerFactory();
		
		response.sendRedirect("./listar");
	}
}
