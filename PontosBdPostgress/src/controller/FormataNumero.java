package controller;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Formata um campo de texto para receber apenas números
 *
 */
@SuppressWarnings("serial")
public class FormataNumero extends PlainDocument
{
	public final int NUMERO_DIGITOS_MAXIMO = 20; 
	
	public void insertString(int offs, String str, javax.swing.text.AttributeSet a) throws BadLocationException 
	{
		String texto = getText(0, getLength()); 
		
		for (int i = 0; i < str.length(); i++)
		{ 
			char c = str.charAt(i); 
			if (!Character.isDigit(c)) 
				return; 
		} 
				
		if(texto.length() < this.NUMERO_DIGITOS_MAXIMO)
		{
			super.remove(0, getLength()); 
			StringBuffer s = new StringBuffer(texto + str); 
		
			if (s.length() > 0 && s.charAt(0) == '0') 
				s.deleteCharAt(0);
			super.insertString(0, s.toString(), a);
		} 
	} 
	
	public void remove(int offset, int length) throws BadLocationException 
	{ 
		super.remove(offset, length); 
		String texto = getText(0, getLength()); 
		super.remove(0, getLength()); 
		insertString(0, texto, null); 
	}
}