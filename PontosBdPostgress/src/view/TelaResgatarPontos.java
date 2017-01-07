package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import model.ClienteDao;
import model.HistoricoDao;
import controller.Historico;
import controller.MaxLengthTextDocument;

public class TelaResgatarPontos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfPontosResgatar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					TelaResgatarPontos dialog = new TelaResgatarPontos();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public TelaResgatarPontos() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				TelaResgatarPontos.class.getResource("/imagens/dinheiro.gif")));
		setResizable(false);
		setTitle("Pontos");
		setModal(true);
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(null);
		((JComponent) getContentPane()).setBorder(new BevelBorder(
				BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK,
				Color.BLACK));

		JLabel label_1 = new JLabel("Usu\u00E1rio Logado: ");
		label_1.setBorder(null);
		label_1.setForeground(Color.ORANGE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(107, 21, 137, 28);
		getContentPane().add(label_1);

		JLabel lblUsuarioLogado = new JLabel((String) null);
		lblUsuarioLogado.setBorder(null);
		lblUsuarioLogado.setForeground(Color.ORANGE);
		lblUsuarioLogado.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuarioLogado.setBounds(250, 21, 222, 28);
		lblUsuarioLogado.setText(TelaPrincipal.logado.getNome());

		getContentPane().add(lblUsuarioLogado);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(507, 0, 87, 69);
		label_3.setIcon(new ImageIcon(TelaResgatarPontos.class
				.getResource("/imagens/dinheiro2.png")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(label_3);

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 600, 69);
		label.setIcon(new ImageIcon(TelaResgatarPontos.class
				.getResource("/imagens/fundo_1.jpg")));
		getContentPane().add(label);

		JPanel panel = new JPanel();
		panel.setBounds(45, 116, 506, 167);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel);

		JLabel lblSaldoRestante = new JLabel("Saldo Pontos");
		lblSaldoRestante.setHorizontalAlignment(SwingConstants.LEFT);
		lblSaldoRestante.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSaldoRestante.setFont(new Font("Ebrima", Font.PLAIN, 14));
		lblSaldoRestante.setBounds(48, 36, 128, 28);
		panel.add(lblSaldoRestante);

		JLabel lblPontosResgatar = new JLabel("Pontos \u00E0 Resgatar");
		lblPontosResgatar.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPontosResgatar.setHorizontalAlignment(SwingConstants.LEFT);
		lblPontosResgatar.setFont(new Font("Ebrima", Font.PLAIN, 14));
		lblPontosResgatar.setBounds(273, 36, 128, 28);
		panel.add(lblPontosResgatar);

		JLabel lblSaldoPontos = new JLabel("0000");
		lblSaldoPontos.setBorder(UIManager.getBorder("TextField.border"));
		lblSaldoPontos.setForeground(Color.RED);
		lblSaldoPontos.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaldoPontos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSaldoPontos.setBounds(48, 69, 178, 47);
		lblSaldoPontos.setText(String.valueOf(TelaPrincipal.localizado
				.getPontos()));
		panel.add(lblSaldoPontos);
		
		final JButton btConfirmar = new JButton("Confimar");
		btConfirmar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		
		
		btConfirmar.setBounds(329, 312, 112, 28);
		getRootPane().setDefaultButton(btConfirmar);

		MaxLengthTextDocument maxLength_2 = new MaxLengthTextDocument();
		maxLength_2.setMaxChars(7);
		
		tfPontosResgatar = new JTextField();
		tfPontosResgatar.setHorizontalAlignment(SwingConstants.CENTER);
		tfPontosResgatar.setFont(new Font("Tahoma", Font.BOLD, 20));
		tfPontosResgatar.setBounds(273, 69, 178, 47);
		panel.add(tfPontosResgatar);
		tfPontosResgatar.setColumns(10);

		
		
		
		
		btConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tfPontosResgatar.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite um valor no campo");

					tfPontosResgatar.requestFocus();

				} else if (TelaPrincipal.localizado.getPontos() < Integer
						.parseInt(tfPontosResgatar.getText())) {

					JOptionPane
							.showMessageDialog(
									null,
									"Não foi possível fazer a transação.\nO número de pontos é menor do que o solicitado.");

					tfPontosResgatar.setText("");
					tfPontosResgatar.requestFocus();

				} else if (Integer.parseInt(tfPontosResgatar.getText()) <= 0) {

					JOptionPane.showMessageDialog(null,
							"Digite um valor maior que Zero");

					tfPontosResgatar.setText("");
					tfPontosResgatar.requestFocus();

				} else {

					int resposta = JOptionPane.showConfirmDialog(null,
							"Deseja resgatar Pontos?");

					if (resposta == 0) {

						int subtração = TelaPrincipal.localizado.getPontos()
								- Integer.parseInt(tfPontosResgatar.getText());
						TelaPrincipal.localizado.setPontos(subtração);

						ClienteDao clienteDao = new ClienteDao();
						clienteDao.alterarPontos(TelaPrincipal.localizado);
						tfPontosResgatar.requestFocus();

						dispose();

						
						String transacao = "Subtrair";
						
						Date data = new Date();
						long hora = System.currentTimeMillis();
						
						Historico historico = new Historico(TelaPrincipal.logado
								.getNome().toUpperCase(), TelaPrincipal.logado
								.getCpf(), TelaPrincipal.localizado.getNome()
								.toUpperCase(),
								TelaPrincipal.localizado.getCpf(), 
								transacao, Integer
										.parseInt(tfPontosResgatar.getText()),
								TelaPrincipal.localizado.getPontos(),
								new java.sql.Date(data.getTime()), new java.sql.Time(hora));
						

						HistoricoDao historicoDao = new HistoricoDao();
						historicoDao.inserirHistorico(historico);
						
						


					} else if (resposta == 1) {

						JOptionPane.showMessageDialog(null,
								"Não desejo resgatar Pontos");

						tfPontosResgatar.setText("");
						tfPontosResgatar.requestFocus();

					} else {

						tfPontosResgatar.setText("");
						tfPontosResgatar.requestFocus();

					}

				}
			}
		});
		btConfirmar.setRolloverIcon(new ImageIcon(TelaResgatarPontos.class
				.getResource("/imagens/fundo_2.jpg")));
		btConfirmar.setIcon(new ImageIcon(TelaResgatarPontos.class
				.getResource("/imagens/fundo_1.jpg")));
		btConfirmar.setHorizontalTextPosition(SwingConstants.CENTER);
		btConfirmar.setForeground(Color.WHITE);
		btConfirmar.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		getContentPane().add(btConfirmar);

		JButton Cancelar = new JButton("Cancelar");
		Cancelar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		Cancelar.setBounds(451, 312, 100, 28);
		Cancelar.setRolloverIcon(new ImageIcon(TelaResgatarPontos.class
				.getResource("/imagens/fundo_2.jpg")));
		Cancelar.setIcon(new ImageIcon(TelaResgatarPontos.class
				.getResource("/imagens/fundo_1.jpg")));
		Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}

		});
		Cancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		Cancelar.setForeground(Color.WHITE);
		Cancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(Cancelar);

		JLabel lblResgatarPontos = new JLabel("Resgatar Pontos");
		lblResgatarPontos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblResgatarPontos.setBounds(45, 76, 204, 38);
		getContentPane().add(lblResgatarPontos);

	}
}
