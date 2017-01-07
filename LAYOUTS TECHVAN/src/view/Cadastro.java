package view;

import javax.swing.JFrame;

public class Cadastro extends JFrame{
	
	public static void main(String [] args){
		
		JFrame frame = new Cadastro();
		frame.pack();
		frame.setBounds(0,0,800,600);
		frame.setResizable(false);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

}
