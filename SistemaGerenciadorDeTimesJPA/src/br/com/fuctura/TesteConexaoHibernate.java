package br.com.fuctura;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.fuctura.model.Filme;

public class TesteConexaoHibernate {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Fuctura-PU");
		EntityManager gerenciador = fabrica.createEntityManager();

		EntityTransaction transacao = gerenciador.getTransaction();
		
		transacao.begin(); //comeco
		
		Filme novo = new Filme();
		novo.setNome("Vingadores");
		novo.setLinkyt("yt/huio1");
		
		gerenciador.persist(novo);
		
		transacao.commit(); //fim
	}

}
