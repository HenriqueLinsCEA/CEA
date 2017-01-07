package controller;

import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.CadastrarCliente;

public class Aplicativo {

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			Aplicativo novo = new Aplicativo();
			try {
				novo.inicio();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

	}

	public void inicio() throws IOException{
		
		
		Cliente importar = new Cliente();
		importar.ImportarClientes();
		
		CadastrarCliente frame = new CadastrarCliente();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		
		
	}
}
