package venda_montaria.tp1.view_graphic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		BufferedImage myPicture = ImageIO.read(new File("/home/felipefrm/Downloads/Saddle.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		
		JButton btArqVendedor = new JButton("Selecionar arquivo de vendedores");
		btArqVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_selecionarArquivo();
			}
		});
		
		JButton btArqMontaria = new JButton("Selecionar arquivo de montarias");
		btArqMontaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_selecionarArquivo();
			}
		});
		
		JLabel lblSistemaDeEstoque = new JLabel("Sistema de Estoque de Montarias");
		lblSistemaDeEstoque.setFont(new Font("Dialog", Font.BOLD, 16));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(161)
							.addComponent(picLabel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(67)
							.addComponent(lblSistemaDeEstoque))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(87)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btArqMontaria, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btArqVendedor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(77, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSistemaDeEstoque)
					.addGap(29)
					.addComponent(picLabel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(btArqVendedor)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btArqMontaria)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		

	}


	private void bt_selecionarArquivo() {
		JFrame explorer = new JFrame("Selecione o arquivo");
		JFileChooser chooser = new JFileChooser();
		explorer.add(chooser);
		chooser.setPreferredSize(new Dimension(800, 600));
		explorer.setPreferredSize(new Dimension(800, 600));
		explorer.setVisible(true);
		int result = chooser.showSaveDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			File f = chooser.getSelectedFile();
			String absPath = f.getAbsolutePath();	
		} 
		else if (result == JFileChooser.CANCEL_OPTION) {
		    System.out.println("Cancel was selected");
		}
	
	}
}
