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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import model.ConfiguracaoPontosDao;
import controller.ConfiguracaoPontos;
import controller.MaxLengthTextDocument;

public class TelaConfigurarPontos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfConfiguracaoPonto;
	private JTextField tfConfiguracaoValor;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			TelaConfigurarPontos dialog = new TelaConfigurarPontos();
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
	public TelaConfigurarPontos() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				TelaConfigurarPontos.class
						.getResource("/imagens/dinheiro.gif")));
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
		btnConfimar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int resposta = JOptionPane.showConfirmDialog(null, "Deseja alterar o valor de troca dos Pontos?");
				
				if (resposta == 0){
				
				new model.ConfiguracaoPontosDao();
				ConfiguracaoPontos inicial = ConfiguracaoPontosDao.confirmarPontos();
				inicial.setValor(Integer.parseInt(tfConfiguracaoValor.getText()));
								
				model.ConfiguracaoPontosDao.alterarValor(inicial);

				new Thread(new Runnable() {
					@Override
					public void run() {

						ConfiguracaoPontos inicial = ConfiguracaoPontosDao.confirmarPontos();
						tfConfiguracaoValor.setText(String.valueOf(inicial.getValor()));
					
					}
				}).start();
				
				dispose();
				
				} else if (resposta == 1){ 	
					
					
					JOptionPane.showMessageDialog(null, "Não Desejo alterar o valor de troca dos Pontos");
					
					dispose();
					
				}
			}
		});
		btnConfimar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
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

		btnConfimar.setRolloverIcon(new ImageIcon(TelaConfigurarPontos.class
				.getResource("/imagens/fundo_2.jpg")));
		btnConfimar.setIcon(new ImageIcon(TelaConfigurarPontos.class
				.getResource("/imagens/fundo_1.jpg")));
		btnConfimar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConfimar.setForeground(Color.WHITE);
		btnConfimar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConfimar.setBounds(329, 312, 112, 28);
		getRootPane().setDefaultButton(btnConfimar);
		contentPanel.add(btnConfimar);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(45, 116, 506, 167);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblConfiguracaoPonto = new JLabel("Pontos");
		lblConfiguracaoPonto.setBounds(49, 38, 138, 28);
		panel.add(lblConfiguracaoPonto);
		lblConfiguracaoPonto.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblConfiguaracaoValor = new JLabel("Valor em dinheiro");
		lblConfiguaracaoValor.setBounds(273, 38, 138, 28);
		panel.add(lblConfiguaracaoValor);
		lblConfiguaracaoValor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		tfConfiguracaoPonto = new JTextField();
		tfConfiguracaoPonto.setBackground(Color.WHITE);
		tfConfiguracaoPonto.setEditable(false);
		tfConfiguracaoPonto.setFont(new Font("Tahoma", Font.BOLD, 20));
		tfConfiguracaoPonto.setHorizontalAlignment(SwingConstants.CENTER);
		tfConfiguracaoPonto.setForeground(Color.RED);
		tfConfiguracaoPonto.setBounds(49, 77, 150, 40);
		tfConfiguracaoPonto.setColumns(10);
		tfConfiguracaoPonto.setText(String.valueOf(model.ConfiguracaoPontosDao.confirmarPontos().getPontos()));
		panel.add(tfConfiguracaoPonto);

		tfConfiguracaoValor = new JTextField();
		tfConfiguracaoValor.setHorizontalAlignment(SwingConstants.CENTER);
		tfConfiguracaoValor.setForeground(Color.RED);
		tfConfiguracaoValor.setFont(new Font("Tahoma", Font.BOLD, 20));
		tfConfiguracaoValor.setColumns(10);
		tfConfiguracaoValor.setBounds(273, 77, 150, 40);
		tfConfiguracaoValor.setText(String.valueOf(model.ConfiguracaoPontosDao.confirmarPontos().getValor()));
		panel.add(tfConfiguracaoValor);
		
				JLabel lblX = new JLabel("X");
				lblX.setHorizontalAlignment(SwingConstants.CENTER);
				lblX.setBounds(197, 79, 77, 38);
				panel.add(lblX);
				lblX.setFont(new Font("Tahoma", Font.BOLD, 20));

		

		MaxLengthTextDocument maxLength_2 = new MaxLengthTextDocument();
		maxLength_2.setMaxChars(7);

		JButton button_1 = new JButton("Cancelar");
		button_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		button_1.setRolloverIcon(new ImageIcon(TelaConfigurarPontos.class
				.getResource("/imagens/fundo_2.jpg")));
		button_1.setIcon(new ImageIcon(TelaConfigurarPontos.class
				.getResource("/imagens/fundo_1.jpg")));
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_1.setBounds(451, 312, 100, 28);
		contentPanel.add(button_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(TelaConfigurarPontos.class
				.getResource("/imagens/dinheiro2.png")));
		lblNewLabel.setBounds(513, 0, 75, 69);
		contentPanel.add(lblNewLabel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaConfigurarPontos.class
				.getResource("/imagens/fundo_1.jpg")));
		label.setBounds(0, 0, 600, 69);
		contentPanel.add(label);
	}
}
