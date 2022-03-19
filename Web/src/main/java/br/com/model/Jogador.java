package br.com.model;

public class Jogador {
	private Long id;
	private String nome;
	private Long idade;
	private String nomeDaImagem;
	private Integer camisa;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

	public String getNomeDaImagem() {
		return nomeDaImagem;
	}

	public void setNomeDaImagem(String nomeDaImagem) {
		this.nomeDaImagem = nomeDaImagem;
	}

	public Integer getCamisa() {
		return camisa;
	}

	public void setCamisa(Integer camisa) {
		this.camisa = camisa;
	}

}
