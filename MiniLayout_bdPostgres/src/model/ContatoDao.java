package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.Cliente;
import controller.Contato;

public class ContatoDao {

	private Connection conexaoBanco;

	public ContatoDao() {

		this.conexaoBanco = ConectarBanco.getConnection();

	}

	public void inserirContatoUsuario(Contato contato) {

		String sql = "INSERT INTO contato ( nome_para_contato, e_mail, telefone1, telefone2, id_usuario) VALUES (?, ?,  ?, ?, ?) ";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, contato.getNomeParaContato());
			declarar.setString(2, contato.getEmail());
			declarar.setString(3, contato.getTelefone1());
			declarar.setString(4, contato.getTelefone2());
			declarar.setInt(5, contato.getId_usuario());

			// JOptionPane.showMessageDialog(null,"Contato cadastrado com sucesso");

			declarar.execute();
			declarar.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro" + e);

		}

	}

	public void inserirContatoCliente(Contato contato) {

		String sql = "INSERT INTO contato ( id_cliente, nome_para_contato, e_mail, telefone1, telefone2) VALUES (?, ?, ?, ?, ?) ";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, contato.getId_cliente());
			declarar.setString(2, contato.getNomeParaContato());
			declarar.setString(3, contato.getEmail());
			declarar.setString(4, contato.getTelefone1());
			declarar.setString(5, contato.getTelefone2());

			// JOptionPane.showMessageDialog(null,"Contato cadastrado com sucesso");

			declarar.execute();
			declarar.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro" + e);

		}

	}

	public Contato localizarContatoCliente(int id_cliente) {

		Contato contato = new Contato();

		String sql = "SELECT * FROM contato Where id_cliente= ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, id_cliente);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				contato.setId_contato(resultado.getInt("Id_contato"));
				contato.setNomeParaContato(resultado
						.getString("nome_para_contato"));
				contato.setEmail(resultado.getString("e_mail"));
				contato.setTelefone1(resultado.getString("telefone1"));
				contato.setTelefone2(resultado.getString("telefone2"));
				contato.setId_cliente(resultado.getInt("id_cliente"));

			}

			resultado.close();
			declarar.close();

			return contato;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "erro" + e);

		}

		return contato;

	}

	public boolean excluirContatoCliente(int id_contato) {

		boolean excluiuContato = false;
		
		Contato contato = new Contato();

		String sql = "DELETE FROM contato WHERE id_contato = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, contato.getId_contato());

			declarar.execute();
			declarar.close();

			excluiuContato = true;
			
			return excluiuContato;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"Erro os Dados não foram excluídos do Banco de Dados");
		}
		
		return excluiuContato;

	}

	public boolean alterarContatoCliente(Contato contato) {

		boolean corretoContato = false;

		String sql = "UPDATE contato SET id_cliente = ?,  nome_para_contato = ?,  e_mail = ?, telefone1 = ?, telefone2 = ?  WHERE id_contato = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, contato.getId_cliente());
			declarar.setString(2, contato.getNomeParaContato());
			declarar.setString(3, contato.getEmail());
			declarar.setString(4, contato.getTelefone1());
			declarar.setString(5, contato.getTelefone2());
			declarar.setInt(6, contato.getId_contato());

			declarar.execute();
			declarar.close();

			corretoContato = true;

			return corretoContato;

			

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			JOptionPane.showMessageDialog(null,
					"Erro não foi possível alterar o Contato do Cliente\n" + e);

		}

		return corretoContato;

	}

}
