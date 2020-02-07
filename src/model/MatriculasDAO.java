package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.Matriculas;

public class MatriculasDAO {
    private Connection conexao;
    public MatriculasDAO() {
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

            ResultSet rs = stmt.executeQuery("select * from matriculas");

            while( rs.next() ) {
                Matriculas matriculas = new Matriculas(); 
                
                matriculas.setId(rs.getInt("id") );

                resultado.add(matriculas);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }
    
    public Matriculas getAlunoPorID( int codigo ) {
        Matriculas Matriculas = new Matriculas();
        try {
            String sql = "SELECT * FROM matriculas WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                Matriculas.setId(rs.getInt("id"));
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Matriculas;
    }
    
    public boolean gravar( Matriculas Matriculas ) {
        try {
            String sql;
            if ( Matriculas.getId() == 0 ) {
                // Realizar uma inclus�o
                sql = "INSERT INTO matriculas (nome, idade) VALUES (?,?)";
            } else {
                // Realizar uma altera��o
                sql = "UPDATE matriculas SET nome=?, idade=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            if ( Matriculas.getId()> 0 )
                ps.setInt(3, Matriculas.getId());
            
            ps.execute();
            
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM matriculas WHERE id = ?";
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
