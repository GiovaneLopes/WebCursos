package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.Turmas;

public class TurmasDAO {
    private Connection conexao;
    public TurmasDAO() {
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

            ResultSet rs = stmt.executeQuery("select * from turmas");

            while( rs.next() ) {
                Turmas turmas = new Turmas(); 
                
                turmas.setId(rs.getInt("id") );

                resultado.add(turmas);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }
    
    public Turmas getAlunoPorID( int codigo ) {
        Turmas Turmas = new Turmas();
        try {
            String sql = "SELECT * FROM turmas WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                Turmas.setId(rs.getInt("id"));
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Turmas;
    }
    
    public boolean gravar( Turmas Turmas ) {
        try {
            String sql;
            if ( Turmas.getId() == 0 ) {
                // Realizar uma inclus�o
                sql = "INSERT INTO turmas (nome, idade) VALUES (?,?)";
            } else {
                // Realizar uma altera��o
                sql = "UPDATE turmas SET nome=?, idade=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            if ( Turmas.getId()> 0 )
                ps.setInt(3, Turmas.getId());
            
            ps.execute();
            
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM turmas WHERE id = ?";
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
