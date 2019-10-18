package tp1;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class VendedorInterface  {
	
	public Vendedor criaVendedor(Scanner sc) {
		
		System.out.println("Criando vendedor...");
		System.out.printf("Nome: ");
		String nome = sc.next();
		System.out.printf("Raça: ");
		String raca = sc.next();
		System.out.printf("Idade: ");
		int idade = sc.nextInt();
		System.out.printf("Descrição: ");
		String descricao = sc.next();
		
		return new Vendedor(nome, raca, idade, descricao);
	}
	
	public void menu(ArrayList<Vendedor> vendedores, Scanner sc) {
		
		for (Vendedor v : vendedores) {
			System.out.printf("%d %s, %s, %d\n",  v.getId(), v.getNome(), v.getRaca(), v.getIdade());
		}
		
		System.out.println("Qual operação deseja realizar?");
		System.out.printf("[0] Voltar\n[1] Adicionar Vendedor\n[2] Remove Vendedor\n>>> ");
		int op = sc.nextInt();
		
		switch(op) {
			case 0:
				return;
			case 1:
				criaVendedor(sc);
                                break;
			case 2:
				removeVendedor(vendedores, sc);
                                break;
		}
		
	}
	
	public void removeVendedor(ArrayList<Vendedor> vendedores, Scanner sc) {
		
		while (true) {
			
			System.out.printf("Qual vendedor deseja remover? [Digite 0 para voltar]");
			int vend = sc.nextInt();
	
			if (vend == 0)
				break;
			
			for (Vendedor v : vendedores) {
				if (v.getId() == vend)
					vendedores.remove(v);
			}
		
		}
	}
	
}
