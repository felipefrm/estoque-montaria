package venda_montaria.tp1.control;

import venda_montaria.tp1.view_graphic.HomeInterface;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JLabel;

import venda_montaria.tp1.model.Montaria;
import venda_montaria.tp1.model.Vendedor;

public class HomeControlador {

	private HomeInterface interf;
	private ArrayList<Vendedor> modeloVendedor;
	private ArrayList<Montaria> modeloMontaria;
	private Arquivo arquivo;
	private static String pathVendedor = "./vend";
	private static String pathMontaria = "./mont";
	private MontariaControlador mc;
	private VendedorControlador vc;
	
	
	public HomeControlador(HomeInterface interf, 
			ArrayList<Vendedor> modeloVendedor, 
			ArrayList<Montaria> modeloMontaria,
			MontariaControlador mc, 
			VendedorControlador vc) 
	{
			this.interf = interf;
			this.modeloVendedor = modeloVendedor;
			this.modeloMontaria = modeloMontaria;
			this.mc = mc;
			this.vc = vc;
			
			this.interf.getBtArqVendedor().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bt_selecionarArquivoVendedor();
				}
			});
			
			this.interf.getBtArqVendedor().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bt_selecionarArquivoVendedor(); 
				}
			});
			
			this.interf.getBtArqMontaria().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bt_selecionarArquivoMontaria();
				}
			});
			this.interf.getBtSalvar().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bt_saveActionPerformed();
				}
			});
			arquivo = Arquivo.getInstance();
	}

	private void bt_selecionarArquivoVendedor() {
		JFileChooser chooser = new JFileChooser();
		chooser.setPreferredSize(new Dimension(800, 600));
		int result = chooser.showOpenDialog(interf);
		File f;
		if (result == JFileChooser.APPROVE_OPTION) {
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			f = chooser.getSelectedFile();
			System.out.println(f.getName());
			pathVendedor = f.getName();
			Arquivo arq = Arquivo.getInstance();	
			arq.carregaArquivoVendedor(f.getName(), modeloVendedor, modeloMontaria);
		} 
		vc.atualizaTabela();
	}

	private void bt_selecionarArquivoMontaria() {
		JFileChooser chooser = new JFileChooser();
		chooser.setPreferredSize(new Dimension(800, 600));
		int result = chooser.showOpenDialog(interf);
		File f;
		if (result == JFileChooser.APPROVE_OPTION) {
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			f = chooser.getSelectedFile();
			pathMontaria = f.getName();
			Arquivo arq = Arquivo.getInstance();	
			arq.carregaArquivoMontaria(f.getName(), modeloMontaria);
		} 
		mc.atualizaTabela();
	}

	
	private void bt_saveActionPerformed() {
		Arquivo arq = Arquivo.getInstance();
		arq.salvaArquivo(pathVendedor, modeloVendedor);
		arq.salvaArquivo(pathMontaria, modeloMontaria);
	}
}


