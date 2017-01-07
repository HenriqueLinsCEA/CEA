package controller;

import javax.swing.text.MaskFormatter;

public class Cliente extends Pessoa {

	private int id_cliente;
	private String cnpj;
	private String razaoSocial;
	private String vendedor;
	private Contato contato;
	private Endereco endereco;

	public Cliente() {

	}

	public Cliente(int id_cliente, String cnpj, String razaoSocial,
			String vendedor, String nomeParaContato, String email,
			String telefone1, String telefone2, String logradouro, String complemento,
			String numero, String bairro, String cidade, String uf, String cep) {

		this.id_cliente = id_cliente;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.vendedor = vendedor;
		this.contato.setEmail(email);
		this.contato.setTelefone1(telefone1);
		this.contato.setTelefone2(telefone2);
		this.endereco.setLogradouro(logradouro);
		this.endereco.setComplemento(complemento);
		this.endereco.setNumero(numero);
		this.endereco.setBairro(bairro);
		this.endereco.setCidade(cidade);
		this.endereco.setUf(uf);
		this.endereco.setCep(cep);

	}
	
	public Cliente(String nome, String cnpj, String razaoSocial,
			String vendedor,  int id_cliente) {
		
		this.nome = nome;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.vendedor = vendedor;
		this.id_cliente = id_cliente;
	
	}
	
	public Cliente(String nome, String cnpj, String razaoSocial,
			String vendedor) {
		
		this.nome = nome;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.vendedor = vendedor;
	
	}
	
	public Cliente(String logradouro, String complemento,
			String numero, String bairro, String cidade, String uf, String cep) {

		this.endereco.setLogradouro(logradouro);
		this.endereco.setComplemento(complemento);
		this.endereco.setNumero(numero);
		this.endereco.setBairro(bairro);
		this.endereco.setCidade(cidade);
		this.endereco.setUf(uf);
		this.endereco.setCep(cep);

	}
	

	public Cliente(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cliente(Contato contato) {
		this.contato = contato;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [id_cliente=").append(id_cliente)
				.append(", cnpj=").append(cnpj).append(", razaoSocial=")
				.append(razaoSocial).append(", vendedor=").append(vendedor)
				.append(", nome=").append(nome).append("]");
		return builder.toString();
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
