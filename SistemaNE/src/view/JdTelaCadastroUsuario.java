package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controller.MaxLengthTextDocument;
import controller.cliente.Cliente;
import controller.cliente.ClienteRN;
import controller.endereco.Endereco;
import controller.login.Login;
import controller.usuario.Usuario;
import controller.usuario.UsuarioRN;

import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;

public class JdTelaCadastroUsuario extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2801762787270085397L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfNomeCompletoUsuario;
	private JTextField tfLogradouro;
	private JTextField tfNumero;
	private JTextField tfComplemento;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField tfLogin;
	private JTextField tfEmailUsuario;
	private JPasswordField pfSenha;
	private JPasswordField pfConfirmarSenha;
	private JTextField tfFuncao;
	private JComboBox cbStatusUsuario;
	private JFormattedTextField tfCep;
	private JFormattedTextField ftfTelefoneUsuario;
	private JFormattedTextField ftfCpf;
	private JComboBox cbNivelAcesso;
	private JComboBox cbUf;
	private JDateChooser JdcDtNascimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {

			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			JdTelaCadastroUsuario dialog = new JdTelaCadastroUsuario();
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
	public JdTelaCadastroUsuario() {
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JdTelaCadastroUsuario.class.getResource("/image/ne.png")));
		setTitle("Cadastro de Usu\u00E1rios");
		setBounds(100, 100, 1000, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel label = new JLabel("Card1");
		label.setBounds(118, 16, 0, 0);

		JLabel lblNomeCompleto = new JLabel("* Nome Completo");
		lblNomeCompleto.setBounds(88, 91, 97, 14);

		tfNomeCompletoUsuario = new JTextField();
		tfNomeCompletoUsuario.setBounds(88, 109, 261, 20);
		tfNomeCompletoUsuario.setColumns(10);

		JLabel lblCpf = new JLabel("* CPF");
		lblCpf.setBounds(584, 91, 97, 14);

		JLabel lblCadastroUsuarios = new JLabel("Cadastro de Usu\u00E1rios");
		lblCadastroUsuarios.setBounds(88, 51, 169, 14);
		lblCadastroUsuarios.setForeground(Color.BLACK);
		lblCadastroUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JSeparator separator = new JSeparator();
		separator.setBounds(88, 76, 606, 9);

		JLabel label_9 = new JLabel("Endere\u00E7o");
		label_9.setBounds(88, 260, 169, 14);
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(88, 282, 606, 9);

		JLabel lblLogradouro = new JLabel("* Logradouro");
		lblLogradouro.setBounds(88, 293, 97, 14);

		tfLogradouro = new JTextField();
		tfLogradouro.setBounds(88, 311, 478, 20);
		tfLogradouro.setColumns(10);

		JLabel lblNumero = new JLabel("* N\u00FAmero");
		lblNumero.setBounds(584, 293, 97, 14);

		tfNumero = new JTextField();
		tfNumero.setBounds(584, 311, 110, 20);
		tfNumero.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(88, 342, 97, 14);

		tfComplemento = new JTextField();
		tfComplemento.setBounds(88, 360, 372, 20);
		tfComplemento.setColumns(10);

		JLabel lblBairro = new JLabel("* Bairro");
		lblBairro.setBounds(484, 342, 97, 14);

		tfBairro = new JTextField();
		tfBairro.setBounds(484, 360, 210, 20);
		tfBairro.setColumns(10);

		JLabel lblCidade = new JLabel("* Cidade");
		lblCidade.setBounds(88, 392, 97, 14);

		tfCidade = new JTextField();
		tfCidade.setBounds(88, 410, 372, 20);
		tfCidade.setColumns(10);

		JLabel lblCep = new JLabel("* CEP");
		lblCep.setBounds(551, 391, 97, 14);

		tfCep = new JFormattedTextField(ClienteRN.CEP(""));
		tfCep.setBounds(552, 410, 142, 20);
		tfCep.setHorizontalAlignment(SwingConstants.LEFT);
		tfCep.setColumns(10);

		cbUf = new JComboBox();
		cbUf.setModel(new DefaultComboBoxModel(
				new String[] { " ", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cbUf.setBounds(484, 410, 52, 20);

		JLabel label_16 = new JLabel("* Campo Obrigat\u00F3rio.");
		label_16.setBounds(88, 466, 210, 14);
		contentPanel.setLayout(null);
		contentPanel.add(label);
		contentPanel.add(lblCadastroUsuarios);
		contentPanel.add(separator);
		contentPanel.add(lblNomeCompleto);
		contentPanel.add(lblCpf);
		contentPanel.add(tfNomeCompletoUsuario);
		contentPanel.add(label_9);
		contentPanel.add(separator_1);
		contentPanel.add(lblLogradouro);
		contentPanel.add(lblNumero);
		contentPanel.add(tfLogradouro);
		contentPanel.add(tfNumero);
		contentPanel.add(lblComplemento);
		contentPanel.add(lblBairro);
		contentPanel.add(tfComplemento);
		contentPanel.add(tfBairro);
		contentPanel.add(lblCidade);
		contentPanel.add(lblCep);
		contentPanel.add(tfCidade);
		contentPanel.add(cbUf);
		contentPanel.add(tfCep);
		contentPanel.add(label_16);

		ftfCpf = new JFormattedTextField(UsuarioRN.CPF(""));
		ftfCpf.setColumns(10);
		ftfCpf.setBounds(584, 109, 110, 20);
		contentPanel.add(ftfCpf);

		JLabel lblLogin = new JLabel("* Login");
		lblLogin.setBounds(88, 189, 152, 14);
		contentPanel.add(lblLogin);

		tfLogin = new JTextField();
		tfLogin.setColumns(10);
		tfLogin.setBounds(88, 207, 226, 20);
		contentPanel.add(tfLogin);

		JLabel lblEmail = new JLabel("* E-mail");
		lblEmail.setBounds(239, 140, 97, 14);
		contentPanel.add(lblEmail);

		tfEmailUsuario = new JTextField();
		tfEmailUsuario.setColumns(10);
		tfEmailUsuario.setBounds(240, 158, 226, 20);
		contentPanel.add(tfEmailUsuario);

		JLabel lblSenha = new JLabel("* Senha (6 d\u00EDgitos)");
		lblSenha.setBounds(337, 189, 97, 14);
		contentPanel.add(lblSenha);

		pfSenha = new JPasswordField();
		pfSenha.setColumns(10);
		pfSenha.setBounds(337, 207, 104, 20);

		MaxLengthTextDocument maxLength = new MaxLengthTextDocument();
		maxLength.setMaxChars(7);
		pfSenha.setDocument(maxLength);

		contentPanel.add(pfSenha);

		JLabel lblTelefone = new JLabel("*Telefone do usuário");
		lblTelefone.setBounds(91, 140, 124, 14);
		contentPanel.add(lblTelefone);

		ftfTelefoneUsuario = new JFormattedTextField(UsuarioRN.TelefoneCelular(""));
		ftfTelefoneUsuario.setColumns(10);
		ftfTelefoneUsuario.setBounds(88, 158, 127, 20);
		contentPanel.add(ftfTelefoneUsuario);

		JLabel lblConfirmarSenha = new JLabel("* Confirmar Senha");
		lblConfirmarSenha.setBounds(462, 189, 104, 14);
		contentPanel.add(lblConfirmarSenha);

		pfConfirmarSenha = new JPasswordField();
		pfConfirmarSenha.setColumns(10);
		pfConfirmarSenha.setBounds(462, 207, 104, 20);

		MaxLengthTextDocument maxLength2 = new MaxLengthTextDocument();
		maxLength2.setMaxChars(7);
		pfConfirmarSenha.setDocument(maxLength2);

		contentPanel.add(pfConfirmarSenha);

		JLabel lblStatusUsuario = new JLabel("* Status");
		lblStatusUsuario.setBounds(490, 140, 91, 14);
		contentPanel.add(lblStatusUsuario);

		cbStatusUsuario = new JComboBox();
		cbStatusUsuario.setModel(new DefaultComboBoxModel(new String[] { "", "Ativo", "Inativo" }));
		cbStatusUsuario.setBounds(490, 158, 87, 20);
		contentPanel.add(cbStatusUsuario);

		JLabel lblFuncao = new JLabel("* Fun\u00E7\u00E3o");
		lblFuncao.setBounds(373, 91, 152, 14);
		contentPanel.add(lblFuncao);

		tfFuncao = new JTextField();
		tfFuncao.setColumns(10);
		tfFuncao.setBounds(373, 109, 189, 20);
		contentPanel.add(tfFuncao);

		JLabel lblDataNascimento = new JLabel("* Dt Nascimento");
		lblDataNascimento.setBounds(603, 140, 91, 14);
		contentPanel.add(lblDataNascimento);

		JdcDtNascimento = new JDateChooser("dd/MM/yyyy", "##/##/#####", '_');
		JdcDtNascimento.setBounds(603, 157, 91, 20);
		contentPanel.add(JdcDtNascimento);

		JLabel lblUf = new JLabel("* UF");
		lblUf.setBounds(484, 392, 97, 14);
		contentPanel.add(lblUf);

		JLabel lblNvelAcesso = new JLabel("* N\u00EDvel Acesso");
		lblNvelAcesso.setBounds(603, 189, 91, 14);
		contentPanel.add(lblNvelAcesso);

		cbNivelAcesso = new JComboBox();
		cbNivelAcesso.setModel(new DefaultComboBoxModel(new String[] { "", "amarelo", "verde", "azul", "vermelho" }));
		cbNivelAcesso.setBounds(603, 207, 87, 20);
		contentPanel.add(cbNivelAcesso);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						String emailValido = tfEmailUsuario.getText().toLowerCase();

						boolean valido = controller.ValidarCpf.isCPF(UsuarioRN.removerMascara(ftfCpf.getText()));

						if (tfNomeCompletoUsuario.getText().isEmpty()) {

							JOptionPane.showMessageDialog(null, "Digite o nome completo do usuário");

							tfNomeCompletoUsuario.requestFocus();

						} else if (tfFuncao.getText().isEmpty()) {

							JOptionPane.showMessageDialog(null, "Digite a função do usuário");

							tfFuncao.requestFocus();

						} else if (ftfCpf.getText().isEmpty()) {

							JOptionPane.showMessageDialog(null, "Digite o CPF do usuário");

							ftfCpf.requestFocus();

						} else if (valido == false) {

							JOptionPane.showMessageDialog(null, "CPF inválido");

							ftfCpf.setText("");
							ftfCpf.requestFocus();

						} else if (ftfTelefoneUsuario.getText().equals("(  )      -    ")) {

							JOptionPane.showMessageDialog(null, "Digite o telefone do usuário");

							ftfTelefoneUsuario.requestFocus();

						} else if (tfEmailUsuario.getText().isEmpty()) {

							JOptionPane.showMessageDialog(null, "Digite o e-mail do usuário");

							tfEmailUsuario.requestFocus();

						} else if (!Pattern.matches(
								"\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b",
								emailValido)) {

							JOptionPane.showMessageDialog(null, "E-mail invalido");

							tfEmailUsuario.setText("");
							tfEmailUsuario.requestFocus();

						} else if (cbStatusUsuario.getSelectedItem().equals("")) {

							JOptionPane.showMessageDialog(null, "Selecione o status do usuário");

							cbStatusUsuario.requestFocus();

						} else if (JdcDtNascimento.getDate() == null) {

							JOptionPane.showMessageDialog(null, "Selecione a data de nascimento do Usuário");

							JdcDtNascimento.requestFocus();

						} else if (tfLogin.getText().isEmpty()) {

							JOptionPane.showMessageDialog(null, "Digite um login para o usuário");

							tfLogin.requestFocus();

						} else if (pfSenha.getPassword().equals("")) {

							JOptionPane.showMessageDialog(null, "Digite a senha para o usuário");

							pfSenha.requestFocus();

						} else if (pfSenha.getPassword().length < 6) {

							JOptionPane.showMessageDialog(null, "Digite uma senha com 6 Dígitos");
							
							pfSenha.setText("");
							pfConfirmarSenha.setText("");
							pfSenha.requestFocus();

						} else if (String.valueOf(pfConfirmarSenha.getPassword() )== null ) {

							JOptionPane.showMessageDialog(null, "Digite a confirmação da senha para o usuário");

							pfConfirmarSenha.requestFocus();

						} else if (!String.valueOf(pfSenha.getPassword())
								.equals(String.valueOf(pfConfirmarSenha.getPassword()))) {

							JOptionPane.showMessageDialog(null, "A senha e sua confirmação não estão iguais");

							pfSenha.setText("");
							pfConfirmarSenha.setText("");
							pfSenha.requestFocus();

						} else if (cbNivelAcesso.getSelectedItem().equals("")) {

							JOptionPane.showMessageDialog(null, "Selecione o nível de acesso do usuário");

							cbNivelAcesso.requestFocus();

						} else if (tfLogradouro.getText().isEmpty()) {

							JOptionPane.showMessageDialog(null, "Digite o logradouro");

							tfLogradouro.requestFocus();

						} else if (tfNumero.getText().isEmpty()) {

							JOptionPane.showMessageDialog(null, "Digite o número");

							tfNumero.requestFocus();

						} else if (tfBairro.getText().isEmpty()) {

							JOptionPane.showMessageDialog(null, "Digite o bairro");

							tfBairro.requestFocus();

						} else if (tfCidade.getText().isEmpty()) {

							JOptionPane.showMessageDialog(null, "Digite a cidade");

							tfCidade.requestFocus();

						} else if (cbUf.getSelectedItem().equals("")) {

							JOptionPane.showMessageDialog(null, "Selecione a unidade federal");

							cbNivelAcesso.requestFocus();

						} else if (tfCep.getText().equals("     -   ")) {

							JOptionPane.showMessageDialog(null, "Digite o CEP");

							tfCep.requestFocus();

						} else {

							java.util.Date dataUtil = JdcDtNascimento.getDate();
							java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

							Endereco endereco = new Endereco(tfLogradouro.getText().toUpperCase(), tfNumero.getText(),
									tfComplemento.getText().toUpperCase(), tfBairro.getText().toUpperCase(),
									tfCidade.getText().toUpperCase(), String.valueOf(cbUf.getSelectedItem()),
									tfCep.getText());

							Login login = new Login(tfLogin.getText().toLowerCase(),
									String.valueOf(pfSenha.getPassword()),
									String.valueOf(cbNivelAcesso.getSelectedItem()));

							Usuario usuario = new Usuario(tfNomeCompletoUsuario.getText().toUpperCase(),
									tfFuncao.getText().toUpperCase(), ftfCpf.getText(), ftfTelefoneUsuario.getText(),
									tfEmailUsuario.getText().toLowerCase(),
									String.valueOf(cbStatusUsuario.getSelectedItem()), dataSql);

							usuario.setEndereco(endereco);
							usuario.setLogin(login);

							UsuarioRN usuarioRN = new UsuarioRN();
							usuarioRN.CadastrarUsuario(usuario);

						}
					}

				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						dispose();

					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
