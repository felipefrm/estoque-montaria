package tp1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		ArrayList<Vendedor> vend = new ArrayList();
		ArrayList<Montaria> mont = new ArrayList();
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("MENU:");
			System.out.printf("[0] Fechar programa\n[1] Vendedor\n[2] Montaria\n>>> ");

			int op = sc.nextInt();

			switch (op) {
			case 0:
				return;
			case 1:

				VendedorInterface.menu(vend, new Scanner(System.in));
				break;
			case 2:

				MontariaInterface.menu(mont, new Scanner(System.in));
				break;
			default:
				System.out.println("Não há esta opção, por favor digite novamente.");

			}
		}
	}
}
