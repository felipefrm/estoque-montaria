package venda_montaria.tp1.control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import venda_montaria.tp1.model.Montaria;
import venda_montaria.tp1.view_graphic.MontariaInterface;

public class MontariaControlador {
	private MontariaInterface interf;
	private ArrayList<Montaria> modelo;
	
	public MontariaControlador(MontariaInterface interf, ArrayList<Montaria> modelo) {
		this.interf = interf;
		this.modelo = modelo;
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
		this.interf.getBtRemover().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_removeActionPerformed();
			}
		});
		
		this.interf.getTableMontaria().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	tableMontariaMouseClick(evt);
            	
            }
        });
		
	}
	
	private void bt_limparActionPerformed() {
		interf.getTextID().setText("");;
		interf.getTextRaca().setText("");
		interf.getTextCapacidade().setText("");
		interf.getTextVelocidade().setText("");
		interf.getTextRaridade().setText("");
		interf.getTextCombustivel().setText("");
	}
	
	private void bt_addActionPerformed() {
		try {
			Integer.parseInt(interf.getTextCapacidade().getText());
			Float.parseFloat(interf.getTextVelocidade().getText());

		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O campo capacidade deve ser um número inteiro e o campo velocidade deve ser um número real.");
			return;
		}
	
		Montaria m  = new Montaria(interf.getTextRaca().getText(), 
				interf.getTextCombustivel().getText(), 
				interf.getTextRaridade().getText(), 
				Integer.valueOf(interf.getTextCapacidade().getText()),  
				Float.valueOf(interf.getTextVelocidade().getText()));
        modelo.add(m);
		DefaultTableModel model = (DefaultTableModel)interf.getTableMontaria().getModel();
        
		model.setRowCount(MontariaInterface.getRowCount());
		MontariaInterface.setRowCount(MontariaInterface.getRowCount()+1);
		
        model.addRow(new Object[]{m.getId(), m.getRaca(), m.getCombustivel(), m.getRaridade(), m.getCapacidade(), m.getVelocidade()});
	}
	
	private void bt_removeActionPerformed() {
		JTable tableMontaria = interf.getTableMontaria();
		
		DefaultTableModel model = (DefaultTableModel) tableMontaria.getModel();
		if (tableMontaria.getSelectedRow() == -1) { 
			JOptionPane.showMessageDialog(null, "Selecione a montaria que deseja remover.");
			return;
		}
		int linha = tableMontaria.getSelectedRow();
		Object id = tableMontaria.getValueAt(linha, 0);
		for (Montaria m : modelo)
			if (m.getId() == Integer.valueOf(id.toString())) {
				modelo.remove(m);
				break;
			}
		model.removeRow(tableMontaria.getSelectedRow());
		MontariaInterface.setRowCount(MontariaInterface.getRowCount()-1);
	}
	
	private void tableMontariaMouseClick(java.awt.event.MouseEvent evt) {
		JTable tableMontaria = interf.getTableMontaria();
		interf.getBtRemover().setEnabled(true);
		interf.getTextID().setText(String.valueOf(tableMontaria.getValueAt(tableMontaria.getSelectedRow(), 0)));
		interf.getTextRaca().setText(String.valueOf(tableMontaria.getValueAt(tableMontaria.getSelectedRow(), 1)));
		interf.getTextCombustivel().setText(String.valueOf(tableMontaria.getValueAt(tableMontaria.getSelectedRow(), 2)));
		interf.getTextRaridade().setText(String.valueOf(tableMontaria.getValueAt(tableMontaria.getSelectedRow(), 3)));
		interf.getTextCapacidade().setText(String.valueOf(tableMontaria.getValueAt(tableMontaria.getSelectedRow(), 4)));
		interf.getTextVelocidade().setText(String.valueOf(tableMontaria.getValueAt(tableMontaria.getSelectedRow(), 5)));
	}
}
