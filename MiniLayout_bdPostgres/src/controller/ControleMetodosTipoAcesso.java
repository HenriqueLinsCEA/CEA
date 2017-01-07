package controller;

import model.TipoAcessoDao;

public class ControleMetodosTipoAcesso {

	
	public void CadastrarTipoAcesso(TipoAcesso tipoAcesso){
		
		new TipoAcessoDao().inserirTipoAcesso(tipoAcesso);
		

	}

	public static TipoAcesso pesquisarTipoAcesso(int id_layout) {
	
		
		TipoAcesso tipoAcesso = new  TipoAcessoDao().pesquisarTipoAcesso(id_layout);
		
		return tipoAcesso;
		
	}
	
public static boolean excluirTipoAcessoCliente(int id_acesso){
		
	boolean excluiuTipoAcesso =  new TipoAcessoDao().excluirTipoAcessoCliente(id_acesso);
	
	return excluiuTipoAcesso;
		
	}
	

}
