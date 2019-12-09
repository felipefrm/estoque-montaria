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
	
	public HomeControlador(HomeInterface interf, ArrayList<Vendedor> modeloVendedor, 
			ArrayList<Montaria> modeloMontaria) {
			this.interf = interf;
			this.modeloVendedor = modeloVendedor;
			this.modeloMontaria = modeloMontaria;
			
			this.interf.getBtArqVendedor().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bt_selecionarArquivoVendedor();
				}
			});
	

	private void bt_selecionarArquivoVendedor() {
		JFileChooser chooser = new JFileChooser();
		chooser.setPreferredSize(new Dimension(800, 600));
		int result = chooser.showOpenDialog(this);
		boolean control = false;
		File f;
		if (result == JFileChooser.APPROVE_OPTION) {
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			f = chooser.getSelectedFile();
			System.out.println(f.getName());
			pathVendedor = f.getName();
			control = true;
			Arquivo arq = Arquivo.getInstance();	
			arq.carregaArquivoVendedor(f.getName(), vend, mont);
			lbl.setVisible(true);
		} 
		
		return control;
	}

	private boolean bt_selecionarArquivoMontaria() {
		JFileChooser chooser = new JFileChooser();
		chooser.setPreferredSize(new Dimension(800, 600));
		int result = chooser.showOpenDialog(this);
		boolean control = false;
		File f;
		if (result == JFileChooser.APPROVE_OPTION) {
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			f = chooser.getSelectedFile();
			pathMontaria = f.getName();
			control = true;
			Arquivo arq = Arquivo.getInstance();	
			arq.carregaArquivoMontaria(f.getName(), mont);
			lbl.setVisible(true);
		} 
		
		return control;
	}

	
	private void bt_saveActionPerformed() {
		Arquivo arq = Arquivo.getInstance();
		arq.salvaArquivo(pathVendedor, vend);
		arq.salvaArquivo(pathMontaria, mont);
	}
}


