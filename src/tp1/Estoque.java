package tp1;

public class Estoque {
	private int quantidade;
	private float preco;
	private Montaria montaria;

	public Montaria getMontaria() {
		return montaria;
	}

	public void setMontaria(Montaria montaria) {
		this.montaria = montaria;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

}