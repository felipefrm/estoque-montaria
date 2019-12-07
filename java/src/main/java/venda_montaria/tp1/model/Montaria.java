package venda_montaria.tp1.model;

public class Montaria extends Entidade {

	private String raca;
	private String combustivel;
	private String raridade;
	private int capacidade;
	private float velocidade;
	static private int cont = 1;

	public Montaria(String raca, String combustivel, String raridade, int capacidade,
			float velocidade) {
		setId(cont++);
		this.raca = raca;
		this.combustivel = combustivel;
		this.raridade = raridade;
		this.capacidade = capacidade;
		this.velocidade = velocidade;
	}

	public static void setCont(int cont) {
		Montaria.cont = cont;
	}

	public Montaria() {

	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
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
