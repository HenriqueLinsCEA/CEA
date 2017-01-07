package controller;

public class Pessoa {
	
	protected int id;
	protected String nome;
	protected Contato contato;
	protected Endereco endereco;
	
	public Pessoa() {
		
	}

	public Pessoa(int id, String nome, String nomeParaContato, String email,
			String telefone1, String telefone2, String logradouro, String complemento,
			String numero, String bairro, String cidade, String uf, String cep) {
		
		this.id = id;
		this.nome = nome;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	
	
	
	
}
