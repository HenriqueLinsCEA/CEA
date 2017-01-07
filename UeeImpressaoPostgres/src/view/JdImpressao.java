package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Carteira;
import controller.ConsultaCarteira;

public class JdImpressao extends JDialog {
	private JTextField tfNomeAluno;
	private JTextField tfInstituicao;
	private JTextField tfCurso;
	private JTextField tfMatricula;
	private JTextField tfDataNascimento;
	private JTextField tfRG;
	private JButton btnRefazer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JdImpressao dialog = new JdImpressao();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
	public JdImpressao() {
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						JdImpressao.class
								.getResource("/images/techvan_transparente_pequena.png")));
		setTitle("Carteira UEE");
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);

		tfNomeAluno = new JTextField();
		tfNomeAluno.setBorder(null);
		tfNomeAluno.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfNomeAluno.setBounds(253, 152, 400, 35);
		getContentPane().add(tfNomeAluno);
		tfNomeAluno.setColumns(10);

		tfInstituicao = new JTextField();
		tfInstituicao.setBorder(null);
		tfInstituicao.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfInstituicao.setColumns(10);
		tfInstituicao.setBounds(253, 205, 400, 35);
		getContentPane().add(tfInstituicao);

		tfCurso = new JTextField();
		tfCurso.setBorder(null);
		tfCurso.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfCurso.setColumns(10);
		tfCurso.setBounds(253, 258, 400, 35);
		getContentPane().add(tfCurso);

		tfMatricula = new JTextField();
		tfMatricula.setBorder(null);
		tfMatricula.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfMatricula.setColumns(10);
		tfMatricula.setBounds(253, 312, 197, 35);
		getContentPane().add(tfMatricula);

		tfDataNascimento = new JTextField();
		tfDataNascimento.setBorder(null);
		tfDataNascimento.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfDataNascimento.setColumns(10);
		tfDataNascimento.setBounds(456, 312, 197, 35);
		getContentPane().add(tfDataNascimento);

		tfRG = new JTextField();
		tfRG.setBorder(null);
		tfRG.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfRG.setColumns(10);
		tfRG.setBounds(253, 367, 197, 35);
		getContentPane().add(tfRG);

		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tfNomeAluno.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite o nome do Aluno");

					tfNomeAluno.getFocusCycleRootAncestor();

				} else if (tfInstituicao.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite o nome da  Instituicao de  Ensino");

					tfInstituicao.getFocusCycleRootAncestor();

				} else if (tfCurso.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite o nome do Curso");

					tfCurso.getFocusCycleRootAncestor();

				} else if (tfMatricula.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite a Matrícula do Aluno");

					tfMatricula.getFocusCycleRootAncestor();

				} else if (tfDataNascimento.getText().equals("")) {

					JOptionPane.showMessageDialog(null,
							"Digite a Data de Nascimento do Aluno");

					tfDataNascimento.getFocusCycleRootAncestor();

				} else if (tfRG.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Digite o RG do Aluno");

					tfRG.getFocusCycleRootAncestor();

				} else {

					impressao.ControleImpressao.imp(tfNomeAluno.getText()
							.toUpperCase(), tfInstituicao.getText()
							.toUpperCase(), tfCurso.getText().toUpperCase());

					int id_carteira = new controller.ControleMetodosCarteira().inserirDadosCarteira(new Carteira(
							tfNomeAluno.getText().toUpperCase(), tfInstituicao
									.getText().toUpperCase(), tfCurso.getText()
									.toUpperCase(), tfMatricula.getText(),
							tfDataNascimento.getText(), tfRG.getText()));

					if (id_carteira == -1) {

						/*
						 * JOptionPane.showMessageDialog(null,
						 * "Não foi possível cadastrar a carteira");
						 */

					} else {

						/*
						 * JOptionPane.showMessageDialog(null,
						 * "Carteira cadastrada com Sucesso!!");
						 */

						String motivo = "1 via";

						int id_consulta = new controller.ControleMetodosConsultaCarteira()
								.inserirConsultaCarteira(new ConsultaCarteira(
										tfNomeAluno.getText().toUpperCase(),
										tfInstituicao.getText().toUpperCase(),
										tfCurso.getText().toUpperCase(), motivo
												.toUpperCase(),
										JfPrincipal.logado.getNome()
												.toUpperCase(),
										JfPrincipal.dataAtual,
										JfPrincipal.horaAtual));

						if (id_consulta == -1) {

							/*
							 * JOptionPane.showMessageDialog(null,
							 * "Não foi possível cadastrar a consulta");
							 */

						} else {

							/*
							 * JOptionPane.showMessageDialog(null,
							 * "consulta cadastrada com Sucesso!!");
							 */

						}

						tfNomeAluno.setText("");
						tfInstituicao.setText("");
						tfCurso.setText("");
						tfMatricula.setText("");
						tfDataNascimento.setText("");
						tfRG.setText("");

					}

				}

			}
		});
		btnImprimir.setBounds(489, 367, 161, 47);
		getContentPane().add(btnImprimir);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JdImpressao.class
				.getResource("/images/FRENTE_4.png")));
		lblNewLabel.setBounds(0, 0, 686, 426);
		getContentPane().add(lblNewLabel);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();

			}
		});
		btnSair.setBounds(582, 437, 71, 27);
		getContentPane().add(btnSair);

		btnRefazer = new JButton("Refazer");
		btnRefazer.setBounds(421, 437, 70, 27);
		getContentPane().add(btnRefazer);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(39, 437, 372, 24);
		getContentPane().add(comboBox);

		JButton btnMotivo = new JButton("Motivo");
		btnMotivo.setBounds(501, 437, 71, 27);
		getContentPane().add(btnMotivo);

	}
}
