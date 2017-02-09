package controller.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.usuario.Usuario;
import model.ConectarBanco;

public class LoginDAO {

	ConectarBanco conectarBanco = new ConectarBanco();
	Connection conexao = conectarBanco.geraConexao();

	Usuario usuario = new Usuario();
	Login login = new Login();

	public Usuario login(String login, String senha) {

		PreparedStatement insereST = null;
		ResultSet rs = null;
		String sql = "";

		try {

			sql = "SELECT * FROM login WHERE login = ? AND senha = ?";

			insereST = conexao.prepareStatement(sql);
			insereST.setString(1, login);
			insereST.setString(2, senha);
			rs = insereST.executeQuery();

			while (rs.next()) {

				this.login.setId_login(rs.getInt("id_login"));
				this.login.setLogin(rs.getString("login"));
				this.login.setSenha(rs.getString("senha"));
				this.login.setNivelAcesso(rs.getString("nivelAcesso"));

			}

	
			sql = "SELECT * FROM usuario WHERE id_login = ? ";

			insereST = conexao.prepareStatement(sql);
			insereST.setInt(1, this.login.getId_login());
			rs = insereST.executeQuery();

			while (rs.next()) {

				this.usuario.setId_usuario(rs.getInt("id_usuario"));
				this.usuario.setNomeUsuario(rs.getString("nomeusuario"));
				this.usuario.setFuncaoUsuario(rs.getString("funcaousuario"));
				this.usuario.setCpf(rs.getString("cpf"));
				this.usuario.setTelefoneUsuario(rs.getString("telefoneusuario"));
				this.usuario.setEmailUsuario(rs.getString("emailusuario"));
				this.usuario.setStatusUsuario(rs.getString("statususuario"));
				this.usuario.setDataNascimento(rs.getDate("datanascimento"));
				this.usuario.setLogin(this.login);

			}

	
			rs.close();
			insereST.close();
			return usuario;

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e);

		}

		return usuario;

	}

	public List<Login> listarLogin() {

		List<Login> ListaLogin = new ArrayList<Login>();
		PreparedStatement insereST = null;
		ResultSet rs = null;
		Login login = new Login();
		login.setLogin("");
		ListaLogin.add(login);

		String sql = "";

		try {

			sql = "SELECT * FROM login ORDER BY login ASC";

			insereST = conexao.prepareStatement(sql);
			rs = insereST.executeQuery();

			while (rs.next()) {

				login = new Login();
				login.setLogin(rs.getString("login"));
				ListaLogin.add(login);

			}

			rs.close();
			insereST.close();

			return ListaLogin;

		} catch (SQLException e) {

			e.printStackTrace();

			JOptionPane.showMessageDialog(null, "Erro ao acessar a Tabela login");

		}

		return null;

	}

}
