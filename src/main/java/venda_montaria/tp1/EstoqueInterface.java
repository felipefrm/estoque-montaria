package venda_montaria.tp1;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class EstoqueInterface {

	public static void menuEstoque(ArrayList<Estoque> estoques, String nome, ArrayList<Montaria> montarias, Scanner sc) {

//		visualizaEstoque(estoques);

		while (true) {

			System.out.println("\n╔════════ MENU DO VENDEDOR " + nome.toUpperCase() + " ════════╗");
			System.out.printf("╠0 Voltar\n╠1 Adicionar nova montaria ao estoque\n╠2 Editar o estoque de uma montaria existente\n╠3 Remover uma montaria do estoque\n╚4 Visualizar estoque\n⟶ ");
			int opcao = sc.nextInt();

			switch (opcao) {

			case 0:
				return;

			case 1:
				adicionaEstoque(estoques, montarias, sc);
				break;

			case 2:
				editaEstoque(estoques, sc);
				break;

			case 3:
				removeEstoque(estoques, sc);
				break;

			case 4:
				visualizaEstoque(estoques);
				break;

			default:
				System.out.println("Não existe esta opção, por favor digite novamente.");
			}

		}

	}

	public static void removeEstoque(ArrayList<Estoque> estoques, Scanner sc) {

		System.out.printf("\nEscolha uma montaria para remover do estoque [Digite 0 para voltar]: ");
		int idEscolha = sc.nextInt();

		if (idEscolha == 0)
			return;

		for (Estoque e : estoques)
			if (e.getMontaria().getId() == idEscolha) {
				estoques.remove(e);
				System.out.println("Montaria removida com sucesso do estoque!");
				return;
			}
		System.out.println("Está montaria não está contida no estoque.");
	}

	public static void editaEstoque(ArrayList<Estoque> estoques, Scanner sc) {

		System.out.printf("\nEscolha uma montaria para editar o estoque [Digite 0 para voltar]: ");
		int idEscolha = sc.nextInt();

		if (idEscolha == 0)
			return;

		for (Estoque e : estoques) {
			if (e.getMontaria().getId() == idEscolha) {
				System.out.println("\n╔════════ MENU DE EDIÇÃO ════════╗");
				while (true) {

					System.out.printf("╔0 Voltar\n╠1 Editar quantidade\n╚2 Editar preço\n⟶ ");
					
					int op = sc.nextInt();

					switch (op) {

					case 1:
						System.out.printf("\nAtual quantidade: " + e.getQuantidade());
						System.out.printf("\nQuer alterar para quanto? ");
						int qtd = sc.nextInt();
						e.setQuantidade(qtd);
						System.out.println("Quantidade alterada com sucesso!\n");
						break;

					case 2:
						float precoNovo = 0;
						System.out.printf("\nAtual preço: U$" + e.getPreco());
						System.out.printf("\nQuer alterar para quanto? ");
						precoNovo = sc.nextFloat();
						e.setPreco(precoNovo);
						System.out.println("Preço alterado com sucesso!\n");
						break;

					case 0:
						return;

					default:
						System.out.println("Não há esta opção, por favor digite novamente.");
					}
				}
			}
		}
	}

	public static void adicionaEstoque(ArrayList<Estoque> estoques, ArrayList<Montaria> montarias, Scanner sc) {
		System.out.println("\nMontarias disponíveis:\n");
		
		if (montarias.size() == 0) {
			System.out.println("Não há nenhuma montaria na base de dados.");
			return;
		}
		
		else {
			for (Montaria m : montarias)
				System.out.printf("[%d] %s\n", m.getId(), m.getRaca());
			System.out.printf("\nSelecione uma montaria para adicionar ao estoque [Digite 0 para voltar]: ");
	
			int montId = sc.nextInt();
			
			if (montId == 0)
				return;
			
			for (Estoque e : estoques)
				if (e.getMontaria().getId() == montId) {
					System.out.println("Montaria já existe no estoque.");
					return;
				}
	
			Montaria monta = new Montaria();
			for (Montaria m : montarias)
				if (m.getId() == montId) {
					monta = m;
					break;
				}
			
			System.out.printf("Preço: U$");
			float preco = sc.nextFloat();
			System.out.printf("Quantidade: ");
			int qtd = sc.nextInt();
			estoques.add(new Estoque(monta, qtd, preco));
		}
	}

	public static void visualizaEstoque(ArrayList<Estoque> estoques) {
		
		if (estoques.size() == 0) {
			System.out.println("\nEste vendedor não contém nenhuma montaria no estoque.");
			return;
		}	
		
		System.out.println();
		
		for (Estoque e : estoques)
			System.out.printf("[%d] %s - QTD: %d - PREÇO: U$%.2f\n", e.getMontaria().getId(), e.getMontaria().getRaca(),
					e.getQuantidade(), e.getPreco());
	}
}