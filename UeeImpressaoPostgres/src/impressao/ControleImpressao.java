package impressao;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

/*import com.itextpdf.text.Document;
 import com.itextpdf.text.DocumentException;
 import com.itextpdf.text.Element;
 import com.itextpdf.text.Font;
 import com.itextpdf.text.Font.FontFamily;
 import com.itextpdf.text.PageSize;
 import com.itextpdf.text.Paragraph;
 import com.itextpdf.text.pdf.PdfWriter;*/

public class ControleImpressao extends javax.swing.JFrame implements Printable {
	
	JFrame frameToPrint;
	
	public static void imprimirCarteira(String nome, String instituicao,
			String curso) {

		PrinterJob job = PrinterJob.getPrinterJob();

		PageFormat pf = new PageFormat();
		//pf.getPaper().

		Paper p = new Paper();
		p.setImageableArea(-10.0f, -10.0f, 250f, 250f);

		pf.setOrientation(PageFormat.LANDSCAPE);
		pf.setPaper(p); // setando o papel

		job.setPrintable(null, pf);

		if (job.printDialog()) {
			try {
				job.print();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Falha ao imprimir!!!",
						"Atenção", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
		Graphics2D graphics2D = (Graphics2D) graphics;

		graphics2D.drawString("Renato Souza", 5, 10);

		return (PAGE_EXISTS);
	}

	/*
	 * public static void criarPdf(String nome, String instituicao, String
	 * curso) throws IOException {
	 * 
	 * Document documento = new Document(PageSize.ID_1, 10, 10, 50, 30);
	 * 
	 * try {
	 * 
	 * Font f = new Font(FontFamily.TIMES_ROMAN, 8);
	 * 
	 * PdfWriter writer = PdfWriter.getInstance(documento, new
	 * FileOutputStream("carteira.pdf")); documento.open();
	 * 
	 * Paragraph p1 = new Paragraph(nome.toUpperCase(), f);
	 * p1.setAlignment(Element.RECTANGLE); //
	 * p1.setAlignment(Element.ALIGN_LEFT);
	 * 
	 * Paragraph p2 = new Paragraph(instituicao.toUpperCase(), f);
	 * p2.setAlignment(Element.ALIGN_LEFT);
	 * 
	 * Paragraph p3 = new Paragraph(curso.toUpperCase(), f);
	 * p3.setAlignment(Element.ALIGN_LEFT);
	 * 
	 * documento.add(p1); documento.add(p2); documento.add(p3);
	 * 
	 * }
	 * 
	 * catch (DocumentException de) {
	 * 
	 * JOptionPane.showMessageDialog(null, de);
	 * 
	 * }
	 * 
	 * documento.close();
	 * 
	 * visualisar();
	 * 
	 * }
	 * 
	 * public static void visualisar() {
	 * 
	 * File pdf = new File("carteira.pdf"); try {
	 * Desktop.getDesktop().open(pdf); } catch (Exception ex) {
	 * ex.printStackTrace(); JOptionPane.showMessageDialog(null,
	 * "Erro no Desktop: " + ex); }
	 * 
	 * }
	 */

	public static void imp(String nome, String instituicao, String curso) {

		// cria um frame temporário, onde será desenhado o texto a ser impresso
		Frame f = new Frame();
		f.pack();

		// pega o Toolkit do Frame
		Toolkit tk = f.getToolkit();

		// Pega os serviços de impressão existentes no computador,
		// para que seja escolhida uma impressora.
		// Também pode ser uma impressora de rede
		PrintJob pj = tk.getPrintJob(f, "print", null);

		// Aqui se inicia a impressão

		Graphics g = pj.getGraphics();
		g.setFont(new Font("Arial", Font.BOLD, 10));
		g.drawString("Teste de impressão", 12, 30);
		g.drawString(nome, 200, 70);
		g.drawString(instituicao, 50, 95);
		g.drawString(curso, 50, 120);

		// libera os recursos gráficos
		g.dispose();
		// encerra a impressão
		pj.end();

		// desfaz o frame temporário
		f.dispose();
	}

	// public static int print2(Graphics g, PageFormat pf, int page, String
	// nome, String instituicao,String curso)
	public static int print2(Graphics g, PageFormat pf, int page, String nome,
			String instituicao, String curso) throws PrinterException {

		
		
		if (page > 0) { /* We have only one page, and 'page' is zero-based */
			return NO_SUCH_PAGE;
		}

		/*
		 * User (0,0) is typically outside the imageable area, so we must
		 * translate by the X and Y values in the PageFormat to avoid clipping
		 */
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(pf.getImageableX(), pf.getImageableY());

		/* Now we perform our rendering */
		g.drawString(nome, 100, 100);
		g.drawString(instituicao, 200, 100);
		g.drawString(curso, 200, 100);

		/* tell the caller that this page is part of the printed document */
		return PAGE_EXISTS;
	}

	public void actionPerformed1(ActionEvent e) {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(this);
		boolean ok = job.printDialog();
		if (ok) {
			try {
				job.print();
			} catch (PrinterException ex) {
				/* The job did not successfully complete */
			}
		}
	}

	public int print1(Graphics g, PageFormat pf, int page)
			throws PrinterException {

		if (page > 0) { /* We have only one page, and 'page' is zero-based */
			return NO_SUCH_PAGE;
		}

		/*
		 * User (0,0) is typically outside the imageable area, so we must
		 * translate by the X and Y values in the PageFormat to avoid clipping
		 */
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(pf.getImageableX(), pf.getImageableY());

		/* Now print the window and its visible contents */
		frameToPrint.printAll(g);

		/* tell the caller that this page is part of the printed document */
		return PAGE_EXISTS;
	}

	public void actionPerformed(ActionEvent e) {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(this);
		boolean ok = job.printDialog();
		if (ok) {
			try {
				job.print();
			} catch (PrinterException ex) {
				/* The job did not successfully complete */
			}
		}
	}

	public ControleImpressao(JFrame f) {
		frameToPrint = f;
	}

	public static void main(String args[]) {
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		JFrame f = new JFrame("Print UI Example");
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		JTextArea text = new JTextArea(50, 20);
		for (int i = 1; i <= 50; i++) {
			text.append("Line " + i + "\n");
		}
		JScrollPane pane = new JScrollPane(text);
		pane.setPreferredSize(new Dimension(250, 200));
		f.add("Center", pane);
		JButton printButton = new JButton("Print This Window");
		printButton.addActionListener(new Imp3(f));
		f.add("South", printButton);
		f.pack();
		f.setVisible(true);
	}

}
