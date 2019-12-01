package venda_montaria.tp1.view_terminal;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import venda_montaria.tp1.model.Estoque;
import venda_montaria.tp1.model.Montaria;

public abstract class EstoqueInterface {

	public static void menu(ArrayList<Estoque> estoques, String nome, ArrayList<Montaria> montarias, Scanner sc) {

		while (true) {

			int op;
			while (true) {
				System.out.println("\n╔════════ MENU DO VENDEDOR " + nome.toUpperCase() + " ════════╗");
				System.out.printf("╠0 Voltar\n╠1 Adicionar nova montaria ao estoque\n╠2 Editar o estoque de uma montaria existente\n╠3 Remover uma montaria do estoque\n╚4 Visualizar estoque\n⟶ ");
				
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
	

	public static void adicionaEstoque(ArrayList<Estoque> estoques, ArrayList<Montaria> montarias, Scanner sc) {
		System.out.println("\nMontarias disponíveis:\n");
		
		if (montarias.size() == 0) {
			System.out.println("Não há nenhuma montaria na base de dados.");
			return;
		}
		
		else {
			for (Montaria m : montarias)
				System.out.printf("[%d] %s\n", m.getId(), m.getRaca());
	
			int montId;
			while (true) {
				System.out.printf("\nSelecione uma montaria para adicionar ao estoque [Digite 0 para voltar]: ");
				try {
					montId = sc.nextInt();
					break;
				}
				catch(InputMismatchException e) {
					sc.nextLine();
					System.out.println("Entrada inválida, insira o ID da montaria que deseja adicionar ao estoque.");
				}
			}
			
			if (montId == 0)
				return;
			
			for (Estoque e : estoques)
				if (e.getMontaria().getId() == montId) {
					System.out.println("Montaria já existe no estoque.");
					return;
				}

			int flag = 0;
			Montaria monta = new Montaria();
			for (Montaria m : montarias) {
				if (m.getId() == montId) {
					flag = 1;
					monta = m;
					break;
				}
			}
			
			if (flag == 0) {
				System.out.println("Não há nenhuma montaria com o ID " + montId + " na base de dados.");
				return;
			}
			
			float preco;
			while (true) {
				System.out.printf("Preço: U$");
				try {
					preco = sc.nextFloat();
					break;
				}
				catch(InputMismatchException e) {
					sc.nextLine();
					System.out.println("Entrada inválida, insira um número real para o preço da montaria.");
				}
			}
			
			int qtd;
			while (true) {
				System.out.printf("Quantidade: ");
				try {
					qtd = sc.nextInt();
					break;
				}
				catch(InputMismatchException e) {
					sc.nextLine();
					System.out.println("Entrada inválida, insira um número inteiro para a quantidade da montaria no estoque.");
				}
			}

			
			estoques.add(new Estoque(monta, qtd, preco));
		}
	}



	public static void editaEstoque(ArrayList<Estoque> estoques, Scanner sc) {

	
		int idEscolha;
		while (true) {
			try {
				System.out.printf("\nEscolha uma montaria para editar o estoque [Digite 0 para voltar]: ");
				idEscolha = sc.nextInt();
				break;
			}
			catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("Entrada inválida, insira o ID da montaria que deseja remover do estoque.");			
			}
		}
	
		
		if (idEscolha == 0)
			return;

		int flag = 0;
		for (Estoque e : estoques) {
			if (e.getMontaria().getId() == idEscolha) {
				flag = 1;
				
				while (true) {
					
					int op;
					while (true) {
						System.out.println("\n╔════════ MENU DE EDIÇÃO ════════╗");
						System.out.printf("╠0 Voltar\n╠1 Editar quantidade\n╚2 Editar preço\n⟶ ");
						try {
							op = sc.nextInt();
							break;
						}
						catch(InputMismatchException ex) {
							sc.nextLine();
							System.out.printf("Entrada inválida, por favor escolha uma das opções.\n ");
						}
					}

					switch (op) {

					case 1:
						System.out.printf("\nAtual quantidade: " + e.getQuantidade());
						System.out.printf("\nNova quantidade: ");
						
						int qtd;
						while (true) {
							try {
								qtd = sc.nextInt();
								break;
							}
							catch(InputMismatchException exc) {
								sc.nextLine();
								System.out.printf("Entrada inválida, insira um número inteiro para a quantidade.\nNova quantidade: ");
							}
						}
						
						e.setQuantidade(qtd);
						System.out.println("Quantidade alterada com sucesso!");
						break;

					case 2:
						System.out.printf("\nAtual preço: U$" + e.getPreco());
						System.out.printf("\nNovo preço: U$");
						
						float preco;
						while (true) {
							try {
								preco = sc.nextFloat();
								break;
							}
							catch(InputMismatchException exce) {
								sc.nextLine();
								System.out.printf("Entrada inválida, insira um número real para o preço da montaria.\nNovo preço: ");
							}
						}
						
						e.setPreco(preco);
						System.out.println("Preço alterado com sucesso!");
						break;

					case 0:
						return;

					default:
						System.out.println("\nNão há esta opção, por favor digite novamente.");
					}
				}
			}
		}
		if (flag == 0)
			System.out.println("Esta montaria não está contida no estoque deste vendedor.");
	}

	
	public static void removeEstoque(ArrayList<Estoque> estoques, Scanner sc) {

		int idEscolha;
		while (true) {
			try {
				System.out.printf("\nEscolha uma montaria para remover do estoque [Digite 0 para voltar]: ");
				idEscolha = sc.nextInt();
				break;
			}
			catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("Entrada inválida, insira o ID da montaria que deseja remover do estoque.");				
			}
		}
		
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
