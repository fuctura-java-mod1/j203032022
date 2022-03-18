package br.com.fuctura.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "TB_FILME" )
public class Filme {
	@Id
	private String linkyt;
	@Column(length = 100, nullable = false)
	private String nome;
	private int duracao;
	private int classificacao;
	
	public String getLinkyt() {
		return linkyt;
	}
	public void setLinkyt(String linkyt) {
		this.linkyt = linkyt;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public int getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}
}
