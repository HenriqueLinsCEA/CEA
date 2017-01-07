package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.Cliente;

public class ClienteDao {

	private static Connection conexaoBanco;

	public ClienteDao() {

		ClienteDao.conexaoBanco = ConectarBanco.getConnection();

	}

	public int inserirDadosCliente(Cliente cliente) {

		int id_cliente = -1;

		String sql = "INSERT INTO cliente (nome_fantasia, cnpj, razao_social, vendedor) VALUES (?, ?, ?, ?) returning id_cliente";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, cliente.getNome());
			declarar.setString(2, cliente.getCnpj());
			declarar.setString(3, cliente.getRazaoSocial());
			declarar.setString(4, cliente.getVendedor());

			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				id_cliente = resultado.getInt("id_cliente");

			}

			// JOptionPane.showMessageDialog(null,
			// "Cliente cadastrado com sucesso");

			declarar.close();

			return id_cliente;

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro" + e);

		}

		return id_cliente;

	}

	public List<Cliente> listarDadosCliente() {

		List<Cliente> ListaCliente = new ArrayList<Cliente>();

		String sql = "SELECT * FROM cliente ORDER BY login ASC";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				Cliente cliente = new Cliente();

				cliente.setId_cliente(resultado.getInt("id_cliente"));
				cliente.setNome(resultado.getString("nome_fantasia"));
				cliente.setCnpj(resultado.getString("cnpj"));
				cliente.setRazaoSocial(resultado.getString("razão_social"));
				cliente.setVendedor(resultado.getString("vendedor"));

				ListaCliente.add(cliente);

			}

			resultado.close();
			declarar.close();

			return ListaCliente;

		} catch (SQLException e) {

			e.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"Erro ao acessar a Tabela Cliente");

		}

		return null;

	}

	public List<Cliente> pesquisarNome(String pesquisaNome) {

		List<Cliente> listaCliente = new ArrayList<Cliente>();
	

		String sql = "SELECT * FROM cliente WHERE nome_fantasia like ? ";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, pesquisaNome + "%");
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				Cliente cliente = new Cliente();

				cliente.setId_cliente(resultado.getInt("id_cliente"));
				cliente.setNome(resultado.getString("nome_fantasia"));
				cliente.setCnpj(resultado.getString("cnpj"));
				cliente.setRazaoSocial(resultado.getString("razao_social"));
				cliente.setVendedor(resultado.getString("vendedor"));

				listaCliente.add(cliente);

			}

			resultado.close();
			declarar.close();

			return listaCliente;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "erro" + e);

		}

		return null;
	}

	public Cliente pesquisarUnicoNome(String pesquisaNome) {

		Cliente cliente = new Cliente();
		String sql = "SELECT * FROM cliente Where nome_fantasia = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, pesquisaNome);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				cliente.setId_cliente(resultado.getInt("id_cliente"));
				cliente.setNome(resultado.getString("nome_fantasia"));
				cliente.setCnpj(resultado.getString("cnpj"));
				cliente.setRazaoSocial(resultado.getString("razao_social"));
				cliente.setVendedor(resultado.getString("vendedor"));

			}

			resultado.close();
			declarar.close();

			return cliente;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "erro" + e);

		}

		return cliente;
	}

	public List<Cliente> pesquisarMultiplosCampos(String campo, String pesquisa) {
		
		List<Cliente> listaCliente = new ArrayList<Cliente>();

		String sql = "SELECT * FROM cliente WHERE " + campo + " like ? ";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, pesquisa + "%");
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				Cliente cliente = new Cliente();

				cliente.setId_cliente(resultado.getInt("id_cliente"));
				cliente.setNome(resultado.getString("nome_fantasia"));
				cliente.setCnpj(resultado.getString("cnpj"));
				cliente.setRazaoSocial(resultado.getString("razao_social"));
				cliente.setVendedor(resultado.getString("vendedor"));

				listaCliente.add(cliente);

			}

			resultado.close();
			declarar.close();

			return listaCliente;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "erro" + e);

		}

		return null;
	}
	
	public boolean excluirDadosCliente (int id_cliente) {
		
		boolean excluiuDados = false;
		
		String sql = "DELETE FROM cliente WHERE id_cliente = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, id_cliente);

			declarar.execute();
			declarar.close();

			excluiuDados = true;
			
			return excluiuDados;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"Erro os Dados não foram excluídos do  Banco de Dados" + e);
		}
		
		return excluiuDados;

	}

	public boolean  alterarDadosCliente(Cliente cliente) {
		
		boolean corretoCliente = false;
		
		String sql = "UPDATE cliente SET nome_fantasia = ?, cnpj = ?,  razao_social = ?, vendedor = ?  WHERE id_cliente = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, cliente.getNome());
			declarar.setString(2, cliente.getCnpj());
			declarar.setString(3, cliente.getRazaoSocial());
			declarar.setString(4, cliente.getVendedor());
			declarar.setInt(5, cliente.getId_cliente());

			declarar.execute();
			declarar.close();
			
			corretoCliente = true;

		return corretoCliente;
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			JOptionPane
					.showMessageDialog(null,
							"Erro não foi possível alterar o dados do Cliente\n"
									+ e);

		}
		
		return corretoCliente;

	}


}
