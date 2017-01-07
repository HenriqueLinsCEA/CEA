package view;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TelaSelecionarArquivo extends JFrame {

	
	private static final long serialVersionUID = 1L;

	
	public static void main(String[] args) {
		
			
		JFileChooser escolherArquivo = new JFileChooser();
		

		FileFilter filtroExtensao = new FileNameExtensionFilter(".jpg", "jpg");
		escolherArquivo.addChoosableFileFilter(filtroExtensao);
		int retorno = escolherArquivo.showDialog(null, "Selecionar Arquivo");

		
		if (retorno == JFileChooser.APPROVE_OPTION) {

			File arquivo = escolherArquivo.getSelectedFile();
			escolherArquivo.setSelectedFile(arquivo);

			JOptionPane.showMessageDialog(null,  arquivo);

		}
		
		
	}

	
}