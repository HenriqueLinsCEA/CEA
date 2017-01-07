package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;


	public class ConectarBanco {
		 
	    private static final String URL = 
	    	"jdbc:derby:Pontos;create=true;user=Pontos;password=1010";
	         
	    private static final String DRIVER =
	        "org.apache.derby.jdbc.EmbeddedDriver";
	 
	    public static Connection getConnection() {
	       
	        try {
	        	
	            Class.forName(DRIVER);
	            
	            return DriverManager.getConnection(URL);
	            
	           
	        } catch (ClassNotFoundException e) {

	            JOptionPane.showMessageDialog(null, e);
	            	            
	        } catch (SQLException e) {
	        	
	        	  JOptionPane.showMessageDialog(null, e);

	        }
	        return null;
	    }
	
	
	
}
