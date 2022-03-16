package fuctura.model;

public class Jogador {

    private int codigo;		
	private String nome;
	private Integer idade;
	private Integer camisa;
	private boolean isRemovido;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Integer getCamisa() {
		return camisa;
	}

	public void setCamisa(Integer camisa) {
		this.camisa = camisa;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public boolean isRemovido() {
		return isRemovido;
	}

	public void setRemovido(boolean isRemovido) {
		this.isRemovido = isRemovido;
	}
}
