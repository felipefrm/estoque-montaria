package venda_montaria.tp1.model;

import java.util.ArrayList;

public class Vendedor extends Entidade {
	private int idade;
	private String raca;
	private String nome;
	private ArrayList<Estoque> estoque;
	static private int cont = 1;


	public Vendedor(String nome, String raca, int idade) {
		setId(cont++);
		this.nome = nome;
		this.raca = raca;
		this.idade = idade;
		this.estoque = new ArrayList<Estoque>();
	}

	public static void setCont(int cont) {
		Vendedor.cont = cont;
	}


	public ArrayList<Estoque> getEstoque() {
		return estoque;
	}

	public void setEstoque(ArrayList<Estoque> estoque) {
		this.estoque = estoque;
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

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
