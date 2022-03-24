package br.com.fuctura.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import br.com.fuctura.model.Filme;
import br.com.fuctura.util.JPAUtil;

public class FilmeDAO {
	
	//estou "injetando" um EntityManagerFactory
	private EntityManagerFactory fabrica = JPAUtil.getEntityManagerFactory();
	
	public void salvar(Filme filme) {
		
		EntityManager gerenciador = fabrica.createEntityManager();
		
		EntityTransaction transacao = gerenciador.getTransaction();
		
		transacao.begin(); //comeco

		gerenciador.persist(filme); //persist eh o metodo que salva na base
		
		transacao.commit(); //fim
		
		gerenciador.close();
		
	}
	
	public void excluir(Filme filme) {
		
		EntityManager gerenciador = fabrica.createEntityManager();
		EntityTransaction transacao = gerenciador.getTransaction();
		
		transacao.begin();
		
		Filme filmeQueVaiExcluido = gerenciador.find(Filme.class, filme.getLinkyt());
		
		gerenciador.remove(filmeQueVaiExcluido);
		
		transacao.commit();
		
		gerenciador.close();
		
	}
	
	public Filme pesquisar(Filme filme) {
		
		EntityManager gerenciador = fabrica.createEntityManager();
		
		Filme fi = gerenciador.find(Filme.class, filme.getLinkyt());
		
		gerenciador.close();
		
		return fi;
	}
	
}
