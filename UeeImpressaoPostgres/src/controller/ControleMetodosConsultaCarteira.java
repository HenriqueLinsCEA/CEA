package controller;

import java.util.List;

import model.ConsultaCarteiraDao;

public class ControleMetodosConsultaCarteira {

	public List<ConsultaCarteira> listarConsulta() {

		List<ConsultaCarteira> listaConsulta = new ConsultaCarteiraDao()
				.listarDadosConsulta();

		return listaConsulta;

	}

	public int inserirConsultaCarteira(ConsultaCarteira consulta) {

		int id_consulta = new ConsultaCarteiraDao()
				.inserirConsultaCarteira(consulta);

		return id_consulta;

	}

	public List<ConsultaCarteira> pesquisarConsulta(String nome) {

		List<ConsultaCarteira> listaConsulta = new ConsultaCarteiraDao()
				.pesquisarNome(nome);

		return listaConsulta;

	}

	public List<ConsultaCarteira> pesquisarMultiplosCampos(String campo,
			String pesquisa) {

		List<ConsultaCarteira> listaConsulta = new ConsultaCarteiraDao()
				.pesquisarUsuariosMultiplosCampos(campo, pesquisa);

		return listaConsulta;

	}

}
