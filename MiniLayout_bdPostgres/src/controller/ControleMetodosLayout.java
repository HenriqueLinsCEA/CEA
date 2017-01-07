package controller;

import java.util.List;

import model.LayoutDao;

public class ControleMetodosLayout {

	public int cadastrarLayout(Layout layout) {

		int id_layout = new LayoutDao().inserirLayout(layout);

		return id_layout;

	}

	public static List<Layout> listarLayout(int id_cliente) {

		List<Layout> listaLayout = new LayoutDao().listarLayout(id_cliente);

		return listaLayout;

	}

	public static Layout pesquisarLayout(int id_cliente) {

		Layout layout = new LayoutDao().pesquisarLayout(id_cliente);

		return layout;

	}

	public static Layout pesquisarLayoutCorreto(int id_layout) {

		Layout layoutCorreto = new LayoutDao()
				.pesquisarLayoutCorreto(id_layout);

		return layoutCorreto;

	}

	public static String simNao(boolean booleano) {

		Boolean trueFalse = booleano;
		String simNao;

		if (trueFalse == true) {

			simNao = "Sim";

		} else {

			simNao = "Não";

		}

		return simNao;

	}

	public static boolean excluirLayoutCliente(int id_layout) {

		boolean excluiuLayout = new LayoutDao().excluirLayoutCliente(id_layout);
		
		return excluiuLayout;

	}

}
