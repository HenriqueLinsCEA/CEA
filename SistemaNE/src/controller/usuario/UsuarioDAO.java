package controller.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.ConectarBanco;

public class UsuarioDAO {

	ConectarBanco conectarBanco = new ConectarBanco();
	Connection conexao = conectarBanco.geraConexao();

	@SuppressWarnings("resource")
	public void insereUsuario(Usuario usuario) {

		PreparedStatement insereST = null;
		ResultSet rs = null;

		String sql = "";

		try {

			sql = "insert into endereco (logradouro, numero, complemento, bairro, cidade, uf, cep ) values(?,?,?,?,?,?,?)";

			insereST = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			insereST.setString(1, usuario.getEndereco().getLogradouro());
			insereST.setString(2, usuario.getEndereco().getNumero());
			insereST.setString(3, usuario.getEndereco().getComplemento());
			insereST.setString(4, usuario.getEndereco().getBairro());
			insereST.setString(5, usuario.getEndereco().getCidade());
			insereST.setString(6, usuario.getEndereco().getUf());
			insereST.setString(7, usuario.getEndereco().getCep());

			insereST.executeUpdate();

			// Recupera a id
			rs = insereST.getGeneratedKeys();
			int id_endereco = 0;
			if (rs.next()) {
				id_endereco = rs.getInt(1);
			}

			sql = "insert into login (login, senha, nivelacesso) values(?,?,?)";

			insereST = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			insereST.setString(1, usuario.getLogin().getLogin());
			insereST.setString(2, usuario.getLogin().getSenha());
			insereST.setString(3, usuario.getLogin().getNivelAcesso());

			insereST.executeUpdate();

			// Recupera a id
			rs = insereST.getGeneratedKeys();
			int id_login = 0;
			if (rs.next()) {
				id_login = rs.getInt(1);
			}

			sql = "insert into usuario (nomeusuario, funcaousuario, cpf, telefoneusuario, emailusuario,statususuario, datanascimento, id_endereco, id_login  ) values(?,?,?,?,?,?,?,?,?)";

			java.sql.Date dataSql = new java.sql.Date(usuario.getDataNascimento().getTime());

			insereST = conexao.prepareStatement(sql);
			insereST.setString(1, usuario.getNomeUsuario());
			insereST.setString(2, usuario.getFuncaoUsuario());
			insereST.setString(3, usuario.getCpf());
			insereST.setString(4, usuario.getTelefoneUsuario());
			insereST.setString(5, usuario.getEmailUsuario());
			insereST.setString(6, usuario.getStatusUsuario());
			insereST.setDate(7, dataSql);
			insereST.setInt(8, id_endereco);
			insereST.setInt(9, id_login);

			insereST.executeUpdate();

			JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao incluir o Usuário. Mensagem: " + e.getMessage());

		} finally {
			try {

				insereST.close();
				conexao.close();

			} catch (Throwable e) {

				JOptionPane.showMessageDialog(null, "Erro ao incluir o Usuário. Mensagem: " + e.getMessage());

			}
		}

	}

	/*public List<Usuario> listarDadosUsuario() {

		List<Usuario> ListaUsuario = new ArrayList<Usuario>();
		PreparedStatement insereST = null;
		ResultSet rs = null;

		String sql = "";


		try {
			
			sql = "SELECT * FROM usuario ORDER BY login ASC";

			//insereST = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			insereST = conexao.prepareStatement(sql);
			rs = insereST.executeQuery();
			
			/*rs = insereST.getGeneratedKeys();
			int id_login = 0;
			if (rs.next()) {
				id_login = rs.getInt(1);
			}

			while (rs.next()) {

				Usuario usuario = new Usuario();

				usuario.setId_usuario(rs.getInt("id_usuario"));
				usuario.setNomeUsuario(rs.getString("nomeusuario"));
				usuario.setFuncaoUsuario(rs.getString("funcaousuario"));
				usuario.setCpf(rs.getString("cpf"));
				//usuario.setTelefoneUsuario(rs.getString("telefoneusuario"));
				//usuario.setEmailUsuario(rs.getString("emailusuario"));
				//usuario.setStatusUsuario(rs.getString("statususuario"));
				//usuario.setDataNascimento(rs.getDate("datanascimento"));
				//usuario.getLogin().setLogin(rs.getString("login"));
				//usuario.getLogin().setSenha(rs.getString("senha"));
				//usuario.getLogin().setNivelAcesso(rs.getString("nivelAcesso"));
								
				ListaUsuario.add(usuario);

			}

			rs.close();
			insereST.close();

			return ListaUsuario;

		} catch (SQLException e) {
			
			e.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"Erro ao acessar a Tabela usuario");

		}

		return ListaUsuario;

	}*/
	
