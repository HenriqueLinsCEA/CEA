package controller.endereco;

import controller.cliente.Cliente;

public class EnderecoRN {
	
public void CadastrarCliente(Cliente cliente) {
		
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		enderecoDAO.insereEndereco(cliente);
		
	}
	

}
