package controller.contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.cliente.Cliente;
import model.ConectarBanco;

public class ContatoDAO {
	
	ConectarBanco conectarBanco = new ConectarBanco();
	Connection conexao = conectarBanco.geraConexao();
	
public void insereContato(Cliente cliente) {
		
		
		PreparedStatement insereST = null;

		String sql = "";

		try {

			sql = "insert into contato (nomecontato, emailcontato,telefonecontato01,telefonecontato02 ) values(?,?,?,?)";
			
			insereST = conexao.prepareStatement(sql);
			insereST.setString(1, cliente.getContato().getNomeContato());
			insereST.setString(2, cliente.getContato().getEmailContato());
			insereST.setString(3, cliente.getContato().getTelefone01());
			insereST.setString(4, cliente.getContato().getTelefone02());
			
			insereST.executeUpdate();
							
			JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!");
			
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null,"Erro ao incluir  o Contato. Mensagem: " + e.getMessage());

		} finally {
			try {

				insereST.close();
				conexao.close();

			} catch (Throwable e) {

				JOptionPane.showMessageDialog(null,"Erro ao incluir o Contato. Mensagem: " + e.getMessage());

			}
		}

	};

	

}