	/*
	 * public int inserirDadosUsuario(Usuario usuario) {
	 * 
	 * int id_usuario = -1;
	 * 
	 * String sql =
	 * "INSERT INTO usuario (nomefantasia, razaosocial, cnpj, inscricaoestadual, clientedesde, statuscliente, nomecontato, emailcontato, telefonecontato01, telefonecontato02, logradouro, numero, complemento, bairro, cidade, uf, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) returning id_cliente"
	 * ;
	 * 
	 * try {
	 * 
	 * PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
	 * 
	 * declarar.setString(1, usuario.getNomeUsuario()); declarar.setString(2,
	 * usuario.getCPF()); declarar.setString(3, usuario.getSetor());
	 * declarar.setString(4, usuario.getEmailUsuario()); declarar.setString(5,
	 * usuario.getTelefoneUsuario()); declarar.setString(6,
	 * usuario.getStatusUsuario()); declarar.setString(7,
	 * usuario.getLogin().getLogin()); declarar.setString(8,
	 * usuario.getLogin().getSenha()); declarar.setString(9,
	 * usuario.getLogin().getNivelAcesso()); declarar.setString(10,
	 * usuario.getEndereco().getLogradouro()); declarar.setString(11,
	 * usuario.getEndereco().getNumero()); declarar.setString(12,
	 * usuario.getEndereco().getComplemento()); declarar.setString(13,
	 * usuario.getEndereco().getCidade()); declarar.setString(14,
	 * usuario.getEndereco().getBairro()); declarar.setString(15,
	 * usuario.getEndereco().getUf()); declarar.setString(16,
	 * usuario.getEndereco().getCep());
	 * 
	 * ResultSet resultado = declarar.executeQuery();
	 * 
	 * while (resultado.next()) {
	 * 
	 * id_usuario = resultado.getInt("id_usuario");
	 * 
	 * }
	 * 
	 * declarar.close();
	 * 
	 * return id_usuario;
	 * 
	 * } catch (SQLException e) {
	 * 
	 * JOptionPane.showMessageDialog(null, "Erro" + e);
	 * 
	 * }
	 * 
	 * return id_usuario;
	 * 
	 * }
	 * 
	 * /* public List<Cliente> listarDadosCliente() {
	 * 
	 * List<Cliente> ListaCliente = new ArrayList<Cliente>();
	 * 
	 * String sql = "SELECT * FROM cliente ORDER BY login ASC";
	 * 
	 * try {
	 * 
	 * PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
	 * ResultSet resultado = declarar.executeQuery();
	 * 
	 * while (resultado.next()) {
	 * 
	 * Cliente cliente = new Cliente();
	 * 
	 * cliente.setId_cliente(resultado.getInt("id_cliente"));
	 * cliente.setNome(resultado.getString("nome_fantasia"));
	 * cliente.setCnpj(resultado.getString("cnpj"));
	 * cliente.setRazaoSocial(resultado.getString("razão_social"));
	 * cliente.setVendedor(resultado.getString("vendedor"));
	 * 
	 * ListaCliente.add(cliente);
	 * 
	 * }
	 * 
	 * resultado.close(); declarar.close();
	 * 
	 * return ListaCliente;
	 * 
	 * } catch (SQLException e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * JOptionPane.showMessageDialog(null, "Erro ao acessar a Tabela Cliente");
	 * 
	 * }
	 * 
	 * return null;
	 * 
	 * }
	 * 
	 * public List<Cliente> pesquisarNome(String pesquisaNome) {
	 * 
	 * List<Cliente> listaCliente = new ArrayList<Cliente>();
	 * 
	 * 
	 * String sql = "SELECT * FROM cliente WHERE nome_fantasia like ? ";
	 * 
	 * try {
	 * 
	 * PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
	 * 
	 * declarar.setString(1, pesquisaNome + "%"); ResultSet resultado =
	 * declarar.executeQuery();
	 * 
	 * while (resultado.next()) {
	 * 
	 * Cliente cliente = new Cliente();
	 * 
	 * cliente.setId_cliente(resultado.getInt("id_cliente"));
	 * cliente.setNome(resultado.getString("nome_fantasia"));
	 * cliente.setCnpj(resultado.getString("cnpj"));
	 * cliente.setRazaoSocial(resultado.getString("razao_social"));
	 * cliente.setVendedor(resultado.getString("vendedor"));
	 * 
	 * listaCliente.add(cliente);
	 * 
	 * }
	 * 
	 * resultado.close(); declarar.close();
	 * 
	 * return listaCliente;
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); JOptionPane.showMessageDialog(null, "erro" + e);
	 * 
	 * }
	 * 
	 * return null; }
	 * 
	 * public Cliente pesquisarUnicoNome(String pesquisaNome) {
	 * 
	 * Cliente cliente = new Cliente(); String sql =
	 * "SELECT * FROM cliente Where nome_fantasia = ?";
	 * 
	 * try {
	 * 
	 * PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
	 * 
	 * declarar.setString(1, pesquisaNome); ResultSet resultado =
	 * declarar.executeQuery();
	 * 
	 * while (resultado.next()) {
	 * 
	 * cliente.setId_cliente(resultado.getInt("id_cliente"));
	 * cliente.setNome(resultado.getString("nome_fantasia"));
	 * cliente.setCnpj(resultado.getString("cnpj"));
	 * cliente.setRazaoSocial(resultado.getString("razao_social"));
	 * cliente.setVendedor(resultado.getString("vendedor"));
	 * 
	 * }
	 * 
	 * resultado.close(); declarar.close();
	 * 
	 * return cliente;
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); JOptionPane.showMessageDialog(null, "erro" + e);
	 * 
	 * }
	 * 
	 * return cliente; }
	 * 
	 * public List<Cliente> pesquisarMultiplosCampos(String campo, String
	 * pesquisa) {
	 * 
	 * List<Cliente> listaCliente = new ArrayList<Cliente>();
	 * 
	 * String sql = "SELECT * FROM cliente WHERE " + campo + " like ? ";
	 * 
	 * try {
	 * 
	 * PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
	 * 
	 * declarar.setString(1, pesquisa + "%"); ResultSet resultado =
	 * declarar.executeQuery();
	 * 
	 * while (resultado.next()) {
	 * 
	 * Cliente cliente = new Cliente();
	 * 
	 * cliente.setId_cliente(resultado.getInt("id_cliente"));
	 * cliente.setNome(resultado.getString("nome_fantasia"));
	 * cliente.setCnpj(resultado.getString("cnpj"));
	 * cliente.setRazaoSocial(resultado.getString("razao_social"));
	 * cliente.setVendedor(resultado.getString("vendedor"));
	 * 
	 * listaCliente.add(cliente);
	 * 
	 * }
	 * 
	 * resultado.close(); declarar.close();
	 * 
	 * return listaCliente;
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); JOptionPane.showMessageDialog(null, "erro" + e);
	 * 
	 * }
	 * 
	 * return null; }
	 * 
	 * public boolean excluirDadosCliente (int id_cliente) {
	 * 
	 * boolean excluiuDados = false;
	 * 
	 * String sql = "DELETE FROM cliente WHERE id_cliente = ?";
	 * 
	 * try {
	 * 
	 * PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
	 * 
	 * declarar.setInt(1, id_cliente);
	 * 
	 * declarar.execute(); declarar.close();
	 * 
	 * excluiuDados = true;
	 * 
	 * return excluiuDados;
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace();
	 * 
	 * JOptionPane.showMessageDialog(null,
	 * "Erro os Dados não foram excluídos do  Banco de Dados" + e); }
	 * 
	 * return excluiuDados;
	 * 
	 * }
	 * 
	 * public boolean alterarDadosCliente(Cliente cliente) {
	 * 
	 * boolean corretoCliente = false;
	 * 
	 * String sql =
	 * "UPDATE cliente SET nome_fantasia = ?, cnpj = ?,  razao_social = ?, vendedor = ?  WHERE id_cliente = ?"
	 * ;
	 * 
	 * try {
	 * 
	 * PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
	 * 
	 * declarar.setString(1, cliente.getNome()); declarar.setString(2,
	 * cliente.getCnpj()); declarar.setString(3, cliente.getRazaoSocial());
	 * declarar.setString(4, cliente.getVendedor()); declarar.setInt(5,
	 * cliente.getId_cliente());
	 * 
	 * declarar.execute(); declarar.close();
	 * 
	 * corretoCliente = true;
	 * 
	 * return corretoCliente;
	 * 
	 * 
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * 
	 * JOptionPane .showMessageDialog(null,
	 * "Erro não foi possível alterar o dados do Cliente\n" + e);
	 * 
	 * }
	 * 
	 * return corretoCliente;
	 * 
	 * }
	 */

}
