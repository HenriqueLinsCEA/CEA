package controller;

import java.util.InputMismatchException;

public class ValidarCnpj {

	public static boolean isCNPJ(String CNPJ) {
		
		    if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") || 
				CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
				CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
				CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
				CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
			(CNPJ.length() != 14)) return(false);

		char dig13, dig14; 
		int sm, i, r, num, peso;

		try {
			sm = 0; peso = 13; 
			for (i=0; i<12; i++) { 

				num = (int)(CNPJ.charAt(i) - 48); 
				sm = sm + (num * peso); 
				peso = peso - 1;
				}

			 r = 14 - (sm % 14);
			 if ((r == 13) || (r == 14)){
			 dig13 = '0';
			} else {
			
			dig13 = (char)(r + 48); 

			}
			 
			 sm = 0;
			 peso = 14;
			 for(i=0; i<13; i++) {
				 num = (int)(CNPJ.charAt(i) - 48);
				 sm = sm + (num * peso);
				 peso = peso - 1;
				 
			 }
			
			 r = 14 - (sm % 14);
			 if ((r == 13) || (r == 14)){
				 
				 dig14 = '0';
				 
			 }else{
				 
				 dig14 = (char)(r + 48);
				 
			 }

			 if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13))){
				
				 return(true);
				 
			 } else{
				 
				 return(false);
				 
			 }
			 
		} catch (InputMismatchException erro) {

			 return(false);	
		}
	}
	
	public static String imprimeCPF(String CNPJ) {
		
		return(CNPJ.substring(0, 1) + "." + CNPJ.substring(2, 4) + "." + "." + CNPJ.substring(5, 7) + "/" +

		CNPJ.substring(8, 11) + "-" + CNPJ.substring(12,13));
	
}
	
}
