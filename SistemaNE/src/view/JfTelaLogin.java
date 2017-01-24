package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import controller.usuario.Usuario;

public class JfTelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField pfSenha;
	JComboBox<String> cbUsuario = new JComboBox<String>();
	private List <Usuario> listaUsuario;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					JfTelaLogin frame = new JfTelaLogin();
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
	public JfTelaLogin() {
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JfTelaLogin.class.getResource("/image/ne.png")));
		setResizable(false);
		setTitle("Login de Usu\u00E1rio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 276, 145);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(36, 22, 46, 22);
		contentPane.add(lblLogin);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(36, 49, 46, 22);
		contentPane.add(lblSenha);

		pfSenha = new JPasswordField();
		pfSenha.setHorizontalAlignment(SwingConstants.LEFT);
		pfSenha.setBounds(77, 49, 150, 20);
		contentPane.add(pfSenha);
		
		

		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnOk.setHorizontalTextPosition(SwingConstants.CENTER);
		btnOk.setMnemonic('O');
		getRootPane().setDefaultButton(btnOk);
		

		cbUsuario.setBounds(77, 23, 150, 20);
		contentPane.add(cbUsuario);
	
		//listaUsuario = new ControleMetodosUsuario().listarUsuario();

		
		//for(Usuario user : listaUsuario){
			
			//cbUsuario.addItem(user.getLogin());
			
		//}
	
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					dispose();
					
					UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					JfTelaInicial frame = new JfTelaInicial();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
					
					
					
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				


			}
		});
		btnOk.setBounds(36, 82, 89, 23);
		contentPane.add(btnOk);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelar.setMnemonic('C');
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();

			}
		});
		btnCancelar.setBounds(139, 82, 89, 23);
		contentPane.add(btnCancelar);
	
	
	}

	
}
