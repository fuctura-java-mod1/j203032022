package br.com.fuctura.util;

import javax.persistence.PrePersist;

import br.com.fuctura.model.Filme;

public class FilmeAuditor {
	
	@PrePersist
	public void callback(Filme filme) {
		System.out.println("Nome:" + filme.getNome());
	}
	
}
