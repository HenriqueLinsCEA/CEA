package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class TesteSplit {

	public static void main(String[] args) throws IOException {

		ImportarClientes();

	}

	public static void ImportarClientes() throws IOException {

		FileReader arquivo = new FileReader("c:/Teste/cliente.txt");
		BufferedReader lerArquivo = new BufferedReader(arquivo);
		String linha = lerArquivo.readLine();
		
		String nome = null;
		String frente = null;
		String verso = null;
		
		int quantidaDeLinhas = 0;

		while (linha != null) {

			String[] palavra = linha.split(";");
			
			
			int contador = 0;
			
			for (String p : palavra) {

				//JOptionPane.showMessageDialog(null, p + " " +contador+" "+quantidaDeLinhas);		
				
				contador ++;
				
				if(contador == 1){
					nome = p;
				}if(contador == 2){
					frente = p;										
				}if(contador == 3){
					verso =p;
				}
				
								
			}
			
			JOptionPane.showMessageDialog(null, nome);
			JOptionPane.showMessageDialog(null, frente);
			JOptionPane.showMessageDialog(null, verso);
			
			linha = lerArquivo.readLine();

			quantidaDeLinhas++;
			
			controller.Cliente.ListaCliente.add(new Cliente(nome, frente, verso));
		}
		
		//controller.Cliente.ListaCliente.add(new Cliente(nome, frente, verso));

		JOptionPane.showMessageDialog(null, quantidaDeLinhas);

		arquivo.close();
		
		Cliente n = new Cliente();
		n.ListarCliente();
		
		

	}

}
