package tp1;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class EstoqueInterface {
	Scanner sc = new Scanner(System.in);
	public void editaEstoque(ArrayList<Estoque> estoque) {
		int opcao = 0;
		String racaEscolha ="";	
		while(true) {
			System.out.printf("Edita Estoque");
			System.out.printf("Deseja: \n 1-Editar um existente \n 2-Adicionar um novo? \n 0-Sair");
			sc.nextInt(opcao);
			
			if(opcao == 0)
				break;
			
			if(opcao == 1) {
				int j = 0,i = 0;
				System.out.printf("Estoque de qual raça deseja editar?");
				sc.next(racaEscolha);
				
				while(estoque.get(i).getMontaria().getRaca() != racaEscolha) {
					i++;
				}
				System.out.println("O que deseja fazer com esse estoque?");
				System.out.println("1:Remover estoque");
				System.out.println("2:Editar quantidade");
				System.out.println("0:Voltar");
				sc.nextInt(j);
				
				switch(j) {
				case 1:
					estoque.remove(i);
					break;
				case 2:
					int qtd = 0;
					System.out.printf("Atual quantidade: "+estoque.get(i).getQuantidade());
					System.out.printf("Quer alterar para quanto?");
					sc.nextInt(qtd);
					if(qtd == 0)
						System.out.println("Quantidade inválida, tente remover o estoque.");
					else {
						estoque.get(i).setQuantidade(qtd);
						System.out.println("Quantidade alterada com sucesso!");
					}
					break;
				case 0:
					break;
					
				}
				
			}
			
		}
	}
	public void visualizaEstoque(ArrayList<Estoque> estoque) {
		int opcao = 0,i = 0;
		String racaEscolha = "";
		while(true) {
			System.out.printf("O que deseja?\n 0 - Sair \n 1 - Vizualizar um estoque\n");
			sc.nextInt(opcao);
			if(opcao == 0)
				break;
			else
				
				System.out.printf("Estoque de qual raça deseja visualizar?");
				sc.next(racaEscolha);
				while(estoque.get(i).getMontaria().getRaca() != racaEscolha) {
					i++;
				}
				System.out.println("Estoque da raça: "+estoque.get(i).getMontaria().getRaca());
				System.out.println("Quantidade disponivel: "+estoque.get(i).getQuantidade());
				System.out.println("Preço individual da montaria: "+estoque.get(i).getPreco());
		}
	}
	
}
