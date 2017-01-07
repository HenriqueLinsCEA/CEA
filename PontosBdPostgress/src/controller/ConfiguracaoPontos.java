package controller;

import model.ConfiguracaoPontosDao;

public class ConfiguracaoPontos {
	
	private int id_configuracaoPontos;
	private int pontos;
	private int valor;
	
	public ConfiguracaoPontos() {
		
	}
	
	
	public ConfiguracaoPontos(int pontos, int valor) {
		this.pontos = pontos;
		this.valor = valor;
	}

	public ConfiguracaoPontos(int id_configuracaoPontos, int pontos, int valor) {
		this.id_configuracaoPontos = id_configuracaoPontos;
		this.pontos = pontos;
		this.valor = valor;
	}

	public int getId_configuracaoPontos() {
		return id_configuracaoPontos;
	}


	public void setId_configuracaoPontos(int id_configuracaoPontos) {
		this.id_configuracaoPontos = id_configuracaoPontos;
	}


	public int getPontos() {
		return pontos;
	}


	public void setPontos(int pontos) {
		this.pontos = pontos;
	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}

	
	public static int adicionarPontos(int valor, int pontos){
		
		int soma = (pontos / ConfiguracaoPontosDao.confirmarPontos().getValor()) + valor ;
				
		return soma;
		
		
	}
	
	public static int resgatarPontos(int pontos, int valor){
		
		int subtracao = pontos - valor;
		
		
		
		return subtracao;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConfiguracaoPontos [id_configuracaoPontos=")
				.append(id_configuracaoPontos).append(", pontos=")
				.append(pontos).append(", valor=").append(valor).append("]");
		return builder.toString();
	}
	

	
	
}
