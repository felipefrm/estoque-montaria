package venda_montaria.tp1;

import java.util.ArrayList;

public class Vendedor extends Entidade {
	private int idade;
	private String raca;
	private String nome;
	private String descricao;
	private ArrayList<Estoque> estoque;
	static private int cont = 1;

	public static void setCont(int cont) {
		Vendedor.cont = cont;
	}

	public Vendedor(String nome, String raca, int idade, String descricao) {
		setId(cont++);
		this.nome = nome;
		this.raca = raca;
		this.idade = idade;
		this.descricao = descricao;
		this.estoque = new ArrayList<Estoque>();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}