package venda_montaria.tp1.view_graphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeInterface extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		
		JLabel lblOk_1 = new JLabel("OK!");
		lblOk_1.setForeground(new Color(51, 204, 0));
		lblOk_1.setBounds(360, 214, 66, 15);
		lblOk_1.setVisible(false);
		add(lblOk_1);
		
		JLabel lblOk_2 = new JLabel("OK!");
		lblOk_2.setForeground(new Color(0, 204, 0));
		lblOk_2.setBounds(360, 248, 66, 15);
		lblOk_2.setVisible(false);
		add(lblOk_2);
		
		JButton btArqVendedor = new JButton("Selecionar arquivo de vendedores");
		btArqVendedor.setBounds(87, 209, 266, 25);
		btArqVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bt_selecionarArquivo()) {
					lblOk_1.setVisible(true);
				}
			}
		});
		
		JButton btArqMontaria = new JButton("Selecionar arquivo de montarias");
		btArqMontaria.setBounds(87, 243, 266, 25);
		btArqMontaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bt_selecionarArquivo()) {
					lblOk_2.setVisible(true);
				}
			}
		});
		
		JLabel lblSistemaDeEstoque = new JLabel("Sistema de Estoque de Montarias");
		lblSistemaDeEstoque.setBounds(67, 12, 306, 19);
		lblSistemaDeEstoque.setFont(new Font("Dialog", Font.BOLD, 16));
		setLayout(null);
		add(picLabel);
		add(lblSistemaDeEstoque);
		add(btArqMontaria);
		add(btArqVendedor);
		
		JButton btSalvar = new JButton("Salvar");
		btSalvar.setBounds(161, 275, 114, 25);
		add(btSalvar);
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_saveActionPerformed();
			}
		});

	}
	
	
	private boolean bt_selecionarArquivo() {
		JFileChooser chooser = new JFileChooser();
		chooser.setPreferredSize(new Dimension(800, 600));
		int result = chooser.showOpenDialog(this);
		boolean control = false;
		if (result == JFileChooser.APPROVE_OPTION) {
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			File f = chooser.getSelectedFile();
			System.out.println(f.getName());
			String absPath = f.getAbsolutePath();
			System.out.println(absPath);
			control = true;
		} 
		else if (result == JFileChooser.CANCEL_OPTION) {
		    System.out.println("Cancel was selected");
		}
		return control;
	}
	
	private void bt_saveActionPerformed() {
		
	}
}
