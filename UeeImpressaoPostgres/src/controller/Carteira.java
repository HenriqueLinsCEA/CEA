package controller;

public class Carteira {
	
	String nome;
	String instituicao;
	String curso;
	String matricula;
	String rg;
	String dataNascimento;
	
	public Carteira(String nome, String instituicao, String curso,
			String matricula, String rg, String dataNascimento) {
		
		this.nome = nome;
		this.instituicao = instituicao;
		this.curso = curso;
		this.matricula = matricula;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	

}
