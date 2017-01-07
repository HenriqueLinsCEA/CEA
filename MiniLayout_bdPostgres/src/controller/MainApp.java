package controller;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import view.JfLogin;

public class MainApp {
	
	public static Usuario logado = new Usuario();
		
	public static void main(String[] args) {
			
		new MainApp().iniciarApp();
		
	}
	
	public void iniciarApp(){
		
			
		try {
			
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			
			JfLogin frame = new JfLogin();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
						
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, e);
			
			
		}
	
		
		
		
	}

}
