package controller;

import java.util.List;

import model.EnderecoDao;
import model.UsuarioDao;

public class ControleMetodosEndereco {

	
	public static List<Usuario> listarUsuario() {

		List<Usuario> listaUsuario = new UsuarioDao().listarDadosUsuario();

		return listaUsuario;

	}

	public void  cadastrarEnderecoUsuario(Endereco endereco){
		
		new EnderecoDao().inserirEnderecoUsuario(endereco);
		
				
	}
	
public void  cadastrarEnderecoCliente(Endereco endereco){
		
		new EnderecoDao().inserirEnderecoCliente(endereco);
				
	}

public static Endereco  pesquisarEnderecoCliente(int id_cliente){
	
	Endereco endereco = new EnderecoDao().pesquisarEnderecoCliente(id_cliente);
	
	return endereco;
			
}

public boolean  alterarEnderecoCliente(Endereco endereco){
	
	boolean corretoEndereco = new EnderecoDao().alterarEnderecoCliente(endereco);
	
	return corretoEndereco;
			
}

public static boolean  excluirEnderecoCliente(int id_endereco){
	
	boolean excluiuEndereco = new EnderecoDao().excluirEnderecoCliente(id_endereco);
	
	return excluiuEndereco;
			
}



}
