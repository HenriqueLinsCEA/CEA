package impressao;

import java.awt.Font;  
import java.awt.FontMetrics;  
import java.awt.Graphics;  
import java.awt.Graphics2D;  
import java.awt.Rectangle;  
import java.awt.geom.Rectangle2D;  
import java.awt.print.PageFormat;  
import java.awt.print.Printable;  
import java.awt.print.PrinterException;  
import java.util.ArrayList;  
import java.util.List;  
import java.util.regex.Pattern;  
  
import javax.swing.JPanel;  
  
public class ImprimeFormula extends JPanel implements Printable{  
      
    private int x = 0;  
    private int y = 80;  
    private int qtdLines =0;  
    private int lines = 0;  
    private int auxY = 0;  
    private int auxX = 0;  
    private int alturaDaLinha = 0;  
    double alturaPagina =0 ;  
    private static int quebraDePagina[];  
    private String linhas[];  
    private String a, c;  
    private Graphics2D comp;  
    private int posicao=0;  
    private static List<Integer> posicoes = new ArrayList<Integer>();  
      
    public ImprimeFormula(String a){  
        this.a = a;  
        a = a.replaceAll(Pattern.quote(".0 "),"");  
    }  
      
    public int calculaLinhas(){  
        int retorno = 0;  
          
        int i = 0;  
        while(i<a.toCharArray().length){  
            if((a.charAt(i) == '$')||(a.charAt(i) == ';')){  
                retorno++;  
                posicoes.add(i);  
            }  
              
            i++;  
        }  
          
        return retorno;  
    }  
  
  
    public void paintComponent(Graphics componente){  
//      Graphics2D comp = (Graphics2D) componente;  
        comp = (Graphics2D) componente;  
          
        Font f = new Font("Arial", Font.PLAIN, 15);  
        Font exp = new Font ("Arial", Font.PLAIN, 8);  
        comp.setFont(f);  
        Font flecha = new Font("Arial", Font.BOLD, 20);  
          
        comp.drawString("-- R E S P O S T A --", 200, 15);  
          
        /* 
         * Sinais 
         * ^ = expoente (sobe a letra e muda a fonte) 
         * ~ = cai expoente (desce a letra e retorna a fonte original) 
         * $ = muda a linha 
         * # = tabular em oito espacos 
         * ; = criar barra de fração 
         */  
//      String a = "P(5,0) = (9,0) ^ 5,0 ~ * (e) ^ -9,0 ~ ;" +  
//                                      "##5,0! $" +  
//      "\nP(5,0) = 0,000123410 * 0,000123410;" +  
//                          "###120,0$" +   
//  
//       "\nP(5,0) = 0,0607";  
  
//      String a = "P(5.0) = (9.0) ^ 5.0~ * (e)^  (-9.0)~ ; ##(5.0!)$P(5.0) = 0,000123410 * 0,000123410;##120.0$P(5.0) = 0,0607";  
          
//      a = a.repslaceAll(Pattern.quote(",0 "), "");  
//      char texto[] = a.toCharArray();  
          
        int i =0;  
        c = "";  
        FontMetrics fm = getFontMetrics(f);  
          
//      while(i<texto.length){  
        while(i<a.length()){  
//          System.out.println(i);  
            if(a.charAt(i) == '^'){  
            auxY = y;  
            y-=5;  
            comp.setFont(exp);  
            }else if(a.charAt(i) == '~'){  
                y = auxY;  
                comp.setFont(f);  
            }else if(a.charAt(i) == '$'){  
                comp.setFont(flecha);  
                  
//              comp.drawString(" =>",fm.stringWidth(c) + 150,y-10);  
                y += 20;  
                auxY = c.length();  
                c = "";  
                comp.setFont(f);  
            }else if(a.charAt(i) == '#'){  
                c += "        ";  
            }else if(a.charAt(i) == ';'){  
                auxX = c.length();  
                  
                Rectangle2D.Float background = new Rectangle.Float(0, y+3, fm.stringWidth(c), 2);  
                comp.fill(background);  
                  
                y += 23;  
                auxY = c.length();  
                c = "";  
  
            }else{                
                comp.drawString(String.valueOf(a.charAt(i)),x + fm.stringWidth(c),y);  
//              comp.drawString(String.valueOf(a.charAt(i)),x + fm.stringWidth(c),10);  
            }  
            c += a.charAt(i);  
            i++;  
              
        }  
          
        alturaDaLinha = fm.getHeight();  
    }  
      
