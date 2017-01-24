package controller.contato;

public class Contato {
	
	private int id_contato;
	private String nomeContato;
	private String emailContato;
	private String telefoneFixo;
	private String telefoneCelular;
	
	public Contato(String nomeContato, String emailContato, String telefoneFixo, String telefoneCelular) {
		this.nomeContato = nomeContato;
		this.emailContato = emailContato;
		this.telefoneFixo = telefoneFixo;
		this.telefoneCelular = telefoneCelular;
	}
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
	public String getEmailContato() {
		return emailContato;
	}
	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}
	public String getTelefone01() {
		return telefoneFixo;
	}
	public void setTelefone01(String telefone01) {
		this.telefoneFixo = telefone01;
	}
	public String getTelefone02() {
		return telefoneCelular;
	}
	public void setTelefone02(String telefone02) {
		this.telefoneCelular = telefone02;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailContato == null) ? 0 : emailContato.hashCode());
		result = prime * result + id_contato;
		result = prime * result + ((nomeContato == null) ? 0 : nomeContato.hashCode());
		result = prime * result + ((telefoneFixo == null) ? 0 : telefoneFixo.hashCode());
		result = prime * result + ((telefoneCelular == null) ? 0 : telefoneCelular.hashCode());
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
		if (telefoneFixo == null) {
			if (other.telefoneFixo != null)
				return false;
		} else if (!telefoneFixo.equals(other.telefoneFixo))
			return false;
		if (telefoneCelular == null) {
			if (other.telefoneCelular != null)
				return false;
		} else if (!telefoneCelular.equals(other.telefoneCelular))
			return false;
		return true;
	}
	
}
