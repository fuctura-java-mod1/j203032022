package br.com.controllers.jogador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.model.Jogador;

/**
 * Servlet implementation class JogadorExcluir
 */
@WebServlet("/jogador/excluir")
public class ExcluirJogador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExcluirJogador() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		int posicaoNaLista = Integer.valueOf(id);
		
		Jogador jogadorSelecionado = ListarJogador.jogadores.get( posicaoNaLista );
		
		request.setAttribute("jogador", jogadorSelecionado);
		
		request.getRequestDispatcher("../pages/jogador/excluir.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int posicaoNaLista = Integer.valueOf(id);
		ListarJogador.jogadores.remove(posicaoNaLista);
		
		//atualiza os identificadores dos jogadores
		for(int idDoJogador = 0; idDoJogador < ListarJogador.jogadores.size(); idDoJogador++) {
			Jogador jogadorNaPosicao = ListarJogador.jogadores.get(idDoJogador);
			jogadorNaPosicao.setId(Long.valueOf(idDoJogador));
		}
		
		response.sendRedirect("./listar");
	}

}
