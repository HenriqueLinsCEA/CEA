package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.Historico;

public class HistoricoDao {
	
	private static Connection conexaoBanco;

	public HistoricoDao() {

		HistoricoDao.conexaoBanco = ConectarBanco.getConnection();

	}

	public Historico inserirHistorico(Historico historico) {

		String sql = "INSERT INTO historicoResgate (logado, logadoCpf, localizado, localizadoCpf, transacao, valor, pontosAtualizado, data , hora) VALUES (?, ?, ?, ?, ? , ?, ?, ?, ?)";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, historico.getLogado());
			declarar.setString(2, historico.getLogadoCpf());
			declarar.setString(3, historico.getLocalizado());
			declarar.setString(4, historico.getLocalizadoCpf());
			declarar.setString(5, historico.getTransacao());
			declarar.setInt(6, historico.getValor());
			declarar.setInt(7, historico.getPontosAtualizado());
			declarar.setTimestamp(8, new Timestamp(historico.getData().getTime()));
			declarar.setTime(9, historico.getHora());
			
			declarar.execute();
			declarar.close();

			
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e);

			
			return historico;

		}

		return historico;

	}
	
	public static List<Historico> mostrarDados() {

		List<Historico> ListaHistorico = new ArrayList<Historico>();

		String sql = "SELECT * FROM historicoResgate";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				Historico historico = new Historico();

				historico.setId_historico(resultado.getInt("id_historico"));
				historico.setLogado(resultado.getString("logado"));
				historico.setLogadoCpf(resultado.getString("logadoCpf"));
				historico.setLocalizado(resultado.getString("localizado"));
				historico.setLocalizadoCpf(resultado.getString("localizadoCpf"));
				historico.setTransacao(resultado.getString("transacao"));
				historico.setValor(resultado.getInt("valor"));
				historico.setPontosAtualizado(resultado.getInt("pontosAtualizado"));
				historico.setData(resultado.getDate("data"));
				historico.setHora(resultado.getTime("hora"));
											
				ListaHistorico.add(historico);

			}

			resultado.close();
			declarar.close();

			return ListaHistorico;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		
		}

		return null;

	}

	public static List<Historico> pesquisarNomeUsuario(String nome) {

		List<Historico> ListaHistorico = new ArrayList<Historico>();
		

		String sql = "SELECT * FROM historicoResgate WHERE logado like ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, nome + "%");
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {
				
				Historico historico = new Historico();
				
				historico.setId_historico(resultado.getInt("id_historico"));
				historico.setLogado(resultado.getString("logado"));
				historico.setLogadoCpf(resultado.getString("logadoCpf"));
				historico.setLocalizado(resultado.getString("localizado"));
				historico.setLocalizadoCpf(resultado.getString("localizadoCpf"));
				historico.setTransacao(resultado.getString("transacao"));
				historico.setValor(resultado.getInt("valor"));
				historico.setPontosAtualizado(resultado.getInt("pontosAtualizado"));
				historico.setData(resultado.getDate("data"));
				historico.setHora(resultado.getTime("hora"));
											
				ListaHistorico.add(historico);

			}

			resultado.close();
			declarar.close();

			return ListaHistorico;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return null;
	}
	
	public static List<Historico> pesquisarNomeCliente(String nome) {

		List<Historico> ListaHistorico = new ArrayList<Historico>();
		

		String sql = "SELECT * FROM historicoResgate WHERE localizado like ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, nome + "%");
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {
				
				Historico historico = new Historico();
				
				historico.setId_historico(resultado.getInt("id_historico"));
				historico.setLogado(resultado.getString("logado"));
				historico.setLogadoCpf(resultado.getString("logadoCpf"));
				historico.setLocalizado(resultado.getString("localizado"));
				historico.setLocalizadoCpf(resultado.getString("localizadoCpf"));
				historico.setTransacao(resultado.getString("transacao"));
				historico.setValor(resultado.getInt("valor"));
				historico.setPontosAtualizado(resultado.getInt("pontosAtualizado"));
				historico.setData(resultado.getDate("data"));
				historico.setHora(resultado.getTime("hora"));
											
				ListaHistorico.add(historico);

			}

			resultado.close();
			declarar.close();

			return ListaHistorico;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return null;
	}
	
	public static List<Historico> pesquisarCpfCliente(String cpf) {
		
		List<Historico> ListaHistorico = new ArrayList<Historico>();
		

		String sql = "SELECT * FROM historicoResgate WHERE localizadoCpf = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, cpf);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {
				
				Historico historico = new Historico();

				historico.setId_historico(resultado.getInt("id_historico"));
				historico.setLogado(resultado.getString("logado"));
				historico.setLogadoCpf(resultado.getString("logadoCpf"));
				historico.setLocalizado(resultado.getString("localizado"));
				historico.setLocalizadoCpf(resultado.getString("localizadoCpf"));
				historico.setTransacao(resultado.getString("transacao"));
				historico.setValor(resultado.getInt("valor"));
				historico.setPontosAtualizado(resultado.getInt("pontosAtualizado"));
				historico.setData(resultado.getDate("data"));
				historico.setHora(resultado.getTime("hora"));
				
				ListaHistorico.add(historico);

			}
			
		
			resultado.close();
			declarar.close();

			return ListaHistorico;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return null;
	}
	
