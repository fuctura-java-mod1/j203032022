package br.com.fuctura;

import br.com.fuctura.dao.ClubeDAO;
import br.com.fuctura.model.Clube;

public class TesteAssociacao {
	
	public static void main(String[] args) {
		
		Clube clubeA = new Clube();
		clubeA.setNome("Clube Fuctura");
		clubeA.setCapacidade(950);
		clubeA.setDataFundacao("01-01-1500");
	
		ClubeDAO dao = new ClubeDAO();
		
		//dao.salvar(clubeA);
	
	}
}
