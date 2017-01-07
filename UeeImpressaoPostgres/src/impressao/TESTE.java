package impressao;

import java.awt.Graphics;   
import java.awt.PrintJob;   
import java.awt.Toolkit;  
import java.awt.Font;   
import java.awt.Frame;    
  
public class TESTE {      
      
    public void imprimir() {     
      
    // cria um frame tempor�rio, onde ser�  desenhado  o texto a ser impresso     
   Frame f = new Frame();
   f.pack();      
      
    // pega o Toolkit do Frame     
    Toolkit tk = f.getToolkit();      
  
    // Pega os servi�os de impress�o existentes no computador,     
    // para que seja escolhida uma impressora.    
    // Tamb�m pode ser uma impressora de rede   
    PrintJob pj = tk.getPrintJob(f,  "print" , null);    
  
    // Aqui se inicia a impress�o   
    if (pj != null) {    
        Graphics g = pj.getGraphics();  
        g.setFont(new Font("Courier New",Font.PLAIN,12));    
        g.drawString( "Teste de impress�o" , 50, 30);   
        g.drawString( "linha 1, qwreqwreqwreqwerqwerasdfasgsdfbxcbvsdfgsdvsaewrtaert" , 50, 70);   
        g.drawString( "linha 2, qwreqwreqwreqwerqwerasdfasgsdfbxcbvsdfgsdvsaewrtaert" , 50, 95);  
        g.drawString( "linha 2, qwreqwreqwreqwerqwerasdfasgsdfbxcbvsdfgsdvsaewrtaert" , 50, 120);    
        g.drawString( "linha 2, qwreqwreqwreqwerqwerasdfasgsdfbxcbvsdfgsdvsaewrtaert" , 50, 145);    
        g.setFont(new Font("Courier New",Font.PLAIN,10));  
        g.drawString( "linha 2, qwreqwreqwreqwerqwerasdfasgsdfbxcbvsdfgsdvsaewrtaert" , 50, 170);   
        g.drawString( "linha 2, qwreqwreqwreqwerqwerasdfasgsdfbxcbvsdfgsdvsaewrtaert" , 50, 195);   
        g.drawString( "linha 2, qwreqwreqwreqwerqwerasdfasgsdfbxcbvsdfgsdvsaewrtaert" , 50, 220);   
        g.drawString( "linha 2, qwreqwreqwreqwerqwerasdfasgsdfbxcbvsdfgsdvsaewrtaert" , 50, 245);   
        //g.setFont(new Font("Courier New",Font.PLAIN,<img src="http://javafree.uol.com.br/forum/images/smiles/icon_cool.gif">);  
        g.drawString( "linha 2, qwreqwreqwreqwerqwerasdfasgsdfbxcbvsdfgsdvsaewrtaert" , 50, 270);   
        g.drawString( "linha 2, qwreqwreqwreqwerqwerasdfasgsdfbxcbvsdfgsdvsaewrtaert" , 50, 295);   
        g.drawString( "linha 2, qwreqwreqwreqwerqwerasdfasgsdfbxcbvsdfgsdvsaewrtaert" , 50, 320);   
        g.drawString( "linha 2, qwreqwreqwreqwerqwerasdfasgsdfbxcbvsdfgsdvsaewrtaert" , 50, 345);    
        g.drawString( "p�gina 1" , 500, 810);      
  
        // libera os recursos gr�ficos    
        g.dispose();      
        // encerra a impress�o    
        pj.end();   
    }    
  
    // desfaz o frame tempor�rio   
    f.dispose();   
    }  
    // M�todo main para teste    
    public static void main(String[] args) {     
   TESTE imp = new TESTE();      
    imp.imprimir();   
    }   
}  