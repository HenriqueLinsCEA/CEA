package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Cliente {

	private String nome;
	private String imagemFrente;
	private String imagemVerso;

	public static ArrayList<Cliente> ListaCliente = new ArrayList<Cliente>();

	public Cliente() {

	}

	public Cliente(String nome) {

		this.nome = nome;

	}

	public Cliente(String nome, String imagemFrente, String imagemVerso) {

		this.nome = nome;
		this.imagemFrente = imagemFrente;
		this.imagemVerso = imagemVerso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagemFrente() {
		return imagemFrente;
	}

	public void setImagemFrente(String imagemFrente) {
		this.imagemFrente = imagemFrente;
	}

	public String getImagemVerso() {
		return imagemVerso;
	}

	public void setImagemVerso(String imagemVerso) {
		this.imagemVerso = imagemVerso;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Nome ").append(nome).append("\nEndereço Frente ")
				.append(imagemFrente).append("\nEndereço Verso ")
				.append(imagemVerso);
		return builder.toString();
	}
	
	

		
		public void ImportarClientes() throws IOException {

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
			
			
			JOptionPane.showMessageDialog(null, quantidaDeLinhas);

			arquivo.close();
			
			Cliente n = new Cliente();
			n.ListarCliente();
			
			

		}

	public void AdicionarCliente(String nome, String imagemFrente,
			String imagemVerso) {

		ListaCliente.add(new Cliente(nome, imagemFrente, imagemVerso));

		JOptionPane.showMessageDialog(null, "Cliente cadastrado");

		try {
			FileWriter arquivo = new FileWriter("c:/Teste/cliente.txt");
			PrintWriter gravarArquivo = new PrintWriter(arquivo);

			gravarArquivo.printf("Nome;ImagemFrente;ImagemVerso\n");
			
			
			
			for (int i = 0 ; i < ListaCliente.size(); i++) {

				gravarArquivo.printf(ListaCliente.get(i).getNome() + ";"
						+ ListaCliente.get(i).getImagemFrente() + ";"
						+ ListaCliente.get(i).getImagemVerso() + "\n");

			}

			gravarArquivo.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ListarCliente() {

		for (Cliente c : ListaCliente) {

			JOptionPane.showMessageDialog(null, c.toString());

		}

	}

	public int PesquisarCliente(String nome) {

		int posicao = -1;

		for (int i = 0; i < ListaCliente.size(); i++) {

			if (nome.equalsIgnoreCase(ListaCliente.get(i).getNome().toString())) {

				posicao = i;
			}

		}

		if (posicao == -1) {

			JOptionPane.showMessageDialog(null, "Não achou");

		} else {

			JOptionPane.showMessageDialog(null, "Achou");
		}

		JOptionPane.showMessageDialog(null, posicao + ListaCliente.toString());

		return posicao;

	}

}
