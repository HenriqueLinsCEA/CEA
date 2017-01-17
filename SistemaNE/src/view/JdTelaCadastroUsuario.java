package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controller.cliente.Cliente;

import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

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
	private JTextField tfEmail;
	private JPasswordField pfSenha;
	private JPasswordField pfConfirmarSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			
			UIManager
			.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
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
		tfNomeCompletoUsuario.setBounds(88, 109, 372, 20);
		tfNomeCompletoUsuario.setColumns(10);
		
		JLabel lblCpf = new JLabel("* CPF");
		lblCpf.setBounds(484, 91, 97, 14);
		
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
		
		JLabel lblNumero = new JLabel("* N.\u00BA");
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
		
		JFormattedTextField ftfCEP = new JFormattedTextField((AbstractFormatter) null);
		ftfCEP.setBounds(552, 410, 142, 20);
		ftfCEP.setHorizontalAlignment(SwingConstants.LEFT);
		ftfCEP.setColumns(10);
		
		JComboBox cbUf = new JComboBox();
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
		contentPanel.add(ftfCEP);
		contentPanel.add(label_16);
		
		JRadioButton radioButton = new JRadioButton("Administrador");
		radioButton.setActionCommand("ADMINISTRADOR");
		radioButton.setBounds(439, 51, 109, 23);
		contentPanel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Operador");
		radioButton_1.setActionCommand("OPERADOR");
		radioButton_1.setBounds(585, 51, 109, 23);
		contentPanel.add(radioButton_1);
		
		JFormattedTextField ftfCpf = new JFormattedTextField(Cliente.CPF(""));
		ftfCpf.setColumns(10);
		ftfCpf.setBounds(484, 109, 210, 20);
		contentPanel.add(ftfCpf);
		
		JLabel lblLogin = new JLabel("* Login");
		lblLogin.setBounds(88, 140, 97, 14);
		contentPanel.add(lblLogin);
		
		tfLogin = new JTextField();
		tfLogin.setColumns(10);
		tfLogin.setBounds(88, 158, 294, 20);
		contentPanel.add(tfLogin);
		
		JLabel lblEmail = new JLabel("* E-mail");
		lblEmail.setBounds(88, 189, 97, 14);
		contentPanel.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(88, 207, 294, 20);
		contentPanel.add(tfEmail);
		
		JLabel lblSenha = new JLabel("* Senha (6 d\u00EDgitos)");
		lblSenha.setBounds(409, 140, 116, 14);
		contentPanel.add(lblSenha);
		
		pfSenha = new JPasswordField();
		pfSenha.setColumns(10);
		pfSenha.setBounds(409, 158, 127, 20);
		contentPanel.add(pfSenha);
		
		JLabel lblTelefone = new JLabel("*Telefone Celular");
		lblTelefone.setBounds(409, 189, 88, 14);
		contentPanel.add(lblTelefone);
		
		JFormattedTextField ftfTelefoneCelular = new JFormattedTextField(Cliente.TelefoneCelular(""));
		ftfTelefoneCelular.setColumns(10);
		ftfTelefoneCelular.setBounds(409, 207, 127, 20);
		contentPanel.add(ftfTelefoneCelular);
		
		JLabel lblConfirmarSenha = new JLabel("* Confirmar Senha");
		lblConfirmarSenha.setBounds(565, 140, 116, 14);
		contentPanel.add(lblConfirmarSenha);
		
		pfConfirmarSenha = new JPasswordField();
		pfConfirmarSenha.setColumns(10);
		pfConfirmarSenha.setBounds(561, 158, 133, 20);
		contentPanel.add(pfConfirmarSenha);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
