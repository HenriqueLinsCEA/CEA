package controller;

import java.sql.Time;
import java.sql.Date;


public class ConsultaCarteira {
	
	private String nome;
	private String instituicao;
	private String curso;
	private String motivo;
	private String usuarioLogado;
	private Date data;
	private Time hora;
	
	
	public ConsultaCarteira (){
		
	}
	
	public ConsultaCarteira(String nome, String instituicao, String curso,
			String motivo, String usuarioLogado, Date data, Time hora) {
		
		this.nome = nome;
		this.instituicao = instituicao;
		this.curso = curso;
		this.motivo = motivo;
		this.usuarioLogado = usuarioLogado;
		this.data = data;
		this.hora = hora;
		
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(String usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
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
