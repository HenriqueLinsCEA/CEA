package controller.login;

import java.util.ArrayList;
import java.util.List;

import controller.usuario.Usuario;

public class LoginRN {

	Usuario usuario;
	LoginDAO loginDAO = new LoginDAO();

	public Usuario login(String login, String senha) {
		
		usuario = loginDAO.login(login, senha);
		
		return usuario;

	}
	
	public List<Login> ListarLogin(){
		
		List<Login> listaLogin = new ArrayList<Login>();
		
		listaLogin = loginDAO.listarLogin();
		
		return listaLogin;
		
	}
	
	
	

}
