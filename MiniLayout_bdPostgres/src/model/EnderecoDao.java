package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.Cliente;
import controller.Endereco;

public class EnderecoDao {

	private Connection conexaoBanco;

	public EnderecoDao() {

		this.conexaoBanco = ConectarBanco.getConnection();

	}

	public void inserirEnderecoUsuario(Endereco endereco) {

		String sql = "INSERT INTO endereco ( logradouro, complemento, numero, bairro, cidade, uf, cep, id_usuario) VALUES (?, ?,  ?, ?, ?, ?, ?, ?) ";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, endereco.getLogradouro());
			declarar.setString(2, endereco.getComplemento());
			declarar.setString(3, endereco.getNumero());
			declarar.setString(4, endereco.getBairro());
			declarar.setString(5, endereco.getCidade());
			declarar.setString(6, endereco.getUf());
			declarar.setString(7, endereco.getCep());
			declarar.setInt(8, endereco.getId_usuario());

			//JOptionPane.showMessageDialog(null,"Endereco cadastrado com sucesso");

			declarar.execute();
			declarar.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro" + e);

		}

	}

	public void inserirEnderecoCliente(Endereco endereco) {

		String sql = "INSERT INTO endereco (id_cliente,  logradouro, complemento, numero, bairro, cidade, uf, cep ) VALUES ( ?,  ?, ?, ?, ?, ?, ?, ?) ";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, endereco.getId_cliente());
			declarar.setString(2, endereco.getLogradouro());
			declarar.setString(3, endereco.getComplemento());
			declarar.setString(4, endereco.getNumero());
			declarar.setString(5, endereco.getBairro());
			declarar.setString(6, endereco.getCidade());
			declarar.setString(7, endereco.getUf());
			declarar.setString(8, endereco.getCep());

			//JOptionPane.showMessageDialog(null,"Endereco cadastrado com sucesso");

			declarar.execute();
			declarar.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro" + e);

		}

	}

	public Endereco pesquisarEnderecoCliente(int id_cliente) {

		Endereco endereco = new Endereco();

		String sql = "SELECT * FROM endereco Where id_cliente = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, id_cliente);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				endereco.setId_endereco(resultado.getInt("Id_endereco"));
				endereco.setLogradouro(resultado.getString("logradouro"));
				endereco.setComplemento(resultado.getString("complemento"));
				endereco.setNumero(resultado.getString("numero"));
				endereco.setBairro(resultado.getString("bairro"));
				endereco.setCidade(resultado.getString("cidade"));
				endereco.setUf(resultado.getString("uf"));
				endereco.setCep(resultado.getString("cep"));
				endereco.setId_cliente(resultado.getInt("id_cliente"));

			}

			resultado.close();
			declarar.close();

			return endereco;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "erro" + e);

		}

		return endereco;
	}
	
	public boolean excluirEnderecoCliente(int id_endereco) {
		
		boolean excluiuEndereco = false;
		
		Endereco endereco = new Endereco();

		String sql = "DELETE FROM endereco WHERE id_endereco= ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, endereco.getId_endereco());

			declarar.execute();
			declarar.close();

		    excluiuEndereco = true;
		    
		    return excluiuEndereco;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"Erro o Endereço não foi excluído do Banco de Dados");
		}
		
		return excluiuEndereco;

	}

	public boolean alterarEnderecoCliente(Endereco endereco) {
		
		boolean corretoEndereco = false;

		String sql = "UPDATE endereco SET id_cliente = ?, logradouro = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, uf = ?, cep = ?  WHERE id_endereco= ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
			
			declarar.setInt(1,  endereco.getId_cliente());
			declarar.setString(2, endereco.getLogradouro());
			declarar.setString(3, endereco.getNumero());
			declarar.setString(4, endereco.getComplemento());
			declarar.setString(5, endereco.getBairro());
			declarar.setString(6, endereco.getCidade());
			declarar.setString(7, endereco.getUf());
			declarar.setString(8, endereco.getCep());
			declarar.setInt(9,  endereco.getId_endereco());
			
			declarar.execute();
			declarar.close();
			
			corretoEndereco = true;
			
			return corretoEndereco;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			JOptionPane
					.showMessageDialog(null,
							"Erro não foi possível alterar o endereco do Cliente\n"
									+ e);

		}
		
		return corretoEndereco;

	}


}
