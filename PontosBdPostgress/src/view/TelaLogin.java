package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import model.UsuarioDao;
import javax.swing.border.EtchedBorder;

public class TelaLogin extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfUsuario;
	private JPasswordField pfSenha;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			TelaLogin dialog = new TelaLogin();
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
	public TelaLogin() {
		setUndecorated(true);
		setType(Type.POPUP);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/dinheiro.gif")));
		setModal(true);
		setTitle("Pontos");
		setBounds(100, 100, 399, 202);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
		contentPanel.setBackground(SystemColor.control);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("");
		label.setBounds(118, 25, 0, 0);
		contentPanel.setLayout(null);
		contentPanel.add(label);
		
		JButton button = new JButton("Fechar");
		button.setRolloverIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/fundo_2.jpg")));
		button.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/fundo_1.jpg")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		button.setInheritsPopupMenu(true);
		button.setIgnoreRepaint(true);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setHideActionText(true);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		button.setBounds(203, 145, 136, 30);
		contentPanel.add(button);
		
		
		final JLabel lblMensagem = new JLabel("Verifique se est\u00E1 com o caps lock ativado e tente novamente.");
		lblMensagem.setVisible(false);
		lblMensagem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagem.setBounds(0, 171, 399, 31);
		contentPanel.add(lblMensagem);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.setBounds(59, 145, 134, 30);
		contentPanel.add(btnLogar);
		btnLogar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLogar.setRolloverIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/fundo_2.jpg")));
		btnLogar.setHideActionText(true);
		btnLogar.setInheritsPopupMenu(true);
		btnLogar.setIgnoreRepaint(true);
		btnLogar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogar.setForeground(Color.WHITE);
		btnLogar.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/fundo_1.jpg")));
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfUsuario.getText().equalsIgnoreCase("") || pfSenha.getPassword().equals("")){
					
					JOptionPane.showMessageDialog(null, "Digite em ambos os campos");
										
				}else{
				
				UsuarioDao usuarioDao = new UsuarioDao();			
				
				TelaPrincipal.logado = usuarioDao.login(tfUsuario.getText().toUpperCase(), String.valueOf(pfSenha.getPassword()));
	
				
					if (TelaPrincipal.logado.getLogin() == null || TelaPrincipal.logado.getSenha() == null){
					
					JOptionPane.showMessageDialog(null, "Login ou senha inválidos");
					
					
					tfUsuario.grabFocus();
					
					}else{
				
						JOptionPane.showMessageDialog(null, "Usuário Logado");
				
						try {
							UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
						} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						TelaPrincipal frame = new TelaPrincipal();
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
	
				
						dispose();
				
					}
				
				tfUsuario.setText("");
				pfSenha.setText("");
				
				lblMensagem.setVisible(true);
				
			}
				
			}
		});
		getRootPane().setDefaultButton(btnLogar);
		btnLogar.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblLogin = new JLabel("|          LOGIN          |");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.ORANGE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogin.setBounds(0, 0, 399, 30);
		contentPanel.add(lblLogin);
		
		JLabel lblFaixa = new JLabel("New label");
		lblFaixa.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/fundo_1.jpg")));
		lblFaixa.setBounds(0, 0, 399, 30);
		contentPanel.add(lblFaixa);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(59, 109, 280, 25);
		contentPanel.add(pfSenha);
		pfSenha.setHorizontalAlignment(SwingConstants.CENTER);
		pfSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(59, 91, 43, 20);
		contentPanel.add(lblSenha);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio");
		lblUsuario.setBounds(59, 46, 54, 19);
		contentPanel.add(lblUsuario);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(59, 64, 280, 25);
		contentPanel.add(tfUsuario);
		tfUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfUsuario.setColumns(10);
		
		
	}
}
