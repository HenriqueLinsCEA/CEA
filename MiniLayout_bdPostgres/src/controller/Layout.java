	package controller;

public class Layout {
	private int id_layout;
	private int id_cliente;
	private String produto;
	private String tipoProduto;
	private String espessura;
	private String classeProduto;
	private boolean furado;
	private String presilhaOuCordao;
	private String orientacao;
	private String protetor;
	private String cor;
	private boolean acesso;
	private String impressao;
	private String localFrente;
	private String localVerso;
	
	public Layout() {
		
	}

	public Layout(int id_layout, String produto, String tipoProduto,
			String espessura, String classeProduto, boolean furado,
			String presilhaOuCordao,  String orientacao,
			String protetor, String cor, boolean acesso, String impressao,
			String locaFrente, String localVerso) {
		
		this.id_layout = id_layout;
		this.produto = produto;
		this.tipoProduto = tipoProduto;
		this.espessura = espessura;
		this.classeProduto = classeProduto;
		this.furado = furado;
		this.presilhaOuCordao = presilhaOuCordao;
		this.orientacao = orientacao;
		this.protetor = protetor;
		this.cor = cor;
		this.acesso = acesso;
		this.impressao = impressao;
		this.localFrente = locaFrente;
		this.localVerso = localVerso;
	}
	
	public Layout( String produto, String tipoProduto,
			String espessura, String classeProduto, boolean furado,
			String presilhaOuCordao, String orientacao,
			String protetor, String cor, boolean acesso, String impressao,
			String locaFrente, String localVerso,  int id_cliente) {
		
		this.produto = produto;
		this.tipoProduto = tipoProduto;
		this.espessura = espessura;
		this.classeProduto = classeProduto;
		this.furado = furado;
		this.presilhaOuCordao = presilhaOuCordao;
		this.orientacao = orientacao;
		this.protetor = protetor;
		this.cor = cor;
		this.acesso = acesso;
		this.impressao = impressao;
		this.localFrente = locaFrente;
		this.localVerso = localVerso;
		this.id_cliente = id_cliente;
		
	}
	
	public Layout( int id_cliente, String produto, String tipoProduto,
			String espessura, String classeProduto, boolean furado,
			String presilhaOuCordao, String orientacao,
			String protetor, String cor, boolean acesso, String impressao,
			String locaFrente, String localVerso,  int id_layout) {
		
		this.id_cliente = id_cliente;
		this.produto = produto;
		this.tipoProduto = tipoProduto;
		this.espessura = espessura;
		this.classeProduto = classeProduto;
		this.furado = furado;
		this.presilhaOuCordao = presilhaOuCordao;
		this.orientacao = orientacao;
		this.protetor = protetor;
		this.cor = cor;
		this.acesso = acesso;
		this.impressao = impressao;
		this.localFrente = locaFrente;
		this.localVerso = localVerso;
		this.id_layout = id_layout;
		
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

	public String getLocalFrente() {
		return localFrente;
	}

	public void setLocalFrente(String localFrente) {
		this.localFrente = localFrente;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String getEspessura() {
		return espessura;
	}

	public void setEspessura(String espessura) {
		this.espessura = espessura;
	}

	public String getClasseProduto() {
		return classeProduto;
	}

	public void setClasseProduto(String classeProduto) {
		this.classeProduto = classeProduto;
	}

	public boolean isFurado() {
		return furado;
	}

	public void setFurado(boolean furado) {
		this.furado = furado;
	}


	public String getOrientacao() {
		return orientacao;
	}

	public void setOrientacao(String orientacao) {
		this.orientacao = orientacao;
	}

	public String getProtetor() {
		return protetor;
	}

	public void setProtetor(String protetor) {
		this.protetor = protetor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public boolean isAcesso() {
		return acesso;
	}

	public void setAcesso(boolean acesso) {
		this.acesso = acesso;
	}

	public String getImpressao() {
		return impressao;
	}

	public void setImpressao(String impressao) {
		this.impressao = impressao;
	}

	public String getLocaFrente() {
		return localFrente;
	}

	public void setLocaFrente(String locaFrente) {
		this.localFrente = locaFrente;
	}

	public String getLocalVerso() {
		return localVerso;
	}

	public void setLocalVerso(String localVerso) {
		this.localVerso = localVerso;
	}

	public String getPresilhaOuCordao() {
		return presilhaOuCordao;
	}

	public void setPresilhaOuCordao(String presilhaOuCordao) {
		this.presilhaOuCordao = presilhaOuCordao;
	}
	
	
	
}
