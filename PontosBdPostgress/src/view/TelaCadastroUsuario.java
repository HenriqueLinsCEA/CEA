package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import model.UsuarioDao;
import controller.Cliente;
import controller.Usuario;

public class TelaCadastroUsuario extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfNome;
	private JTextField tfLogin;
	private JPasswordField pfSenha;
	private JPasswordField pfConfirmarSenha;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			TelaCadastroUsuario dialog = new TelaCadastroUsuario();
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
	public TelaCadastroUsuario() {
		setUndecorated(true);
		setResizable(false);
		setModal(true);
		setTitle("Pontos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				TelaCadastroUsuario.class.getResource("/imagens/dinheiro.gif")));
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		final JFormattedTextField ftfCpf = new JFormattedTextField(
				Cliente.Mascara(""));
		ftfCpf.setBounds(88, 59, 125, 25);
		ftfCpf.setForeground(Color.BLACK);
		ftfCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));

		{
			JPanel panel = new JPanel();
			panel.setBounds(58, 111, 479, 206);
			contentPanel.add(panel);
			JLabel label = new JLabel("CPF");
			label.setBounds(30, 60, 53, 23);
			label.setFont(new Font("Tahoma", Font.PLAIN, 12));


			JLabel lblNomeCompleto = new JLabel("Nome");
			lblNomeCompleto.setBounds(30, 26, 53, 23);
			lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tfNome = new JTextField();
			tfNome.setBounds(88, 25, 352, 25);
			tfNome.setForeground(Color.BLACK);
			tfNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tfNome.setColumns(10);
			panel.setLayout(null);
			panel.add(lblNomeCompleto);
			panel.add(label);
			panel.add(ftfCpf);
			panel.add(tfNome);

			JLabel lblLogin = new JLabel("Login");
			lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblLogin.setBounds(30, 93, 53, 23);
			panel.add(lblLogin);

			tfLogin = new JTextField();
			tfLogin.setForeground(Color.BLACK);
			tfLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tfLogin.setColumns(10);
			tfLogin.setBounds(88, 92, 351, 25);
			panel.add(tfLogin);

			JLabel lblSenha = new JLabel("Senha");
			lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblSenha.setBounds(29, 128, 53, 23);
			panel.add(lblSenha);
			
			pfSenha = new JPasswordField();
			pfSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
			pfSenha.setBounds(139, 128, 300, 23);
			panel.add(pfSenha);
			
			JLabel lblConfirmarSenha = new JLabel("Confirmar Senha");
			lblConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblConfirmarSenha.setBounds(30, 162, 104, 23);
			panel.add(lblConfirmarSenha);
			
			pfConfirmarSenha = new JPasswordField();
			pfConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
			pfConfirmarSenha.setBounds(139, 162, 300, 23);
			panel.add(pfConfirmarSenha);
			
			JRadioButton rdbtnAdministrador = new JRadioButton("Administrador");
			rdbtnAdministrador.setActionCommand("Administrador");
			buttonGroup.add(rdbtnAdministrador);
			rdbtnAdministrador.setBounds(229, 61, 91, 23);
			panel.add(rdbtnAdministrador);
			
			JRadioButton rdbtnOperador = new JRadioButton("Operador");
			rdbtnOperador.setActionCommand("Operador");
			buttonGroup.add(rdbtnOperador);
			rdbtnOperador.setBounds(349, 61, 91, 23);
			panel.add(rdbtnOperador);
			

			
			
		}
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean valido = controller.ValidarCpf.isCPF(Cliente
						.removerMascara(ftfCpf.getText()));
				
				String senha = String.valueOf(pfSenha.getPassword());
				String confirmacaoSenha = String.valueOf(pfConfirmarSenha.getPassword());
				
				if (tfNome.getText().equalsIgnoreCase("")
						|| buttonGroup.isSelected(null)
						|| ftfCpf.getText().equalsIgnoreCase("")
						|| tfLogin.getText().equals("")
						|| pfSenha.getPassword().equals("")
						|| pfConfirmarSenha.getPassword().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite em  todos os campos");

				} else if (!senha.equalsIgnoreCase(confirmacaoSenha)){
					
					JOptionPane.showMessageDialog(null,
							"A confirmação da senha não está igual a senha");
						
					pfSenha.setText("");
					pfConfirmarSenha.setText("");
				
				}else{
					
					if (valido == false) {

						JOptionPane.showMessageDialog(null, "CPF inválido");

						ftfCpf.setText("");
						ftfCpf.requestFocus();

					} else if (valido == true) {

						
					UsuarioDao usuarioDao = new UsuarioDao();
					Usuario cpfDuplicado = new Usuario();
					cpfDuplicado = usuarioDao.inserirDadosUsuario(
							new Usuario(tfNome.getText().toUpperCase(), buttonGroup.getSelection().getActionCommand(), Usuario
									.removerMascara(ftfCpf.getText()), tfLogin
									.getText(), String.valueOf(pfSenha.getPassword())));
					
					if (cpfDuplicado.getCpf() == null){
						
						ftfCpf.setText("");
						ftfCpf.requestFocus();
												
					}else{
						
					tfNome.setText("");
					ftfCpf.setText("");
					tfLogin.setText("");
					pfSenha.setText("");
					pfConfirmarSenha.setText("");
				
					
					dispose();
					}
					
					}
				}
			}
		});

		JLabel label_2 = new JLabel("Usu\u00E1rio Logado: ");
		label_2.setForeground(Color.ORANGE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(107, 21, 137, 28);
		contentPanel.add(label_2);
		

		JLabel lblUsuarioLogado = new JLabel((String) null);
		lblUsuarioLogado.setForeground(Color.ORANGE);
		lblUsuarioLogado.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuarioLogado.setBounds(251, 21, 250, 28);
		lblUsuarioLogado.setText(TelaPrincipal.logado.getNome());
		contentPanel.add(lblUsuarioLogado);
		btnConfirmar.setRolloverIcon(new ImageIcon(TelaCadastroUsuario.class
				.getResource("/imagens/fundo_2.jpg")));
		btnConfirmar.setIcon(new ImageIcon(TelaCadastroUsuario.class
				.getResource("/imagens/fundo_1.jpg")));
		btnConfirmar.setBounds(279, 328, 134, 28);
		contentPanel.add(btnConfirmar);
		btnConfirmar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 13));
		getRootPane().setDefaultButton(btnConfirmar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		btnCancelar.setIcon(new ImageIcon(TelaCadastroUsuario.class
				.getResource("/imagens/fundo_1.jpg")));
		btnCancelar.setRolloverIcon(new ImageIcon(TelaCadastroUsuario.class
				.getResource("/imagens/fundo_2.jpg")));
		btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(423, 328, 115, 28);
		contentPanel.add(btnCancelar);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaCadastroUsuario.class.getResource("/imagens/dinheiro2.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(507, 0, 87, 69);
		contentPanel.add(label_1);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaCadastroUsuario.class
				.getResource("/imagens/fundo_1.jpg")));
		label.setBounds(0, 0, 600, 69);
		contentPanel.add(label);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Usu\u00E1rios");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(58, 70, 204, 38);
		contentPanel.add(lblNewLabel);
	}
}
