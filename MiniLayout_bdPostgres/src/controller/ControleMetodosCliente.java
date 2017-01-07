package controller;

import java.util.List;

import model.ClienteDao;

public class ControleMetodosCliente {

	public int cadastrarCliente(Cliente cliente) {

		int id_cliente = new ClienteDao().inserirDadosCliente(cliente);

		return id_cliente;

	}

	public boolean alterarDadosCliente(Cliente cliente) {

		boolean corretoCliente = new ClienteDao().alterarDadosCliente(cliente);
		
		return corretoCliente;

	}

	public static List<Cliente> listarCliente() {

		List<Cliente> listaCliente = new ClienteDao().listarDadosCliente();

		return listaCliente;

	}

	public static List<Cliente> pesquisarCliente(String pesquisaNome) {

		List<Cliente> listaCliente = new ClienteDao()
				.pesquisarNome(pesquisaNome);

		return listaCliente;

	}

	public static Cliente pesquisarUnicoCliente(String pesquisaNome) {

		Cliente cliente = new ClienteDao().pesquisarUnicoNome(pesquisaNome);

		return cliente;

	}

	public static List<Cliente> pesquisarClienteMultiplosCampos(String campo,
			String pesquisa) {

		List<Cliente> listaCliente = new ClienteDao().pesquisarMultiplosCampos(
				campo, pesquisa);

		return listaCliente;

	}
	
	public static boolean excluirDadosCliente(int id_cliente) {

		boolean excluiuDados = new ClienteDao().excluirDadosCliente(id_cliente);
		
		return excluiuDados;

	}


}
