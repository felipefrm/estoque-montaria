package tp1;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class EstoqueInterface {

	public static void menuEstoque(ArrayList<Estoque> estoques, Scanner sc) {

		for (Estoque e : estoques) {
			System.out.printf("[%d] %s - QTD: %d - PREÇO: %f\n", e.getMontaria().getId(), e.getMontaria().getNome(),
					e.getQuantidade(), e.getPreco());
		}
		int opcao = 0, idEscolha = 0;

		while (true) {

			System.out.printf(
					"Qual operação deseja realizar?\n[0] Voltar\n[1] Adicionar nova montaria ao estoque\n[2] Editar o estoque de uma montaria existente\n[3] Remover uma montaria do estoque\n>>>");
			opcao = sc.nextInt();

			switch (opcao) {
			case 0:
				return;
			case 1:
				adicionaEstoque(estoques, sc);
				break;
			case 2:
				System.out.printf("Escolha uma montaria para editar o estoque: ");
				idEscolha = sc.nextInt();
				for (Estoque e : estoques)
					if (e.getMontaria().getId() == idEscolha) {
						editaEstoque(e, sc);
						break;
					}
				break;
			case 3:
				System.out.printf("Escolha uma montaria para remover do estoque: ");
				idEscolha = sc.nextInt();
				for (Estoque e : estoques)
					if (e.getMontaria().getId() == idEscolha) {
						removeEstoque(estoques, idEscolha);
						break;
					}
				break;
			default:
				System.out.println("Não existe esta opção, por favor digite novamente.");
			}

		}

	}

	public static void removeEstoque(ArrayList<Estoque> estoques, int idEscolha) {
		estoques.remove(idEscolha);
		System.out.println("Estoque removido com sucesso!");
	}

	public static void editaEstoque(Estoque estoque, Scanner sc) {

		while (true) {

			System.out.println("[0] Voltar");
			System.out.println("[1] Editar quantidade");
			System.out.println("[2] Editar preço");
			int op = sc.nextInt();

			switch (op) {
			case 1:
				System.out.printf("Atual quantidade: " + estoque.getQuantidade());
				System.out.printf("Quer alterar para quanto?");
				int qtd = sc.nextInt();
				if (qtd == 0)
					System.out.println("Quantidade inválida, tente remover o estoque.");
				else {
					estoque.setQuantidade(qtd);
					System.out.println("Quantidade alterada com sucesso!");
				}
				break;
			case 2:
				float precoNovo = 0;
				System.out.printf("Atual preço: " + estoque.getPreco());
				System.out.printf("Quer alterar para quanto?");
				precoNovo = sc.nextFloat();
				estoque.setPreco(precoNovo);
				System.out.println("Preço alterada com sucesso!");

			case 0:
				return;

			}

		}

	}

	public static void adicionaEstoque(ArrayList<Estoque> estoques, Scanner sc) {
		
	}

}