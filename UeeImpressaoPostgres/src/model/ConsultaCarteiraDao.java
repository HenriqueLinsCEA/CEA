package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.ConsultaCarteira;
import controller.Usuario;

public class ConsultaCarteiraDao {

	private Connection conexaoBanco;

	public ConsultaCarteiraDao() {

		this.conexaoBanco = ConectarBanco.getConnection();

	}

	public int inserirConsultaCarteira(ConsultaCarteira consultaCarteira) {

		int id_consulta = -1;

		String sql = "INSERT INTO consulta_carteira (nome, instituicao, curso, motivo, usuarioLogado, data, hora) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?) returning id_consulta";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, consultaCarteira.getNome());
			declarar.setString(2, consultaCarteira.getInstituicao());
			declarar.setString(3, consultaCarteira.getCurso());
			declarar.setString(4, consultaCarteira.getMotivo());
			declarar.setString(5, consultaCarteira.getUsuarioLogado());
			declarar.setTimestamp(6, new Timestamp(consultaCarteira.getData()
					.getTime()));
			declarar.setTime(7, consultaCarteira.getHora());

			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				id_consulta = resultado.getInt("id_consulta");

			}

			declarar.close();

			return id_consulta;

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro!! " + e);

		}

		return id_consulta;
	}

	public List<ConsultaCarteira> listarDadosConsulta() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ConsultaCarteira> pesquisarUsuariosMultiplosCampos(
			String campo, String pesquisa) {

		List<ConsultaCarteira> listaConsultaCarteira = new ArrayList<ConsultaCarteira>();

		if (campo.equalsIgnoreCase("instituição")) {

			campo = "instituicao";

		} else if (campo.equalsIgnoreCase("usuário logado")) {

			campo = "usuariologado";

		} else if (campo.equalsIgnoreCase("Situação")) {

			campo = "motivo";

		}

		String sql = "SELECT * FROM consulta_carteira WHERE " + campo
				+ " like ? ";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, pesquisa + "%");
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				ConsultaCarteira consultaCarteira = new ConsultaCarteira();

				consultaCarteira.setNome(resultado.getString("nome"));
				consultaCarteira.setInstituicao(resultado
						.getString("instituicao"));
				consultaCarteira.setCurso(resultado.getString("curso"));
				consultaCarteira.setMotivo(resultado.getString("motivo"));
				consultaCarteira.setUsuarioLogado(resultado
						.getString("usuariologado"));
				consultaCarteira.setData(resultado.getDate("data"));
				consultaCarteira.setHora(resultado.getTime("hora"));

				listaConsultaCarteira.add(consultaCarteira);

			}

			resultado.close();
			declarar.close();

			return listaConsultaCarteira;

		} catch (SQLException e) {

			e.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"Erro ao acessar a Tabela Usuários");

		}

		return listaConsultaCarteira;

	}

	public List<ConsultaCarteira> pesquisarNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * public List<Historico> mostrarDados() {
	 * 
	 * List<Historico> ListaHistorico = new ArrayList<Historico>();
	 * 
	 * String sql = "SELECT * FROM historicoResgate";
	 * 
	 * try {
	 * 
	 * PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
	 * ResultSet resultado = declarar.executeQuery();
	 * 
	 * while (resultado.next()) {
	 * 
	 * Historico historico = new Historico();
	 * 
	 * historico.setId_historico(resultado.getInt("id_historico"));
	 * historico.setLogado(resultado.getString("logado"));
	 * historico.setLogadoCpf(resultado.getString("logadoCpf"));
	 * historico.setLocalizado(resultado.getString("localizado")); historico
	 * .setLocalizadoCpf(resultado.getString("localizadoCpf"));
	 * historico.setResgate(resultado.getInt("resgate"));
	 * historico.setPontosAtualizado(resultado .getInt("pontosAtualizado"));
	 * historico.setData(resultado.getDate("data"));
	 * historico.setHora(resultado.getTime("hora"));
	 * 
	 * ListaHistorico.add(historico);
	 * 
	 * }
	 * 
	 * resultado.close(); declarar.close();
	 * 
	 * return ListaHistorico;
	 * 
	 * } catch (SQLException e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * JOptionPane.showMessageDialog(null, "Erro ao acessar a Tabela Clientes");
	 * 
	 * }
	 * 
	 * return null;
	 * 
	 * }
	 */

}
