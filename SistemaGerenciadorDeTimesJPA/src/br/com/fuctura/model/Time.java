package br.com.fuctura.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Time {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	private String nome;
	private int qtdTitulos;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdTitulos() {
		return qtdTitulos;
	}

	public void setQtdTitulos(int qtdTitulos) {
		this.qtdTitulos = qtdTitulos;
	}

}
