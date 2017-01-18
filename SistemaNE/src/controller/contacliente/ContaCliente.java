package controller;

import java.sql.Date;

public class ContaCliente {
	
	private int id_conta;
	private long saldoAtual;
	private long saldoAnterior;
	private Date dtSaldoAnterior;
	
	public int getId_conta() {
		return id_conta;
	}
	public void setId_conta(int id_conta) {
		this.id_conta = id_conta;
	}
	public long getSaldoAtual() {
		return saldoAtual;
	}
	public void setSaldoAtual(long saldoAtual) {
		this.saldoAtual = saldoAtual;
	}
	public long getSaldoAnterior() {
		return saldoAnterior;
	}
	public void setSaldoAnterior(long saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}
	public Date getDtSaldoAnterior() {
		return dtSaldoAnterior;
	}
	public void setDtSaldoAnterior(Date dtSaldoAnterior) {
		this.dtSaldoAnterior = dtSaldoAnterior;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtSaldoAnterior == null) ? 0 : dtSaldoAnterior.hashCode());
		result = prime * result + id_conta;
		result = prime * result + (int) (saldoAnterior ^ (saldoAnterior >>> 32));
		result = prime * result + (int) (saldoAtual ^ (saldoAtual >>> 32));
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
		ContaCliente other = (ContaCliente) obj;
		if (dtSaldoAnterior == null) {
			if (other.dtSaldoAnterior != null)
				return false;
		} else if (!dtSaldoAnterior.equals(other.dtSaldoAnterior))
			return false;
		if (id_conta != other.id_conta)
			return false;
		if (saldoAnterior != other.saldoAnterior)
			return false;
		if (saldoAtual != other.saldoAtual)
			return false;
		return true;
	}
	
	
	
	


}
