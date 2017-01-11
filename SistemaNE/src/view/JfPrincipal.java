package view;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import controller.Usuario;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class JfPrincipal extends JFrame {

	protected static Usuario logado;
	private JPanel contentPane;
	public static DateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
	private static Date data = new Date();
	public static java.sql.Date dataAtual = new java.sql.Date(data.getTime());
	private static long hora = System.currentTimeMillis();
	public static java.sql.Time horaAtual = new java.sql.Time(hora);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					JfPrincipal frame = new JfPrincipal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JfPrincipal() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JfPrincipal.class.getResource("/image/ne.png")));
		setTitle("NE Sistemas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1038, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1032, 31);

		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);

		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente fazer o logout do sistema?",
						"Logout de Sistema", JOptionPane.YES_NO_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {

					logado = (new Usuario());

					dispose();

					try {
						UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					JfLogin frame = new JfLogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				}

			}
		});
		mnNewMenu.add(mntmLogout);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do sistema?",
						"Sair de Sistema", JOptionPane.YES_NO_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {

					dispose();

					try {
						UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();

					}

				}

			}
		});

		JSeparator separator_4 = new JSeparator();
		mnNewMenu.add(separator_4);
		mnNewMenu.add(mntmSair);

		JMenu mnNESolution = new JMenu("NE Solution");
		menuBar.add(mnNESolution);

		JMenu mnNewMenu_1 = new JMenu("Cadastro");
		mnNESolution.add(mnNewMenu_1);

		JMenuItem mntmUsurios = new JMenuItem("Usu\u00E1rios");
		mntmUsurios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

					// JdCadastroUsuario frame = new JdCadastroUsuario();
					// frame.setLocationRelativeTo(null);
					// frame.setVisible(true);

				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		mnNewMenu_1.add(mntmUsurios);

		JMenuItem mntmMquinas = new JMenuItem("M\u00E1quinas");
		mntmMquinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

					// JdCadastroMaquina frame = new JdCadastroMaquina();
					// frame.setLocationRelativeTo(null);
					// frame.setVisible(true);

				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		mnNewMenu_1.add(mntmMquinas);

		JSeparator separator_5 = new JSeparator();
		mnNESolution.add(separator_5);

		JMenu mnSegurana = new JMenu("Seguran\u00E7a");
		mnNESolution.add(mnSegurana);

		JMenuItem mntmConfigurao = new JMenuItem("Configura\u00E7\u00E3o");
		mntmConfigurao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

					// JdSeguranca frame = new JdSeguranca();
					// frame.setLocationRelativeTo(null);
					// frame.setVisible(true);

				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		mnSegurana.add(mntmConfigurao);

		JMenu mnLivre = new JMenu("Livre");
		menuBar.add(mnLivre);

		JMenuItem mntmCarteira = new JMenuItem("Carteira");
		mnLivre.add(mntmCarteira);

		JSeparator separator_3 = new JSeparator();
		mnLivre.add(separator_3);

		JMenuItem mntmAbrirMovimento = new JMenuItem("Abrir Movimento");
		mnLivre.add(mntmAbrirMovimento);

		JMenuItem mntmFecharMovimento = new JMenuItem("Fechar Movimento");
		mnLivre.add(mntmFecharMovimento);

		JMenuItem mntmExportarArquivoPara = new JMenuItem("Exportar arquivo para a Techvan");
		mnLivre.add(mntmExportarArquivoPara);

		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);

		JMenuItem mntmImportante = new JMenuItem("Importante");
		mnAjuda.add(mntmImportante);

		JLabel lblHoraAtual = new JLabel("");
		lblHoraAtual.setBounds(992, 431, 202, 21);
		lblHoraAtual.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblHoraAtual.setHorizontalAlignment(SwingConstants.RIGHT);

		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, new Locale("pt", "BR"));
		df.format(new Date());

		class Relogio extends TimerTask {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy " + " HH:mm:ss");

			private JLabel lblHoraAtual;

			public Relogio(JLabel lblHoraAtual) {
				this.lblHoraAtual = lblHoraAtual;

			}

			public void run() {
				lblHoraAtual.setText(sdf.format(new Date()));

			}
		}

		Timer t = new Timer();
		t.scheduleAtFixedRate(new Relogio(lblHoraAtual), 0, 1000);
		new ImageIcon(JfPrincipal.class.getResource("/images/techvan_transparente.png"));
		JPanel cardUsuario = new JPanel();
		cardUsuario.setBounds(240, 42, 782, 519);
		cardUsuario.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 782, 519);
		cardUsuario.add(panel);
		panel.setLayout(null);

		CardLayout cardlayout = new CardLayout();

		panel.setLayout(cardlayout);

		JButton button = new JButton("");
		button.setBounds(10, 158, 212, 34);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setFocusable(false);

		JButton button_1 = new JButton("");
		button_1.setBounds(10, 215, 212, 34);
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setFocusable(false);

		JButton button_2 = new JButton("");
		button_2.setBounds(10, 274, 212, 34);
		button_2.setHorizontalTextPosition(SwingConstants.CENTER);
		button_2.setFocusable(false);

		JButton button_3 = new JButton("");
		button_3.setBounds(10, 333, 212, 34);
		button_3.setHorizontalTextPosition(SwingConstants.CENTER);
		button_3.setFocusable(false);

		JButton button_4 = new JButton("");
		button_4.setBounds(10, 388, 212, 34);
		button_4.setHorizontalTextPosition(SwingConstants.CENTER);
		button_4.setFocusable(false);
		contentPane.setLayout(null);
		contentPane.add(menuBar);
		contentPane.add(button_1);
		contentPane.add(button_4);
		contentPane.add(button_3);
		contentPane.add(button_2);
		contentPane.add(button);
		contentPane.add(cardUsuario);
		contentPane.add(lblHoraAtual);

	}
}
