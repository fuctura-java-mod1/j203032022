package br.com.controllers.jogador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.model.Jogador;

/**
 * Servlet implementation class JogadorAtualizar
 */
@WebServlet("/jogador/alterar")
public class AlterarJogador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarJogador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		int posicaoNaLista = Integer.valueOf(id);
		
		Jogador jogadorSelecionado = ListarJogador.jogadores.get( posicaoNaLista );
		
		request.setAttribute("jogador", jogadorSelecionado);
		
		request.getRequestDispatcher("../pages/jogador/atualizar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String idade = request.getParameter("idade");
		
		int posicaoNaLista = Integer.valueOf(id);
		
		Jogador jogadorSelecionado = ListarJogador.jogadores.get( posicaoNaLista );
		
		jogadorSelecionado.setNome(nome);
		jogadorSelecionado.setIdade(Long.valueOf(idade));
		
		response.sendRedirect("./listar");
	}

}
