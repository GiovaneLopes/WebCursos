package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.Alunos;
import utils.Matriculas;

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
    public ArrayList<Alunos> getLista() {
        ArrayList<Alunos> resultado = new ArrayList<Alunos>();
        try {            
            Statement stmt = conexao.createStatement();

            ResultSet rs = stmt.executeQuery("select * from alunos");

            while( rs.next() ) {
                Alunos alunos = new Alunos(); 
                
                alunos.setId(rs.getInt("id") );
                alunos.setNome( rs.getString("nome") );
                alunos.setAprovado(rs.getString("aprovado").charAt(0));
                alunos.setBairro(rs.getString("bairro"));
                alunos.setCelular(rs.getString("celular"));
                alunos.setCep(rs.getString("cep"));
                alunos.setCidade(rs.getString("cidade"));
                alunos.setComentario(rs.getString("comentario"));
                alunos.setCpf(rs.getString("cpf"));
                alunos.setEmail(rs.getString("email"));
                alunos.setEndereco(rs.getString("endereco"));
                alunos.setLogin(rs.getString("login"));

                resultado.add(alunos);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }
    
    public Alunos getAlunoPorID( int codigo ) {
        Alunos alunos = new Alunos();
        try {
            String sql = "SELECT alunos.*, matriculas.nota, turmas.id, cursos.nome " +
            			 "FROM alunos " +
            			 "LEFT JOIN matriculas " +
            			 "ON alunos.id = matriculas.aluno_id " +
            			 "LEFT JOIN turmas " +
            			 "ON matriculas.turmas_id = turmas.id " +
            			 "LEFT JOIN cursos " +
            			 "ON turmas.cursos_id = cursos.id " +
            			 "WHERE alunos.id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                alunos.setId(rs.getInt("id"));
                alunos.setNome( rs.getString("nome") );
                alunos.setAprovado(rs.getString("aprovado").charAt(0));
                alunos.setBairro(rs.getString("bairro"));
                alunos.setCelular(rs.getString("celular"));
                alunos.setCep(rs.getString("cep"));
                alunos.setCidade(rs.getString("cidade"));
                alunos.setComentario(rs.getString("comentario"));
                alunos.setCpf(rs.getString("cpf"));
                alunos.setEmail(rs.getString("email"));
                alunos.setEndereco(rs.getString("endereco"));
                alunos.setLogin(rs.getString("login"));
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return alunos;
    }
    
    public ArrayList<Alunos> getAlunosPendentes(){
    	ArrayList resultado = new ArrayList();
        try {            
            Statement stmt = conexao.createStatement();

            ResultSet rs = stmt.executeQuery("select * from alunos where aprovado = 'N'");

            while( rs.next() ) {
                Alunos alunos = new Alunos(); 
                
                alunos.setId(rs.getInt("id"));
                alunos.setNome( rs.getString("nome") );
                alunos.setAprovado(rs.getString("aprovado").charAt(0));
                alunos.setBairro(rs.getString("bairro"));
                alunos.setCelular(rs.getString("celular"));
                alunos.setCep(rs.getString("cep"));
                alunos.setCidade(rs.getString("cidade"));
                alunos.setComentario(rs.getString("comentario"));
                alunos.setCpf(rs.getString("cpf"));
                alunos.setEmail(rs.getString("email"));
                alunos.setEndereco(rs.getString("endereco"));
                alunos.setLogin(rs.getString("login"));

                resultado.add(alunos);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }
    
    public ArrayList<Alunos> getAlunosInstrutores(int id_turmas){
    	ArrayList<Alunos> resultado = new ArrayList();
        try {            
            Statement stmt = conexao.createStatement();

            String sql = "SELECT * " + 
            		"FROM alunos " + 
            		"LEFT JOIN matriculas " +
            		"ON matriculas.turmas_id = ? ";
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id_turmas);
            ResultSet rs = ps.executeQuery();

            while( rs.next() ) {
                Alunos alunos = new Alunos(); 
                alunos.setId(rs.getInt("id"));
                alunos.setNome( rs.getString("nome") );
                alunos.setAprovado(rs.getString("aprovado").charAt(0));
                alunos.setBairro(rs.getString("bairro"));
                alunos.setCelular(rs.getString("celular"));
                alunos.setCep(rs.getString("cep"));
                alunos.setCidade(rs.getString("cidade"));
                alunos.setComentario(rs.getString("comentario"));
                alunos.setCpf(rs.getString("cpf"));
                alunos.setEmail(rs.getString("email"));
                alunos.setEndereco(rs.getString("endereco"));
                alunos.setLogin(rs.getString("login"));
                
                Matriculas matricula = new Matriculas();
                matricula.setAlunos_id(rs.getInt("id"));
                matricula.setNota(rs.getDouble("nota"));
                ArrayList<Matriculas> matriculas = new ArrayList<Matriculas>();
                matriculas.add(matricula);
                alunos.setMatriculas(matriculas);
                
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
                sql = "INSERT INTO alunos (nome, cpf, celular, email, senha, login, endereco, cidade, bairro, cep) VALUES (?,?,?,?,?,?,?,?,?,?)";
            } else {
                // Realizar uma altera��o
                sql = "UPDATE alunos SET nome=?, cpf=?, celular=?, email=?, senha=?, login=?, endereco=?, cidade=?, bairro=?, cep=?, comentario=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, Alunos.getNome());
            ps.setString(2, Alunos.getCpf());
            ps.setString(3, Alunos.getCelular());
            ps.setString(4, Alunos.getEmail());
            ps.setString(5, Alunos.getSenha());
            ps.setString(6, Alunos.getLogin());
            ps.setString(7, Alunos.getEndereco());
            ps.setString(8, Alunos.getCidade());
            ps.setString(9, Alunos.getBairro());
            ps.setString(10, Alunos.getCep());
            
            if ( Alunos.getId()> 0 )
                ps.setString(11, Alunos.getComentario());
            
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