    public void setC(){  
        c = "";  
        y = 80;  
    }  
    public void desenhar(Graphics componente){  
//      Graphics2D comp = (Graphics2D) componente;  
        comp = (Graphics2D) componente;  
          
        Font f = new Font("Arial", Font.PLAIN, 15);  
        Font exp = new Font ("Arial", Font.PLAIN, 8);  
        comp.setFont(f);  
        Font flecha = new Font("Arial", Font.BOLD, 20);  
          
        comp.drawString("-- R E S P O S T A --", 200, 15);  
          
        /* 
         * Sinais 
         * ^ = expoente (sobe a letra e muda a fonte) 
         * ~ = cai expoente (desce a letra e retorna a fonte original) 
         * $ = muda a linha 
         * # = tabular em oito espacos 
         * ; = criar barra de fração 
         */  
//      String a = "P(5,0) = (9,0) ^ 5,0 ~ * (e) ^ -9,0 ~ ;" +  
//                                      "##5,0! $" +  
//      "\nP(5,0) = 0,000123410 * 0,000123410;" +  
//                          "###120,0$" +   
//  
//       "\nP(5,0) = 0,0607";  
  
//      String a = "P(5.0) = (9.0) ^ 5.0~ * (e)^  (-9.0)~ ; ##(5.0!)$P(5.0) = 0,000123410 * 0,000123410;##120.0$P(5.0) = 0,0607";  
          
//      a = a.repslaceAll(Pattern.quote(",0 "), "");  
//      char texto[] = a.toCharArray();  
          
        int i =0;  
        c = "";  
        FontMetrics fm = getFontMetrics(f);  
          
//      while(i<texto.length){  
        while(i<a.length()){  
//          System.out.println(i);  
            if(a.charAt(i) == '^'){  
            auxY = y;  
            y-=5;  
            comp.setFont(exp);  
            }else if(a.charAt(i) == '~'){  
                y = auxY;  
                comp.setFont(f);  
            }else if(a.charAt(i) == '$'){  
                comp.setFont(flecha);  
                  
//              comp.drawString(" =>",fm.stringWidth(c) + 150,y-10);  
                y += 20;  
                auxY = c.length();  
                c = "";  
                comp.setFont(f);  
            }else if(a.charAt(i) == '#'){  
                c += "        ";  
            }else if(a.charAt(i) == ';'){  
                auxX = c.length();  
                  
                Rectangle2D.Float background = new Rectangle.Float(0, y+3, fm.stringWidth(c), 2);  
                comp.fill(background);  
                  
                y += 23;  
                auxY = c.length();  
                c = "";  
  
            }else{                
                comp.drawString(String.valueOf(a.charAt(i)),x + fm.stringWidth(c),y);  
//              comp.drawString(String.valueOf(a.charAt(i)),x + fm.stringWidth(c),10);  
            }  
            c += a.charAt(i);  
            i++;  
        }  
    }  
  
  
    public void desenhar(Graphics componente, String a, int pag){  
//      Graphics2D comp = (Graphics2D) componente;  
        comp = (Graphics2D) componente;  
          
        Font f = new Font("Arial", Font.PLAIN, 15);  
        Font exp = new Font ("Arial", Font.PLAIN, 8);  
        comp.setFont(f);  
        Font flecha = new Font("Arial", Font.BOLD, 20);  
          
        comp.drawString("-- R E S P O S T A  p. " + (pag + 1) + "--", 200, 15);  
          
        /* 
         * Sinais 
         * ^ = expoente (sobe a letra e muda a fonte) 
         * ~ = cai expoente (desce a letra e retorna a fonte original) 
         * $ = muda a linha 
         * # = tabular em oito espacos 
         * ; = criar barra de fração 
         */  
//      String a = "P(5,0) = (9,0) ^ 5,0 ~ * (e) ^ -9,0 ~ ;" +  
//                                      "##5,0! $" +  
//      "\nP(5,0) = 0,000123410 * 0,000123410;" +  
//                          "###120,0$" +   
//  
//       "\nP(5,0) = 0,0607";  
  
//      String a = "P(5.0) = (9.0) ^ 5.0~ * (e)^  (-9.0)~ ; ##(5.0!)$P(5.0) = 0,000123410 * 0,000123410;##120.0$P(5.0) = 0,0607";  
          
//      a = a.repslaceAll(Pattern.quote(",0 "), "");  
//      char texto[] = a.toCharArray();  
          
        int i =0;  
        c = "";  
        FontMetrics fm = getFontMetrics(f);  
          
        int tamanhoY = fm.getHeight();  
          
//      while(i<texto.length){  
        while(i<a.length()){  
//          System.out.println(i);  
            if(a.charAt(i) == '^'){  
            auxY = y;  
            y-=5;  
            comp.setFont(exp);  
            }else if(a.charAt(i) == '~'){  
                y = auxY;  
                comp.setFont(f);  
            }else if(a.charAt(i) == '$'){  
                comp.setFont(flecha);  
                  
//              comp.drawString(" =>",fm.stringWidth(c) + 150,y-10);  
//              y += 20;  
                y += tamanhoY;   
                auxY = c.length();  
                c = "";  
                comp.setFont(f);  
            }else if(a.charAt(i) == '#'){  
                c += "        ";  
            }else if(a.charAt(i) == ';'){  
                auxX = c.length();  
                  
                Rectangle2D.Float background = new Rectangle.Float(0, y+3, fm.stringWidth(c), 2);  
                comp.fill(background);  
                  
//              y += 23;  
                y += tamanhoY;  
                auxY = c.length();  
                c = "";  
  
            }else{                
                comp.drawString(String.valueOf(a.charAt(i)),x + fm.stringWidth(c),y);  
//              comp.drawString(String.valueOf(a.charAt(i)),x + fm.stringWidth(c),10);  
            }  
            c += a.charAt(i);  
            i++;  
        }  
    }  
  
  
    public int calculaNumPages(PageFormat  pf){  
          
        alturaPagina = pf.getImageableHeight()*0.7/* - 100*/;  
        int qtdLines = calculaLinhas();  
        int qtdDeLinhaPorPagina = (int)alturaPagina/alturaDaLinha;  
//      System.out.println("Qtd de linhas por página: " + qtdDeLinhaPorPagina);  
//      System.out.println("Qtd de linha do texto: " + qtdLines);  
//        
        int qtdQuebrasDePagina = qtdLines/qtdDeLinhaPorPagina;  
//      pageIndex += 1;  
//      System.out.println("Qtd de quebras de página: " + qtdQuebrasDePagina);  
          
        return qtdQuebrasDePagina;  
  
    }  
  
      
    public int print( Graphics arg0, PageFormat pf, int page)  
            throws PrinterException {  
//      if(page>=1)  
//          return Printable.NO_SUCH_PAGE;  
//        
//      Graphics2D g2 = (Graphics2D) arg0;  
//      g2.translate(100,150);  
//        
//      desenhar(g2);  
//      setC();  
//      return Printable.PAGE_EXISTS;  
//      pageIndex = qtdPaginas(pf);  
          
        System.out.println("Altura da LInha: " + alturaDaLinha);  
//      dividir(a);  
        alturaPagina = pf.getImageableHeight()*0.70 /* - 100*/;  
//      System.out.println("Altura da página: " + alturaPagina);  
        int qtdLines = calculaLinhas();  
        int qtdDeLinhaPorPagina = ((int)alturaPagina/alturaDaLinha);  
//      System.out.println("Qtd de linhas por página: " + qtdDeLinhaPorPagina);  
//      System.out.println("Qtd de linha do texto: " + qtdLines);  
          
        int qtdQuebrasDePagina = qtdLines/qtdDeLinhaPorPagina;  
//      pageIndex += 1;  
        System.out.println("Qtd de quebras de página: " + qtdQuebrasDePagina);  
        System.out.println("Qtd de paginas: " + page);  
          
        quebraDePagina = new int[qtdQuebrasDePagina];  
          
        for(int b = 0; b<qtdQuebrasDePagina; b++){  
            quebraDePagina[b] = (b+1) * qtdDeLinhaPorPagina;  
        }  
          
        if(page>qtdQuebrasDePagina)  
            return Printable.NO_SUCH_PAGE;  
          
        Graphics2D g2 = (Graphics2D) arg0;  
//      g2 = (Graphics2D)arg0;  
        g2.translate(pf.getImageableX(),pf.getImageableY());  
//      g2 = comp;  
//      comp.translate(pf.getImageableX(),pf.getImageableY());  
          
          
//      desenhar(g2);  
  
//      int y = 0;   
//        int start = (pageIndex == 0) ? 0 : quebraDePagina[pageIndex-1];  
//        int end   = (pageIndex == quebraDePagina.length)  
//                         ? linhas.length : quebraDePagina[pageIndex];  
//        for (int line=start; line<end; line++) {  
//            y += alturaDaLinha;  
////            g.drawString(textLines[line], 0, y);  
//            desenhar(linhas[line], g2);  
//        }  
//  
////        /* tell the caller that this page is part of the printed document */  
////        return PAGE_EXISTS;  
  
//      int start = 0;  
//      if(page > 0)           
//          start = posicoes.get(quebraDePagina[page-2]);  
//      int end = posicoes.get(quebraDePagina[page-1]);  
//      if(page == quebraDePagina.length){  
//          end = posicoes.get(1);  
//      }  
//      System.out.println("Start: " + start);  
//      System.out.println("end: " + end);  
//      System.out.println("pagina: " + page);  
          
//      for(int i=start; i<end; i++){  
//          desenhar(g2);  
          
        int w = 0;  
          
        if(posicao > qtdQuebrasDePagina)  
            posicao = 0;  
              
          
//      int start = 0;  
//      if((posicao>0)&&(posicao<=qtdQuebrasDePagina)){  
////            start = quebraDePagina[posicao-1];  
//          start = posicoes.get(quebraDePagina[posicao-1]);  
//      }  
////        if(posicao == qtdQuebrasDePagina){  
////            start = quebraDePagina[posicao];  
////        }  
//        
//      int end = a.length();  
//      if((qtdQuebrasDePagina>0)&&(posicao<qtdQuebrasDePagina)){  
////        end = quebraDePagina[posicao];  
//      end = posicoes.get(quebraDePagina[posicao]);  
//      }  
          
        int start = 0;  
        if((page>0)&&(page<=qtdQuebrasDePagina)){  
//          start = quebraDePagina[posicao-1];  
            start = posicoes.get(quebraDePagina[page-1]);  
        }  
//      if(posicao == qtdQuebrasDePagina){  
//          start = quebraDePagina[posicao];  
//      }  
          
        int end = a.length();  
        if((qtdQuebrasDePagina>0)&&(page<qtdQuebrasDePagina)){  
//      end = quebraDePagina[posicao];  
        end = posicoes.get(quebraDePagina[page]);  
        }  
  
          
          
//      end = 2;  
        String aux = a.substring(start, end);  
        System.out.println("aki 1 + " + aux);  
//      for(int i = 0; i<qtdQuebrasDePagina;){  
            desenhar(g2, aux, page);  
//          desenhar(aux);  
//      }  
              
//          System.out.println(linhas[i]);  
//          System.out.println(i);  
//      }  
          
          
          
//      System.out.println("start: " + start);  
//      System.err.println("END: " + end);  
//        
//      desenhar(g2);  
        setC();  
          
//      posicao++;  
        return Printable.PAGE_EXISTS;  
}  
  
    }     
