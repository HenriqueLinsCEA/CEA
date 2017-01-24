package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
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

import controller.cliente.Cliente;
import controller.cliente.ClienteDAO;
import controller.cliente.ClienteRN;
import controller.contato.Contato;
import controller.contato.ContatoRN;
import controller.endereco.Endereco;
import controller.endereco.EnderecoRN;
import com.jgoodies.animation.AnimationUtils;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class JdTelaCadastroCliente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2801762787270085397L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfRazaoSocial;
	private JTextField tfNomeFantasia;
	private JTextField tfCnpj;
	private JTextField tfNomeContato;
	private JTextField tfInscricaoEstadual;
	private JTextField tfEmailContato;
	private JTextField tfLogradouro;
	private JTextField tfNumero;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField tfCep;
	private JTextField tfVendedor;
	private JFormattedTextField ftfTelefoneFixo;
	private JComboBox cbUF;
	private JComboBox cbStatus;
	private JDateChooser JdcClienteDesde;
	private JFormattedTextField ftfTelefoneCelular;
	private Date data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {

			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			JdTelaCadastroCliente dialog = new JdTelaCadastroCliente();
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
	public JdTelaCadastroCliente() {
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JdTelaCadastroCliente.class.getResource("/image/ne.png")));
		setTitle("Cadastro de Clientes");
		setBounds(100, 100, 1000, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel label = new JLabel("Card1");
		label.setBounds(118, 16, 0, 0);

		JLabel lblRazãoSocial = new JLabel("* Raz\u00E3o Social");
		lblRazãoSocial.setBounds(88, 92, 97, 14);

		tfRazaoSocial = new JTextField();
		tfRazaoSocial.setBounds(88, 109, 331, 20);
		tfRazaoSocial.setColumns(10);

		JLabel lblNomeFantasia = new JLabel("* Nome Fantasia");
		lblNomeFantasia.setBounds(88, 133, 97, 14);

		tfNomeFantasia = new JTextField();
		tfNomeFantasia.setBounds(88, 151, 331, 20);
		tfNomeFantasia.setColumns(10);

		JLabel lblCnpj = new JLabel("* CNPJ");
		lblCnpj.setBounds(443, 92, 97, 14);

		tfCnpj = new JFormattedTextField(ClienteRN.CNPJ(""));
		tfCnpj.setBounds(443, 109, 138, 20);
		tfCnpj.setColumns(10);

		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Clientes");
		lblCadastroDeClientes.setBounds(88, 51, 169, 14);
		lblCadastroDeClientes.setForeground(Color.BLACK);
		lblCadastroDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JSeparator separator = new JSeparator();
		separator.setBounds(88, 76, 606, 9);

		JLabel lblContato = new JLabel("* Contato");
		lblContato.setBounds(88, 177, 97, 14);

		tfNomeContato = new JTextField();
		tfNomeContato.setBounds(88, 195, 331, 20);
		tfNomeContato.setColumns(10);

		JLabel lblInscrioEstadual = new JLabel("* Inscri\u00E7\u00E3o Estadual");
		lblInscrioEstadual.setBounds(552, 133, 97, 14);

		tfInscricaoEstadual = new JTextField();
		tfInscricaoEstadual.setBounds(552, 151, 142, 20);
		tfInscricaoEstadual.setColumns(10);

		JLabel lblEmail = new JLabel("* E-mail");
		lblEmail.setBounds(88, 226, 97, 14);

		tfEmailContato = new JTextField();
		tfEmailContato.setBounds(88, 244, 276, 20);
		tfEmailContato.setColumns(10);

		JLabel lblTelefoneCelular = new JLabel("Telefone Celular");
		lblTelefoneCelular.setBounds(552, 226, 97, 14);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(88, 273, 169, 14);
		lblEndereco.setForeground(Color.BLACK);
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(88, 295, 606, 9);

		JLabel lblLogradouro = new JLabel("* Logradouro");
		lblLogradouro.setBounds(88, 304, 97, 14);

		tfLogradouro = new JTextField();
		tfLogradouro.setBounds(88, 322, 478, 20);
		tfLogradouro.setColumns(10);

		JLabel lblNumero = new JLabel("* N\u00FAmero");
		lblNumero.setBounds(584, 304, 97, 14);

		tfNumero = new JTextField();
		tfNumero.setBounds(584, 322, 110, 20);
		tfNumero.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(88, 353, 97, 14);

		JTextField tfComplemento = new JTextField();
		tfComplemento.setBounds(88, 371, 372, 20);
		tfComplemento.setColumns(10);

		JLabel lblBairro = new JLabel("* Bairro");
		lblBairro.setBounds(484, 353, 97, 14);

		tfBairro = new JTextField();
		tfBairro.setBounds(484, 371, 210, 20);
		tfBairro.setColumns(10);

		JLabel lblCidade = new JLabel("* Cidade");
		lblCidade.setBounds(88, 403, 97, 14);

		tfCidade = new JTextField();
		tfCidade.setBounds(88, 421, 397, 20);
		tfCidade.setColumns(10);

		JLabel lblCep = new JLabel("* CEP");
		lblCep.setBounds(584, 402, 97, 14);

		tfCep = new JFormattedTextField(ClienteRN.CEP(""));
		tfCep.setBounds(584, 421, 110, 20);
		tfCep.setHorizontalAlignment(SwingConstants.LEFT);
		tfCep.setColumns(10);

		cbUF = new JComboBox();
		cbUF.setModel(new DefaultComboBoxModel(new String[] {" ", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cbUF.setBounds(503, 421, 63, 20);

		JLabel label_16 = new JLabel("* Campo Obrigat\u00F3rio.");
		label_16.setBounds(88, 466, 210, 14);

		JLabel lblVendedor = new JLabel("Vendedor");
		lblVendedor.setBounds(443, 177, 97, 14);

		tfVendedor = new JTextField();
		tfVendedor.setBounds(443, 195, 251, 20);
		tfVendedor.setColumns(10);
		contentPanel.setLayout(null);
		contentPanel.add(label);
		contentPanel.add(lblCadastroDeClientes);
		contentPanel.add(separator);
		contentPanel.add(lblRazãoSocial);
		contentPanel.add(lblCnpj);
		contentPanel.add(tfRazaoSocial);
		contentPanel.add(tfCnpj);
		contentPanel.add(lblNomeFantasia);
		contentPanel.add(lblInscrioEstadual);
		contentPanel.add(tfNomeFantasia);
		contentPanel.add(tfInscricaoEstadual);
		contentPanel.add(lblEmail);
		contentPanel.add(lblTelefoneCelular);
		contentPanel.add(tfEmailContato);
		contentPanel.add(lblEndereco);
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
		contentPanel.add(cbUF);
		contentPanel.add(tfCep);
		contentPanel.add(label_16);
		contentPanel.add(lblContato);
		contentPanel.add(tfNomeContato);
		contentPanel.add(lblVendedor);
		contentPanel.add(tfVendedor);

		ftfTelefoneFixo = new JFormattedTextField(ClienteRN.TelefoneFixo(""));
		ftfTelefoneFixo.setColumns(10);
		ftfTelefoneFixo.setBounds(388, 244, 142, 20);
		contentPanel.add(ftfTelefoneFixo);

		JLabel lblTelefoneFixo = new JLabel("Telefone Fixo");
		lblTelefoneFixo.setBounds(388, 226, 97, 14);
		contentPanel.add(lblTelefoneFixo);

		JLabel lblUF = new JLabel("* UF");
		lblUF.setBounds(503, 403, 52, 14);
		contentPanel.add(lblUF);

		JLabel lblClienteDesde = new JLabel("* ClienteDesde");
		lblClienteDesde.setBounds(603, 92, 91, 14);
		contentPanel.add(lblClienteDesde);

		JLabel lblStatusCliente = new JLabel("* Status");
		lblStatusCliente.setBounds(443, 133, 91, 14);
		contentPanel.add(lblStatusCliente);

		cbStatus = new JComboBox();
		cbStatus.setModel(new DefaultComboBoxModel(new String[] { "", "Ativo", "Inativo" }));
		cbStatus.setBounds(443, 151, 87, 20);
		contentPanel.add(cbStatus);

		JdcClienteDesde = new JDateChooser("dd/MM/yyyy", "##/##/#####", '_');
		JdcClienteDesde.setBounds(603, 109, 91, 20);

		contentPanel.add(JdcClienteDesde);

		ftfTelefoneCelular = new JFormattedTextField(ClienteRN.TelefoneCelular(""));
		ftfTelefoneCelular.setColumns(10);
		ftfTelefoneCelular.setBounds(552, 244, 142, 20);
		contentPanel.add(ftfTelefoneCelular);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						String emailValido = tfEmailContato.getText().toLowerCase();

						if (tfRazaoSocial.getText().isEmpty()) {

							JOptionPane.showMessageDialog(null, "Digite a Razão Social da Empresa");

							tfRazaoSocial.requestFocus();

						} else if (tfCnpj.getText().isEmpty()) {

							JOptionPane.showMessageDialog(null, "Digite o CNPJ da Empresa");

							tfCnpj.requestFocus();
							
							
						} else if (JdcClienteDesde.getDate() == null) {

							JOptionPane.showMessageDialog(null, "Digite a data de cadastro da Empresa");

							JdcClienteDesde.requestFocus();


						} else if (tfNomeFantasia.getText().isEmpty()) {

							JOptionPane.showMessageDialog(null, "Digite o Nome Fantasia da Empresa");

							tfNomeFantasia.requestFocus();

						} else if (cbStatus.getSelectedItem().equals("")) {

							JOptionPane.showMessageDialog(null, "Selecione o status ativo ou inativo da Empresa");

							cbStatus.requestFocus();

						} else if (tfInscricaoEstadual.getText().isEmpty()) {

							JOptionPane.showMessageDialog(null, "Digite a Inscrição Estadual da Empresa");

							tfInscricaoEstadual.requestFocus();

						} else if (tfNomeContato.getText().isEmpty()) {

							JOptionPane.showMessageDialog(null, "Digite o nome do contato da Empresa");

							tfNomeContato.requestFocus();

						} else if (tfVendedor.getText().isEmpty()) {

							JOptionPane.showMessageDialog(null, "Digite o nome vendedor que atende a Empresa");

							tfVendedor.requestFocus();

						} else if (tfEmailContato.getText().isEmpty()) {

							JOptionPane.showMessageDialog(null, "Digite o email da Empresa");

							tfEmailContato.requestFocus();

						}  else if (!Pattern
								.matches(
										"\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b",
										emailValido)) {

							JOptionPane.showMessageDialog(null, "E-mail invalido");

							tfEmailContato.setText("");
							tfEmailContato.requestFocus();

						} else if (ftfTelefoneFixo.getText().isEmpty() || ftfTelefoneCelular.getText().isEmpty()) {

							JOptionPane.showMessageDialog(null, "Digite um telefone para a empresa da Empresa");

							ftfTelefoneCelular.requestFocus();

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

						} else if (tfCep.getText().isEmpty()) {

							JOptionPane.showMessageDialog(null, "Digite o CEP");

							tfCep.requestFocus();

						} else {

							java.util.Date dataUtil = JdcClienteDesde.getDate();
							java.sql.Date DataSql = new java.sql.Date(dataUtil.getTime());

							Endereco endereco = new Endereco(tfLogradouro.getText().toUpperCase(), tfNumero.getText(),
									tfComplemento.getText().toUpperCase(), tfBairro.getText().toUpperCase(),
									tfCidade.getText().toUpperCase(), String.valueOf(cbUF.getSelectedItem()),
									tfCep.getText());

							Contato contato = new Contato(tfNomeContato.getText().toUpperCase(),
									tfEmailContato.getText().toLowerCase(), ftfTelefoneFixo.getText(),
									ftfTelefoneCelular.getText());

							Cliente cliente = new Cliente(tfNomeFantasia.getText().toUpperCase(),
									tfRazaoSocial.getText().toUpperCase(), tfCnpj.getText(),
									tfInscricaoEstadual.getText(), DataSql, String.valueOf(cbStatus.getSelectedItem()));

							cliente.setContato(contato);
							cliente.setEndereco(endereco);

							ClienteRN clienteRN = new ClienteRN();
							clienteRN.CadastrarCliente(cliente);

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
