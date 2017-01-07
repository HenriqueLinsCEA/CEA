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
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				

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

		String sql = "INSERT INTO usuario (nome,  login, senha) VALUES (?, ?, ?) returning id_usuario ";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, usuario.getNome());
			declarar.setString(2, usuario.getLogin());
			declarar.setString(3, usuario.getSenha());
			
									
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				id_usuario = resultado.getInt("id_usuario");
										
			}
			
		
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

			JOptionPane.showMessageDialog(null, "Usuário excluído");

		} catch (SQLException e) {

			e.printStackTrace();

			JOptionPane.showMessageDialog(null, "Erro ao excluir Usuário");
		}

	}

	public int alterarDadosUsuario (Usuario usuario) {
		
		int id_usuario=-1;
		
		String sql = "UPDATE usuario SET nome = ?,  login = ?, senha = ?  WHERE id_usuario = ?  returning id_usuario";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, usuario.getNome());
			declarar.setString(2, usuario.getLogin());
			declarar.setString(3, usuario.getSenha());
			declarar.setInt(4, usuario.getId_usuario());
			
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				id_usuario = resultado.getInt("id_usuario");
										
			}

			declarar.execute();
			declarar.close();
											
			return id_usuario;

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null,
					"Erro " + e);
		}
		
		return id_usuario;
		
	}
	
	public void excluirDadosUsuario(Usuario usuario) {

		String sql = "DELETE FROM usuario WHERE id_usuario = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, usuario.getId_usuario());

			declarar.execute();
			declarar.close();

			JOptionPane.showMessageDialog(null,
					"Usuário excluído do Banco de Dados");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"Erro o Usuario não foi excluído do Banco de Dados");
		}
		
	}


	public List<Usuario> listarDadosUsuario() {

		List<Usuario> ListaUsuario = new ArrayList<Usuario>();

		String sql = "SELECT * FROM usuario ORDER BY login ASC";
		//String sql = "SELECT * FROM usuario";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				Usuario usuario = new Usuario();

				usuario.setId_usuario(resultado.getInt("id_usuario"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("Senha"));
				
				ListaUsuario.add(usuario);
				
			}

			resultado.close();
			declarar.close();

			return ListaUsuario;

		} catch (SQLException e) {
			
			e.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"Erro ao acessar a Tabela Usuários");

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
				usuario.setLogin(resultado.getString("login"));
							
			}

			resultado.close();
			declarar.close();

			return usuario;

		} catch (SQLException e) {
			
			e.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"Erro ao acessar a Tabela Usuários");

		}

		return usuario;

	}

	public List<Usuario> pesquisarUsuariosMultiplosCampos(String campo,	String pesquisa) {
		
		List<Usuario> ListaUsuario = new ArrayList<Usuario>();

			
		String sql = "SELECT * FROM usuario WHERE " + campo + " like ? ";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
			
			declarar.setString(1, pesquisa + "%");
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				Usuario usuario = new Usuario();

				usuario.setId_usuario(resultado.getInt("id_usuario"));
				usuario.setNome(resultado.getString("nome_usuario"));
				usuario.setLogin(resultado.getString("login"));
				
				ListaUsuario.add(usuario);

			}

			resultado.close();
			declarar.close();

			return ListaUsuario;

		} catch (SQLException e) {
			
			e.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"Erro ao acessar a Tabela Usuários");

		}

		return null;

	}
	
public List<Usuario> pesquisarUsuario(String nome) {
		
		List<Usuario> ListaUsuario = new ArrayList<Usuario>();
		
		
			
		String sql = "SELECT * FROM usuario WHERE nome like ? ";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
			
			declarar.setString(1, nome + "%");
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				Usuario usuario = new Usuario();

				usuario.setId_usuario(resultado.getInt("id_usuario"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				
				ListaUsuario.add(usuario);

			}

			resultado.close();
			declarar.close();

			return ListaUsuario;

		} catch (SQLException e) {
			
			e.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"Erro ao acessar a Tabela Usuários");

		}

		return null;

	}

}
