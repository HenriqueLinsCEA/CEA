package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.ConfiguracaoPontos;

public class ConfiguracaoPontosDao {
	
	
	
	private static Connection conexaoBanco;

	public ConfiguracaoPontosDao() {

		ConfiguracaoPontosDao.conexaoBanco = ConectarBanco.getConnection();

	}

	public void inserirDadosConfiguracaoPontosDao(
			ConfiguracaoPontos configuracaoPontos) {

		String sql = "INSERT INTO configuracaoPontos (pontos, valor) "
				+ "VALUES (?, ?)";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, configuracaoPontos.getPontos());
			declarar.setInt(2, configuracaoPontos.getValor());

			declarar.execute();
			declarar.close();

			JOptionPane.showMessageDialog(null,
					"Configuracao cadastrada com sucesso");

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e);

			configuracaoPontos.setPontos(0);
			configuracaoPontos.setValor(0);
			
		}

		
	}

	public void alterarConfiguracaoPontos(ConfiguracaoPontos configuracaoPontos) {

		String sql = "UPDATE configuracaoPontos SET pontos = ?, valor = ? WHERE id_configuracaoPontos = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, configuracaoPontos.getPontos());
			declarar.setInt(2, configuracaoPontos.getValor());
			declarar.setInt(3, configuracaoPontos.getId_configuracaoPontos());

			declarar.execute();
			declarar.close();

			JOptionPane.showMessageDialog(null,
					"Configuracao alterada com sucesso");

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			JOptionPane.showMessageDialog(null,
					"Erro não foi possível alterar a base de dados\n" + e);

		}

	}

	public static void alterarValor(ConfiguracaoPontos configuracaoPontos) {

		String sql = "UPDATE configuracaoPontos SET valor = ?  WHERE id_configuracaoPontos = ? " ;
		
				
		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, configuracaoPontos.getValor());
			declarar.setInt(2, configuracaoPontos.getId_configuracaoPontos());

			declarar.execute();
			declarar.close();

			JOptionPane.showMessageDialog(null, "Valor modificado com sucesso");
			
			

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null,
					"Erro não foi possível modificar o Valor");
			
		}

	}

	public void adicionarPontos(ConfiguracaoPontos configuracacaoPontos) {

		String sql = "UPDATE configuracaoPontos SET pontos = ?  WHERE id_configuracaoPontos = ?";
		ConfiguracaoPontos configuracaoPontos = new ConfiguracaoPontos();
		
		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, configuracaoPontos.getPontos());
			declarar.setInt(2, configuracaoPontos.getId_configuracaoPontos());

			declarar.execute();
			declarar.close();

			JOptionPane
					.showMessageDialog(null, "Pontos modificado com sucesso");

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null,
					"Erro não foi possível modificar os Pontos");

		}

	}

	public int Id_ConfiguaracaoPontos() {

		String sql = "SELECT * FROM configuracaoPontos WHERE id_configuracaoPontos = ?";
		int id = 0;

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				id = resultado.getInt("Id_configuracaoPontos");

			}

			resultado.close();
			declarar.close();

			return id;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return id;
	}
	
	
	public static ConfiguracaoPontos confirmarPontos() {

		String sql = "SELECT * FROM configuracaoPontos";
		ConfiguracaoPontos configuracaoPontos = new ConfiguracaoPontos();

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				configuracaoPontos.setId_configuracaoPontos(resultado.getInt("Id_configuracaoPontos"));
				configuracaoPontos.setPontos(resultado.getInt("pontos"));
				configuracaoPontos.setValor(resultado.getInt("valor"));
								
			}

			resultado.close();
			declarar.close();

			return configuracaoPontos;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return configuracaoPontos;
	}
	
	public int retornoPontos() {
		
		int pontos = 0;
		String sql = "SELECT * FROM configuracaoPontos";
		

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {
				
				pontos = resultado.getInt("pontos");
				
			}

			resultado.close();
			declarar.close();

			return pontos;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return pontos;
	}
	
}
