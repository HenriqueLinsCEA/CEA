package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import model.ClienteDao;
import model.HistoricoDao;
import controller.ConfiguracaoPontos;
import controller.Historico;
import controller.MaxLengthTextDocument;

import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class TelaAdicionarPontos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfValorCompras;
	private JLabel lblSaldoPontos;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			TelaAdicionarPontos dialog = new TelaAdicionarPontos();
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
	public TelaAdicionarPontos() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				TelaAdicionarPontos.class.getResource("/imagens/dinheiro.gif")));
		setModal(true);
		setResizable(false);
		setTitle("Pontos");
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		final JButton btnConfimar = new JButton("Confirmar");
		btnConfimar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnConfimar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if (tfValorCompras.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite um valor no campo");
					
					tfValorCompras.requestFocus();

				} else if (Integer.parseInt(tfValorCompras.getText()) == 0) {

					JOptionPane.showMessageDialog(null,
							"Digite um valor maior que Zero");

					tfValorCompras.setText("");
					
					tfValorCompras.requestFocus();

				} else {
				
				
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja adicionar Pontos?");
				
				if (resposta == 0){
					
					
					int soma = ConfiguracaoPontos.adicionarPontos(TelaPrincipal.localizado.getPontos(),
							Integer.parseInt(tfValorCompras.getText()));
					
					
					TelaPrincipal.localizado.setPontos(soma);

					ClienteDao clienteDao = new ClienteDao();
					clienteDao.adicionarPontos(TelaPrincipal.localizado);

					lblSaldoPontos.setText(String
							.valueOf(TelaPrincipal.localizado.getPontos()));

					
					
					String transacao = "Adicionar";
					
					Date data = new Date();
					long hora = System.currentTimeMillis();
					
					Historico historico = new Historico(TelaPrincipal.logado
							.getNome().toUpperCase(), TelaPrincipal.logado
							.getCpf(), TelaPrincipal.localizado.getNome()
							.toUpperCase(),
							TelaPrincipal.localizado.getCpf(), 
							transacao, Integer
									.parseInt(tfValorCompras.getText()),
							TelaPrincipal.localizado.getPontos(),
							new java.sql.Date(data.getTime()), new java.sql.Time(hora));
					
					HistoricoDao historicoDao = new HistoricoDao();
					historicoDao.inserirHistorico(historico);

					dispose();
					
					tfValorCompras.setText("");

					
				} else if (resposta == 1){ 	
					
				JOptionPane.showMessageDialog(null, "Não desejo adicionar Pontos");
	
				tfValorCompras.setText("");
				tfValorCompras.requestFocus();

				
				} else{
					
					tfValorCompras.setText("");
					tfValorCompras.requestFocus();
					
				}
				
				
				
				
				}

			
			}
		});

		JLabel lbUsuarioLogado = new JLabel("Usu\u00E1rio Logado: ");
		lbUsuarioLogado.setForeground(Color.ORANGE);
		lbUsuarioLogado.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbUsuarioLogado.setBounds(107, 21, 137, 28);
		contentPanel.add(lbUsuarioLogado);

		JLabel lblUsuarioLogado = new JLabel((String) null);
		lblUsuarioLogado.setForeground(Color.ORANGE);
		lblUsuarioLogado.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuarioLogado.setBounds(251, 21, 222, 28);
		lblUsuarioLogado.setText(TelaPrincipal.logado.getNome());
		contentPanel.add(lblUsuarioLogado);

		btnConfimar.setRolloverIcon(new ImageIcon(TelaAdicionarPontos.class
				.getResource("/imagens/fundo_2.jpg")));
		btnConfimar.setIcon(new ImageIcon(TelaAdicionarPontos.class
				.getResource("/imagens/fundo_1.jpg")));
		btnConfimar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConfimar.setForeground(Color.WHITE);
		btnConfimar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConfimar.setBounds(329, 312, 112, 28);
		getRootPane().setDefaultButton(btnConfimar);
		contentPanel.add(btnConfimar);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(45, 116, 506, 167);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblValorDasCompras = new JLabel("Valor das Compras");
		lblValorDasCompras.setBounds(49, 38, 138, 28);
		panel.add(lblValorDasCompras);
		lblValorDasCompras.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblSaldoDosPontos = new JLabel("Saldo dos Pontos");
		lblSaldoDosPontos.setBounds(273, 38, 138, 28);
		panel.add(lblSaldoDosPontos);
		lblSaldoDosPontos.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblSaldoPontos = new JLabel("0000");
		lblSaldoPontos.setBackground(Color.WHITE);
		lblSaldoPontos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblSaldoPontos.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaldoPontos.setForeground(Color.RED);
		lblSaldoPontos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSaldoPontos.setBounds(273, 69, 178, 47);
		lblSaldoPontos.setText(String.valueOf(TelaPrincipal.localizado
				.getPontos()));
		panel.add(lblSaldoPontos);

		tfValorCompras = new JTextField();
		tfValorCompras.setHorizontalAlignment(SwingConstants.CENTER);
		tfValorCompras.setFont(new Font("Tahoma", Font.BOLD, 20));
		tfValorCompras.setBounds(48, 69, 178, 47);
		panel.add(tfValorCompras);
		tfValorCompras.setColumns(10);

		tfValorCompras.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {

				String caracteres = "0987654321";

				if (!caracteres.contains(ev.getKeyChar() + "")) {

					ev.consume();

				}

			}
		});

		MaxLengthTextDocument maxLength_2 = new MaxLengthTextDocument();
		maxLength_2.setMaxChars(7);
		tfValorCompras.setDocument(maxLength_2);

		JButton button_1 = new JButton("Cancelar");
		button_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		button_1.setRolloverIcon(new ImageIcon(TelaAdicionarPontos.class
				.getResource("/imagens/fundo_2.jpg")));
		button_1.setIcon(new ImageIcon(TelaAdicionarPontos.class
				.getResource("/imagens/fundo_1.jpg")));
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_1.setBounds(451, 312, 100, 28);
		contentPanel.add(button_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(TelaAdicionarPontos.class.getResource("/imagens/dinheiro2.png")));
		lblNewLabel.setBounds(513, 0, 75, 69);
		contentPanel.add(lblNewLabel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaAdicionarPontos.class
				.getResource("/imagens/fundo_1.jpg")));
		label.setBounds(0, 0, 600, 69);
		contentPanel.add(label);
		
		JLabel lblAdicionarPontos = new JLabel("Adicionar Pontos");
		lblAdicionarPontos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdicionarPontos.setBounds(45, 76, 204, 38);
		contentPanel.add(lblAdicionarPontos);
	}
}
