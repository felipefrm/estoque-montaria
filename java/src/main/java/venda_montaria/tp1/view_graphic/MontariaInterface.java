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
	private JButton btLimpar = new JButton("Limpar");
	private JButton btRemover = new JButton("Remover");
	private JButton btAdicionar = new JButton("Adicionar");
	private JTable tableMontaria;
	private static int rowCount = 0;
	
	public static int getRowCount() {
		return rowCount;
	}

	public static void setRowCount(int rowCount) {
		MontariaInterface.rowCount = rowCount;
	}

	public JTextField getTextID() {
		return textID;
	}

	public JTextField getTextRaca() {
		return textRaca;
	}

	public JTextField getTextCapacidade() {
		return textCapacidade;
	}

	public JTextField getTextVelocidade() {
		return textVelocidade;
	}

	public JTextField getTextRaridade() {
		return textRaridade;
	}

	public JTextField getTextCombustivel() {
		return textCombustivel;
	}

	public JButton getBtLimpar() {
		return btLimpar;
	}

	public JButton getBtRemover() {
		return btRemover;
	}

	public JButton getBtAdicionar() {
		return btAdicionar;
	}

	public JTable getTableMontaria() {
		return tableMontaria;
	}

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
		
		tableMontaria = new JTable();
		tableMontaria.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tableMontaria.setModel(new DefaultTableModel(
				new Object [][] {},
	            new String [] {"ID", "Raça", "Capacidade", "Raridade", "Velocidade", "Combustivel"}
	       	));
		JScrollPane scroll = new JScrollPane(tableMontaria);
		scroll.setViewportView(tableMontaria);
		add(scroll);
		
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

}
