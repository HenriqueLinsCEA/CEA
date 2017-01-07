package view;

import controller.Etiquetas;
import controller.Listas;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.awt.Font;

public class TelaAplicativo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfAbrir;
	private JTextField tfSalvar;
	private static File local;
	String caminhoUltimoArquivo = "";
	String caminhoAbrir = "";
	private JButton btnEtiqueta;
	private JButton btnListagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					TelaAplicativo frame = new TelaAplicativo();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAplicativo() {
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				TelaAplicativo.class
						.getResource("/image/f121d135f320140728102619.jpg")));
		setTitle("Etiquetas e Listas Unimed Norte Nordeste");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfAbrir = new JTextField();
		tfAbrir.setBounds(26, 118, 262, 20);
		contentPane.add(tfAbrir);
		tfAbrir.setColumns(10);

		tfSalvar = new JTextField();
		tfSalvar.setColumns(10);
		tfSalvar.setBounds(26, 163, 262, 20);
		contentPane.add(tfSalvar);

		JButton btnAbrirArquivo = new JButton("Abrir Arquivo");
		btnAbrirArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser escolherArquivo = new JFileChooser();
				FileNameExtensionFilter filtroExtensao = new FileNameExtensionFilter(
						".txt", "txt");

				FileNameExtensionFilter filtroExtensao2 = new FileNameExtensionFilter(
						".csv", "csv");

				escolherArquivo.addChoosableFileFilter(filtroExtensao);

				escolherArquivo.addChoosableFileFilter(filtroExtensao2);

				File pathInicial = new File(caminhoUltimoArquivo);
				escolherArquivo.setCurrentDirectory(pathInicial);

				int retorno = escolherArquivo.showDialog(null,
						"Selecionar Arquivo");

				if (retorno == JFileChooser.APPROVE_OPTION) {

					File arquivo = null;
					arquivo = escolherArquivo.getSelectedFile();
					escolherArquivo.setSelectedFile(arquivo);

					JOptionPane.showMessageDialog(null, arquivo);
					tfAbrir.setText(arquivo.getPath());

				}

				String caminhoCompleto = escolherArquivo.getSelectedFile().getAbsolutePath();
				caminhoUltimoArquivo = caminhoCompleto.substring(0,
						caminhoCompleto.lastIndexOf("\\"));
				caminhoAbrir = escolherArquivo.getSelectedFile()
						.getAbsolutePath();

			}
		});
		btnAbrirArquivo.setBounds(293, 117, 127, 23);
		contentPane.add(btnAbrirArquivo);

		JButton btnSalvarArquivo = new JButton("Salvar Arquivo");
		btnSalvarArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser escolherArquivo = new JFileChooser();

				File pathInicial = new File(caminhoUltimoArquivo);
				escolherArquivo.setCurrentDirectory(pathInicial);

				if (tfAbrir.getText().equalsIgnoreCase("")) {

					JOptionPane.showMessageDialog(null,
							"Primeiro escolha o arquivo de entrada!");

				} else {

					FileNameExtensionFilter filtroExtensao = new FileNameExtensionFilter(
							".txt", "txt");

					FileNameExtensionFilter filtroExtensao2 = new FileNameExtensionFilter(
							".csv", "csv");

					escolherArquivo.addChoosableFileFilter(filtroExtensao);

					escolherArquivo.addChoosableFileFilter(filtroExtensao2);

					int retorno = escolherArquivo.showDialog(null, "Salvar");

					if (retorno == JFileChooser.APPROVE_OPTION) {

						File arquivo = null;

						arquivo = escolherArquivo.getSelectedFile();

						if (caminhoAbrir.equalsIgnoreCase(arquivo.toString())) {

							JOptionPane
									.showMessageDialog(null,
											"O arquivo Abrir não pode ser igual ao Salvar!");

						} else if (arquivo.exists() == true) {

							int resposta = JOptionPane
									.showConfirmDialog(
											null,
											"Já exite um arquivo com esse nome, \nDeseja subscrever o arquivo?",
											"MENSAGEM",
											JOptionPane.YES_NO_OPTION);

							if (resposta == JOptionPane.YES_OPTION) {

								escolherArquivo.setSelectedFile(arquivo);

								escolherArquivo.setSelectedFile(arquivo);

							

								tfSalvar.setText(arquivo.getAbsolutePath());

								String caminhoCompleto = escolherArquivo
										.getSelectedFile().getAbsolutePath();
								caminhoUltimoArquivo = caminhoCompleto
										.substring(0, caminhoCompleto
												.lastIndexOf("\\"));

							} else {

								tfSalvar.setText("");

							}

						} else {

					
							escolherArquivo.setSelectedFile(arquivo);
						

							tfSalvar.setText(arquivo.getAbsolutePath());

							String caminhoCompleto = escolherArquivo
									.getSelectedFile().getAbsolutePath();
							caminhoUltimoArquivo = caminhoCompleto.substring(0,
									caminhoCompleto.lastIndexOf("\\"));

						}

					}

				}

			}
		});
		btnSalvarArquivo.setBounds(293, 160, 127, 23);
		contentPane.add(btnSalvarArquivo);

		btnEtiqueta = new JButton("Etiqueta");
		btnEtiqueta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnEtiqueta.setEnabled(true);

				Etiquetas etiquetas = new Etiquetas();
				boolean retorno = false;
				if (tfAbrir.getText().equals("")
						|| tfSalvar.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Preencha os campos Abrir e Salvar");

				} else {

					try {

						retorno = etiquetas.SalvarEtiquetas(tfAbrir.getText()
								.toUpperCase(), tfSalvar.getText()
								.toUpperCase());

						if (retorno == false) {

							JOptionPane
									.showMessageDialog(null,
											"Erro ao gerar o arquivo. \nVerifique se abriu o arquivo correto!");

							File deletar = new File(tfSalvar.getText()
									.toUpperCase() + ".csv");

							deletar.delete();

							
							tfSalvar.setText("");
							tfAbrir.setText("");

						} else {

							JOptionPane.showMessageDialog(null,
									"Arquivo gerado com sucesso!");

							int resposta = JOptionPane.showConfirmDialog(null,
									"Deseja gerar a Listagem?", "MENSAGEM",
									JOptionPane.YES_NO_OPTION);

							if (resposta == JOptionPane.YES_OPTION) {

								tfSalvar.setText("");
								btnEtiqueta.setEnabled(false);

							} else {

								tfAbrir.setText("");
								tfSalvar.setText("");

							}

						}

					} catch (HeadlessException | IOException e1) {

						e1.printStackTrace();

						JOptionPane
								.showMessageDialog(null,
										"Erro ao gerar o arquivo. \nVerifique se abriu o arquivo correto!");

						new File(tfSalvar.getText().toUpperCase()).delete();

					}

				}

			}
		});
		btnEtiqueta.setBounds(29, 215, 127, 23);
		contentPane.add(btnEtiqueta);

		btnListagem = new JButton("Listas");
		btnListagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Listas listas = new Listas();
				boolean retorno = false;
				if (tfAbrir.getText().equals("")
						|| tfSalvar.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Preencha os campos Abrir e Salvar");

				} else {

					try {

						retorno = listas.SalvarListas(tfAbrir.getText()
								.toUpperCase(), tfSalvar.getText()
								.toUpperCase());

						if (retorno == false) {

							JOptionPane
									.showMessageDialog(null,
											"Erro ao gerar o arquivo. \nVerifique se abriu o arquivo correto!");

							File deletar = new File(tfSalvar.getText()
									.toUpperCase() + ".csv");

							deletar.delete();

						

							tfSalvar.setText("");
							tfAbrir.setText("");

							
						} else {

							JOptionPane.showMessageDialog(null,
									"Arquivo gerado com sucesso!");

							btnEtiqueta.setEnabled(true);
							tfAbrir.setText("");
							tfSalvar.setText("");

						}

					} catch (HeadlessException | IOException e1) {

						e1.printStackTrace();

						JOptionPane
								.showMessageDialog(null,
										"Erro ao gerar o arquivo. \nVerifique se abriu o arquivo correto!");

						new File(tfSalvar.getText().toUpperCase()).delete();

					}

				}

				/*
				 * if (!tfAbrir.getText().equals("") &&
				 * tfSalvar.getText().equals("")) {
				 * 
				 * tfSalvar.setText("");
				 * 
				 * } else {
				 * 
				 * tfAbrir.setText(""); tfSalvar.setText("");
				 * 
				 * }
				 */

			}
		});
		btnListagem.setBounds(161, 215, 127, 23);
		contentPane.add(btnListagem);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.exit(EXIT_ON_CLOSE);

			}
		});
		btnSair.setBounds(293, 215, 127, 23);
		contentPane.add(btnSair);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaAplicativo.class
				.getResource("/image/photo.jpg")));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(26, 19, 120, 76);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Gerador de etiquetas e listagens");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(161, 19, 259, 76);
		contentPane.add(lblNewLabel_1);
	}

	public static File getLocal() {
		return local;
	}

	public static void setLocal(File local) {
		TelaAplicativo.local = local;
	}
}
