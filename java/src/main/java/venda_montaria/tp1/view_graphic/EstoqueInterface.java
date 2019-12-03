package venda_montaria.tp1.view_graphic;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;

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
	private JTextPane txtpnEstoqueDoVendedor;
	private JTable table;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public EstoqueInterface() {
		
		JLabel lblId = new JLabel("ID");
		
		textID = new JTextField();
		textID.setColumns(10);
		
		JLabel lblRaa = new JLabel("Raça");
		
		textRaca = new JTextField();
		textRaca.setColumns(10);
		
		lblQuantidade = new JLabel("Quantidade");
		
		lblPreo = new JLabel("Preço");
		
		textQTD = new JTextField();
		textQTD.setColumns(10);
		
		textPreco = new JTextField();
		textPreco.setColumns(10);
		
		btLimpar = new JButton("Limpar");
		
		btAdicionar = new JButton("Adicionar");
		
		btEditar = new JButton("Editar");
		
		btRemover = new JButton("Remover");
		
		txtpnEstoqueDoVendedor = new JTextPane();
		txtpnEstoqueDoVendedor.setText("Estoque do Vendedor ");
		
		table = new JTable();
		
		table_1 = new JTable();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
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
										.addComponent(btLimpar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(147)
									.addComponent(txtpnEstoqueDoVendedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)))
							.addGap(29)
							.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addComponent(txtpnEstoqueDoVendedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
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
							.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

		
		
	}
}
