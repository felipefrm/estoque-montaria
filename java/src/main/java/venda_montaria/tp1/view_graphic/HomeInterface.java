package venda_montaria.tp1.view_graphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import venda_montaria.tp1.control.Arquivo;
import venda_montaria.tp1.model.Montaria;
import venda_montaria.tp1.model.Vendedor;

public class HomeInterface extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btArqVendedor = new JButton("Selecionar arquivo de vendedores");
	private JButton btArqMontaria = new JButton("Selecionar arquivo de montarias");
	private JButton btSalvar = new JButton("Salvar");
	
	public JButton getBtArqVendedor(){
		return btArqVendedor;
	}

	public JButton getBtArqMontaria(){
		return btArqMontaria;
	}

	public JButton getBtSalvar(){
		return btSalvar;
	}
	
	
	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public HomeInterface() throws IOException {
		
		initComponents();
		
	}

	public void initComponents() throws IOException {
		
		BufferedImage myPicture = ImageIO.read(new File("src/main/java/venda_montaria/tp1/view_graphic/Saddle.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(161, 43, 125, 166);
		
		btArqVendedor.setBounds(87, 209, 266, 25);
		
		
		btArqMontaria.setBounds(87, 243, 266, 25);
		
		
		JLabel lblSistemaDeEstoque = new JLabel("Sistema de Estoque de Montarias");
		lblSistemaDeEstoque.setBounds(67, 12, 306, 19);
		lblSistemaDeEstoque.setFont(new Font("Dialog", Font.BOLD, 16));
		setLayout(null);
		add(picLabel);
		add(lblSistemaDeEstoque);
		add(btArqMontaria);
		add(btArqVendedor);
		
		btSalvar.setBounds(161, 275, 114, 25);
		add(btSalvar);


	}
	
	

}
