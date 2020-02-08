package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.Alunos;
import utils.Instrutores;

public class LoginDAO {
	private Connection conexao;
    public LoginDAO() {
        try {
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro cria��o de conexao DAO");
            System.out.println(e);
        }
    }
    
    public boolean doLogin(String tipoUser, String email, String senha) {
    	switch(tipoUser) {
    		case "Aluno": 
    			AlunosDAO aluno = new AlunosDAO();
    			Alunos resultAluno = aluno.getLogin(email, senha);
    			if(resultAluno.getNome() != null) {
    				return true;
    			}
    			break;
    		case "Instrutor":
    			InstrutoresDAO instrutor = new InstrutoresDAO();
    			Instrutores resultInstrutor = instrutor.getLogin(email, senha);
    			if(resultInstrutor.getNome() != null) {
    				return true;
    			}
    			break;
    		case "Admin":
    			return this.doLoginAdmin(email, senha);
    	}
    	return false;
    }
    
    public boolean doLoginAdmin(String email, String senha) {
    	try {
            String sql = "SELECT * FROM instrutores WHERE email = ? && senha = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, senha);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
            	return true;
            }
            return false;
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
}
