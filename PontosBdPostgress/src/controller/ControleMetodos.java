package controller;

import java.util.List;

import model.ConfiguracaoPontosDao;
import model.UsuarioDao;

public class ControleMetodos {
	

	public static void criarTabelaClientes() {

		new model.CriarTabelas().criarTabelaClientes();

	}
	
	public static void criarTabelaUsuarios() {

		new model.CriarTabelas().criarTabelaUsuarios();

	}
	
	public static void criarTabelaHistoricoResgate() {

		new model.CriarTabelas().criarTabelaHistoricoResgate();

	}
	
	
	public static void criarTabelaConfiguracaoPontos() {

		new model.CriarTabelas().criarTabelaConfiguracaoPontos();

	}
	
	public static void deletarTabelaClientes() {

		new model.CriarTabelas().deletarTabelaclientes();
	}
	
	public static void deletarTabelaUsuarios() {

		new model.CriarTabelas().deletarTabelaUsuarios();

	}
	
	public static void deletarTabelaHistoricoResgate() {

		new model.CriarTabelas().deletarTabelahistoricoResgate();

	}
	
	public static void deletarTabelaConfiguracaoPontos() {

		new model.CriarTabelas().deletarTabelaConfiguracaoPontos();

	}
	
	
	public static void inserirAdministrador() {

		UsuarioDao usuarioDao = new UsuarioDao();

		Usuario u1 = new Usuario();
		u1.setNome("ADMINISTRADOR");
		u1.setTipo("Administrador");
		u1.setCpf("00000000001");
		u1.setLogin("adm");
		u1.setSenha(String.valueOf(1010));
		usuarioDao.inserirAdministrador(u1);

	}
	
	public static void inserirConfiguracaoPontos() {
		
		new model.ConfiguracaoPontosDao();
		ConfiguracaoPontos inicial = ConfiguracaoPontosDao.confirmarPontos();
		
		if(inicial.getPontos() == 0){
			
			ConfiguracaoPontosDao configuracaoPontosDao = new ConfiguracaoPontosDao();
			ConfiguracaoPontos configuracaoPontos = new ConfiguracaoPontos();
			configuracaoPontos.setPontos(1);
			configuracaoPontos.setValor(1);
			configuracaoPontosDao.inserirDadosConfiguracaoPontosDao(configuracaoPontos);
						
		}
		
			
	}
	
	
	    
	public static void listarClientes() {
        List<Cliente> clienteLista = new model.ClienteDao().mostrarDados();
        for (Cliente cliente : clienteLista) {
        	
        	System.out.println(cliente.toString());
            
        }
        
        
    }
	
	
	public static Cliente localizarClientePeloCpf(String cpf){
		
		Cliente cliente = new model.ClienteDao().pesquisarCpf(cpf);
		
		return cliente;	
		
	}
	
	public String removerMascara(String cpf){  
	    return cpf.replaceAll("\\D", "");  
	}  
	

}
