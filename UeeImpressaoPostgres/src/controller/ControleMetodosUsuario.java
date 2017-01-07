package controller;

import java.util.List;

import model.UsuarioDao;

public class ControleMetodosUsuario {

	public Usuario login(String login, String senha) {

		Usuario usuario = new Usuario();
		usuario = new UsuarioDao().login(login, senha);

		return usuario;

	}

	public List<Usuario> listarUsuario() {

		List<Usuario> listaUsuario = new UsuarioDao().listarDadosUsuario();

		return listaUsuario;

	}

	public int cadastrarUsuario(Usuario usuario) {

		int id_usuario = new UsuarioDao().inserirDadosUsuario(usuario);

		return id_usuario;

	}

	public int alterarDadosUsuario(Usuario usuario) {

		int id_usuario = new UsuarioDao().alterarDadosUsuario(usuario);

		return id_usuario;

	}

	public void excluirDadosUsuario(Usuario usuario) {

		new UsuarioDao().excluirDadosUsuario(usuario);

	}

	public List<Usuario> pesquisarUsuario(String nome) {

		List<Usuario> listaUsuario = new UsuarioDao().pesquisarUsuario(nome);

		return listaUsuario;

	}

	public List<Usuario> pesquisarUsuariosMultiplosCampos(String campo,
			String pesquisa) {

		List<Usuario> listaUsuario = new UsuarioDao()
				.pesquisarUsuariosMultiplosCampos(campo, pesquisa);

		return listaUsuario;

	}

}
