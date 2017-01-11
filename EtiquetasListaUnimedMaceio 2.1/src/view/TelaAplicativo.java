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
	private static File local;
	String caminhoUltimoArquivo = "C:/";
	String caminhoAbrir = "";
	String caminhoCompleto = "";
	private JButton btnEtiqueta;
	private JButton btnAbrirArquivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAplicativo.class.getResource("/image/avatar.jpg")));
		setTitle("Unimed Etiqueta e Listagem");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfAbrir = new JTextField();
		tfAbrir.setBounds(29, 151, 257, 20);
		contentPane.add(tfAbrir);
		tfAbrir.setColumns(10);

		btnAbrirArquivo = new JButton("Abrir Arquivo");
		getRootPane().setDefaultButton(btnAbrirArquivo);
		btnAbrirArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser escolherArquivo = new JFileChooser();

				FileNameExtensionFilter filtroExtensao = new FileNameExtensionFilter(".txt", "txt");
				FileNameExtensionFilter filtroExtensao2 = new FileNameExtensionFilter(".csv", "csv");

				escolherArquivo.addChoosableFileFilter(filtroExtensao);
				escolherArquivo.addChoosableFileFilter(filtroExtensao2);

				File pathInicial = new File(caminhoUltimoArquivo);
				escolherArquivo.setCurrentDirectory(pathInicial);

				int retorno = escolherArquivo.showDialog(null, "Selecionar Arquivo");

				if (retorno == JFileChooser.APPROVE_OPTION) {

					File arquivo = null;
					arquivo = escolherArquivo.getSelectedFile();
					escolherArquivo.setSelectedFile(arquivo);

					JOptionPane.showMessageDialog(null, arquivo);
					tfAbrir.setText(arquivo.getPath());

					getRootPane().setDefaultButton(btnEtiqueta);

				}

				try {

					caminhoCompleto = escolherArquivo.getSelectedFile().getAbsolutePath();
					caminhoUltimoArquivo = caminhoCompleto.substring(0, caminhoCompleto.lastIndexOf("\\"));
					caminhoAbrir = escolherArquivo.getSelectedFile().getAbsolutePath();

				} catch (Exception e2) {

					caminhoCompleto = "";
					caminhoUltimoArquivo = caminhoCompleto;
					caminhoAbrir = caminhoCompleto;

				}

			}
		});
		btnAbrirArquivo.setBounds(296, 150, 127, 23);
		contentPane.add(btnAbrirArquivo);

		btnEtiqueta = new JButton("Gerar Etiquetas e Listagem");
		btnEtiqueta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Etiquetas etiquetas = new Etiquetas();
				boolean retorno = false;

				Listas listas = new Listas();
				boolean retorno2 = false;

				if (tfAbrir.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Preencha o campo Abrir Arquivo");

				} else {

					try {

						retorno = etiquetas.SalvarEtiquetas(tfAbrir.getText().toUpperCase());

						retorno2 = listas.SalvarListas(tfAbrir.getText().toUpperCase());

						if (retorno == false || retorno2 == false) {

							JOptionPane.showMessageDialog(null,
									"Erro abrir o arquivo. \nVerifique se abriu o arquivo correto!");

							File deletar = new File(tfAbrir.getText().toUpperCase() + "-ETI.csv");

							deletar.delete();

							File deletar2 = new File(tfAbrir.getText().toUpperCase() + "-LI.csv");

							deletar2.delete();

							tfAbrir.setText("");

						} else {

							JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso!");

							tfAbrir.setText("");

							getRootPane().setDefaultButton(btnAbrirArquivo);

						}

					} catch (HeadlessException | IOException e1) {

						e1.printStackTrace();

						File deletar = new File(tfAbrir.getText().toUpperCase() + "-ETI.csv");

						deletar.delete();

						File deletar2 = new File(tfAbrir.getText().toUpperCase() + "-LI.csv");

						deletar2.delete();

						tfAbrir.setText("");
					}

				}

			}
		});
		btnEtiqueta.setBounds(29, 208, 194, 23);
		contentPane.add(btnEtiqueta);

		JButton btnSair = new JButton("Cancelar");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.exit(EXIT_ON_CLOSE);

			}
		});
		btnSair.setBounds(233, 208, 190, 23);
		contentPane.add(btnSair);

		JLabel lbllOGO = new JLabel("");
		lbllOGO.setIcon(new ImageIcon(TelaAplicativo.class.getResource("/image/avatar.jpg")));
		lbllOGO.setHorizontalTextPosition(SwingConstants.CENTER);
		lbllOGO.setHorizontalAlignment(SwingConstants.CENTER);
		lbllOGO.setBounds(11, 13, 170, 113);
		contentPane.add(lbllOGO);

		JLabel lblNomeprog = new JLabel("Etiquetas e Listagem");
		lblNomeprog.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeprog.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNomeprog.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNomeprog.setBounds(161, 23, 262, 103);
		contentPane.add(lblNomeprog);
	}

	public static File getLocal() {
		return local;
	}

	public static void setLocal(File local) {
		TelaAplicativo.local = local;
	}
}
