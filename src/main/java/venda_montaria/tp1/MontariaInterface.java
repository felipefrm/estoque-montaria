package venda_montaria.tp1;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class MontariaInterface {

	public static Montaria criaMontaria(Scanner sc) {

		System.out.println("Criando Montaria...");
		System.out.printf("Nome: ");
		String nome = sc.nextLine();
		System.out.printf("Raça: ");
		String raca = sc.nextLine();
		System.out.printf("Raridade: ");
		String raridade = sc.nextLine();
		System.out.printf("Capacidade: ");
		int capacidade = sc.nextInt();
		System.out.printf("Velocidade: ");
		float velocidade = sc.nextFloat();
		System.out.printf("Combustivel: ");
		String combustivel = sc.nextLine();
		System.out.printf("Descrição: ");
		String descricao = sc.nextLine();

		return new Montaria(nome, raca, descricao, combustivel, raridade, capacidade, velocidade);
	}

	public static void menu(ArrayList<Montaria> montarias, Scanner sc) {

		while (true) {

//			visualizaMontarias(montarias);

			System.out.println("Qual operação deseja realizar?");
			System.out
					.printf("[0] Voltar\n[1] Adicionar Montaria\n[2] Remover Montaria\n[3] Visualizar Montarias\n>>> ");

			int op = sc.nextInt();

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
			default:
				System.out.println("Não existe esta opção, por favor digite novamente.");
			}
		}
	}

	public static void removeMontaria(ArrayList<Montaria> montarias, Scanner sc) {

		while (true) {

			System.out.printf("Qual montaria deseja remover? [Digite 0 para voltar] ");
			int montId = sc.nextInt();

			if (montId == 0)
				break;

			for (Montaria m : montarias) {
				if (m.getId() == montId) {
					montarias.remove(m);
					System.out.println("Montaria removida. ");
				}
				System.out.printf("Não há nenhuma montaria com o ID " + montId + ".");
				break;
			}
		}
	}

	public static void adicionaMontaria(ArrayList<Montaria> montarias, Scanner sc) {
		Montaria nova_montaria = criaMontaria(sc);
		montarias.add(nova_montaria);
	}

	public static void visualizaMontarias(ArrayList<Montaria> montarias) {
		for (Montaria m : montarias)
			System.out.printf("[%d] %s, %d, %s, %.2f, %s\n", m.getId(), m.getRaca(), m.getCapacidade(),
					m.getCombustivel(), m.getVelocidade(), m.getRaridade());

	}
}