package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import controller.ControleMetodosUsuario;
import controller.Usuario;

import java.util.List;
import java.awt.Color;

import javax.swing.SwingConstants;

public class JdCadastroUsuario extends JDialog {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	static JTextField tfNumero;
	static JTextField tfLogin;
	static JPasswordField pfSenhaAtual;
	static JPasswordField pfNovaSenha;
	static JPasswordField pfRepetirSenha;
	static JTextField tfNome;
	static List<Usuario> listaUsuario;
	private int posicao = 0;
	private String botao;
	static JComboBox<String> cbNome = new JComboBox<String>();
	static int numeroUsuario = 1;
	JButton btnEditar = new JButton("");
	JButton btnExcluir = new JButton("");
	JButton btnRegistroPosterior = new JButton("");
	JButton btnNovo = new JButton("");
	JButton okButton = new JButton("Salvar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JdCadastroUsuario dialog = new JdCadastroUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * 
	 * 
	 */

	public JdCadastroUsuario() {
		setBackground(Color.LIGHT_GRAY);
		setModal(true);
		setResizable(false);
		setTitle("Cadastro Usu\u00E1rio");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				JdCadastroUsuario.class
						.getResource("/images/techvan_transparente.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		okButton.setVisible(false);
		
		listaUsuario = new ControleMetodosUsuario().listarUsuario();

		tfNumero = new JTextField();
		tfNumero.setEditable(false);
		tfNumero.setBounds(37, 104, 61, 20);
		contentPanel.add(tfNumero);
		tfNumero.setText(String.valueOf(1));

		tfNumero.setColumns(10);
		tfLogin = new JTextField();
		tfLogin.setEditable(false);
		tfLogin.setColumns(10);
		tfLogin.setBounds(36, 155, 255, 20);
		contentPanel.add(tfLogin);
		tfLogin.setText(String.valueOf(listaUsuario.get(posicao).getLogin()));

		pfSenhaAtual = new JPasswordField();
		pfSenhaAtual.setEditable(false);
		pfSenhaAtual.setBounds(36, 203, 102, 20);
		contentPanel.add(pfSenhaAtual);
		pfSenhaAtual.setText(String.valueOf(listaUsuario.get(posicao)
				.getSenha()));

		pfNovaSenha = new JPasswordField();
		pfNovaSenha.setEditable(false);
		pfNovaSenha.setBounds(167, 203, 102, 20);
		contentPanel.add(pfNovaSenha);

		for (Usuario user : listaUsuario) {

			cbNome.addItem(user.getNome());

		}

		cbNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				listaUsuario = new ControleMetodosUsuario().listarUsuario();

				posicao = cbNome.getSelectedIndex();

				if (posicao == -1) {

					posicao = 0;

				}

				tfNumero.setText(String.valueOf(posicao + 1));
				tfLogin.setText(String.valueOf(listaUsuario.get(posicao)
						.getLogin()));
				pfSenhaAtual.setText(listaUsuario.get(posicao).getSenha());

			}
		});

		cbNome.setBounds(108, 104, 291, 20);
		contentPanel.add(cbNome);

		JCheckBox chckbxBloqueado = new JCheckBox("Bloqueado");
		chckbxBloqueado.setEnabled(false);
		chckbxBloqueado.setBounds(324, 154, 75, 23);
		contentPanel.add(chckbxBloqueado);

		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setBounds(37, 86, 46, 14);
		contentPanel.add(lblNumero);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(108, 86, 136, 14);
		contentPanel.add(lblNome);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(37, 135, 136, 14);
		contentPanel.add(lblLogin);

		JLabel lblSenhaAtual = new JLabel("Senha Atual");
		lblSenhaAtual.setBounds(37, 186, 69, 14);
		contentPanel.add(lblSenhaAtual);

		JLabel lblNovaSenha = new JLabel("Senha");
		lblNovaSenha.setBounds(167, 186, 69, 14);
		contentPanel.add(lblNovaSenha);
		
		btnNovo.setFocusable(false);
		btnNovo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNovo.setRolloverIcon(new ImageIcon(JdCadastroUsuario.class
				.getResource("/images/adicionar_usuario_2.png")));
		btnNovo.setContentAreaFilled(false);
		btnNovo.setBorderPainted(false);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				okButton.setVisible(true);
				
				botao = "salvar";

				btnNovo.setEnabled(false);
				btnEditar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnRegistroPosterior.setEnabled(false);

				tfNumero.setText(String.valueOf(listaUsuario.size() + 1));
				cbNome.setVisible(false);
				tfNome.setVisible(true);
				tfNome.setText("");
				tfLogin.setText("");
				tfLogin.setEditable(true);

				chckbxBloqueado.setEnabled(true);

