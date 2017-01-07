package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.Contato;
import controller.Layout;
import controller.TipoAcesso;

public class TipoAcessoDao {

	private static Connection conexaoBanco;

	public TipoAcessoDao() {

		TipoAcessoDao.conexaoBanco = ConectarBanco.getConnection();

	}

	public void inserirTipoAcesso(TipoAcesso tipoAcesso) {

		String sql = "INSERT INTO tipo_acesso (id_layout, id_cliente, codigo_barras, padrao_codigo_barras, digitos, tarja_magnetica, tipo_tarja, tarja_1, tarja_2, tarja_3, proximidade, tipo_cartao_proximidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, tipoAcesso.getId_layout());
			declarar.setInt(2,  tipoAcesso.getId_cliente());
			declarar.setBoolean(3, tipoAcesso.isCodigoDeBarras());
			declarar.setString(4, tipoAcesso.getPadraoCodigoDeBarras());
			declarar.setString(5, tipoAcesso.getDigitos());
			declarar.setBoolean(6, tipoAcesso.isTarjaMagnetica());
			declarar.setString(7, tipoAcesso.getTipoTarja());
			declarar.setBoolean(8, tipoAcesso.isTarja1());
			declarar.setBoolean(9, tipoAcesso.isTarja2());
			declarar.setBoolean(10, tipoAcesso.isTarja3());
			declarar.setBoolean(11, tipoAcesso.isProximidade());
			declarar.setString(12, tipoAcesso.getTipoCartaoProximidade());
			
			declarar.execute();
			declarar.close();
			
			//JOptionPane.showMessageDialog(null, "Tipo Acesso cadastrado com sucesso");


		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro" + e);

		}


	}

	public TipoAcesso pesquisarTipoAcesso(int id_layout) {
		
		TipoAcesso tipoAcesso = new TipoAcesso();

		String sql = "SELECT * FROM tipo_acesso Where id_layout = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, id_layout);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {
				
				tipoAcesso.setId_acesso(resultado.getInt("id_acesso"));
				tipoAcesso.setId_layout(resultado.getInt("id_layout"));
				tipoAcesso.setCodigoDeBarras(resultado.getBoolean("codigo_barras"));
				tipoAcesso.setPadraoCodigoDeBarras(resultado.getString("padrao_codigo_barras"));
				tipoAcesso.setDigitos(resultado.getString("digitos"));
				tipoAcesso.setTarjaMagnetica(resultado.getBoolean("tarja_magnetica"));
				tipoAcesso.setTarja1(resultado.getBoolean("tarja_1"));
				tipoAcesso.setTarja2(resultado.getBoolean("tarja_2"));
				tipoAcesso.setTarja3(resultado.getBoolean("tarja_3"));
				tipoAcesso.setProximidade(resultado.getBoolean("proximidade"));
				tipoAcesso.setTipoCartaoProximidade(resultado.getString("tipo_cartao_proximidade"));
				tipoAcesso.setTipoTarja(resultado.getString("tipo_tarja"));
				tipoAcesso.setId_cliente(resultado.getInt("id_cliente"));
			
			}

			resultado.close();
			declarar.close();

			return tipoAcesso;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "erro" + e);

		}

		return tipoAcesso;
	}
	
	
	public boolean excluirTipoAcessoCliente(int id_acesso) {
		
		boolean excluiuTipoAcesso = false;

		String sql = "DELETE FROM tipo_acesso WHERE id_acesso = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, id_acesso);

			declarar.execute();
			declarar.close();

			excluiuTipoAcesso = true;
			
			return excluiuTipoAcesso;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"Erro Tipo do Acesso  não excluído do Banco de Dados");
		}
		
		return excluiuTipoAcesso;

	}

	public void alterarContatoCliente(Contato contato) {

		String sql = "UPDATE contato SET id_cliente  = ?, nome_para_contato = ?,  e_mail = ?, telefone1 = ?, telefone2 = ?  WHERE id_contato = ?";

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

			JOptionPane.showMessageDialog(null, "Contato do Cliente alterado");

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			JOptionPane
					.showMessageDialog(null,
							"Erro não foi possível alterar o Contato do Cliente\n"
									+ e);

		}

	}

}
