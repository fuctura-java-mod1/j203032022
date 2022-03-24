package br.com.fuctura.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	//padrao de projeto singleton - vai garantir que eu tenha
	//uma fabrica uma única vez
	
	private static EntityManagerFactory fabrica = null; 
	
	static {
		System.out.println("Carregando XML...");
		fabrica = Persistence.createEntityManagerFactory("Fuctura-PU");
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		
		if( fabrica == null ) {
			System.out.println("Carregando XML...");
			fabrica = Persistence.createEntityManagerFactory("Fuctura-PU");
		}
		return fabrica;
	}
}
