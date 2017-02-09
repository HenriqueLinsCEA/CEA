package controller.usuario;

import java.sql.Date;

import controller.endereco.Endereco;
import controller.login.Login;

public class Usuario {

	private int id_usuario;
	private String nomeUsuario;
	private String funcaoUsuario;
	private String cpf;
	private String telefoneUsuario;
	private String emailUsuario;
	private String statusUsuario;
	private Date dataNascimento;
	private Login login;
	private Endereco endereco;

	
	public Usuario(){}
	
	public Usuario(String nomeUsuario, String funcaoUsuario, String cpf, String telefoneUsuario, String emailUsuario,
			String statusUsuario, Date dataNascimento) {

		this.nomeUsuario = nomeUsuario;
		this.funcaoUsuario = funcaoUsuario;
		this.cpf = cpf;
		this.telefoneUsuario = telefoneUsuario;
		this.emailUsuario = emailUsuario;
		this.statusUsuario = statusUsuario;
		this.dataNascimento = dataNascimento;

	}

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

	public String getFuncaoUsuario() {
		return funcaoUsuario;
	}

	public void setFuncaoUsuario(String funcaoUsuario) {
		this.funcaoUsuario = funcaoUsuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getStatusUsuario() {
		return statusUsuario;
	}

	public void setStatusUsuario(String statusUsuario) {
		this.statusUsuario = statusUsuario;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((emailUsuario == null) ? 0 : emailUsuario.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((funcaoUsuario == null) ? 0 : funcaoUsuario.hashCode());
		result = prime * result + id_usuario;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nomeUsuario == null) ? 0 : nomeUsuario.hashCode());
		result = prime * result + ((statusUsuario == null) ? 0 : statusUsuario.hashCode());
		result = prime * result + ((telefoneUsuario == null) ? 0 : telefoneUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (emailUsuario == null) {
			if (other.emailUsuario != null)
				return false;
		} else if (!emailUsuario.equals(other.emailUsuario))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (funcaoUsuario == null) {
			if (other.funcaoUsuario != null)
				return false;
		} else if (!funcaoUsuario.equals(other.funcaoUsuario))
			return false;
		if (id_usuario != other.id_usuario)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nomeUsuario == null) {
			if (other.nomeUsuario != null)
				return false;
		} else if (!nomeUsuario.equals(other.nomeUsuario))
			return false;
		if (statusUsuario == null) {
			if (other.statusUsuario != null)
				return false;
		} else if (!statusUsuario.equals(other.statusUsuario))
			return false;
		if (telefoneUsuario == null) {
			if (other.telefoneUsuario != null)
				return false;
		} else if (!telefoneUsuario.equals(other.telefoneUsuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [id_usuario=").append(id_usuario).append(", nomeUsuario=").append(nomeUsuario)
				.append(", funcaoUsuario=").append(funcaoUsuario).append(", cpf=").append(cpf)
				.append(", telefoneUsuario=").append(telefoneUsuario).append(", emailUsuario=").append(emailUsuario)
				.append(", statusUsuario=").append(statusUsuario).append(", dataNascimento=").append(dataNascimento)
				.append(", login=").append(login).append(", endereco=").append(endereco).append("]");
		return builder.toString();
	}
	
	

}
