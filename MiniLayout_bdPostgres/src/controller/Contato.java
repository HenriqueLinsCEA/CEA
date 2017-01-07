package controller;

public class Contato {

	private int id_contato;
	private String nomeParaContato;
	private String email;
	private String telefone1;
	private String telefone2;
	private int id_usuario;
	private int id_cliente;

	public Contato() {

	}

	public Contato(int id_cliente, String nomeParaContato, String email,
			String telefone1, String telefone2) {

		this.id_cliente = id_cliente;
		this.nomeParaContato = nomeParaContato;
		this.email = email;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;

	}

	public Contato(int id_cliente, String nomeParaContato, String email,
			String telefone1, String telefone2, int id_contato) {

		this.id_cliente = id_cliente;
		this.nomeParaContato = nomeParaContato;
		this.email = email;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.id_contato = id_contato;

	}

	public Contato(String nomeParaContato, String email, String telefone1,
			String telefone2, int id_usuario) {

		this.nomeParaContato = nomeParaContato;
		this.email = email;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.id_usuario = id_usuario;

	}

	public String getNomeParaContato() {
		return nomeParaContato;
	}

	public void setNomeParaContato(String nomeParaContato) {
		this.nomeParaContato = nomeParaContato;
	}

	public int getId_contato() {
		return id_contato;
	}

	public void setId_contato(int id_contato) {
		this.id_contato = id_contato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

}
