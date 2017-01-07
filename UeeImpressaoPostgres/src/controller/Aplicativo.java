	package controller;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.JfLogin;

public class Aplicativo {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		// TODO Auto-generated method stub
		UIManager
		.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		JfLogin frame = new JfLogin();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
	}

}
