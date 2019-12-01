package venda_montaria.tp1.view_graphic;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;

public class menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel modeloTabelaVendedor;
	private DefaultTableModel modeloTabelaMontaria;
	private JTable tableVendedor;
	private JTable tableMontaria; 
	JTextField myTitle;//can be used anywhere in this class

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public menu() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Home", null, panel, null);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		BufferedImage myPicture = ImageIO.read(new File("/home/felipefrm/Downloads/Saddle.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		panel.add(picLabel);
		
		JPanel panelVendedor = new JPanel();
		tabbedPane.addTab("Vendedor", null, panelVendedor, null);
		
		JButton btnNewButton = new JButton("Adicionar Vendedor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel add = new JPanel();
//				add.setBorder(new EmptyBorder(5, 5, 5, 5));
//				add.setLayout(new BorderLayout(0, 0));
//				add.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//				EventQueue.invokeLater(new Runnable() {
//			        public void run() {
//			            try {
//			                menu add = new menu();
//			                add.setVisible(true);
//			            } catch (Exception e) {
//			                e.printStackTrace();
//			            }
//			        }
//			    });
				add.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		panelVendedor.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelVendedor.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remover Vendedor");
		panelVendedor.add(btnNewButton_1);
		
		JButton btnAcessar = new JButton("Acessar estoque de um Vendedor");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelVendedor.add(btnAcessar);
		
		modeloTabelaVendedor = new DefaultTableModel();		
		modeloTabelaVendedor.addColumn("ID");
		modeloTabelaVendedor.addColumn("Nome");
		modeloTabelaVendedor.addColumn("Raça");
		modeloTabelaVendedor.addColumn("Idade");
		tableVendedor = new JTable(modeloTabelaVendedor);		
		
		tableVendedor.setPreferredSize(new Dimension(580, 400));
		tableVendedor.getColumnModel().getColumn(0).setMaxWidth(40);
//		tableVendedor.getColumnModel().getColumn(1).setMaxWidth(180);
//		tableVendedor.getColumnModel().getColumn(2).setMaxWidth(180);
		tableVendedor.getColumnModel().getColumn(3).setMaxWidth(80);
		panelVendedor.add(tableVendedor);
		
		JScrollPane scrollV = new JScrollPane();
		scrollV.setViewportView(tableVendedor);
		panelVendedor.add(scrollV);
		
		
		JPanel panelMontaria = new JPanel();
		tabbedPane.addTab("Montaria", null, panelMontaria, null);
		panelMontaria.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAdicionarMontaria = new JButton("Adicionar Montaria");
		panelMontaria.add(btnAdicionarMontaria);
		
		JButton btnRemoverMontaria = new JButton("Remover Montaria");
		panelMontaria.add(btnRemoverMontaria);
		
		modeloTabelaMontaria = new DefaultTableModel();		
		modeloTabelaMontaria.addColumn("ID");
		modeloTabelaMontaria.addColumn("Raça");
		modeloTabelaMontaria.addColumn("Raridade");
		modeloTabelaMontaria.addColumn("Capacidade");
		modeloTabelaMontaria.addColumn("Velocidade");
		modeloTabelaMontaria.addColumn("Combustivel");
		
		tableMontaria = new JTable(modeloTabelaMontaria);
		panelMontaria.add(tableMontaria);
		
		tableMontaria.setPreferredSize(new Dimension(580, 400));
		tableMontaria.getColumnModel().getColumn(0).setMaxWidth(40);
		panelMontaria.add(tableMontaria);
		
		JScrollPane scrollM = new JScrollPane();
		scrollM.setViewportView(tableMontaria);
		panelMontaria.add(scrollM);

	}
}
