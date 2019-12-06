package venda_montaria.tp1.control;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import venda_montaria.tp1.model.Entidade;
import venda_montaria.tp1.model.Estoque;
import venda_montaria.tp1.model.Montaria;
import venda_montaria.tp1.model.Vendedor;

public class Arquivo {
	
	private static Arquivo uniqueInstance;
	private Gson gson;
	private JsonReader reader;
	Writer writer;
	
	private Arquivo() {
		this.reader = null;
		this.writer = null;
	}
	
	public static Arquivo getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Arquivo();
		return uniqueInstance;
	}
	
	public JsonReader carregaArquivoMontaria(String montariaFileName, ArrayList<Montaria> mont) {
		
		reader = null;
		
		try {
			reader = new JsonReader(new FileReader(montariaFileName));
			mont = gson.fromJson(reader, new TypeToken<ArrayList<Montaria>>() {
			}.getType());
			int max_id = 1;
			for (Montaria m : mont) {
				max_id = Math.max(max_id, m.getId() + 1);
			}
			Montaria.setCont(max_id);
		} 
		catch (FileNotFoundException e) {
			System.out.print("Arquivo não encontrado. Usando base vazia.\n");
		}
		System.out.println(mont.size() + " montarias carregadas da base.");
		return reader;
	}
	
	public JsonReader carregaArquivoVendedor(String vendedorFileName, ArrayList<Vendedor> vend, ArrayList<Montaria> mont) {
		
		reader = null;

		try {
			reader = new JsonReader(new FileReader(vendedorFileName));
			vend = gson.fromJson(reader, new TypeToken<ArrayList<Vendedor>>() {
			}.getType());
			int max_id = 1;
			for (Vendedor v : vend) {
				max_id = Math.max(max_id, v.getId() + 1);
				for(Estoque est : v.getEstoque()) {
					for(Montaria m : mont) {
						if(est.getMontaria().getId()==m.getId()) {
							est.setMontaria(m);
							break;
						}
					}
				}
			}
			Vendedor.setCont(max_id);
		} catch (FileNotFoundException e) {
			System.out.print("Arquivo não encontrado. Usando base vazia.\n");
		}
		System.out.println(vend.size() + " vendedores carregados da base.");
		return reader;
	}
	
	public <T extends Entidade> void salvaArquivo(String path, ArrayList<T> obj) {
		
		Writer writer;
		
		if (!obj.isEmpty()) {
			writer = null;
			try {
				writer = new FileWriter(path);
				gson.toJson(obj, writer);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	
}