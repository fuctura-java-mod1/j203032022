package br.com.fuctura;

import java.util.Iterator;
import java.util.List;

import br.com.fuctura.dao.FilmeDAO;
import br.com.fuctura.model.Filme;

public class TesteConexaoHibernate {

	public static void main(String[] args) {

		Filme novoFilme = new Filme();
		novoFilme.setNome("Vingadores");
		novoFilme.setDuracao(120);
		novoFilme.setLinkyt("yt/7hdyu");
		novoFilme.setClassificacao(12);

		Filme filme2 = new Filme();
		filme2.setNome("Matrix");
		filme2.setDuracao(220);
		filme2.setLinkyt("yt/78j1");
		filme2.setClassificacao(15);
		
		FilmeDAO dao = new FilmeDAO();
		
		dao.salvar(novoFilme);
		dao.salvar(filme2);

		//dao.excluir(novoFilme);

		Filme filmeEncontradoNaBase = dao.pesquisar(novoFilme);
		
		if (filmeEncontradoNaBase != null) {
			System.out.println("Duracao: " + filmeEncontradoNaBase.getDuracao());
		}
		
		Filme f = new Filme();
		f.setClassificacao(15);
		
		List<Filme> resultado = dao.pesquisarPorClassificacao(f);
		for(Filme filme : resultado) {
			System.out.println("Nome: " + filme.getNome());
		}
		
		List<Filme> resultado2 = dao.pesquisarPorClassificacao(10, 22);
		for(Filme filme : resultado2) {
			System.out.println("- Nome: " + filme.getNome());
		}
		
		List<Filme> resultado3 = dao.pesquisarPorNome("Vingadores");
		for(Filme filme : resultado3) {
			System.out.println("* Nome: " + filme.getNome());
		}
	}

}
