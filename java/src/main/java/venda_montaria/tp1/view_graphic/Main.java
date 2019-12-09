package venda_montaria.tp1.view_graphic;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UnsupportedLookAndFeelException;

import venda_montaria.tp1.control.MontariaControlador;
import venda_montaria.tp1.control.VendedorControlador;
import venda_montaria.tp1.model.Montaria;
import venda_montaria.tp1.model.Vendedor;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Main() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		ArrayList<Montaria> modeloMontaria = new ArrayList<Montaria>();
		ArrayList<Vendedor> modeloVendedor = new ArrayList<Vendedor>();

		
		frame = new JFrame("Estoque de Montaria");
		frame.setBounds(100, 100, 440, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel home = new HomeInterface(modeloVendedor, modeloMontaria);
		tabbedPane.addTab("Home", null, home, null);
		
		
		MontariaInterface montaria = new MontariaInterface();

		MontariaControlador controladorMontaria = new MontariaControlador(montaria, modeloMontaria);
		tabbedPane.addTab("Montaria", null, montaria, null);
		
		VendedorInterface vendedor = new VendedorInterface(modeloVendedor, modeloMontaria);
		
		VendedorControlador controladorVendedor = new VendedorControlador(vendedor,modeloVendedor,modeloMontaria);
		tabbedPane.addTab("Vendedor", null, vendedor, null);
	
	}
}
