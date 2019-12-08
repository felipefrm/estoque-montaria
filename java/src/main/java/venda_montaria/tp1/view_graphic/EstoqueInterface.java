package venda_montaria.tp1.view_graphic;

import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import venda_montaria.tp1.model.Estoque;
import venda_montaria.tp1.model.Montaria;
import venda_montaria.tp1.model.Vendedor;

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
	private static int rowCount;
	
	public void setRowCount(int count) {
		rowCount = count;
	}
	
	public int getRowCount() {
		return rowCount;
	}
		
	/**
	 * Create the panel.
	 */
	
	
	public EstoqueInterface(Vendedor v, ArrayList<Montaria> mont) {

		setRowCount(0);
		initComponents(v, mont);
		
	}
	
	private void initComponents(Vendedor v, ArrayList<Montaria> mont) {

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
				bt_addActionPerformed(v, mont);
			}
		});
		
		btEditar = new JButton("Editar");
		btEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_editActionPerformed(v);
			}
		});
		
		btRemover = new JButton("Remover");
		btRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_removeActionPerformed(v);
			}
		});
		
		tableEstoque = new JTable();
		tableEstoque.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
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

		DefaultTableModel modelEstoque = (DefaultTableModel) tableEstoque.getModel();
		for (Estoque e : v.getEstoque()) {
			modelEstoque.addRow(new Object[]{e.getMontaria().getId(), e.getMontaria().getRaca(), e.getQuantidade(), e.getPreco()});
		}

		
		tableEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tableEstoqueMouseClick(evt);
        	}
        });
		
		tableMontaria = new JTable();
		tableMontaria.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
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

		DefaultTableModel modelMontaria = (DefaultTableModel) tableMontaria.getModel();
		for (Montaria m : mont) {
			modelMontaria.addRow(new Object[]{m.getId(), m.getRaca()});
		}

		tableMontaria.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tableMontariaMouseClick(evt);
        	}
        });

		
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
	
	private void bt_addActionPerformed(Vendedor v, ArrayList<Montaria> mont) {		
		
		int linha = tableMontaria.getSelectedRow();
		Object id = tableMontaria.getValueAt(linha, 0);

		for (Estoque e : v.getEstoque())
			if (e.getMontaria().getId() == Integer.valueOf(id.toString())) {
				JOptionPane.showMessageDialog(null, "Montaria já existe no estoque.");			
				return;
			}
		
		for (Montaria m : mont)
			if (m.getId() == Integer.valueOf(id.toString())) {
				try {
					Integer.parseInt(textQTD.getText());
					Float.parseFloat(textPreco.getText());
				} catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "A quantidade deve ser um número inteiro e o preco um número real.");
					return;
				}
			
				v.getEstoque().add(new Estoque(m, Integer.valueOf(textQTD.getText()), Float.valueOf(textPreco.getText())));
				DefaultTableModel model = (DefaultTableModel)tableEstoque.getModel();
		        model.setRowCount(rowCount++);
		        model.addRow(new Object[]{m.getId(), m.getRaca(), Integer.valueOf(textQTD.getText()), Float.valueOf(textPreco.getText())});
				break;
			}
		
	
	}	
	
	private void bt_removeActionPerformed(Vendedor v) {
		DefaultTableModel model = (DefaultTableModel) tableEstoque.getModel();
		if (tableEstoque.getSelectedRow() == -1) { 
			JOptionPane.showMessageDialog(null, "Selecione a montaria que deseja remover do estoque.");
			return;
		}

		int linha = tableEstoque.getSelectedRow();
		Object id = tableEstoque.getValueAt(linha, 0);
		for (Estoque e : v.getEstoque())
			if (e.getMontaria().getId() == Integer.valueOf(id.toString())) {
				v.getEstoque().remove(e);
				break;
			}

	    model.removeRow(linha);
	    rowCount--;

	}
	
	private void bt_editActionPerformed(Vendedor v) {
		
		try {
			Integer.parseInt(textQTD.getText());
			Float.parseFloat(textPreco.getText());
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "A quantidade deve ser um número inteiro e o preco um número real.");
			return;
		}
		
		if (tableEstoque.getSelectedRow() == -1) { 
			JOptionPane.showMessageDialog(null, "Selecione a montaria que deseja editar o estoque.");
			return;
		}

		
		int linha = tableEstoque.getSelectedRow();
		Object id = tableEstoque.getValueAt(linha, 0);
		tableEstoque.setValueAt(textQTD.getText(), linha, 2);
		tableEstoque.setValueAt(textPreco.getText(), linha, 3);
		for (Estoque e : v.getEstoque())
			if (e.getMontaria().getId() == Integer.valueOf(id.toString())) {
				e.setQuantidade(Integer.valueOf(textQTD.getText()));
				e.setPreco(Integer.valueOf(textPreco.getText()));
				break;
			}

	}
	
	 private void tableEstoqueMouseClick(java.awt.event.MouseEvent evt) {
        textID.setText(String.valueOf(tableEstoque.getValueAt(tableEstoque.getSelectedRow(), 0)));
        textRaca.setText(String.valueOf(tableEstoque.getValueAt(tableEstoque.getSelectedRow(), 1)));
        textQTD.setText(String.valueOf(tableEstoque.getValueAt(tableEstoque.getSelectedRow(), 2)));
        textPreco.setText(String.valueOf(tableEstoque.getValueAt(tableEstoque.getSelectedRow(), 3)));

	 }	

	 private void tableMontariaMouseClick(java.awt.event.MouseEvent evt) {
	        textID.setText(String.valueOf(tableMontaria.getValueAt(tableMontaria.getSelectedRow(), 0)));
	        textRaca.setText(String.valueOf(tableMontaria.getValueAt(tableMontaria.getSelectedRow(), 1)));
		 }	

	 
}
