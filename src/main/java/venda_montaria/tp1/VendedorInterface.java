package venda_montaria.tp1;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class VendedorInterface {

	public static Vendedor criaVendedor(Scanner sc) {

		System.out.println("\nAdicionando vendedor...");
		System.out.printf("Nome: ");
		String nome = sc.nextLine();
		System.out.printf("Raça: ");
		String raca = sc.nextLine();
		System.out.printf("Idade: ");
		int idade = sc.nextInt();
		System.out.printf("Descrição: ");
		sc.nextLine();
		String descricao = sc.nextLine();

		return new Vendedor(nome, raca, idade, descricao);
	}

	public static void adicionaVendedor(ArrayList<Vendedor> vendedores, Scanner sc) {
		Vendedor novo_vendedor = criaVendedor(sc);
		vendedores.add(novo_vendedor);
	}

	public static void menu(ArrayList<Vendedor> vendedores, ArrayList<Montaria> montarias, Scanner sc) {

		while (true) {

//			visualizaVendedores(vendedores);

			System.out.println("\n╔════════ MENU DE VENDEDORES ════════╗");
			System.out.printf("╠0 Voltar\n╠1 Adicionar Vendedor\n╠2 Remover Vendedor\n╠3 Visualizar Vendedores\n╚4 Estoque Vendedor\n⟶ ");
			int op = sc.nextInt();

			switch (op) {
			case 0:
				return;
			case 1:
				sc.nextLine();
				adicionaVendedor(vendedores, sc);
				break;
			case 2:
				removeVendedor(vendedores, sc);
				break;
			case 3:
				visualizaVendedores(vendedores);
				break;
			case 4:
				Vendedor vend = selecionaVendedor(vendedores, sc);
				EstoqueInterface.menuEstoque(vend.getEstoque(), vend.getNome(), montarias, sc);
				break;
			default:
				System.out.println("Não existe esta opção, por favor digite novamente.");

			}
		}
	}

	public static void removeVendedor(ArrayList<Vendedor> vendedores, Scanner sc) {

		System.out.printf("\nQual vendedor deseja remover? [Digite 0 para voltar] ");
		int vendId = sc.nextInt();

		if (vendId == 0)
			return;

		for (Vendedor v : vendedores) {
			if (v.getId() == vendId) {
				vendedores.remove(v);
				System.out.println("Vendedor removido. ");
				return;
			}
		}
		System.out.printf("Não há nenhum vendedor com o ID " + vendId + " na base de dados.");
		
	}

	public static Vendedor selecionaVendedor(ArrayList<Vendedor> vendedores, Scanner sc) {

		System.out.printf("\nSelecione um vendedor para acessar o estoque: ");
		int vendId = sc.nextInt();

		for (Vendedor v : vendedores)
			if (v.getId() == vendId)
				return v;

		System.out.printf("Não há nenhum vendedor com o ID " + vendId + " na base de dados.");
		return null;
	}

	public static void visualizaVendedores(ArrayList<Vendedor> vendedores) {
		
		if (vendedores.size() == 0) {
			System.out.println("\nNão há nenhum vendedor cadastro na base de dados.");
			return;
		}	
		
		System.out.println();
		
		for (Vendedor v : vendedores)
			System.out.printf("[%d] %s, %s, %d anos\n", v.getId(), v.getNome(), v.getRaca(), v.getIdade());
	}
}