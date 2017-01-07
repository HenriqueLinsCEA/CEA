package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

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
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import model.HistoricoDao;
import controller.Historico;
import controller.MaxLengthTextDocument;

public class TelaListarHistorico extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static JTable tabelaHistorico;
	private JTextField tfCpfUsuario;
	private JTextField tfUsuario;
	private JTextField tfCpfCliente;
	private JTextField tfCliente;
	private List<Historico> listaHistorico;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			TelaListarHistorico dialog = new TelaListarHistorico();
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
	@SuppressWarnings("serial")
	public TelaListarHistorico() {
		setUndecorated(true);
		setTitle("Pontos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				TelaListarHistorico.class.getResource("/imagens/dinheiro.gif")));
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			contentPanel.setLayout(null);

			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(507, 0, 87, 69);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setIcon(new ImageIcon(TelaListarHistorico.class
					.getResource("/imagens/dinheiro2.png")));
			contentPanel.add(lblNewLabel);
			{
				JLabel lbUsuarioLogado = new JLabel("Usu\u00E1rio Logado: ");
				lbUsuarioLogado.setForeground(Color.ORANGE);
				lbUsuarioLogado.setFont(new Font("Tahoma", Font.BOLD, 16));
				lbUsuarioLogado.setBounds(107, 21, 137, 28);
				contentPanel.add(lbUsuarioLogado);
			}
			{
				JLabel lblUsuarioLogado = new JLabel("Usu\u00E1rio Logado");
				lblUsuarioLogado.setForeground(Color.ORANGE);
				lblUsuarioLogado.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblUsuarioLogado.setBounds(251, 21, 250, 28);
				lblUsuarioLogado.setText(TelaPrincipal.logado.getNome());

				contentPanel.add(lblUsuarioLogado);
			}
			{
				JLabel label = new JLabel("");
				label.setBounds(0, 0, 600, 69);
				label.setIcon(new ImageIcon(TelaListarHistorico.class
						.getResource("/imagens/fundo_1.jpg")));
				contentPanel.add(label);
			}
		}
		{

			{

				{
					JButton btCancelar = new JButton("Cancelar");
					btCancelar.setActionCommand("Cancelar");
					btCancelar.setBorder(new BevelBorder(BevelBorder.RAISED, null,
							null, null, null));
					btCancelar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							dispose();

						}
					});
					btCancelar.setBounds(461, 330, 100, 28);
					getRootPane().setDefaultButton(btCancelar);

					btCancelar.setRolloverIcon(new ImageIcon(TelaListarHistorico.class
							.getResource("/imagens/fundo_2.jpg")));
					btCancelar.setIcon(new ImageIcon(TelaListarHistorico.class
							.getResource("/imagens/fundo_1.jpg")));
					btCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
					btCancelar.setForeground(Color.WHITE);
					btCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
					getRootPane().setDefaultButton(btCancelar);

					contentPanel.add(btCancelar);
				}

			}
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setBackground(SystemColor.menu);
		scrollPane.setInheritsPopupMenu(true);
		scrollPane.setIgnoreRepaint(true);
		scrollPane.setBounds(34, 204, 532, 114);
		contentPanel.add(scrollPane);

		tabelaHistorico = new JTable();
		tabelaHistorico.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabelaHistorico.setEnabled(false);
		tabelaHistorico.setColumnSelectionAllowed(true);
		tabelaHistorico.setCellSelectionEnabled(true);
		tabelaHistorico.setFont(new Font("Tahoma", Font.PLAIN, 9));
		tabelaHistorico.setToolTipText("");
		tabelaHistorico.setForeground(Color.BLACK);
		tabelaHistorico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaHistorico.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"User Logado", "Usuario CPF", "Cliente", "Cliente CPF", "Transa\u00E7\u00E3o", "Valor", "Pontos", "Data", "Hora"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelaHistorico.getColumnModel().getColumn(0).setResizable(false);
		tabelaHistorico.getColumnModel().getColumn(0).setPreferredWidth(150);
		tabelaHistorico.getColumnModel().getColumn(1).setResizable(false);
		tabelaHistorico.getColumnModel().getColumn(1).setPreferredWidth(90);
		tabelaHistorico.getColumnModel().getColumn(2).setResizable(false);
		tabelaHistorico.getColumnModel().getColumn(2).setPreferredWidth(150);
		tabelaHistorico.getColumnModel().getColumn(3).setResizable(false);
		tabelaHistorico.getColumnModel().getColumn(3).setPreferredWidth(90);
		tabelaHistorico.getColumnModel().getColumn(4).setResizable(false);
		tabelaHistorico.getColumnModel().getColumn(5).setResizable(false);
		tabelaHistorico.getColumnModel().getColumn(5).setPreferredWidth(55);
		tabelaHistorico.getColumnModel().getColumn(6).setResizable(false);
		tabelaHistorico.getColumnModel().getColumn(6).setPreferredWidth(55);
		tabelaHistorico.getColumnModel().getColumn(7).setResizable(false);
		tabelaHistorico.getColumnModel().getColumn(7).setPreferredWidth(58);
		tabelaHistorico.getColumnModel().getColumn(8).setResizable(false);
		tabelaHistorico.getColumnModel().getColumn(8).setPreferredWidth(53);
		scrollPane.setViewportView(tabelaHistorico);
		{

		}

		JButton btnTodos = new JButton("Todos");
		getRootPane().setDefaultButton(btnTodos);
		btnTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tfCliente.setText("");
				tfUsuario.setText("");
				tfCpfCliente.setText("");
				tfCpfUsuario.setText("");
				

				DefaultTableModel model = (DefaultTableModel) tabelaHistorico
						.getModel();
				model.setNumRows(0);

				new HistoricoDao();

				listaHistorico = HistoricoDao.mostrarDados();

				for (Historico h : listaHistorico) {

					Object[] linha = { h.getLogado(), h.getLogadoCpf(),
							h.getLocalizado(), h.getLocalizadoCpf(),
							h.getTransacao(), h.getValor(),
							h.getPontosAtualizado(),
							TelaPrincipal.ft.format(h.getData()), h.getHora() };

					model.addRow(linha);

				}

			}
		});
		btnTodos.setRolloverIcon(new ImageIcon(TelaListarHistorico.class
				.getResource("/imagens/botao_fundo_2.jpg")));
		btnTodos.setIcon(new ImageIcon(TelaListarHistorico.class
				.getResource("/imagens/botao_fundo_1.jpg")));
		btnTodos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTodos.setForeground(Color.WHITE);
		btnTodos.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTodos.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,

		null, null));
		btnTodos.setBounds(351, 330, 100, 28);
		contentPanel.add(btnTodos);

		{
			JLabel lblHistoricoPontos = new JLabel("Historico Pontos");
			lblHistoricoPontos.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblHistoricoPontos.setBounds(34, 85, 137, 28);
			contentPanel.add(lblHistoricoPontos);
		}

		tfCpfUsuario = new JTextField();

		tfCpfUsuario.addKeyListener(new KeyAdapter() {
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
		tfCpfUsuario.setDocument(maxLength);

		tfCpfUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		tfCpfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCpfUsuario.setColumns(10);
		tfCpfUsuario.setBounds(34, 127, 169, 25);
		contentPanel.add(tfCpfUsuario);

		JLabel lblCpfDoUsurio = new JLabel("CPF do Usu\u00E1rio");
		lblCpfDoUsurio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpfDoUsurio.setBounds(34, 110, 169, 18);
		contentPanel.add(lblCpfDoUsurio);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsurio.setBounds(35, 150, 168, 18);
		contentPanel.add(lblUsurio);

		tfUsuario = new JTextField();

		tfUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfUsuario.setColumns(10);
		tfUsuario.setBounds(34, 168, 170, 25);
		contentPanel.add(tfUsuario);

		final JButton btnUsuario = new JButton();
		tfUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				DefaultTableModel model = (DefaultTableModel) tabelaHistorico
						.getModel();
				model.setNumRows(0);

				tfCliente.setText("");
				tfCpfUsuario.setText("");
				tfCpfCliente.setText("");
				

				getRootPane().setDefaultButton(btnUsuario);

			}
		});

		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) tabelaHistorico
						.getModel();
				model.setNumRows(0);

				if (tfUsuario.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite no campo Usuário");

				} else {

					new HistoricoDao();
					listaHistorico = HistoricoDao
							.pesquisarNomeUsuario(tfUsuario.getText()
									.toUpperCase());

					if (listaHistorico.isEmpty()) {

						JOptionPane.showMessageDialog(null,
								"Usuário não encontrado");

						tfUsuario.setText("");

					} else {

						for (Historico h : listaHistorico) {

							Object[] linha = { h.getLogado(), h.getLogadoCpf(),
									h.getLocalizado(), h.getLocalizadoCpf(),
									h.getTransacao(), h.getValor(),
									h.getPontosAtualizado(),
									TelaPrincipal.ft.format(h.getData()),
									h.getHora() };

							model.addRow(linha);
						}
					}
				}
			}
		});

		btnUsuario.setRolloverIcon(new ImageIcon(TelaListarHistorico.class
				.getResource("/imagens/lupa_pequena2.png")));
		btnUsuario.setIcon(new ImageIcon(TelaListarHistorico.class
				.getResource("/imagens/lupa_pequena1.png")));
		btnUsuario.setInheritsPopupMenu(true);
		btnUsuario.setIgnoreRepaint(true);
		btnUsuario.setHideActionText(true);
		btnUsuario.setFocusable(false);
		btnUsuario.setFocusTraversalPolicyProvider(true);
		btnUsuario.setFocusCycleRoot(true);
		btnUsuario.setContentAreaFilled(false);
		btnUsuario.setBorderPainted(false);
		btnUsuario.setBorder(null);
		btnUsuario.setAutoscrolls(true);
		btnUsuario.setBounds(213, 156, 46, 46);
		contentPanel.add(btnUsuario);

		final JButton btnCpfUsuario = new JButton();
		tfCpfUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				DefaultTableModel model = (DefaultTableModel) tabelaHistorico
						.getModel();
				model.setNumRows(0);

				tfCliente.setText("");
				tfUsuario.setText("");
				tfCpfUsuario.setText("");
				

				getRootPane().setDefaultButton(btnCpfUsuario);

			}
		});
		btnCpfUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) tabelaHistorico
						.getModel();
				model.setNumRows(0);

				if (tfCpfUsuario.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite no campo CPF Usuário");

				} else {

					new HistoricoDao();
					listaHistorico = HistoricoDao
							.pesquisarCpfUsuario(tfCpfUsuario.getText());

					if (listaHistorico.isEmpty()) {

						JOptionPane.showMessageDialog(null,
								"Usuário não encontrado");

						tfCpfUsuario.setText("");
					} else {

						for (Historico h : listaHistorico) {

							Object[] linha = { h.getLogado(), h.getLogadoCpf(),
									h.getLocalizado(), h.getLocalizadoCpf(),
									h.getTransacao(), h.getValor(),
									h.getPontosAtualizado(),
									TelaPrincipal.ft.format(h.getData()),
									h.getHora() };

							model.addRow(linha);

						}
					}

				}
			}
		});

		btnCpfUsuario.setRolloverIcon(new ImageIcon(TelaListarHistorico.class
				.getResource("/imagens/lupa_pequena2.png")));
		btnCpfUsuario.setIcon(new ImageIcon(TelaListarHistorico.class
				.getResource("/imagens/lupa_pequena1.png")));
		btnCpfUsuario.setInheritsPopupMenu(true);
		btnCpfUsuario.setIgnoreRepaint(true);
		btnCpfUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		btnCpfUsuario.setHideActionText(true);
		btnCpfUsuario.setFocusable(false);
		btnCpfUsuario.setFocusTraversalPolicyProvider(true);
		btnCpfUsuario.setFocusCycleRoot(true);
		btnCpfUsuario.setContentAreaFilled(false);
		btnCpfUsuario.setBorderPainted(false);
		btnCpfUsuario.setBorder(null);
		btnCpfUsuario.setAutoscrolls(true);
		btnCpfUsuario.setBounds(213, 115, 46, 46);
		contentPanel.add(btnCpfUsuario);

		JLabel lblCpfCliente = new JLabel("CPF do Cliente");
		lblCpfCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpfCliente.setBounds(331, 110, 170, 18);
		contentPanel.add(lblCpfCliente);

		tfCpfCliente = new JTextField();

		tfCpfCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {

				String caracteres = "0987654321";

				if (!caracteres.contains(ev.getKeyChar() + "")) {

					ev.consume();

				}

			}
		});

		MaxLengthTextDocument maxLength1 = new MaxLengthTextDocument();
		maxLength1.setMaxChars(12);
		tfCpfCliente.setDocument(maxLength1);

		tfCpfCliente.setHorizontalAlignment(SwingConstants.CENTER);
		tfCpfCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCpfCliente.setColumns(10);
		tfCpfCliente.setBounds(331, 127, 170, 25);
		contentPanel.add(tfCpfCliente);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCliente.setBounds(331, 150, 171, 18);
		contentPanel.add(lblCliente);

		tfCliente = new JTextField();

		tfCliente.setHorizontalAlignment(SwingConstants.CENTER);
		tfCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfCliente.setColumns(10);
		tfCliente.setBounds(330, 168, 170, 25);
		contentPanel.add(tfCliente);

		final JButton btnCliente = new JButton();

		tfCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				DefaultTableModel model = (DefaultTableModel) tabelaHistorico
						.getModel();
				model.setNumRows(0);

				tfUsuario.setText("");
				tfCpfUsuario.setText("");
				tfCpfCliente.setText("");
			

				getRootPane().setDefaultButton(btnCliente);
			}
		});

		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) tabelaHistorico
						.getModel();
				model.setNumRows(0);

				if (tfCliente.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite no campo Cliente");

				} else {

					new HistoricoDao();
					listaHistorico = HistoricoDao
							.pesquisarNomeCliente(tfCliente.getText()
									.toUpperCase());

					if (listaHistorico.isEmpty()) {

						JOptionPane.showMessageDialog(null,
								"Cliente não encontrado");

						tfCliente.setText("");

					} else {

						for (Historico h : listaHistorico) {

							Object[] linha = { h.getLogado(), h.getLogadoCpf(),
									h.getLocalizado(), h.getLocalizadoCpf(),
									h.getTransacao(), h.getValor(),
									h.getPontosAtualizado(),
									TelaPrincipal.ft.format(h.getData()),
									h.getHora() };

							model.addRow(linha);
						}
					}
				}
			}
		});
		btnCliente.setIcon(new ImageIcon(TelaListarHistorico.class
				.getResource("/imagens/lupa_pequena1.png")));
		btnCliente.setRolloverIcon(new ImageIcon(TelaListarHistorico.class
				.getResource("/imagens/lupa_pequena2.png")));
		btnCliente.setInheritsPopupMenu(true);
		btnCliente.setIgnoreRepaint(true);
		btnCliente.setHideActionText(true);
		btnCliente.setFocusable(false);
		btnCliente.setFocusTraversalPolicyProvider(true);
		btnCliente.setFocusCycleRoot(true);
		btnCliente.setContentAreaFilled(false);
		btnCliente.setBorderPainted(false);
		btnCliente.setBorder(null);
		btnCliente.setAutoscrolls(true);
		btnCliente.setBounds(515, 156, 46, 46);
		contentPanel.add(btnCliente);

		final JButton btnCpfCliente = new JButton();
		tfCpfCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				DefaultTableModel model = (DefaultTableModel) tabelaHistorico
						.getModel();
				model.setNumRows(0);

				tfCliente.setText("");
				tfUsuario.setText("");
				tfCpfUsuario.setText("");
				

				getRootPane().setDefaultButton(btnCpfCliente);

			}
		});
		btnCpfCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) tabelaHistorico
						.getModel();
				model.setNumRows(0);

				if (tfCpfCliente.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite no campo CPF Cliente");

				} else {

					new HistoricoDao();
					listaHistorico = HistoricoDao
							.pesquisarCpfCliente(tfCpfCliente.getText());

					if (listaHistorico.isEmpty()) {

						JOptionPane.showMessageDialog(null,
								"Cliente não encontrado");

						tfCpfCliente.setText("");

					} else {

						for (Historico h : listaHistorico) {

							Object[] linha = { h.getLogado(), h.getLogadoCpf(),
									h.getLocalizado(), h.getLocalizadoCpf(),
									h.getTransacao(), h.getValor(),
									h.getPontosAtualizado(),
									TelaPrincipal.ft.format(h.getData()),
									h.getHora() };

							model.addRow(linha);
						}
					}
				}
			}
		});
		btnCpfCliente.setRolloverIcon(new ImageIcon(TelaListarHistorico.class
				.getResource("/imagens/lupa_pequena2.png")));
		btnCpfCliente.setIcon(new ImageIcon(TelaListarHistorico.class
				.getResource("/imagens/lupa_pequena1.png")));
		btnCpfCliente.setInheritsPopupMenu(true);
		btnCpfCliente.setIgnoreRepaint(true);
		btnCpfCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		btnCpfCliente.setHideActionText(true);
		btnCpfCliente.setFocusable(false);
		btnCpfCliente.setFocusTraversalPolicyProvider(true);
		btnCpfCliente.setFocusCycleRoot(true);
		btnCpfCliente.setContentAreaFilled(false);
		btnCpfCliente.setBorderPainted(false);
		btnCpfCliente.setBorder(null);
		btnCpfCliente.setAutoscrolls(true);
		btnCpfCliente.setBounds(515, 115, 46, 46);
		contentPanel.add(btnCpfCliente);
	}
}
