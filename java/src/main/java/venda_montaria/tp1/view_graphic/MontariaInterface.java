package venda_montaria.tp1.view_graphic;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MontariaInterface extends JPanel {
	private JTextField textID;
	private JTextField textRaca;
	private JTextField textCapacidade;
	private JTextField textVelocidade;
	private JTextField textRaridade;
	private JTextField textCombustivel;

	/**
	 * Create the panel.
	 */
	public MontariaInterface() {
		
		JLabel lblId = new JLabel("ID");
		
		textID = new JTextField();
		textID.setColumns(10);
		
		JLabel lblNome = new JLabel("Raça");
		
		JLabel lblCapacidade = new JLabel("Capacidade");
		
		JLabel lblRaridade = new JLabel("Raridade");
		
		JLabel lblVelocidade = new JLabel("Velocidade");
		
		JLabel lblCombustivel = new JLabel("Combustivel");
		
		textRaca = new JTextField();
		textRaca.setColumns(10);
		
		textCapacidade = new JTextField();
		textCapacidade.setColumns(10);
		
		textVelocidade = new JTextField();
		textVelocidade.setColumns(10);
		
		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt_limparActionPerformed(e);
			}
		});
		
		JButton btRemover = new JButton("Remover");
		
		textRaridade = new JTextField();
		textRaridade.setColumns(10);
		
		textCombustivel = new JTextField();
		textCombustivel.setColumns(10);
		
		JButton btAdicionar = new JButton("Adicionar");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
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
								.addComponent(lblNome)
								.addComponent(lblId))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btLimpar, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
								.addComponent(textRaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(18, Short.MAX_VALUE))
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
					.addContainerGap(133, Short.MAX_VALUE))
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
}