package controller;

import java.util.List;

import javax.swing.text.MaskFormatter;

import view.TelaPrincipal;

public class Usuario {
	
	private int id_usuario;
	private String nome;
	private String tipo;
	private String cpf;
	private String login;
	private String senha;
	
	
	public Usuario(){
		
	}
	
	public Usuario(String login,
			String senha) {
				
		this.login = login;
		this.senha = senha;
		
	}
	
	public Usuario(String nome, String tipo, String cpf, String login,
			String senha) {
		
		
		this.nome = nome;
		this.tipo = tipo;
		this.cpf = cpf;
		this.login = login;
		this.senha = senha;
	}
	
	
	public Usuario(int id_usuario, String nome, String tipo, String cpf, String login,
			String senha) {
		
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.tipo = tipo;
		this.cpf = cpf;
		this.login = login;
		this.senha = senha;
	}
	
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [id_usuario=").append(id_usuario)
				.append(", nome=").append(nome).append(", tipo=").append(tipo)
				.append(", cpf=").append(cpf).append(", login=").append(login)
				.append(", senha=").append(senha).append("]");
		return builder.toString();
	}

	public static String removerMascara(String cpf){  
	    return cpf.replaceAll("\\D", "");  
	} 
	
	public static MaskFormatter Mascara(String Mascara){  
        
	       MaskFormatter F_Mascara = new MaskFormatter();  
	       try{  
	           F_Mascara.setMask("###.###.###-##"); //Atribui a mascara  
	           F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento   
	       }  
	       catch (Exception excecao) {  
	       excecao.printStackTrace();  
	       }   
	       return F_Mascara;  
	}   
	
	public static Usuario localizarUsuarioPeloCpf(String cpf){
		
		Usuario usuario = new model.UsuarioDao().pesquisarCpfUsuario(cpf);
		
		return usuario;	
		
	}
	
	public static Usuario localizarUsuarioPeloNome(String nome){
		
		Usuario usuario = new model.UsuarioDao().pesquisarNomeUsuario(nome);
		
		return usuario;	
		
	}
	
	public static void excluirUsuarios() {
        
 
        new model.UsuarioDao().excluirUsuario(TelaPrincipal.usuarioLocalizado);
 
       
    }
	
	public static List<Usuario> localizarUsuarioParteDoNome(String nome){
		
		List<Usuario> ListaUsuario = new model.UsuarioDao().pesquisarNome(nome);
		
		return ListaUsuario;	
		
	}
	
	
	
	

}
