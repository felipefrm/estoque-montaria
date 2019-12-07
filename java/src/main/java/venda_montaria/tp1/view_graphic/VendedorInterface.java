package venda_montaria.tp1.view_graphic;

import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import venda_montaria.tp1.model.Vendedor;

public class VendedorInterface extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textID;
	private JTextField textNome;
	private JTextField textRaca;
	private JTextField textIdade;
	private JTable tableVendedor;
	private DefaultTableModel modeloTabela;
	private static int rowCount = 0;
	
	
	/**
	 * Create the panel.
	 */
	public VendedorInterface() {
		
		initComponents();
	
	}
	
	private void initComponents() {
		
		JLabel lblId = new JLabel("ID");
		JLabel lblNome = new JLabel("Nome");
		JLabel lblRaa = new JLabel("Raça");
		JLabel lblIdade = new JLabel("Idade");
		
		textID = new JTextField();
		textID.setBackground(SystemColor.control);
		textID.setEditable(false);
		textID.setColumns(10);	
//		textID.setText("1");
//		
		textNome = new JTextField();
		textNome.setColumns(10);	
//		textNome.setText("Felipe");
			
		textRaca = new JTextField();
		textRaca.setColumns(10);	
		
		textIdade = new JTextField();
		textIdade.setColumns(10);
		
		JButton btRemover = new JButton("Remover");
		btRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_removeActionPerformed();
			}
		});
		
		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_limparActionPerformed(e);
			}
		});
		
		JButton btAdicionar = new JButton("Adicionar");	
		btAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_addActionPerformed();
			}
		});
		
		JButton btEstoque = new JButton("Acessar estoque do Vendedor");
		btEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_acessActionPerformed(Integer.valueOf(textID.getText()), textNome.getText());
			}
		});
		
//		modeloTabela = new DefaultTableModel();		
//		modeloTabela.addColumn("ID");
//		modeloTabela.addColumn("Nome");
//		modeloTabela.addColumn("Raça");
//		modeloTabela.addColumn("Idade");
		tableVendedor = new JTable();
		tableVendedor.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		tableVendedor.setModel(new DefaultTableModel(
			new Object [][] {},
            new String [] { "ID", "Nome", "Raça", "Idade"}
       	));
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(tableVendedor);
		add(scroll);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblRaa)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textRaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNome)
										.addComponent(lblId))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textNome)
										.addComponent(textID))
									.addGap(17)
									.addComponent(btLimpar, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(7)
											.addComponent(btAdicionar, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblIdade)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btRemover, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(116)
							.addComponent(btEstoque))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(tableVendedor, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)))
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
						.addComponent(lblNome)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRaa)
						.addComponent(textRaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdade)
						.addComponent(textIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btAdicionar)
						.addComponent(btRemover))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btEstoque)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tableVendedor, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
					.addGap(10))
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
		Vendedor v  = new Vendedor(textNome.getText(), textRaca.getText(), Integer.valueOf(textIdade.getText()));
        DefaultTableModel model = (DefaultTableModel)tableVendedor.getModel();
        model.setRowCount(rowCount++);
        model.addRow(new Object[]{v.getId(), v.getNome() ,v.getRaca(), v.getIdade()});
	}
	
	private void bt_removeActionPerformed() {
		
	}
	
	private void bt_acessActionPerformed(int ID, String nome) {
		JFrame frame = new JFrame("Estoque do vendedor " + nome);
		frame.add(new EstoqueInterface());
		frame.setBounds(100, 100, 440, 400);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
