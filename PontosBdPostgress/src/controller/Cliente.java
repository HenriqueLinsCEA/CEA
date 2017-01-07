package controller;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.text.MaskFormatter;

import view.TelaPrincipal;

public class Cliente{
	

	private int id_cliente;
	private String nome;
	private String cpf;
	private int pontos;
	private Endereco endereco = new Endereco();
	private Telefone telefone = new Telefone();
	private Date dataCadastro;


	public Cliente(){
		
	}
	
	public Cliente(String nome, String cpf, int pontos) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.pontos = pontos;
		
	}
	
	public Cliente(int id_cliente, String nome, String cpf, int pontos,
			Endereco endereco, Telefone telefone, Date dataCadastro) {
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.cpf = cpf;
		this.pontos = pontos;
		this.endereco = endereco;
		this.telefone = telefone;
		this.dataCadastro = dataCadastro;
	}
	
	public Cliente(int id_cliente, String nome, String cpf, int pontos,
			String logradouro, String numero, String complemento, String bairro,
			String cidade, String uf, String cep, String telefone1, String telefone2, Date dataCadastro) {
		
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.cpf = cpf;
		this.pontos = pontos;
		this.endereco.setLogradouro(logradouro);
		this.endereco.setNumero(numero);
		this.endereco.setComplemento(complemento);
		this.endereco.setBairro(bairro);
		this.endereco.setCidade(cidade);
		this.endereco.setUf(uf);
		this.endereco.setCep(cep);
		this.telefone.setTelefone1(telefone1);
		this.telefone.setTelefone2(telefone2);
		this.dataCadastro = dataCadastro;
		
	}


	public Cliente(String nome, String cpf, int pontos,
			String logradouro, String numero, String complemento, String bairro,
			String cidade, String uf, String cep, String telefone1, String telefone2, Date dataCadastro) {
		
		
		this.nome = nome;
		this.cpf = cpf;
		this.pontos = pontos;
		this.endereco.setLogradouro(logradouro);
		this.endereco.setNumero(numero);
		this.endereco.setComplemento(complemento);
		this.endereco.setBairro(bairro);
		this.endereco.setCidade(cidade);
		this.endereco.setUf(uf);
		this.endereco.setCep(cep);
		this.telefone.setTelefone1(telefone1);
		this.telefone.setTelefone2(telefone2);
		this.dataCadastro = dataCadastro;
		
	}
	
	

	public int getId_cliente() {
		return id_cliente;
	}



	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}



	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public Telefone getTelefone() {
		return telefone;
	}


	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [id_cliente=").append(id_cliente)
				.append(", nome=").append(nome)
				.append(", cpf=").append(cpf)
				.append(", pontos=").append(pontos)
				.append(", logradouro=").append(endereco.getLogradouro())
				.append(", numero=").append(endereco.getNumero())
				.append(", complemento=").append(endereco.getComplemento())
				.append(", bairro=").append(endereco.getBairro())
				.append(", cidade=").append(endereco.getCidade())
				.append(", uf=").append(endereco.getUf())
				.append(", cep=").append(endereco.getCep())
				.append(", telefone1=").append(telefone.getTelefone1())
				.append(", telefone2=").append(telefone.getTelefone2())
				.append(", dataCadastro=").append(dataCadastro)
				.append("]");
		return builder.toString();
	}

	public static String removerMascara(String cpf){  
	    return cpf.replaceAll("\\D", "");  
	} 
	
	
	public static Cliente localizarClientePeloCpf(String cpf){
		
		Cliente cliente = new model.ClienteDao().pesquisarCpf(cpf);
		
		return cliente;	
		
	}
	
	public static List<Cliente> localizarClientePeloNome(String nome){
		
		List<Cliente> ListaCliente = new model.ClienteDao().pesquisarNome(nome);
		
		return ListaCliente;	
		
	}
	
public static Cliente localizarClientePeloNomeUnico(String nome){
		
		Cliente cliente = new model.ClienteDao().pesquisarNomeUnico(nome);
		
		return cliente;	
		
	}
	
	
	public static MaskFormatter Mascara(String Mascara){  
        
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
	

	public static MaskFormatter Telefone(String Mascara){  
        
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
	
	
	public static MaskFormatter SeisDigitos(String Mascara){  
        
	       MaskFormatter F_Mascara = new MaskFormatter();  
	       try{  
	           F_Mascara.setMask("######"); //Atribui a mascara  
	           F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento   
	       }  
	       catch (Exception excecao) {  
	       excecao.printStackTrace();  
	       }   
	       return F_Mascara;  
	}   
	
	public static String Numero(String valor){  
        
		Locale Local = new Locale("pt","BR");    
		  
		//Number pra string  
		double mascara = Double.parseDouble(valor);    
		DecimalFormat df = new DecimalFormat("#,###", new DecimalFormatSymbols(Local));    
		String s = df.format(mascara);    
		  

		return s;
		
	}   
	
	
	
	public static void excluirCliente() {
        
		 
        new model.ClienteDao().excluirCliente(TelaPrincipal.localizado);
 
       
    }

	
	
}
