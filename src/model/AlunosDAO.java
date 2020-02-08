package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.Alunos;

public class AlunosDAO {
	private Connection conexao;
    public AlunosDAO() {
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

            ResultSet rs = stmt.executeQuery("select * from alunos");

            while( rs.next() ) {
                Alunos alunos = new Alunos(); 
                
                alunos.setId(rs.getInt("id") );
                alunos.setNome( rs.getString("nome") );

                resultado.add(alunos);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }
    
    public Alunos getAlunoPorID( int codigo ) {
        Alunos Alunos = new Alunos();
        try {
            String sql = "SELECT * FROM alunos WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                Alunos.setId(rs.getInt("id"));
                Alunos.setNome( rs.getString("nome") );
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Alunos;
    }
    
    public ArrayList<Alunos> getAlunosPendentes(){
    	ArrayList resultado = new ArrayList();
        try {            
            Statement stmt = conexao.createStatement();

            ResultSet rs = stmt.executeQuery("select * from alunos where aprovado = 'N'");

            while( rs.next() ) {
                Alunos alunos = new Alunos(); 
                
                alunos.setId(rs.getInt("id") );
                alunos.setNome( rs.getString("nome") );

                resultado.add(alunos);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }
    
    public Alunos getLogin(String email, String senha) {
    	Alunos alunos = new Alunos();
        try {
            String sql = "SELECT * FROM alunos WHERE email = ? && senha = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, senha);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                alunos.setId(rs.getInt("id"));
                alunos.setNome( rs.getString("nome") );
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return null;
        }
        return alunos;
    }
    
    public boolean gravar( Alunos Alunos ) {
        try {
            String sql;
            if ( Alunos.getId() == 0 ) {
                // Realizar uma inclus�o
                sql = "INSERT INTO alunos (nome, idade) VALUES (?,?)";
            } else {
                // Realizar uma altera��o
                sql = "UPDATE alunos SET nome=?, idade=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, Alunos.getNome());
            
            if ( Alunos.getId()> 0 )
                ps.setInt(3, Alunos.getId());
            
            ps.execute();
            
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM alunos WHERE id = ?";
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
