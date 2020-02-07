package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.Cursos;

public class CursosDAO {
    private Connection conexao;
    public CursosDAO() {
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

            ResultSet rs = stmt.executeQuery("select * from cursos");

            while( rs.next() ) {
                Cursos cursos = new Cursos(); 
                
                cursos.setId(rs.getInt("id") );
                cursos.setNome( rs.getString("nome") );

                resultado.add(cursos);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }
    
    public Cursos getAlunoPorID( int codigo ) {
        Cursos Cursos = new Cursos();
        try {
            String sql = "SELECT * FROM cursos WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                Cursos.setId(rs.getInt("id"));
                Cursos.setNome( rs.getString("nome") );
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Cursos;
    }
    
    public boolean gravar( Cursos Cursos ) {
        try {
            String sql;
            if ( Cursos.getId() == 0 ) {
                // Realizar uma inclus�o
                sql = "INSERT INTO cursos (nome, idade) VALUES (?,?)";
            } else {
                // Realizar uma altera��o
                sql = "UPDATE cursos SET nome=?, idade=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, Cursos.getNome());
            
            if ( Cursos.getId()> 0 )
                ps.setInt(3, Cursos.getId());
            
            ps.execute();
            
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM cursos WHERE id = ?";
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
