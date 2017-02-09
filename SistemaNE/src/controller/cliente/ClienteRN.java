package controller.cliente;

import javax.swing.text.MaskFormatter;

public class ClienteRN {
	
	public void CadastrarCliente(Cliente cliente) {
		
		ClienteDAO clienteDAO = new ClienteDAO();
	    clienteDAO.insereCliente(cliente);
		
	}
	
	public static MaskFormatter CNPJ(String Mascara) {

		MaskFormatter F_Mascara = new MaskFormatter();
		try {
			F_Mascara.setMask("##.###.###/####-##"); // Atribui a mascara
			F_Mascara.setPlaceholderCharacter(' '); // Caracter para
													// preencimento
		} catch (Exception excecao) {
			excecao.printStackTrace();
		}
		return F_Mascara;
	}
	
	public static MaskFormatter InscriacaoEstadual(String Mascara) {

		MaskFormatter F_Mascara = new MaskFormatter();
		try {
			F_Mascara.setMask("##.#.###.####"); // Atribui a mascara
			F_Mascara.setPlaceholderCharacter(' '); // Caracter para
													// preencimento
		} catch (Exception excecao) {
			excecao.printStackTrace();
		}
		return F_Mascara;
	}

	public static MaskFormatter TelefoneFixo(String Mascara) {

		MaskFormatter F_Mascara = new MaskFormatter();
		try {
			F_Mascara.setMask("(##) ####-####"); // Atribui a mascara
			F_Mascara.setPlaceholderCharacter(' '); // Caracter para
													// preencimento
		} catch (Exception excecao) {
			excecao.printStackTrace();
		}
		return F_Mascara;
	}

	public static MaskFormatter TelefoneCelular(String Mascara) {

		MaskFormatter F_Mascara = new MaskFormatter();
		try {
			F_Mascara.setMask("(##) #####-####"); // Atribui a mascara
			F_Mascara.setPlaceholderCharacter(' '); // Caracter para
													// preencimento
		} catch (Exception excecao) {
			excecao.printStackTrace();
		}
		return F_Mascara;
	}

	public static MaskFormatter CEP(String Mascara) {

		MaskFormatter F_Mascara = new MaskFormatter();
		try {
			F_Mascara.setMask("#####-###"); // Atribui a mascara
			F_Mascara.setPlaceholderCharacter(' '); // Caracter para
													// preencimento
		} catch (Exception excecao) {
			excecao.printStackTrace();
		}
		return F_Mascara;
	}

	

}
