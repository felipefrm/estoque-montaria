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
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import venda_montaria.tp1.model.Montaria;

public class MontariaInterface extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textID;
	private JTextField textRaca;
	private JTextField textCapacidade;
	private JTextField textVelocidade;
	private JTextField textRaridade;
	private JTextField textCombustivel;
	private JTable tableMontaria;
	private static int rowCount = 0;

	/**
	 * Create the panel.
	 */
	public MontariaInterface() {
		
		initComponents();
		
	}
	
	private void initComponents() {
		
		JLabel lblId = new JLabel("ID");		
		JLabel lbRaca = new JLabel("Raça");
		JLabel lblCapacidade = new JLabel("Capacidade");
		JLabel lblRaridade = new JLabel("Raridade");
		JLabel lblVelocidade = new JLabel("Velocidade");
		JLabel lblCombustivel = new JLabel("Combustivel");
		
		textID = new JTextField();
		textID.setBackground(SystemColor.control);
		textID.setEditable(false);
		textID.setColumns(10);
		
		textRaca = new JTextField();
		textRaca.setColumns(10);
		
		textCapacidade = new JTextField();
		textCapacidade.setColumns(10);
		
		textVelocidade = new JTextField();
		textVelocidade.setColumns(10);
		
		textRaridade = new JTextField();
		textRaridade.setColumns(10);		
		
		textCombustivel = new JTextField();
		textCombustivel.setColumns(10);

		
		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_limparActionPerformed(e);
			}
		});
		
		JButton btRemover = new JButton("Remover");
		btRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_removeActionPerformed();
			}
		});

				
		JButton btAdicionar = new JButton("Adicionar");
		btAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_addActionPerformed();
			}
		});

		
		tableMontaria = new JTable();
		tableMontaria.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tableMontaria.setModel(new DefaultTableModel(
				new Object [][] {

	            },
	            new String [] {
	                "ID", "Raça", "Capacidade", "Raridade", "Velocidade", "Combustivel"
	            }
	       	));
		JScrollPane scroll = new JScrollPane(tableMontaria);
		scroll.setViewportView(tableMontaria);
		add(scroll);

		tableMontaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	tableMontariaMouseClick(evt);
            }
        });
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tableMontaria, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblVelocidade)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textVelocidade, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCapacidade)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textCapacidade, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRaridade)
								.addComponent(lblCombustivel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(textCombustivel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(textRaridade, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addComponent(btAdicionar, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btRemover, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lbRaca)
								.addComponent(lblId))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btLimpar, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
								.addComponent(textRaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btLimpar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbRaca)
						.addComponent(textRaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCapacidade)
						.addComponent(textCapacidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRaridade)
						.addComponent(textRaridade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVelocidade)
						.addComponent(textVelocidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCombustivel)
						.addComponent(textCombustivel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btAdicionar)
						.addComponent(btRemover))
					.addGap(18)
					.addComponent(tableMontaria, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
					.addContainerGap())
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
		Montaria m  = new Montaria(textRaca.getText(), textCombustivel.getText(), textRaridade.getText(), Integer.valueOf(textCapacidade.getText()),  Float.valueOf(textVelocidade.getText()));
        DefaultTableModel model = (DefaultTableModel)tableMontaria.getModel();
        model.setRowCount(rowCount++);
        model.addRow(new Object[]{m.getId(), m.getRaca() ,m.getCombustivel(), m.getRaridade(), m.getCapacidade(), m.getVelocidade()});
	}
	
	private void bt_removeActionPerformed() {
		DefaultTableModel model = (DefaultTableModel) tableMontaria.getModel();
		System.out.println(tableMontaria.getSelectedRow());
	    model.removeRow(tableMontaria.getSelectedRow());
	    rowCount--;
	}
	
	 private void tableMontariaMouseClick(java.awt.event.MouseEvent evt) {
	        textID.setText(String.valueOf(tableMontaria.getValueAt(tableMontaria.getSelectedRow(), 0)));
	        textRaca.setText(String.valueOf(tableMontaria.getValueAt(tableMontaria.getSelectedRow(), 1)));
	        textCombustivel.setText(String.valueOf(tableMontaria.getValueAt(tableMontaria.getSelectedRow(), 2)));
	        textRaridade.setText(String.valueOf(tableMontaria.getValueAt(tableMontaria.getSelectedRow(), 3)));
	        textCapacidade.setText(String.valueOf(tableMontaria.getValueAt(tableMontaria.getSelectedRow(), 4)));
	        textVelocidade.setText(String.valueOf(tableMontaria.getValueAt(tableMontaria.getSelectedRow(), 5)));	    
	 }
}
