package impressao;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import controller.Cliente;

public class ControleImpressao {

	

	
	public static void criarPdf(String nome, String cpf) throws IOException {

		Document documento = new Document(PageSize.ID_1, 10, 10, 50, 30);
		
					
			try {
				
			Font f = new Font(FontFamily.HELVETICA, 10);	
				
			PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream("codigo.pdf"));
			documento.open();
			
			Paragraph p1 = new Paragraph(nome.toUpperCase(), f);
			p1.setAlignment(Element.ALIGN_CENTER);
			documento.add(p1);
			
			PdfContentByte cb = writer.getDirectContent();
			
			Barcode39 code39 = new Barcode39();
			code39.setBarHeight(30);
			//code39.setN(4);
			code39.setCode(Cliente.removerMascara(cpf));
			
			Image image39 = Image.getInstance(code39.createImageWithBarcode(cb, null, null));
			image39.scaleAbsolute(180, 50);
			Paragraph p2 = new Paragraph(new Chunk(image39, 0, -60));
			p2.setAlignment(Element.ALIGN_CENTER);
			documento.add(p2);
			
			
		

		}

			 catch(DocumentException de) {
	              
	              JOptionPane.showMessageDialog(null, de);
	              
	          }
	          catch(IOException ioe) {
	             
	              JOptionPane.showMessageDialog(null, ioe);
	          }
	          
			documento.close();
			
			visualisar();
			
	      }   


	public static void visualisar(){
		
		File pdf = new File("codigo.pdf");  
		try {  
		  Desktop.getDesktop().open(pdf);  
		} catch(Exception ex) {  
		  ex.printStackTrace();  
		  JOptionPane.showMessageDialog(null, "Erro no Desktop: " + ex);  
		}  

		
		
	}


}
