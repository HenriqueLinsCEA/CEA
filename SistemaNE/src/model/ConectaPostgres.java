package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaPostgres {

	public static void main(String[] args) {
		
		Connection conexao = null;
		
		try {
			// Registrando a classe JDBC no sistema em tempo de execução
			
			String usuario = "postgres";
			String senha = "1006";
			String url = "jdbc:postgresql://localhost:5432/SistemaNE";

			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectou");

		} catch (SQLException e) {

			System.out.println("Ocorreu um erro SQL. Erro: " + e.getMessage());

		} finally {
			try {

				conexao.close();

			} catch (SQLException e) {

				System.out.println("Ocorreu um erro SQL. Erro: " + e.getMessage());

			}

		}

	}
}
