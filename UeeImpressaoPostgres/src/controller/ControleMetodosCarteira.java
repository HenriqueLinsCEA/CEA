package controller;

import java.util.List;

import model.CarteiraDao;

public class ControleMetodosCarteira {

	
	public int inserirDadosCarteira(Carteira carteira) {

		int id_carteira = new CarteiraDao().inserirDadosCarteira(carteira);

		return id_carteira;

	}
	
	public List<Carteira> pesquisarMultiplosCampos(String campo,
			String pesquisa) {

		List<Carteira> listaConsulta = new CarteiraDao().pesquisarMultiplosCampos(campo, pesquisa);

		return listaConsulta;

	}



}
