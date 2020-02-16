package model;

import java.sql.Connection;
import java.sql.Date;
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
    public ArrayList<Turmas> getLista() {
        ArrayList<Turmas> resultado = new ArrayList<Turmas>();
        try {            
            Statement stmt = conexao.createStatement();

            ResultSet rs = stmt.executeQuery("select * from turmas");

            while( rs.next() ) {
                Turmas turma = new Turmas(); 
                
                turma.setId(rs.getInt("id") );
                turma.setCarga_horaria(rs.getInt("carga_horaria"));
                turma.setCursos_id(rs.getInt("cursos_id"));
                turma.setData_final(rs.getDate("data_final"));
                turma.setData_inicio(rs.getDate("date"));
                turma.setInstrutores_id(rs.getInt("instrutores_id"));

                resultado.add(turma);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }
    
    public Turmas getTurmaPorID( int codigo ) {
        Turmas turma = new Turmas();
        try {
            String sql = "SELECT * FROM turmas WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
            	turma.setId(rs.getInt("id") );
                turma.setCarga_horaria(rs.getInt("carga_horaria"));
                turma.setCursos_id(rs.getInt("cursos_id"));
                turma.setData_final(rs.getDate("data_final"));
                turma.setData_inicio(rs.getDate("date"));
                turma.setInstrutores_id(rs.getInt("instrutores_id"));
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return turma;
    }
    
    public ArrayList<Turmas> getTurmasPorInstrutor(int id_instrutor) {
        ArrayList<Turmas> resultado = new ArrayList<Turmas>();
        try {            
            Statement stmt = conexao.createStatement();
            String sql = "select * from turmas WHERE instrutores_id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id_instrutor);
            ResultSet rs = stmt.executeQuery(sql);

            while( rs.next() ) {
                Turmas turma = new Turmas(); 
                
                turma.setId(rs.getInt("id") );
                turma.setCarga_horaria(rs.getInt("carga_horaria"));
                turma.setCursos_id(rs.getInt("cursos_id"));
                turma.setData_final(rs.getDate("data_final"));
                turma.setData_inicio(rs.getDate("date"));
                turma.setInstrutores_id(rs.getInt("instrutores_id"));

                resultado.add(turma);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }
    
    public ArrayList<Turmas> getTurmasPorCurso(int id_curso) {
        ArrayList<Turmas> resultado = new ArrayList<Turmas>();
        try {            
            Statement stmt = conexao.createStatement();
            String sql = "select * from turmas WHERE curso_id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id_curso);
            ResultSet rs = stmt.executeQuery(sql);

            while( rs.next() ) {
                Turmas turma = new Turmas(); 
                
                turma.setId(rs.getInt("id") );
                turma.setCarga_horaria(rs.getInt("carga_horaria"));
                turma.setCursos_id(rs.getInt("cursos_id"));
                turma.setData_final(rs.getDate("data_final"));
                turma.setData_inicio(rs.getDate("date"));
                turma.setInstrutores_id(rs.getInt("instrutores_id"));

                resultado.add(turma);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }


    public boolean gravar( Turmas Turmas ) {
        try {
            String sql;
            if ( Turmas.getId() == 0 ) {
                // Realizar uma inclus�o
                sql = "INSERT INTO turmas (carga_horaria, cursos_id, instrutores_id, data_inicio, data_final) VALUES (?,?,?,?,?)";
            } else {
                // Realizar uma altera��o
                sql = "UPDATE turmas SET carga_horaria=?, cursos_id=?, instrutores_id=?, data_inicio=?, data_final=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, Turmas.getCarga_horaria());
            ps.setInt(2, Turmas.getCursos_id());
            ps.setInt(3, Turmas.getInstrutores_id());
            ps.setDate(4, new Date(Turmas.getData_inicio().getTime()));
            ps.setDate(5, new Date(Turmas.getData_final().getTime()));
            
            if ( Turmas.getId()> 0 )
                ps.setInt(6, Turmas.getId());
            
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
