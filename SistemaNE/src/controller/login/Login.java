package controller.login;

public class Login {
	
	
	private int id_login;
	private String login;
	private String senha;
	private String nivelAcesso;
	
	public Login(){};
	
	public Login(String login, String senha, String nivelAcesso) {
		this.login = login;
		this.senha = senha;
		this.nivelAcesso = nivelAcesso;
	}
	
	public int getId_login() {
		return id_login;
	}
	public void setId_login(int id_login) {
		this.id_login = id_login;
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
	public String getNivelAcesso() {
		return nivelAcesso;
	}
	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nivelAcesso == null) ? 0 : nivelAcesso.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Login other = (Login) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nivelAcesso == null) {
			if (other.nivelAcesso != null)
				return false;
		} else if (!nivelAcesso.equals(other.nivelAcesso))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Login [id_login=").append(id_login).append(", login=").append(login).append(", senha=")
				.append(senha).append(", nivelAcesso=").append(nivelAcesso).append("]");
		return builder.toString();
	}
	
	
	

}
