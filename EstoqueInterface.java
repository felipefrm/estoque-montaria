package tp1;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class EstoqueInterface {
		
	public static void menuEstoque(ArrayList<Estoque> estoques,Scanner sc) {
		for(Estoque e : estoques) {
			System.out.printf("ID: "+e.getMontaria().getId()+"\nQuantidade: "+e.getQuantidade());
			System.out.printf("Nome: "+e.getMontaria().getNome()+"\nPreço: "+e.getPreco()+"\n");
		}
		int opcao = 0,idEscolha = 0;
		while(true) {
			System.out.println("Deseja Adicionar um Estoque novo(1), editar um existente(2),remover um(3) ou voltar(0)?");
			sc.nextInt(opcao);
			if(opcao == 0)
				break;
			switch(opcao) {
			case 1:
				adicionaEstoque(estoques,sc);
				break;
			case 2:
				System.out.printf("Escolha um estoque pelo ID da Montaria ");
				sc.nextInt(idEscolha);
				for(Estoque e : estoques)
					if(e.getMontaria().getId() == idEscolha)
						editaEstoque(e,sc);
				break;
			case 3:
				System.out.printf("Escolha um estoque pelo ID da Montaria ");
				sc.nextInt(idEscolha);
				for(Estoque e : estoques)
					if(e.getMontaria().getId() == idEscolha)
						removeEstoque(estoques,idEscolha);
			}
				
			}
				
			}
			
	public static void removeEstoque(ArrayList <Estoque> estoques,int idEscolha) {
		estoques.remove(idEscolha);
		System.out.println("Estoque removido com sucesso!");
	}

    public static void editaEstoque(Estoque estoque, Scanner sc) {
        int j = 0;
		while(true) {
				System.out.println("O que deseja fazer com esse estoque?");
				System.out.println("1:Editar quantidade");
				System.out.println("2:Editar preço");
				System.out.println("0:Voltar");
				sc.nextInt(j);
				
				switch(j) {
				case 1:
					int qtd = 0;
					System.out.printf("Atual quantidade: "+estoque.getQuantidade());
					System.out.printf("Quer alterar para quanto?");
					sc.nextInt(qtd);
					if(qtd == 0)
						System.out.println("Quantidade inválida, tente remover o estoque.");
					else {
						estoque.setQuantidade(qtd);
						System.out.println("Quantidade alterada com sucesso!");
					}
					break;
				case 2:
					float precoNovo = (float) 0;
					System.out.printf("Atual preço: "+estoque.getPreco());
					System.out.printf("Quer alterar para quanto?");
					sc.nextFloat(precoNovo);
					estoque.setPreco(precoNovo);
					System.out.println("Preço alterada com sucesso!");
					
				case 0:
					return;
					
				}
				
			}
			
		}
    public static void adicionaEstoque(ArrayList <Estoque> estoques, Scanner sc) {
    	
    }

	
}
