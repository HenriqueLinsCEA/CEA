package controller;

public class Contato {
	
	private int id_contato;
	private String nomeContato;
	private String email;
	private String telefone01;
	private String telefone02;
	
	public int getId_contato() {
		return id_contato;
	}
	public void setId_contato(int id_contato) {
		this.id_contato = id_contato;
	}
	public String getNomeContato() {
		return nomeContato;
	}
	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone01() {
		return telefone01;
	}
	public void setTelefone01(String telefone01) {
		this.telefone01 = telefone01;
	}
	public String getTelefone02() {
		return telefone02;
	}
	public void setTelefone02(String telefone02) {
		this.telefone02 = telefone02;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id_contato;
		result = prime * result + ((nomeContato == null) ? 0 : nomeContato.hashCode());
		result = prime * result + ((telefone01 == null) ? 0 : telefone01.hashCode());
		result = prime * result + ((telefone02 == null) ? 0 : telefone02.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id_contato != other.id_contato)
			return false;
		if (nomeContato == null) {
			if (other.nomeContato != null)
				return false;
		} else if (!nomeContato.equals(other.nomeContato))
			return false;
		if (telefone01 == null) {
			if (other.telefone01 != null)
				return false;
		} else if (!telefone01.equals(other.telefone01))
			return false;
		if (telefone02 == null) {
			if (other.telefone02 != null)
				return false;
		} else if (!telefone02.equals(other.telefone02))
			return false;
		return true;
	}
	
}
