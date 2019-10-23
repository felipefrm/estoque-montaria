package venda_montaria.tp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class Main {

	public static void main(String[] args) {

		ArrayList<Vendedor> vend = new ArrayList<Vendedor>();
		ArrayList<Montaria> mont = new ArrayList<Montaria>();
		Scanner sc = new Scanner(System.in);
		Gson gson = new Gson();
		JsonReader reader;

		System.out.println("Nome do arquivo com a base de dados de vendedor e montaria: ");
		System.out.print("Arquivo vendedor:");
		String vendedorFileName = sc.next();

		reader = null;

		try {
			reader = new JsonReader(new FileReader(vendedorFileName));
			vend = gson.fromJson(reader, new TypeToken<ArrayList<Vendedor>>() {
			}.getType());
			int max_id = 1;
			for (Vendedor v : vend) {
				max_id = Math.max(max_id, v.getId() + 1);
			}
			Vendedor.setCont(max_id);
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado. Usando base vazia.");
		}

		System.out.print("\nArquivo montaria:");
		String montariaFileName = sc.next();
		reader = null;

		try {
			reader = new JsonReader(new FileReader(montariaFileName));
			mont = gson.fromJson(reader, new TypeToken<ArrayList<Montaria>>() {
			}.getType());
			int max_id = 1;
			for (Montaria m : mont) {
				max_id = Math.max(max_id, m.getId());
			}
			Montaria.setCont(max_id);
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado. Usando base vazia.");
		}

		System.out.println();

		while (true) {

			System.out.println("MENU:");
			System.out.printf("[0] Fechar programa\n[1] Vendedor\n[2] Montaria\n>>> ");

			int op = sc.nextInt();

			switch (op) {
			case 0:

				Writer writer;
				if (!vend.isEmpty()) {
					writer = null;
					try {
						writer = new FileWriter(vendedorFileName);
						gson.toJson(vend, writer);
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				if (!mont.isEmpty()) {
					writer = null;
					try {
						writer = new FileWriter(montariaFileName);
						gson.toJson(mont, writer);
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				return;
			case 1:

				VendedorInterface.menu(vend, mont, sc);
				break;
			case 2:

				MontariaInterface.menu(mont, sc);
				break;
			default:
				System.out.println("Não há esta opção, por favor digite novamente.");

			}
		}
	}
}
