package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.Instrutores;

public class InstrutoresDAO {
	private Connection conexao;

	public InstrutoresDAO() {
		try {
			conexao = Conexao.criaConexao();
		} catch (Exception e) {
			System.out.println("Erro cria��o de conexao DAO");
			System.out.println(e);
		}
	}

	public ArrayList<Instrutores> getLista() {
		ArrayList<Instrutores> resultado = new ArrayList<Instrutores>();
		try {
			Statement stmt = conexao.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT instrutores.*, sum(cursos.carga_horaria) as ch_total "
					+ "FROM instrutores " + "LEFT JOIN turmas " + "ON turmas.instrutores_id = instrutores.id "
					+ "LEFT JOIN cursos " + "ON turmas.cursos_id = cursos.id");

			while (rs.next()) {
				Instrutores instrutor = new Instrutores();
				instrutor.setId(rs.getInt("id"));
				instrutor.setNome(rs.getString("nome"));
				instrutor.setExperiencia(rs.getString("experiencia"));
				instrutor.setEmail(rs.getString("email"));
				instrutor.setLogin(rs.getString("login"));

				if(rs.getString("valor_hora") != null) {
					instrutor.setValor_hora(Integer.parseInt(rs.getString("valor_hora")));
					if (rs.getString("ch_total") != null) {
						int ch_total = Integer.parseInt(rs.getString("ch_total"));
						instrutor.setValor_receber(ch_total * instrutor.getValor_hora());
					}
				}
				
				resultado.add(instrutor);
			}
		} catch (SQLException e) {
			System.out.println("Erro de SQL: " + e.getMessage());
		}

		return resultado;
	}

	public Instrutores getInstrutoresPorID(int codigo) {
		Instrutores instrutor = new Instrutores();
		try {
			String sql = "SELECT instrutores.*, sum(cursos.carga_horaria) as ch_total, turmas.* " + "FROM instrutores "
					+ "LEFT JOIN turmas " + "ON turmas.instrutores_id = instrutores.id " + "LEFT JOIN cursos "
					+ "ON turmas.cursos_id = cursos.id " + "WHERE instrutores.id = ?";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, codigo);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				instrutor.setId(rs.getInt("id"));
				instrutor.setNome(rs.getString("nome"));
				instrutor.setExperiencia(rs.getString("experiencia"));
				instrutor.setEmail(rs.getString("email"));
				instrutor.setValor_hora(rs.getInt("valor_hora"));
				instrutor.setLogin(rs.getString("login"));

				int ch_total = rs.getInt("ch_total");
				instrutor.setValor_receber(ch_total * instrutor.getValor_hora());
			}

		} catch (SQLException e) {
			System.out.println("Erro de SQL: " + e.getMessage());
		}
		return instrutor;
	}

	public Instrutores getLogin(String login, String senha) {
		Instrutores instrutor = new Instrutores();
		try {
			String sql = "SELECT * FROM instrutores WHERE login = ? && senha = ?";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				instrutor.setId(rs.getInt("id"));
				instrutor.setNome(rs.getString("nome"));
				instrutor.setExperiencia(rs.getString("experiencia"));
				instrutor.setEmail(rs.getString("email"));
				instrutor.setValor_hora(rs.getInt("valor_hora"));
				instrutor.setLogin(rs.getString("login"));

				int ch_total = rs.getInt("ch_total");
				instrutor.setValor_receber(ch_total * instrutor.getValor_hora());
			}

		} catch (SQLException e) {
			System.out.println("Erro de SQL: " + e.getMessage());
		}
		return instrutor;
	}

	public boolean gravar(Instrutores instrutor) {
		try {
			String sql;
			if (instrutor.getId() == 0) {
				// Realizar uma inclus�o
				sql = "INSERT INTO instrutores (nome, experiencia, email, valor_hora, login, senha) VALUES (?,?,?,?,?,?)";
			} else {
				// Realizar uma altera��o
				sql = "UPDATE instrutores SET nome=?, experiencia=?, email=?, valor_hora=?, login=?, senha=? WHERE id=?";
			}

			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, instrutor.getNome());
			ps.setString(2, instrutor.getExperiencia());
			ps.setString(3, instrutor.getEmail());
			ps.setInt(4, instrutor.getValor_hora());
			ps.setString(5, instrutor.getLogin());
			ps.setString(6, instrutor.getSenha());

			if (instrutor.getId() > 0)
				ps.setInt(7, instrutor.getId());

			ps.execute();

			return true;
		} catch (SQLException e) {
			System.out.println("Erro de SQL: " + e.getMessage());
			return false;
		}
	}

	public boolean excluir(int id) {
		try {
			String sql = "DELETE FROM instrutores WHERE id = ?";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Erro de SQL: " + e.getMessage());
			return false;
		}
	}
}
