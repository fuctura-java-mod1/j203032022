package br.com.fuctura;

import br.com.fuctura.dao.FilmeDAO;
import br.com.fuctura.model.Filme;

public class TesteConexaoHibernate {

	public static void main(String[] args) {

		Filme novoFilme = new Filme();

		novoFilme.setNome("Vingadores");
		novoFilme.setDuracao(120);
		novoFilme.setLinkyt("yt/7hdyu");

		FilmeDAO dao = new FilmeDAO();
		dao.salvar(novoFilme);

		dao.excluir(novoFilme);

		Filme filmeEncontradoNaBase = dao.pesquisar(novoFilme);
		
		if (filmeEncontradoNaBase != null) {
			System.out.println("Duracao: " + filmeEncontradoNaBase.getDuracao());
		}
	
	}

}