public static List<Historico> pesquisarCpfUsuario(String cpf) {
		
		List<Historico> ListaHistorico = new ArrayList<Historico>();
		

		String sql = "SELECT * FROM historicoResgate WHERE logadoCpf = ?";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, cpf);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {
				
				Historico historico = new Historico();

				historico.setId_historico(resultado.getInt("id_historico"));
				historico.setLogado(resultado.getString("logado"));
				historico.setLogadoCpf(resultado.getString("logadoCpf"));
				historico.setLocalizado(resultado.getString("localizado"));
				historico.setLocalizadoCpf(resultado.getString("localizadoCpf"));
				historico.setTransacao(resultado.getString("transacao"));
				historico.setValor(resultado.getInt("valor"));
				historico.setPontosAtualizado(resultado.getInt("pontosAtualizado"));
				historico.setData(resultado.getDate("data"));
				historico.setHora(resultado.getTime("hora"));
				
				ListaHistorico.add(historico);

			}
			
		
			resultado.close();
			declarar.close();

			return ListaHistorico;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return null;
	}

public static List<Historico> pesquisarData(Date dataInicial, Date dataFinal) {
	
	List<Historico> ListaHistorico = new ArrayList<Historico>();
	

	String sql = "SELECT * FROM historicoResgate WHERE data BETWEEN '2015-04-03' AND '2015-04-03'";

	try {

		PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

		declarar.setDate(1, (Date) dataInicial);
		declarar.setDate(1, (Date) dataFinal);
		ResultSet resultado = declarar.executeQuery();

		while (resultado.next()) {
			
			Historico historico = new Historico();

			historico.setId_historico(resultado.getInt("id_historico"));
			historico.setLogado(resultado.getString("logado"));
			historico.setLogadoCpf(resultado.getString("logadoCpf"));
			historico.setLocalizado(resultado.getString("localizado"));
			historico.setLocalizadoCpf(resultado.getString("localizadoCpf"));
			historico.setTransacao(resultado.getString("transacao"));
			historico.setValor(resultado.getInt("valor"));
			historico.setPontosAtualizado(resultado.getInt("pontosAtualizado"));
			historico.setData(resultado.getDate("data"));
			historico.setHora(resultado.getTime("hora"));
			
			ListaHistorico.add(historico);

		}
		
	
		resultado.close();
		declarar.close();

		return ListaHistorico;

	} catch (SQLException e) {

		e.printStackTrace();

	}

	return null;
}


}
