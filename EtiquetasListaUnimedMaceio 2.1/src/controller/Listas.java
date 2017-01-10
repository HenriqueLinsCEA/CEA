package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Listas {

	public String abrir;
	public String salvar;
	boolean sucesso = false;
	String linha;
	int contador;

	public boolean isSucesso() {
		return sucesso;
	}

	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}

	public String getLinha() {
		return linha;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}

	public String getAbrir() {
		return abrir;
	}

	public void setAbrir(String abrir) {
		this.abrir = abrir;
	}

	public String getSalvar() {
		return salvar;
	}

	public void setSalvar(String salvar) {
		this.salvar = salvar;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public boolean SalvarListas(String abrir) throws IOException {

		this.abrir = abrir;
		this.salvar = abrir + "-LI";

		FileReader arq = new FileReader(this.abrir);
		BufferedReader lerArq = new BufferedReader(arq);

		OutputStream out = new FileOutputStream(this.salvar.toString() + ".csv");
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
		BufferedWriter bf = new BufferedWriter(outputStreamWriter);

		bf.append("Arquivos: "+";" + "Original:  " + this.abrir.toUpperCase() + ";" + "Novo: " + this.salvar.toUpperCase());
		bf.newLine();
		bf.append("ID"+";" + "Número " + ";" + "Nome "+ ";" + "Família" + ";"+ "Tipo" );
		bf.newLine();
		
		contador = 1;

		try {

			while ((linha = lerArq.readLine()) != null) {

				bf.append(contador + " ;" + linha.substring(9, 28) + ";"
						+ linha.substring(29, 54).toUpperCase() + ";"
						+ linha.substring(926, 931) + ";"
						+ linha.substring(932, 933));

				bf.newLine();
				sucesso = true;

				contador++;

			}

		} catch (Exception e) {

			bf.close();
			lerArq.close();
			return sucesso;

		}

		bf.append("Total: " + (contador - 1));
		bf.close();
		lerArq.close();
		return sucesso;
	}

}
