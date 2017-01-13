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
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

public class JdTelaCadastroUsuario extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2801762787270085397L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

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
		setTitle("Cadastro de Clientes");
		setBounds(100, 100, 1000, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("Card1");
		label.setBounds(118, 16, 0, 0);
		
		JLabel lblNomeCompleto = new JLabel("* Nome Completo");
		lblNomeCompleto.setBounds(88, 91, 97, 14);
		
		textField = new JTextField();
		textField.setBounds(88, 109, 372, 20);
		textField.setColumns(10);
		
		JLabel lblCpf = new JLabel("* CPF");
		lblCpf.setBounds(484, 91, 97, 14);
		
		JLabel lblCadastroUsuarios = new JLabel("Cadastro Usuarios");
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
		
		JLabel label_10 = new JLabel("* Logradouro");
		label_10.setBounds(88, 293, 97, 14);
		
		textField_5 = new JTextField();
		textField_5.setBounds(88, 311, 478, 20);
		textField_5.setColumns(10);
		
		JLabel label_11 = new JLabel("* N.\u00BA");
		label_11.setBounds(584, 293, 97, 14);
		
		textField_6 = new JTextField();
		textField_6.setBounds(584, 311, 110, 20);
		textField_6.setColumns(10);
		
		JLabel label_12 = new JLabel("Complemento");
		label_12.setBounds(88, 342, 97, 14);
		
		textField_7 = new JTextField();
		textField_7.setBounds(88, 360, 372, 20);
		textField_7.setColumns(10);
		
		JLabel label_13 = new JLabel("* Bairro");
		label_13.setBounds(484, 342, 97, 14);
		
		textField_8 = new JTextField();
		textField_8.setBounds(484, 360, 210, 20);
		textField_8.setColumns(10);
		
		JLabel label_14 = new JLabel("* Cidade");
		label_14.setBounds(88, 392, 97, 14);
		
		textField_9 = new JTextField();
		textField_9.setBounds(88, 410, 372, 20);
		textField_9.setColumns(10);
		
		JLabel label_15 = new JLabel("* CEP");
		label_15.setBounds(551, 391, 97, 14);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField((AbstractFormatter) null);
		formattedTextField_2.setBounds(552, 410, 142, 20);
		formattedTextField_2.setHorizontalAlignment(SwingConstants.LEFT);
		formattedTextField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(484, 410, 52, 20);
		
		JLabel label_16 = new JLabel("* Campo Obrigat\u00F3rio.");
		label_16.setBounds(88, 466, 210, 14);
		contentPanel.setLayout(null);
		contentPanel.add(label);
		contentPanel.add(lblCadastroUsuarios);
		contentPanel.add(separator);
		contentPanel.add(lblNomeCompleto);
		contentPanel.add(lblCpf);
		contentPanel.add(textField);
		contentPanel.add(label_9);
		contentPanel.add(separator_1);
		contentPanel.add(label_10);
		contentPanel.add(label_11);
		contentPanel.add(textField_5);
		contentPanel.add(textField_6);
		contentPanel.add(label_12);
		contentPanel.add(label_13);
		contentPanel.add(textField_7);
		contentPanel.add(textField_8);
		contentPanel.add(label_14);
		contentPanel.add(label_15);
		contentPanel.add(textField_9);
		contentPanel.add(comboBox);
		contentPanel.add(formattedTextField_2);
		contentPanel.add(label_16);
		
		JRadioButton radioButton = new JRadioButton("Administrador");
		radioButton.setActionCommand("ADMINISTRADOR");
		radioButton.setBounds(439, 51, 109, 23);
		contentPanel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Operador");
		radioButton_1.setActionCommand("OPERADOR");
		radioButton_1.setBounds(585, 51, 109, 23);
		contentPanel.add(radioButton_1);
		
		JFormattedTextField formattedTextField = new JFormattedTextField((javax.swing.JFormattedTextField$AbstractFormatter) null);
		formattedTextField.setColumns(10);
		formattedTextField.setBounds(484, 109, 210, 20);
		contentPanel.add(formattedTextField);
		
		JLabel label_1 = new JLabel("* Login");
		label_1.setBounds(88, 140, 97, 14);
		contentPanel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(88, 158, 294, 20);
		contentPanel.add(textField_1);
		
		JLabel label_2 = new JLabel("* E-mail");
		label_2.setBounds(88, 189, 97, 14);
		contentPanel.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(88, 207, 294, 20);
		contentPanel.add(textField_2);
		
		JLabel label_3 = new JLabel("* Senha (6 d\u00EDgitos)");
		label_3.setBounds(409, 140, 116, 14);
		contentPanel.add(label_3);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(409, 158, 127, 20);
		contentPanel.add(passwordField);
		
		JLabel label_4 = new JLabel("Telefone Fixo");
		label_4.setBounds(409, 189, 88, 14);
		contentPanel.add(label_4);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField((javax.swing.JFormattedTextField$AbstractFormatter) null);
		formattedTextField_1.setColumns(10);
		formattedTextField_1.setBounds(409, 207, 127, 20);
		contentPanel.add(formattedTextField_1);
		
		JLabel label_5 = new JLabel("* Repetir Senha");
		label_5.setBounds(565, 140, 116, 14);
		contentPanel.add(label_5);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setColumns(10);
		passwordField_1.setBounds(561, 158, 133, 20);
		contentPanel.add(passwordField_1);
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField((javax.swing.JFormattedTextField$AbstractFormatter) null);
		formattedTextField_3.setColumns(10);
		formattedTextField_3.setBounds(561, 207, 133, 20);
		contentPanel.add(formattedTextField_3);
		
		JLabel label_6 = new JLabel("* Telefone Celular");
		label_6.setBounds(565, 189, 102, 14);
		contentPanel.add(label_6);
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
