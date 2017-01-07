package impressao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.IOException;

import javax.swing.JPanel;



public class printe extends JPanel implements Printable{  
	
String layoutPath;

public String getLayoutPath() {
	return layoutPath;
}

public void setLayoutPath(String path){  
    layoutPath = path;  
}  
  
public int print(Graphics graphics, PageFormat format, int pageIndex)  
throws PrinterException{  
    if(pageIndex>1){  
        return Printable.NO_SUCH_PAGE;  
    }  
    else{  
        Graphics2D g2d = (Graphics2D) graphics;  
		g2d.translate(format.getImageableX(), format.getImageableY());  
  
		g2d.setFont(new Font("Times", Font.PLAIN, 12));  
		g2d.setColor(Color.BLUE);  
  
		g2d.drawString("teste", 0, 0);  
        return Printable.PAGE_EXISTS;  
    }  
}  
}