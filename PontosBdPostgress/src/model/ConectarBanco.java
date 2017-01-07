package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;


	public class ConectarBanco {
		 
	    private static final String URL =  "jdbc:postgresql://localhost:5432/Pontos";
	         
	    private static final String DRIVER =  "org.postgresql.Driver";
	    
	    private static final String LOGIN = "postgres";
	    
	    private static final String SENHA = "1006";
	    
	 
	    public static Connection getConnection() {
	       
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
	
	
	
}
