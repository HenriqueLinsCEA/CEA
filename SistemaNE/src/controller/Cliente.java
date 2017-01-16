package controller;

import java.sql.Date;

import javax.swing.text.MaskFormatter;

public class Cliente {

	private int id_cliente;
	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private String inscricaoEstadual;
	private Boolean statusCliente;
	private Endereco endereco;
	private Contato contato;
	private Date clienteDesde;
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
	public Boolean getStatusCliente() {
		return statusCliente;
	}
	public void setStatusCliente(Boolean statusCliente) {
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
	public Date getClienteDesde() {
		return clienteDesde;
	}
	public void setClienteDesde(Date clienteDesde) {
		this.clienteDesde = clienteDesde;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clienteDesde == null) ? 0 : clienteDesde.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((contato == null) ? 0 : contato.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + id_cliente;
		result = prime * result + ((inscricaoEstadual == null) ? 0 : inscricaoEstadual.hashCode());
		result = prime * result + ((nomeFantasia == null) ? 0 : nomeFantasia.hashCode());
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
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id_cliente != other.id_cliente)
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

	public static MaskFormatter CPF(String Mascara){  
        
	       MaskFormatter F_Mascara = new MaskFormatter();  
	       try{  
	           F_Mascara.setMask("###.###.###-##"); //Atribui a mascara  
	           F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento   
	       }  
	       catch (Exception excecao) {  
	       excecao.printStackTrace();  
	       }   
	       return F_Mascara;  
	}   
	
	public static MaskFormatter CNPJ(String Mascara){  
     
	       MaskFormatter F_Mascara = new MaskFormatter();  
	       try{  
	           F_Mascara.setMask("##.###.###/####-##"); //Atribui a mascara  
	           F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento   
	       }  
	       catch (Exception excecao) {  
	       excecao.printStackTrace();  
	       }   
	       return F_Mascara;  
	}   
	
	public static MaskFormatter TelefoneFixo(String Mascara){  
     
	       MaskFormatter F_Mascara = new MaskFormatter();  
	       try{  
	           F_Mascara.setMask("(##) ####-####"); //Atribui a mascara  
	           F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento   
	       }  
	       catch (Exception excecao) {  
	       excecao.printStackTrace();  
	       }   
	       return F_Mascara;  
	}   
	
	public static MaskFormatter TelefoneCelular(String Mascara){  
     
	       MaskFormatter F_Mascara = new MaskFormatter();  
	       try{  
	           F_Mascara.setMask("(##) #####-####"); //Atribui a mascara  
	           F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento   
	       }  
	       catch (Exception excecao) {  
	       excecao.printStackTrace();  
	       }   
	       return F_Mascara;  
	}   
	
	public static MaskFormatter CEP(String Mascara){  
     
	       MaskFormatter F_Mascara = new MaskFormatter();  
	       try{  
	           F_Mascara.setMask("#####-###"); //Atribui a mascara  
	           F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento   
	       }  
	       catch (Exception excecao) {  
	       excecao.printStackTrace();  
	       }   
	       return F_Mascara;  
	}   
	
	public static String removerMascara(String cpf){  
	    return cpf.replaceAll("\\D", "");  
	} 
	

}
