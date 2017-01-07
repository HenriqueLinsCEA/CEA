package controller;


public class Usuario extends Pessoa {
	
	private int id_usuario;
	private String cpf;
	private String login;
	private String senha;
	private String tipo;
	private Contato contato;
	private Endereco endereco;

	
	public Usuario() {
	
	}
	
	public Usuario(String nome, String cpf, String login, String senha, String tipo){
		
		this.nome = nome;
		this.cpf = cpf;
		this.login = login;
		this.senha = senha;
		this.tipo = tipo;
		
	}

	public Usuario(int id_usuario, String cpf,
			String login, String senha,
			String tipo, String nomeParaContato, String email,
			String telefone1, String telefone2, String logradouro, String complemento,
			String numero, String bairro, String cidade, String uf, String cep) {
		
		this.id_usuario = id_usuario;
		this.cpf = cpf;
		this.login = login;
		this.senha = senha;
		this.tipo = tipo;
		this.contato.setEmail(email);
		this.contato.setTelefone1(telefone1);
		this.contato.setTelefone2(telefone2);
		this.endereco.setLogradouro(logradouro);
		this.endereco.setComplemento(complemento);
		this.endereco.setNumero(numero);
		this.endereco.setBairro(bairro);
		this.endereco.setCidade(cidade);
		this.endereco.setUf(uf);
		this.endereco.setCep(cep);
		
	}
	
	public Usuario(int id_usuario, String cpf,
			String login, String senha,
			String tipo) {
		
		this.id_usuario = id_usuario;
		this.cpf = cpf;
		this.login = login;
		this.senha = senha;
		this.tipo = tipo;
		
		
	}
	
	public Usuario(String nomeParaContato, String email,
			String telefone1, String telefone2) {
		
		this.contato.setNomeParaContato(nomeParaContato);
		this.contato.setEmail(email);
		this.contato.setTelefone1(telefone1);
		this.contato.setTelefone2(telefone2);
				
	}
	
	public Usuario(String logradouro, String complemento,
			String numero, String bairro, String cidade, String uf, String cep) {
		
		this.endereco.setLogradouro(logradouro);
		this.endereco.setComplemento(complemento);
		this.endereco.setNumero(numero);
		this.endereco.setBairro(bairro);
		this.endereco.setCidade(cidade);
		this.endereco.setUf(uf);
		this.endereco.setCep(cep);
		
	}
	
	
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(login);
		return builder.toString();
	}
	
	

	
}
