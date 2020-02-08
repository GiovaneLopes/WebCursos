package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.Instrutores;

public class InstrutoresDAO {
	private Connection conexao;
    public InstrutoresDAO() {
        try {
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro cria��o de conexao DAO");
            System.out.println(e);
        }
    }
    public ArrayList getLista() {
        ArrayList resultado = new ArrayList();
        try {            
            Statement stmt = conexao.createStatement();

            ResultSet rs = stmt.executeQuery("select * from instrutores");

            while( rs.next() ) {
                Instrutores instrutor = new Instrutores(); 
                
                instrutor.setId(rs.getInt("id") );
                instrutor.setNome( rs.getString("nome") );

                resultado.add(instrutor);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }
    
    public Instrutores getInstrutoresPorID( int codigo ) {
        Instrutores Instrutores = new Instrutores();
        try {
            String sql = "SELECT * FROM instrutores WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                Instrutores.setId(rs.getInt("id"));
                Instrutores.setNome( rs.getString("nome") );
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Instrutores;
    }
    
    public Instrutores getLogin(String email, String senha) {
    	Instrutores instrutores = new Instrutores();
        try {
            String sql = "SELECT * FROM instrutores WHERE email = ? && senha = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, senha);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
            	instrutores.setId(rs.getInt("id"));
            	instrutores.setNome( rs.getString("nome") );
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return instrutores;
    }
    
    public boolean gravar( Instrutores Instrutores ) {
        try {
            String sql;
            if ( Instrutores.getId() == 0 ) {
                // Realizar uma inclus�o
                sql = "INSERT INTO contatos (nome, idade) VALUES (?,?)";
            } else {
                // Realizar uma altera��o
                sql = "UPDATE contatos SET nome=?, idade=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, Instrutores.getNome());
            
            if ( Instrutores.getId()> 0 )
                ps.setInt(3, Instrutores.getId());
            
            ps.execute();
            
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM instrutores WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
}
