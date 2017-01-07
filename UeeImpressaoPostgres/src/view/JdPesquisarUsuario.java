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
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControleMetodosUsuario;
import controller.Usuario;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;

public class JdPesquisarUsuario extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfPesquisaNome;
	private JTable tbPesquisaUsuario;
	List<Usuario> listaPesquisaUsuario;
	Usuario usuarioLocalizado = new Usuario();
	JButton btnPesquisarNome = new JButton("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JdPesquisarUsuario dialog = new JdPesquisarUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JdPesquisarUsuario() {
		setModal(true);
		setResizable(false);
		setTitle("Pesquisar Usu\u00E1rio");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				JdPesquisarUsuario.class
						.getResource("/images/techvan_transparente.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		tfPesquisaNome = new JTextField();
		tfPesquisaNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel) tbPesquisaUsuario
						.getModel();

				model.setNumRows(0);
				
				getRootPane().setDefaultButton(btnPesquisarNome);
				
			}
		});
		tfPesquisaNome.setBounds(28, 46, 314, 20);
		contentPanel.add(tfPesquisaNome);
		tfPesquisaNome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(28, 29, 46, 14);
		contentPanel.add(lblNewLabel);

		
		
		btnPesquisarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
				if (tfPesquisaNome.getText().equalsIgnoreCase("")) {

					JOptionPane.showMessageDialog(null,
							"Digite um nome ou letra para pesquisar!");

				} else {

					listaPesquisaUsuario = new ControleMetodosUsuario()
							.pesquisarUsuario(tfPesquisaNome.getText()
									.toUpperCase());

					if (listaPesquisaUsuario.isEmpty() == true) {

						JOptionPane.showMessageDialog(null,
								"Usuário não encontrado!");
																		

					} else {

						DefaultTableModel model = (DefaultTableModel) tbPesquisaUsuario
								.getModel();

						model.setNumRows(0);

						for (Usuario u : listaPesquisaUsuario) {

							Object[] linha = { u.getNome() };

							model.addRow(linha);

						}

					}

				}

			}
		});
		btnPesquisarNome.setRolloverIcon(new ImageIcon(JdPesquisarUsuario.class
				.getResource("/images/views-48_2.png")));
		btnPesquisarNome.setContentAreaFilled(false);
		btnPesquisarNome.setFocusable(false);
		btnPesquisarNome.setBorderPainted(false);
		btnPesquisarNome.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPesquisarNome.setIcon(new ImageIcon(JdPesquisarUsuario.class
				.getResource("/images/views-48.png")));
		btnPesquisarNome.setBounds(341, 24, 69, 65);
		contentPanel.add(btnPesquisarNome);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(28, 100, 378, 120);
		contentPanel.add(scrollPane);

		tbPesquisaUsuario = new JTable();
		tbPesquisaUsuario.setGridColor(Color.WHITE);
		tbPesquisaUsuario.setBackground(Color.YELLOW);
		tbPesquisaUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int posicao = tbPesquisaUsuario.getSelectedRow();
				
				usuarioLocalizado.setId_usuario(listaPesquisaUsuario.get(posicao).getId_usuario());
				usuarioLocalizado.setNome(String.valueOf(listaPesquisaUsuario.get(posicao).getNome()));
				usuarioLocalizado.setLogin(String.valueOf(listaPesquisaUsuario.get(posicao).getLogin()));
												
				JdCadastroUsuario.tfNumero.setText(String.valueOf(usuarioLocalizado.getId_usuario()));
				JdCadastroUsuario.tfNome.setText(usuarioLocalizado.getNome());
				JdCadastroUsuario.tfLogin.setText(usuarioLocalizado.getLogin());
				JdCadastroUsuario.cbNome.setSelectedItem(usuarioLocalizado.getNome());
				
				/*JdCadastroUsuario.listaUsuario.clear();
				JdCadastroUsuario.cbNome.removeAllItems();
				JdCadastroUsuario.cbNome.setSelectedItem(null);

				for (Usuario user : JdCadastroUsuario.listaUsuario) {

					JdCadastroUsuario.cbNome.addItem(user.getNome());

				}
				
				
				/* listaPesquisaUsuario.get(posicao).getId_usuario();
				JdCadastroUsuario.listaUsuario.get(posicao).getId_usuario();

			
					//	JdCadastroUsuario.listaUsuario.clear();
						//JdCadastroUsuario.cbNome.removeAllItems();
						//JdCadastroUsuario.cbNome.setSelectedItem(null);

						JdCadastroUsuario.listaUsuario.get(posicao)
								.getId_usuario();

						for (Usuario user : JdCadastroUsuario.listaUsuario) {

							JdCadastroUsuario.cbNome.addItem(user.getNome());

						}

						posicao = JdCadastroUsuario.cbNome.getSelectedIndex();

						if (posicao == -1) {

							posicao = 0;

						}

						JdCadastroUsuario.tfNumero.setText(String
								.valueOf(JdCadastroUsuario.listaUsuario.get(
										posicao).getId_usuario()));
						JdCadastroUsuario.tfLogin.setText(String
								.valueOf(JdCadastroUsuario.listaUsuario.get(
										posicao).getLogin()));
						JdCadastroUsuario.pfSenhaAtual
								.setText(JdCadastroUsuario.listaUsuario.get(
										posicao).getSenha());*/


				dispose();
			}
		
		});

		tbPesquisaUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbPesquisaUsuario.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Usu\u00E1rio Encontrado" }));
		scrollPane.setViewportView(tbPesquisaUsuario);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
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
