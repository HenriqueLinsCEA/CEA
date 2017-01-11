package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

public class Listas {

	private String abrir;
	private String salvar;
	private boolean sucesso = false;
	private String linha;
	private int contador;
	private OutputStreamWriter outputStreamWriter;
	private BufferedReader lerArq;
	private OutputStream out;

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

	@SuppressWarnings("resource")
	public boolean SalvarListas(String abrir) throws IOException, java.io.FileNotFoundException {

		this.abrir = abrir;
		this.salvar = abrir + "-LI";
		
		File file = new File(this.salvar.toString() + ".csv");
		FileReader arq = new FileReader(this.abrir);
		
		BufferedReader lerArq = new BufferedReader(arq);
					
		try {
			
			out = new FileOutputStream(file);
			lerArq = new BufferedReader(arq);
			
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "O arquivo já está sendo usado por outro processo");
			return sucesso;
		}
		
		outputStreamWriter = new OutputStreamWriter(out);
		BufferedWriter bf = new BufferedWriter(outputStreamWriter);
				
		bf.append("Arquivo: "+";" +  file.getName());
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

	public BufferedReader getLerArq() {
		return lerArq;
	}

	public void setLerArq(BufferedReader lerArq) {
		this.lerArq = lerArq;
	}

}
