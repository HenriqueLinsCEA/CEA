package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;

public class TelaAreaDoUsuario extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
				
			TelaAreaDoUsuario dialog = new TelaAreaDoUsuario();
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
	public TelaAreaDoUsuario() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAreaDoUsuario.class.getResource("/imagens/dinheiro.gif")));
		setResizable(false);
		setTitle("Pontos");
		setModal(true);
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblUsuarioLogado = new JLabel((String) null);
			lblUsuarioLogado.setForeground(Color.ORANGE);
			lblUsuarioLogado.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblUsuarioLogado.setBounds(251, 21, 250, 28);
			lblUsuarioLogado.setText(TelaPrincipal.logado.getNome());
			contentPanel.add(lblUsuarioLogado);
		}
		{
			JLabel label = new JLabel("Usu\u00E1rio Logado: ");
			label.setForeground(Color.ORANGE);
			label.setFont(new Font("Tahoma", Font.BOLD, 16));
			label.setBounds(107, 21, 137, 28);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(TelaAreaDoUsuario.class.getResource("/imagens/dinheiro2.png")));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(507, 0, 87, 69);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("");
			label.setBounds(0, 0, 600, 69);
			label.setIcon(new ImageIcon(TelaAreaDoUsuario.class.getResource("/imagens/fundo_1.jpg")));
			contentPanel.add(label);
		}
		{
			{
				{
					{
						JButton button = new JButton("Cancelar");
						button.setBounds(401, 325, 149, 28);
						button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								dispose();
								
							}
						});
						contentPanel.add(button);
						button.setRolloverIcon(new ImageIcon(TelaAreaDoUsuario.class.getResource("/imagens/fundo_2.jpg")));
						button.setIcon(new ImageIcon(TelaAreaDoUsuario.class.getResource("/imagens/fundo_1.jpg")));
						button.setHorizontalTextPosition(SwingConstants.CENTER);
						button.setForeground(Color.WHITE);
						button.setFont(new Font("Tahoma", Font.BOLD, 13));
					}
				}
			}
		}
		{
			JButton btnNovoUsuario = new JButton("Novo Usu\u00E1rio");
			btnNovoUsuario.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			btnNovoUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
						
						TelaCadastroUsuario frame = new TelaCadastroUsuario();
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
						
						} catch (ClassNotFoundException | InstantiationException
							| IllegalAccessException
							| UnsupportedLookAndFeelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			btnNovoUsuario.setBounds(400, 134, 150, 28);
			btnNovoUsuario.setRolloverIcon(new ImageIcon(TelaAreaDoUsuario.class.getResource("/imagens/fundo_2.jpg")));
			btnNovoUsuario.setIcon(new ImageIcon(TelaAreaDoUsuario.class.getResource("/imagens/fundo_1.jpg")));
			btnNovoUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
			btnNovoUsuario.setForeground(Color.WHITE);
			btnNovoUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
			getRootPane().setDefaultButton(btnNovoUsuario);
			contentPanel.add(btnNovoUsuario);
		}
		{
			JButton btnExcluirUsuario = new JButton("Configurar Pontos");
			btnExcluirUsuario.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			btnExcluirUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						
						
						UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
						
						TelaConfigurarPontos frame = new TelaConfigurarPontos();
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
						
											
					} catch (ClassNotFoundException | InstantiationException
							| IllegalAccessException
							| UnsupportedLookAndFeelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			btnExcluirUsuario.setBounds(401, 231, 150, 28);
			btnExcluirUsuario.setRolloverIcon(new ImageIcon(TelaAreaDoUsuario.class.getResource("/imagens/fundo_2.jpg")));
			btnExcluirUsuario.setIcon(new ImageIcon(TelaAreaDoUsuario.class.getResource("/imagens/fundo_1.jpg")));
			btnExcluirUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
			btnExcluirUsuario.setForeground(Color.WHITE);
			btnExcluirUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
			contentPanel.add(btnExcluirUsuario);
		}
		{
			JButton btnListarUsuario = new JButton("Buscar Usu\u00E1rios");
			btnListarUsuario.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			btnListarUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
						
						TelaBuscarUsuario frame = new TelaBuscarUsuario();
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
						
					} catch (ClassNotFoundException | InstantiationException
							| IllegalAccessException
							| UnsupportedLookAndFeelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			btnListarUsuario.setBounds(400, 173, 150, 28);
			btnListarUsuario.setRolloverIcon(new ImageIcon(TelaAreaDoUsuario.class.getResource("/imagens/fundo_2.jpg")));
			btnListarUsuario.setIcon(new ImageIcon(TelaAreaDoUsuario.class.getResource("/imagens/fundo_1.jpg")));
			btnListarUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
			btnListarUsuario.setForeground(Color.WHITE);
			btnListarUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
			contentPanel.add(btnListarUsuario);
		}
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(TelaAreaDoUsuario.class.getResource("/imagens/logo casa grande horizontal2.png")));
			lblNewLabel.setBounds(50, 134, 349, 180);
			contentPanel.add(lblNewLabel);
		}
		{
			JButton btnHistorico = new JButton("Listar Hist\u00F3rico");
			btnHistorico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					TelaListarHistorico frame = new TelaListarHistorico();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
					
				}
			});
			btnHistorico.setRolloverIcon(new ImageIcon(TelaAreaDoUsuario.class.getResource("/imagens/fundo_2.jpg")));
			btnHistorico.setIcon(new ImageIcon(TelaAreaDoUsuario.class.getResource("/imagens/fundo_1.jpg")));
			btnHistorico.setHorizontalTextPosition(SwingConstants.CENTER);
			btnHistorico.setForeground(Color.WHITE);
			btnHistorico.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnHistorico.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			btnHistorico.setBounds(400, 270, 150, 28);
			contentPanel.add(btnHistorico);
		}
	}
}
