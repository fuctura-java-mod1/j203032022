package br.com.fuctura;

import java.util.ArrayList;

import br.com.fuctura.dao.ClubeDAO;
import br.com.fuctura.dao.TimeDAO;
import br.com.fuctura.model.Clube;
import br.com.fuctura.model.Jogador;
import br.com.fuctura.model.Time;

public class TesteAssociacao {

	public static void main(String[] args) {

		Clube clubeA = new Clube();
		clubeA.setNome("Clube Fuctura");
		clubeA.setCapacidade(950);
		clubeA.setDataFundacao("01-01-1500");

		Time time = new Time();
		time.setNome("Brasil");
		time.setQtdTitulos(5);
		
		clubeA.setTime(time);

		ClubeDAO dao = new ClubeDAO();

		//dao.salvar(clubeA);
		
		Jogador j1 = new Jogador();
		j1.setNome("Gabriel");
		
		Jogador j2 = new Jogador();
		j2.setNome("Joao");
		
		ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
		
		jogadores.add(j1);
		jogadores.add(j2);
		
		time.setJogadores(jogadores);
		
		TimeDAO daoDoTime = new TimeDAO();
		daoDoTime.salvar(time);
		
	}
	
}
