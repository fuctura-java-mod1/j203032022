package br.com.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf;

	static {
		//Remover o comentário da linha de baixo quando finalizar a configuração do JPA
		//emf = Persistence.createEntityManagerFactory("Fuctura-PU");
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("Fuctura-PU");
		}
		return emf;
	}

}
