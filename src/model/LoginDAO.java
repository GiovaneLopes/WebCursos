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
    
    public int doLoginAdmin(String login, String senha) {
    	try {
            String sql = "SELECT * FROM administrador WHERE login = ? && senha = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
            	return rs.getInt("id");
            }
            return 0;
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return 0;
        }
    }
}
