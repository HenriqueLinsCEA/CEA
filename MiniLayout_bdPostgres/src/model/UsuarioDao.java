package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.Usuario;

public class UsuarioDao {

	private Connection conexaoBanco;

	public UsuarioDao() {

		this.conexaoBanco = ConectarBanco.getConnection();

	}

	public Usuario login(String login, String senha) {

		Usuario usuario = new Usuario();
		String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, login);
			declarar.setString(2, senha);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				usuario.setId_usuario(resultado.getInt("id_usuario"));
				usuario.setNome(resultado.getString("nome_usuario"));
				usuario.setCpf(resultado.getString("cpf"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				usuario.setTipo(resultado.getString("tipo"));

			}

			resultado.close();
			declarar.close();

			return usuario;

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e);

		}

		return usuario;

	}

	public int inserirDadosUsuario(Usuario usuario) {

		int id_usuario=-1;

		String sql = "INSERT INTO usuario (nome_usuario, cpf,  login, senha, tipo) VALUES (?, ?, ?, ?, ?) returning id_usuario ";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, usuario.getNome());
			declarar.setString(2, usuario.getCpf());
			declarar.setString(3, usuario.getLogin());
			declarar.setString(4, usuario.getSenha());
			declarar.setString(5, usuario.getTipo());
									
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				id_usuario = resultado.getInt("id_usuario");
										
			}
			
			JOptionPane.showMessageDialog(null,
					"Usu�rio cadastrado com sucesso");
			
		
		
			declarar.close();
			
			return id_usuario ;

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro" + e);

		}
		
		return id_usuario;
	

	}

	public void excluirUsuario(Usuario usuario) {

		String sql = "DELETE FROM usuario WHERE id_usuario = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, usuario.getId_usuario());

			declarar.execute();
			declarar.close();

			JOptionPane.showMessageDialog(null, "Usu�rio exclu�do");

		} catch (SQLException e) {

			e.printStackTrace();

			JOptionPane.showMessageDialog(null, "Erro ao excluir Usu�rio");
		}

	}

	public void alterarDadosUsuario(Usuario usuario) {

		String sql = "UPDATE usuario SET nome = ?, cpf = ?, tipo = ?, login = ?, senha = ?  WHERE id_usuario = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, usuario.getNome());
			declarar.setString(2, usuario.getCpf());
			declarar.setString(3, usuario.getTipo());
			declarar.setString(4, usuario.getLogin());
			declarar.setString(5, usuario.getSenha());
			declarar.setInt(6, usuario.getId_usuario());

			declarar.execute();
			declarar.close();

			JOptionPane.showMessageDialog(null,
					"Altera��o conclu�da com sucesso");

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null,
					"Erro ao tentar alterar os dados do usu�rio" + e);
		}

	}

	public List<Usuario> listarDadosUsuario() {

		List<Usuario> ListaUsuario = new ArrayList<Usuario>();

		String sql = "SELECT * FROM usuario ORDER BY login ASC";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				Usuario usuario = new Usuario();

				usuario.setId_usuario(resultado.getInt("id_usuario"));
				usuario.setNome(resultado.getString("nome_usuario"));
				usuario.setCpf(resultado.getString("cpf"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setTipo(resultado.getString("tipo"));

				ListaUsuario.add(usuario);

			}

			resultado.close();
			declarar.close();

			return ListaUsuario;

		} catch (SQLException e) {
			
			e.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"Erro ao acessar a Tabela Usu�rios");

		}

		return null;

	}
	
	public Usuario pesquisarUsuario(int id_usuario) {

		Usuario usuario = new Usuario();

		String sql = "SELECT * FROM usuario";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {
				
				usuario.setId_usuario(resultado.getInt("id_usuario"));
				usuario.setNome(resultado.getString("nome_usuario"));
				usuario.setCpf(resultado.getString("cpf"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setTipo(resultado.getString("tipo"));
			
			}

			resultado.close();
			declarar.close();

			return usuario;

		} catch (SQLException e) {
			
			e.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"Erro ao acessar a Tabela Usu�rios");

		}

		return usuario;

	}

	public List<Usuario> pesquisarUsuariosMultiplosCampos(String campo,	String pesquisa) {
		
		List<Usuario> ListaUsuario = new ArrayList<Usuario>();

		//String sql = "SELECT * FROM usuario ORDER BY login ASC";
		
		String sql = "SELECT * FROM usuario WHERE " + campo + " like ? ";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
			
			declarar.setString(1, pesquisa + "%");
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				Usuario usuario = new Usuario();

				usuario.setId_usuario(resultado.getInt("id_usuario"));
				usuario.setNome(resultado.getString("nome_usuario"));
				usuario.setCpf(resultado.getString("cpf"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setTipo(resultado.getString("tipo"));

				ListaUsuario.add(usuario);

			}

			resultado.close();
			declarar.close();

			return ListaUsuario;

		} catch (SQLException e) {
			
			e.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"Erro ao acessar a Tabela Usu�rios");

		}

		return null;

	}

}
