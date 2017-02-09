package controller.movimentacaocliente;

import java.sql.Date;
import java.sql.Time;

public class MovimentacaoCliente {
	
	private int id_movimentacao;
	private String tipoOperacao;
	private String nomeOperacao;
	private Date dtOperacao;
	private Time horaOperacao;
	private long saldoInicial;
	private long valorOperacao;
	private long saldoFinal;
	public int getId_movimentacao() {
		return id_movimentacao;
	}
	public void setId_movimentacao(int id_movimentacao) {
		this.id_movimentacao = id_movimentacao;
	}
	public String getTipoOperacao() {
		return tipoOperacao;
	}
	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}
	public String getNomeOperacao() {
		return nomeOperacao;
	}
	public void setNomeOperacao(String nomeOperacao) {
		this.nomeOperacao = nomeOperacao;
	}
	public Date getDtOperacao() {
		return dtOperacao;
	}
	public void setDtOperacao(Date dtOperacao) {
		this.dtOperacao = dtOperacao;
	}
	public Time getHoraOperacao() {
		return horaOperacao;
	}
	public void setHoraOperacao(Time horaOperacao) {
		this.horaOperacao = horaOperacao;
	}
	public long getSaldoInicial() {
		return saldoInicial;
	}
	public void setSaldoInicial(long saldoInicial) {
		this.saldoInicial = saldoInicial;
	}
	public long getValorOperacao() {
		return valorOperacao;
	}
	public void setValorOperacao(long valorOperacao) {
		this.valorOperacao = valorOperacao;
	}
	public long getSaldoFinal() {
		return saldoFinal;
	}
	public void setSaldoFinal(long saldoFinal) {
		this.saldoFinal = saldoFinal;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtOperacao == null) ? 0 : dtOperacao.hashCode());
		result = prime * result + ((horaOperacao == null) ? 0 : horaOperacao.hashCode());
		result = prime * result + id_movimentacao;
		result = prime * result + ((nomeOperacao == null) ? 0 : nomeOperacao.hashCode());
		result = prime * result + (int) (saldoFinal ^ (saldoFinal >>> 32));
		result = prime * result + (int) (saldoInicial ^ (saldoInicial >>> 32));
		result = prime * result + ((tipoOperacao == null) ? 0 : tipoOperacao.hashCode());
		result = prime * result + (int) (valorOperacao ^ (valorOperacao >>> 32));
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
		MovimentacaoCliente other = (MovimentacaoCliente) obj;
		if (dtOperacao == null) {
			if (other.dtOperacao != null)
				return false;
		} else if (!dtOperacao.equals(other.dtOperacao))
			return false;
		if (horaOperacao == null) {
			if (other.horaOperacao != null)
				return false;
		} else if (!horaOperacao.equals(other.horaOperacao))
			return false;
		if (id_movimentacao != other.id_movimentacao)
			return false;
		if (nomeOperacao == null) {
			if (other.nomeOperacao != null)
				return false;
		} else if (!nomeOperacao.equals(other.nomeOperacao))
			return false;
		if (saldoFinal != other.saldoFinal)
			return false;
		if (saldoInicial != other.saldoInicial)
			return false;
		if (tipoOperacao == null) {
			if (other.tipoOperacao != null)
				return false;
		} else if (!tipoOperacao.equals(other.tipoOperacao))
			return false;
		if (valorOperacao != other.valorOperacao)
			return false;
		return true;
	}
	

}
