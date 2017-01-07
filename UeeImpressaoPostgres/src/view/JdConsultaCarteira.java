package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import controller.ConsultaCarteira;
import controller.ControleMetodosConsultaCarteira;
import controller.Usuario;
import javax.swing.DebugGraphics;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;

public class JdConsultaCarteira extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tbConsultaCarteira;
	private JTextField tfPesquisa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JdConsultaCarteira dialog = new JdConsultaCarteira();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JdConsultaCarteira() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				JdConsultaCarteira.class
						.getResource("/images/techvan_transparente.png")));
		setTitle("Consultar Carteiras");
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JComboBox cbCampoPesquisa = new JComboBox();
		cbCampoPesquisa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel) tbConsultaCarteira
						.getModel();

				model.setNumRows(0);
								
			}
		});
		
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(42, 113, 697, 282);
				contentPanel.add(scrollPane);
				scrollPane.setBackground(Color.WHITE);
				
						tbConsultaCarteira = new JTable();
						tbConsultaCarteira.setBackground(Color.WHITE);
						tbConsultaCarteira.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
						tbConsultaCarteira.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"Nome", "Institui\u00E7\u00E3o", "Curso", "Situa\u00E7\u00E3o", "Usu\u00E1rio Logado", "Data", "Hora"
							}
						) {
							boolean[] columnEditables = new boolean[] {
								false, false, false, false, false, false, false
							};
							public boolean isCellEditable(int row, int column) {
								return columnEditables[column];
							}
						});
						tbConsultaCarteira.getColumnModel().getColumn(0).setPreferredWidth(154);
						tbConsultaCarteira.getColumnModel().getColumn(1).setPreferredWidth(173);
						tbConsultaCarteira.getColumnModel().getColumn(2).setPreferredWidth(173);
						tbConsultaCarteira.getColumnModel().getColumn(3).setPreferredWidth(108);
						tbConsultaCarteira.getColumnModel().getColumn(4).setPreferredWidth(167);
						tbConsultaCarteira.getColumnModel().getColumn(5).setPreferredWidth(106);
						tbConsultaCarteira.getColumnModel().getColumn(6).setPreferredWidth(102);
						scrollPane.setViewportView(tbConsultaCarteira);
		cbCampoPesquisa.setEditable(true);
		cbCampoPesquisa.setModel(new DefaultComboBoxModel(new String[] {
				"Selecione o campo para pesquisa", "Nome",
				"Institui\u00E7\u00E3o", "Curso", "Situa\u00E7\u00E3o",
				"Usu\u00E1rio Logado", "Data" }));
		cbCampoPesquisa.setBounds(42, 46, 210, 22);
		contentPanel.add(cbCampoPesquisa);
		{
			JButton btnPesquisa = new JButton("");
			btnPesquisa.setFocusable(false);
			btnPesquisa.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPesquisa.setBorderPainted(false);
			btnPesquisa.setRolloverIcon(new ImageIcon(JdConsultaCarteira.class
					.getResource("/images/views-48_2.png")));
			btnPesquisa.setIcon(new ImageIcon(JdConsultaCarteira.class
					.getResource("/images/views-48.png")));
			btnPesquisa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (cbCampoPesquisa.getSelectedItem().equals(
							"Selecione o campo para pesquisa")) {

						JOptionPane.showMessageDialog(null,
								"Selecione um campo para pesquisar");

					} else if (tfPesquisa.getText().equals("")) {

						JOptionPane.showMessageDialog(null,
								"Digite no campo para pesquisar");

					} else {

						List<ConsultaCarteira> listaConsulta = new ControleMetodosConsultaCarteira()
								.pesquisarMultiplosCampos(String
										.valueOf(cbCampoPesquisa
												.getSelectedItem()), tfPesquisa
										.getText().toUpperCase());

						if (listaConsulta.isEmpty()) {

							JOptionPane.showMessageDialog(null,
									"Não foi possível encontrar um resultado");

						} else {

							DefaultTableModel model = (DefaultTableModel) tbConsultaCarteira
									.getModel();

							model.setNumRows(0);

							for (ConsultaCarteira c : listaConsulta) {

								Object[] linha = { c.getNome(),
										c.getInstituicao(), c.getCurso(),
										c.getMotivo(), c.getUsuarioLogado(),
										c.getData(), c.getHora() };

								model.addRow(linha);

							}

						}
					}
				}

			});
			btnPesquisa.setBounds(405, 28, 59, 57);
			contentPanel.add(btnPesquisa);
			btnPesquisa.setActionCommand("OK");
			getRootPane().setDefaultButton(btnPesquisa);
		}

		tfPesquisa = new JTextField();
		tfPesquisa.setBounds(274, 45, 130, 22);
		contentPanel.add(tfPesquisa);
		tfPesquisa.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						dispose();

					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
