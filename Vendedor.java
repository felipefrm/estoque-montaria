package tp1;

public class Vendedor extends Entidade {
	private int idade;
	private String raca;
	private String nome;
	private String descricao;
	private int id;
	static private int cont = 0;
	
	public Vendedor(String nome, String raca, int idade, String descricao) {
		this.id = ++cont;
		this.nome = nome;
		this.raca = raca;
		this.idade = idade;
		this.descricao = descricao;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getRaca() {
		return raca;
	}
	public int getId() {
		return id;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}