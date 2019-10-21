package tp1;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class MontariaInterface {

	public static Montaria criaMontaria(Scanner sc) {

		System.out.println("Criando Montaria...");
		System.out.printf("Nome: ");
		String nome = sc.next();
		System.out.printf("Raça: ");
		String raca = sc.next();
		System.out.printf("Raridade: ");
		String raridade = sc.next();
		System.out.printf("Capacidade: ");
		int capacidade = sc.nextInt();
		System.out.printf("Velocidade: ");
		float velocidade = sc.nextFloat();
		System.out.printf("Combustivel: ");
		String combustivel = sc.next();
		System.out.printf("Descrição: ");
		String descricao = sc.next();

		return new Montaria(nome, raca, descricao, combustivel, raridade, capacidade, velocidade);
	}

	public static void adicionaMontaria(ArrayList<Montaria> montarias, Scanner sc) {
		Montaria nova_montaria = criaMontaria(sc);
		montarias.add(nova_montaria);
	}

	public static void menu(ArrayList<Montaria> montarias, Scanner sc) {

		while (true) {

			for (Montaria m : montarias) {
				System.out.printf("[%d] %s, %s, %d, %s, %f, %s\n", m.getId(), m.getNome(), m.getRaca(),
						m.getCapacidade(), m.getCombustivel(), m.getVelocidade(), m.getRaridade());
			}

			System.out.println("Qual operação deseja realizar?");
			System.out.printf("[0] Voltar\n[1] Adicionar Montaria\n[2] Remove Montaria\n>>> ");

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
			default:
				System.out.println("Não existe esta opção, por favor digite novamente.");
			}
		}
	}

	public static void removeMontaria(ArrayList<Montaria> montarias, Scanner sc) {

		while (true) {

			System.out.printf("Qual montaria deseja remover? [Digite 0 para voltar] ");
			int mont = sc.nextInt();

			if (mont == 0)
				break;

			for (Montaria m : montarias) {
				if (m.getId() == mont) {
					montarias.remove(m);
					System.out.println("Montaria removido. ");
				}
				break;
			}
		}
	}
	
	public static Montaria selecionaMontaria(ArrayList<Montaria> montarias, Scanner sc){
		System.out.printf("Selecione uma montaria para adicionar ao estoque: ");
		
		int mont = sc.nextInt();

		for (Montaria m : montarias)
			if (v.getId() == mont)
				return m;

		System.out.println("Não existe montaria com este ID.");
		return null;
	
}
