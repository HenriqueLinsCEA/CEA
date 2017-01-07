package controller;

import java.util.List;

import model.UsuarioDao;

public class ControleMetodosUsuario {

	public static Usuario login(String login, String senha) {

		Usuario usuario = new Usuario();
		usuario = new UsuarioDao().login(login, senha);

		return usuario;

	}

	public static List<Usuario> listarUsuario() {

		List<Usuario> listaUsuario = new UsuarioDao().listarDadosUsuario();

		return listaUsuario;

	}

	public int  cadastrarUsuario(Usuario usuario){
		
		int id_usuario = new UsuarioDao().inserirDadosUsuario(usuario);
		
		return id_usuario;
				
	}
	
public static Usuario  pesquisarUsuario(int id_usuario){
		
		Usuario usuario = new UsuarioDao().pesquisarUsuario(id_usuario);
		
		return usuario;
				
	}

public static List<Usuario> pesquisarUsuariosMultiplosCampos(String campo, String pesquisa){
	
	
		List<Usuario> listaUsuario = new UsuarioDao().pesquisarUsuariosMultiplosCampos(campo, pesquisa);

		return listaUsuario;

}

}
