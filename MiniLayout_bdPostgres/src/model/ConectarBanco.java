package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConectarBanco {
	
	private static String HOST = "localhost";
	private static String PORTA = "5432";
	private static String LOGIN = "postgres";
	private static String SENHA = "1006";
	
	
	//private static final String URL = "jdbc:postgresql://localhost:5432/Layout";
	
	
	private static String URL = "jdbc:postgresql://"+ HOST +":"+ PORTA +"/LAYOUT";

	private static final String DRIVER = "org.postgresql.Driver";

	//private static final String LOGIN = "postgres";

	//private static final String SENHA = "1006";

	public static Connection getConnection() {
		
		URL = "jdbc:postgresql://"+ HOST +":"+ PORTA +"/LAYOUT";
		
		try {

			Class.forName(DRIVER);

			return DriverManager.getConnection(URL, LOGIN, SENHA);

		} catch (ClassNotFoundException e) {

			JOptionPane.showMessageDialog(null, "Erro de acesso" + e);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro de acesso SQL" + e);

			throw new RuntimeException(e);

		}
		return null;
	}
	
	public static Connection getConnectionTeste() {
		
		URL = "jdbc:postgresql://"+ HOST +":"+ PORTA +"/LAYOUT";

		try {

			Class.forName(DRIVER);
			
			
			if (!DriverManager.getConnection(URL, LOGIN, SENHA).equals(null)){
				
				JOptionPane.showMessageDialog(null, "Conectado ao Banco");
				
			}
			
			return DriverManager.getConnection(URL, LOGIN, SENHA);
			
			
		} catch (ClassNotFoundException e) {

			JOptionPane.showMessageDialog(null, "Erro de acesso" + e);
			
			return null;

		
		} catch (SQLException e) {

			
			JOptionPane.showMessageDialog(null, "Erro de acesso SQL" + e);
			
			return null;
			
		}
		
		
	}
	
	
	
	
	public static String getHOST() {
		return HOST;
	}

	public static void setHOST(String hOST) {
		HOST = hOST;
	}

	public static String getPORTA() {
		return PORTA;
	}

	public static void setPORTA(String pORTA) {
		PORTA = pORTA;
	}

	public static String getSENHA() {
		return SENHA;
	}

	public static void setSENHA(String sENHA) {
		SENHA = sENHA;
	}

	public static String getLOGIN() {
		return LOGIN;
	}

	public static void setLOGIN(String lOGIN) {
		LOGIN = lOGIN;
	}


}
