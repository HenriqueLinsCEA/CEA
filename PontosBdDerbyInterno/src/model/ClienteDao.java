package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.Cliente;

public class ClienteDao {

	private static Connection conexaoBanco;

	public ClienteDao() {

		ClienteDao.conexaoBanco = ConectarBanco.getConnection();

	}

	public Cliente inserirDadosClientes(Cliente cliente) {

		String sql = "INSERT INTO clientes (nome, cpf, pontos, logradouro, numero, complemento, bairro, cidade, uf, cep, telefone1, telefone2, dataCadastro) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, cliente.getNome());
			declarar.setString(2, cliente.getCpf());
			declarar.setInt(3, cliente.getPontos());
			declarar.setString(4, cliente.getEndereco().getLogradouro());
			declarar.setString(5, cliente.getEndereco().getNumero());
			declarar.setString(6, cliente.getEndereco().getComplemento());
			declarar.setString(7, cliente.getEndereco().getBairro());
			declarar.setString(8, cliente.getEndereco().getCidade());
			declarar.setString(9, cliente.getEndereco().getUf());
			declarar.setString(10, cliente.getEndereco().getCep());
			declarar.setString(11, cliente.getTelefone().getTelefone1());
			declarar.setString(12, cliente.getTelefone().getTelefone2());
			declarar.setTimestamp(13, new Timestamp(cliente.getDataCadastro().getTime()));

			declarar.execute();
			declarar.close();

			JOptionPane.showMessageDialog(null,
					"Cliente cadastrado com sucesso");

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null,
					"CPF em duplicidade no Banco de Dados\n" + e);

			cliente.setNome(null);
			cliente.setCpf(null);

