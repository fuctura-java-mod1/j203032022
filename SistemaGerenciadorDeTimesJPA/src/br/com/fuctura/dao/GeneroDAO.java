package br.com.fuctura.dao;import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import br.com.fuctura.model.Genero;
import br.com.fuctura.util.JPAUtil;

public class GeneroDAO {
	
	//estou "injetando" um EntityManagerFactory
		private EntityManagerFactory fabrica = JPAUtil.getEntityManagerFactory();
	
	public void salvar(Genero genero) {
		
		EntityManager gerenciador = fabrica.createEntityManager();
		
		EntityTransaction transacao = gerenciador.getTransaction();
		
		transacao.begin(); //comeco

		gerenciador.persist(genero); //persist eh o metodo que salva na base
		
		transacao.commit(); //fim
		
		gerenciador.close();
		
	}
	
}
