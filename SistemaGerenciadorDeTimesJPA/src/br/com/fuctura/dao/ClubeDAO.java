package br.com.fuctura.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import br.com.fuctura.model.Clube;
import br.com.fuctura.util.JPAUtil;

public class ClubeDAO {
	
	private EntityManagerFactory fabrica = JPAUtil.getEntityManagerFactory();
	
	public void salvar(Clube clube) {
		
		EntityManager gerenciador = fabrica.createEntityManager();
		
		EntityTransaction transacao = gerenciador.getTransaction();
		
		transacao.begin();
		
		gerenciador.persist(clube);
		
		transacao.commit();
		
	}
	
	
}
