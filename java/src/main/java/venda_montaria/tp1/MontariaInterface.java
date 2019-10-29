package venda_montaria.tp1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class MontariaInterface {

	public static void menu(ArrayList<Montaria> montarias, Scanner sc) {

		while (true) {

//			visualizaMontarias(montarias);

			int op;
			while (true) {
				System.out.println("\n╔════════ MENU DE MONTARIAS ════════╗");
				System.out
						.printf("╠0 Voltar\n╠1 Adicionar Montaria\n╠2 Remover Montaria\n╚3 Visualizar Montarias\n⟶ ");
				try {
					op = sc.nextInt();
					break;
				}
				catch(InputMismatchException e) {
					sc.nextLine();
					System.out.printf("Entrada inválida, por favor escolha uma das opções.\n ");
				}
			}

			switch (op) {
			case 0:
				return;
			case 1:
				adicionaMontaria(montarias, sc);
				break;
			case 2:
				removeMontaria(montarias, sc);
				break;
			case 3:
				visualizaMontarias(montarias);
				break;
			default:
				System.out.println("\nNão existe esta opção, por favor digite novamente.");
			}
		}
	}


	public static Montaria criaMontaria(Scanner sc) {

		System.out.println("\nAdicionando Montaria...");
		sc.nextLine();
		System.out.printf("Nome: ");
		String nome = sc.nextLine();
		System.out.printf("Raça: ");
		String raca = sc.nextLine();
		System.out.printf("Raridade: ");
		String raridade = sc.nextLine();
		int capacidade;
		while (true) {
			System.out.printf("Capacidade: ");
			try {
				capacidade = sc.nextInt();
				break;
			}
			catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("Entrada inválida, insira um número inteiro para a capacidade.");
			}
		}
		float velocidade;
		while (true) {
			System.out.printf("Velocidade: ");
			try {
				velocidade = sc.nextInt();
				break;
			}
			catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("Entrada inválida, insira um número real para a velocidade.");
			}
		}
		sc.nextLine();
		System.out.printf("Combustivel: ");
		String combustivel = sc.nextLine();
		System.out.printf("Descrição: ");
		String descricao = sc.nextLine();

		return new Montaria(nome, raca, descricao, combustivel, raridade, capacidade, velocidade);
	}

	
	public static void adicionaMontaria(ArrayList<Montaria> montarias, Scanner sc) {
		Montaria nova_montaria = criaMontaria(sc);
		montarias.add(nova_montaria);
	}

	public static void removeMontaria(ArrayList<Montaria> montarias, Scanner sc) {

		int montId;
		while (true) {
			System.out.printf("\nQual montaria deseja remover? [Digite 0 para voltar] ");
			try {
				montId = sc.nextInt();
				break;
			}
			catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("Entrada inválida, digite o ID da montaria para removê-la.");
			}
		}
		
		if (montId == 0)
			return;

		for (Montaria m : montarias) {
			if (m.getId() == montId) {
				montarias.remove(m);
				System.out.println("Montaria removida. ");
				return;
			}
		}
		System.out.println("Não há nenhuma montaria com o ID " + montId + " na base de dados.");
	}

	
	public static void visualizaMontarias(ArrayList<Montaria> montarias) {
		
		if (montarias.size() == 0) {
			System.out.println("\nNão há nenhuma montaria cadastrada na base de dados.");
			return;
		}	
		
		System.out.println();
		
		for (Montaria m : montarias)
			System.out.printf("[%d] %s, %d, %s, %.2f, %s\n", m.getId(), m.getRaca(), m.getCapacidade(),
					m.getCombustivel(), m.getVelocidade(), m.getRaridade());

	}
}