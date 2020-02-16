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
		} catch (Exception e) {
			System.out.println("Erro cria��o de conexao DAO");
			System.out.println(e);
		}
	}

	public ArrayList<Cursos> getLista() {
		ArrayList<Cursos> resultado = new ArrayList<Cursos>();
		try {
			Statement stmt = conexao.createStatement();

			ResultSet rs = stmt.executeQuery("select * from cursos");

			while (rs.next()) {
				Cursos cursos = new Cursos();
				cursos.setId(rs.getInt("id"));
				cursos.setNome(rs.getString("nome"));
				cursos.setCarga_horaria(Integer.parseInt(rs.getString("carga_horaria")));
				cursos.setEmenta(rs.getString("ementa"));
				cursos.setPreco(Double.parseDouble(rs.getString("preco")));
				cursos.setRequisito(rs.getString("requisito"));

				resultado.add(cursos);
			}
		} catch (SQLException e) {
			System.out.println("Erro de SQL: " + e.getMessage());
		}

		return resultado;
	}

	public Cursos getCursoPorID(int codigo) {
		Cursos cursos = new Cursos();
		try {
			String sql = "SELECT * FROM cursos WHERE id = ?";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, codigo);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				cursos.setId(rs.getInt("id"));
				cursos.setNome(rs.getString("nome"));
				cursos.setCarga_horaria(Integer.parseInt(rs.getString("carga_horaria")));
				cursos.setEmenta(rs.getString("ementa"));
				cursos.setPreco(Double.parseDouble(rs.getString("preco")));
				cursos.setRequisito(rs.getString("requisito"));
			}

		} catch (SQLException e) {
			System.out.println("Erro de SQL: " + e.getMessage());
		}
		return cursos;
	}

	public String getNomeCurso(int id_turma) {
		try {
			String sql = "SELECT nome FROM cursos LEFT JOIN turmas ON turmas.cursos_id=cursos.id WHERE turmas.id = ?";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id_turma);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getString("nome");
			} else {
				return null;
			}

		} catch (SQLException e) {
			System.out.println("Erro de SQL: " + e.getMessage());
			return null;
		}

	}

	public boolean gravar(Cursos cursos) {
		try {
			String sql;
			if (cursos.getId() == 0) {
				// Realizar uma inclus�o
				sql = "INSERT INTO cursos (nome, carga_horaria, ementa, preco, requisito) VALUES (?,?,?,?,?)";
			} else {
				// Realizar uma altera��o
				sql = "UPDATE cursos SET nome=?, carga_horaria=?, ementa=?, preco=?, requisito=? WHERE id=?";
			}

			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, cursos.getNome());
			ps.setInt(2, cursos.getCarga_horaria());
			ps.setString(3, cursos.getEmenta());
			ps.setDouble(4, cursos.getPreco());
			ps.setString(5, cursos.getRequisito());

			if (cursos.getId() > 0)
				ps.setInt(6, cursos.getId());

			ps.execute();

			return true;
		} catch (SQLException e) {
			System.out.println("Erro de SQL: " + e.getMessage());
			return false;
		}
	}

	public boolean excluir(int id) {
		try {
			String sql = "DELETE FROM cursos WHERE id = ?";
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
