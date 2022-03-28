package br.com.controllers.jogador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.JogadorDAO;
import br.com.model.Jogador;

/**
 * Servlet implementation class JogadorListar
 */
@WebServlet("/jogador/listar")
public class ListarJogador extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public static List<Jogador> jogadores;
	
	static {
		jogadores = new ArrayList<Jogador>();
		
		Jogador jogador1 = new Jogador();
		jogador1.setId(0L);
		jogador1.setNome("Ronaldo");
		jogador1.setIdade(30L);
		jogador1.setNomeDaImagem("cr7.jpg");

		Jogador jogador2 = new Jogador();
		jogador2.setId(1L);
		jogador2.setNome("Rivaldo");
		jogador2.setIdade(31L);	
		jogador2.setNomeDaImagem("rivaldo.png");
		
		jogadores.add(jogador1);
		jogadores.add(jogador2);		
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarJogador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-- Listar Jogadores --");
		List<Jogador> resultadoDaConsulta = getJogadoresEmMemoria();
		
		//criar aqui o método de consulta
		
		request.setAttribute("jogadores", resultadoDaConsulta);
		request.getRequestDispatcher("../pages/jogador/listar.jsp").forward(request, response);
	}

	private List<Jogador> getJogadoresEmMemoria() {
		return jogadores;
	}	
}
