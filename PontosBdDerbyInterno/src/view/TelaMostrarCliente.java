package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
import controller.Cliente;

public class TelaMostrarCliente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField ftfCpf;
	private JTextField tfNome;
	private JTextField tfLogradouro;
	private JTextField tfComplemento;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField tfTelefone1;
	private JTextField tfTelefone2;
	private JTextField tfPontos;
	private JTextField tfNumero;
	private JTextField tfCep;
	private JTextField tfDataCadastro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			TelaMostrarCliente dialog = new TelaMostrarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TelaMostrarCliente() {
		setUndecorated(true);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				TelaMostrarCliente.class.getResource("/imagens/dinheiro.gif")));
		setTitle("Pontos");
		setResizable(false);
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(507, 0, 87, 69);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(TelaMostrarCliente.class.getResource("/imagens/dinheiro2.png")));
		contentPanel.add(lblNewLabel);

		JLabel lbUsuarioLogado = new JLabel("Usu\u00E1rio Logado: ");
		lbUsuarioLogado.setBounds(107, 21, 137, 28);
		lbUsuarioLogado.setForeground(Color.ORANGE);
		lbUsuarioLogado.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPanel.add(lbUsuarioLogado);
		
		final JLabel lblUsuarioLogado = new JLabel("Usu\u00E1rio Logado");
		lblUsuarioLogado.setBounds(251, 21, 251, 28);
		lblUsuarioLogado.setForeground(Color.ORANGE);
		lblUsuarioLogado.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuarioLogado.setText(TelaPrincipal.logado.getNome());
		contentPanel.add(lblUsuarioLogado);

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 600, 69);
		label.setIcon(new ImageIcon(TelaMostrarCliente.class
				.getResource("/imagens/fundo_1.jpg")));
		contentPanel.add(label);
		
		final JButton btnSalvarDados = new JButton("Salvar");
		btnSalvarDados.setBounds(118, 305, 74, 28);
		btnSalvarDados.setPressedIcon(new ImageIcon(TelaMostrarCliente.class.getResource("/imagens/fundo_2.jpg")));
		btnSalvarDados.setRolloverIcon(new ImageIcon(TelaMostrarCliente.class.getResource("/imagens/botao_fundo_2.jpg")));
		btnSalvarDados.setIcon(new ImageIcon(TelaMostrarCliente.class.getResource("/imagens/botao_fundo_1.jpg")));
		
		btnSalvarDados.setEnabled(false);
		btnSalvarDados.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalvarDados.setForeground(Color.WHITE);
		btnSalvarDados.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSalvarDados.setBorder(new BevelBorder(BevelBorder.RAISED, null,

						null, null, null));
		contentPanel.add(btnSalvarDados);
		
		
		final JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(43, 305, 72, 28);
		btnEditar.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));

		btnEditar.setIcon(new ImageIcon(TelaMostrarCliente.class.getResource("/imagens/botao_fundo_1.jpg")));
		btnEditar.setRolloverIcon(new ImageIcon(TelaMostrarCliente.class.getResource("/imagens/botao_fundo_2.jpg")));
		btnEditar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(btnEditar);

		final JButton btnExcluirUsuario = new JButton("Excluir Cliente");
		btnExcluirUsuario.setBounds(42, 339, 150, 28);
		btnExcluirUsuario.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		
			
		if (TelaPrincipal.logado.getTipo().equalsIgnoreCase("Administrador")) {

			btnExcluirUsuario.setEnabled(true);

		} else {

			btnExcluirUsuario.setEnabled(false);
		}
		
		
		btnExcluirUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int resposta = JOptionPane.showConfirmDialog(null,
						"Deseja realmente excluir o cliente");

				if (resposta == 0) {

		
						Cliente.excluirCliente();

						dispose();

				if (resposta == 1) {

					JOptionPane.showMessageDialog(null,
							"Não desejo excluir cliente");
					
				
					
				}

				}

			}

		});
		btnExcluirUsuario.setRolloverIcon(new ImageIcon(TelaMostrarCliente.class.getResource("/imagens/botao_fundo_2.jpg")));
		btnExcluirUsuario.setIcon(new ImageIcon(TelaMostrarCliente.class.getResource("/imagens/botao_fundo_1.jpg")));
		btnExcluirUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExcluirUsuario.setForeground(Color.WHITE);
		btnExcluirUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(btnExcluirUsuario);

		final JButton btnResgatarPontos = new JButton("Resgatar Pontos");
		btnResgatarPontos.setBounds(227, 339, 150, 28);
		btnResgatarPontos.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		btnResgatarPontos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
					TelaResgatarPontos frame = new TelaResgatarPontos();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
					new Thread(new Runnable() {						
						@Override
						public void run() {
							Cliente cliente = Cliente.localizarClientePeloCpf((TelaPrincipal.localizado.getCpf()));
							tfPontos.setText(cliente.getPontos()+"");
						}
					}).start();
					
				
		
			}
		});
		btnResgatarPontos.setRolloverIcon(new ImageIcon(TelaMostrarCliente.class.getResource("/imagens/botao_fundo_2.jpg")));
		btnResgatarPontos.setIcon(new ImageIcon(TelaMostrarCliente.class.getResource("/imagens/botao_fundo_1.jpg")));
		btnResgatarPontos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnResgatarPontos.setForeground(Color.WHITE);
		btnResgatarPontos.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(btnResgatarPontos);

		final JButton btnAdionarPontos = new JButton("Adicionar Pontos");
		btnAdionarPontos.setBounds(227, 305, 150, 28);
		btnAdionarPontos.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		btnAdionarPontos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


					TelaAdicionarPontos frame = new TelaAdicionarPontos();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
					
					new Thread(new Runnable() {						
						@Override
						public void run() {
							Cliente cliente = Cliente.localizarClientePeloCpf((TelaPrincipal.localizado.getCpf()));
							tfPontos.setText(cliente.getPontos()+"");
						}
					}).start();
			
			}			
		});
		btnAdionarPontos.setRolloverIcon(new ImageIcon(TelaMostrarCliente.class.getResource("/imagens/botao_fundo_2.jpg")));
		btnAdionarPontos.setIcon(new ImageIcon(TelaMostrarCliente.class.getResource("/imagens/botao_fundo_1.jpg")));
		btnAdionarPontos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdionarPontos.setForeground(Color.WHITE);
		btnAdionarPontos.setFont(new Font("Tahoma", Font.BOLD, 13));
		getRootPane().setDefaultButton(btnAdionarPontos);
		contentPanel.add(btnAdionarPontos);

		JPanel panel = new JPanel();
		panel.setBounds(44, 80, 513, 219);
		panel.setBorder(new TitledBorder(null, "Dados do Usu\u00E1rio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(panel);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(21, 58, 51, 27);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 11));

		final JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(21, 28, 51, 20);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.setLayout(null);
		panel.add(lblCpf);
		panel.add(lblNome);

		JLabel lblPontos = new JLabel(String.valueOf(TelaPrincipal.localizado
				.getPontos()));
		lblPontos.setBounds(0, 50, -45, -50);
		panel.add(lblPontos);
		lblPontos.setFont(new Font("Ebrima", Font.PLAIN, 14));

		JLabel lblPontos_1 = new JLabel("Pontos");
		lblPontos_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPontos_1.setBounds(358, 58, 52, 20);
		panel.add(lblPontos_1);

		ftfCpf = new JFormattedTextField(
				Cliente.Mascara(""));
		ftfCpf.setDisabledTextColor(Color.WHITE);
		ftfCpf.setEditable(false);
		ftfCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ftfCpf.setBackground(Color.WHITE);
		ftfCpf.setBounds(83, 56, 118, 25);
		ftfCpf.setText(String.valueOf(TelaPrincipal.localizado.getCpf()));

		panel.add(ftfCpf);
		
		tfNome = new JTextField();
		tfNome.setDisabledTextColor(Color.WHITE);
		tfNome.setBackground(Color.WHITE);
		tfNome.setEditable(false);
		tfNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNome.setBounds(83, 26, 404, 25);
		panel.add(tfNome);
		tfNome.setColumns(10);
		tfNome.setText(TelaPrincipal.localizado.getNome());
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLogradouro.setBounds(21, 88, 62, 20);
		panel.add(lblLogradouro);
		
		tfLogradouro = new JTextField();
		tfLogradouro.setBackground(Color.WHITE);
		tfLogradouro.setDisabledTextColor(Color.WHITE);
		tfLogradouro.setText(TelaPrincipal.localizado.getEndereco().getLogradouro());
		tfLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfLogradouro.setEditable(false);
		tfLogradouro.setColumns(10);
		tfLogradouro.setBounds(83, 86, 404, 25);
		panel.add(tfLogradouro);
		
		tfComplemento = new JTextField();
		tfComplemento.setBackground(Color.WHITE);
		tfComplemento.setDisabledTextColor(Color.WHITE);
		tfComplemento.setText(TelaPrincipal.localizado.getEndereco().getComplemento());
		tfComplemento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfComplemento.setEditable(false);
		tfComplemento.setColumns(10);
		tfComplemento.setBounds(243, 116, 244, 25);
		panel.add(tfComplemento);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblComplemento.setBounds(168, 118, 75, 20);
		panel.add(lblComplemento);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBairro.setBounds(21, 148, 43, 20);
		panel.add(lblBairro);
		
		tfBairro = new JTextField();
		tfBairro.setBackground(Color.WHITE);
		tfBairro.setDisabledTextColor(Color.WHITE);
		tfBairro.setText(TelaPrincipal.localizado.getEndereco().getBairro());
		tfBairro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfBairro.setEditable(false);
		tfBairro.setColumns(10);
		tfBairro.setBounds(83, 146, 131, 25);
		panel.add(tfBairro);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBorder(null);
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCidade.setBounds(229, 148, 43, 20);
		panel.add(lblCidade);
		
		tfCidade = new JTextField();
		tfCidade.setBackground(Color.WHITE);
		tfCidade.setText(TelaPrincipal.localizado.getEndereco().getCidade());
		tfCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCidade.setEditable(false);
		tfCidade.setColumns(10);
		tfCidade.setBounds(273, 146, 145, 25);
		panel.add(tfCidade);
		
		JLabel lblUf = new JLabel("CEP");
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUf.setBounds(21, 178, 32, 20);
		panel.add(lblUf);
		
		JLabel lblFone1 = new JLabel("Fone 01");
		lblFone1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFone1.setBounds(183, 178, 42, 20);
		panel.add(lblFone1);
		
		tfTelefone1 = new JTextField();
		tfTelefone1.setBackground(Color.WHITE);
		tfTelefone1.setDisabledTextColor(Color.WHITE);
		tfTelefone1.setText(TelaPrincipal.localizado.getTelefone().getTelefone1());
		tfTelefone1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTelefone1.setEditable(false);
		tfTelefone1.setColumns(10);
		tfTelefone1.setBounds(226, 176, 105, 25);
		tfTelefone1.setText(TelaPrincipal.localizado.getTelefone().getTelefone1());
		panel.add(tfTelefone1);
		
		JLabel lblFone2 = new JLabel("Fone 02");
		lblFone2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFone2.setBounds(337, 178, 41, 20);
		panel.add(lblFone2);
		
		tfTelefone2 = new JTextField();
		tfTelefone2.setBackground(Color.WHITE);
		tfTelefone2.setDisabledTextColor(Color.WHITE);
		tfTelefone2.setText(TelaPrincipal.localizado.getTelefone().getTelefone2());
		tfTelefone2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTelefone2.setEditable(false);
		tfTelefone2.setColumns(10);
		tfTelefone2.setText(TelaPrincipal.localizado.getTelefone().getTelefone2());
		tfTelefone2.setBounds(382, 176, 105, 25);
		panel.add(tfTelefone2);
		
		tfPontos = new JTextField();
		tfPontos.setForeground(Color.RED);
		tfPontos.setText(TelaPrincipal.localizado.getPontos()+"");
		tfPontos.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfPontos.setEditable(false);
		tfPontos.setColumns(10);
		tfPontos.setBackground(Color.WHITE);
		tfPontos.setBounds(397, 56, 90, 25);
		panel.add(tfPontos);
		
		final JComboBox cbUf = new JComboBox();
		cbUf.setOpaque(false);
		cbUf.setEnabled(false);
		cbUf.setEditable(true);
		cbUf.setFont(new Font("Zurich Cn BT", Font.BOLD, 13));
		cbUf.setModel(new DefaultComboBoxModel(new String[] {"UF", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cbUf.setToolTipText("");
		cbUf.setBounds(434, 146, 53, 25);
		panel.add(cbUf);
		cbUf.setSelectedItem(TelaPrincipal.localizado.getEndereco().getUf());
		
		JLabel lblNumero = new JLabel("N.\u00BA");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumero.setBounds(21, 118, 48, 20);
		panel.add(lblNumero);
		
		tfNumero = new JTextField();
		tfNumero.setText(TelaPrincipal.localizado.getEndereco().getNumero());
		tfNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNumero.setEditable(false);
		tfNumero.setDisabledTextColor(Color.WHITE);
		tfNumero.setColumns(10);
		tfNumero.setBackground(Color.WHITE);
		tfNumero.setBounds(83, 116, 72, 25);
		panel.add(tfNumero);
		
		tfCep = new JTextField();
		tfCep.setText((String) null);
		tfCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCep.setEditable(false);
		tfCep.setDisabledTextColor(Color.WHITE);
		tfCep.setColumns(10);
		tfCep.setBackground(Color.WHITE);
		tfCep.setBounds(83, 176, 93, 25);
		tfCep.setText(TelaPrincipal.localizado.getEndereco().getCep());
		panel.add(tfCep);
		
		JLabel lblDataCadastro = new JLabel("C. Desde");
		lblDataCadastro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDataCadastro.setBounds(206, 58, 52, 20);
		panel.add(lblDataCadastro);
		
			
		tfDataCadastro = new JTextField();
		tfDataCadastro.setText(TelaPrincipal.ft.format(TelaPrincipal.localizado.getDataCadastro()));
		tfDataCadastro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDataCadastro.setEditable(false);
		tfDataCadastro.setDisabledTextColor(Color.WHITE);
		tfDataCadastro.setColumns(10);
		tfDataCadastro.setBackground(Color.WHITE);
		tfDataCadastro.setBounds(256, 56, 95, 25);
		panel.add(tfDataCadastro);
		

		JButton button = new JButton("Cancelar");
		button.setBounds(409, 339, 150, 28);
		button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		button.setRolloverIcon(new ImageIcon(TelaMostrarCliente.class.getResource("/imagens/botao_fundo_2.jpg")));
		button.setIcon(new ImageIcon(TelaMostrarCliente.class.getResource("/imagens/botao_fundo_1.jpg")));
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(button);

		final JButton btn2ViaCarto = new JButton("2\u00AA via cart\u00E3o");
		btn2ViaCarto.setBounds(409, 305, 150, 28);
		contentPanel.add(btn2ViaCarto);
		btn2ViaCarto.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btn2ViaCarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {

					impressao.ControleImpressao.criarPdf(TelaPrincipal.localizado.getNome(),TelaPrincipal.localizado
							.getCpf());
				

				} catch (IOException e1) {
					// TODO Auto-generated catch block

					JOptionPane.showMessageDialog(null, e1);
				}

			}
		});
		btn2ViaCarto.setRolloverIcon(new ImageIcon(TelaMostrarCliente.class.getResource("/imagens/botao_fundo_2.jpg")));
		btn2ViaCarto.setIcon(new ImageIcon(TelaMostrarCliente.class.getResource("/imagens/botao_fundo_1.jpg")));
		btn2ViaCarto.setHorizontalTextPosition(SwingConstants.CENTER);
		btn2ViaCarto.setForeground(Color.WHITE);
		btn2ViaCarto.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnEditar.setEnabled(false);
				btn2ViaCarto.setEnabled(false);
				btnExcluirUsuario.setEnabled(false);
				btnAdionarPontos.setEnabled(false);
				btnResgatarPontos.setEnabled(false);
				
				btnSalvarDados.setEnabled(true);
				rootPane.setDefaultButton(btnSalvarDados);
				
				tfNome.setEditable(true);
				ftfCpf.setEditable(true);
				tfLogradouro.setEditable(true);
				tfNumero.setEditable(true);
				tfComplemento.setEditable(true);
				tfBairro.setEditable(true);
				tfCidade.setEditable(true);
				cbUf.setEnabled(true);
				cbUf.setEditable(true);
				tfCep.setEditable(true);
				tfTelefone1.setEditable(true);
				tfTelefone2.setEditable(true);
		
			
			}		
		});
		
		btnSalvarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaPrincipal.localizado.setNome(tfNome.getText().toUpperCase());
				TelaPrincipal.localizado.setCpf(Cliente.removerMascara(ftfCpf.getText()));
				TelaPrincipal.localizado.getEndereco().setLogradouro(tfLogradouro.getText().toUpperCase());
				TelaPrincipal.localizado.getEndereco().setNumero(tfNumero.getText());
				TelaPrincipal.localizado.getEndereco().setComplemento(tfComplemento.getText().toUpperCase());
				TelaPrincipal.localizado.getEndereco().setBairro(tfBairro.getText().toUpperCase());
				TelaPrincipal.localizado.getEndereco().setCidade(tfCidade.getText().toUpperCase());
				TelaPrincipal.localizado.getEndereco().setUf(cbUf.getSelectedItem()+"");
				TelaPrincipal.localizado.getEndereco().setCep(tfCep.getText());
				TelaPrincipal.localizado.getTelefone().setTelefone1(tfTelefone1.getText());
				TelaPrincipal.localizado.getTelefone().setTelefone2(tfTelefone2.getText());
				
						
				ClienteDao clienteDao = new ClienteDao();
				clienteDao.alterarDados(TelaPrincipal.localizado);
				
				tfNome.setEditable(false);
				ftfCpf.setEditable(false);
				tfLogradouro.setEditable(false);
				tfNumero.setEditable(false);
				tfComplemento.setEditable(false);
				tfBairro.setEditable(false);
				tfCidade.setEditable(false);
				tfCep.setEditable(false);
				cbUf.setEnabled(false);
				cbUf.setEditable(false);
				
				tfTelefone1.setEditable(false);
				tfTelefone2.setEditable(false);
				
				
				btnSalvarDados.setEnabled(false);
				
				
				
				new Thread(new Runnable() {						
					@Override
					public void run() {
						
						Cliente cliente = Cliente.localizarClientePeloCpf((TelaPrincipal.localizado.getCpf()));
						
						tfNome.setText(cliente.getNome());
						ftfCpf.setText(cliente.getCpf());
						tfLogradouro.setText(cliente.getEndereco().getLogradouro());
						tfComplemento.setText(cliente.getEndereco().getComplemento());
						tfBairro.setText(cliente.getEndereco().getBairro());
						tfCidade.setText(cliente.getEndereco().getCidade());
						cbUf.setToolTipText(cliente.getEndereco().getUf());
						tfTelefone1.setText(cliente.getTelefone().getTelefone1());
						tfTelefone2.setText(cliente.getTelefone().getTelefone2());
						
						
						if (TelaPrincipal.logado.getTipo().equalsIgnoreCase("Administrador")) {

							btnExcluirUsuario.setEnabled(true);

						} else {

							btnExcluirUsuario.setEnabled(false);
						}
						
						
					}
				}).start();
				
				btnEditar.setEnabled(true);
				btn2ViaCarto.setEnabled(true);
				btnAdionarPontos.setEnabled(true);
				btnExcluirUsuario.setEnabled(true);
				btnResgatarPontos.setEnabled(true);
				
				rootPane.setDefaultButton(btnAdionarPontos);
				
				btnEditar.setEnabled(true);				
			}
		});
		
		
		
		
	}
}
