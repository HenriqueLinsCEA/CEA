package controller.usuario;

import javax.swing.text.MaskFormatter;

public class UsuarioRN {

	UsuarioDAO usuarioDAO = new UsuarioDAO();

public void CadastrarUsuario(Usuario usuario) {
		
		  usuarioDAO.insereUsuario(usuario);
		
	}

/*public List<controller.usuario.Usuario> ListarUsuario() {
	
	List<Usuario> listaUsuario = new UsuarioDAO().listarDadosUsuario();

	return listaUsuario;
	
}*/









	
	public static MaskFormatter CPF(String Mascara) {

		MaskFormatter F_Mascara = new MaskFormatter();
		try {
			F_Mascara.setMask("###.###.###-##"); // Atribui a mascara
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
	
	public static String removerMascara(String cpf) {
		return cpf.replaceAll("\\D", "");
	}

	

}
