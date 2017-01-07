package controller;

public class TipoAcesso {
	
	private int id_acesso;
	private int id_layout;
	private int id_cliente;
	private boolean codigoDeBarras;
	private String padraoCodigoDeBarras;
	private String digitos;
	private boolean tarjaMagnetica;
	private String tipoTarja;
	private boolean tarja1;
	private boolean tarja2;
	private boolean tarja3;
	private boolean proximidade;
	private String tipoCartaoProximidade;
	
	public TipoAcesso(){
		
	}

	public TipoAcesso(int id_layout, int id_cliente, boolean codigoDeBarras,
			String padraoCodigoDeBarras, String digitos, boolean tarjaMagnetica,
			String tipoTarja, boolean tarja1, boolean tarja2, boolean tarja3,
			boolean proximidade, String tipoCartaoProximidade) {
		
		this.id_layout = id_layout;
		this.id_cliente = id_cliente;
		this.codigoDeBarras = codigoDeBarras;
		this.padraoCodigoDeBarras = padraoCodigoDeBarras;
		this.digitos = digitos;
		this.tarjaMagnetica = tarjaMagnetica;
		this.tipoTarja = tipoTarja;
		this.tarja1 = tarja1;
		this.tarja2 = tarja2;
		this.tarja3 = tarja3;
		this.proximidade = proximidade;
		this.tipoCartaoProximidade = tipoCartaoProximidade;
	}
	
	public TipoAcesso(boolean codigoDeBarras,
			String padraoCodigoDeBarras, String digitos, boolean tarjaMagnetica,
			boolean tarja1, boolean tarja2, boolean tarja3,
			boolean proximidade, String tipoCartaoProximidade) {
		
		this.codigoDeBarras = codigoDeBarras;
		this.padraoCodigoDeBarras = padraoCodigoDeBarras;
		this.digitos = digitos;
		this.tarjaMagnetica = tarjaMagnetica;
		this.tarja1 = tarja1;
		this.tarja2 = tarja2;
		this.tarja3 = tarja3;
		this.proximidade = proximidade;
		this.tipoCartaoProximidade = tipoCartaoProximidade;
	}

	public int getId_acesso() {
		return id_acesso;
	}

	public void setId_acesso(int id_acesso) {
		this.id_acesso = id_acesso;
	}
	
	
	public int getId_layout() {
		return id_layout;
	}

	public void setId_layout(int id_layout) {
		this.id_layout = id_layout;
	}
	
	
	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public boolean isCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(boolean codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public String getPadraoCodigoDeBarras() {
		return padraoCodigoDeBarras;
	}

	public void setPadraoCodigoDeBarras(String padraoCodigoDeBarras) {
		this.padraoCodigoDeBarras = padraoCodigoDeBarras;
	}

	public String getDigitos() {
		return digitos;
	}

	public void setDigitos(String digitos) {
		this.digitos = digitos;
	}

	public boolean isTarjaMagnetica() {
		return tarjaMagnetica;
	}

	public void setTarjaMagnetica(boolean tarjaMagnetica) {
		this.tarjaMagnetica = tarjaMagnetica;
	}

	public String getTipoTarja() {
		return tipoTarja;
	}

	public void setTipoTarja(String tipoTarja) {
		this.tipoTarja = tipoTarja;
	}

	public boolean isTarja1() {
		return tarja1;
	}

	public void setTarja1(boolean tarja1) {
		this.tarja1 = tarja1;
	}

	public boolean isTarja2() {
		return tarja2;
	}

	public void setTarja2(boolean tarja2) {
		this.tarja2 = tarja2;
	}

	public boolean isTarja3() {
		return tarja3;
	}

	public void setTarja3(boolean tarja3) {
		this.tarja3 = tarja3;
	}

	public boolean isProximidade() {
		return proximidade;
	}

	public void setProximidade(boolean proximidade) {
		this.proximidade = proximidade;
	}

	public String getTipoCartaoProximidade() {
		return tipoCartaoProximidade;
	}

	public void setTipoCartaoProximidade(String tipoCartaoProximidade) {
		this.tipoCartaoProximidade = tipoCartaoProximidade;
	}
	
	
	
}
