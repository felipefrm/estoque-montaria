package venda_montaria.tp1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;


public class Main {
	// String to use repeat function
	static final String MENU_FR="═",
			MENU_ROOF_RIGHT="╗",
			MENU_ROOF_LEFT="╔",
			MENU_FLOOR_LEFT="╚",
			REQ_ENTRY="⟶ ";
	static final int MENU_FR_SIZE=8;
	public static void main(String[] args) {

		ArrayList<Vendedor> vend = new ArrayList<Vendedor>();
		ArrayList<Montaria> mont = new ArrayList<Montaria>();
		Scanner sc = new Scanner(System.in);
		Gson gson = new Gson();
		JsonReader reader;

		System.out.println(MENU_ROOF_LEFT+MENU_FR.repeat(MENU_FR_SIZE)+"Bases de dados"+MENU_FR.repeat(MENU_FR_SIZE)+MENU_ROOF_RIGHT);
		System.out.print("Nome do arquivo de vendedores "+REQ_ENTRY);
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
			System.out.print("Arquivo não encontrado. Usando base vazia.");
		}

		System.out.print("\nNome do arquivo de montarias "+REQ_ENTRY);
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
			System.out.print("Arquivo não encontrado. Usando base vazia.");
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
