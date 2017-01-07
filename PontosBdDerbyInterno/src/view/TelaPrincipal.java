package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.Cliente;
import controller.MaxLengthTextDocument;
import controller.Usuario;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static Cliente localizado = new Cliente();
	public static Usuario logado = new Usuario();
	public static Usuario usuarioLocalizado = new Usuario();
	private JTextField tfBuscarPeloCpf;
	private JTextField tfPesquisaNome;
	private static JTable tabelaClientes;
	static java.util.List<Cliente> listaCliente;
	static java.util.List<Usuario> listaUsuario;
	public static DateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
	private static Date data = new Date();
	public static java.sql.Date dataAtual = new java.sql.Date(data.getTime());
	public static long hora = System.currentTimeMillis();
	public static java.sql.Time horaAtual = new java.sql.Time(hora);
	
	
	/**
	 * Launch the applicationD
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					TelaPrincipal frame = new TelaPrincipal();
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
	@SuppressWarnings("serial")
	public TelaPrincipal() {
		setUndecorated(true);
		setFocusTraversalPolicyProvider(true);

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				TelaPrincipal.class.getResource("/imagens/dinheiro.gif")));
		setTitle("Pontos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setIgnoreRepaint(true);
		contentPane.setBackground(SystemColor.control);
		contentPane.setInheritsPopupMenu(true);
		contentPane.setDoubleBuffered(false);
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnFechar.setRolloverIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/imagens/fundo_2.jpg")));
		btnFechar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFechar.setForeground(Color.WHITE);
		btnFechar.setIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/imagens/fundo_1.jpg")));
		btnFechar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/imagens/dinheiro2.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(507, 0, 87, 69);
		contentPane.add(label);
		btnFechar.setBounds(420, 350, 145, 28);
		contentPane.add(btnFechar);

		JPanel panel = new JPanel();
		panel.setFont(new Font("Zurich Cn BT", Font.PLAIN, 13));
		panel.setBackground(SystemColor.control);
		panel.setBorder(new TitledBorder(null, "Pesquisar Clientes",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(31, 83, 361, 295);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"CPF (Digite apenas os 11 n\u00FAmeros)");
		lblNewLabel.setBounds(13, 31, 280, 18);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

		final JButton btnPesquisarCliente = new JButton();
		btnPesquisarCliente.setAutoscrolls(true);
		btnPesquisarCliente.setIgnoreRepaint(true);
		btnPesquisarCliente.setInheritsPopupMenu(true);
		btnPesquisarCliente.setFocusable(false);
		btnPesquisarCliente.setFocusTraversalPolicyProvider(true);
		btnPesquisarCliente.setFocusCycleRoot(true);
		btnPesquisarCliente.setBorderPainted(false);
		btnPesquisarCliente.setBorder(null);
		btnPesquisarCliente.setHideActionText(true);
		btnPesquisarCliente.setRolloverIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/imagens/lupa_pequena2.png")));
		btnPesquisarCliente.setContentAreaFilled(false);
		btnPesquisarCliente.setBounds(273, 26, 89, 70);
		getRootPane().setDefaultButton(btnPesquisarCliente);
		panel.add(btnPesquisarCliente);

		btnPesquisarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tfPesquisaNome.setText("");

				DefaultTableModel model = (DefaultTableModel) tabelaClientes
						.getModel();

				model.setNumRows(0);

				if (tfBuscarPeloCpf.getText().equalsIgnoreCase("")) {

					JOptionPane.showMessageDialog(null,
							"Digite o número do CPF no campo");

				} else {

					localizado = Cliente.localizarClientePeloCpf((Cliente
							.removerMascara(tfBuscarPeloCpf.getText())));

					if (localizado.getCpf() == null) {

						JOptionPane.showMessageDialog(null,
								"Cliente não Localizado");

						tfBuscarPeloCpf.setText("");

					} else {

						tfBuscarPeloCpf.setText("");

						try {
							UIManager
									.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

							TelaMostrarCliente frame = new TelaMostrarCliente();
							frame.setLocationRelativeTo(null);
							frame.setVisible(true);

						} catch (ClassNotFoundException
								| InstantiationException
								| IllegalAccessException
								| UnsupportedLookAndFeelException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}

				}
			}
		});

		getRootPane().setDefaultButton(btnPesquisarCliente);
		btnPesquisarCliente.setIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/imagens/lupa_pequena1.png")));

		tfBuscarPeloCpf = new JTextField();
		tfBuscarPeloCpf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				rootPane.setDefaultButton(btnPesquisarCliente);

			}
		});
		tfBuscarPeloCpf.setHorizontalAlignment(SwingConstants.CENTER);
		tfBuscarPeloCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfBuscarPeloCpf.setBounds(13, 50, 280, 25);
		panel.add(tfBuscarPeloCpf);
		tfBuscarPeloCpf.setColumns(10);

		tfBuscarPeloCpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {

				String caracteres = "0987654321";

				if (!caracteres.contains(ev.getKeyChar() + "")) {

					ev.consume();

				}

			}
		});

		MaxLengthTextDocument maxLength = new MaxLengthTextDocument();
		maxLength.setMaxChars(12);
		tfBuscarPeloCpf.setDocument(maxLength);

		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente");
		lblNomeDoCliente.setBounds(13, 86, 280, 18);
		panel.add(lblNomeDoCliente);
		lblNomeDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfPesquisaNome = new JTextField();

		tfPesquisaNome.setBounds(13, 107, 280, 25);
		panel.add(tfPesquisaNome);
		tfPesquisaNome.setHorizontalAlignment(SwingConstants.CENTER);
		tfPesquisaNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfPesquisaNome.setColumns(10);

		final JLabel lblSelecioneOCliente = new JLabel(
				"Selecione o Cliente abaixo");
		lblSelecioneOCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSelecioneOCliente.setBounds(13, 143, 335, 18);
		lblSelecioneOCliente.setVisible(false);
		panel.add(lblSelecioneOCliente);

		final JButton btnPesquisaNome = new JButton();

		tfPesquisaNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {

				rootPane.setDefaultButton(btnPesquisaNome);

			}
		});
		btnPesquisaNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tfBuscarPeloCpf.setText("");

				listaCliente = Cliente.localizarClientePeloNome(tfPesquisaNome
						.getText().toUpperCase());

				if (tfPesquisaNome.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite no campo de pesquisa Nome");

				} else {

					if (listaCliente.isEmpty()) {

						JOptionPane.showMessageDialog(null,
								"Cliente não Localizado");

						tfPesquisaNome.setText("");

					} else {

						lblSelecioneOCliente.setVisible(true);

						tfPesquisaNome.setText("");

						DefaultTableModel model = (DefaultTableModel) tabelaClientes
								.getModel();

						model.setNumRows(0);

						for (Cliente c : listaCliente) {

							Object[] linha = { c.getNome(), c.getCpf(),
									c.getPontos() };

							model.addRow(linha);

						}

						tfBuscarPeloCpf.setText("");

					}

				}

			}
		});
		btnPesquisaNome.setRolloverIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/imagens/lupa_pequena2.png")));
		btnPesquisaNome.setIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/imagens/lupa_pequena1.png")));
		btnPesquisaNome.setInheritsPopupMenu(true);
		btnPesquisaNome.setIgnoreRepaint(true);
		btnPesquisaNome.setHideActionText(true);
		btnPesquisaNome.setFocusable(false);
		btnPesquisaNome.setFocusTraversalPolicyProvider(true);
		btnPesquisaNome.setFocusCycleRoot(true);
		btnPesquisaNome.setContentAreaFilled(false);
		btnPesquisaNome.setBorderPainted(false);
		btnPesquisaNome.setBorder(null);
		btnPesquisaNome.setAutoscrolls(true);
		btnPesquisaNome.setBounds(273, 86, 89, 70);
		panel.add(btnPesquisaNome);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setBounds(13, 165, 335, 107);
		panel.add(scrollPane);

		JLabel lblSejaBemVindo = new JLabel("Usuário Logado: ");
		lblSejaBemVindo.setForeground(Color.ORANGE);
		lblSejaBemVindo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSejaBemVindo.setBounds(107, 21, 137, 28);
		contentPane.add(lblSejaBemVindo);

		JLabel lblUsuarioLogado = new JLabel("Usu\u00E1rio Logado");

		lblUsuarioLogado.setForeground(Color.ORANGE);
		lblUsuarioLogado.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuarioLogado.setBounds(251, 21, 250, 28);
		lblUsuarioLogado.setText(logado.getNome());

		contentPane.add(lblUsuarioLogado);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/imagens/fundo_1.jpg")));
		lblNewLabel_1.setBounds(0, 0, 600, 69);
		contentPane.add(lblNewLabel_1);

		tabelaClientes = new JTable();

		tabelaClientes.setSelectionForeground(Color.BLACK);
		tabelaClientes.setShowGrid(false);
		tabelaClientes.setSelectionBackground(Color.ORANGE);
		tabelaClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int posicao = tabelaClientes.getSelectedRow();

				localizado.setCpf(listaCliente.get(posicao).getCpf());

				localizado = Cliente.localizarClientePeloCpf((localizado
						.getCpf()));

				TelaMostrarCliente frame = new TelaMostrarCliente();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

				DefaultTableModel model = (DefaultTableModel) tabelaClientes
						.getModel();

				model.setNumRows(0);

				lblSelecioneOCliente.setVisible(false);

			}
		});
		tabelaClientes.setInheritsPopupMenu(true);
		tabelaClientes.setIgnoreRepaint(true);
		tabelaClientes.setDoubleBuffered(true);
		tabelaClientes.setDragEnabled(true);
		tabelaClientes.setFocusCycleRoot(true);
		tabelaClientes.setFocusTraversalPolicyProvider(true);
		tabelaClientes.setSurrendersFocusOnKeystroke(true);
		tabelaClientes.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		tabelaClientes.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tabelaClientes.setToolTipText("");
		tabelaClientes.setForeground(Color.BLACK);
		tabelaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaClientes.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "CPF" }) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, String.class };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabelaClientes.getColumnModel().getColumn(0).setResizable(false);
		tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(243);
		tabelaClientes.getColumnModel().getColumn(1).setResizable(false);
		tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(130);

		scrollPane.setViewportView(tabelaClientes);

		final JButton btnAreaDoUsuario = new JButton(
				"\u00C1rea do Usu\u00E1rio");
		
		if (TelaPrincipal.logado.getTipo().equalsIgnoreCase("Administrador")) {

			btnAreaDoUsuario.setEnabled(true);

		} else {

			btnAreaDoUsuario.setEnabled(false);
		}

		btnAreaDoUsuario.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		btnAreaDoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				localizado = (new Cliente(0, null, null, 0, null, null, null));

				try {

					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					TelaAreaDoUsuario frame = new TelaAreaDoUsuario();
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
		btnAreaDoUsuario.setRolloverIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/imagens/fundo_2.jpg")));
		btnAreaDoUsuario.setIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/imagens/fundo_1.jpg")));
		btnAreaDoUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAreaDoUsuario.setForeground(Color.WHITE);
		btnAreaDoUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAreaDoUsuario.setBounds(420, 155, 145, 28);
		contentPane.add(btnAreaDoUsuario);

		JButton btnListarClientes = new JButton("Listar Clientes");
		btnListarClientes.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		btnListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

					TelaListarCliente frame = new TelaListarCliente();
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
		btnListarClientes.setRolloverIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/imagens/fundo_2.jpg")));
		btnListarClientes.setIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/imagens/fundo_1.jpg")));
		btnListarClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnListarClientes.setForeground(Color.WHITE);
		btnListarClientes.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListarClientes.setBounds(420, 90, 145, 28);
		contentPane.add(btnListarClientes);

		JButton btnUsuarioSair = new JButton("Logoff Usu\u00E1rio");
		btnUsuarioSair.setBounds(420, 123, 145, 28);
		contentPane.add(btnUsuarioSair);
		btnUsuarioSair.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		btnUsuarioSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int resposta = JOptionPane.showConfirmDialog(null,
						"Deseja realmente fazer o logoff do sistema?");

				if (resposta == 0) {

					logado.setId_usuario(0);
					logado.setNome(null);
					logado.setLogin(null);
					logado.setSenha(null);

					localizado = (new Cliente(0, null, null, 0, null, null,
							null));

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
					TelaLogin frame = new TelaLogin();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);

				} else if (resposta == 1) {

					JOptionPane.showMessageDialog(null,
							"Não desejo fazer o logoff ");
				}

			}
		});
		btnUsuarioSair.setRolloverIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/imagens/fundo_2.jpg")));
		btnUsuarioSair.setIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/imagens/fundo_1.jpg")));
		btnUsuarioSair.setHorizontalTextPosition(SwingConstants.CENTER);
		btnUsuarioSair.setForeground(Color.WHITE);
		btnUsuarioSair.setFont(new Font("Tahoma", Font.BOLD, 13));

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(420, 188, 145, 28);
		contentPane.add(btnCadastrar);
		btnCadastrar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnCadastrar.setRolloverIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/imagens/fundo_2.jpg")));
		btnCadastrar.setSelected(true);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tfBuscarPeloCpf.setText(" ");

				localizado = (new Cliente(0, null, null, 0, null, null, null,
						null, null, null, null, null, null, null));

				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				TelaCadastroCliente frame = new TelaCadastroCliente();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

			}
		});
		btnCadastrar.setIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/imagens/fundo_1.jpg")));
		btnCadastrar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lbClientes = new JLabel("");
		lbClientes.setIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/imagens/casa.png")));
		lbClientes.setBounds(420, 216, 145, 138);
		contentPane.add(lbClientes);
		lbClientes.setBorder(null);
		lbClientes.setInheritsPopupMenu(false);
		lbClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lbClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JLabel lblDesenvolvedorHenriqueLins = new JLabel("Desenvolvedor Henrique Lins");
		lblDesenvolvedorHenriqueLins.setBounds(31, 372, 231, 28);
		contentPane.add(lblDesenvolvedorHenriqueLins);

	}
}
