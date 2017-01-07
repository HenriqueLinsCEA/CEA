package view;

import java.io.File; 

import javax.swing.JFileChooser; 
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter; 
import javax.swing.filechooser.FileNameExtensionFilter; 

public class FileChooserDialog { 
   public static void main ( String [] args ) { 
     JFileChooser fileopen = new JFileChooser () ; 
     FileFilter filter = new FileNameExtensionFilter ( "jpg files" , "jpg" ) ; 
     fileopen.addChoosableFileFilter ( filter ) ; 

     int ret = fileopen.showDialog ( null, "Open file" ) ; 

     if ( ret == JFileChooser.APPROVE_OPTION ) { 
       File file = fileopen.getSelectedFile () ; 
       System.out.println ( file ) ;
       JOptionPane.showMessageDialog(null, file);
     } 
   } 
}