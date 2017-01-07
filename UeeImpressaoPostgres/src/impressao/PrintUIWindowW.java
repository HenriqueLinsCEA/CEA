package impressao;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

//Esta classe implementa a interface Printable, permitindo que possa ser impressa por um PrinterJob.  
public class PrintUIWindowW implements Printable, ActionListener {  

 // Inst�ncia do JFrame que ser� impresso.  
 JFrame frameToPrint;  

 // M�todo implementado da interface Printable  
 public int print(Graphics g, PageFormat pf, int page) throws  
                                                     PrinterException {  

     if (page > 0) { /* We have only one page, and 'page' is zero-based */  
         return NO_SUCH_PAGE;  
     }  

     /* User (0,0) is typically outside the imageable area, so we must 
      * translate by the X and Y values in the PageFormat to avoid clipping 
      */  
     Graphics2D g2d = (Graphics2D)g;  
     g2d.translate(pf.getImageableX(), pf.getImageableY());  

     /* Now print the window and its visible contents */  
     frameToPrint.printAll(g); // Obs.: O exemplo usa JFrame para ser impresso, mas o m�todo printAll � de java.awt.Component, portanto pode adaptar o exemplo para trabalhar com outros componentes al�m do JFrame.  

     /* tell the caller that this page is part of the printed document */  
     return PAGE_EXISTS;  
 }  

 public void actionPerformed(ActionEvent e) {  
      // instancia um PrinterJob.  
      PrinterJob job = PrinterJob.getPrinterJob();  

      // seta este objeto como o Printable a ser impresso pelo PrinterJob.  
      job.setPrintable(this);  

      // o m�todo printDialog() exibe o di�logo de impress�o, que permite selecionar impressora, qtde de p�ginas, etc. Se tudo der certo na configura��o da impressora, o retorno ser� true.  
      boolean ok = job.printDialog();  

      if (ok) { // verifica se o resultado foi ok.  
          try {  
               job.print(); // Chama o m�todo print de PrinterJob, que vai chamar o m�todo print que foi implementado acima j� passando os par�metros necess�rios.  
          } catch (PrinterException ex) {  
           /* The job did not successfully complete */  
          }  
      }  
 }  

 // Construtor que recebe o Frame a ser impresso.  
 public PrintUIWindow(JFrame f) {  
     frameToPrint = f;  
 }  
}  