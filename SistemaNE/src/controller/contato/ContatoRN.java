package controller.contato;

import controller.cliente.Cliente;

public class ContatoRN {
	
public void CadastrarCliente(Cliente cliente) {
		
		ContatoDAO contatoDAO = new ContatoDAO();
		contatoDAO.insereContato(cliente);
			
	}
	

}
