package controller;

import java.sql.Date;
import java.sql.Time;

public class Log {
	
	private String loginUsuarioLogado;
	private String nomeUsuarioLogado;
	private String atividade;
	private Date data;
	private Time hora;
	

	public Log(String loginUsuarioLogado, String nomeUsuarioLogado,
			String atividade, Date data, Time hora) {
		
		this.loginUsuarioLogado = loginUsuarioLogado;
		this.nomeUsuarioLogado = nomeUsuarioLogado;
		this.atividade = atividade;
		this.data = data;
		this.hora = hora;
		
	}


	public String getLoginUsuarioLogado() {
		return loginUsuarioLogado;
	}


	public void setLoginUsuarioLogado(String loginUsuarioLogado) {
		this.loginUsuarioLogado = loginUsuarioLogado;
	}


	public String getNomeUsuarioLogado() {
		return nomeUsuarioLogado;
	}


	public void setNomeUsuarioLogado(String nomeUsuarioLogado) {
		this.nomeUsuarioLogado = nomeUsuarioLogado;
	}


	public String getAtividade() {
		return atividade;
	}


	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public Time getHora() {
		return hora;
	}


	public void setHora(Time hora) {
		this.hora = hora;
	}
	
	
	

}
