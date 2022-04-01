package br.com.fuctura.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PostPersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.fuctura.util.AuditorFilme;
import br.com.fuctura.util.GeneroEnum;

@Entity
@Table( name = "TB_FILME" )
@NamedQueries({
	@NamedQuery(name = "Filme.findByClassificacao", 
	query = "select f from Filme f where f.classificacao = :class"),
	@NamedQuery(name = "findByIntervalo", 
	query = " select f from Filme f where f.classificacao >= :menor AND f.classificacao <= :maior")
})
@EntityListeners(AuditorFilme.class)
public class Filme {
	@Id
	private String linkyt;
	@Column(length = 100, nullable = false)
	private String nome;
	private int duracao;
	private int classificacao;
	private LocalDate dataDeLancamento;
	
	@Enumerated(EnumType.STRING)
	private GeneroEnum genero;
	
	public GeneroEnum getGenero() {
		return genero;
	}
	public void setGenero(GeneroEnum genero) {
		this.genero = genero;
	}
	@Transient
	private String ignorar;
	
	@Lob
	private byte[] imagemDoFilme;
	
	public String getIgnorar() {
		return ignorar;
	}
	public void setIgnorar(String ignorar) {
		this.ignorar = ignorar;
	}
	public byte[] getImagemDoFilme() {
		return imagemDoFilme;
	}
	public void setImagemDoFilme(byte[] imagemDoFilme) {
		this.imagemDoFilme = imagemDoFilme;
	}
	public LocalDate getDataDeLancamento() {
		return dataDeLancamento;
	}
	public void setDataDeLancamento(LocalDate dataDeLancamento) {
		this.dataDeLancamento = dataDeLancamento;
	}
	
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
	
	@PostPersist
	public void callback() {
		System.out.println("Invocou o método de callback");
	}

}
