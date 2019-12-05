package venda_montaria.tp1.view_graphic;

import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

public class EstoqueInterface extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textID;
	private JTextField textRaca;
	private JLabel lblQuantidade;
	private JLabel lblPreo;
	private JTextField textQTD;
	private JTextField textPreco;
	private JButton btLimpar;
	private JButton btAdicionar;
	private JButton btEditar;
	private JButton btRemover;
	private JTable tableEstoque;
	private JTable tableMontaria;

	/**
	 * Create the panel.
	 */
	public EstoqueInterface() {
		
		initComponents();
		
	}
	
	private void initComponents() {

		JLabel lblId = new JLabel("ID");
		JLabel lblRaa = new JLabel("Raça");
		
		
		textID = new JTextField();
		textID.setBackground(SystemColor.control);
		textID.setEditable(false);
		textID.setColumns(10);
		
		
		textRaca = new JTextField();
		textRaca.setColumns(10);
		
		lblQuantidade = new JLabel("Quantidade");
		
		lblPreo = new JLabel("Preço");
		
		textQTD = new JTextField();
		textQTD.setColumns(10);
		
		textPreco = new JTextField();
		textPreco.setColumns(10);
		
		btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_limparActionPerformed(e);
			}
		});
		
		btAdicionar = new JButton("Adicionar");
		btAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_addActionPerformed();
			}
		});
		
		btEditar = new JButton("Editar");
		btEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_editActionPerformed();
			}
		});
		
		btRemover = new JButton("Remover");
		btRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_removeActionPerformed();
			}
		});
		
		tableEstoque = new JTable();
		tableEstoque.setModel(new DefaultTableModel(
				new Object [][] {

	            },
	            new String [] {
	                "ID", "Raça", "Quantidade", "Preço"
	            }
	       	));
			JScrollPane scrollE = new JScrollPane(tableEstoque);
			scrollE.setViewportView(tableEstoque);
			add(scrollE);

		
		tableMontaria = new JTable();
		tableMontaria.setModel(new DefaultTableModel(
				new Object [][] {

	            },
	            new String [] {
	                "ID", "Raça"
	            }
	       	));
			JScrollPane scrollM = new JScrollPane(tableMontaria);
			scrollM.setViewportView(tableMontaria);
			add(scrollM);

		
		JLabel lblNewLabel = new JLabel("Estoque do Vendedor ");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(tableEstoque, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblId)
											.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
											.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblRaa)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textRaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblQuantidade)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textQTD, 0, 0, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblPreo)
											.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
											.addComponent(textPreco, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btEditar, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
										.addComponent(btAdicionar, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
										.addComponent(btRemover, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
										.addComponent(btLimpar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addComponent(lblNewLabel))
							.addGap(29)
							.addComponent(tableMontaria, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblId)
								.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btLimpar))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRaa)
								.addComponent(textRaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btAdicionar))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btEditar)
									.addPreferredGap(ComponentPlacement.UNRELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textQTD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblQuantidade))
									.addGap(4)))
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btRemover)
								.addComponent(lblPreo)
								.addComponent(textPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(tableMontaria, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(tableEstoque, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

		
	}
	
	private void bt_limparActionPerformed(ActionEvent evt) {

		Component[] components = getComponents();
		for (Component c : components) {
			  if (c instanceof JTextField) {         
				  	JTextField field = (JTextField) c;   
	                field.setText("");   
			  }
		}
	}
	
	private void bt_addActionPerformed() {
		
	}
	
	private void bt_removeActionPerformed() {
		
	}
	
	private void bt_editActionPerformed() {
		
	}
}
