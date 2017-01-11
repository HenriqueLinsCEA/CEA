package controller;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Etiquetas {

	private String abrir;
	private String salvar;
	private String linha = "";
	private String anterior = "";
	private String atual = "";
	private OutputStream out;
	private BufferedReader lerArq;
	
	boolean sucesso = false;

	public String getLinha() {
		return linha;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}

	public String getAnterior() {
		return anterior;
	}

	public void setAnterior(String anterior) {
		this.anterior = anterior;
	}

	public String getAtual() {
		return atual;
	}

	public void setAtual(String atual) {
		this.atual = atual;
	}

	public boolean isSucesso() {
		return sucesso;
	}

	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
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

	public boolean SalvarEtiquetas(String abrir)
			throws HeadlessException, IOException {

		this.salvar = abrir + "-ET";
		this.abrir = abrir;

		File file = new File(this.salvar.toString() + ".csv");
		FileReader arq = new FileReader(this.abrir);
		
		try {
			
			out = new FileOutputStream(file);
			lerArq = new BufferedReader(arq);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "O arquivo já está sendo usado por outro processo");
			return sucesso;
		
		}

		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
		BufferedWriter bf = new BufferedWriter(outputStreamWriter);
		
		bf.append("Número " + ";" + "Nome "+ ";" + "Logradouro" + ";"+ "Complemento" );
		bf.newLine();
		
		int posicao = 0;

		
		try {
			
		
			while ((linha = lerArq.readLine()) != null){

				
				String linha_2 = linha.substring(926, 1098);
				atual = linha_2.substring(0,5);
				
				Pattern cep = Pattern.compile("([2-3-4-5]\\d\\d\\d\\d\\d\\d\\d)");
				Matcher matcher = cep.matcher(linha_2);

				if (matcher.find()) {

					posicao = matcher.start();

				}else{
					
					JOptionPane.showMessageDialog(null, "Erro posição CEP");
								
				}

		

				if (atual.equals(anterior) == false) {

							bf.append(linha.substring(926, 931) + "-"
							+ linha.substring(9, 28) + ";"
							+ linha.substring(29, 54).toUpperCase() + ";"
							+ linha_2.substring(8, posicao).toUpperCase() + ";"
							+ linha_2.substring(posicao, 164).toUpperCase());

					bf.newLine();
					anterior = atual;
					sucesso = true;

				} else {
					
									
					

				}

			} 
			
		} catch (Exception e) {
			
		
			bf.close();
			lerArq.close();
			return sucesso;
			
		}


	
		bf.close();
		lerArq.close();
		return sucesso;

	}

}
