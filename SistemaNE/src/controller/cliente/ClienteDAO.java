package controller.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.ConectarBanco;

public class ClienteDAO {

	ConectarBanco conectarBanco = new ConectarBanco();
	Connection conexao = conectarBanco.geraConexao();

	@SuppressWarnings("resource")
	public void insereCliente(Cliente cliente) {

		PreparedStatement insereST = null;
		ResultSet rs = null;

		String sql = "";

		try {

			sql = "insert into endereco (logradouro, numero, complemento, bairro, cidade, uf, cep ) values(?,?,?,?,?,?,?)";

			insereST = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			insereST.setString(1, cliente.getEndereco().getLogradouro());
			insereST.setString(2, cliente.getEndereco().getNumero());
			insereST.setString(3, cliente.getEndereco().getComplemento());
			insereST.setString(4, cliente.getEndereco().getBairro());
			insereST.setString(5, cliente.getEndereco().getCidade());
			insereST.setString(6, cliente.getEndereco().getUf());
			insereST.setString(7, cliente.getEndereco().getCep());

			insereST.executeUpdate();

			// Recupera a id
			rs = insereST.getGeneratedKeys();
			int id_endereco = 0;
			if (rs.next()) {
				id_endereco = rs.getInt(1);
			}

			sql = "insert into contato (nomecontato, emailcontato,telefonecontato01,telefonecontato02 ) values(?,?,?,?)";

			insereST = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			insereST.setString(1, cliente.getContato().getNomeContato());
			insereST.setString(2, cliente.getContato().getEmailContato());
			insereST.setString(3, cliente.getContato().getTelefone01());
			insereST.setString(4, cliente.getContato().getTelefone02());

			insereST.executeUpdate();

			// Recupera a id
			rs = insereST.getGeneratedKeys();
			int id_contato = 0;
			if (rs.next()) {
				id_contato = rs.getInt(1);
			}

			sql = "insert into cliente (nomefantasia, razaosocial, cnpj, inscricaoestadual, statuscliente, clientedesde, id_endereco, id_contato  ) values(?,?,?,?,?,?,?,?)";
			
			java.sql.Date dataSql = new java.sql.Date(cliente.getClienteDesde().getTime()); 


			insereST = conexao.prepareStatement(sql);
			insereST.setString(1, cliente.getNomeFantasia());
			insereST.setString(2, cliente.getRazaoSocial());
			insereST.setString(3, cliente.getCnpj());
			insereST.setString(4, cliente.getInscricaoEstadual());
			insereST.setString(5, cliente.getStatusCliente());
			insereST.setDate(6, dataSql);
			insereST.setInt(7, id_endereco);
			insereST.setInt(8, id_contato);

			insereST.executeUpdate();

			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao incluir cliente. Mensagem: " + e.getMessage());

		} finally {
			try {

				insereST.close();
				conexao.close();

			} catch (Throwable e) {

				JOptionPane.showMessageDialog(null, "Erro ao incluir cliente. Mensagem: " + e.getMessage());

			}
		}

	};

	/*
	 * public void salvar(Cliente cliente) {
	 * 
	 * 
	 * PreparedStatement insereST = null;
	 * 
	 * String sql =
	 * "insert into cliente (nomefantasia, razaosocial) values(?,?)";
	 * 
	 * try {
	 * 
	 * insereST = conexao.prepareStatement(sql); insereST.setString(1,
	 * cliente.getNomeFantasia()); insereST.setString(2,
	 * cliente.getRazaoSocial());
	 * 
	 * insereST.executeUpdate();
	 * 
	 * JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!");
	 * 
	 * } catch (SQLException e) {
	 * 
	 * JOptionPane.showMessageDialog(null,"Erro ao incluir cliente. Mensagem: "
	 * + e.getMessage());
	 * 
	 * } finally { try {
	 * 
	 * insereST.close(); conexao.close();
	 * 
	 * } catch (Throwable e) {
	 * 
	 * JOptionPane.showMessageDialog(null,"Erro ao incluir cliente. Mensagem: "
	 * + e.getMessage());
	 * 
	 * } }
	 * 
	 * };
	 */

	/*
	 * public int inserirDadosCliente(Cliente cliente) {
	 * 
	 * int id_cliente = -1;
	 * 
	 * String sqlCliente =
	 * "INSERT INTO cliente (nomefantasia, razaosocial, cnpj, inscricaoestadual, clientedesde, statuscliente) VALUES (?, ?, ?, ?, ?,?) returning id_cliente"
	 * ;
	 * 
	 * String sqlContato =
	 * "INSERT INTO contato (nomecontato, emailcontato, telefonecontato01, telefonecontato02) VALUES (?, ?, ?, ?)"
	 * ;
	 * 
	 * String sqlEndereco =
	 * "INSERT INTO contato (logradouro, numero, complemento, bairro, cidade, uf, cep) VALUES (?, ?, ?, ?, ?, ?, ?)"
	 * ;
	 * 
	 * try {
	 * 
	 * PreparedStatement declarar = conexaoBanco.prepareStatement(sqlCliente);
	 * 
	 * declarar.setString(1, cliente.getNomeFantasia()); declarar.setString(2,
	 * cliente.getRazaoSocial()); declarar.setString(3, cliente.getCnpj());
	 * declarar.setString(4, cliente.getInscricaoEstadual());
	 * declarar.setDate(5, cliente.getClienteDesde()); declarar.setString(6,
	 * cliente.getStatusCliente());
	 * 
	 * /*declarar = conexaoBanco.prepareStatement(sqlContato);
	 * 
	 * declarar.setString(7, cliente.getContato().getNomeContato());
	 * declarar.setString(8, cliente.getContato().getEmailContato());
	 * declarar.setString(9, cliente.getContato().getTelefone01());
	 * declarar.setString(10, cliente.getContato().getTelefone02());
	 * 
	 * declarar = conexaoBanco.prepareStatement(sqlEndereco);
	 * 
	 * declarar.setString(11, cliente.getEndereco().getLogradouro());
	 * declarar.setString(12, cliente.getEndereco().getNumero());
	 * declarar.setString(13, cliente.getEndereco().getComplemento());
	 * declarar.setString(14, cliente.getEndereco().getBairro());
	 * declarar.setString(15, cliente.getEndereco().getCidade());
	 * declarar.setString(16, cliente.getEndereco().getUf());
	 * declarar.setString(17, cliente.getEndereco().getCep());
	 * 
	 * ResultSet resultado = declarar.executeQuery();
	 * 
	 * 
	 * while (resultado.next()) {
	 * 
	 * id_cliente = resultado.getInt("id_cliente");
	 * 
	 * }
	 * 
	 * declarar.close();
	 * 
	 * return id_cliente;
	 * 
	 * } catch (SQLException e) {
	 * 
	 * JOptionPane.showMessageDialog(null, "Erro" + e);
	 * 
	 * }
	 * 
	 * return id_cliente;
	 * 
	 * }/*
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
