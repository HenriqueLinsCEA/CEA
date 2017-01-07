package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import model.ClienteDao;
import controller.Cliente;

public class TelaListarCliente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static JTable tabelaClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			TelaListarCliente dialog = new TelaListarCliente();
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
	@SuppressWarnings("serial")
	public TelaListarCliente() {
		setUndecorated(true);
		setTitle("Pontos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				TelaListarCliente.class.getResource("/imagens/dinheiro.gif")));
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			contentPanel.setLayout(null);

			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(507, 0, 87, 69);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setIcon(new ImageIcon(TelaListarCliente.class.getResource("/imagens/dinheiro2.png")));
			contentPanel.add(lblNewLabel);
			{
				JLabel lbUsuarioLogado = new JLabel("Usu\u00E1rio Logado: ");
				lbUsuarioLogado.setForeground(Color.ORANGE);
				lbUsuarioLogado.setFont(new Font("Tahoma", Font.BOLD, 16));
				lbUsuarioLogado.setBounds(107, 21, 137, 28);
				contentPanel.add(lbUsuarioLogado);
			}
			{
				JLabel lblUsuarioLogado = new JLabel("Usu\u00E1rio Logado");
				lblUsuarioLogado.setForeground(Color.ORANGE);
				lblUsuarioLogado.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblUsuarioLogado.setBounds(251, 21, 250, 28);
				lblUsuarioLogado.setText(TelaPrincipal.logado.getNome());
				
				contentPanel.add(lblUsuarioLogado);
			}
			{
				JLabel label = new JLabel("");
				label.setBounds(0, 0, 600, 69);
				label.setIcon(new ImageIcon(TelaListarCliente.class
						.getResource("/imagens/fundo_1.jpg")));
				contentPanel.add(label);
			}
		}
		{

			
			{

				{
					JButton btOk = new JButton("OK");
					btOk.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					btOk.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							dispose();
							
						}
					});
					btOk.setBounds(446, 330, 100, 28);
					getRootPane().setDefaultButton(btOk);

					btOk.setRolloverIcon(new ImageIcon(TelaListarCliente.class
							.getResource("/imagens/fundo_2.jpg")));
					btOk.setIcon(new ImageIcon(TelaListarCliente.class
							.getResource("/imagens/fundo_1.jpg")));
					btOk.setHorizontalTextPosition(SwingConstants.CENTER);
					btOk.setForeground(Color.WHITE);
					btOk.setFont(new Font("Tahoma", Font.BOLD, 13));
					getRootPane().setDefaultButton(btOk);
					
					contentPanel.add(btOk);
				}

			}
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.menu);
		scrollPane.setInheritsPopupMenu(true);
		scrollPane.setIgnoreRepaint(true);
		scrollPane.setBounds(55, 124, 491, 184);
		contentPanel.add(scrollPane);
		
		tabelaClientes = new JTable();
		tabelaClientes.setSelectionBackground(Color.ORANGE);
		tabelaClientes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tabelaClientes.setToolTipText("");
		tabelaClientes.setForeground(Color.BLACK);
		tabelaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaClientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "CPF", "Pontos"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelaClientes.getColumnModel().getColumn(0).setResizable(false);
		tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(200);
		tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(50);
		scrollPane.setViewportView(tabelaClientes);
		
		
		
		tabelaClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int posicao = tabelaClientes.getSelectedRow();
				
				TelaPrincipal.localizado.setCpf(TelaPrincipal.listaCliente.get(posicao).getCpf());
				
				TelaPrincipal.localizado = Cliente.localizarClientePeloCpf((TelaPrincipal.localizado.getCpf()));
				
						
				TelaMostrarCliente frame = new TelaMostrarCliente();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
		
				DefaultTableModel model = (DefaultTableModel) tabelaClientes
						.getModel();

				model.setNumRows(0);
				
				dispose();

				
			}
		});
		
		{
			JLabel lblTotalClientes = new JLabel("Total de Clientes: ");
			lblTotalClientes.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblTotalClientes.setBounds(55, 330, 152, 28);
			contentPanel.add(lblTotalClientes);
		}
		{
			
		}
			
		JLabel lblTotal = new JLabel("New label");
		lblTotal.setForeground(Color.RED);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotal.setBounds(209, 330, 87, 28);
		contentPanel.add(lblTotal);

			DefaultTableModel model = (DefaultTableModel) tabelaClientes.getModel();
			model.setNumRows(0);
			
			TelaPrincipal.listaCliente = new ClienteDao().mostrarDados();
			
			int quantidade = 0;
			
			for (Cliente c : TelaPrincipal.listaCliente) {
					
					quantidade ++;
					
					Object[] linha = { c.getNome(), c.getCpf(), c.getPontos()};
						
					model.addRow(linha);
					
					

			}

			lblTotal.setText(String.valueOf(quantidade));
			{
				JLabel lblTabelaClientes = new JLabel("Tabela Clientes");
				lblTabelaClientes.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblTabelaClientes.setBounds(55, 85, 137, 28);
				contentPanel.add(lblTabelaClientes);
			}
	}
	
	
			
}