			return cliente;

		}

		return cliente;

	}

	public void excluirCliente(Cliente cliente) {

		String sql = "DELETE FROM clientes WHERE id_cliente = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, cliente.getId_cliente());

			declarar.execute();
			declarar.close();

			JOptionPane.showMessageDialog(null,
					"Dados excluídos no Banco de Dados");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"Erro os Dados não foram gravados no Banco de Dados");
		}

	}

	public void alterarDados(Cliente cliente) {

		String sql = "UPDATE clientes SET nome = ?, cpf = ?,  pontos = ?, logradouro = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, uf = ?, cep = ?, telefone1 = ?, telefone2 = ?  WHERE id_cliente = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, cliente.getNome());
			declarar.setString(2, cliente.getCpf());
			declarar.setInt(3, cliente.getPontos());
			declarar.setString(4, cliente.getEndereco().getLogradouro());
			declarar.setString(5, cliente.getEndereco().getNumero());
			declarar.setString(6, cliente.getEndereco().getComplemento());
			declarar.setString(7, cliente.getEndereco().getBairro());
			declarar.setString(8, cliente.getEndereco().getCidade());
			declarar.setString(9, cliente.getEndereco().getUf());
			declarar.setString(10, cliente.getEndereco().getCep());
			declarar.setString(11, cliente.getTelefone().getTelefone1());
			declarar.setString(12, cliente.getTelefone().getTelefone2());
			declarar.setInt(13, cliente.getId_cliente());

			
			
			declarar.execute();
			declarar.close();

			JOptionPane.showMessageDialog(null, "Registro do Cliente alterado");

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			JOptionPane
					.showMessageDialog(null,
							"Erro não foi possível alterar o dados do Cliente\n"
									+ e);

		}

	}

	public void alterarNomeCPF(Cliente cliente) {

		String sql = "UPDATE clientes SET nome = ?, cpf = ? WHERE id_cliente = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, cliente.getNome());
			declarar.setString(2, cliente.getCpf());
			declarar.setInt(3, cliente.getId_cliente());

			declarar.execute();
			declarar.close();

			JOptionPane.showMessageDialog(null, "Registro alterado");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void alterarPontos(Cliente cliente) {

		String sql = "UPDATE clientes SET pontos = ?  WHERE id_cliente = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, cliente.getPontos());
			declarar.setInt(2, cliente.getId_cliente());

			declarar.execute();
			declarar.close();

			JOptionPane
					.showMessageDialog(null, "Pontos Resgatados com sucesso");

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null,
					"Erro não foi Resgatar os Pontos\n" + e);

		}

	}

	public void adicionarPontos(Cliente cliente) {

		String sql = "UPDATE clientes SET pontos = ?  WHERE id_cliente = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, cliente.getPontos());
			declarar.setInt(2, cliente.getId_cliente());

			declarar.execute();
			declarar.close();

			JOptionPane.showMessageDialog(null,
					"Pontos Adicionados com sucesso");

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null,
					"Erro não foi possível Adicionar Pontos");

		}

	}

	public Cliente pesquisarCpf(String cpf) {

		Cliente cliente = new Cliente();
		String sql = "SELECT * FROM clientes WHERE cpf = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, cpf);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				cliente.setId_cliente(resultado.getInt("id_cliente"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setCpf(resultado.getString("cpf"));
				cliente.setPontos(resultado.getInt("pontos"));
				cliente.getEndereco().setLogradouro(resultado.getString("logradouro"));
				cliente.getEndereco().setNumero(resultado.getString("numero"));
				cliente.getEndereco().setComplemento(resultado.getString("complemento"));
				cliente.getEndereco().setBairro(resultado.getString("bairro"));
				cliente.getEndereco().setCidade(resultado.getString("cidade"));
				cliente.getEndereco().setUf(resultado.getString("uf"));
				cliente.getEndereco().setCep(resultado.getString("cep"));
				cliente.getTelefone().setTelefone1(resultado.getString("telefone1"));
				cliente.getTelefone().setTelefone2(resultado.getString("telefone2"));
				cliente.setDataCadastro(resultado.getDate("dataCadastro"));
				

			}
			
		
			resultado.close();
			declarar.close();

			return cliente;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return null;
	}

	public List<Cliente> pesquisarNome(String nome) {

		List<Cliente> ListaCliente = new ArrayList<Cliente>();

		String sql = "SELECT * FROM clientes WHERE nome like ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, nome + "%");
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				Cliente cliente = new Cliente();

				cliente.setId_cliente(resultado.getInt("id_cliente"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setCpf(resultado.getString("cpf"));
				cliente.setPontos(resultado.getInt("pontos"));
				cliente.getEndereco().setLogradouro(resultado.getString("logradouro"));
				cliente.getEndereco().setComplemento(resultado.getString("complemento"));
				cliente.getEndereco().setBairro(resultado.getString("bairro"));
				cliente.getEndereco().setCidade(resultado.getString("cidade"));
				cliente.getEndereco().setUf(resultado.getString("uf"));
				cliente.getTelefone().setTelefone1(resultado.getString("telefone1"));
				cliente.getTelefone().setTelefone2(resultado.getString("telefone2"));
				cliente.setDataCadastro(resultado.getDate("dataCadastro"));
				
				ListaCliente.add(cliente);

			}

			resultado.close();
			declarar.close();

			return ListaCliente;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return null;
	}

	public Cliente pesquisarNomeUnico(String nome) {

		Cliente cliente = new Cliente();

		String sql = "SELECT * FROM clientes WHERE nome = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, nome);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				cliente.setId_cliente(resultado.getInt("id_cliente"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setCpf(resultado.getString("cpf"));
				cliente.setPontos(resultado.getInt("pontos"));
				cliente.getEndereco().setLogradouro(resultado.getString("logradouro"));
				cliente.getEndereco().setComplemento(resultado.getString("complemento"));
				cliente.getEndereco().setBairro(resultado.getString("bairro"));
				cliente.getEndereco().setCidade(resultado.getString("cidade"));
				cliente.getEndereco().setUf(resultado.getString("uf"));
				cliente.getTelefone().setTelefone1(resultado.getString("telefone1"));
				cliente.getTelefone().setTelefone2(resultado.getString("telefone2"));
				cliente.setDataCadastro(resultado.getDate("dataCadastro"));
				
			}

			resultado.close();
			declarar.close();

			return cliente;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return null;
	}

	public List<Cliente> mostrarDados() {

		List<Cliente> ListaCliente = new ArrayList<Cliente>();

		String sql = "SELECT * FROM clientes";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				Cliente cliente = new Cliente();

				cliente.setId_cliente(resultado.getInt("id_cliente"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setCpf(resultado.getString("cpf"));
				cliente.setPontos(resultado.getInt("pontos"));

				ListaCliente.add(cliente);

			}

			resultado.close();
			declarar.close();

			return ListaCliente;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"Erro ao acessar a Tabela Clientes");

		}

		return null;

	}
	
	public static int contarClientes() {

		int numero = 0;

		String sql = "SELECT * FROM clientes";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				numero++;
			}

			resultado.close();
			declarar.close();

			return numero;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"Erro ao acessar a Tabela Clientes");

		}

		return numero;

	}

	public static Cliente localizarClientePeloCpf(String cpf) {

		Cliente cliente = new model.ClienteDao().pesquisarCpf(cpf);

		return cliente;

	}

}
