package br.com.fuctura.dto;

//DTO = Data Transfer Object
public class NomeDuracaoDTO {
	private String nome;
	private int duracao;
	private int classificacao;
	
	//construtor "customizado"
	public NomeDuracaoDTO(String nome, int duracao, int classificacao) {
		this.nome = nome;
		this.duracao = duracao;
		this.classificacao = classificacao;
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
	
}
