package controller;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.usuario.Usuario;
import view.JfTelaLogin;

public class IniciarAplicativoSistemaNE {

	public static Usuario logado = null;

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {

		new IniciarAplicativoSistemaNE().iniciar();

	}

	public void iniciar() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {

		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		JfTelaLogin frame = new JfTelaLogin();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}

}
