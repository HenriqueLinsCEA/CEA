package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.Contato;
import controller.Layout;

public class LayoutDao {

	private static Connection conexaoBanco;

	public LayoutDao() {

		LayoutDao.conexaoBanco = ConectarBanco.getConnection();

	}

	public int inserirLayout(Layout layout) {

		int id_layout = -1;

		String sql = "INSERT INTO layout (produto, tipo_produto, espessura, classe_produto, furado, presilha_ou_cordao, orientacao, protetor, cor, acesso, impressao, local_frente, local_verso, id_cliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) returning id_layout";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setString(1, layout.getProduto());
			declarar.setString(2, layout.getTipoProduto());
			declarar.setString(3, layout.getEspessura());
			declarar.setString(4, layout.getClasseProduto());
			declarar.setBoolean(5, layout.isFurado());
			declarar.setString(6, layout.getPresilhaOuCordao());
			declarar.setString(7, layout.getOrientacao());
			declarar.setString(8, layout.getProtetor());
			declarar.setString(9, layout.getCor());
			declarar.setBoolean(10, layout.isAcesso());
			declarar.setString(11, layout.getImpressao());
			declarar.setString(12, layout.getLocaFrente());
			declarar.setString(13, layout.getLocalVerso());
			declarar.setInt(14, layout.getId_cliente());

			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				id_layout = resultado.getInt("id_layout");

			}

			//JOptionPane.showMessageDialog(null, "Layout cadastrado com sucesso");

			declarar.close();

			return id_layout;

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro" + e);

		}

		return id_layout;

	}
	
	public List<Layout> listarLayout(int id_cliente) {

		List<Layout> listaLayout = new ArrayList<Layout>();
		
		String sql = "SELECT * FROM layout where id_cliente = ? ";

		try {
						
			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);
			
			declarar.setInt(1, id_cliente);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {
				
				Layout layout = new Layout();
								
				layout.setId_cliente(resultado.getInt("id_cliente"));
				layout.setId_layout(resultado.getInt("id_layout"));
				layout.setClasseProduto(resultado.getString("classe_produto"));
				layout.setLocalFrente(resultado.getString("local_frente"));
				layout.setLocalVerso(resultado.getString("local_verso"));
				
				listaLayout.add(layout);

			}

			resultado.close();
			declarar.close();

			return listaLayout;

		} catch (SQLException e) {
			
			e.printStackTrace();

			JOptionPane.showMessageDialog(null,
					"Erro ao acessar a Tabela Cliente");

		}

		return listaLayout ;

	}

	public  Layout pesquisarLayout(int id_cliente) {
		
		Layout layout = new Layout();

		String sql = "SELECT * FROM layout Where id_cliente = ? ";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, id_cliente);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				layout.setId_layout(resultado.getInt("id_layout"));
				layout.setId_cliente(resultado.getInt("id_cliente"));
				layout.setProduto(resultado.getString("produto"));
				layout.setTipoProduto(resultado.getString("tipo_produto"));
				layout.setEspessura(resultado.getString("espessura"));
				layout.setClasseProduto(resultado.getString("classe_produto"));
				layout.setFurado(resultado.getBoolean("furado"));
				layout.setPresilhaOuCordao(resultado.getString("presilha_ou_cordao"));
				layout.setOrientacao(resultado.getString("orientacao"));
				layout.setProtetor(resultado.getString("protetor"));
				layout.setCor(resultado.getString("cor"));
				layout.setAcesso(resultado.getBoolean("acesso"));
				layout.setImpressao(resultado.getString("impressao"));
				layout.setLocalFrente(resultado.getString("local_frente"));
				layout.setLocalVerso(resultado.getString("local_verso"));
				
			}

			resultado.close();
			declarar.close();

			return layout;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "erro" + e);

		}

		return layout;
	}
	
public  Layout pesquisarLayoutCorreto(int id_layout) {
		
		Layout layoutCorreto = new Layout();

		String sql = "SELECT * FROM layout Where id_layout = ? ";

		try {

			PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

			declarar.setInt(1, id_layout);
			ResultSet resultado = declarar.executeQuery();

			while (resultado.next()) {

				layoutCorreto.setId_layout(resultado.getInt("id_layout"));
				layoutCorreto.setId_cliente(resultado.getInt("id_cliente"));
				layoutCorreto.setProduto(resultado.getString("produto"));
				layoutCorreto.setTipoProduto(resultado.getString("tipo_produto"));
				layoutCorreto.setEspessura(resultado.getString("espessura"));
				layoutCorreto.setClasseProduto(resultado.getString("classe_produto"));
				layoutCorreto.setFurado(resultado.getBoolean("furado"));
				layoutCorreto.setPresilhaOuCordao(resultado.getString("presilha_ou_cordao"));
				layoutCorreto.setOrientacao(resultado.getString("orientacao"));
				layoutCorreto.setProtetor(resultado.getString("protetor"));
				layoutCorreto.setCor(resultado.getString("cor"));
				layoutCorreto.setAcesso(resultado.getBoolean("acesso"));
				layoutCorreto.setImpressao(resultado.getString("impressao"));
				layoutCorreto.setLocalFrente(resultado.getString("local_frente"));
				layoutCorreto.setLocalVerso(resultado.getString("local_verso"));
				
			}

			resultado.close();
			declarar.close();

			return layoutCorreto;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "erro" + e);

		}

		return layoutCorreto;
	}

public boolean excluirLayoutCliente(int id_layout) {

	boolean excluiuLayout = false;
	
	String sql = "DELETE FROM layout WHERE id_layout = ?";

	try {

		PreparedStatement declarar = conexaoBanco.prepareStatement(sql);

		declarar.setInt(1, id_layout);

		declarar.execute();
		declarar.close();

		excluiuLayout = true;
		
		return excluiuLayout;

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

		JOptionPane.showMessageDialog(null,
				"Erro Layout  não excluído do Banco de Dados");
	}
	
	return excluiuLayout;

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
