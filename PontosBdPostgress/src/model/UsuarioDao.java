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
	
	public void inserirAdministrador(Usuario usuario) {

		String sql = "INSERT INTO usuarios (nome, tipo, cpf, login, senha) VALUES (?, ?, ?, ?, ?)";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
			
					
			declarar.setString(1, usuario.getNome());
			declarar.setString(2, usuario.getTipo());
			declarar.setString(3, usuario.getCpf());
			declarar.setString(4, usuario.getLogin());
			declarar.setString(5, usuario.getSenha());

			declarar.execute();
			declarar.close();

			JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");

		} catch (SQLException e) {

			

		}

	}
	

	public Usuario inserirDadosUsuario(Usuario usuario) {

		String sql = "INSERT INTO usuarios (nome, tipo, cpf, login, senha) VALUES (?, ?, ?, ?, ?)";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
			
						
			declarar.setString(1, usuario.getNome());
			declarar.setString(2, usuario.getTipo());
			declarar.setString(3, usuario.getCpf());
			declarar.setString(4, usuario.getLogin());
			declarar.setString(5, usuario.getSenha());

			declarar.execute();
			declarar.close();

			JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "CPF ou login em duplicidade");
			
			
			usuario.setNome(null);
			usuario.setTipo(null);
			usuario.setCpf(null);
			
			
			return usuario;

		}

		return usuario;
	}

	public void excluirUsuario(Usuario usuario) {

		String sql = "DELETE FROM usuarios WHERE id_usuario = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, usuario.getId_usuario());

			declarar.execute();
			declarar.close();

			JOptionPane.showMessageDialog(null,
					"Usuário excluído");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"Erro ao excluir Usuário");
		}

	}

	public void alterarDadosUsuario(Usuario usuario) {

		String sql = "UPDATE usuarios SET nome = ?, tipo = ?, cpf = ?, login = ?, senha = ?  WHERE id_usuario = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
			
			
			
			declarar.setString(1, usuario.getNome());
			declarar.setString(2, usuario.getTipo());
			declarar.setString(3, usuario.getCpf());
			declarar.setString(4, usuario.getLogin());
			declarar.setString(5, usuario.getSenha());
			declarar.setInt(6, usuario.getId_usuario());

			declarar.execute();
			declarar.close();

			JOptionPane.showMessageDialog(null, "Alteração Concluída com sucesso");

		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao tentar alterar os dados do usuario" + e);
		}

	}

	public void alterarNomeCPFUsuario(Usuario usuario) {

		String sql = "UPDATE usuarios SET nome = ?, cpf = ? WHERE id_usuario = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, usuario.getNome());
			declarar.setString(2, usuario.getCpf());
			declarar.setInt(3, usuario.getId_usuario());

			System.out.println(usuario);

			declarar.execute();
			declarar.close();

			JOptionPane.showMessageDialog(null, "Alteração Concluída com sucesso");

		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao tentar alterar os dados do usuario" + e);
		}

	}

	public Usuario pesquisarCpfUsuario(String cpf) {

		Usuario usuario = new Usuario();
		String sql = "SELECT * FROM usuarios WHERE cpf = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, cpf);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				usuario.setId_usuario(resultado.getInt("id_usuario"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setTipo(resultado.getString("tipo"));
				usuario.setCpf(resultado.getString("cpf"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));

			}

			resultado.close();
			declarar.close();

			return usuario;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return null;
	}

	public Usuario pesquisarNomeUsuario(String nome) {

		Usuario usuario = new Usuario();

		String sql = "SELECT * FROM usuarios WHERE nome = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, nome);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				usuario.setId_usuario(resultado.getInt("id_pessoas"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setTipo(resultado.getString("tipo"));
				usuario.setCpf(resultado.getString("cpf"));

			}

			resultado.close();
			declarar.close();

			return usuario;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return null;
	}

	public List<Usuario> mostrarDadosUsuario() {

		List<Usuario> ListaUsuario = new ArrayList<Usuario>();

		String sql = "SELECT * FROM usuarios";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				Usuario usuario = new Usuario();

				usuario.setId_usuario(resultado.getInt("id_usuario"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setTipo(resultado.getString("tipo"));
				usuario.setCpf(resultado.getString("cpf"));
				usuario.setLogin(resultado.getString("login"));

				ListaUsuario.add(usuario);

			}

			resultado.close();
			declarar.close();

			return ListaUsuario;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"Erro ao acessar a Tabela Usuários");

		}

		return null;

	}

	public Usuario login(String login, String senha) {

		Usuario usuario = new Usuario();
		String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, login);
			declarar.setString(2, senha);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				usuario.setId_usuario(resultado.getInt("id_usuario"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setTipo(resultado.getString("tipo"));
				usuario.setCpf(resultado.getString("cpf"));
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
	
	public String removerMascara(String str){  
	    return str.replaceAll("\\D", "");  
	}  
	
	public List<Usuario> pesquisarNome(String nome) {

		List<Usuario> ListaUsuario = new ArrayList<Usuario>();

		String sql = "SELECT * FROM usuarios WHERE nome like ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, nome + "%");
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				Usuario usuario = new Usuario();

				usuario.setId_usuario(resultado.getInt("id_usuario"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setTipo(resultado.getString("tipo"));
				usuario.setCpf(resultado.getString("cpf"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));

				
				ListaUsuario.add(usuario);

			}

			resultado.close();
			declarar.close();

			return ListaUsuario;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return null;
	}

	

}
