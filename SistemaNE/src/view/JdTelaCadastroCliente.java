package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
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
import controller.cliente.ClienteRN;

public class JdTelaCadastroCliente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2801762787270085397L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfRazaoSocial;
	private JTextField tfNomeFantasia;
	private JTextField tfNomeContato;
	private JTextField tfInscricaoEstadual;
	private JTextField tfEmailContato;
	private JTextField tfLogradouro;
	private JTextField tfNumero;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField tfVendedor;

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
		lblRazãoSocial.setBounds(88, 91, 97, 14);

		tfRazaoSocial = new JTextField();
		tfRazaoSocial.setBounds(88, 109, 372, 20);
		tfRazaoSocial.setColumns(10);

		JLabel lblNomeFantasia = new JLabel("* Nome Fantasia");
		lblNomeFantasia.setBounds(88, 133, 97, 14);

		tfNomeFantasia = new JTextField();
		tfNomeFantasia.setBounds(88, 151, 276, 20);
		tfNomeFantasia.setColumns(10);

		JLabel lblCnpj = new JLabel("* CNPJ");
		lblCnpj.setBounds(484, 96, 97, 14);

		JFormattedTextField ftfCnpj = new JFormattedTextField((AbstractFormatter) null);
		ftfCnpj.setBounds(484, 109, 210, 20);
		ftfCnpj.setColumns(10);

		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Clientes");
		lblCadastroDeClientes.setBounds(88, 51, 169, 14);
		lblCadastroDeClientes.setForeground(Color.BLACK);
		lblCadastroDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JSeparator separator = new JSeparator();
		separator.setBounds(88, 76, 606, 9);

		JLabel lblContato = new JLabel("* Contato");
		lblContato.setBounds(87, 177, 97, 14);

		tfNomeContato = new JTextField();
		tfNomeContato.setBounds(87, 195, 276, 20);
		tfNomeContato.setColumns(10);

		JLabel lblInscrioEstadual = new JLabel("* Inscri\u00E7\u00E3o Estadual");
		lblInscrioEstadual.setBounds(388, 133, 97, 14);

		tfInscricaoEstadual = new JTextField();
		tfInscricaoEstadual.setBounds(388, 151, 142, 20);
		tfInscricaoEstadual.setColumns(10);

		JLabel lblEmail = new JLabel("* E-mail");
		lblEmail.setBounds(88, 217, 97, 14);

		tfEmailContato = new JTextField();
		tfEmailContato.setBounds(88, 235, 276, 20);
		tfEmailContato.setColumns(10);

		JLabel lblTelefone01 = new JLabel("Telefone 02");
		lblTelefone01.setBounds(552, 217, 97, 14);

		JFormattedTextField ftfTelefone02Contato = new JFormattedTextField((AbstractFormatter) null);
		ftfTelefone02Contato.setBounds(552, 235, 142, 20);
		ftfTelefone02Contato.setColumns(10);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(88, 260, 169, 14);
		lblEndereco.setForeground(Color.BLACK);
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 11));

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

		JTextField tfComplemento = new JTextField();
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

		JFormattedTextField ftfCep = new JFormattedTextField((AbstractFormatter) null);
		ftfCep.setBounds(552, 410, 142, 20);
		ftfCep.setHorizontalAlignment(SwingConstants.LEFT);
		ftfCep.setColumns(10);

		JComboBox cbUF = new JComboBox();
		cbUF.setModel(new DefaultComboBoxModel(
				new String[] { " ", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cbUF.setBounds(484, 410, 52, 20);

		JLabel label_16 = new JLabel("* Campo Obrigat\u00F3rio.");
		label_16.setBounds(88, 466, 210, 14);

		JLabel lblVendedor = new JLabel("Vendedor");
		lblVendedor.setBounds(484, 177, 97, 14);

		tfVendedor = new JTextField();
		tfVendedor.setBounds(484, 195, 210, 20);
		tfVendedor.setColumns(10);
		contentPanel.setLayout(null);
		contentPanel.add(label);
		contentPanel.add(lblCadastroDeClientes);
		contentPanel.add(separator);
		contentPanel.add(lblRazãoSocial);
		contentPanel.add(lblCnpj);
		contentPanel.add(tfRazaoSocial);
		contentPanel.add(ftfCnpj);
		contentPanel.add(lblNomeFantasia);
		contentPanel.add(lblInscrioEstadual);
		contentPanel.add(tfNomeFantasia);
		contentPanel.add(tfInscricaoEstadual);
		contentPanel.add(lblEmail);
		contentPanel.add(lblTelefone01);
		contentPanel.add(tfEmailContato);
		contentPanel.add(ftfTelefone02Contato);
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
		contentPanel.add(ftfCep);
		contentPanel.add(label_16);
		contentPanel.add(lblContato);
		contentPanel.add(tfNomeContato);
		contentPanel.add(lblVendedor);
		contentPanel.add(tfVendedor);

		JFormattedTextField ftfTelefone01Contato = new JFormattedTextField((AbstractFormatter) null);
		ftfTelefone01Contato.setColumns(10);
		ftfTelefone01Contato.setBounds(388, 235, 142, 20);
		contentPanel.add(ftfTelefone01Contato);

		JLabel lblTelefone = new JLabel("* Telefone 01");
		lblTelefone.setBounds(388, 217, 97, 14);
		contentPanel.add(lblTelefone);

		JLabel lblUF = new JLabel("* UF");
		lblUF.setBounds(484, 391, 52, 14);
		contentPanel.add(lblUF);

		JLabel lblClienteDesde = new JLabel("* ClienteDesde");
		lblClienteDesde.setBounds(554, 133, 97, 14);
		contentPanel.add(lblClienteDesde);

		JFormattedTextField ftfClienteDesde = new JFormattedTextField((AbstractFormatter) null);
		ftfClienteDesde.setColumns(10);
		ftfClienteDesde.setBounds(554, 151, 142, 20);
		contentPanel.add(ftfClienteDesde);

		JLabel lblStatusCliente = new JLabel("* Status");
		lblStatusCliente.setBounds(388, 176, 91, 14);
		contentPanel.add(lblStatusCliente);

		JComboBox cbStatus = new JComboBox();
		cbStatus.setModel(new DefaultComboBoxModel(new String[] { "", "Ativo", "Inativo" }));
		cbStatus.setBounds(388, 195, 52, 20);
		contentPanel.add(cbStatus);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
							
						ClienteRN clienteRN = new ClienteRN();
						clienteRN.CadastrarCliente(new Cliente());
							
						
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
