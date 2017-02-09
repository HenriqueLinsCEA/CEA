package view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class JfTelaInicial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5249132647149033653L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					JfTelaInicial frame = new JfTelaInicial();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JfTelaInicial() {
		setTitle("NE Sistemas - Controle Contas de Clientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(JfTelaInicial.class.getResource("/image/ne.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);

		JMenu menu = new JMenu("New menu");
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("New menu item");
		menu.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("New menu item");
		menu.add(menuItem_1);

		JMenu menu_1 = new JMenu("New menu");
		menuBar.add(menu_1);

		JMenuItem menuItem_2 = new JMenuItem("New menu item");
		menu_1.add(menuItem_2);

		JMenuItem menuItem_3 = new JMenuItem("New menu item");
		menu_1.add(menuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblLogo = new JLabel("");
		lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(JfTelaInicial.class.getResource("/image/logo_ne_solution.png")));

		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					JdTelaCliente dialog = new JdTelaCliente();
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);

				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton button = new JButton("OK");
		button.setActionCommand("OK");

		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		});
		button_1.setActionCommand("Cancel");

		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					JdTelaUsuario dialog = new JdTelaUsuario();
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);

				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		JLabel lblLogado = new JLabel("");
	
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, new Locale(
				"pt", "BR"));
		df.format(new Date());

		class Relogio extends TimerTask {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy "
					+ " HH:mm:ss");

			private JLabel lblHoraAtual;

			public Relogio(JLabel lblHoraAtual) {
				this.lblHoraAtual = lblHoraAtual;

			}

			public void run() {
				
				lblLogado.setText((sdf.format(new Date())) + "      |      LOGADO:    " +controller.IniciarAplicativoSistemaNE.logado.getNomeUsuario() + "       |       (     " + controller.IniciarAplicativoSistemaNE.logado.getFuncaoUsuario() + "     )");
				

			}
		}

		Timer t = new Timer();
		t.scheduleAtFixedRate(new Relogio(lblLogado), 0, 1000);
		
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(223)
					.addComponent(lblLogo, GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
					.addGap(224))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblLogado, GroupLayout.PREFERRED_SIZE, 826, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(30))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnUsuarios, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnClientes, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(995, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(107)
					.addComponent(btnClientes)
					.addGap(30)
					.addComponent(btnUsuarios)
					.addGap(14)
					.addComponent(lblLogo, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
					.addGap(163)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(button)
							.addComponent(lblLogado, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(button_1))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
