package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Cliente;

public class CadastrarCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfImagemFrente;
	private JTextField tfImagemVerso;
	private JButton btnCadastrar;
	private JButton btnSair;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					CadastrarCliente frame = new CadastrarCliente();
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
	public CadastrarCliente() {
		setTitle("Cadastro Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		tfNome = new JTextField();
		tfNome.setBounds(39, 59, 369, 20);
		tfNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(39, 39, 148, 14);
		
		JLabel lblImagemFrente = new JLabel("Imagem Frente");
		lblImagemFrente.setBounds(39, 90, 150, 14);
		
		tfImagemFrente = new JTextField();
		tfImagemFrente.setBounds(39, 111, 203, 20);
		tfImagemFrente.setColumns(10);
		
		JLabel lblImagemVerso = new JLabel("Imagem Verso");
		lblImagemVerso.setBounds(39, 144, 142, 14);
		
		tfImagemVerso = new JTextField();
		tfImagemVerso.setBounds(39, 165, 203, 20);
		tfImagemVerso.setColumns(10);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(193, 214, 122, 23);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			tfNome.getText().toUpperCase();
			tfImagemFrente.getText().toUpperCase();
			tfImagemVerso.getText().toUpperCase();
			
			Cliente novo = new Cliente();
			novo.AdicionarCliente(tfNome.getText().toUpperCase(), tfImagemFrente.getText().toUpperCase(), tfImagemVerso.getText().toUpperCase());
			
			novo.ListarCliente();
			
						
			EscolherImagem frame = new EscolherImagem ();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);			
				
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(325, 214, 83, 23);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
		});
		
		JButton btnSelecionarImagem = new JButton("Selecionar Imagem");
		btnSelecionarImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser escolherArquivo = new JFileChooser();
				FileNameExtensionFilter filtroExtensao = new FileNameExtensionFilter(".jpg", "jpg");
				escolherArquivo.addChoosableFileFilter(filtroExtensao);
			
				
				int retorno = escolherArquivo.showDialog(null, "Selecionar Imagem");

				
				if (retorno == JFileChooser.APPROVE_OPTION) {

					File arquivo = escolherArquivo.getSelectedFile();
					escolherArquivo.setSelectedFile(arquivo);

					JOptionPane.showMessageDialog(null,  arquivo);
					tfImagemFrente.setText(String.valueOf(arquivo));

				}
				
				
				
			}
		});
		btnSelecionarImagem.setBounds(252, 110, 156, 23);
		
		JButton btnSelecionarImagem_1 = new JButton("Selecionar Imagem");
		btnSelecionarImagem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
							
				JFileChooser escolherArquivo = new JFileChooser();
				FileNameExtensionFilter filtroExtensao = new FileNameExtensionFilter(".jpg", "jpg");
				escolherArquivo.addChoosableFileFilter(filtroExtensao);
			
				
				int retorno = escolherArquivo.showDialog(null, "Selecionar Imagem");

				
				if (retorno == JFileChooser.APPROVE_OPTION) {

					File arquivo = escolherArquivo.getSelectedFile();
					escolherArquivo.setSelectedFile(arquivo);

					JOptionPane.showMessageDialog(null,  arquivo);
					tfImagemVerso.setText(String.valueOf(arquivo));

				}
				
				
				
			}
		});
		btnSelecionarImagem_1.setBounds(252, 164, 156, 23);
		contentPane.setLayout(null);
		contentPane.add(tfNome);
		contentPane.add(btnCadastrar);
		contentPane.add(btnSair);
		contentPane.add(lblImagemVerso);
		contentPane.add(lblImagemFrente);
		contentPane.add(tfImagemVerso);
		contentPane.add(tfImagemFrente);
		contentPane.add(btnSelecionarImagem_1);
		contentPane.add(btnSelecionarImagem);
		contentPane.add(lblNome);
	}
}
