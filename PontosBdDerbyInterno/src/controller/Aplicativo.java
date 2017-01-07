package controller;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.TelaLogin;

public class Aplicativo {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, java.sql.SQLException {
		
			
		Aplicativo novo = new Aplicativo();
		novo.iniciar();
		
		
	}
	
	public void iniciar(){
			
		
		ControleMetodos.criarTabelaUsuarios();
		ControleMetodos.criarTabelaClientes();
		ControleMetodos.criarTabelaHistoricoResgate();
		ControleMetodos.criarTabelaConfiguracaoPontos();
		ControleMetodos.inserirAdministrador();
		ControleMetodos.inserirConfiguracaoPontos();
				
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		TelaLogin frame = new TelaLogin();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	

}
