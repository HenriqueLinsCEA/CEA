package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

//import javafx.scene.control.ComboBox;
//import javafx.scene.control.RadioButton;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeCellEditor.DefaultTextField;

import controller.Cliente;
import controller.Contato;
import controller.ControleMetodosCliente;
import controller.ControleMetodosContato;
import controller.ControleMetodosEndereco;
import controller.ControleMetodosLayout;
import controller.ControleMetodosTipoAcesso;
import controller.ControleMetodosUsuario;
import controller.Endereco;
import controller.Imagem;
import controller.Layout;
import controller.MaxLengthTextDocument;
import controller.TipoAcesso;
import controller.Usuario;

import java.awt.Toolkit;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.border.EtchedBorder;

//import com.sun.javafx.collections.ListListenerHelper;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JList;

import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

import model.ClienteDao;
import model.ConectarBanco;
import javax.swing.ScrollPaneConstants;
import java.awt.Frame;

public class JfPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7437939733514662038L;
	private JPanel contentPane;
	static JTextField tfPesquisaCliente;
	private JTextField tfRazaoSocial;
	private JTextField tfNomeFantasia;
	private JTextField tfCnpj;
	private JTextField tfContato;
	private JTextField tfVendedor;
	private JTextField tfEmailCliente;
	private JFormattedTextField tfTelefoneCliente2;
	private JTextField tfLogradouroCliente;
	private JTextField tfNumeroCliente;
	private JTextField tfComplementoCliente;
	private JTextField tfBairroCliente;
	private JTextField tfCidadeCliente;
	private JFormattedTextField tfCepCliente;
	private final ButtonGroup btgEspessura = new ButtonGroup();
	private JTextField tfLayoutFrente;
	private JTextField tfLayoutVerso;
	private JTextField tfNomeCompleto;
	private JFormattedTextField tfCpf;
	private JTextField tfLogin;
	private JPasswordField tfSenha;
	private JPasswordField tfRepetirSenha;
	private JTextField tfEmail;
	private JFormattedTextField tfTelefone1;
	private JFormattedTextField tfTelefone2;
	private JTextField tfLogradouro;
	private JTextField tfNumero;
	private JTextField tfComplemento;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JFormattedTextField tfCep;
	private JTextField tfCorProtetorRigido;
	private final ButtonGroup btgPresilhaOuCordao = new ButtonGroup();
	private final ButtonGroup btgAdmOper = new ButtonGroup();
	private JFormattedTextField tfTelefoneCliente1;
	@SuppressWarnings("rawtypes")
	private JComboBox cbClasseDoProduto;
	@SuppressWarnings("rawtypes")
	private JComboBox cbnOrientacaoDoCracha;
	@SuppressWarnings("rawtypes")
	private JComboBox cbnProtetor;
	private static int id_cliente;
	private static int id_layout;
	private JCheckBox chckbxTecnologiaDeAcesso;
	private final ButtonGroup btgFrenteFrenteVerso = new ButtonGroup();
	public static Imagem crachaFrente = new Imagem("/images/lupa_pequena2.png");
	public static Imagem crachaVerso = new Imagem("/images/lupa_pequena2.png");
	public static String frente;
	public static String verso;
	private static JLabel lb_FrenteCracha;
	private static JLabel lb_VersoCracha;
	private static JLabel lbFCrachaFrente;
	private static JLabel lbFCrachaVerso;
	private static JLabel lbFCLocalFrente;
	private static JLabel lbFCLocalVerso;
	private static JTable tabelaClientes;
	static java.util.List<Cliente> listaCliente;
	static java.util.List<Layout> listaLayout;
	private JTextField tfFCNomeFantasia;
	private JTextField tfFCRazaoSocial;
	private JTextField tfFCCnpj;
	JPanel JpanelPrincipal;
	JPanel JpanelSecundario;
	private JTextField tfFCVendedor;
	private Cliente localizadoCliente;
	private Contato localizadoContato;
	private Endereco localizadoEndereco;
	private Layout localizadoLayout;
	private TipoAcesso localizadoTipoAcesso;
	private JTextField tfFCContato;
	private JTextField tfFCEmail;
	private JTextField tfFCTelefone1;
	private JTextField tfFCTelefone2;
	private JTextField tfFCLogradouro;
	private JTextField tfFCComplemento;
	private JTextField tfFCNumero;
	private JTextField tfFCBairro;
	private JTextField tfFCCidade;
	private JTextField tfFCCep;
	private JTextField tfFCrachaProduto;
	private JTextField tfFCrachaTipoDoProduto;
	private JTextField tfFCrachaEspessura;
	private JTextField tfFCrachaClasseDoProduto;
	private JTextField tfFCrachaFurado;
	private JTextField tfFCrachaPresilhaCordao;
	private JTextField tfFCrachaOrientacao;
	private JTextField tfFCrachaProtetor;
	private JTextField tfFCrachaProtetorCor;
	private JTextField tfFCrachaImpressaoFace;
	private JTextField tfFCrachaTecnologiaAcesso;
	private JTextField tfFCrachaCodigoDeBarras;
	private JTextField tfFCrachaTipoCodBarras;
	private JTextField tfFCrachaTarjaMagnetica;
	private JTextField tfFCrachaTarja01;
	private JTextField tfFCrachaTarja02;
	private JTextField tfFCrachaTarja03;
	private JTextField tfFCrachaProximidade;
	private JTextField tfFCrachaNumeroDeDigitos;
	private JTextField tfFCrachaTipoProximidade;
	private JTextField tfFCrachaTipoTarjaMagnetica;
	private JButton btnPesquisaCliente;
	private JTextField tfFCUf;
	private JRadioButton rdbtnPresilha;
	private JRadioButton rdbtnCordao;
	private JLabel lbCor;
	private JComboBox cbDigitos;
	private JComboBox cbTipoTarja;
	private JCheckBox chckbxTrilha1;
	private JCheckBox chckbxTrilha2;
	private JCheckBox chckbxTrilha3;
	private JComboBox cbTipoTecnologia;
	private JCheckBox chckbxProximidade;
	private JCheckBox chckbxTarjaMagnetica;
	private JCheckBox chckbxCodigoDeBarras;
	private JRadioButton rdbtnFrente;
	private JRadioButton rdbtnFrenteEVerso;
	private JCheckBox chckbxFurado;
	private JComboBox cbProduto;
	private JComboBox cbTipoMaterial;
	private JComboBox cbPadraoCodigoDeBarras;
	private CardLayout cardlayout;
	private CardLayout cardlayout2;
	private JPanel card0;
	private JPanel card01;
	private JPanel card02;
	private JPanel card03;
	private JPanel card04;
	private JPanel card05;
	private JPanel cardCliente;
	private JPanel cardCracha;
	private JPanel JpanelCliente;
	private JButton btnSairCliente;
	private JButton btnConfirmarNovoLayout;
	private JComboBox cbUfCliente;
	private JButton btnAreaUsuario;
	private JButton btnNovoUsuario;
	private JPanel pFrente;
	private JPanel pVerso;
	private JButton btnNovoCliente;
	private JTabbedPane tpLayout;
	private JTabbedPane tabbedPaneAreaUsuario;
	private JPanel pFCrachaFrente;
	private JPanel pFCrachaVerso;
	private JTabbedPane tabbedPaneFrenteVerso;
	private Layout layCorreto;
	private TipoAcesso tipoAcesso;
	private JTable tbLayout;
	private JLabel lbLayoutFrente;
	private JLabel lbLayoutVerso;
	static Usuario logado = new Usuario();
	private JTextField tfUsuarioLogado;
	private JScrollPane spnListaClientes;
	private JComboBox cbUf;
	private JLabel lbCampoObrigatorio;
	private JTextField txtAUCpesquisar;
	private JTable tbAUCpesquisar;
	private JButton btnExcluirAUCliente;
	private JButton btnEditarAUCliente;
	private JComboBox cbAUUpesquisar;
	private JTextField txtAUUpesquisar;
	private JButton btnAUUpesquisarOk;
	private JScrollPane scrollPaneAUUsuario;
	private JButton btnEditarAUUsuario;
	private JButton btnExluirAUUsuario;
	private JTable tbAUUsuario;
	private JButton btnAUCpesquisarOK;
	private JTextField tfConfHost;
	private JTextField tfConfPorta;
	private JTextField tfConfLogin;
	private JPasswordField pfConfSenha;
	private JButton btnConfConfirmar;
	private JButton btnSairCardCliente;
	private JLabel lbACinfo;
	private JButton btnEditarAULayout;

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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @return
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JfPrincipal() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				JfPrincipal.class
						.getResource("/images/techvan_transparente.png")));
		setName("");
		setTitle("Layouts");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('a');
		menuBar.add(mnArquivo);

		JMenuItem mntmNovoCliente = new JMenuItem("Novo Cliente");
		mntmNovoCliente.setIcon(null);

		mntmNovoCliente.setMnemonic('c');
		mnArquivo.add(mntmNovoCliente);

		JMenuItem mntmFechar = new JMenuItem("Fechar");
		mntmFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});

		JMenuItem mntmNovoUsurio = new JMenuItem("Novo Usu\u00E1rio");
		mntmNovoUsurio.setMnemonic('u');
		mntmNovoUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JpanelPrincipal.setVisible(true);
				JpanelSecundario.setVisible(true);
				JpanelCliente.setVisible(false);
				cardlayout.show(JpanelSecundario, "frame02");

				tfPesquisaCliente.setText("");
				spnListaClientes.setVisible(false);

				btnNovoCliente.setEnabled(false);
				btnNovoUsuario.setEnabled(false);
				btnAreaUsuario.setEnabled(false);
				btnPesquisaCliente.setEnabled(false);
				tfPesquisaCliente.setEnabled(false);

				btgAdmOper.clearSelection();
				tfNomeCompleto.setText("");
				tfCpf.setText("");
				tfLogin.setText("");
				tfSenha.setText("");
				tfRepetirSenha.setText("");
				tfEmail.setText("");
				tfTelefone1.setText("");
				tfTelefone2.setText("");
				tfLogradouro.setText("");
				tfNumero.setText("");
				tfComplemento.setText("");
				tfBairro.setText("");
				tfCidade.setText("");
				cbUf.setSelectedIndex(0);
				tfCep.setText("");

			}
		});

		mnArquivo.add(mntmNovoUsurio);
		mntmFechar.setMnemonic('f');
		mnArquivo.add(mntmFechar);

		JMenu mnAjuda = new JMenu("Ajuda");
		mnAjuda.setMnemonic('j');
		menuBar.add(mnAjuda);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Sobre");
		mntmNewMenuItem_3.setMnemonic('s');
		mnAjuda.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(800, 600));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon icon2 = new ImageIcon(JfPrincipal.class.getResource(""));

		JpanelPrincipal = new JPanel();
		JpanelPrincipal.setIgnoreRepaint(true);
		JpanelPrincipal.setInheritsPopupMenu(true);
		JpanelPrincipal.setFocusable(false);
		JpanelPrincipal.setFocusTraversalPolicyProvider(true);
		JpanelPrincipal.setFocusCycleRoot(true);
		JpanelPrincipal.setDoubleBuffered(false);
		JpanelPrincipal.setAutoscrolls(true);
		JpanelPrincipal.setBorder(null);
		JpanelPrincipal.setBounds(0, 0, 250, 486);
		contentPane.add(JpanelPrincipal);
		JpanelPrincipal.setLayout(null);

		btnNovoCliente = new JButton("Novo Cliente");
		btnNovoCliente.setMnemonic('N');

		btnNovoCliente.setBounds(63, 280, 120, 23);
		JpanelPrincipal.add(btnNovoCliente);

		btnNovoUsuario = new JButton("Novo Usu\u00E1rio");
		btnNovoUsuario.setMnemonic('U');

		btnNovoUsuario.setBounds(63, 333, 120, 23);
		JpanelPrincipal.add(btnNovoUsuario);

		btnAreaUsuario = new JButton("\u00C1rea Usu\u00E1rio");
		btnAreaUsuario.setMnemonic('r');

		btnAreaUsuario.setBounds(63, 387, 120, 23);

		if (logado.getTipo().equalsIgnoreCase("ADMINISTRADOR")) {

			btnAreaUsuario.setEnabled(true);

		} else {

			btnAreaUsuario.setEnabled(false);

		}

		JpanelPrincipal.add(btnAreaUsuario);

		JLabel lblPesquisaCliente = new JLabel("Pesquisar Cliente");
		lblPesquisaCliente.setBounds(24, 68, 131, 14);
		JpanelPrincipal.add(lblPesquisaCliente);

		tfPesquisaCliente = new JTextField();
		tfPesquisaCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {

				rootPane.setDefaultButton(btnPesquisaCliente);

			}
		});
		tfPesquisaCliente.setBounds(23, 88, 150, 20);
		JpanelPrincipal.add(tfPesquisaCliente);
		tfPesquisaCliente.setColumns(10);

		spnListaClientes = new JScrollPane();
		spnListaClientes.setVisible(false);
		spnListaClientes.setBounds(24, 134, 200, 135);
		JpanelPrincipal.add(spnListaClientes);

		tabelaClientes = new JTable();
		tabelaClientes.setModel(new DefaultTableModel(new Object[][] {
				{ null }, { null }, { null }, { null }, { null }, { null },
				{ null }, }, new String[] { "Cliente" }) {
			Class[] columnTypes = new Class[] { String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabelaClientes.getColumnModel().getColumn(0).setResizable(false);
		tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(243);

		spnListaClientes.setViewportView(tabelaClientes);

		tabelaClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int posicao = tabelaClientes.getSelectedRow();

				String pesquisarNome = listaCliente.get(posicao).getNome();

				localizadoCliente = ControleMetodosCliente
						.pesquisarUnicoCliente(pesquisarNome.toUpperCase());

				localizadoContato = ControleMetodosContato
						.pesquisarContatoEndereco((localizadoCliente
								.getId_cliente()));

				localizadoEndereco = ControleMetodosEndereco
						.pesquisarEnderecoCliente(localizadoCliente
								.getId_cliente());

				localizadoLayout = ControleMetodosLayout
						.pesquisarLayout(localizadoCliente.getId_cliente());

				localizadoTipoAcesso = ControleMetodosTipoAcesso
						.pesquisarTipoAcesso(localizadoLayout.getId_layout());

				tfFCNomeFantasia.setText(localizadoCliente.getNome());
				tfFCRazaoSocial.setText(localizadoCliente.getRazaoSocial());
				tfFCCnpj.setText(localizadoCliente.getCnpj());
				tfFCVendedor.setText(localizadoCliente.getVendedor());

				tfFCContato.setText(localizadoContato.getNomeParaContato());
				tfFCEmail.setText(localizadoContato.getEmail());
				tfFCTelefone1.setText(localizadoContato.getTelefone1());
				tfFCTelefone2.setText(localizadoContato.getTelefone2());

				tfFCLogradouro.setText(localizadoEndereco.getLogradouro());
				tfFCComplemento.setText(localizadoEndereco.getComplemento());
				tfFCNumero.setText(localizadoEndereco.getNumero());

				tfFCBairro.setText(localizadoEndereco.getBairro());
				tfFCCidade.setText(localizadoEndereco.getCidade());
				tfFCUf.setText(localizadoEndereco.getUf());
				tfFCCep.setText(localizadoEndereco.getCep());

				tfFCrachaProduto.setText(localizadoLayout.getProduto());
				tfFCrachaTipoDoProduto.setText(localizadoLayout
						.getTipoProduto());
				tfFCrachaEspessura.setText(localizadoLayout.getEspessura());
				tfFCrachaClasseDoProduto.setText(localizadoLayout
						.getClasseProduto());
				tfFCrachaPresilhaCordao.setText(localizadoLayout
						.getPresilhaOuCordao());
				tfFCrachaOrientacao.setText(localizadoLayout.getOrientacao());
				tfFCrachaProtetor.setText(localizadoLayout.getProtetor());
				tfFCrachaProtetorCor.setText(localizadoLayout.getCor());
				tfFCrachaImpressaoFace.setText(localizadoLayout.getImpressao());
				tfFCrachaFurado.setText(ControleMetodosLayout
						.simNao(localizadoLayout.isFurado()));
				tfFCrachaTecnologiaAcesso.setText(ControleMetodosLayout
						.simNao(localizadoLayout.isAcesso()));

				listaLayout = ControleMetodosLayout
						.listarLayout(localizadoCliente.getId_cliente());

				DefaultTableModel model1 = (DefaultTableModel) tbLayout
						.getModel();

				model1.setNumRows(0);
				int i = 1;

				for (Layout lay : listaLayout) {

					Object[] linha = { i, lay.getClasseProduto() };

					model1.addRow(linha);

					i++;

				}

				tfFCrachaCodigoDeBarras.setText(ControleMetodosLayout
						.simNao(localizadoTipoAcesso.isCodigoDeBarras()));
				tfFCrachaTipoCodBarras.setText(localizadoTipoAcesso
						.getPadraoCodigoDeBarras());
				tfFCrachaNumeroDeDigitos.setText(localizadoTipoAcesso
						.getDigitos());
				tfFCrachaTarjaMagnetica.setText(ControleMetodosLayout
						.simNao(localizadoTipoAcesso.isTarjaMagnetica()));
				tfFCrachaTipoTarjaMagnetica.setText(localizadoTipoAcesso
						.getTipoTarja());
				tfFCrachaTarja01.setText(ControleMetodosLayout
						.simNao(localizadoTipoAcesso.isTarja1()));
				tfFCrachaTarja02.setText(ControleMetodosLayout
						.simNao(localizadoTipoAcesso.isTarja2()));
				tfFCrachaTarja03.setText(ControleMetodosLayout
						.simNao(localizadoTipoAcesso.isTarja3()));
				tfFCrachaProximidade.setText(ControleMetodosLayout
						.simNao(localizadoTipoAcesso.isProximidade()));
				tfFCrachaTipoProximidade.setText(localizadoTipoAcesso
						.getTipoCartaoProximidade());

				JpanelPrincipal.setVisible(false);
				JpanelSecundario.setVisible(false);
				JpanelCliente.setVisible(true);

				cardlayout2.show(JpanelCliente, "frameCliente");

				DefaultTableModel model = (DefaultTableModel) tabelaClientes
						.getModel();

				model.setNumRows(0);

			}
		});

		btnPesquisaCliente = new JButton("");

		btnPesquisaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tfPesquisaCliente.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite o nome do cliente");

				} else {

					new ControleMetodosCliente();
					listaCliente = ControleMetodosCliente
							.pesquisarCliente(tfPesquisaCliente.getText()
									.toUpperCase());

					if (listaCliente.isEmpty()) {

						spnListaClientes.setVisible(false);

						JOptionPane.showMessageDialog(null,
								"Cliente não Localizado");

						DefaultTableModel model = (DefaultTableModel) tabelaClientes
								.getModel();

						model.setNumRows(0);

					} else {

						spnListaClientes.setVisible(true);

						DefaultTableModel model = (DefaultTableModel) tabelaClientes
								.getModel();

						model.setNumRows(0);

						tabelaClientes.setVisible(true);

						for (Cliente c : listaCliente) {

							Object[] linha = { c.getNome() };

							model.addRow(linha);

						}

					}

				}

			}
		});
		btnPesquisaCliente.setContentAreaFilled(false);
		btnPesquisaCliente.setHideActionText(true);
		btnPesquisaCliente.setFocusTraversalPolicyProvider(true);
		btnPesquisaCliente.setFocusCycleRoot(true);
		btnPesquisaCliente.setIgnoreRepaint(true);
		btnPesquisaCliente.setBorderPainted(false);
		btnPesquisaCliente.setAutoscrolls(true);
		btnPesquisaCliente.setInheritsPopupMenu(true);
		btnPesquisaCliente.setFocusable(false);
		btnPesquisaCliente.setRolloverIcon(new ImageIcon(JfPrincipal.class
				.getResource("/images/lupa_pequena2.png")));
		btnPesquisaCliente.setIcon(new ImageIcon(JfPrincipal.class
				.getResource("/images/lupa_pequena1.png")));
		btnPesquisaCliente.setBounds(180, 79, 44, 40);
		JpanelPrincipal.add(btnPesquisaCliente);

		JLabel lbUsuarioLogado = new JLabel("Usu\u00E1rio Logado");
		lbUsuarioLogado.setBounds(24, 11, 101, 14);
		JpanelPrincipal.add(lbUsuarioLogado);

		tfUsuarioLogado = new JTextField();
		tfUsuarioLogado.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfUsuarioLogado.setBorder(null);
		tfUsuarioLogado.setBounds(24, 36, 200, 20);
		JpanelPrincipal.add(tfUsuarioLogado);
		tfUsuarioLogado.setColumns(10);
		tfUsuarioLogado.setText(logado.getNome());
		tfUsuarioLogado.setEditable(false);

		JpanelSecundario = new JPanel();
		JpanelSecundario.setBounds(248, 0, 536, 486);
		contentPane.add(JpanelSecundario);

		cardlayout = new CardLayout();

		card0 = new JPanel();
		card01 = new JPanel();
		card02 = new JPanel();
		card03 = new JPanel();
		card05 = new JPanel();

		JpanelSecundario.setLayout(cardlayout);

		JpanelSecundario.add(card0, "frame0");
		JpanelSecundario.add(card01, "frame01");
		JpanelSecundario.add(card02, "frame02");
		JpanelSecundario.add(card03, "frame03");
		final JPanel card04 = new JPanel();
		JpanelSecundario.add(card04, "frame04");

		card04.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(52, 60, 430, 9);
		card04.add(separator);

		JLabel lbAdicionarLayouts = new JLabel("Adicionar Layout");
		lbAdicionarLayouts.setForeground(Color.BLACK);
		lbAdicionarLayouts.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbAdicionarLayouts.setBounds(52, 36, 169, 14);
		card04.add(lbAdicionarLayouts);

		cbPadraoCodigoDeBarras = new JComboBox();
		cbPadraoCodigoDeBarras.setModel(new DefaultComboBoxModel(new String[] {
				"Padr\u00E3o do C\u00F3digo de Barras",
				"2 de 5  - Padr\u00E3o Livre", "2 de 5 - M\u00F3dulo 11",
				"2 de 5 - Codin Junior", "2 de 5 - T1000",
				"2 de 5 - Criptografado", "3 de 9", "EAN 13" }));
		cbPadraoCodigoDeBarras.setBounds(172, 240, 220, 20);
		cbPadraoCodigoDeBarras.setVisible(false);
		card04.add(cbPadraoCodigoDeBarras);

		chckbxFurado = new JCheckBox("Furado");
		chckbxFurado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (chckbxFurado.isSelected()) {

					rdbtnCordao.setVisible(true);
					rdbtnPresilha.setVisible(true);

				} else {

					rdbtnCordao.setVisible(false);
					rdbtnPresilha.setVisible(false);

				}

			}
		});

		chckbxFurado.setBounds(52, 139, 73, 23);
		card04.add(chckbxFurado);

		chckbxCodigoDeBarras = new JCheckBox("C\u00F3digo de Barras");
		chckbxCodigoDeBarras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				chckbxTarjaMagnetica.setVisible(false);
				chckbxProximidade.setVisible(false);

				if (chckbxCodigoDeBarras.isSelected() == true) {

					cbPadraoCodigoDeBarras.setVisible(true);
					cbDigitos.setVisible(true);

				} else {

					cbPadraoCodigoDeBarras.setVisible(false);
					cbDigitos.setVisible(false);

					chckbxTarjaMagnetica.setVisible(true);
					chckbxProximidade.setVisible(true);

				}

			}
		});
		chckbxCodigoDeBarras.setBounds(52, 239, 107, 23);
		chckbxCodigoDeBarras.setVisible(false);
		card04.add(chckbxCodigoDeBarras);

		cbProduto = new JComboBox();
		cbProduto.setModel(new DefaultComboBoxModel(new String[] { "Produto",
				"Techcard", "Techzero", "Techzero Adesivado",
				"Techcard Mifare", "Techzero + Mifare", "Techzero + Akura",
				"PVC", "" }));
		cbProduto.setBounds(52, 80, 132, 20);
		card04.add(cbProduto);

		cbTipoMaterial = new JComboBox();
		cbTipoMaterial.setModel(new DefaultComboBoxModel(new String[] {
				"Tipo do Produto", "Crach\u00E1", "Carteira", "Cartao",
				"Credencial", "Chaveiro", "Boton" }));
		cbTipoMaterial.setBounds(199, 80, 132, 20);
		card04.add(cbTipoMaterial);

		final JRadioButton rdbtnEspessura046 = new JRadioButton("0,46");
		btgEspessura.add(rdbtnEspessura046);
		rdbtnEspessura046.setActionCommand("0,46");
		rdbtnEspessura046.setBounds(52, 107, 47, 23);
		card04.add(rdbtnEspessura046);

		final JRadioButton rdbtnEspessura076 = new JRadioButton("0,76");
		btgEspessura.add(rdbtnEspessura076);
		rdbtnEspessura076.setActionCommand("0,76");
		rdbtnEspessura076.setBounds(119, 107, 47, 23);
		card04.add(rdbtnEspessura076);

		cbDigitos = new JComboBox();
		cbDigitos.setModel(new DefaultComboBoxModel(new String[] {
				"D\u00EDgitos", "04", "05", "06", "07", "08", "09", "10", "11",
				"12" }));
		cbDigitos.setBounds(422, 240, 60, 20);
		cbDigitos.setVisible(false);
		card04.add(cbDigitos);

		chckbxTarjaMagnetica = new JCheckBox("Tarja Magn\u00E9tica");
		chckbxTarjaMagnetica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				chckbxCodigoDeBarras.setVisible(false);
				chckbxProximidade.setVisible(false);

				if (chckbxTarjaMagnetica.isSelected() == true) {

					cbTipoTarja.setVisible(true);
					chckbxTrilha1.setVisible(true);
					chckbxTrilha2.setVisible(true);
					chckbxTrilha3.setVisible(true);

				} else {

					cbTipoTarja.setVisible(false);
					chckbxTrilha1.setVisible(false);
					chckbxTrilha2.setVisible(false);
					chckbxTrilha3.setVisible(false);

					chckbxCodigoDeBarras.setVisible(true);
					chckbxProximidade.setVisible(true);

				}

			}
		});
		chckbxTarjaMagnetica.setBounds(52, 267, 107, 23);
		chckbxTarjaMagnetica.setVisible(false);
		card04.add(chckbxTarjaMagnetica);

		chckbxTrilha1 = new JCheckBox("Trilha 01");
		chckbxTrilha1.setBounds(275, 267, 67, 23);
		chckbxTrilha1.setVisible(false);
		card04.add(chckbxTrilha1);

		chckbxTrilha2 = new JCheckBox("Trilha 02");
		chckbxTrilha2.setBounds(344, 267, 73, 23);
		chckbxTrilha2.setVisible(false);
		card04.add(chckbxTrilha2);

		chckbxTrilha3 = new JCheckBox("Trilha 03");
		chckbxTrilha3.setBounds(418, 267, 67, 23);
		chckbxTrilha3.setVisible(false);
		card04.add(chckbxTrilha3);

		cbTipoTarja = new JComboBox();
		cbTipoTarja.setModel(new DefaultComboBoxModel(new String[] {
				"Tipo de Tarja", "Alta", "Baixa" }));
		cbTipoTarja.setBounds(172, 268, 97, 20);
		cbTipoTarja.setVisible(false);
		card04.add(cbTipoTarja);

		chckbxProximidade = new JCheckBox("Proximidade");
		chckbxProximidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				chckbxCodigoDeBarras.setVisible(false);
				chckbxTarjaMagnetica.setVisible(false);

				if (chckbxProximidade.isSelected() == true) {

					cbTipoTecnologia.setVisible(true);

				} else {

					cbTipoTecnologia.setVisible(false);

					chckbxCodigoDeBarras.setVisible(true);
					chckbxTarjaMagnetica.setVisible(true);

				}

			}
		});
		chckbxProximidade.setBounds(52, 295, 107, 23);
		chckbxProximidade.setVisible(false);
		card04.add(chckbxProximidade);

		cbTipoTecnologia = new JComboBox();
		cbTipoTecnologia.setModel(new DefaultComboBoxModel(new String[] {
				"Tipo Tecnologia", "Mifare", "Acura", "ID", "Motorola" }));
		cbTipoTecnologia.setBounds(172, 295, 122, 20);
		cbTipoTecnologia.setVisible(false);
		card04.add(cbTipoTecnologia);

		final JLabel lblLayoutFrente = new JLabel("Layout frente");
		lblLayoutFrente.setBounds(182, 358, 87, 14);
		lblLayoutFrente.setVisible(false);
		card04.add(lblLayoutFrente);

		tfLayoutFrente = new JTextField();
		tfLayoutFrente.setBounds(182, 373, 232, 20);
		card04.add(tfLayoutFrente);
		tfLayoutFrente.setVisible(false);
		tfLayoutFrente.setColumns(10);

		final JLabel lblLayoutVerso = new JLabel("Layout verso");
		lblLayoutVerso.setBounds(182, 392, 87, 14);
		lblLayoutVerso.setVisible(false);
		card04.add(lblLayoutVerso);

		tfLayoutVerso = new JTextField();
		tfLayoutVerso.setColumns(10);
		tfLayoutVerso.setBounds(182, 407, 232, 20);
		tfLayoutVerso.setVisible(false);
		card04.add(tfLayoutVerso);

		final JButton btnAbrirLayoutFrente = new JButton("Abrir");
		btnAbrirLayoutFrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser escolherArquivo = new JFileChooser();
				FileNameExtensionFilter filtroExtensao = new FileNameExtensionFilter(
						".jpg", "jpg");
				escolherArquivo.addChoosableFileFilter(filtroExtensao);

				int retorno = escolherArquivo.showDialog(null,
						"Selecionar Imagem");

				if (retorno == JFileChooser.APPROVE_OPTION) {

					File arquivo = null;
					arquivo = escolherArquivo.getSelectedFile();
					escolherArquivo.setSelectedFile(arquivo);

					JOptionPane.showMessageDialog(null, arquivo);
					tfLayoutFrente.setText(arquivo.getPath());

				}

			}
		});
		btnAbrirLayoutFrente.setBounds(422, 373, 60, 20);
		btnAbrirLayoutFrente.setVisible(false);
		card04.add(btnAbrirLayoutFrente);

		final JButton btnAbrirLayoutVerso = new JButton("Abrir");
		btnAbrirLayoutVerso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser escolherArquivo = new JFileChooser();
				FileNameExtensionFilter filtroExtensao = new FileNameExtensionFilter(
						".jpg", "jpg");
				escolherArquivo.addChoosableFileFilter(filtroExtensao);

				int retorno = escolherArquivo.showDialog(null,
						"Selecionar Imagem");

				if (retorno == JFileChooser.APPROVE_OPTION) {

					File arquivo = null;

					arquivo = escolherArquivo.getSelectedFile();

					escolherArquivo.setSelectedFile(arquivo);

					JOptionPane.showMessageDialog(null, arquivo);
					tfLayoutVerso.setText(arquivo.getPath());

				}

			}
		});
		btnAbrirLayoutVerso.setBounds(422, 407, 60, 20);
		btnAbrirLayoutVerso.setVisible(false);
		card04.add(btnAbrirLayoutVerso);

		tfCorProtetorRigido = new JTextField();
		tfCorProtetorRigido.setBounds(378, 169, 104, 20);
		tfCorProtetorRigido.setVisible(false);
		card04.add(tfCorProtetorRigido);

		JButton btnCancelarLayout = new JButton("Cancelar");
		btnCancelarLayout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				cardlayout.show(JpanelSecundario, "frame01");

				btnConfirmarNovoLayout.setText("Adicionar Layout");

				cardlayout.show(JpanelSecundario, "frame01");

			}
		});
		btnCancelarLayout.setBounds(294, 438, 89, 23);
		card04.add(btnCancelarLayout);

		JButton btnConfirmarLayout = new JButton("Confirmar");
		btnConfirmarLayout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String presilhaOuCordao;

				String padraoCodigoDeBarras = String
						.valueOf(cbPadraoCodigoDeBarras.getSelectedItem());
				String digitos = String.valueOf(cbDigitos.getSelectedItem());
				String tipoDeTarja = String.valueOf(cbTipoTarja
						.getSelectedItem());
				String tipoTecnologia = String.valueOf(cbTipoTecnologia
						.getSelectedItem());

				if (chckbxFurado.isSelected() == false) {

					presilhaOuCordao = "Não";

				} else {

					presilhaOuCordao = btgPresilhaOuCordao.getSelection()
							.getActionCommand();

				}

				if (chckbxTecnologiaDeAcesso.isSelected() == false) {

					padraoCodigoDeBarras = "Não";
					digitos = "Não";
					tipoDeTarja = "Não";
					tipoTecnologia = "Não";

				} else if (chckbxTecnologiaDeAcesso.isSelected() == true
						&& chckbxCodigoDeBarras.isSelected() == true) {

					tipoDeTarja = "Não";
					tipoTecnologia = "Não";

				} else if (chckbxTecnologiaDeAcesso.isSelected() == true
						&& chckbxTarjaMagnetica.isSelected() == true) {

					padraoCodigoDeBarras = "Não";
					digitos = "Não";
					tipoTecnologia = "Não";

				} else if (chckbxTecnologiaDeAcesso.isSelected() == true
						&& chckbxProximidade.isSelected() == true) {

					padraoCodigoDeBarras = "Não";
					digitos = "Não";
					tipoDeTarja = "Não";

				}

				if (cbProduto.getSelectedItem().equals("Produto")) {

					JOptionPane.showMessageDialog(null, "Selecione o Produto");

				} else if (cbTipoMaterial.getSelectedItem().equals(
						"Tipo do Produto")) {

					JOptionPane.showMessageDialog(null,
							"Selecione o Tipo do Produto");

				} else if (btgEspessura.isSelected(null) == true) {

					JOptionPane
							.showMessageDialog(null, "Selecione a Espessura");

				} else if (cbClasseDoProduto.getSelectedItem().equals(
						"Classe do Produto")) {

					JOptionPane.showMessageDialog(null,
							"Selecione a Classe do Produto");

				} else if (chckbxFurado.isSelected()
						&& btgPresilhaOuCordao.isSelected(null) == true) {

					JOptionPane.showMessageDialog(null,
							"Selecione se tem Presilha ou Cordão");

				} else if (cbnOrientacaoDoCracha.getSelectedItem().equals(
						"Orientação")) {

					JOptionPane.showMessageDialog(null,
							"Selecione a Orientação do Produto");

				} else if (cbnProtetor.getSelectedItem().equals("Protetor")) {

					JOptionPane.showMessageDialog(null,
							"Selecione se tem Protetor e de que Tipo");

				} else if (cbnProtetor.getSelectedItem().equals("Rígido")
						&& tfCorProtetorRigido.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite a cor do Protetor Rígido");

				} else if (chckbxTecnologiaDeAcesso.isSelected() == true
						&& chckbxCodigoDeBarras.isSelected() == false
						&& chckbxTarjaMagnetica.isSelected() == false
						&& chckbxProximidade.isSelected() == false) {

					JOptionPane.showMessageDialog(null,
							"Selecione a Tecnologia de Acesso");

				} else if (chckbxCodigoDeBarras.isSelected() == true
						&& cbPadraoCodigoDeBarras.getSelectedItem().equals(
								"Padrão do Código de Barras")) {

					JOptionPane.showMessageDialog(null,
							"Selecione o Padrão do Código de Barras");

				} else if (chckbxCodigoDeBarras.isSelected() == true
						&& cbDigitos.getSelectedItem().equals("Dígitos")) {

					JOptionPane.showMessageDialog(null,
							"Selecione o número de Dígitos");

				} else if (chckbxTarjaMagnetica.isSelected() == true
						&& cbTipoTarja.getSelectedItem()
								.equals("Tipo de Tarja")) {

					JOptionPane.showMessageDialog(null,
							"Selecione Tarja de Alta ou Baixar Coercitividade");

				} else if ((chckbxTarjaMagnetica.isSelected() == true
						&& chckbxTrilha1.isSelected() == false
						&& chckbxTrilha2.isSelected() == false && chckbxTrilha3
						.isSelected() == false)) {

					JOptionPane.showMessageDialog(null,
							"Selecione pelo menos uma Tarja");

				} else if (chckbxProximidade.isSelected() == true
						&& cbTipoTecnologia.getSelectedItem().equals(
								"Tipo Tecnologia")) {

					JOptionPane.showMessageDialog(null,
							"Selecione a Tecnologia do Cartão de Proximidade");

				} else if (btgFrenteFrenteVerso.isSelected(null) == true) {

					JOptionPane.showMessageDialog(null,
							"Selecione o Layout Frente ou Frente e Verso");

				} else if (btgFrenteFrenteVerso.getSelection()
						.getActionCommand().equals("Frente")
						&& tfLayoutFrente.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Selecione a imagem para a Frente do Layout");

				} else if ((btgFrenteFrenteVerso.getSelection()
						.getActionCommand().equals("Frente e Verso") && tfLayoutFrente
						.getText().equals(""))
						&& ((btgFrenteFrenteVerso.getSelection()
								.getActionCommand().equals("Frente e Verso") && tfLayoutVerso
								.getText().equals("")))) {

					JOptionPane
							.showMessageDialog(null,
									"Selecione a imagem para a Frente e para o Verso do Layout");

				} else if (btgFrenteFrenteVerso.getSelection()
						.getActionCommand().equals("Frente e Verso")
						&& tfLayoutFrente.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Selecione a imagem para a Frente do Layout");

				} else if (btgFrenteFrenteVerso.getSelection()
						.getActionCommand().equals("Frente e Verso")
						&& tfLayoutVerso.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Selecione a imagem para a Verso do Layout");

				} else {

					if (tfCorProtetorRigido.getText().equals("")) {

						tfCorProtetorRigido.setText("Não");

					}

					id_layout = new ControleMetodosLayout()
							.cadastrarLayout(new Layout(String
									.valueOf(cbProduto.getSelectedItem()),
									String.valueOf(cbTipoMaterial
											.getSelectedItem()), String
											.valueOf(btgEspessura
													.getSelection()
													.getActionCommand()),
									String.valueOf(cbClasseDoProduto
											.getSelectedItem()), chckbxFurado
											.isSelected(), presilhaOuCordao,
									String.valueOf(cbnOrientacaoDoCracha
											.getSelectedItem()), String
											.valueOf(cbnProtetor
													.getSelectedItem()),
									tfCorProtetorRigido.getText(),
									chckbxTecnologiaDeAcesso.isSelected(),
									btgFrenteFrenteVerso.getSelection()
											.getActionCommand(), tfLayoutFrente
											.getText().toUpperCase(),
									tfLayoutVerso.getText().toUpperCase(),
									id_cliente));

					new ControleMetodosTipoAcesso()
							.CadastrarTipoAcesso(new TipoAcesso(id_layout,
									id_cliente, chckbxCodigoDeBarras
											.isSelected(),
									padraoCodigoDeBarras, digitos,
									chckbxTarjaMagnetica.isSelected(),
									tipoDeTarja, chckbxTrilha1.isSelected(),
									chckbxTrilha2.isSelected(), chckbxTrilha3
											.isSelected(), chckbxProximidade
											.isSelected(), tipoTecnologia));

					JOptionPane.showMessageDialog(null,
							"Layout cadastrado com sucesso");

					cardlayout.show(JpanelSecundario, "frame01");

					btnConfirmarNovoLayout.setText("Novo Layout");

				}

			}
		});
		btnConfirmarLayout.setBounds(393, 438, 89, 23);
		card04.add(btnConfirmarLayout);

		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.setRequestFocusEnabled(false);
		btnVisualizar.setRolloverIcon(new ImageIcon(JfPrincipal.class
				.getResource("/images/cracha2.png")));
		btnVisualizar.setContentAreaFilled(false);
		btnVisualizar.setIcon(new ImageIcon(JfPrincipal.class
				.getResource("/images/cracha.png")));

		btnVisualizar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (cbnOrientacaoDoCracha.getSelectedItem()
						.equals("Horizontal")) {

					lb_FrenteCracha.setBounds(70, 88, 400, 250);
					lb_VersoCracha.setBounds(70, 88, 400, 250);

				} else if (cbnOrientacaoDoCracha.getSelectedItem().equals(
						"Vertical")) {

					lb_FrenteCracha.setBounds(136, 29, 250, 400);
					lb_VersoCracha.setBounds(136, 29, 250, 400);

				}

				if (cbnOrientacaoDoCracha.getSelectedItem()
						.equals("Orientação")) {

					JOptionPane.showMessageDialog(null,
							"Selecione a Orientação do Crachá");

				} else if (btgFrenteFrenteVerso.isSelected(null) == true) {

					JOptionPane.showMessageDialog(null,
							"Selecione o botão Frente ou Frente e Verso");

				} else if (btgFrenteFrenteVerso.getSelection()
						.getActionCommand().equals("Frente")
						&& tfLayoutFrente.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Selecione o endereço da Imagem frente");

				} else if (btgFrenteFrenteVerso.getSelection()
						.getActionCommand().equals("Frente e Verso")
						&& tfLayoutFrente.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Selecione o endereço da Imagem Frente");

				} else if (btgFrenteFrenteVerso.getSelection()
						.getActionCommand().equals("Frente e Verso")
						&& tfLayoutVerso.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Selecione o endereço da Imagem Verso");

				} else if (btgFrenteFrenteVerso.getSelection()
						.getActionCommand().equals("Frente")) {

					String frente1 = String.valueOf(tfLayoutFrente.getText());

					ImageIcon iconFrente = new ImageIcon(frente1);
					lb_FrenteCracha.setIcon(new ImageIcon(iconFrente.getImage()
							.getScaledInstance(lb_FrenteCracha.getWidth(),
									lb_FrenteCracha.getHeight(),
									Image.SCALE_DEFAULT)));

					tpLayout.setEnabledAt(0, true);

					cardlayout.show(JpanelSecundario, "frame05");

					JButton btnVoltar = new JButton("Voltar");
					btnVoltar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {

							cardlayout.show(JpanelSecundario, "frame04");

						}

					});

				} else {

					String frente2 = String.valueOf(tfLayoutFrente.getText());
					String verso2 = String.valueOf(tfLayoutVerso.getText());

					ImageIcon iconFrente = new ImageIcon(frente2);
					lb_FrenteCracha.setIcon(new ImageIcon(iconFrente.getImage()
							.getScaledInstance(lb_FrenteCracha.getWidth(),
									lb_FrenteCracha.getHeight(),
									Image.SCALE_DEFAULT)));

					ImageIcon iconVerso = new ImageIcon(verso2);
					lb_VersoCracha.setIcon(new ImageIcon(iconVerso.getImage()
							.getScaledInstance(lb_VersoCracha.getWidth(),
									lb_VersoCracha.getHeight(),
									Image.SCALE_DEFAULT)));

					tpLayout.setEnabledAt(0, true);
					tpLayout.setEnabledAt(1, true);

					cardlayout.show(JpanelSecundario, "frame05");

					JButton btnVoltar = new JButton("Voltar");
					btnVoltar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {

							cardlayout.show(JpanelSecundario, "frame04");

						}

					});

				}
			}
		});
		btnVisualizar.setBounds(28, 350, 141, 125);
		card04.add(btnVisualizar);

		cbClasseDoProduto = new JComboBox();
		cbClasseDoProduto.setModel(new DefaultComboBoxModel(new String[] {
				"Classe do Produto", "Funcion\u00E1rio", "Provis\u00F3rio",
				"Visitante", "Prestador de Servi\u00E7os", "Extra" }));
		cbClasseDoProduto.setBounds(199, 111, 132, 20);
		card04.add(cbClasseDoProduto);

		cbnProtetor = new JComboBox();
		cbnProtetor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cbnProtetor.getSelectedItem().equals("Rígido")) {

					lbCor.setVisible(true);
					tfCorProtetorRigido.setText("");
					tfCorProtetorRigido.setVisible(true);

				} else {

					lbCor.setVisible(false);
					tfCorProtetorRigido.setText("");
					tfCorProtetorRigido.setVisible(false);

				}

			}
		});
		cbnProtetor.setModel(new DefaultComboBoxModel(new String[] {
				"Protetor", "N\u00E3o", "R\u00EDgido", "Flex\u00EDvel" }));
		cbnProtetor.setBounds(199, 169, 132, 20);
		card04.add(cbnProtetor);

		cbnOrientacaoDoCracha = new JComboBox();
		cbnOrientacaoDoCracha.setModel(new DefaultComboBoxModel(new String[] {
				"Orienta\u00E7\u00E3o", "Horizontal", "Vertical" }));
		cbnOrientacaoDoCracha.setBounds(52, 169, 132, 20);
		card04.add(cbnOrientacaoDoCracha);

		rdbtnPresilha = new JRadioButton("Presilha");
		rdbtnPresilha.setVisible(false);
		btgPresilhaOuCordao.add(rdbtnPresilha);
		rdbtnPresilha.setActionCommand("Presilha");
		rdbtnPresilha.setBounds(148, 139, 73, 23);

		card04.add(rdbtnPresilha);

		rdbtnCordao = new JRadioButton("Cord\u00E3o");
		rdbtnCordao.setVisible(false);
		btgPresilhaOuCordao.add(rdbtnCordao);
		rdbtnCordao.setActionCommand("Cordão");
		rdbtnCordao.setBounds(230, 139, 83, 23);
		card04.add(rdbtnCordao);

		lbCor = new JLabel("Cor:");
		lbCor.setBounds(344, 175, 21, 14);
		lbCor.setVisible(false);
		card04.add(lbCor);

		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(52, 200, 430, 9);
		card04.add(separator_7);

		JLabel lblEndereoDoLayout = new JLabel("Visualizar Layout");
		lblEndereoDoLayout.setForeground(Color.BLACK);
		lblEndereoDoLayout.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEndereoDoLayout.setBounds(52, 333, 114, 14);
		card04.add(lblEndereoDoLayout);

		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(52, 325, 430, 9);
		card04.add(separator_8);

		chckbxTecnologiaDeAcesso = new JCheckBox("Tecnologia de Acesso");
		chckbxTecnologiaDeAcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (chckbxTecnologiaDeAcesso.isSelected() == true) {

					chckbxCodigoDeBarras.setVisible(true);
					chckbxTarjaMagnetica.setVisible(true);
					chckbxProximidade.setVisible(true);

				} else {

					chckbxCodigoDeBarras.setVisible(false);
					chckbxTarjaMagnetica.setVisible(false);
					chckbxProximidade.setVisible(false);

					cbPadraoCodigoDeBarras.setVisible(false);
					cbDigitos.setVisible(false);

					cbTipoTarja.setVisible(false);
					chckbxTrilha1.setVisible(false);
					chckbxTrilha2.setVisible(false);
					chckbxTrilha3.setVisible(false);

					cbTipoTecnologia.setVisible(false);

				}

			}
		});
		chckbxTecnologiaDeAcesso.setBounds(52, 210, 150, 23);
		card04.add(chckbxTecnologiaDeAcesso);

		rdbtnFrente = new JRadioButton("Frente");
		rdbtnFrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnFrente.isSelected() == true) {

					lblLayoutFrente.setVisible(true);
					tfLayoutFrente.setVisible(true);
					btnAbrirLayoutFrente.setVisible(true);

					lblLayoutVerso.setVisible(false);
					tfLayoutVerso.setVisible(false);
					btnAbrirLayoutVerso.setVisible(false);

				} else {

					lblLayoutFrente.setVisible(true);
					tfLayoutFrente.setVisible(true);
					btnAbrirLayoutFrente.setVisible(true);

					lblLayoutVerso.setVisible(true);
					tfLayoutVerso.setVisible(true);
					btnAbrirLayoutVerso.setVisible(true);

				}

			}

		});
		btgFrenteFrenteVerso.add(rdbtnFrente);
		rdbtnFrente.setActionCommand("Frente");
		rdbtnFrente.setBounds(230, 328, 73, 23);
		card04.add(rdbtnFrente);

		rdbtnFrenteEVerso = new JRadioButton("Frente e Verso");
		rdbtnFrenteEVerso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnFrenteEVerso.isSelected() == true) {

					lblLayoutFrente.setVisible(true);
					tfLayoutFrente.setVisible(true);
					btnAbrirLayoutFrente.setVisible(true);

					lblLayoutVerso.setVisible(true);
					tfLayoutVerso.setVisible(true);
					btnAbrirLayoutVerso.setVisible(true);

				}
			}
		});
		btgFrenteFrenteVerso.add(rdbtnFrenteEVerso);
		rdbtnFrenteEVerso.setActionCommand("Frente e Verso");
		rdbtnFrenteEVerso.setBounds(331, 329, 150, 23);
		card04.add(rdbtnFrenteEVerso);
		JpanelSecundario.add(card05, "frame05");

		card05.setLayout(null);

		tpLayout = new JTabbedPane(JTabbedPane.TOP);
		tpLayout.setBounds(0, 0, 548, 486);
		card05.add(tpLayout);

		pFrente = new JPanel();
		tpLayout.addTab("Frente", null, pFrente, null);
		tpLayout.setEnabledAt(0, false);

		pVerso = new JPanel();
		tpLayout.addTab("Verso", null, pVerso, null);
		tpLayout.setEnabledAt(1, false);

		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cardlayout.show(JpanelSecundario, "frame04");

			}
		});
		pFrente.setLayout(null);
		button.setMnemonic('S');
		button.setBounds(437, 424, 82, 23);
		pFrente.add(button);

		JButton button1 = new JButton("Voltar");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cardlayout.show(JpanelSecundario, "frame04");

			}
		});
		pVerso.setLayout(null);
		button1.setMnemonic('S');
		button1.setBounds(437, 424, 82, 23);
		pVerso.add(button1);

		lb_FrenteCracha = new JLabel("");
		lb_FrenteCracha.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
				null));
		lb_FrenteCracha.setBounds(136, 29, 250, 400);
		pFrente.add(lb_FrenteCracha);

		lb_VersoCracha = new JLabel("");
		lb_VersoCracha.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
				null));
		lb_VersoCracha.setBounds(136, 29, 250, 400);
		pVerso.add(lb_VersoCracha);

		JLabel jl1 = new JLabel("Card1");
		card01.setLayout(null);
		card0.setLayout(null);

		// Redimensiona a imagem do label

		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(53, 84, 415, 324);
		ImageIcon icon = new ImageIcon(
				JfPrincipal.class
						.getResource("/images/techvan_transparente.png"));
		lblLogo.setIcon(new ImageIcon(JfPrincipal.class
				.getResource("/images/techvan_transparente.png")));

		card0.add(lblLogo);

		JLabel lblNewLabel_1 = new JLabel("Desenvolvedor HenriqueLins");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(316, 440, 151, 14);
		card0.add(lblNewLabel_1);

		card01.add(jl1);

		JLabel lblNewLabel = new JLabel("* Raz\u00E3o Social");
		lblNewLabel.setBounds(52, 75, 97, 14);
		card01.add(lblNewLabel);

		tfRazaoSocial = new JTextField();
		tfRazaoSocial.setBounds(52, 93, 251, 20);
		card01.add(tfRazaoSocial);
		tfRazaoSocial.setColumns(10);

		JLabel lblRazoSocial = new JLabel("* Nome Fantasia");
		lblRazoSocial.setBounds(52, 117, 97, 14);
		card01.add(lblRazoSocial);

		tfNomeFantasia = new JTextField();
		tfNomeFantasia.setColumns(10);
		tfNomeFantasia.setBounds(52, 135, 251, 20);
		card01.add(tfNomeFantasia);

		JLabel lblCnpj = new JLabel("* CNPJ");
		lblCnpj.setBounds(313, 75, 97, 14);
		card01.add(lblCnpj);

		tfCnpj = new JFormattedTextField(controller.Cliente.CNPJ(""));
		tfCnpj.setColumns(10);
		tfCnpj.setBounds(313, 93, 169, 20);
		card01.add(tfCnpj);

		JLabel lblCadastroClientes = new JLabel("Cadastro Clientes");
		lblCadastroClientes.setForeground(Color.BLACK);
		lblCadastroClientes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCadastroClientes.setBounds(52, 35, 169, 14);
		card01.add(lblCadastroClientes);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(52, 60, 430, 9);
		card01.add(separator_3);

		JLabel lblContato = new JLabel("* Contato");
		lblContato.setBounds(51, 159, 97, 14);
		card01.add(lblContato);

		tfContato = new JTextField();
		tfContato.setColumns(10);
		tfContato.setBounds(51, 177, 252, 20);
		card01.add(tfContato);

		JLabel lblVendedor = new JLabel("* Vendedor");
		lblVendedor.setBounds(313, 117, 97, 14);
		card01.add(lblVendedor);

		tfVendedor = new JTextField();
		tfVendedor.setColumns(10);
		tfVendedor.setBounds(313, 135, 169, 20);
		card01.add(tfVendedor);

		JLabel lblEmail = new JLabel("* E-mail");
		lblEmail.setBounds(52, 199, 97, 14);
		card01.add(lblEmail);

		tfEmailCliente = new JTextField();
		tfEmailCliente.setColumns(10);
		tfEmailCliente.setBounds(52, 217, 251, 20);
		card01.add(tfEmailCliente);

		JLabel lblTelefoneCliente2 = new JLabel("* Telefone Celular");
		lblTelefoneCliente2.setBounds(313, 199, 97, 14);
		card01.add(lblTelefoneCliente2);

		tfTelefoneCliente2 = new JFormattedTextField(
				Cliente.TelefoneCelular(""));
		tfTelefoneCliente2.setColumns(10);
		tfTelefoneCliente2.setBounds(313, 217, 169, 20);
		card01.add(tfTelefoneCliente2);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setForeground(Color.BLACK);
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEndereo.setBounds(52, 242, 169, 14);
		card01.add(lblEndereo);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(52, 264, 430, 9);
		card01.add(separator_4);

		JLabel lblLogradouro = new JLabel("* Logradouro");
		lblLogradouro.setBounds(52, 275, 97, 14);
		card01.add(lblLogradouro);

		tfLogradouroCliente = new JTextField();
		tfLogradouroCliente.setColumns(10);
		tfLogradouroCliente.setBounds(52, 293, 310, 20);
		card01.add(tfLogradouroCliente);

		JLabel lblN = new JLabel("* N.\u00BA");
		lblN.setBounds(372, 275, 97, 14);
		card01.add(lblN);

		tfNumeroCliente = new JTextField();
		tfNumeroCliente.setColumns(10);
		tfNumeroCliente.setBounds(372, 293, 110, 20);
		card01.add(tfNumeroCliente);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(52, 324, 97, 14);
		card01.add(lblComplemento);

		tfComplementoCliente = new JTextField();
		tfComplementoCliente.setColumns(10);
		tfComplementoCliente.setBounds(52, 342, 210, 20);
		card01.add(tfComplementoCliente);

		JLabel lblBairro = new JLabel("* Bairro");
		lblBairro.setBounds(272, 324, 97, 14);
		card01.add(lblBairro);

		tfBairroCliente = new JTextField();
		tfBairroCliente.setColumns(10);
		tfBairroCliente.setBounds(272, 342, 210, 20);
		card01.add(tfBairroCliente);

		JLabel lblCidade = new JLabel("* Cidade");
		lblCidade.setBounds(52, 374, 97, 14);
		card01.add(lblCidade);

		tfCidadeCliente = new JTextField();
		tfCidadeCliente.setColumns(10);
		tfCidadeCliente.setBounds(52, 392, 228, 20);
		card01.add(tfCidadeCliente);

		JLabel lblCep = new JLabel("* CEP");
		lblCep.setBounds(339, 373, 97, 14);
		card01.add(lblCep);

		tfCepCliente = new JFormattedTextField(Cliente.CEP(""));
		tfCepCliente.setHorizontalAlignment(SwingConstants.LEFT);
		tfCepCliente.setColumns(10);
		tfCepCliente.setBounds(340, 392, 142, 20);
		card01.add(tfCepCliente);

		cbUfCliente = new JComboBox();
		cbUfCliente.setModel(new DefaultComboBoxModel(new String[] { "UF",
				"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
				"MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN",
				"RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cbUfCliente.setBounds(290, 392, 40, 20);
		card01.add(cbUfCliente);

		btnConfirmarNovoLayout = new JButton("Confirmar");
		btnConfirmarNovoLayout.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String emailValido1 = tfEmailCliente.getText().toLowerCase();

				if (btnConfirmarNovoLayout.getText().equals("Novo Layout")
						|| btnConfirmarNovoLayout.getText().equals(
								"Adicionar Layout")) {

					cbProduto.setSelectedIndex(0);
					cbTipoMaterial.setSelectedIndex(0);
					cbClasseDoProduto.setSelectedIndex(0);
					cbnOrientacaoDoCracha.setSelectedIndex(0);
					cbnProtetor.setSelectedIndex(0);
					cbPadraoCodigoDeBarras.setSelectedIndex(0);
					cbPadraoCodigoDeBarras.setVisible(false);
					cbTipoTarja.setSelectedIndex(0);
					cbTipoTarja.setVisible(false);
					cbTipoTecnologia.setSelectedIndex(0);
					cbTipoTecnologia.setVisible(false);
					cbDigitos.setSelectedIndex(0);
					cbDigitos.setVisible(false);
					btnAbrirLayoutVerso.setVisible(true);

					lbCor.setVisible(false);

					tfCorProtetorRigido.setText("");
					tfCorProtetorRigido.setVisible(false);

					tfLayoutFrente.setText("");
					tfLayoutVerso.setText("");
					tfLayoutVerso.setVisible(true);

					btgEspessura.clearSelection();

					chckbxFurado.setSelected(false);
					chckbxTecnologiaDeAcesso.setSelected(false);
					chckbxCodigoDeBarras.setSelected(false);
					chckbxCodigoDeBarras.setVisible(false);
					chckbxTarjaMagnetica.setSelected(false);
					chckbxTarjaMagnetica.setVisible(false);
					chckbxProximidade.setSelected(false);
					chckbxProximidade.setVisible(false);
					chckbxTrilha1.setSelected(false);
					chckbxTrilha1.setVisible(false);
					chckbxTrilha2.setSelected(false);
					chckbxTrilha2.setVisible(false);
					chckbxTrilha3.setSelected(false);
					chckbxTrilha3.setVisible(false);

					btgPresilhaOuCordao.clearSelection();
					rdbtnPresilha.setVisible(false);
					rdbtnCordao.setVisible(false);
					btgFrenteFrenteVerso.clearSelection();

					cardlayout.show(JpanelSecundario, "frame04");

				} else if (tfRazaoSocial.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite a Razão Social da Empresa");

					tfRazaoSocial.requestFocus();

				} else if (tfCnpj.getText().equals("  .   .   /    -  ")) {

					JOptionPane.showMessageDialog(null,
							"Digite o CNPJ da Empresa");

					tfCnpj.requestFocus();

				} else if (tfNomeFantasia.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite o Nome Fantasia da Empresa");

					tfNomeFantasia.requestFocus();

				} else if (tfVendedor.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite o nome do Vendedor");

					tfVendedor.requestFocus();

				} else if (tfContato.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite o nome do Contato da Empresa");

					tfContato.requestFocus();

				} else if (tfTelefoneCliente1.getText()
						.equals("(  )     -    ")) {

					JOptionPane.showMessageDialog(null,
							"Digite o Telefone Fixo da Empresa");

					tfTelefoneCliente1.requestFocus();

				} else if (tfEmailCliente.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite o E-mail da Empresa");

					tfEmailCliente.requestFocus();

				} else if (!Pattern
						.matches(
								"\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b",
								emailValido1)) {

					JOptionPane.showMessageDialog(null, "E-mail invalido");

					tfEmail.setText("");
					tfEmail.requestFocus();

				} else if (tfTelefoneCliente2.getText().equals(
						"(  )      -    ")) {

					JOptionPane.showMessageDialog(null,
							"Digite o Telefone Celular");

					tfTelefoneCliente2.requestFocus();

				} else if (tfLogradouroCliente.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite o Logradouro do Endereço da Empresa");

					tfLogradouroCliente.requestFocus();

				} else if (tfNumeroCliente.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite o Número do Endereço da Empresa");

					tfNumeroCliente.requestFocus();

				} else if (tfBairroCliente.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite o Bairro do Endereço da Empresa");

					tfBairroCliente.requestFocus();

				} else if (tfCidadeCliente.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite a Cidade do Endereço da Empesa");

					tfCidadeCliente.requestFocus();

				} else if (cbUfCliente.getSelectedItem().equals("UF")) {

					JOptionPane.showMessageDialog(null,
							"Selecione a Unidade Federal (Sigla Estadual)");

				} else if (tfCepCliente.getText().equals("     -   ")) {

					JOptionPane.showMessageDialog(null,
							"Digite o CEP do Endereço da Empresa");

					tfCepCliente.requestFocus();

				} else if (btnConfirmarNovoLayout.getText().equals("Salvar")) {
					
					//if (localizadoCliente.getNome().equals(tfFCNomeFantasia.getText()) || localizadoCliente.getRazaoSocial().equals(tfFCRazaoSocial.getText()) || localizadoCliente.getCnpj().equals(tfCnpj.getText()))
					
					

					boolean corretoCliente = new ControleMetodosCliente()
							.alterarDadosCliente(new Cliente(tfNomeFantasia
									.getText().toUpperCase(), tfCnpj.getText(),
									tfRazaoSocial.getText().toUpperCase(),
									tfVendedor.getText().toUpperCase(),
									localizadoCliente.getId_cliente()));

					boolean corretoContato = new ControleMetodosContato()
							.alterarContatoCliente(new Contato(
									localizadoContato.getId_cliente(),
									tfContato.getText().toUpperCase(),
									tfEmailCliente.getText().toLowerCase(),
									tfTelefoneCliente1.getText(),
									tfTelefoneCliente2.getText(),
									localizadoContato.getId_contato()));

					boolean corretoEndereco = new ControleMetodosEndereco().alterarEnderecoCliente(new Endereco(
							localizadoEndereco.getId_cliente(),
							tfLogradouroCliente.getText().toUpperCase(),
							tfComplementoCliente.getText().toUpperCase(),
							tfNumeroCliente.getText().toUpperCase(),
							tfBairroCliente.getText().toUpperCase(),
							tfCidadeCliente.getText().toUpperCase(), String
									.valueOf(cbUfCliente.getSelectedItem()),
							tfCepCliente.getText(), localizadoEndereco
									.getId_endereco()));

					if (corretoCliente == true && corretoContato == true
							&& corretoEndereco == true) {
						
					

						JOptionPane.showMessageDialog(null,
								"Cliente Alterado com com Sucesso");

						cardlayout.show(JpanelSecundario, "frame0");

						tfPesquisaCliente.setEnabled(true);
						tfPesquisaCliente.setEditable(true);
						btnPesquisaCliente.setEnabled(true);
						btnNovoCliente.setEnabled(true);
						btnNovoUsuario.setEnabled(true);
						btnAreaUsuario.setEnabled(true);

						tfPesquisaCliente.requestFocus();

						btnConfirmarNovoLayout.setText("Confirmar");

						txtAUCpesquisar.setText("");

						DefaultTableModel model = (DefaultTableModel) tbAUCpesquisar
								.getModel();

						model.setNumRows(0);

						btnExcluirAUCliente.setVisible(false);
						btnEditarAULayout.setVisible(false);
						btnEditarAUCliente.setVisible(false);
						lbACinfo.setVisible(false);

					} else {

						JOptionPane.showMessageDialog(null,
								"Não foi possível fazer Alterações");
					}

				} else {

					id_cliente = new ControleMetodosCliente()
							.cadastrarCliente(new Cliente(tfNomeFantasia
									.getText().toUpperCase(), tfCnpj.getText(),
									tfRazaoSocial.getText().toUpperCase(),
									tfVendedor.getText().toUpperCase()));

					new ControleMetodosContato()
							.cadastrarContatoCliente(new Contato(id_cliente,
									tfContato.getText().toUpperCase(),
									tfEmailCliente.getText().toLowerCase(),
									tfTelefoneCliente1.getText(),
									tfTelefoneCliente2.getText()));

					new ControleMetodosEndereco()
							.cadastrarEnderecoCliente(new Endereco(
									id_cliente,
									tfLogradouroCliente.getText().toUpperCase(),
									tfComplementoCliente.getText()
											.toUpperCase(), tfNumeroCliente
											.getText().toUpperCase(),
									tfBairroCliente.getText().toUpperCase(),
									tfCidadeCliente.getText().toUpperCase(),
									String.valueOf(cbUfCliente
											.getSelectedItem()), tfCepCliente
											.getText()));
											
									
					JOptionPane.showMessageDialog(null,
							"Cliente Cadastrado com Sucesso");

					cardlayout.show(JpanelSecundario, "frame04");

				}

			}
		});
		btnConfirmarNovoLayout.setBounds(362, 438, 120, 23);
		card01.add(btnConfirmarNovoLayout);

		btnSairCliente = new JButton("Sair");

		btnSairCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cardlayout.show(JpanelSecundario, "frame0");

				tfPesquisaCliente.setEnabled(true);
				tfPesquisaCliente.setEditable(true);
				btnPesquisaCliente.setEnabled(true);
				btnNovoCliente.setEnabled(true);
				btnNovoUsuario.setEnabled(true);
				btnAreaUsuario.setEnabled(true);

				tfPesquisaCliente.requestFocus();

				btnConfirmarNovoLayout.setText("Confirmar");

				txtAUCpesquisar.setText("");

				DefaultTableModel model = (DefaultTableModel) tbAUCpesquisar
						.getModel();

				model.setNumRows(0);

				btnExcluirAUCliente.setVisible(false);
				btnEditarAULayout.setVisible(false);
				btnEditarAUCliente.setVisible(false);
				lbACinfo.setVisible(false);

			}
		});
		btnSairCliente.setBounds(272, 438, 77, 23);
		card01.add(btnSairCliente);

		JLabel lbTelefoneCliente1 = new JLabel("* Telefone Fixo");
		lbTelefoneCliente1.setBounds(313, 159, 97, 14);
		card01.add(lbTelefoneCliente1);

		tfTelefoneCliente1 = new JFormattedTextField(Cliente.TelefoneFixo(""));
		tfTelefoneCliente1.setColumns(10);
		tfTelefoneCliente1.setBounds(313, 177, 169, 20);
		card01.add(tfTelefoneCliente1);

		JLabel label = new JLabel("* Campo Obrigat\u00F3rio.");
		label.setBounds(52, 442, 210, 14);
		card01.add(label);
		card02.setLayout(null);

		tfNomeCompleto = new JTextField();
		tfNomeCompleto.setColumns(10);
		tfNomeCompleto.setBounds(52, 93, 270, 20);
		card02.add(tfNomeCompleto);

		JLabel lblNomeCompleto = new JLabel("* Nome Completo");
		lblNomeCompleto.setBounds(52, 75, 97, 14);
		card02.add(lblNomeCompleto);

		JLabel lblCadastroUsurio = new JLabel("Cadastro Usu\u00E1rio");
		lblCadastroUsurio.setForeground(Color.BLACK);
		lblCadastroUsurio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCadastroUsurio.setBounds(52, 35, 169, 14);
		card02.add(lblCadastroUsurio);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(52, 60, 430, 9);
		card02.add(separator_1);

		JLabel lbnCpf = new JLabel("* CPF");
		lbnCpf.setBounds(332, 75, 97, 14);
		card02.add(lbnCpf);

		tfCpf = new JFormattedTextField(Cliente.CPF(""));
		tfCpf.setColumns(10);
		tfCpf.setBounds(332, 93, 150, 20);
		card02.add(tfCpf);

		JLabel lblLogin = new JLabel("* Login");
		lblLogin.setBounds(52, 124, 97, 14);
		card02.add(lblLogin);

		tfLogin = new JTextField();
		tfLogin.setColumns(10);
		tfLogin.setBounds(52, 142, 178, 20);
		card02.add(tfLogin);

		JLabel lblSenha = new JLabel("* Senha (6 d\u00EDgitos)");
		lblSenha.setBounds(240, 124, 116, 14);
		card02.add(lblSenha);

		tfSenha = new JPasswordField();
		tfSenha.setColumns(10);
		tfSenha.setBounds(240, 142, 116, 20);

		MaxLengthTextDocument maxLength = new MaxLengthTextDocument();
		maxLength.setMaxChars(7);
		tfSenha.setDocument(maxLength);

		card02.add(tfSenha);

		JLabel lblRepetirSenha = new JLabel("* Repetir Senha");
		lblRepetirSenha.setBounds(366, 124, 116, 14);
		card02.add(lblRepetirSenha);

		tfRepetirSenha = new JPasswordField();
		tfRepetirSenha.setColumns(10);
		tfRepetirSenha.setBounds(366, 142, 116, 20);
		card02.add(tfRepetirSenha);

		MaxLengthTextDocument maxLength2 = new MaxLengthTextDocument();
		maxLength2.setMaxChars(7);
		tfRepetirSenha.setDocument(maxLength2);

		tfRepetirSenha.setDocument(maxLength2);

		JLabel lblemail = new JLabel("* E-mail");
		lblemail.setBounds(52, 173, 97, 14);
		card02.add(lblemail);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(52, 191, 178, 20);
		card02.add(tfEmail);

		JLabel lblTelefone_1 = new JLabel("Telefone Fixo");
		lblTelefone_1.setBounds(240, 173, 88, 14);
		card02.add(lblTelefone_1);

		tfTelefone1 = new JFormattedTextField(Cliente.TelefoneFixo(""));
		tfTelefone1.setColumns(10);
		tfTelefone1.setBounds(240, 191, 116, 20);
		card02.add(tfTelefone1);

		JLabel lblTelefone_2 = new JLabel("* Telefone Celular");
		lblTelefone_2.setBounds(366, 173, 102, 14);
		card02.add(lblTelefone_2);

		tfTelefone2 = new JFormattedTextField(Cliente.TelefoneCelular(""));
		tfTelefone2.setColumns(10);
		tfTelefone2.setBounds(366, 191, 116, 20);
		card02.add(tfTelefone2);

		JLabel label_2 = new JLabel("Endere\u00E7o");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(52, 233, 169, 14);
		card02.add(label_2);

		JLabel lblLogradouro_1 = new JLabel("* Logradouro");
		lblLogradouro_1.setBounds(52, 275, 97, 14);
		card02.add(lblLogradouro_1);

		tfLogradouro = new JTextField();
		tfLogradouro.setColumns(10);
		tfLogradouro.setBounds(52, 293, 310, 20);
		card02.add(tfLogradouro);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(52, 258, 430, 9);
		card02.add(separator_5);

		JLabel lblN_1 = new JLabel("* N.\u00BA");
		lblN_1.setBounds(372, 275, 97, 14);
		card02.add(lblN_1);

		tfNumero = new JTextField();
		tfNumero.setColumns(10);
		tfNumero.setBounds(372, 293, 110, 20);
		card02.add(tfNumero);

		JLabel lblComplemento_1 = new JLabel("Complemento");
		lblComplemento_1.setBounds(52, 324, 97, 14);
		card02.add(lblComplemento_1);

		tfComplemento = new JTextField();
		tfComplemento.setColumns(10);
		tfComplemento.setBounds(52, 342, 210, 20);
		card02.add(tfComplemento);

		JLabel lblBairro_1 = new JLabel("* Bairro");
		lblBairro_1.setBounds(272, 324, 97, 14);
		card02.add(lblBairro_1);

		tfBairro = new JTextField();
		tfBairro.setColumns(10);
		tfBairro.setBounds(272, 342, 210, 20);
		card02.add(tfBairro);

		JLabel lblCidade_1 = new JLabel("* Cidade");
		lblCidade_1.setBounds(52, 374, 97, 14);
		card02.add(lblCidade_1);

		tfCidade = new JTextField();
		tfCidade.setColumns(10);
		tfCidade.setBounds(52, 392, 228, 20);
		card02.add(tfCidade);

		cbUf = new JComboBox();
		cbUf.setModel(new DefaultComboBoxModel(new String[] { "UF", "AC", "AL",
				"AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS",
				"MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO",
				"RR", "SC", "SP", "SE", "TO" }));
		cbUf.setBounds(290, 392, 40, 20);
		card02.add(cbUf);

		JLabel lblCep_1 = new JLabel("* CEP");
		lblCep_1.setBounds(339, 373, 97, 14);
		card02.add(lblCep_1);

		tfCep = new JFormattedTextField(Cliente.CEP(""));
		tfCep.setHorizontalAlignment(SwingConstants.LEFT);
		tfCep.setColumns(10);
		tfCep.setBounds(340, 392, 142, 20);
		card02.add(tfCep);

		card03.setLayout(null);

		JButton btConfirmar = new JButton("Confirmar");
		btConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String emailValido = tfEmail.getText().toLowerCase();

				boolean valido = controller.ValidarCpf.isCPF(Cliente
						.removerMascara(tfCpf.getText()));

				if (btgAdmOper.isSelected(null) == true) {

					JOptionPane.showMessageDialog(null,
							"Selecione o Tipo do Usuário");

				} else if (tfNomeCompleto.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite o Nome do Usuário");

					tfNomeCompleto.requestFocus();

				} else if (tfCpf.getText().equals("   .   .   -  ")) {

					JOptionPane.showMessageDialog(null,
							"Digite o CPF do Usuário");

					tfCpf.requestFocus();

				} else if (valido == false) {

					JOptionPane.showMessageDialog(null, "CPF inválido");

					tfCpf.setText("");
					tfCpf.requestFocus();

				} else if (tfLogin.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite o Login do Usuário");

					tfLogin.requestFocus();

				} else if (tfSenha.getPassword() == null) {

					JOptionPane.showMessageDialog(null,
							"Digite a Senha do Usuário");

					tfSenha.requestFocus();

				} else if (tfSenha.getPassword().length < 6) {

					JOptionPane.showMessageDialog(null,
							"Digite uma senha com 6 Dígitos");

					tfSenha.requestFocus();

				} else if (tfRepetirSenha.getPassword() == null) {

					JOptionPane.showMessageDialog(null,
							"Repita a Senha do Usuário");

					tfRepetirSenha.requestFocus();

				} else if (!String.valueOf(tfSenha.getPassword()).equals(
						String.valueOf(tfRepetirSenha.getPassword()))) {

					JOptionPane.showMessageDialog(null,
							"A senha e sua repetição não estão iguais");

					tfSenha.setText("");
					tfRepetirSenha.setText("");
					tfSenha.requestFocus();

				} else if (tfEmail.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite o E-mail do Usuário");

					tfEmail.requestFocus();

				} else if (!Pattern
						.matches(
								"\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b",
								emailValido)) {

					JOptionPane.showMessageDialog(null, "E-mail invalido");

					tfEmail.setText("");
					tfEmail.requestFocus();

				} else if (tfTelefone2.getText().equals("(  )      -    ")) {

					JOptionPane.showMessageDialog(null,
							"Digite o Telefone Celular  do Usuário");

					tfTelefone2.requestFocus();

				} else if (tfLogradouro.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite o Logradouro do Endereço do Usuário");

					tfLogradouro.requestFocus();

				} else if (tfNumero.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite o Número do Endereço do Usuário");

					tfNumero.requestFocus();

				} else if (tfBairro.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite o Bairro do Endereço do Usuário");

					tfBairro.requestFocus();

				} else if (tfCidade.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite a Cidade do Endereço do Usuário");

					tfCidade.requestFocus();

				} else if (cbUf.getSelectedItem().equals("UF")) {

					JOptionPane.showMessageDialog(null,
							"Selecione a Unidade Federal (Sigla Estadual)");

					cbUf.requestFocus();

				} else if (tfCep.getText().equals("     -   ")) {

					JOptionPane.showMessageDialog(null,
							"Digite o CEP do Endereço do Usuário");

				} else {

					int id_usuario = new ControleMetodosUsuario().cadastrarUsuario(new Usuario(
							tfNomeCompleto.getText().toUpperCase(), tfCpf
									.getText(),
							tfLogin.getText().toUpperCase(), tfSenha.getText(),
							btgAdmOper.getSelection().getActionCommand()));
					new ControleMetodosContato()
							.cadastrarContatoUsuario(new Contato(tfNomeCompleto
									.getText().toUpperCase(), tfEmail.getText()
									.toLowerCase(), tfTelefone1.getText(),
									tfTelefone2.getText(), id_usuario));
					new ControleMetodosEndereco()
							.cadastrarEnderecoUsuario(new Endereco(tfLogradouro
									.getText().toUpperCase(), tfComplemento
									.getText().toUpperCase(), tfNumero
									.getText(), tfBairro.getText()
									.toUpperCase(), tfCidade.getText()
									.toUpperCase(), String.valueOf(cbUf
									.getSelectedItem()), tfCep.getText(),
									id_usuario));

					btnNovoCliente.setEnabled(true);
					btnNovoUsuario.setEnabled(true);
					btnAreaUsuario.setEnabled(true);
					btnPesquisaCliente.setEnabled(true);
					tfPesquisaCliente.setEnabled(true);

					cardlayout.show(JpanelSecundario, "frame0");

				}

			}
		});
		btConfirmar.setBounds(393, 438, 89, 23);
		card02.add(btConfirmar);

		JButton btSairUsuario = new JButton("Sair");
		btSairUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnNovoCliente.setEnabled(true);
				btnNovoUsuario.setEnabled(true);
				btnAreaUsuario.setEnabled(true);
				btnPesquisaCliente.setEnabled(true);
				tfPesquisaCliente.setEnabled(true);

				tfPesquisaCliente.requestFocus();

				cardlayout.show(JpanelSecundario, "frame0");

			}
		});
		btSairUsuario.setBounds(290, 438, 89, 23);
		card02.add(btSairUsuario);

		JRadioButton rdbtnAdministrador = new JRadioButton("Administrador");
		btgAdmOper.add(rdbtnAdministrador);
		rdbtnAdministrador.setActionCommand("ADMINISTRADOR");
		rdbtnAdministrador.setBounds(227, 31, 109, 23);
		card02.add(rdbtnAdministrador);

		JRadioButton rdbtnOperador = new JRadioButton("Operador");
		rdbtnOperador.setActionCommand("OPERADOR");
		btgAdmOper.add(rdbtnOperador);
		rdbtnOperador.setBounds(373, 31, 109, 23);
		card02.add(rdbtnOperador);

		lbCampoObrigatorio = new JLabel("* Campo Obrigat\u00F3rio.");
		lbCampoObrigatorio.setBounds(52, 447, 210, 14);
		card02.add(lbCampoObrigatorio);

		JLabel lblreaDoUsurio = new JLabel("\u00C1rea do Usu\u00E1rio");
		lblreaDoUsurio.setForeground(Color.BLACK);
		lblreaDoUsurio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblreaDoUsurio.setBounds(52, 35, 169, 14);
		card03.add(lblreaDoUsurio);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(52, 60, 430, 9);
		card03.add(separator_6);

		tabbedPaneAreaUsuario = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneAreaUsuario.setBounds(52, 80, 430, 352);
		card03.add(tabbedPaneAreaUsuario);

		final JPanel panelClienteAreaUsuario = new JPanel();
		tabbedPaneAreaUsuario.addTab("Clientes", null, panelClienteAreaUsuario,
				null);
		panelClienteAreaUsuario.setLayout(null);

		final JComboBox cbAUCpesquisar = new JComboBox();
		cbAUCpesquisar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {

				txtAUCpesquisar.setText("");

				DefaultTableModel model = (DefaultTableModel) tbAUCpesquisar
						.getModel();

				model.setNumRows(0);

				btnEditarAUCliente.setVisible(false);
				btnEditarAULayout.setVisible(false);
				btnExcluirAUCliente.setVisible(false);
				lbACinfo.setVisible(false);

			}
		});
		cbAUCpesquisar.setModel(new DefaultComboBoxModel(new String[] {
				"Pesquisar pelo ...", "Nome Fantasia", "Raz\u00E3o Social",
				"CNPJ", "Vendedor" }));
		cbAUCpesquisar.setBounds(29, 28, 124, 20);
		panelClienteAreaUsuario.add(cbAUCpesquisar);

		txtAUCpesquisar = new JTextField();
		txtAUCpesquisar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				getRootPane().setDefaultButton(btnAUCpesquisarOK);

				txtAUCpesquisar.setText("");

				DefaultTableModel model = (DefaultTableModel) tbAUCpesquisar
						.getModel();

				model.setNumRows(0);

				btnEditarAUCliente.setVisible(false);
				btnEditarAULayout.setVisible(false);
				btnExcluirAUCliente.setVisible(false);
				lbACinfo.setVisible(false);

			}
		});

		txtAUCpesquisar.setBounds(163, 28, 177, 20);
		panelClienteAreaUsuario.add(txtAUCpesquisar);
		txtAUCpesquisar.setColumns(10);

		btnAUCpesquisarOK = new JButton("");
		btnAUCpesquisarOK.setFocusPainted(false);
		btnAUCpesquisarOK.setBorderPainted(false);
		btnAUCpesquisarOK.setContentAreaFilled(false);
		btnAUCpesquisarOK.setBorder(null);
		btnAUCpesquisarOK.setVerifyInputWhenFocusTarget(false);
		btnAUCpesquisarOK.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAUCpesquisarOK.setRolloverIcon(new ImageIcon(JfPrincipal.class
				.getResource("/images/lupa_pequena2.png")));
		btnAUCpesquisarOK.setIcon(new ImageIcon(JfPrincipal.class
				.getResource("/images/lupa_pequena1.png")));
		btnAUCpesquisarOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String campo = null;

				if (cbAUCpesquisar.getSelectedItem().equals("Nome Fantasia")) {

					campo = "nome_fantasia";

				} else if (cbAUCpesquisar.getSelectedItem().equals(
						"Razão Social")) {

					campo = "razao_social";

				} else if (cbAUCpesquisar.getSelectedItem().equals("CNPJ")) {

					campo = "cnpj";

				} else if (cbAUCpesquisar.getSelectedItem().equals("Vendedor")) {

					campo = "vendedor";

				}

				if (cbAUCpesquisar.getSelectedItem().equals(
						"Pesquisar pelo ...")) {

					JOptionPane.showMessageDialog(null,
							"Selecione o campo para pesquisa");

				} else if (txtAUCpesquisar.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Digite sua pesquisa");

				} else {

					listaCliente = ControleMetodosCliente
							.pesquisarClienteMultiplosCampos(campo,
									txtAUCpesquisar.getText().toUpperCase());

					if (listaCliente.isEmpty()) {

						JOptionPane.showMessageDialog(null,
								"Cliente não Localizado");

					} else {

						btnEditarAUCliente.setVisible(true);
						btnEditarAULayout.setVisible(true);
						btnExcluirAUCliente.setVisible(true);
						lbACinfo.setVisible(true);

						DefaultTableModel model = (DefaultTableModel) tbAUCpesquisar
								.getModel();

						model.setNumRows(0);

						for (Cliente c : listaCliente) {

							Object[] linha = { c.getRazaoSocial(), c.getNome(),
									c.getCnpj(), c.getVendedor() };

							model.addRow(linha);

						}

					}

				}

			}

		});
		btnAUCpesquisarOK.setBounds(345, 21, 43, 39);
		panelClienteAreaUsuario.add(btnAUCpesquisarOK);

		JScrollPane scrollPane_AUCliente = new JScrollPane();
		scrollPane_AUCliente.setBounds(29, 73, 359, 165);
		panelClienteAreaUsuario.add(scrollPane_AUCliente);

		tbAUCpesquisar = new JTable();
		tbAUCpesquisar.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbAUCpesquisar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tbAUCpesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				txtAUCpesquisar.setText("");

				int posicao = tbAUCpesquisar.getSelectedRow();

				String pesquisarNome = listaCliente.get(posicao).getNome();

				localizadoCliente = ControleMetodosCliente
						.pesquisarUnicoCliente(pesquisarNome.toUpperCase());

				localizadoContato = ControleMetodosContato
						.pesquisarContatoEndereco((localizadoCliente
								.getId_cliente()));

				localizadoEndereco = ControleMetodosEndereco
						.pesquisarEnderecoCliente(localizadoCliente
								.getId_cliente());

				localizadoLayout = ControleMetodosLayout
						.pesquisarLayout(localizadoCliente.getId_cliente());

				localizadoTipoAcesso = ControleMetodosTipoAcesso
						.pesquisarTipoAcesso(localizadoLayout.getId_layout());

			}
		});
		tbAUCpesquisar.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Raz\u00E3o Social", "Nome Fantasia", "CNPJ",
						"Vendedor" }) {
			boolean[] columnEditables = new boolean[] { false, false, false,
					false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbAUCpesquisar.getColumnModel().getColumn(0).setResizable(false);
		tbAUCpesquisar.getColumnModel().getColumn(0).setPreferredWidth(150);
		tbAUCpesquisar.getColumnModel().getColumn(0).setMinWidth(14);
		tbAUCpesquisar.getColumnModel().getColumn(1).setResizable(false);
		tbAUCpesquisar.getColumnModel().getColumn(1).setPreferredWidth(150);
		tbAUCpesquisar.getColumnModel().getColumn(2).setResizable(false);
		tbAUCpesquisar.getColumnModel().getColumn(2).setPreferredWidth(120);
		tbAUCpesquisar.getColumnModel().getColumn(3).setResizable(false);
		tbAUCpesquisar.getColumnModel().getColumn(3).setPreferredWidth(100);

		scrollPane_AUCliente.setViewportView(tbAUCpesquisar);

		btnExcluirAUCliente = new JButton("Excluir Cliente");
		btnExcluirAUCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tbAUCpesquisar.getSelectedRow() == -1) {

					JOptionPane.showMessageDialog(null, "Selecione o cliente");

				} else {

					boolean excluiuDados = ControleMetodosCliente
							.excluirDadosCliente(localizadoCliente
									.getId_cliente());

					boolean excluiuContato = ControleMetodosContato
							.excluirContatoCliente(localizadoContato
									.getId_contato());

					boolean excluiuEndereco = ControleMetodosEndereco
							.excluirEnderecoCliente(localizadoEndereco
									.getId_endereco());

					boolean excluiuLayout = ControleMetodosLayout
							.excluirLayoutCliente(localizadoLayout
									.getId_cliente());

					boolean excluiuTipoAcesso = ControleMetodosTipoAcesso
							.excluirTipoAcessoCliente(localizadoTipoAcesso
									.getId_cliente());
					
					
					if ((excluiuDados == true && excluiuContato == true
							&& excluiuEndereco == true && excluiuLayout == true && excluiuTipoAcesso == true)) {

						JOptionPane.showMessageDialog(null,
								"Cliente Deletado com Sucesso!");

						cardlayout.show(JpanelSecundario, "frame0");

						tfPesquisaCliente.setEnabled(true);
						tfPesquisaCliente.setEditable(true);
						btnPesquisaCliente.setEnabled(true);
						btnNovoCliente.setEnabled(true);
						btnNovoUsuario.setEnabled(true);
						btnAreaUsuario.setEnabled(true);

						tfPesquisaCliente.requestFocus();

						txtAUCpesquisar.setText("");

						DefaultTableModel model = (DefaultTableModel) tbAUCpesquisar
								.getModel();

						model.setNumRows(0);

						btnExcluirAUCliente.setVisible(false);
						btnEditarAULayout.setVisible(false);
						btnEditarAUCliente.setVisible(false);
						lbACinfo.setVisible(false);

					} else

						JOptionPane.showMessageDialog(null,
								"O Cliente não foi Deletado.");

				}
			}
		});
		btnExcluirAUCliente.setVisible(false);
		btnExcluirAUCliente.setBounds(289, 277, 109, 23);
		panelClienteAreaUsuario.add(btnExcluirAUCliente);

		btnEditarAUCliente = new JButton("Editar Cliente");
		btnEditarAUCliente.setVisible(false);
		btnEditarAUCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tbAUCpesquisar.getSelectedRow() == -1) {

					JOptionPane.showMessageDialog(null, "Selecione o cliente");

				} else {

					cardlayout.show(JpanelSecundario, "frame01");
					btnConfirmarNovoLayout.setText("Salvar");

					tfRazaoSocial.setText(localizadoCliente.getRazaoSocial());
					tfCnpj.setText(localizadoCliente.getCnpj());
					tfNomeFantasia.setText(localizadoCliente.getNome());
					tfVendedor.setText(localizadoCliente.getVendedor());

					tfContato.setText(localizadoContato.getNomeParaContato());
					tfTelefoneCliente1.setText(localizadoContato.getTelefone1());
					tfEmailCliente.setText(localizadoContato.getEmail());
					tfTelefoneCliente2.setText(localizadoContato.getTelefone2());

					tfLogradouroCliente.setText(localizadoEndereco
							.getLogradouro());
					tfNumeroCliente.setText(localizadoEndereco.getNumero());
					tfComplementoCliente.setText(localizadoEndereco
							.getComplemento());
					tfBairroCliente.setText(localizadoEndereco.getBairro());
					tfCidadeCliente.setText(localizadoEndereco.getCidade());
					cbUfCliente.setSelectedItem(localizadoEndereco.getUf());
					tfCepCliente.setText(localizadoEndereco.getCep());

				}

			}
		});
		btnEditarAUCliente.setBounds(30, 277, 109, 23);
		panelClienteAreaUsuario.add(btnEditarAUCliente);

		lbACinfo = new JLabel(
				"Selecione o cliente e escolha uma op\u00E7\u00E3o abaixo");
		lbACinfo.setHorizontalAlignment(SwingConstants.CENTER);
		lbACinfo.setHorizontalTextPosition(SwingConstants.CENTER);
		lbACinfo.setVisible(false);
		lbACinfo.setBounds(29, 249, 359, 14);
		panelClienteAreaUsuario.add(lbACinfo);

		btnEditarAULayout = new JButton("Editar Layout");
		btnEditarAULayout.setBounds(159, 277, 109, 23);
		btnEditarAULayout.setVisible(false);
		panelClienteAreaUsuario.add(btnEditarAULayout);

		JPanel panelUsuarioAreaUsuario = new JPanel();
		tabbedPaneAreaUsuario.addTab("Usu\u00E1rios", null,
				panelUsuarioAreaUsuario, null);
		panelUsuarioAreaUsuario.setLayout(null);

		cbAUUpesquisar = new JComboBox();
		cbAUUpesquisar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				txtAUUpesquisar.setText("");

				DefaultTableModel model = (DefaultTableModel) tbAUUsuario
						.getModel();

				model.setNumRows(0);

			}
		});
		cbAUUpesquisar.setModel(new DefaultComboBoxModel(new String[] {
				"Pesquisar pelo ...", "Nome", "CPF", "Login" }));
		cbAUUpesquisar.setBounds(30, 29, 124, 20);
		panelUsuarioAreaUsuario.add(cbAUUpesquisar);

		txtAUUpesquisar = new JTextField();
		txtAUUpesquisar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				getRootPane().setDefaultButton(btnAUUpesquisarOk);

				txtAUUpesquisar.setText("");

				DefaultTableModel model = (DefaultTableModel) tbAUUsuario
						.getModel();

				model.setNumRows(0);

			}
		});
		txtAUUpesquisar.setColumns(10);
		txtAUUpesquisar.setBounds(164, 29, 177, 20);
		panelUsuarioAreaUsuario.add(txtAUUpesquisar);

		btnAUUpesquisarOk = new JButton("");
		btnAUUpesquisarOk.setBorderPainted(false);
		btnAUUpesquisarOk.setContentAreaFilled(false);
		btnAUUpesquisarOk.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAUUpesquisarOk.setRolloverIcon(new ImageIcon(JfPrincipal.class
				.getResource("/images/lupa_pequena2.png")));
		btnAUUpesquisarOk.setIcon(new ImageIcon(JfPrincipal.class
				.getResource("/images/lupa_pequena1.png")));
		btnAUUpesquisarOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String campo = null;

				if (cbAUUpesquisar.getSelectedItem().equals("Nome")) {

					campo = "nome_usuario";

				} else if (cbAUUpesquisar.getSelectedItem().equals("CPF")) {

					campo = "cpf";

				} else if (cbAUUpesquisar.getSelectedItem().equals("Login")) {

					campo = "login";

				}

				if (cbAUUpesquisar.getSelectedItem().equals(
						"Pesquisar pelo ...")) {

					JOptionPane.showMessageDialog(null,
							"Selecione o campo para pesquisa");

				} else if (txtAUUpesquisar.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Digite sua pesquisa");

				} else {

					List<Usuario> listaUsuario = ControleMetodosUsuario
							.pesquisarUsuariosMultiplosCampos(campo,
									txtAUUpesquisar.getText().toUpperCase());

					if (listaUsuario.isEmpty()) {

						JOptionPane.showMessageDialog(null,
								"Usuário não Localizado");

					} else {

						DefaultTableModel model = (DefaultTableModel) tbAUUsuario
								.getModel();

						model.setNumRows(0);

						for (Usuario u : listaUsuario) {

							Object[] linha = { u.getNome() };

							model.addRow(linha);

						}

					}

				}

			}
		});
		btnAUUpesquisarOk.setBounds(346, 22, 43, 39);
		panelUsuarioAreaUsuario.add(btnAUUpesquisarOk);

		scrollPaneAUUsuario = new JScrollPane();
		scrollPaneAUUsuario.setBounds(30, 88, 269, 183);
		panelUsuarioAreaUsuario.add(scrollPaneAUUsuario);

		tbAUUsuario = new JTable();
		tbAUUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				txtAUUpesquisar.setText("");

			}
		});

		tbAUUsuario.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Usu\u00E1rio" }) {
			Class[] columnTypes = new Class[] { String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tbAUUsuario.getColumnModel().getColumn(0).setResizable(false);
		tbAUUsuario.getColumnModel().getColumn(0).setPreferredWidth(243);

		scrollPaneAUUsuario.setViewportView(tbAUUsuario);

		btnEditarAUUsuario = new JButton("Editar");
		btnEditarAUUsuario.setBounds(305, 214, 89, 23);
		panelUsuarioAreaUsuario.add(btnEditarAUUsuario);

		btnExluirAUUsuario = new JButton("Excluir");
		btnExluirAUUsuario.setBounds(305, 248, 89, 23);
		panelUsuarioAreaUsuario.add(btnExluirAUUsuario);

		JPanel Relatórios = new JPanel();
		tabbedPaneAreaUsuario.addTab("Configura\u00E7\u00E3o Banco", null,
				Relatórios, null);
		Relatórios.setLayout(null);

		tfConfHost = new JTextField();
		tfConfHost.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				getRootPane().setDefaultButton(btnConfConfirmar);

			}
		});
		tfConfHost.setText("localhost");
		tfConfHost.setBounds(25, 96, 200, 20);
		Relatórios.add(tfConfHost);
		tfConfHost.setColumns(10);

		JLabel lblConfUrl = new JLabel("Host");
		lblConfUrl.setBounds(25, 76, 46, 14);
		Relatórios.add(lblConfUrl);

		JLabel lblConfPorta = new JLabel("Porta");
		lblConfPorta.setBounds(246, 76, 46, 14);
		Relatórios.add(lblConfPorta);

		tfConfPorta = new JTextField();
		tfConfPorta.setText("5432");
		tfConfPorta.setColumns(10);
		tfConfPorta.setBounds(246, 96, 154, 20);
		Relatórios.add(tfConfPorta);

		JLabel lblConfLogin = new JLabel("Login");
		lblConfLogin.setBounds(25, 127, 46, 14);
		Relatórios.add(lblConfLogin);

		tfConfLogin = new JTextField();
		tfConfLogin.setText("postgres");
		tfConfLogin.setColumns(10);
		tfConfLogin.setBounds(25, 147, 200, 20);
		Relatórios.add(tfConfLogin);

		JLabel lblConfSenha_1 = new JLabel("Senha");
		lblConfSenha_1.setBounds(246, 127, 46, 14);
		Relatórios.add(lblConfSenha_1);

		btnConfConfirmar = new JButton("Confirmar");
		btnConfConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String senha = String.valueOf(pfConfSenha.getPassword());

				model.ConectarBanco.setHOST(tfConfHost.getText().toLowerCase());
				model.ConectarBanco.setPORTA(tfConfPorta.getText());
				model.ConectarBanco.setLOGIN(tfConfLogin.getText()
						.toLowerCase());
				model.ConectarBanco.setSENHA(senha);

				model.ConectarBanco.getConnectionTeste();

			}
		});
		btnConfConfirmar.setBounds(311, 248, 89, 23);
		Relatórios.add(btnConfConfirmar);

		pfConfSenha = new JPasswordField();
		pfConfSenha.setText("1006");
		pfConfSenha.setBounds(246, 147, 154, 20);
		Relatórios.add(pfConfSenha);

		tabbedPaneAreaUsuario.setEnabledAt(0, true);
		tabbedPaneAreaUsuario.setEnabledAt(1, true);

		JButton btnSairAreaUsuario = new JButton("Sair");
		btnSairAreaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cardlayout.show(JpanelSecundario, "frame0");

				tfPesquisaCliente.setEnabled(true);
				tfPesquisaCliente.setEditable(true);
				btnPesquisaCliente.setEnabled(true);
				btnNovoCliente.setEnabled(true);
				btnNovoUsuario.setEnabled(true);
				btnAreaUsuario.setEnabled(true);

				tfPesquisaCliente.requestFocus();

				txtAUCpesquisar.setText("");

				DefaultTableModel model = (DefaultTableModel) tbAUCpesquisar
						.getModel();

				model.setNumRows(0);

				lbACinfo.setVisible(false);
				btnEditarAULayout.setVisible(false);

			}
		});
		btnSairAreaUsuario.setBounds(393, 437, 89, 23);
		card03.add(btnSairAreaUsuario);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 497, 774, 11);
		contentPane.add(separator_2);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.setMnemonic('f');
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		btnFechar.setBounds(685, 507, 89, 23);
		contentPane.add(btnFechar);

		JButton btnLogoff = new JButton("Logoff");
		btnLogoff.setMnemonic('L');
		btnLogoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					dispose();

					logado.setNome("");
					logado.setLogin("");
					logado.setSenha("");
					logado.setCpf("");
					logado.setTipo("");

					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					JfLogin frame = new JfLogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);

				} catch (Exception e1) {

					e1.printStackTrace();

				}

			}
		});
		btnLogoff.setBounds(586, 507, 89, 23);
		contentPane.add(btnLogoff);

		JpanelCliente = new JPanel();
		JpanelCliente.setVisible(false);
		JpanelCliente.setBounds(0, 0, 794, 486);
		contentPane.add(JpanelCliente);

		cardlayout2 = new CardLayout();

		cardCliente = new JPanel();
		cardCracha = new JPanel();

		JpanelCliente.setLayout(cardlayout2);

		JpanelCliente.add(cardCliente, "frameCliente");
		cardCliente.setLayout(null);

		tfFCNomeFantasia = new JTextField();
		tfFCNomeFantasia.setBounds(28, 65, 216, 20);
		tfFCNomeFantasia.setBackground(Color.WHITE);
		tfFCNomeFantasia.setEditable(false);
		tfFCNomeFantasia.setText("");
		tfFCNomeFantasia.setColumns(10);
		cardCliente.add(tfFCNomeFantasia);

		tfFCRazaoSocial = new JTextField();
		tfFCRazaoSocial.setBounds(254, 65, 214, 20);
		tfFCRazaoSocial.setBackground(Color.WHITE);
		tfFCRazaoSocial.setEditable(false);
		tfFCRazaoSocial.setText("");
		tfFCRazaoSocial.setColumns(10);
		cardCliente.add(tfFCRazaoSocial);

		tfFCCnpj = new JTextField();
		tfFCCnpj.setBounds(478, 65, 142, 20);
		tfFCCnpj.setBackground(Color.WHITE);
		tfFCCnpj.setEditable(false);
		tfFCCnpj.setText("");
		tfFCCnpj.setColumns(10);
		cardCliente.add(tfFCCnpj);

		tfFCVendedor = new JTextField();
		tfFCVendedor.setBounds(630, 65, 142, 20);
		tfFCVendedor.setBackground(Color.WHITE);
		tfFCVendedor.setEditable(false);
		tfFCVendedor.setText("");
		tfFCVendedor.setColumns(10);
		cardCliente.add(tfFCVendedor);

		JLabel lblNomeFantasia = new JLabel("Nome Fantasia");
		lblNomeFantasia.setBounds(28, 42, 100, 20);
		cardCliente.add(lblNomeFantasia);

		JLabel lblRazoSocial_1 = new JLabel("Raz\u00E3o Social");
		lblRazoSocial_1.setBounds(254, 42, 100, 20);
		cardCliente.add(lblRazoSocial_1);

		JLabel lblCnpj_1 = new JLabel("CNPJ");
		lblCnpj_1.setBounds(478, 42, 100, 20);
		cardCliente.add(lblCnpj_1);

		JLabel lbFCVendedor = new JLabel("Vendedor");
		lbFCVendedor.setBounds(630, 42, 100, 20);
		cardCliente.add(lbFCVendedor);

		JLabel lbFCContato = new JLabel("Contato");
		lbFCContato.setBounds(28, 88, 100, 20);
		cardCliente.add(lbFCContato);

		tfFCContato = new JTextField();
		tfFCContato.setBounds(28, 109, 216, 20);
		tfFCContato.setBackground(Color.WHITE);
		tfFCContato.setEditable(false);
		tfFCContato.setText("");
		tfFCContato.setColumns(10);
		cardCliente.add(tfFCContato);

		JLabel lblEmail_1 = new JLabel("E-mail");
		lblEmail_1.setBounds(254, 88, 100, 20);
		cardCliente.add(lblEmail_1);

		tfFCEmail = new JTextField();
		tfFCEmail.setBounds(254, 109, 216, 20);
		tfFCEmail.setBackground(Color.WHITE);
		tfFCEmail.setEditable(false);
		tfFCEmail.setText("");
		tfFCEmail.setColumns(10);
		cardCliente.add(tfFCEmail);

		JLabel lbFCTelefone1 = new JLabel("Telefone Fixo");
		lbFCTelefone1.setBounds(478, 88, 100, 20);
		cardCliente.add(lbFCTelefone1);

		tfFCTelefone1 = new JTextField();
		tfFCTelefone1.setBounds(478, 109, 142, 20);
		tfFCTelefone1.setBackground(Color.WHITE);
		tfFCTelefone1.setEditable(false);
		tfFCTelefone1.setText("");
		tfFCTelefone1.setColumns(10);
		cardCliente.add(tfFCTelefone1);

		JLabel lbFCTelefone2 = new JLabel("Telefone Celular");
		lbFCTelefone2.setBounds(630, 88, 100, 20);
		cardCliente.add(lbFCTelefone2);

		tfFCTelefone2 = new JTextField();
		tfFCTelefone2.setBounds(630, 109, 142, 20);
		tfFCTelefone2.setBackground(Color.WHITE);
		tfFCTelefone2.setEditable(false);
		tfFCTelefone2.setText("");
		tfFCTelefone2.setColumns(10);
		cardCliente.add(tfFCTelefone2);

		JLabel lbFCLogradouro = new JLabel("Logradouro");
		lbFCLogradouro.setBounds(28, 133, 100, 20);
		cardCliente.add(lbFCLogradouro);

		tfFCLogradouro = new JTextField();
		tfFCLogradouro.setBounds(28, 154, 288, 20);
		tfFCLogradouro.setBackground(Color.WHITE);
		tfFCLogradouro.setEditable(false);
		tfFCLogradouro.setText("");
		tfFCLogradouro.setColumns(10);
		cardCliente.add(tfFCLogradouro);

		JLabel lbFCComplemento = new JLabel("Complemento");
		lbFCComplemento.setBounds(327, 133, 100, 20);
		cardCliente.add(lbFCComplemento);

		tfFCComplemento = new JTextField();
		tfFCComplemento.setBounds(326, 154, 142, 20);
		tfFCComplemento.setBackground(Color.WHITE);
		tfFCComplemento.setEditable(false);
		tfFCComplemento.setText("");
		tfFCComplemento.setColumns(10);
		cardCliente.add(tfFCComplemento);

		JLabel lbFCNumero = new JLabel("N.\u00BA");
		lbFCNumero.setBounds(478, 133, 73, 20);
		cardCliente.add(lbFCNumero);

		JLabel lbFCBairro = new JLabel("Bairro");
		lbFCBairro.setBounds(561, 133, 100, 20);
		cardCliente.add(lbFCBairro);

		tfFCNumero = new JTextField();
		tfFCNumero.setBounds(478, 154, 73, 20);
		tfFCNumero.setBackground(Color.WHITE);
		tfFCNumero.setEditable(false);
		tfFCNumero.setText("");
		tfFCNumero.setColumns(10);
		cardCliente.add(tfFCNumero);

		tfFCBairro = new JTextField();
		tfFCBairro.setBounds(561, 154, 211, 20);
		tfFCBairro.setBackground(Color.WHITE);
		tfFCBairro.setEditable(false);
		tfFCBairro.setText("");
		tfFCBairro.setColumns(10);
		cardCliente.add(tfFCBairro);

		JLabel lbFCCidade = new JLabel("Cidade");
		lbFCCidade.setBounds(28, 181, 100, 20);
		cardCliente.add(lbFCCidade);

		tfFCCidade = new JTextField();
		tfFCCidade.setBounds(28, 199, 238, 20);
		tfFCCidade.setBackground(Color.WHITE);
		tfFCCidade.setEditable(false);
		tfFCCidade.setText("");
		tfFCCidade.setColumns(10);
		cardCliente.add(tfFCCidade);

		JLabel lbFCCep = new JLabel("CEP");
		lbFCCep.setBounds(328, 181, 100, 20);
		cardCliente.add(lbFCCep);

		tfFCCep = new JTextField();
		tfFCCep.setBounds(327, 199, 142, 20);
		tfFCCep.setBackground(Color.WHITE);
		tfFCCep.setEditable(false);
		tfFCCep.setText("");
		tfFCCep.setColumns(10);
		cardCliente.add(tfFCCep);

		lbFCLocalFrente = new JLabel("");
		lbFCLocalFrente.setBounds(230, 270, 238, 160);
		lbFCLocalFrente.setBorder(new EtchedBorder(EtchedBorder.RAISED, null,
				null));
		lbFCLocalFrente.setIcon(new ImageIcon(icon2.getImage()
				.getScaledInstance(lbFCLocalFrente.getWidth(),
						lbFCLocalFrente.getHeight(), Image.SCALE_DEFAULT)));

		lbFCLocalFrente.setEnabled(true);
		lbFCLocalFrente.setVisible(false);

		cardCliente.add(lbFCLocalFrente);

		lbFCLocalVerso = new JLabel("");
		lbFCLocalVerso.setBounds(478, 270, 238, 160);
		lbFCLocalVerso.setBorder(new EtchedBorder(EtchedBorder.RAISED, null,
				null));

		lbFCLocalVerso.setIcon(new ImageIcon(icon2.getImage()
				.getScaledInstance(lbFCLocalVerso.getWidth(),
						lbFCLocalVerso.getHeight(), Image.SCALE_DEFAULT)));

		lbFCLocalVerso.setEnabled(true);
		lbFCLocalVerso.setVisible(false);

		cardCliente.add(lbFCLocalVerso);

		lbFCLocalFrente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (layCorreto.getOrientacao().equals("Horizontal")) {

					lbFCrachaFrente.setBounds(46, 88, 400, 250);
					lbFCrachaVerso.setBounds(46, 88, 400, 250);

				} else if (layCorreto.getOrientacao().equals("Vertical")) {

					lbFCrachaFrente.setBounds(136, 15, 250, 400);
					lbFCrachaVerso.setBounds(136, 15, 250, 400);

				}

				tipoAcesso = ControleMetodosTipoAcesso
						.pesquisarTipoAcesso(layCorreto.getId_layout());

				tfFCrachaProduto.setText(layCorreto.getProduto());
				tfFCrachaTipoDoProduto.setText(layCorreto.getTipoProduto());
				tfFCrachaEspessura.setText(layCorreto.getEspessura());
				tfFCrachaClasseDoProduto.setText(layCorreto.getClasseProduto());
				tfFCrachaPresilhaCordao.setText(layCorreto
						.getPresilhaOuCordao());
				tfFCrachaOrientacao.setText(layCorreto.getOrientacao());
				tfFCrachaProtetor.setText(layCorreto.getProtetor());
				tfFCrachaProtetorCor.setText(layCorreto.getCor());
				tfFCrachaImpressaoFace.setText(layCorreto.getImpressao());
				tfFCrachaFurado.setText(ControleMetodosLayout.simNao(layCorreto
						.isFurado()));
				tfFCrachaTecnologiaAcesso.setText(ControleMetodosLayout
						.simNao(layCorreto.isAcesso()));

				tfFCrachaCodigoDeBarras.setText(ControleMetodosLayout
						.simNao(tipoAcesso.isCodigoDeBarras()));
				tfFCrachaTipoCodBarras.setText(tipoAcesso
						.getPadraoCodigoDeBarras());
				tfFCrachaNumeroDeDigitos.setText(tipoAcesso.getDigitos());
				tfFCrachaTarjaMagnetica.setText(ControleMetodosLayout
						.simNao(tipoAcesso.isTarjaMagnetica()));
				tfFCrachaTipoTarjaMagnetica.setText(tipoAcesso.getTipoTarja());
				tfFCrachaTarja01.setText(ControleMetodosLayout
						.simNao(tipoAcesso.isTarja1()));
				tfFCrachaTarja02.setText(ControleMetodosLayout
						.simNao(tipoAcesso.isTarja2()));
				tfFCrachaTarja03.setText(ControleMetodosLayout
						.simNao(tipoAcesso.isTarja3()));
				tfFCrachaProximidade.setText(ControleMetodosLayout
						.simNao(tipoAcesso.isProximidade()));
				tfFCrachaTipoProximidade.setText(tipoAcesso
						.getTipoCartaoProximidade());

				String frente = layCorreto.getLocalFrente();
				String verso = layCorreto.getLocalVerso();

				ImageIcon iconFrente = new ImageIcon(frente);

				lbFCrachaFrente.setIcon(new ImageIcon(iconFrente.getImage()
						.getScaledInstance(lbFCrachaFrente.getWidth(),
								lbFCrachaFrente.getHeight(),
								Image.SCALE_DEFAULT)));

				ImageIcon iconVerso = new ImageIcon(verso);

				lbFCrachaVerso.setIcon(new ImageIcon(
						iconVerso.getImage()
								.getScaledInstance(lbFCrachaVerso.getWidth(),
										lbFCrachaVerso.getHeight(),
										Image.SCALE_DEFAULT)));

				tabbedPaneFrenteVerso.setSelectedComponent(pFCrachaFrente);

				cardlayout2.show(JpanelCliente, "frameCracha");

			}
		});

		lbFCLocalVerso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (layCorreto.getOrientacao().equals("Horizontal")) {

					lbFCrachaFrente.setBounds(46, 88, 400, 250);
					lbFCrachaVerso.setBounds(46, 88, 400, 250);

				} else if (layCorreto.getOrientacao().equals("Vertical")) {

					lbFCrachaFrente.setBounds(136, 15, 250, 400);
					lbFCrachaVerso.setBounds(136, 15, 250, 400);

				}

				tipoAcesso = ControleMetodosTipoAcesso
						.pesquisarTipoAcesso(layCorreto.getId_layout());

				tfFCrachaProduto.setText(layCorreto.getProduto());
				tfFCrachaTipoDoProduto.setText(layCorreto.getTipoProduto());
				tfFCrachaEspessura.setText(layCorreto.getEspessura());
				tfFCrachaClasseDoProduto.setText(layCorreto.getClasseProduto());
				tfFCrachaPresilhaCordao.setText(layCorreto
						.getPresilhaOuCordao());
				tfFCrachaOrientacao.setText(layCorreto.getOrientacao());
				tfFCrachaProtetor.setText(layCorreto.getProtetor());
				tfFCrachaProtetorCor.setText(layCorreto.getCor());
				tfFCrachaImpressaoFace.setText(layCorreto.getImpressao());
				tfFCrachaFurado.setText(ControleMetodosLayout.simNao(layCorreto
						.isFurado()));
				tfFCrachaTecnologiaAcesso.setText(ControleMetodosLayout
						.simNao(layCorreto.isAcesso()));

				tfFCrachaCodigoDeBarras.setText(ControleMetodosLayout
						.simNao(tipoAcesso.isCodigoDeBarras()));
				tfFCrachaTipoCodBarras.setText(tipoAcesso
						.getPadraoCodigoDeBarras());
				tfFCrachaNumeroDeDigitos.setText(tipoAcesso.getDigitos());
				tfFCrachaTarjaMagnetica.setText(ControleMetodosLayout
						.simNao(tipoAcesso.isTarjaMagnetica()));
				tfFCrachaTipoTarjaMagnetica.setText(tipoAcesso.getTipoTarja());
				tfFCrachaTarja01.setText(ControleMetodosLayout
						.simNao(tipoAcesso.isTarja1()));
				tfFCrachaTarja02.setText(ControleMetodosLayout
						.simNao(tipoAcesso.isTarja2()));
				tfFCrachaTarja03.setText(ControleMetodosLayout
						.simNao(tipoAcesso.isTarja3()));
				tfFCrachaProximidade.setText(ControleMetodosLayout
						.simNao(tipoAcesso.isProximidade()));
				tfFCrachaTipoProximidade.setText(tipoAcesso
						.getTipoCartaoProximidade());

				String frente = layCorreto.getLocalFrente();
				String verso = layCorreto.getLocalVerso();

				ImageIcon iconFrente = new ImageIcon(frente);

				lbFCrachaFrente.setIcon(new ImageIcon(iconFrente.getImage()
						.getScaledInstance(lbFCrachaFrente.getWidth(),
								lbFCrachaFrente.getHeight(),
								Image.SCALE_DEFAULT)));

				ImageIcon iconVerso = new ImageIcon(verso);

				lbFCrachaVerso.setIcon(new ImageIcon(
						iconVerso.getImage()
								.getScaledInstance(lbFCrachaVerso.getWidth(),
										lbFCrachaVerso.getHeight(),
										Image.SCALE_DEFAULT)));

				tabbedPaneFrenteVerso.setSelectedComponent(pFCrachaVerso);

				cardlayout2.show(JpanelCliente, "frameCracha");

			}
		});

		JLabel lbFCUf = new JLabel("UF");
		lbFCUf.setBounds(277, 181, 39, 20);
		cardCliente.add(lbFCUf);

		tfFCUf = new JTextField();
		tfFCUf.setBounds(276, 199, 40, 20);
		tfFCUf.setBackground(Color.WHITE);
		tfFCUf.setText("");
		tfFCUf.setEditable(false);
		tfFCUf.setColumns(10);
		cardCliente.add(tfFCUf);

		btnSairCardCliente = new JButton("Sair");
		btnSairCardCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				listaLayout.clear();

				JpanelPrincipal.setVisible(true);
				JpanelSecundario.setVisible(true);
				JpanelCliente.setVisible(false);
				cardlayout.show(JpanelSecundario, "frame0");

				tfPesquisaCliente.setText("");
				spnListaClientes.setVisible(false);

				lbFCLocalFrente.setVisible(false);
				lbFCLocalVerso.setVisible(false);

				lbLayoutFrente.setVisible(false);
				lbLayoutVerso.setVisible(false);

				tfPesquisaCliente.requestFocus();

				DefaultTableModel model = (DefaultTableModel) tbLayout
						.getModel();

				model.setNumRows(0);

			}

		});
		btnSairCardCliente.setBounds(683, 463, 89, 23);
		cardCliente.add(btnSairCardCliente);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 270, 182, 160);
		cardCliente.add(scrollPane);

		tbLayout = new JTable();
		tbLayout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int id_layout = listaLayout.get(tbLayout.getSelectedRow())
						.getId_layout();

				layCorreto = ControleMetodosLayout
						.pesquisarLayoutCorreto(id_layout);

				String frente = layCorreto.getLocalFrente();
				String verso = layCorreto.getLocalVerso();

				if (layCorreto.getOrientacao().equals("Horizontal")) {

					lbFCLocalFrente.setBounds(230, 270, 238, 150);
					lbFCLocalVerso.setBounds(478, 270, 238, 150);

				} else if (layCorreto.getOrientacao().equals("Vertical")) {

					lbFCLocalFrente.setBounds(267, 245, 150, 238);
					lbFCLocalVerso.setBounds(513, 245, 150, 238);

				}

				if (frente.equals("") == true && verso.equals("") == true) {

					lbFCLocalFrente.setVisible(false);
					lbFCLocalVerso.setVisible(false);

				} else if (frente.equals("") == false
						&& verso.equals("") == false) {

					lbFCLocalFrente.setVisible(true);
					lbFCLocalVerso.setVisible(true);

					lbLayoutFrente.setVisible(true);
					lbLayoutVerso.setVisible(true);

					tabbedPaneFrenteVerso.setEnabledAt(0, true);
					tabbedPaneFrenteVerso.setEnabledAt(1, true);

				} else if (frente.equals("") == false
						&& verso.equals("") == true) {

					lbFCLocalFrente.setVisible(true);
					lbFCLocalVerso.setVisible(false);

					lbLayoutFrente.setVisible(true);
					lbLayoutVerso.setVisible(false);

					tabbedPaneFrenteVerso.setEnabledAt(0, true);
					tabbedPaneFrenteVerso.setEnabledAt(1, false);

				} else if (frente.equals("") == true
						&& verso.equals("") == false) {

					lbFCLocalFrente.setVisible(false);
					lbFCLocalVerso.setVisible(true);

					lbLayoutFrente.setVisible(false);
					lbLayoutVerso.setVisible(true);

					tabbedPaneFrenteVerso.setEnabledAt(0, false);
					tabbedPaneFrenteVerso.setEnabledAt(1, true);

				}

				ImageIcon iconFrente = new ImageIcon(frente);

				lbFCLocalFrente.setIcon(new ImageIcon(iconFrente.getImage()
						.getScaledInstance(lbFCLocalFrente.getWidth(),
								lbFCLocalFrente.getHeight(),
								Image.SCALE_DEFAULT)));

				ImageIcon iconVerso = new ImageIcon(verso);

				lbFCLocalVerso.setIcon(new ImageIcon(
						iconVerso.getImage()
								.getScaledInstance(lbFCLocalVerso.getWidth(),
										lbFCLocalVerso.getHeight(),
										Image.SCALE_DEFAULT)));

			}
		});
		tbLayout.setModel(new DefaultTableModel(
				new Object[][] { { null, null }, }, new String[] { "Número",
						"Layout" }) {
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbLayout.getColumnModel().getColumn(1).setPreferredWidth(118);
		scrollPane.setViewportView(tbLayout);

		lbLayoutFrente = new JLabel("Frente");
		lbLayoutFrente.setVisible(false);
		lbLayoutFrente.setBounds(231, 248, 100, 20);
		cardCliente.add(lbLayoutFrente);

		lbLayoutVerso = new JLabel("Verso");
		lbLayoutVerso.setVisible(false);
		lbLayoutVerso.setBounds(478, 248, 100, 20);
		cardCliente.add(lbLayoutVerso);

		JpanelCliente.add(cardCracha, "frameCracha");
		cardCracha.setLayout(null);

		tabbedPaneFrenteVerso = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneFrenteVerso.setBounds(285, 0, 499, 486);
		cardCracha.add(tabbedPaneFrenteVerso);

		pFCrachaFrente = new JPanel();
		tabbedPaneFrenteVerso.addTab("Frente", null, pFCrachaFrente, null);
		pFCrachaFrente.setLayout(null);

		JButton btnCrachaVoltar2 = new JButton("Voltar");
		btnCrachaVoltar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				cardlayout2.show(JpanelCliente, "frameCliente");

			}
		});
		btnCrachaVoltar2.setBounds(400, 407, 89, 23);
		pFCrachaFrente.add(btnCrachaVoltar2);

		lbFCrachaFrente = new JLabel("");
		lbFCrachaFrente.setBorder(new EtchedBorder(EtchedBorder.RAISED, null,
				null));
		lbFCrachaFrente.setBounds(46, 88, 400, 250);
		pFCrachaFrente.add(lbFCrachaFrente);

		pFCrachaVerso = new JPanel();
		tabbedPaneFrenteVerso.addTab("Verso  ", null, pFCrachaVerso, null);
		pFCrachaVerso.setLayout(null);

		JButton btnFCrachaVoltar = new JButton("Voltar");
		btnFCrachaVoltar.setBounds(400, 407, 89, 23);
		pFCrachaVerso.add(btnFCrachaVoltar);

		lbFCrachaVerso = new JLabel("");
		lbFCrachaVerso.setBorder(new EtchedBorder(EtchedBorder.RAISED, null,
				null));
		lbFCrachaVerso.setBounds(46, 88, 400, 250);
		pFCrachaVerso.add(lbFCrachaVerso);
		btnFCrachaVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				cardlayout2.show(JpanelCliente, "frameCliente");

			}
		});

		JLabel lbFCrachaProduto = new JLabel("Produto: ");
		lbFCrachaProduto.setBounds(28, 11, 46, 20);
		cardCracha.add(lbFCrachaProduto);

		tfFCrachaProduto = new JTextField();
		tfFCrachaProduto.setBackground(Color.WHITE);
		tfFCrachaProduto.setEditable(false);
		tfFCrachaProduto.setBounds(75, 11, 188, 20);
		cardCracha.add(tfFCrachaProduto);
		tfFCrachaProduto.setColumns(10);

		JLabel lbFCrachaTipoDoProduto = new JLabel("Tipo do Produto:");
		lbFCrachaTipoDoProduto.setBounds(28, 36, 86, 20);
		cardCracha.add(lbFCrachaTipoDoProduto);

		tfFCrachaTipoDoProduto = new JTextField();
		tfFCrachaTipoDoProduto.setBackground(Color.WHITE);
		tfFCrachaTipoDoProduto.setEditable(false);
		tfFCrachaTipoDoProduto.setColumns(10);
		tfFCrachaTipoDoProduto.setBounds(115, 36, 148, 20);
		cardCracha.add(tfFCrachaTipoDoProduto);

		JLabel lbFCrachaEspessura = new JLabel("Espessura:");
		lbFCrachaEspessura.setBounds(28, 111, 62, 20);
		cardCracha.add(lbFCrachaEspessura);

		tfFCrachaEspessura = new JTextField();
		tfFCrachaEspessura.setBackground(Color.WHITE);
		tfFCrachaEspessura.setEditable(false);
		tfFCrachaEspessura.setColumns(10);
		tfFCrachaEspessura.setBounds(93, 111, 50, 20);
		cardCracha.add(tfFCrachaEspessura);

		JLabel lbFCrachaClasseDoProduto = new JLabel("Classe do Produto:");
		lbFCrachaClasseDoProduto.setBounds(28, 61, 98, 20);
		cardCracha.add(lbFCrachaClasseDoProduto);

		tfFCrachaClasseDoProduto = new JTextField();
		tfFCrachaClasseDoProduto.setBackground(Color.WHITE);
		tfFCrachaClasseDoProduto.setEditable(false);
		tfFCrachaClasseDoProduto.setColumns(10);
		tfFCrachaClasseDoProduto.setBounds(125, 61, 138, 20);
		cardCracha.add(tfFCrachaClasseDoProduto);

		JLabel lbFCrachaFurado = new JLabel("Furado:");
		lbFCrachaFurado.setBounds(164, 111, 46, 20);
		cardCracha.add(lbFCrachaFurado);

		tfFCrachaFurado = new JTextField();
		tfFCrachaFurado.setBackground(Color.WHITE);
		tfFCrachaFurado.setEditable(false);
		tfFCrachaFurado.setColumns(10);
		tfFCrachaFurado.setBounds(213, 111, 50, 20);
		cardCracha.add(tfFCrachaFurado);

		JLabel lbFCrachaPresilhaCordao = new JLabel("Presilha / Cord\u00E3o:");
		lbFCrachaPresilhaCordao.setBounds(28, 136, 98, 20);
		cardCracha.add(lbFCrachaPresilhaCordao);

		tfFCrachaPresilhaCordao = new JTextField();
		tfFCrachaPresilhaCordao.setBackground(Color.WHITE);
		tfFCrachaPresilhaCordao.setEditable(false);
		tfFCrachaPresilhaCordao.setColumns(10);
		tfFCrachaPresilhaCordao.setBounds(125, 136, 138, 20);
		cardCracha.add(tfFCrachaPresilhaCordao);

		JLabel lbFCrachaOrientao = new JLabel("Orienta\u00E7\u00E3o:");
		lbFCrachaOrientao.setBounds(28, 86, 62, 20);
		cardCracha.add(lbFCrachaOrientao);

		tfFCrachaOrientacao = new JTextField();
		tfFCrachaOrientacao.setBackground(Color.WHITE);
		tfFCrachaOrientacao.setEditable(false);
		tfFCrachaOrientacao.setColumns(10);
		tfFCrachaOrientacao.setBounds(93, 86, 171, 20);
		cardCracha.add(tfFCrachaOrientacao);

		JLabel lbFCrachaProtetor = new JLabel("Protetor:");
		lbFCrachaProtetor.setBounds(28, 161, 54, 20);
		cardCracha.add(lbFCrachaProtetor);

		tfFCrachaProtetor = new JTextField();
		tfFCrachaProtetor.setBackground(Color.WHITE);
		tfFCrachaProtetor.setEditable(false);
		tfFCrachaProtetor.setColumns(10);
		tfFCrachaProtetor.setBounds(79, 161, 184, 20);
		cardCracha.add(tfFCrachaProtetor);

		JLabel lbFCrachaProtetorCor = new JLabel("Protetor Cor:");
		lbFCrachaProtetorCor.setBounds(28, 186, 65, 20);
		cardCracha.add(lbFCrachaProtetorCor);

		tfFCrachaProtetorCor = new JTextField();
		tfFCrachaProtetorCor.setBackground(Color.WHITE);
		tfFCrachaProtetorCor.setEditable(false);
		tfFCrachaProtetorCor.setColumns(10);
		tfFCrachaProtetorCor.setBounds(102, 186, 161, 20);
		cardCracha.add(tfFCrachaProtetorCor);

		JLabel lbFCrachaImpressoFace = new JLabel("Impress\u00E3o Face:");
		lbFCrachaImpressoFace.setBounds(28, 211, 86, 20);
		cardCracha.add(lbFCrachaImpressoFace);

		tfFCrachaImpressaoFace = new JTextField();
		tfFCrachaImpressaoFace.setBackground(Color.WHITE);
		tfFCrachaImpressaoFace.setEditable(false);
		tfFCrachaImpressaoFace.setColumns(10);
		tfFCrachaImpressaoFace.setBounds(113, 211, 151, 20);
		cardCracha.add(tfFCrachaImpressaoFace);

		JLabel lbFCrachaTipo = new JLabel("Tecnologia Acesso:");
		lbFCrachaTipo.setBounds(28, 236, 98, 20);
		cardCracha.add(lbFCrachaTipo);

		tfFCrachaTecnologiaAcesso = new JTextField();
		tfFCrachaTecnologiaAcesso.setBackground(Color.WHITE);
		tfFCrachaTecnologiaAcesso.setEditable(false);
		tfFCrachaTecnologiaAcesso.setColumns(10);
		tfFCrachaTecnologiaAcesso.setBounds(125, 236, 50, 20);
		cardCracha.add(tfFCrachaTecnologiaAcesso);

		JLabel lbFCrachaCodigoDeBarras = new JLabel("C\u00F3digo de Barras:");
		lbFCrachaCodigoDeBarras.setBounds(28, 286, 91, 20);
		cardCracha.add(lbFCrachaCodigoDeBarras);

		tfFCrachaCodigoDeBarras = new JTextField();
		tfFCrachaCodigoDeBarras.setBackground(Color.WHITE);
		tfFCrachaCodigoDeBarras.setEditable(false);
		tfFCrachaCodigoDeBarras.setColumns(10);
		tfFCrachaCodigoDeBarras.setBounds(125, 286, 50, 20);
		cardCracha.add(tfFCrachaCodigoDeBarras);

		JLabel lbFCrachaTarjaMagnetica = new JLabel("Tarja Magn\u00E9tica:");
		lbFCrachaTarjaMagnetica.setBounds(28, 261, 91, 20);
		cardCracha.add(lbFCrachaTarjaMagnetica);

		tfFCrachaTarjaMagnetica = new JTextField();
		tfFCrachaTarjaMagnetica.setBackground(Color.WHITE);
		tfFCrachaTarjaMagnetica.setEditable(false);
		tfFCrachaTarjaMagnetica.setColumns(10);
		tfFCrachaTarjaMagnetica.setBounds(125, 261, 50, 20);
		cardCracha.add(tfFCrachaTarjaMagnetica);

		tfFCrachaTarja01 = new JTextField();
		tfFCrachaTarja01.setBackground(Color.WHITE);
		tfFCrachaTarja01.setEditable(false);
		tfFCrachaTarja01.setColumns(10);
		tfFCrachaTarja01.setBounds(80, 411, 50, 20);
		cardCracha.add(tfFCrachaTarja01);

		JLabel lbFCrachaTarja01 = new JLabel("Tarja 01:");
		lbFCrachaTarja01.setBounds(28, 411, 46, 20);
		cardCracha.add(lbFCrachaTarja01);

		JLabel lbFCrachaTarja02 = new JLabel("Tarja 02:");
		lbFCrachaTarja02.setBounds(160, 411, 50, 20);
		cardCracha.add(lbFCrachaTarja02);

		tfFCrachaTarja02 = new JTextField();
		tfFCrachaTarja02.setBackground(Color.WHITE);
		tfFCrachaTarja02.setEditable(false);
		tfFCrachaTarja02.setColumns(10);
		tfFCrachaTarja02.setBounds(213, 411, 50, 20);
		cardCracha.add(tfFCrachaTarja02);

		JLabel lbFCrachaTarja03 = new JLabel("Tarja 03:");
		lbFCrachaTarja03.setBounds(28, 437, 50, 20);
		cardCracha.add(lbFCrachaTarja03);

		tfFCrachaTarja03 = new JTextField();
		tfFCrachaTarja03.setBackground(Color.WHITE);
		tfFCrachaTarja03.setEditable(false);
		tfFCrachaTarja03.setColumns(10);
		tfFCrachaTarja03.setBounds(81, 437, 50, 20);
		cardCracha.add(tfFCrachaTarja03);

		JLabel lbFCrachaProximidade = new JLabel("Proximidade:");
		lbFCrachaProximidade.setBounds(28, 311, 65, 20);
		cardCracha.add(lbFCrachaProximidade);

		tfFCrachaProximidade = new JTextField();
		tfFCrachaProximidade.setBackground(Color.WHITE);
		tfFCrachaProximidade.setEditable(false);
		tfFCrachaProximidade.setColumns(10);
		tfFCrachaProximidade.setBounds(125, 311, 50, 20);
		cardCracha.add(tfFCrachaProximidade);

		tfFCrachaTipoProximidade = new JTextField();
		tfFCrachaTipoProximidade.setBackground(Color.WHITE);
		tfFCrachaTipoProximidade.setEditable(false);
		tfFCrachaTipoProximidade.setColumns(10);
		tfFCrachaTipoProximidade.setBounds(122, 461, 143, 20);
		cardCracha.add(tfFCrachaTipoProximidade);

		JLabel lbFCrachaTipoProximidade = new JLabel("Tipo Proximidade:");
		lbFCrachaTipoProximidade.setBounds(28, 461, 86, 20);
		cardCracha.add(lbFCrachaTipoProximidade);

		JLabel lbFCrachaTipoTarjaMagnetica = new JLabel(
				"Tipo Tarja Magn\u00E9tica:");
		lbFCrachaTipoTarjaMagnetica.setBounds(26, 361, 106, 20);
		cardCracha.add(lbFCrachaTipoTarjaMagnetica);

		tfFCrachaTipoTarjaMagnetica = new JTextField();
		tfFCrachaTipoTarjaMagnetica.setBackground(Color.WHITE);
		tfFCrachaTipoTarjaMagnetica.setEditable(false);
		tfFCrachaTipoTarjaMagnetica.setColumns(10);
		tfFCrachaTipoTarjaMagnetica.setBounds(137, 361, 126, 20);
		cardCracha.add(tfFCrachaTipoTarjaMagnetica);

		JLabel lbFCrachaTipoCodBarras = new JLabel("Tipo Cod. Barras:");
		lbFCrachaTipoCodBarras.setBounds(28, 336, 98, 20);
		cardCracha.add(lbFCrachaTipoCodBarras);

		tfFCrachaTipoCodBarras = new JTextField();
		tfFCrachaTipoCodBarras.setBackground(Color.WHITE);
		tfFCrachaTipoCodBarras.setEditable(false);
		tfFCrachaTipoCodBarras.setBounds(121, 336, 142, 20);
		cardCracha.add(tfFCrachaTipoCodBarras);
		tfFCrachaTipoCodBarras.setColumns(10);

		JLabel lbFCrachaNumeroDeDgitos = new JLabel(
				"N\u00FAmero de D\u00EDgitos:");
		lbFCrachaNumeroDeDgitos.setBounds(28, 386, 91, 20);
		cardCracha.add(lbFCrachaNumeroDeDgitos);

		tfFCrachaNumeroDeDigitos = new JTextField();
		tfFCrachaNumeroDeDigitos.setBackground(Color.WHITE);
		tfFCrachaNumeroDeDigitos.setEditable(false);
		tfFCrachaNumeroDeDigitos.setBounds(125, 386, 138, 20);
		cardCracha.add(tfFCrachaNumeroDeDigitos);
		tfFCrachaNumeroDeDigitos.setColumns(10);

		btnNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				tfPesquisaCliente.setText("");
				spnListaClientes.setVisible(false);

				cardlayout.show(JpanelSecundario, "frame01");

				tfPesquisaCliente.setEditable(false);
				btnPesquisaCliente.setEnabled(false);
				btnNovoCliente.setEnabled(false);
				btnNovoUsuario.setEnabled(false);
				btnAreaUsuario.setEnabled(false);

				tfRazaoSocial.setText("");
				tfCnpj.setText("");
				tfNomeFantasia.setText("");
				tfVendedor.setText("");
				tfContato.setText("");
				tfTelefoneCliente1.setText("");
				tfEmailCliente.setText("");
				tfTelefoneCliente2.setText("");

				tfLogradouroCliente.setText("");
				tfNumeroCliente.setText("");
				tfComplementoCliente.setText("");
				tfBairroCliente.setText("");
				tfCidadeCliente.setText("");
				cbUfCliente.setSelectedIndex(0);
				tfCepCliente.setText("");

			}
		});

		btnNovoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tfPesquisaCliente.setText("");
				spnListaClientes.setVisible(false);

				btnNovoCliente.setEnabled(false);
				btnNovoUsuario.setEnabled(false);
				btnAreaUsuario.setEnabled(false);
				btnPesquisaCliente.setEnabled(false);
				tfPesquisaCliente.setEnabled(false);

				btgAdmOper.clearSelection();
				tfNomeCompleto.setText("");
				tfCpf.setText("");
				tfLogin.setText("");
				tfSenha.setText("");
				tfRepetirSenha.setText("");
				tfEmail.setText("");
				tfTelefone1.setText("");
				tfTelefone2.setText("");
				tfLogradouro.setText("");
				tfNumero.setText("");
				tfComplemento.setText("");
				tfBairro.setText("");
				tfCidade.setText("");
				cbUf.setSelectedIndex(0);
				tfCep.setText("");

				cardlayout.show(JpanelSecundario, "frame02");

			}
		});

		btnAreaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tfPesquisaCliente.setText("");
				spnListaClientes.setVisible(false);

				tfPesquisaCliente.setEnabled(false);
				btnPesquisaCliente.setEnabled(false);
				btnNovoCliente.setEnabled(false);
				btnNovoUsuario.setEnabled(false);
				btnAreaUsuario.setEnabled(false);
				cbAUCpesquisar.setSelectedIndex(0);

				cardlayout.show(JpanelSecundario, "frame03");

				tabbedPaneAreaUsuario
						.setSelectedComponent(panelClienteAreaUsuario);

			}
		});

		mntmNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JpanelPrincipal.setVisible(true);
				JpanelSecundario.setVisible(true);
				JpanelCliente.setVisible(false);
				cardlayout.show(JpanelSecundario, "frame01");

				tfPesquisaCliente.setText("");
				spnListaClientes.setVisible(false);

				tfPesquisaCliente.setEditable(false);
				btnPesquisaCliente.setEnabled(false);
				btnNovoCliente.setEnabled(false);
				btnNovoUsuario.setEnabled(false);
				btnAreaUsuario.setEnabled(false);

				tfRazaoSocial.setText("");
				tfCnpj.setText("");
				tfNomeFantasia.setText("");
				tfVendedor.setText("");
				tfContato.setText("");
				tfTelefoneCliente1.setText("");
				tfEmailCliente.setText("");
				tfTelefoneCliente2.setText("");

				tfLogradouroCliente.setText("");
				tfNumeroCliente.setText("");
				tfComplementoCliente.setText("");
				tfBairroCliente.setText("");
				tfCidadeCliente.setText("");
				cbUfCliente.setSelectedIndex(0);
				tfCepCliente.setText("");

			}
		});

	}

	public static JLabel getLb_FrenteCracha() {
		return lb_FrenteCracha;
	}

	public static void setLb_FrenteCracha(JLabel lb_FrenteCracha) {
		JfPrincipal.lb_FrenteCracha = lb_FrenteCracha;
	}

	public static JLabel getLb_VersoCracha() {
		return lb_VersoCracha;
	}

	public static void setLb_VersoCracha(JLabel lb_VersoCracha) {
		JfPrincipal.lb_VersoCracha = lb_VersoCracha;
	}

	public Layout getLocalizadoLayout() {
		return localizadoLayout;
	}

	public void setLocalizadoLayout(Layout localizadoLayout) {
		this.localizadoLayout = localizadoLayout;
	}

	public TipoAcesso getLocalizadoTipoAcesso() {
		return localizadoTipoAcesso;
	}

	public void setLocalizadoTipoAcesso(TipoAcesso localizadoTipoAcesso) {
		this.localizadoTipoAcesso = localizadoTipoAcesso;
	}

	public static Usuario getLogado() {
		return logado;
	}

	public static void setLogado(Usuario logado) {
		JfPrincipal.logado = logado;
	}

}
