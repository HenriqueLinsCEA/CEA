package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
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
import javax.swing.table.DefaultTableModel;

import model.UsuarioDao;
import controller.MaxLengthTextDocument;
import controller.Usuario;

public class TelaBuscarUsuario extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tabelaUsuarios;
	private JTextField tfBuscarCpf;
	private JTextField tfBuscarNome;
	private JLabel lblTotal;
	private int quantidade = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			TelaBuscarUsuario dialog = new TelaBuscarUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaBuscarUsuario() {
		setUndecorated(true);
		setTitle("Pontos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				TelaBuscarUsuario.class.getResource("/imagens/dinheiro.gif")));
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblUsuarioLogado = new JLabel((String) null);
			lblUsuarioLogado.setForeground(Color.ORANGE);
			lblUsuarioLogado.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblUsuarioLogado.setBounds(251, 21, 222, 28);
			lblUsuarioLogado.setText(TelaPrincipal.logado.getNome());
			contentPanel.add(lblUsuarioLogado);
		}
		{
			JLabel label = new JLabel("Usu\u00E1rio Logado: ");
			label.setForeground(Color.ORANGE);
			label.setFont(new Font("Tahoma", Font.BOLD, 16));
			label.setBounds(107, 21, 137, 28);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(TelaBuscarUsuario.class
					.getResource("/imagens/dinheiro2.png")));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(507, 0, 87, 69);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("");
			label.setFont(new Font("Tahoma", Font.BOLD, 11));
			label.setBounds(0, 0, 600, 69);
			label.setIcon(new ImageIcon(TelaBuscarUsuario.class
					.getResource("/imagens/fundo_1.jpg")));
			contentPanel.add(label);
		}
		{
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
					null, null));
			btnCancelar.setBounds(446, 330, 100, 28);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					dispose();

				}
			});
			btnCancelar.setRolloverIcon(new ImageIcon(TelaBuscarUsuario.class
					.getResource("/imagens/fundo_2.jpg")));
			btnCancelar.setIcon(new ImageIcon(TelaBuscarUsuario.class
					.getResource("/imagens/fundo_1.jpg")));
			btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
			contentPanel.add(btnCancelar);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(55, 177, 491, 131);
			contentPanel.add(scrollPane);
			{
				
				lblTotal = new JLabel("0");
				lblTotal.setForeground(Color.RED);
				lblTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblTotal.setBounds(212, 330, 82, 28);
				contentPanel.add(lblTotal);

				
				tabelaUsuarios = new JTable();
				tabelaUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				tabelaUsuarios.setSelectionBackground(Color.ORANGE);
				tabelaUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 11));
				tabelaUsuarios.setToolTipText("");
				tabelaUsuarios.setForeground(Color.BLACK);
				tabelaUsuarios
						.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tabelaUsuarios.setModel(new DefaultTableModel(
						new Object[][] {}, new String[] { "Nome", "Tipo",
								"CPF", "Login" }) {
					/**
					 * 
					 */
					private static final long serialVersionUID = -6454047862364409378L;
					boolean[] columnEditables = new boolean[] { false, false,
							false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				tabelaUsuarios.getColumnModel().getColumn(0)
						.setResizable(false);
				tabelaUsuarios.getColumnModel().getColumn(0)
						.setPreferredWidth(179);
				tabelaUsuarios.getColumnModel().getColumn(1)
						.setResizable(false);
				tabelaUsuarios.getColumnModel().getColumn(1)
						.setPreferredWidth(119);
				tabelaUsuarios.getColumnModel().getColumn(2)
						.setResizable(false);
				tabelaUsuarios.getColumnModel().getColumn(2)
						.setPreferredWidth(117);
				tabelaUsuarios.getColumnModel().getColumn(3)
						.setResizable(false);
				tabelaUsuarios.getColumnModel().getColumn(3)
						.setPreferredWidth(74);
				scrollPane.setViewportView(tabelaUsuarios);

				tabelaUsuarios.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						int posicao = tabelaUsuarios.getSelectedRow();

						TelaPrincipal.usuarioLocalizado
								.setCpf(TelaPrincipal.listaUsuario.get(posicao)
										.getCpf());

						TelaPrincipal.usuarioLocalizado = Usuario
								.localizarUsuarioPeloCpf((TelaPrincipal.usuarioLocalizado
										.getCpf()));

						TelaMostrarUsuario frame = new TelaMostrarUsuario();
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);

						dispose();

					}
				});

				{
					JLabel lblTotaldeUsuarios = new JLabel(
							"Total de Usu\u00E1rios: ");
					lblTotaldeUsuarios
							.setFont(new Font("Tahoma", Font.BOLD, 16));
					lblTotaldeUsuarios.setBounds(57, 330, 158, 28);
					contentPanel.add(lblTotaldeUsuarios);
				}
				{

				}
				{
					JLabel lblBuscarUsuário = new JLabel("Localizar Usu\u00E1rio");
					lblBuscarUsuário.setFont(new Font("Tahoma", Font.BOLD, 16));
					lblBuscarUsuário.setBounds(55, 85, 201, 28);
					contentPanel.add(lblBuscarUsuário);
				}

			}
		}

		tfBuscarCpf = new JTextField();
		
		tfBuscarCpf.addKeyListener(new KeyAdapter() {
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
		tfBuscarCpf.setDocument(maxLength);
		
		tfBuscarCpf.setHorizontalAlignment(SwingConstants.CENTER);
		tfBuscarCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfBuscarCpf.setColumns(10);
		tfBuscarCpf.setBounds(55, 141, 176, 25);
		contentPanel.add(tfBuscarCpf);

		tfBuscarNome = new JTextField();
		tfBuscarNome.setHorizontalAlignment(SwingConstants.CENTER);
		tfBuscarNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfBuscarNome.setColumns(10);
		tfBuscarNome.setBounds(284, 142, 216, 25);
		contentPanel.add(tfBuscarNome);

		JLabel lblCpfapenasNmeros = new JLabel("CPF (Apenas n\u00FAmeros)");
		lblCpfapenasNmeros.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpfapenasNmeros.setBounds(55, 122, 201, 18);
		contentPanel.add(lblCpfapenasNmeros);

		JLabel lblNomeDoUsurio = new JLabel("Nome do usu\u00E1rio");
		lblNomeDoUsurio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDoUsurio.setBounds(284, 122, 201, 18);
		contentPanel.add(lblNomeDoUsurio);

		final JButton btnBuscarCpf = new JButton();
		btnBuscarCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				tfBuscarNome.setText("");

				DefaultTableModel model = (DefaultTableModel) tabelaUsuarios
						.getModel();

				model.setNumRows(0);

				if (tfBuscarCpf.getText().equalsIgnoreCase("")) {

					JOptionPane.showMessageDialog(null,
							"Digite o número do CPF no campo");

				} else {

					TelaPrincipal.usuarioLocalizado = Usuario.localizarUsuarioPeloCpf(tfBuscarCpf.getText());

					if (TelaPrincipal.usuarioLocalizado.getCpf() == null) {

						JOptionPane.showMessageDialog(null,
								"Cliente não Localizado");

						tfBuscarCpf.setText("");

					} else {

						tfBuscarCpf.setText("");

						try {
							UIManager
									.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

							TelaMostrarUsuario frame = new TelaMostrarUsuario();
							frame.setLocationRelativeTo(null);
							frame.setVisible(true);

							dispose();

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
		btnBuscarCpf.setRolloverIcon(new ImageIcon(TelaBuscarUsuario.class.getResource("/imagens/lupa_pequena2.png")));
		btnBuscarCpf.setIcon(new ImageIcon(TelaBuscarUsuario.class.getResource("/imagens/lupa_pequena1.png")));
		btnBuscarCpf.setInheritsPopupMenu(true);
		btnBuscarCpf.setIgnoreRepaint(true);
		btnBuscarCpf.setHideActionText(true);
		btnBuscarCpf.setFocusable(false);
		btnBuscarCpf.setFocusTraversalPolicyProvider(true);
		btnBuscarCpf.setFocusCycleRoot(true);
		btnBuscarCpf.setContentAreaFilled(false);
		btnBuscarCpf.setBorderPainted(false);
		btnBuscarCpf.setBorder(null);
		btnBuscarCpf.setAutoscrolls(true);
		btnBuscarCpf.setBounds(230, 131, 55, 46);
		contentPanel.add(btnBuscarCpf);
		
		tfBuscarCpf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				getRootPane().setDefaultButton(btnBuscarCpf);
				
			}
		});
		
				
		final JButton btnBuscarNome = new JButton();
		btnBuscarNome.setHorizontalAlignment(SwingConstants.RIGHT);
		btnBuscarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tfBuscarCpf.setText("");

				TelaPrincipal.listaUsuario = Usuario.localizarUsuarioParteDoNome(tfBuscarNome.getText().toUpperCase());
				
				if (tfBuscarNome.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite no campo de pesquisa Nome");

				} else {

					if (TelaPrincipal.listaUsuario.isEmpty()) {

						JOptionPane.showMessageDialog(null,
								"Cliente não Localizado");

						tfBuscarNome.setText("");

					} else {

					
						tfBuscarNome.setText("");

						DefaultTableModel model = (DefaultTableModel) tabelaUsuarios
								.getModel();

						model.setNumRows(0);

						for (Usuario u : TelaPrincipal.listaUsuario) {

							quantidade++;

							Object[] linha = { u.getNome(), u.getTipo(), u.getCpf(),
									u.getLogin() };

							model.addRow(linha);

						}
						
						lblTotal.setText(String.valueOf(quantidade));
						
						tfBuscarCpf.setText("");

					}

				}
				
			}
		});
		btnBuscarNome.setIcon(new ImageIcon(TelaBuscarUsuario.class.getResource("/imagens/lupa_pequena1.png")));
		btnBuscarNome.setRolloverIcon(new ImageIcon(TelaBuscarUsuario.class.getResource("/imagens/lupa_pequena2.png")));
		btnBuscarNome.setInheritsPopupMenu(true);
		btnBuscarNome.setIgnoreRepaint(true);
		btnBuscarNome.setHideActionText(true);
		btnBuscarNome.setFocusable(false);
		btnBuscarNome.setFocusTraversalPolicyProvider(true);
		btnBuscarNome.setFocusCycleRoot(true);
		btnBuscarNome.setContentAreaFilled(false);
		btnBuscarNome.setBorderPainted(false);
		btnBuscarNome.setBorder(null);
		btnBuscarNome.setAutoscrolls(true);
		btnBuscarNome.setBounds(495, 131, 55, 46);
		contentPanel.add(btnBuscarNome);
		
		tfBuscarNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				getRootPane().setDefaultButton(btnBuscarNome);
				
			}
		});

		JButton btnTodos = new JButton("Todos");
		btnTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				DefaultTableModel model = (DefaultTableModel) tabelaUsuarios
						.getModel();
				model.setNumRows(0);

				TelaPrincipal.listaUsuario = new UsuarioDao()
						.mostrarDadosUsuario();

				
				for (Usuario u : TelaPrincipal.listaUsuario) {

					quantidade++;

					Object[] linha = { u.getNome(), u.getTipo(), u.getCpf(),
							u.getLogin() };

					model.addRow(linha);

				}

				lblTotal.setText(String.valueOf(quantidade));
				
			}
		});
		btnTodos.setRolloverIcon(new ImageIcon(TelaBuscarUsuario.class.getResource("/imagens/botao_fundo_2.jpg")));
		btnTodos.setIcon(new ImageIcon(TelaBuscarUsuario.class.getResource("/imagens/botao_fundo_1.jpg")));
		btnTodos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTodos.setForeground(Color.WHITE);
		btnTodos.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTodos.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnTodos.setBounds(336, 330, 100, 28);
		contentPanel.add(btnTodos);
	}
}
