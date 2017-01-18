package controller;

public class Contato {
	
	private int id_contato;
	private String nomeContato;
	private String emailContato;
	private String telefoneContato01;
	private String telefoneContato02;
	
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
		return emailContato;
	}
	public void setEmail(String emailContato) {
		this.emailContato = emailContato;
	}
	public String getTelefone01() {
		return telefoneContato01;
	}
	public void setTelefone01(String telefone01) {
		this.telefoneContato01 = telefone01;
	}
	public String getTelefone02() {
		return telefoneContato02;
	}
	public void setTelefone02(String telefone02) {
		this.telefoneContato02 = telefone02;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailContato == null) ? 0 : emailContato.hashCode());
		result = prime * result + id_contato;
		result = prime * result + ((nomeContato == null) ? 0 : nomeContato.hashCode());
		result = prime * result + ((telefoneContato01 == null) ? 0 : telefoneContato01.hashCode());
		result = prime * result + ((telefoneContato02 == null) ? 0 : telefoneContato02.hashCode());
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
		if (emailContato == null) {
			if (other.emailContato != null)
				return false;
		} else if (!emailContato.equals(other.emailContato))
			return false;
		if (id_contato != other.id_contato)
			return false;
		if (nomeContato == null) {
			if (other.nomeContato != null)
				return false;
		} else if (!nomeContato.equals(other.nomeContato))
			return false;
		if (telefoneContato01 == null) {
			if (other.telefoneContato01 != null)
				return false;
		} else if (!telefoneContato01.equals(other.telefoneContato01))
			return false;
		if (telefoneContato02 == null) {
			if (other.telefoneContato02 != null)
				return false;
		} else if (!telefoneContato02.equals(other.telefoneContato02))
			return false;
		return true;
	}
	
}
