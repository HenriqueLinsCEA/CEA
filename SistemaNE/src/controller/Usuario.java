package controller;

public class Usuario {
	
	private int  id_usuario;
	private String nomeUsuario;
	private String setor;
	private String CPF;
	private String telefoneUsuario;
	private String emailUsuario;
	private Boolean statusUsuario;
	private Endereco endereco;
	private Login login;
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getTelefoneUsuario() {
		return telefoneUsuario;
	}
	public void setTelefoneUsuario(String telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	public Boolean getStatusUsuario() {
		return statusUsuario;
	}
	public void setStatusUsuario(Boolean statusUsuario) {
		this.statusUsuario = statusUsuario;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	
	

}
