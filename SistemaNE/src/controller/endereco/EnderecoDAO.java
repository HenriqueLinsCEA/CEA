package controller.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.cliente.Cliente;
import model.ConectarBanco;

public class EnderecoDAO {

	ConectarBanco conectarBanco = new ConectarBanco();
	Connection conexao = conectarBanco.geraConexao();

	public void insereEndereco(Cliente cliente) {

		PreparedStatement insereST = null;

		String sql = "";

		try {

			sql = "insert into endereco (logradouro, numero, complemento, bairro, cidade, uf, cep ) values(?,?,?,?,?,?)";

			insereST = conexao.prepareStatement(sql);
			insereST.setString(1, cliente.getEndereco().getLogradouro());
			insereST.setString(2, cliente.getEndereco().getNumero());
			insereST.setString(3, cliente.getEndereco().getComplemento());
			insereST.setString(4, cliente.getEndereco().getBairro());
			insereST.setString(5, cliente.getEndereco().getCidade());
			insereST.setString(6, cliente.getEndereco().getUf());
			insereST.setString(6, cliente.getEndereco().getCep());

			insereST.executeUpdate();

			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao incluir o Endereço. Mensagem: " + e.getMessage());

		} finally {
			try {

				insereST.close();
				conexao.close();

			} catch (Throwable e) {

				JOptionPane.showMessageDialog(null, "Erro ao incluir o Endereço. Mensagem: " + e.getMessage());

			}
		}

	};

}
