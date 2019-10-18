package tp1;

public class Montaria extends Entidade implements MontariaInterface{
	private String nome;
	private String raca;
	private String descricao;
	private String combustivel;
	private String raridade;
	private int capacidade;
	private float velocidade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raça) {
		this.raca = raça;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	public String getRaridade() {
		return raridade;
	}
	public void setRaridade(String raridade) {
		this.raridade = raridade;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public float getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(float velocidade) {
		this.velocidade = velocidade;
	}
	
}
