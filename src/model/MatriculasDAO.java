package model;

import java.sql.Connection;
import java.sql.Date;
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
    public ArrayList<Matriculas> getLista() {
    	ArrayList<Matriculas> resultado = new ArrayList<Matriculas>();
        try {            
            Statement stmt = conexao.createStatement();

            ResultSet rs = stmt.executeQuery("select * from matriculas");

            while( rs.next() ) {
                Matriculas matricula = new Matriculas(); 
                
                matricula.setId(rs.getInt("id") );
                matricula.setAlunos_id(rs.getInt("alunos_id"));
                matricula.setData_matricula(rs.getDate("data_matricula"));
                matricula.setNota(rs.getDouble("nota"));
                matricula.setTurmas_id(rs.getInt("turmas_id"));

                resultado.add(matricula);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }
    
    public Matriculas getMatriculaPorID( int codigo ) {
        Matriculas matricula = new Matriculas();
        try {
            String sql = "SELECT * FROM matriculas WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
            	matricula.setId(rs.getInt("id") );
                matricula.setAlunos_id(rs.getInt("alunos_id"));
                matricula.setData_matricula(rs.getDate("data_matricula"));
                matricula.setNota(rs.getDouble("nota"));
                matricula.setTurmas_id(rs.getInt("turmas_id"));
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return matricula;
    }
    
    public ArrayList<Matriculas> getMatriculasPorAluno(int id_aluno ) {
    	ArrayList<Matriculas> resultado = new ArrayList<Matriculas>();
        try {            
            String sql = "SELECT * FROM matriculas LEFT JOIN alunos ON matriculas.alunos_id = alunos.id WHERE alunos.id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id_aluno);
            
            ResultSet rs = ps.executeQuery();

            while( rs.next() ) {
                Matriculas matricula = new Matriculas(); 
                
                matricula.setId(rs.getInt("id") );
                matricula.setAlunos_id(rs.getInt("alunos_id"));
                matricula.setData_matricula(rs.getDate("data_matricula"));
                matricula.setNota(rs.getDouble("nota"));
                matricula.setTurmas_id(rs.getInt("turmas_id"));

                resultado.add(matricula);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }
    
    public boolean gravar( Matriculas matricula ) {
        try {
            String sql;
            if ( matricula.getId() == 0 ) {
                // Realizar uma inclus�o
                sql = "INSERT INTO matriculas (alunos_id, data_matricula, nota, turmas_id) VALUES (?,?,?,?)";
            } else {
                // Realizar uma altera��o
                sql = "UPDATE matriculas SET alunos_id=?, data_matricula=?, nota=?, turmas_id=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, matricula.getAlunos_id());
            ps.setDate(2, new Date(matricula.getData_matricula().getTime()));
            ps.setDouble(3, matricula.getNota());
            ps.setInt(4, matricula.getTurmas_id());
            
            if ( matricula.getId()> 0 )
                ps.setInt(5, matricula.getId());
            
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
