package controller.cliente;

import java.io.Serializable;
import java.sql.Date;
import controller.contato.Contato;
import controller.endereco.Endereco;

public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6632812712176046714L;
	
	private int id_cliente;
	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private String inscricaoEstadual;
	private Date clienteDesde;
	private String statusCliente;
	private Endereco endereco;
	private Contato contato;
	private String observacoes;
	private boolean crachas;
	private boolean cartoes;
	private boolean pontaoAcesso;
	private boolean impressaoEletronica;
	private boolean outros;

	public Cliente(String nomeFantasia, String razaoSocial, String cnpj, String inscricaoEstadual, Date clienteDesde,
			String statusCliente) {

		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.statusCliente = statusCliente;
		this.clienteDesde = clienteDesde;
	}
	
	
	public Cliente(String nomeFantasia, String razaoSocial, String cnpj, String inscricaoEstadual, Date clienteDesde,
			String statusCliente, Endereco endereco, Contato contato, String observacoes, boolean crachas,
			boolean cartoes, boolean pontaoAcesso, boolean impressaoEletronica, boolean outros) {
	
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.clienteDesde = clienteDesde;
		this.statusCliente = statusCliente;
		this.endereco = endereco;
		this.contato = contato;
		this.observacoes = observacoes;
		this.crachas = crachas;
		this.cartoes = cartoes;
		this.pontaoAcesso = pontaoAcesso;
		this.impressaoEletronica = impressaoEletronica;
		this.outros = outros;
	}


	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public Date getClienteDesde() {
		return clienteDesde;
	}

	public void setClienteDesde(Date clienteDesde) {
		this.clienteDesde = clienteDesde;
	}

	public String getStatusCliente() {
		return statusCliente;
	}

	public void setStatusCliente(String statusCliente) {
		this.statusCliente = statusCliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public boolean isCrachas() {
		return crachas;
	}

	public void setCrachas(boolean crachas) {
		this.crachas = crachas;
	}

	public boolean isCartoes() {
		return cartoes;
	}

	public void setCartoes(boolean cartoes) {
		this.cartoes = cartoes;
	}

	public boolean isPontaoAcesso() {
		return pontaoAcesso;
	}

	public void setPontaoAcesso(boolean pontaoAcesso) {
		this.pontaoAcesso = pontaoAcesso;
	}

	public boolean isImpressaoEletronica() {
		return impressaoEletronica;
	}

	public void setImpressaoEletronica(boolean impressaoEletronica) {
		this.impressaoEletronica = impressaoEletronica;
	}

	public boolean isOutros() {
		return outros;
	}

	public void setOutros(boolean outros) {
		this.outros = outros;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (cartoes ? 1231 : 1237);
		result = prime * result + ((clienteDesde == null) ? 0 : clienteDesde.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((contato == null) ? 0 : contato.hashCode());
		result = prime * result + (crachas ? 1231 : 1237);
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + id_cliente;
		result = prime * result + (impressaoEletronica ? 1231 : 1237);
		result = prime * result + ((inscricaoEstadual == null) ? 0 : inscricaoEstadual.hashCode());
		result = prime * result + ((nomeFantasia == null) ? 0 : nomeFantasia.hashCode());
		result = prime * result + ((observacoes == null) ? 0 : observacoes.hashCode());
		result = prime * result + (outros ? 1231 : 1237);
		result = prime * result + (pontaoAcesso ? 1231 : 1237);
		result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
		result = prime * result + ((statusCliente == null) ? 0 : statusCliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cartoes != other.cartoes)
			return false;
		if (clienteDesde == null) {
			if (other.clienteDesde != null)
				return false;
		} else if (!clienteDesde.equals(other.clienteDesde))
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (contato == null) {
			if (other.contato != null)
				return false;
		} else if (!contato.equals(other.contato))
			return false;
		if (crachas != other.crachas)
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id_cliente != other.id_cliente)
			return false;
		if (impressaoEletronica != other.impressaoEletronica)
			return false;
		if (inscricaoEstadual == null) {
			if (other.inscricaoEstadual != null)
				return false;
		} else if (!inscricaoEstadual.equals(other.inscricaoEstadual))
			return false;
		if (nomeFantasia == null) {
			if (other.nomeFantasia != null)
				return false;
		} else if (!nomeFantasia.equals(other.nomeFantasia))
			return false;
		if (observacoes == null) {
			if (other.observacoes != null)
				return false;
		} else if (!observacoes.equals(other.observacoes))
			return false;
		if (outros != other.outros)
			return false;
		if (pontaoAcesso != other.pontaoAcesso)
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		if (statusCliente == null) {
			if (other.statusCliente != null)
				return false;
		} else if (!statusCliente.equals(other.statusCliente))
			return false;
		return true;
	}

	
	

}
