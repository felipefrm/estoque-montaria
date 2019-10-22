package tp1;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class EstoqueInterface {

	public static void menuEstoque(ArrayList<Estoque> estoques,ArrayList <Montaria> montarias, Scanner sc) {
		
		int opcao = 0, idEscolha = 0;

		while (true) {

			System.out.printf(
					"Qual operação deseja realizar?\n[0] Voltar\n[1] Adicionar nova montaria ao estoque\n[2] Editar o estoque de uma montaria existente\n[3] Remover uma montaria do estoque\n[4] Visualizar estoque\n>>>");
			opcao = sc.nextInt();

			switch (opcao) {
			case 0:
				return;
			case 1:
				adicionaEstoque(estoques,montarias, sc);
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
			case 4:
				for(Estoque e :estoques)
					System.out.printf("[%d] %s - QTD: %d - PREÇO: %.2f\n",e.getMontaria().getId(),e.getMontaria().getRaca(),e.getQuantidade(),e.getPreco());
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
				System.out.printf("\nQuer alterar para quanto?");
				int qtd = sc.nextInt();
				estoque.setQuantidade(qtd);
				System.out.println("Quantidade alterada com sucesso!");
				break;
			case 2:
				float precoNovo = 0;
				System.out.printf("Atual preço: U$" + estoque.getPreco());
				System.out.printf("\nQuer alterar para quanto?");
				precoNovo = sc.nextFloat();
				estoque.setPreco(precoNovo);
				System.out.println("Preço alterada com sucesso!");

			case 0:
				return;

			}

		}

	}

	public static void adicionaEstoque(ArrayList<Estoque> estoques, ArrayList<Montaria> montarias, Scanner sc) {
		System.out.println("Montarias disponíveis: ");
		for(Montaria m : montarias)
			System.out.printf("[%d] %s\n",m.getId(),m.getRaca());
		System.out.printf("Selecione uma montaria para adicionar ao estoque: ");
		
		int montId = sc.nextInt();
		for(Estoque e : estoques)
			if (e.getMontaria().getId() == montId) {
				System.out.println("Montaria já existe no estoque.");
				break;
			}
				
		
		Montaria monta = new Montaria();
		for (Montaria m : montarias)
			if (m.getId() == montId) {
				monta = m;
				break;
			}
		System.out.printf("Preço: ");
		float preco = sc.nextFloat();
		System.out.printf("Quantidade: ");
		int qtd = sc.nextInt();
		estoques.add(new Estoque(monta, qtd, preco));
	}

}
