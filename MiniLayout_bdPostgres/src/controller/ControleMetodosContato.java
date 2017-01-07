package controller;

import model.ContatoDao;

public class ControleMetodosContato {

	public void cadastrarContatoUsuario(Contato contato) {

		new ContatoDao().inserirContatoUsuario(contato);

	}

	public void cadastrarContatoCliente(Contato contato) {

		new ContatoDao().inserirContatoCliente(contato);

	}

	public static Contato pesquisarContatoEndereco(int id_cliente) {

		Contato contatoCliente = new ContatoDao().localizarContatoCliente(id_cliente);
		
		return contatoCliente;

	}

	public boolean alterarContatoCliente(Contato contato) {

		boolean corretoContato = new ContatoDao().alterarContatoCliente(contato);
		
		return corretoContato;
		
	}
	
	public static boolean excluirContatoCliente(int id_contato) {

		boolean excluiuContato = new ContatoDao().excluirContatoCliente(id_contato);
		
		return excluiuContato;
		

	}

}
