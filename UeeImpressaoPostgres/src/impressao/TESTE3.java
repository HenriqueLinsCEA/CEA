package impressao;

import java.awt.Graphics;  
import java.awt.Graphics2D;  
import java.awt.print.PageFormat;  
import java.awt.print.Paper;  
import java.awt.print.Printable;  
import java.awt.print.PrinterJob;  
import javax.swing.*;  
  
public class TESTE3 extends javax.swing.JFrame implements Printable  
{  
  
public TESTE3()  
{  
  initComponents();  
}  
  
// <editor-fold defaultstate="collapsed" desc="Generated Code">  
private void initComponents() {  
  
  bImprimir = new javax.swing.JButton();  
  
  setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);  
  setTitle("Imprimir");  
  
  bImprimir.setText("Imprimir");  
  bImprimir.addActionListener(new java.awt.event.ActionListener() {  
   public void actionPerformed(java.awt.event.ActionEvent evt) {  
    bImprimirActionPerformed(evt);  
   }  
  });  
  
  javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());  
  getContentPane().setLayout(layout);  
  layout.setHorizontalGroup(  
   layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)  
   .addGroup(layout.createSequentialGroup()  
    .addGap(157, 157, 157)  
    .addComponent(bImprimir)  
    .addContainerGap(172, Short.MAX_VALUE))  
  );  
  layout.setVerticalGroup(  
   layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)  
   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()  
    .addContainerGap(158, Short.MAX_VALUE)  
    .addComponent(bImprimir)  
    .addGap(119, 119, 119))  
  );  
  
  pack();  
}// </editor-fold>  
  
private void bImprimirActionPerformed(java.awt.event.ActionEvent evt)                                           
{                                               
PrinterJob job = PrinterJob.getPrinterJob();  
              
PageFormat pf = new PageFormat();  
  
Paper p = new Paper();  
p.setImageableArea(-10.0f,-10.0f,250f,250f);   
  
pf.setOrientation(pf.LANDSCAPE);  
pf.setPaper(p); //setando o papel  
  
job.setPrintable(this,pf);  
if(job.printDialog())  
{  
  try  
  {  
   job.print();  
  }     
  catch(Exception e)  
  {  
   JOptionPane.showMessageDialog(null,"Falha ao imprimir!!!","Atenção",JOptionPane.WARNING_MESSAGE);     
  }  
}                    
}  
  
public int print (Graphics graphics, PageFormat pageFormat, int pageIndex) {  
  Graphics2D graphics2D = (Graphics2D) graphics;  
    
  graphics2D.drawString("Renato Souza",5,10);  
  
  return (PAGE_EXISTS);  
}   
  
public static void main(String args[])  
{  
  java.awt.EventQueue.invokeLater(new Runnable()  
  {  
   public void run()  
   {  
    new TESTE3().setVisible(true);  
   }  
  });  
}  
  
// Variables declaration - do not modify  
private javax.swing.JButton bImprimir;  
// End of variables declaration  
  
}  