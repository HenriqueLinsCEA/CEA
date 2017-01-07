package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class CriarTabelas {
	
	private Connection connection;
	 
    public CriarTabelas() {
        this.connection = ConectarBanco.getConnection();
    }
    
    
    public void criarTabelaClientes() {
        String sql = null;
        try {
            sql =	"CREATE TABLE clientes( "+
            		"id_cliente int not null " +
            		"GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
            		"nome varchar(60) not null, " +
            		"cpf varchar (20) not null, " +
            		"pontos integer not null, " +
            		"logradouro varchar(60)," +
            		"numero varchar (10)," +
            		"complemento varchar(60)," +
            		"bairro varchar(60)," +
            		"cidade varchar(60)," +
            		"uf varchar(10)," +
            		"cep varchar (20)," +
            		"telefone1 varchar(20)," +
            		"telefone2 varchar(20)," +
            		"dataCadastro DATE," +
            		"PRIMARY KEY (id_cliente) " +
                    ")";
 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Tabela Cliente criada com Sucesso");
           
        } catch (SQLException e) {
        	
        	//JOptionPane.showMessageDialog(null, "Erro ao criar Tabela Cliente \nou tabela já criada anteriormente");
        	        	        	
        }
        
    }
    
    public void criarTabelaUsuarios() {
        String sql = null;
        try {
            sql =   "CREATE TABLE usuarios( "+
            		"id_usuario int not null " +
            		"GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
            		"nome varchar(60) not null, " +
            		"tipo varchar(60) not null, " +
            		"cpf varchar (20) not null UNIQUE, " +
            		"login varchar(60) not null UNIQUE, " +
            		"senha varchar(60) not null, " +
            		"PRIMARY KEY (id_usuario) " +
                    ")";
 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Tabela Usuário criada com Sucesso");
           
        } catch (SQLException e) {
        	
        	//JOptionPane.showMessageDialog(null, "Erro ao criar Tabela Usuario");
          
        }
        
    }
    
    
    public void criarTabelaHistoricoResgate() {
        String sql = null;
        try {
            sql =	"CREATE TABLE historicoResgate( "+
            		"id_historico int not null " +
            		"GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
            		"logado varchar(60) not null, " +
            		"logadoCpf varchar(20) not null, " +
            		"localizado varchar(60) not null, " +
            		"localizadoCpf varchar (20) not null," +
            		"transacao varchar (20) not null, " +
            		"valor integer not null, " +
            		"pontosAtualizado integer not null, " +
            		"data DATE, " +
            		"hora TIME, " +
            		"PRIMARY KEY (id_historico) " +
                    ")";
 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Tabela Histórico do Resgate criada com Sucesso");
           
        } catch (SQLException e) {
        	
        	//JOptionPane.showMessageDialog(null, "Erro ao criar Tabela Cliente \nou tabela já criada anteriormente");
        	        	        	
        }
        
    }
    
    public void criarTabelaConfiguracaoPontos() {
        
    	String sql = null;
        
        try {
            
        	sql =   "CREATE TABLE configuracaoPontos( "+
            		"id_configuracaoPontos int not null " +
            		"GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
            		"pontos integer not null, " +
            		"valor integer not null, " +
            		"PRIMARY KEY (id_configuracaoPontos) " +
                    ")";
 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Tabela ConfiguracaoPontos criada com Sucesso");
           
        } catch (SQLException e) {
        	
        	//JOptionPane.showMessageDialog(null, "Erro ao criar Tabela Usuario");
          
        }
        
    }
    
    
    
    public void deletarTabelaclientes() {
        String sql = null;
        try {
            sql = "DROP TABLE clientes";
 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
           
            
        } catch (SQLException e) {
        	
        	JOptionPane.showMessageDialog(null, "Erro ao deletar a Tabela");
          
        }
        
    }
    
    public void deletarTabelaUsuarios() {
        String sql = null;
        try {
            sql = "DROP TABLE usuarios";
 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
           
            
        } catch (SQLException e) {
        	
        	JOptionPane.showMessageDialog(null, "Erro ao deletar a Tabela");
           
        }
        
    }
    
    public void deletarTabelahistoricoResgate() {
        String sql = null;
        try {
            sql = "DROP TABLE historicoResgate";
 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
           
            
        } catch (SQLException e) {
        	
        	JOptionPane.showMessageDialog(null, "Erro ao deletar a Tabela");
          
        }
     
    }
    
    public void deletarTabelaConfiguracaoPontos() {
        String sql = null;
        try {
            sql = "DROP TABLE configuracaoPontos";
 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
           
            
        } catch (SQLException e) {
        	
        	JOptionPane.showMessageDialog(null, "Erro ao deletar a Tabela");
          
        }
     
    }

}
