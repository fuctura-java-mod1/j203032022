package br.com.fuctura.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import br.com.fuctura.model.Time;
import br.com.fuctura.util.JPAUtil;

public class TimeDAO {
	
	private EntityManagerFactory fabrica = JPAUtil.getEntityManagerFactory();
	
	public void salvar(Time time) {
		
		EntityManager gerenciador = fabrica.createEntityManager();
		
		EntityTransaction transacao = gerenciador.getTransaction();
		
		transacao.begin();
		
		gerenciador.persist(time);
		
		transacao.commit();
		
		gerenciador.close();
		
	}
	
}
