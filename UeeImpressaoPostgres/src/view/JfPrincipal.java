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

@SuppressWarnings("serial")
public class JfPrincipal extends JFrame {

	protected static Usuario logado;
	private JPanel contentPane;
	public static DateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
	private static Date data  = new Date();
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
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				JfPrincipal.class
						.getResource("/images/techvan_transparente.png")));
		setTitle("UEE CardExpress");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 794, 21);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Acesso");
		menuBar.add(mnNewMenu);

		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int resposta = JOptionPane.showConfirmDialog(null,
						"Deseja realmente fazer o logout do sistema?",
						"Logout de Sistema", JOptionPane.YES_NO_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {

					logado = (new Usuario());

					dispose();

					try {
						UIManager
								.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					} catch (ClassNotFoundException | InstantiationException
							| IllegalAccessException
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

				int resposta = JOptionPane.showConfirmDialog(null,
						"Deseja realmente sair do sistema?", "Sair de Sistema",
						JOptionPane.YES_NO_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {

					dispose();

					try {
						UIManager
								.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					} catch (ClassNotFoundException | InstantiationException
							| IllegalAccessException
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

		JMenu mnTechvan = new JMenu("Techvan");
		menuBar.add(mnTechvan);

		JMenu mnNewMenu_1 = new JMenu("Cadastro");
		mnTechvan.add(mnNewMenu_1);

		JMenuItem mntmUsurios = new JMenuItem("Usu\u00E1rios");
		mntmUsurios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

					JdCadastroUsuario frame = new JdCadastroUsuario();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);

				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
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
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

					JdCadastroMaquina frame = new JdCadastroMaquina();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);

				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		mnNewMenu_1.add(mntmMquinas);

		JSeparator separator_5 = new JSeparator();
		mnTechvan.add(separator_5);

		JMenu mnSegurana = new JMenu("Seguran\u00E7a");
		mnTechvan.add(mnSegurana);

		JMenuItem mntmConfigurao = new JMenuItem("Configura\u00E7\u00E3o");
		mntmConfigurao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

					JdSeguranca frame = new JdSeguranca();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);

				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		mnSegurana.add(mntmConfigurao);

		JMenu mnUee = new JMenu("UEE");
		menuBar.add(mnUee);

		JMenuItem mntmCarteira = new JMenuItem("Carteira");
		mnUee.add(mntmCarteira);

		JSeparator separator_3 = new JSeparator();
		mnUee.add(separator_3);

		JMenuItem mntmAbrirMovimento = new JMenuItem("Abrir Movimento");
		mnUee.add(mntmAbrirMovimento);

		JMenuItem mntmFecharMovimento = new JMenuItem("Fechar Movimento");
		mnUee.add(mntmFecharMovimento);

		JMenuItem mntmExportarArquivoPara = new JMenuItem(
				"Exportar arquivo para a Techvan");
		mnUee.add(mntmExportarArquivoPara);

		JMenu mnLeiame = new JMenu("Leiame");
		menuBar.add(mnLeiame);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnLeiame.add(mntmSobre);

		JMenuItem mntmImportante = new JMenuItem("Importante");
		mnLeiame.add(mntmImportante);
				
				JButton btnLogoff = new JButton("");
				btnLogoff.setHideActionText(true);
				btnLogoff.setFocusable(false);
				btnLogoff.setFocusTraversalPolicyProvider(true);
				btnLogoff.setIgnoreRepaint(true);
				btnLogoff.setInheritsPopupMenu(true);
				btnLogoff.setFocusCycleRoot(true);
				btnLogoff.setDoubleBuffered(true);
				btnLogoff.setBorderPainted(false);
				btnLogoff.setContentAreaFilled(false);
				btnLogoff.setToolTipText("Logoff");
				btnLogoff.setHorizontalTextPosition(SwingConstants.CENTER);
				btnLogoff.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						int resposta = JOptionPane.showConfirmDialog(null,
								"Deseja realmente fazer o logout do sistema?",
								"Logout de Sistema", JOptionPane.YES_NO_OPTION);

						if (resposta == JOptionPane.YES_OPTION) {

							logado = (new Usuario());

							dispose();

							try {
								UIManager
										.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
							} catch (ClassNotFoundException | InstantiationException
									| IllegalAccessException
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
				btnLogoff.setRolloverIcon(new ImageIcon(JfPrincipal.class.getResource("/images/log2.png")));
				btnLogoff.setIcon(new ImageIcon(JfPrincipal.class.getResource("/images/log.png")));
				btnLogoff.setBounds(405, 418, 58, 58);
				contentPane.add(btnLogoff);
		
				JButton btnSair = new JButton("");
				btnSair.setBorderPainted(false);
				btnSair.setIgnoreRepaint(true);
				btnSair.setInheritsPopupMenu(true);
				btnSair.setHideActionText(true);
				btnSair.setFocusTraversalPolicyProvider(true);
				btnSair.setFocusCycleRoot(true);
				btnSair.setDoubleBuffered(true);
				btnSair.setToolTipText("Fechar");
				btnSair.setRolloverIcon(new ImageIcon(JfPrincipal.class.getResource("/images/fechar2.png")));
				btnSair.setIcon(new ImageIcon(JfPrincipal.class.getResource("/images/fechar1.png")));
				btnSair.setBounds(473, 418, 58, 58);
				contentPane.add(btnSair);
				btnSair.setHorizontalTextPosition(SwingConstants.CENTER);
				btnSair.setFocusable(false);
				btnSair.setContentAreaFilled(false);
				btnSair.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						int resposta = JOptionPane.showConfirmDialog(null,
								"Deseja realmente sair do sistema?", "Sair de Sistema",
								JOptionPane.YES_NO_OPTION);

						if (resposta == JOptionPane.YES_OPTION) {

							dispose();

							try {
								UIManager
										.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
							} catch (ClassNotFoundException | InstantiationException
									| IllegalAccessException
									| UnsupportedLookAndFeelException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();

							}

						}
					}
				});

		JLabel lblHoraAtual = new JLabel("");
		lblHoraAtual.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblHoraAtual.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHoraAtual.setBounds(564, 426, 202, 21);
		contentPane.add(lblHoraAtual);

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
				lblHoraAtual.setText(sdf.format(new Date()));

			}
		}

		Timer t = new Timer();
		t.scheduleAtFixedRate(new Relogio(lblHoraAtual), 0, 1000);

		JSeparator separator = new JSeparator();
		separator.setBounds(24, 421, 742, 2);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(188, 40, 2, 359);
		contentPane.add(separator_1);

		JLabel lblUsurioLogado = new JLabel("Usu\u00E1rio Logado:");
		lblUsurioLogado.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblUsurioLogado.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsurioLogado.setBounds(24, 425, 87, 21);
		contentPane.add(lblUsurioLogado);

		JLabel lblLogado = new JLabel("");
		lblLogado.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblLogado.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogado.setBounds(106, 425, 271, 21);
		contentPane.add(lblLogado);

		lblLogado.setText(logado.getNome());

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(24, 219, 141, 2);
		contentPane.add(separator_2);

		JPanel panel = new JPanel();
		panel.setBounds(215, 43, 550, 356);
		contentPane.add(panel);
		panel.setLayout(null);

		CardLayout cardlayout = new CardLayout();

		JPanel cardTechvan = new JPanel();
		JPanel cardUee = new JPanel();

		panel.setLayout(cardlayout);

		panel.add(cardTechvan, "frameTechvan");
		cardTechvan.setLayout(null);

		JButton btnCadastro = new JButton("");
		btnCadastro.setRolloverIcon(new ImageIcon(JfPrincipal.class
				.getResource("/images/cadastro_usuario_2.png")));
		btnCadastro.setFocusable(false);
		btnCadastro.setBorderPainted(false);
		btnCadastro.setContentAreaFilled(false);
		btnCadastro.setIcon(new ImageIcon(JfPrincipal.class
				.getResource("/images/cadastro_usuario.png")));
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

					JdCadastroUsuario frame = new JdCadastroUsuario();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);

				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnCadastro.setBounds(28, 101, 177, 122);
		cardTechvan.add(btnCadastro);

		JButton btnSegurana = new JButton("");
		btnSegurana.setBorderPainted(false);
		btnSegurana.setRolloverIcon(new ImageIcon(JfPrincipal.class
				.getResource("/images/seg02_2.png")));
		btnSegurana.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSegurana.setFocusable(false);
		btnSegurana.setContentAreaFilled(false);
		btnSegurana.setIcon(new ImageIcon(JfPrincipal.class
				.getResource("/images/seg02.png")));
		btnSegurana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

					JdSeguranca frame = new JdSeguranca();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);

				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnSegurana.setBounds(278, 101, 211, 140);
		cardTechvan.add(btnSegurana);

		JLabel lblLogoTechvan = new JLabel("");
		lblLogoTechvan.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoTechvan.setIcon(new ImageIcon(JfPrincipal.class
				.getResource("/images/techvan_transparente_pequena.png")));
		// lblLogoTechvan.setIcon(new
		// ImageIcon(JfPrincipal.class.getResource("/images/techvan_transparente.png")));
		lblLogoTechvan.setBounds(434, 252, 116, 104);
		new ImageIcon(
				JfPrincipal.class
						.getResource("/images/techvan_transparente.png"));

		cardTechvan.add(lblLogoTechvan);

		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(252, 57, 2, 252);
		cardTechvan.add(separator_6);

		JLabel lblCadastroUsuarios = new JLabel("Cadastro de Usuarios");
		lblCadastroUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroUsuarios.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCadastroUsuarios.setBounds(55, 219, 116, 14);
		cardTechvan.add(lblCadastroUsuarios);

		JLabel lblSeguranca = new JLabel("Seguran\u00E7a");
		lblSeguranca.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSeguranca.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeguranca.setBounds(308, 219, 133, 14);
		cardTechvan.add(lblSeguranca);

		panel.add(cardUee, "frameUee");
		cardUee.setLayout(null);

		JButton btnCarteira = new JButton("");
		btnCarteira.setRolloverIcon(new ImageIcon(JfPrincipal.class.getResource("/images/IMPRIMIR2.png")));
		btnCarteira.setBorderPainted(false);
		btnCarteira.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCarteira.setFocusable(false);
		btnCarteira.setContentAreaFilled(false);
		btnCarteira.setIcon(new ImageIcon(JfPrincipal.class.getResource("/images/IMPRIMIR.png")));
		btnCarteira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JdImpressao dialog = new JdImpressao();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);

			}
		});
		btnCarteira.setBounds(22, 96, 142, 166);
		cardUee.add(btnCarteira);

		JButton btnAbrirMovimento = new JButton("Abrir Movimento");
		btnAbrirMovimento.setBounds(187, 108, 142, 49);
		cardUee.add(btnAbrirMovimento);

		JButton btnFecharMovimento = new JButton("Fechar Movimento");
		btnFecharMovimento.setBounds(367, 144, 142, 49);
		cardUee.add(btnFecharMovimento);

		JLabel lblUee = new JLabel("");
		lblUee.setIcon(new ImageIcon(JfPrincipal.class
				.getResource("/images/uee5.png")));
		lblUee.setHorizontalAlignment(SwingConstants.CENTER);
		lblUee.setBounds(445, 255, 105, 101);
		cardUee.add(lblUee);

		JButton btnConsultaDeCarteiras = new JButton("");
		btnConsultaDeCarteiras.setContentAreaFilled(false);
		btnConsultaDeCarteiras.setFocusable(false);
		btnConsultaDeCarteiras.setBorderPainted(false);
		btnConsultaDeCarteiras.setRolloverEnabled(true);
		btnConsultaDeCarteiras.setRolloverIcon(new ImageIcon(JfPrincipal.class.getResource("/images/consultaCarteira.png")));
		btnConsultaDeCarteiras.setIcon(new ImageIcon(JfPrincipal.class.getResource("/images/consultaCarteira2.png")));
		btnConsultaDeCarteiras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JdConsultaCarteira dialog = new JdConsultaCarteira();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
			}
		});
		btnConsultaDeCarteiras.setBounds(187, 180, 142, 82);
		cardUee.add(btnConsultaDeCarteiras);
		
		JLabel lblImpressão = new JLabel("Impress\u00E3o UEE");
		lblImpressão.setHorizontalTextPosition(SwingConstants.CENTER);
		lblImpressão.setHorizontalAlignment(SwingConstants.CENTER);
		lblImpressão.setBounds(37, 236, 116, 14);
		cardUee.add(lblImpressão);
		
		JLabel lblConsultaCarteira = new JLabel("Consultar Carteira");
		lblConsultaCarteira.setHorizontalTextPosition(SwingConstants.CENTER);
		lblConsultaCarteira.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaCarteira.setBounds(197, 273, 116, 14);
		cardUee.add(lblConsultaCarteira);

		JButton btnTechvan = new JButton("");
		btnTechvan.setBorderPainted(false);
		btnTechvan.setRolloverIcon(new ImageIcon(JfPrincipal.class
				.getResource("/images/techvan_transparente_P_2.png")));
		btnTechvan.setContentAreaFilled(false);
		btnTechvan.setFocusable(false);
		btnTechvan.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTechvan.setIcon(new ImageIcon(JfPrincipal.class
				.getResource("/images/techvan_transparente_P.png")));
		btnTechvan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				cardlayout.show(panel, "frameTechvan");

			}
		});
		btnTechvan.setBounds(24, 83, 140, 87);
		contentPane.add(btnTechvan);

		JButton btnUee = new JButton("");
		btnUee.setBorderPainted(false);
		btnUee.setRolloverIcon(new ImageIcon(JfPrincipal.class
				.getResource("/images/uee4_2.png")));
		btnUee.setFocusable(false);
		btnUee.setContentAreaFilled(false);
		btnUee.setIcon(new ImageIcon(JfPrincipal.class
				.getResource("/images/uee4.png")));
		btnUee.setHorizontalTextPosition(SwingConstants.CENTER);
		btnUee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cardlayout.show(panel, "frameUee");

			}
		});
		btnUee.setBounds(25, 272, 140, 87);
		contentPane.add(btnUee);

	}
}
