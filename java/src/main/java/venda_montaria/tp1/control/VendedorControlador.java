package venda_montaria.tp1.control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import venda_montaria.tp1.model.Estoque;
import venda_montaria.tp1.model.Montaria;
import venda_montaria.tp1.model.Vendedor;
import venda_montaria.tp1.view_graphic.EstoqueInterface;
import venda_montaria.tp1.view_graphic.MontariaInterface;
import venda_montaria.tp1.view_graphic.VendedorInterface;

public class VendedorControlador {
	private VendedorInterface interf;
	private ArrayList<Vendedor> modelo;
	private ArrayList<Montaria> montarias;
	public VendedorControlador(VendedorInterface interf, ArrayList<Vendedor> modelo, ArrayList<Montaria> montarias) {
		this.interf = interf;
		this.modelo = modelo;
		this.montarias = montarias;
		
		this.interf.getBtRemover().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_removeActionPerformed();
			}
		});
		
		
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
		
		
		this.interf.getBtEstoque().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_estoqueActionPerformed();
			}
		});
		
		this.interf.getTableVendedor().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	tableVendedorMouseClick(evt);
            }
        });
	}
	
	private void bt_estoqueActionPerformed() {
		for (Vendedor v : modelo) {
			if (v.getId() == Integer.valueOf(interf.getTextID().getText()))
				bt_acessActionPerformed(v);
		}
	}
	
	private void bt_acessActionPerformed(Vendedor v) {
		JFrame frame = new JFrame("Estoque do vendedor " + v.getNome());
		
		EstoqueInterface interfaceEstoque = new EstoqueInterface();
		
		EstoqueControlador controladorMontaria = new EstoqueControlador(interfaceEstoque, v, montarias);
		
		frame.add(interfaceEstoque);
		frame.setBounds(100, 100, 440, 400);
		frame.setResizable(false);
		frame.setVisible(true);
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
		JTable tableVendedor = interf.getTableVendedor();
		try {
			Integer.parseInt(interf.getTextIdade().getText());
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "A idade deve ser um inteiro.");
			return;
		}
		
		Vendedor v  = new Vendedor(interf.getTextNome().getText(), interf.getTextRaca().getText(), Integer.valueOf(interf.getTextIdade().getText()));
		modelo.add(v);
		DefaultTableModel model = (DefaultTableModel)tableVendedor.getModel();
        model.setRowCount(interf.getRowCount());
        interf.setRowCount(interf.getRowCount()+1);
        model.addRow(new Object[]{v.getId(), v.getNome() ,v.getRaca(), v.getIdade()});
	}
	
	private void bt_removeActionPerformed() {
		JTable tableVendedor = interf.getTableVendedor();
		DefaultTableModel model = (DefaultTableModel) tableVendedor.getModel();
		if (tableVendedor.getSelectedRow() == -1) { 
			JOptionPane.showMessageDialog(null, "Selecione o vendedor que deseja remover.");
			return;
		}

		int linha = tableVendedor.getSelectedRow();
		Object id = tableVendedor.getValueAt(linha, 0);
		for (Vendedor v : modelo)
			if (v.getId() == Integer.valueOf(id.toString())) {
				modelo.remove(v);
				break;
			}

		
	    model.removeRow(tableVendedor.getSelectedRow());
	    interf.setRowCount(interf.getRowCount()-1);
	}
	
	private void tableVendedorMouseClick(java.awt.event.MouseEvent evt) {
		JTable tableVendedor = interf.getTableVendedor();
        interf.getTextID().setText(String.valueOf(tableVendedor.getValueAt(tableVendedor.getSelectedRow(), 0)));
        interf.getTextNome().setText(String.valueOf(tableVendedor.getValueAt(tableVendedor.getSelectedRow(), 1)));
        interf.getTextRaca().setText(String.valueOf(tableVendedor.getValueAt(tableVendedor.getSelectedRow(), 2)));
        interf.getTextIdade().setText(String.valueOf(tableVendedor.getValueAt(tableVendedor.getSelectedRow(), 3)));
    }
	
	public void atualizaTabela() {
		JTable tableVendedor = interf.getTableVendedor();
		
		DefaultTableModel model = (DefaultTableModel)tableVendedor.getModel();
		while(model.getRowCount() > 0)
		{
			model.removeRow(0);
		}
		interf.setRowCount(0);
		
		
		for(Vendedor v : modelo) {
			
			model.setRowCount(interf.getRowCount());
			interf.setRowCount(interf.getRowCount()+1);
			
			model.addRow(new Object[]{v.getId(), v.getNome() ,v.getRaca(), v.getIdade()});	
		}
	}
}
