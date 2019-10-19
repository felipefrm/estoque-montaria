package tp1;

import java.util.ArrayList;

public class Montaria extends Entidade {
	
    private String nome;
	private String raca;
	private String descricao;
	private String combustivel;
	private String raridade;
	private int capacidade;
	private float velocidade;
        private int id;
        static private int cont = 1;
	
        public Montaria (String nome, String raca, String descricao, String combustivel, String raridade, int capacidade, float velocidade) {
            this.id = cont++;
            this.nome = nome;
            this.raca = raca;
            this.descricao = descricao;
            this.combustivel = combustivel;
            this.raridade = raridade;
            this.capacidade = capacidade;
            this.velocidade = velocidade;
        }
        
       	public int getId() {
		return id;
	}
        
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
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
