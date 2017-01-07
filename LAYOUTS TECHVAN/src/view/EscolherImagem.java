package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

import javax.swing.Icon;

import controller.Cliente;

public class EscolherImagem extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCliente;
	private JLabel crachaFrente;
	private JLabel crachaVerso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EscolherImagem frame = new EscolherImagem();
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
	public EscolherImagem() {
		setResizable(false);
		setTitle("Escolher Imagem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1244, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		tfCliente = new JTextField();
		tfCliente.setColumns(10);
						       
		JLabel lblCliente = new JLabel("Cliente");
		
		ImageIcon fotoFrente = new ImageIcon("IMAGE/TECHVAN.GIF");
		ImageIcon fotoVerso = new ImageIcon("IMAGE/TECHVAN.GIF");
		
		
		
		crachaFrente = new JLabel(fotoFrente);
		//crachaFrente.setLabelFor(this);
		
		crachaVerso = new JLabel(fotoVerso);
		
		//final String endereçoFrente = "IMAGE/FRIATO_FRENTE.JPG";
		//final String endereçoVerso = "IMAGE/FRIATO_VERSO.JPG" ;	
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			Cliente novo = new Cliente();
			int posicao = novo.PesquisarCliente(tfCliente.getText().toString());
			
			if (posicao != -1){
				
				crachaFrente.setIcon(new ImageIcon(Cliente.ListaCliente.get(posicao).getImagemFrente()));
				crachaVerso.setIcon(new ImageIcon(Cliente.ListaCliente.get(posicao).getImagemVerso()));	
			
			}
				
				}
		});
		
		
		
		
		
		
		
  
       
  
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCliente)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tfCliente, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnPesquisar)
							.addGap(65)
							.addComponent(crachaFrente, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(crachaVerso, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(lblCliente)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(crachaVerso, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
						.addComponent(crachaFrente, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(tfCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnPesquisar)))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		
		
		contentPane.setLayout(gl_contentPane);
	}
}
