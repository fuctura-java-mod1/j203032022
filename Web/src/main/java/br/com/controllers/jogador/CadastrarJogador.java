package br.com.controllers.jogador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.model.Jogador;

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
		String nome  = request.getParameter("nome");
		String idade = request.getParameter("idade");
				
		long id = ListarJogador.jogadores.size(); //pego o último elemento da lista
		
		//crio um novo objeto jogador
		Jogador novoJogador = new Jogador();
		novoJogador.setId(id);
		novoJogador.setNome(nome);
		novoJogador.setIdade(Long.valueOf(idade));
		
		//salvo o jogador na lista
		ListarJogador.jogadores.add(novoJogador);
		
		response.sendRedirect("./listar");
	}

}
