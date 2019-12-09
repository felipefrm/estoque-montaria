package venda_montaria.tp1.control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import venda_montaria.tp1.model.Estoque;
import venda_montaria.tp1.model.Montaria;
import venda_montaria.tp1.model.Vendedor;
import venda_montaria.tp1.view_graphic.EstoqueInterface;


public class EstoqueControlador {
	private EstoqueInterface interf;
	private ArrayList<Montaria> montarias;
	private Vendedor vendedor;
	public EstoqueControlador(EstoqueInterface interf, Vendedor vendedor, ArrayList<Montaria> montarias) {
		super();
		this.interf = interf;
		this.montarias = montarias;
		this.vendedor = vendedor;
		
		DefaultTableModel modelMontaria = (DefaultTableModel) interf.getTableMontaria().getModel();
		DefaultTableModel modelEstoque = (DefaultTableModel) interf.getTableEstoque().getModel();
		
		
		for (Estoque e : this.vendedor.getEstoque()) {
			modelEstoque.addRow(new Object[]{e.getMontaria().getId(), e.getMontaria().getRaca(), e.getQuantidade(), e.getPreco()});
		}
		
		for (Montaria m : this.montarias) {
			modelMontaria.addRow(new Object[]{m.getId(), m.getRaca()});
		}
		
		
		this.interf.getBtLimpar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_limparActionPerformed();
			}
		});
		
		this.interf.getBtAdicionar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_addActionPerformed();
			}
		});
		
		
		this.interf.getBtEditar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_editActionPerformed();
			}
		});
		
		
		this.interf.getBtRemover().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_removeActionPerformed();
			}
		});
		
		this.interf.getTableEstoque().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tableEstoqueMouseClick();
        	}
        });
		
		this.interf.getTableMontaria().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tableMontariaMouseClick();
        	}
        });
	}
	
	private void bt_limparActionPerformed() {

		Component[] components = interf.getComponents();
		for (Component c : components) {
			  if (c instanceof JTextField) {         
				  	JTextField field = (JTextField) c;   
	                field.setText("");   
			  }
		}
	}
	
	private void bt_addActionPerformed() {		
		JTable tableMontaria = interf.getTableMontaria();
		JTable tableEstoque = interf.getTableMontaria();
		int linha = tableMontaria.getSelectedRow();
		Object id = tableMontaria.getValueAt(linha, 0);

		for (Estoque e : vendedor.getEstoque())
			if (e.getMontaria().getId() == Integer.valueOf(id.toString())) {
				JOptionPane.showMessageDialog(null, "Montaria já existe no estoque.");			
				return;
			}
		
		for (Montaria m : montarias)
			if (m.getId() == Integer.valueOf(id.toString())) {
				try {
					Integer.parseInt(interf.getTextQTD().getText());
					Float.parseFloat(interf.getTextPreco().getText());
				} catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "A quantidade deve ser um número inteiro e o preco um número real.");
					return;
				}
			
				vendedor.getEstoque().add(new Estoque(m, Integer.valueOf(interf.getTextQTD().getText()), Float.valueOf(interf.getTextPreco().getText())));
				DefaultTableModel model = (DefaultTableModel)tableEstoque.getModel();
		        model.setRowCount(interf.getRowCount());
		        interf.setRowCount(interf.getRowCount()+1);
		        model.addRow(new Object[]{m.getId(), 
		        		m.getRaca(), 
		        		Integer.valueOf(interf.getTextQTD().getText()),
		        		Float.valueOf(interf.getTextPreco().getText())});
				break;
			}
		
	
	}	
	
	private void bt_removeActionPerformed() {
		JTable tableEstoque = interf.getTableEstoque();
		
		DefaultTableModel model = (DefaultTableModel) tableEstoque.getModel();
		if (tableEstoque.getSelectedRow() == -1) { 
			JOptionPane.showMessageDialog(null, "Selecione a montaria que deseja remover do estoque.");
			return;
		}

		int linha = tableEstoque.getSelectedRow();
		Object id = tableEstoque.getValueAt(linha, 0);
		for (Estoque e : vendedor.getEstoque())
			if (e.getMontaria().getId() == Integer.valueOf(id.toString())) {
				vendedor.getEstoque().remove(e);
				break;
			}

	    model.removeRow(linha);
	    interf.setRowCount(interf.getRowCount()-1);

	}
	
	private void bt_editActionPerformed() {
		JTable tableEstoque = interf.getTableEstoque();
		try {
			Integer.parseInt(interf.getTextQTD().getText());
			Float.parseFloat(interf.getTextPreco().getText());
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
		tableEstoque.setValueAt(interf.getTextQTD().getText(), linha, 2);
		tableEstoque.setValueAt(interf.getTextPreco().getText(), linha, 3);
		for (Estoque e : vendedor.getEstoque())
			if (e.getMontaria().getId() == Integer.valueOf(id.toString())) {
				e.setQuantidade(Integer.valueOf(interf.getTextQTD().getText()));
				e.setPreco(Integer.valueOf(interf.getTextPreco().getText()));
				break;
			}

	}
	
	 private void tableEstoqueMouseClick() {
		 JTable tableEstoque = interf.getTableEstoque();
		 interf.getTextID().setText(String.valueOf(tableEstoque.getValueAt(tableEstoque.getSelectedRow(), 0)));
		 interf.getTextRaca().setText(String.valueOf(tableEstoque.getValueAt(tableEstoque.getSelectedRow(), 1)));
		 interf.getTextQTD().setText(String.valueOf(tableEstoque.getValueAt(tableEstoque.getSelectedRow(), 2)));
		 interf.getTextPreco().setText(String.valueOf(tableEstoque.getValueAt(tableEstoque.getSelectedRow(), 3)));
	 }	

	 private void tableMontariaMouseClick() {
		 	JTable tableMontaria = interf.getTableMontaria();
	        interf.getTextID().setText(String.valueOf(tableMontaria.getValueAt(tableMontaria.getSelectedRow(), 0)));
	        interf.getTextRaca().setText(String.valueOf(tableMontaria.getValueAt(tableMontaria.getSelectedRow(), 1)));
	}	
}
