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
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import model.ClienteDao;
import model.HistoricoDao;
import controller.Cliente;
import controller.Historico;
import controller.MaxLengthTextDocument;

public class TelaCadastroCliente extends JDialog {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfNome;
	private JTextField tfNumeroCadastro;
	private JTextField tfLogradouro;
	private JTextField tfComplemento;
	private JTextField tfTelefone2;
	private JTextField tfTelefone1;
	private JTextField tfBairro;
	private JTextField tfCidade;
	int numero = 0;
	private JTextField tfPontos;
	private JTextField tfCep;
	private JTextField tfDataCadastro;
	private JTextField tfnumeroCasa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			TelaCadastroCliente dialog = new TelaCadastroCliente();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TelaCadastroCliente() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				TelaCadastroCliente.class.getResource("/imagens/dinheiro.gif")));
		setResizable(false);
		setTitle("Pontos");
		setModal(true);
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroCliente.class
				.getResource("/imagens/dinheiro2.png")));
		lblNewLabel.setBounds(507, 0, 87, 69);
		contentPanel.add(lblNewLabel);

		JLabel lblUsurioLogado = new JLabel("Usu\u00E1rio Logado: ");
		lblUsurioLogado.setForeground(Color.ORANGE);
		lblUsurioLogado.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsurioLogado.setBounds(107, 21, 137, 28);
		contentPanel.add(lblUsurioLogado);

		JLabel lblUsuarioLogado = new JLabel("Usu\u00E1rio Logado");
		lblUsuarioLogado.setForeground(Color.ORANGE);
		lblUsuarioLogado.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuarioLogado.setBounds(251, 21, 250, 28);
		lblUsuarioLogado.setText(TelaPrincipal.logado.getNome());
		contentPanel.add(lblUsuarioLogado);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaCadastroCliente.class
				.getResource("/imagens/fundo_1.jpg")));
		label.setBounds(0, 0, 600, 69);
		contentPanel.add(label);

		JPanel panel = new JPanel();
		panel.setFont(new Font("Ebrima", Font.BOLD, 12));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cadastro de Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(40, 80, 521, 248);
		contentPanel.add(panel);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(261, 24, 34, 23);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(28, 54, 53, 23);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));

		tfNome = new JTextField();
		tfNome.setBounds(101, 53, 388, 25);
		tfNome.setForeground(Color.BLACK);
		tfNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNome.setColumns(10);
		panel.setLayout(null);
		panel.add(lblCpf);
		panel.add(lblNome);
		panel.add(tfNome);

		JLabel lblPontos = new JLabel("Pontos");
		lblPontos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPontos.setBounds(28, 204, 53, 23);
		panel.add(lblPontos);

		MaxLengthTextDocument maxLength_2 = new MaxLengthTextDocument();
		maxLength_2.setMaxChars(7);

		final JFormattedTextField ftfCpf = new JFormattedTextField(
				Cliente.Mascara(""));
		ftfCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ftfCpf.setBounds(291, 23, 198, 25);
		panel.add(ftfCpf);

		JLabel lblN = new JLabel("Cadastro");
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblN.setBounds(28, 24, 53, 23);
		panel.add(lblN);

		List<Cliente> cliente = new ClienteDao().mostrarDados();

		int quantidade = 0;

		for (@SuppressWarnings("unused")
		Cliente c : cliente) {

			quantidade++;

		}

		tfNumeroCadastro = new JTextField();
		tfNumeroCadastro.setDisabledTextColor(Color.GRAY);
		tfNumeroCadastro.setText(quantidade + 1 + "");
		tfNumeroCadastro.setEditable(false);
		tfNumeroCadastro.setForeground(Color.RED);
		tfNumeroCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfNumeroCadastro.setColumns(10);
		tfNumeroCadastro.setBounds(101, 23, 90, 25);
		panel.add(tfNumeroCadastro);

		tfLogradouro = new JTextField();
		tfLogradouro.setForeground(Color.BLACK);
		tfLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfLogradouro.setColumns(10);
		tfLogradouro.setBounds(101, 83, 292, 25);
		panel.add(tfLogradouro);

		JLabel lblEndereo = new JLabel("Logradouro");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEndereo.setBounds(28, 84, 65, 23);
		panel.add(lblEndereo);

		JLabel lblComplemento = new JLabel("N.\u00BA");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblComplemento.setBounds(403, 84, 28, 23);
		panel.add(lblComplemento);

		tfComplemento = new JTextField();
		tfComplemento.setForeground(Color.BLACK);
		tfComplemento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfComplemento.setColumns(10);
		tfComplemento.setBounds(101, 113, 180, 25);
		panel.add(tfComplemento);

		JLabel lblTel = new JLabel("Fone 02");
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTel.setBounds(221, 174, 46, 23);
		panel.add(lblTel);

		tfTelefone2 = new JFormattedTextField(Cliente.Telefone(""));
		tfTelefone2.setForeground(Color.BLACK);
		tfTelefone2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTelefone2.setColumns(10);
		tfTelefone2.setBounds(277, 173, 110, 25);
		panel.add(tfTelefone2);

		JLabel lblTelefone = new JLabel("Fone 01");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone.setBounds(28, 174, 46, 23);
		panel.add(lblTelefone);

		tfTelefone1 = new JFormattedTextField(Cliente.Telefone(""));
		tfTelefone1.setForeground(Color.BLACK);
		tfTelefone1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTelefone1.setColumns(10);
		tfTelefone1.setBounds(101, 173, 110, 25);
		panel.add(tfTelefone1);

		JLabel lblCpf_1 = new JLabel("Bairro");
		lblCpf_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCpf_1.setBounds(291, 114, 40, 23);
		panel.add(lblCpf_1);

		tfBairro = new JTextField();
		tfBairro.setForeground(Color.BLACK);
		tfBairro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfBairro.setColumns(10);
		tfBairro.setBounds(329, 113, 160, 25);
		panel.add(tfBairro);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCidade.setBounds(28, 144, 53, 23);
		panel.add(lblCidade);

		tfCidade = new JTextField();
		tfCidade.setForeground(Color.BLACK);
		tfCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCidade.setColumns(10);
		tfCidade.setBounds(101, 143, 180, 25);
		panel.add(tfCidade);

		final JComboBox cbUf = new JComboBox();
		cbUf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbUf.setModel(new DefaultComboBoxModel(new String[] { "UF", "AC", "AL",
				"AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS",
				"MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO",
				"RR", "SC", "SP", "SE", "TO" }));
		cbUf.setToolTipText("");
		cbUf.setBounds(293, 143, 53, 25);
		panel.add(cbUf);

		tfPontos = new JTextField();
		tfPontos.setHorizontalAlignment(SwingConstants.LEFT);
		tfPontos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				tfPontos.selectAll();
			}
		});
		tfPontos.setText("0");
		tfPontos.setCaretColor(Color.RED);
		tfPontos.setForeground(Color.RED);
		tfPontos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfPontos.setColumns(10);
		tfPontos.setBounds(101, 203, 90, 25);
		panel.add(tfPontos);
		
		tfPontos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {

				String caracteres = "0987654321";

				if (!caracteres.contains(ev.getKeyChar() + "")) {

					ev.consume();

				}

			}
		});

		MaxLengthTextDocument maxLength_3 = new MaxLengthTextDocument();
		maxLength_3.setMaxChars(7);
		tfPontos.setDocument(maxLength_2);

		JLabel label_1 = new JLabel("Complemento");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(28, 114, 76, 23);
		panel.add(label_1);

		tfnumeroCasa = new JTextField();
		tfnumeroCasa.setForeground(Color.BLACK);
		tfnumeroCasa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfnumeroCasa.setColumns(10);
		tfnumeroCasa.setBounds(431, 83, 58, 25);
		panel.add(tfnumeroCasa);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCep.setBounds(359, 144, 34, 23);
		panel.add(lblCep);

		tfCep = new JFormattedTextField(Cliente.CEP(""));
		tfCep.setForeground(Color.BLACK);
		tfCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCep.setColumns(10);
		tfCep.setBounds(389, 143, 100, 25);
		panel.add(tfCep);

		JLabel lblDataCadastro = new JLabel("Data de Cadastro");
		lblDataCadastro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDataCadastro.setBounds(291, 204, 101, 23);
		panel.add(lblDataCadastro);

		tfDataCadastro = new JTextField();
		tfDataCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		tfDataCadastro.setEditable(false);
		tfDataCadastro.setDragEnabled(true);
		tfDataCadastro.setForeground(Color.BLACK);
		tfDataCadastro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDataCadastro.setColumns(10);
		tfDataCadastro.setBounds(388, 203, 101, 25);
		tfDataCadastro.setText(String.valueOf(TelaPrincipal.ft
				.format(TelaPrincipal.dataAtual)));
		panel.add(tfDataCadastro);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnCancelar.setRolloverIcon(new ImageIcon(TelaCadastroCliente.class
				.getResource("/imagens/fundo_2.jpg")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});

		final JButton btImpressao = new JButton("Imprimir Cart\u00E3o");
		btImpressao.setRolloverIcon(new ImageIcon(TelaCadastroCliente.class
				.getResource("/imagens/fundo_2.jpg")));
		btImpressao.setIcon(new ImageIcon(TelaCadastroCliente.class
				.getResource("/imagens/fundo_1.jpg")));
		btImpressao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tfNome.getText().equals("")
						|| tfPontos.getText().equals("")
						|| ftfCpf.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Cadastre um Cliente Primeiro");

				} else {

					int resposta = JOptionPane.showConfirmDialog(null,
							"Deseja realmente fazer a impressão do cartão?");

					if (resposta == 0) {

						try {
							impressao.ControleImpressao.criarPdf(
									TelaPrincipal.localizado.getNome(),
									TelaPrincipal.localizado.getCpf());

						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} else if (resposta == 1) {

						JOptionPane.showMessageDialog(null,
								"Não desejo fazer a impressão do cartão");

					}

				}

				dispose();

				TelaPrincipal.localizado.setCpf("");
			}
		});
		btImpressao.setHorizontalTextPosition(SwingConstants.CENTER);
		btImpressao.setForeground(Color.WHITE);
		btImpressao.setFont(new Font("Tahoma", Font.BOLD, 13));
		btImpressao.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btImpressao.setBounds(184, 339, 119, 28);
		btImpressao.setVisible(false);
		contentPanel.add(btImpressao);

		btnCancelar.setIcon(new ImageIcon(TelaCadastroCliente.class
				.getResource("/imagens/fundo_1.jpg")));
		btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(442, 339, 119, 28);
		contentPanel.add(btnCancelar);

		final JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(313, 339, 119, 28);
		contentPanel.add(btnConfirmar);
		btnConfirmar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Cliente impressao = new Cliente();

				if (tfNome.getText().equalsIgnoreCase("")
						|| ftfCpf.getText().equalsIgnoreCase("")
						|| tfPontos.getText().equals("")
						|| tfLogradouro.getText().equals("")
						|| tfnumeroCasa.getText().equals("")
						|| tfBairro.getText().equals("")
						|| tfCidade.getText().equals("")
						|| cbUf.getKeySelectionManager().equals("UF")) {

					JOptionPane.showMessageDialog(null,
							"Digite em todos os campos obrigatórios");

				} else {

					boolean valido = controller.ValidarCpf.isCPF(Cliente
							.removerMascara(ftfCpf.getText()));

					if (valido == false) {

						JOptionPane.showMessageDialog(null, "CPF inválido");

						ftfCpf.setText("");
						ftfCpf.requestFocus();

					} else if (valido == true) {

						int resposta = JOptionPane.showConfirmDialog(null,
								"Deseja realmente cadastrar um novo Cliente");

						if (resposta == 0) {
							
							Date data = new Date();
							
							ClienteDao clienteDao = new ClienteDao();
							impressao = clienteDao.inserirDadosClientes(new Cliente(
									tfNome.getText().toUpperCase(), Cliente
											.removerMascara(ftfCpf.getText()),
									Integer.parseInt(tfPontos.getText()),
									tfLogradouro.getText().toUpperCase(),
									tfnumeroCasa.getText(), tfComplemento
											.getText().toUpperCase(), tfBairro
											.getText().toUpperCase(), tfCidade
											.getText().toUpperCase(), String
											.valueOf(cbUf.getSelectedItem()),
									tfCep.getText(), tfTelefone1.getText(),
									tfTelefone2.getText(),
									new java.sql.Date(data.getTime())));

							String transacao = "Adicionar";
							
							
							long hora = System.currentTimeMillis();
							
							Historico historico = new Historico(
									TelaPrincipal.logado.getNome().toUpperCase(),
									TelaPrincipal.logado.getCpf(), tfNome
											.getText().toUpperCase(), Cliente
											.removerMascara(ftfCpf.getText()),
									transacao, Integer.parseInt(tfPontos
											.getText()), Integer
											.parseInt(tfPontos.getText()),
											new java.sql.Date(data.getTime()),
									new java.sql.Time(hora));
							

							HistoricoDao historicoDao = new HistoricoDao();
							historicoDao.inserirHistorico(historico);

							if (impressao.getCpf() == null) {

								ftfCpf.setText("");
								ftfCpf.requestFocus();

							} else {

								TelaPrincipal.localizado = impressao;

								btnConfirmar.setEnabled(false);
								btImpressao.setVisible(true);
								btImpressao.requestFocus();

								tfNome.setEditable(false);
								tfPontos.setEditable(false);
								ftfCpf.setEditable(false);

							}

						} else if (resposta == 1) {

							JOptionPane.showMessageDialog(null,
									"Não desejo cadastrar o Cliente?");

							tfNome.setText("");
							tfPontos.setText("");
							ftfCpf.setText("");
							tfNome.requestFocus();

						}

					}

				}
			}
		});
		btnConfirmar.setRolloverIcon(new ImageIcon(TelaCadastroCliente.class
				.getResource("/imagens/fundo_2.jpg")));
		btnConfirmar.setIcon(new ImageIcon(TelaCadastroCliente.class
				.getResource("/imagens/fundo_1.jpg")));
		btnConfirmar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 13));
		getRootPane().setDefaultButton(btnConfirmar);

	}
}
