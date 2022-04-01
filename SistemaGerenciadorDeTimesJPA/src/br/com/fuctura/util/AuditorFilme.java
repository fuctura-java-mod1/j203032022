package br.com.fuctura.util;

import javax.persistence.PrePersist;

import br.com.fuctura.model.Filme;

public class AuditorFilme {
	
	@PrePersist
	public void callback(Filme filme) {
		System.out.println("ANTES DE SALVAR: " 
							+ filme.getNome());
		filme.setNome(filme.getNome().toUpperCase());
		
	}
	
}
