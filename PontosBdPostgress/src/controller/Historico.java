package controller;


import java.sql.Date;
import java.sql.Time;

import javax.swing.text.MaskFormatter;




public class Historico {
	
	private int id_historico;
	private String logado;
	private String logadoCpf;
	private String localizado;
	private String localizadoCpf;
	public String transacao;
	private int valor;
	private int pontosAtualizado;
	private Date data;
	private Time hora;
	
	public Historico(){
		
	}

	public Historico(String logado, String logadoCpf, String localizado, String localizadoCpf, String transacao, int resgate,
			int pontosAtual, Date data, Time hora) {
		this.logado = logado;
		this.logadoCpf = logadoCpf;
		this.localizado = localizado;
		this.localizadoCpf = localizadoCpf;
		this.transacao = transacao;
		this.valor = resgate;
		this.pontosAtualizado = pontosAtual;
		this.data = data;
		this.hora = hora;
	}
	
	
	

	public String getLogado() {
		return logado;
	}

	public void setLogado(String logado) {
		this.logado = logado;
	}

	public String getLocalizado() {
		return localizado;
	}

	public void setLocalizado(String localizado) {
		this.localizado = localizado;
	}

	public String getTransacao() {
		return transacao;
	}

	public void setTransacao(String transacao) {
		this.transacao = transacao;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int resgate) {
		this.valor = resgate;
	}

	public int getPontosAtualizado() {
		return pontosAtualizado;
	}

	public void setPontosAtualizado(int pontosAtual) {
		this.pontosAtualizado = pontosAtual;
	}

	public java.sql.Date getData() {
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

	
	public String getLogadoCpf() {
		return logadoCpf;
	}

	public void setLogadoCpf(String logadoCpf) {
		this.logadoCpf = logadoCpf;
	}

	public String getLocalizadoCpf() {
		return localizadoCpf;
	}

	public void setLocalizadoCpf(String localizadoCpf) {
		this.localizadoCpf = localizadoCpf;
	}


	public int getId_historico() {
		return id_historico;
	}

	public void setId_historico(int id_historico) {
		this.id_historico = id_historico;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Historico [id_historico=").append(id_historico)
				.append(", logado=").append(logado).append(", logadoCpf=")
				.append(logadoCpf).append(", localizado=").append(localizado)
				.append(", localizadoCpf=").append(localizadoCpf)
				.append(", transacao=").append(transacao).append(", resgate=")
				.append(valor).append(", pontosAtualizado=")
				.append(pontosAtualizado).append(", data=").append(data)
				.append(", hora=").append(hora).append("]");
		return builder.toString();
	}
	
	
	public static MaskFormatter Mascara(String Mascara){  
        
	       MaskFormatter F_Mascara = new MaskFormatter();  
	       try{  
	           F_Mascara.setMask("##-##-####"); //Atribui a mascara  
	           F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento   
	       }  
	       catch (Exception excecao) {  
	       excecao.printStackTrace();  
	       }   
	       return F_Mascara;  
	}   
	
	
	

}
