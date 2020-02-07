package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    //Atributo que ir� armazenar a conex�o com o banco de dados
    private static Connection conexao = null;
    
    //M�todo que realiza a conex�o com o banco de dados
    public static Connection criaConexao() throws SQLException {
        //Verifica se j� exite uma conex�o com o banco de dados
        if ( conexao == null ) {
            try {
                //Carrega o Driver JDBC na mem�ria
                Class.forName("com.mysql.jdbc.Driver"); //load driver                       
                System.out.println("Driver foi carregado!");
                //Abre a conex�o com o banco de dados via JDBC
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/escola", "root", "");
                System.out.println("Conex�o realizada com sucesso!");
            }
            catch( ClassNotFoundException e ) {
                System.out.println("Driver n�o foi localizado!");
                System.out.println(e);
            }
        }
        // Retorna um objeto Connection, contendo a conex�o aberta com o BD
        return conexao;
    }
}