				pfSenhaAtual.setText("");
				pfNovaSenha.setEditable(true);
				pfRepetirSenha.setEditable(true);

			}

		});
		btnNovo.setIcon(new ImageIcon(JdCadastroUsuario.class
				.getResource("/images/adicionar_usuario.png")));
		btnNovo.setToolTipText("Novo");
		btnNovo.setBounds(25, 11, 75, 68);
		contentPanel.add(btnNovo);

		btnEditar.setBorderPainted(false);
		btnEditar.setFocusable(false);
		btnEditar.setContentAreaFilled(false);
		btnEditar.setRolloverIcon(new ImageIcon(JdCadastroUsuario.class
				.getResource("/images/editar_usuario_2.png")));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				okButton.setVisible(true);
				
				botao = "editar";

				btnNovo.setEnabled(false);
				btnEditar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnRegistroPosterior.setEnabled(false);

				tfNome.setText(String.valueOf(listaUsuario.get(posicao)
						.getId_usuario()));
				cbNome.setVisible(false);
				tfNome.setVisible(true);
				tfNome.setText(listaUsuario.get(posicao).getNome());
				tfNome.setEditable(true);
				tfLogin.setText(listaUsuario.get(posicao).getLogin());
				tfLogin.setEditable(true);
				pfSenhaAtual.setText(listaUsuario.get(posicao).getSenha());
				pfNovaSenha.setEditable(true);
				pfRepetirSenha.setEditable(true);

			}
		});
		btnEditar.setIcon(new ImageIcon(JdCadastroUsuario.class
				.getResource("/images/editar_usuario.png")));
		btnEditar.setToolTipText("Editar");
		btnEditar.setBounds(125, 11, 84, 68);
		contentPanel.add(btnEditar);

		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setRolloverIcon(new ImageIcon(JdCadastroUsuario.class
				.getResource("/images/excluir_usuario_2.png")));
		btnExcluir.setIcon(new ImageIcon(JdCadastroUsuario.class
				.getResource("/images/excluir_usuario.png")));
		btnExcluir.setBorderPainted(false);
		btnExcluir.setFocusable(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int resposta = JOptionPane.showConfirmDialog(null,
						"Deseja realmente excluir o usuário?",
						"Excluir Usuário", JOptionPane.YES_NO_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {

					new ControleMetodosUsuario()
							.excluirDadosUsuario(new Usuario(tfNome.getText()
									.toUpperCase(), tfLogin.getText()
									.toUpperCase(), String.valueOf(pfNovaSenha
									.getPassword()), listaUsuario.get(posicao)
									.getId_usuario()));

					posicao = cbNome.getSelectedIndex();

					tfNumero.setText(String.valueOf(listaUsuario.get(posicao)
							.getId_usuario()));
					tfLogin.setText(String.valueOf(listaUsuario.get(posicao)
							.getLogin()));
					pfSenhaAtual.setText(listaUsuario.get(posicao).getSenha());

					listaUsuario.clear();
					cbNome.removeAllItems();
					cbNome.setSelectedItem(null);

					listaUsuario = new ControleMetodosUsuario().listarUsuario();

					for (Usuario user : listaUsuario) {

						cbNome.addItem(user.getNome());

					}

				}

			}

		});
		btnExcluir.setToolTipText("Excluir");
		btnExcluir.setBounds(234, 11, 84, 68);
		contentPanel.add(btnExcluir);

		btnRegistroPosterior.setBorderPainted(false);
		btnRegistroPosterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JdPesquisarUsuario dialog = new JdPesquisarUsuario();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);

			}
		});
		btnRegistroPosterior.setFocusable(false);
		btnRegistroPosterior.setContentAreaFilled(false);
		btnRegistroPosterior.setRolloverIcon(new ImageIcon(
				JdCadastroUsuario.class
						.getResource("/images/pesquisa_usuario_2.png")));
		btnRegistroPosterior.setIcon(new ImageIcon(JdCadastroUsuario.class
				.getResource("/images/pesquisa_usuario.png")));
		btnRegistroPosterior.setToolTipText("Pesquisar");
		btnRegistroPosterior.setBounds(343, 11, 76, 68);
		contentPanel.add(btnRegistroPosterior);

		JLabel lblRepetirSenha = new JLabel("Repetir Senha");
		lblRepetirSenha.setBounds(297, 186, 69, 14);
		contentPanel.add(lblRepetirSenha);

		pfRepetirSenha = new JPasswordField();
		pfRepetirSenha.setEditable(false);
		pfRepetirSenha.setBounds(297, 203, 102, 20);
		contentPanel.add(pfRepetirSenha);

		tfNome = new JTextField();
		tfNome.setBounds(108, 104, 291, 20);
		contentPanel.add(tfNome);
		tfNome.setColumns(10);
		tfNome.setVisible(false);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						int id_usuario;

						String senha = String.valueOf(pfNovaSenha.getPassword());
						String repetirSenha = String.valueOf(pfRepetirSenha
								.getPassword());

						if (tfNome.getText().equals("")) {

							JOptionPane.showMessageDialog(null,
									"Digite o Nome do usuário");

							tfNome.requestFocus();

						} else if (tfLogin.getText().equals("")) {

							JOptionPane.showMessageDialog(null,
									"Digite o Login do usuário");

							tfLogin.requestFocus();

						} else if (String.valueOf(pfNovaSenha.getPassword())
								.equalsIgnoreCase("")) {

							JOptionPane.showMessageDialog(null,
									"Digite o Senha do usuário");

							pfNovaSenha.requestFocus();

						} else if (String.valueOf(pfRepetirSenha.getPassword())
								.equalsIgnoreCase("")) {

							JOptionPane.showMessageDialog(null,
									"Repita a Senha do usuário");

							pfRepetirSenha.requestFocus();

						} else if (!senha.equalsIgnoreCase(repetirSenha)) {

							JOptionPane.showMessageDialog(null,
									"As senhas não estão iguais");

							pfNovaSenha.requestFocus();
							pfNovaSenha.setText("");
							pfRepetirSenha.setText("");

						} else {

							if (botao.equals("salvar")) {

								id_usuario = new ControleMetodosUsuario()
										.cadastrarUsuario(new Usuario(
												tfNome.getText().toUpperCase(),
												tfLogin.getText().toUpperCase(),
												senha));

								if (id_usuario == -1) {

									JOptionPane.showMessageDialog(null,
											"Erro ao Cadastrar o Usuário!");
									
					
								} else {

									JOptionPane.showMessageDialog(null,
											"Usuário Cadastrado com Sucesso!");
									
															
									listaUsuario.clear();
									cbNome.removeAllItems();
									cbNome.setSelectedItem(null);
																

									listaUsuario = new ControleMetodosUsuario()
											.listarUsuario();

									for (Usuario user : listaUsuario) {

										cbNome.addItem(user.getNome());

									}


									tfNome.setText("");
									tfLogin.setText("");
									tfLogin.setEditable(false);
									pfSenhaAtual.setText("");
									pfSenhaAtual.setEditable(false);
									pfNovaSenha.setText("");
									pfNovaSenha.setEditable(false);
									pfRepetirSenha.setText("");
									pfRepetirSenha.setEditable(false);
									chckbxBloqueado.setEnabled(false);
									tfNumero.setText("");

									posicao = cbNome.getSelectedIndex();

									tfNumero.setText(String
											.valueOf(posicao + 1));
									tfLogin.setText(String.valueOf(listaUsuario
											.get(posicao).getLogin()));
									pfSenhaAtual.setText(listaUsuario.get(
											posicao).getSenha());

									btnNovo.setEnabled(true);
									btnEditar.setEnabled(true);
									btnExcluir.setEnabled(true);
									btnRegistroPosterior.setEnabled(true);
									
									cbNome.setVisible(true);
									tfNome.setVisible(false);
									

									botao = "";
									
									okButton.setVisible(false);

								}

							}

							if (botao.equals("editar")) {

								id_usuario = new ControleMetodosUsuario()
										.alterarDadosUsuario(new Usuario(
												tfNome.getText().toUpperCase(),
												tfLogin.getText().toUpperCase(),
												senha, listaUsuario.get(posicao).getId_usuario()));

							
								if (id_usuario == -1) {

									JOptionPane.showMessageDialog(null,
											"Erro ao Editar o Usuário!");
								} else {

									JOptionPane.showMessageDialog(null,
											"Usuário Editado com Sucesso!");

									botao = "";
									
							
									listaUsuario.clear();
									cbNome.removeAllItems();
									cbNome.setSelectedItem(null);

									listaUsuario = new ControleMetodosUsuario().listarUsuario();

									for (Usuario user : listaUsuario) {

										cbNome.addItem(user.getNome());

									}
									
									tfNome.setText("");
									tfLogin.setText("");
									tfLogin.setEditable(false);
									pfSenhaAtual.setText("");
									pfSenhaAtual.setEditable(false);
									pfNovaSenha.setText("");
									pfNovaSenha.setEditable(false);
									pfRepetirSenha.setText("");
									pfRepetirSenha.setEditable(false);
									chckbxBloqueado.setEnabled(false);
									tfNumero.setText("");

									posicao = cbNome.getSelectedIndex();

									tfNumero.setText(String
											.valueOf(posicao + 1));
									tfLogin.setText(String.valueOf(listaUsuario
											.get(posicao).getLogin()));
									pfSenhaAtual.setText(listaUsuario.get(
											posicao).getSenha());

									btnNovo.setEnabled(true);
									btnEditar.setEnabled(true);
									btnExcluir.setEnabled(true);
									btnRegistroPosterior.setEnabled(true);
									
									cbNome.setVisible(true);
									tfNome.setVisible(false);
									
									okButton.setVisible(false);

								}

							}

						}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						listaUsuario.clear();
						cbNome.removeAllItems();
						cbNome.setSelectedItem(null);
						
						cbNome.setVisible(true);
						
						dispose();
						
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

	}

}
