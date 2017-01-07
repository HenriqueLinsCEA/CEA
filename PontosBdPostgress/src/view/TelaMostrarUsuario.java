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
import javax.swing.border.TitledBorder;

import controller.Cliente;
import controller.Usuario;

public class TelaMostrarUsuario extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfNome;
	private JTextField tfLogin;
	private JPasswordField pfSenha;
	private JPasswordField pfConfirmarSenha;
	private JButton btnSalvar;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			TelaMostrarUsuario dialog = new TelaMostrarUsuario();
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
	public TelaMostrarUsuario() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				TelaMostrarUsuario.class.getResource("/imagens/dinheiro.gif")));
		setTitle("Pontos");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblUsuarioLogado = new JLabel((String) null);
		lblUsuarioLogado.setForeground(Color.ORANGE);
		lblUsuarioLogado.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuarioLogado.setBounds(251, 21, 222, 28);
		lblUsuarioLogado.setText(TelaPrincipal.logado.getNome());
		contentPanel.add(lblUsuarioLogado);
		
		final JFormattedTextField ftfCpf = new JFormattedTextField(
				Usuario.Mascara(""));
		ftfCpf.setBackground(Color.WHITE);
		ftfCpf.setDisabledTextColor(Color.WHITE);
		ftfCpf.setEditable(false);
		ftfCpf.setBounds(92, 54, 169, 25);
		ftfCpf.setForeground(Color.BLACK);
		ftfCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ftfCpf.setText(TelaPrincipal.usuarioLocalizado.getCpf());
		
		final JRadioButton rbAdministrador = new JRadioButton("Administrador");
		rbAdministrador.setEnabled(false);
		buttonGroup.add(rbAdministrador);
		rbAdministrador.setBounds(267, 57, 91, 23);
		rbAdministrador.setActionCommand("Administrador");
		
								
		final JRadioButton rdOperador = new JRadioButton("Operador");
		rdOperador.setEnabled(false);
		buttonGroup.add(rdOperador);
		rdOperador.setBounds(360, 57, 72, 23);
		rdOperador.setActionCommand("Operador");
	
		
		
		if (TelaPrincipal.usuarioLocalizado.getTipo().equals("Administrador")){
			
			rbAdministrador.setSelected(true);
			rdOperador.setSelected(false);
			
		}else{
			
			rbAdministrador.setSelected(false);
			rdOperador.setSelected(true);
		}

		
		
		JLabel label_2 = new JLabel("Usu\u00E1rio Logado: ");
		label_2.setForeground(Color.ORANGE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(107, 21, 137, 28);
		contentPanel.add(label_2);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(62, 117, 477, 189);
			contentPanel.add(panel);
			JLabel label = new JLabel("CPF");
			label.setBounds(34, 55, 53, 23);
			label.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			panel.add(ftfCpf);

			panel.add(rbAdministrador);
			
			panel.add(rdOperador);
			
			
			JLabel lblNomeCompleto = new JLabel("Nome");
			lblNomeCompleto.setBounds(34, 25, 53, 23);
			lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tfNome = new JTextField();
			tfNome.setBackground(Color.WHITE);
			tfNome.setDisabledTextColor(Color.WHITE);
			tfNome.setEditable(false);
			tfNome.setBounds(92, 24, 339, 25);
			tfNome.setForeground(Color.BLACK);
			tfNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tfNome.setColumns(10);
			tfNome.setText(TelaPrincipal.usuarioLocalizado.getNome());

			panel.setLayout(null);
			panel.add(lblNomeCompleto);
			panel.add(label);

			panel.add(tfNome);

			JLabel lblLogin = new JLabel("Login");
			lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblLogin.setBounds(34, 85, 53, 23);
			panel.add(lblLogin);

			tfLogin = new JTextField();
			tfLogin.setBackground(Color.WHITE);
			tfLogin.setDisabledTextColor(Color.WHITE);
			tfLogin.setEditable(false);
			tfLogin.setForeground(Color.BLACK);
			tfLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tfLogin.setColumns(10);
			tfLogin.setBounds(92, 84, 339, 25);
			tfLogin.setText(TelaPrincipal.usuarioLocalizado.getLogin());

			panel.add(tfLogin);
			
			JLabel lblSenha = new JLabel("Senha");
			lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblSenha.setBounds(34, 115, 53, 23);
			panel.add(lblSenha);
			
			pfSenha = new JPasswordField();
			pfSenha.setBackground(Color.WHITE);
			pfSenha.setDisabledTextColor(Color.WHITE);
			pfSenha.setEditable(false);
			pfSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
			pfSenha.setBounds(92, 115, 339, 23);
			pfSenha.setText(TelaPrincipal.usuarioLocalizado.getSenha());
			panel.add(pfSenha);
			
			pfConfirmarSenha = new JPasswordField();
			pfConfirmarSenha.setBackground(Color.WHITE);
			pfConfirmarSenha.setDisabledTextColor(Color.WHITE);
			pfConfirmarSenha.setEditable(false);
			pfConfirmarSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
			pfConfirmarSenha.setBounds(144, 145, 287, 23);
			pfConfirmarSenha.setText(TelaPrincipal.usuarioLocalizado.getSenha());
			panel.add(pfConfirmarSenha);
			
			JLabel lblConfirmarSenha = new JLabel("Confirmar Senha");
			lblConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblConfirmarSenha.setBounds(34, 145, 104, 23);
			panel.add(lblConfirmarSenha);
			
			
			
			final JButton btnEditar = new JButton("Editar");
			btnEditar.setRolloverIcon(new ImageIcon(TelaMostrarUsuario.class.getResource("/imagens/botao_fundo_2.jpg")));
			btnEditar.setIcon(new ImageIcon(TelaMostrarUsuario.class.getResource("/imagens/botao_fundo_1.jpg")));
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					btnEditar.setEnabled(false);
					
					tfNome.setEditable(true);
					rbAdministrador.setEnabled(true);
					rdOperador.setEnabled(true);
					ftfCpf.setEditable(true);
					tfLogin.setEditable(true);
					pfSenha.setEditable(true);
					pfConfirmarSenha.setEditable(true);
					
					btnSalvar.setEnabled(true);
					
					
					
				}
			});
			
			btnSalvar = new JButton("Salvar");
			btnSalvar.setBorder(new BevelBorder(BevelBorder.RAISED, null,
					null, null, null));
			btnSalvar.setEnabled(false);
			btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (tfNome.getText().equalsIgnoreCase("")
							|| ftfCpf.getText().equalsIgnoreCase("")
							|| tfLogin.getText().equals("")) {

						JOptionPane.showMessageDialog(null,
								"Digite em  todos os campos");

					} else if (TelaPrincipal.logado.getLogin().equals("adm")
							&& TelaPrincipal.usuarioLocalizado.getLogin().equals(
									"adm")
							|| TelaPrincipal.logado.getNome().equals(
									"ADMINISTRADOR")
							&& TelaPrincipal.usuarioLocalizado.getLogin().equals(
									"ADMINISTRADOR")) {

						JOptionPane.showMessageDialog(null,
								"Impossível modificar o usuário atual");

						
					} else {
						
						
						boolean valida = controller.ValidarCpf.isCPF(Cliente.removerMascara(ftfCpf.getText()));
						
						if (valida == false){
							
							JOptionPane.showMessageDialog(null, "CPF inválido");
							
							ftfCpf.setText("");
							ftfCpf.requestFocus();
							
						}else{

						TelaPrincipal.usuarioLocalizado.setNome(tfNome.getText()
								.toUpperCase());
						TelaPrincipal.usuarioLocalizado.setTipo(buttonGroup.getSelection().getActionCommand());
						TelaPrincipal.usuarioLocalizado.setCpf(Usuario
								.removerMascara(ftfCpf.getText()));
						TelaPrincipal.usuarioLocalizado.setLogin(tfLogin
								.getText());

						new model.UsuarioDao()
								.alterarDadosUsuario(TelaPrincipal.usuarioLocalizado);

						btnSalvar.setEnabled(false);
						btnEditar.setEnabled(true);		
						
						new Thread(new Runnable() {						
							@Override
							public void run() {
								
								Usuario usuario = Usuario.localizarUsuarioPeloCpf((TelaPrincipal.usuarioLocalizado.getCpf()));
								
								tfNome.setText(usuario.getNome());
								rbAdministrador.setActionCommand(usuario.getTipo());
								rdOperador.setActionCommand(usuario.getTipo());
								ftfCpf.setText(usuario.getCpf());
								tfLogin.setText(usuario.getLogin());
								pfSenha.setText(usuario.getSenha());
								pfConfirmarSenha.setText(usuario.getSenha());
								
								
								tfNome.setEditable(false);
								rbAdministrador.setEnabled(false);
								rdOperador.setEnabled(false);
								ftfCpf.setEditable(false);
								tfLogin.setEditable(false);
								pfSenha.setEditable(false);
								pfConfirmarSenha.setEditable(false);
								
								
								
							}
						}).start();
						
						}
						
										

					}
				}
			});
			
			
			btnSalvar.setRolloverIcon(new ImageIcon(TelaMostrarUsuario.class
					.getResource("/imagens/fundo_2.jpg")));
			btnSalvar.setIcon(new ImageIcon(TelaMostrarUsuario.class
					.getResource("/imagens/fundo_1.jpg")));
			btnSalvar.setBounds(62, 312, 68, 28);
			contentPanel.add(btnSalvar);
			btnSalvar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnSalvar.setForeground(Color.WHITE);
			btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 13));
			getRootPane().setDefaultButton(btnSalvar);
			
			
			btnEditar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnEditar.setForeground(Color.WHITE);
			btnEditar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnEditar.setBorder(new BevelBorder(BevelBorder.RAISED, null,

								null, null, null));
			btnEditar.setBounds(140, 312, 68, 28);
			contentPanel.add(btnEditar);
		}

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		btnCancelar.setIcon(new ImageIcon(TelaMostrarUsuario.class
				.getResource("/imagens/fundo_1.jpg")));
		btnCancelar.setRolloverIcon(new ImageIcon(TelaMostrarUsuario.class
				.getResource("/imagens/fundo_2.jpg")));
		btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(424, 312, 115, 28);
		contentPanel.add(btnCancelar);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaMostrarUsuario.class.getResource("/imagens/dinheiro2.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(507, 0, 87, 69);
		contentPanel.add(label_1);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaMostrarUsuario.class
				.getResource("/imagens/fundo_1.jpg")));
		label.setBounds(0, -1, 600, 69);
		contentPanel.add(label);
		
		JLabel lblModificarDadosDo = new JLabel("Dados do Usu\u00E1rio");
		lblModificarDadosDo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblModificarDadosDo.setBounds(62, 74, 299, 38);
		contentPanel.add(lblModificarDadosDo);
		
		
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(TelaMostrarUsuario.class.getResource("/imagens/botao_fundo_1.jpg")));
		btnExcluir.setRolloverIcon(new ImageIcon(TelaMostrarUsuario.class.getResource("/imagens/botao_fundo_2.jpg")));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (TelaPrincipal.logado.getLogin().equals("adm")
						&& TelaPrincipal.usuarioLocalizado.getLogin().equals(
								"adm")
						|| TelaPrincipal.logado.getNome().equals(
								"ADMINISTRADOR")
						&& TelaPrincipal.usuarioLocalizado.getLogin().equals(
								"ADMINISTRADOR")){
					
					JOptionPane.showMessageDialog(null, "Impossível excluir o usuário atual");
					
					dispose();
					
				} else {
				
				
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o Usuário?");
				
				if (resposta == 0) {
					
										
					Usuario.excluirUsuarios();
					
					dispose();
					
										
				} else if (resposta == 1){
					
					JOptionPane.showMessageDialog(null, "Não desejo excluir o usuário");
					
					dispose();
					
				}
				
				}
			
			}
		});
		btnExcluir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExcluir.setBorder(new BevelBorder(BevelBorder.RAISED, null,
									null, null, null));
		btnExcluir.setBounds(218, 312, 68, 28);
		contentPanel.add(btnExcluir);
		
		
	}
}
