package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AlunosDAO;
import utils.Alunos;

/**
 * Servlet implementation class Aprovacao
 */
@WebServlet("/admin/aprovacao")
public class Aprovacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Aprovacao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AlunosDAO alunoDAO = new AlunosDAO();
		ArrayList alunos = alunoDAO.getAlunosPendentes();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		char aprovado = request.getParameter("aprovado").toCharArray()[0];
		AlunosDAO alunoDAO = new AlunosDAO();
		if(aprovado == 'S') {
			Alunos aluno = new Alunos();
			aluno.setId(Integer.parseInt(request.getParameter("id")));
			aluno.setNome(request.getParameter("nome"));
			aluno.setEmail(request.getParameter("email"));
			aluno.setSenha(request.getParameter("senha"));
			aluno.setLogin(request.getParameter("login"));
			aluno.setCpf(request.getParameter("cpf"));
			aluno.setCelular(request.getParameter("celular"));
			aluno.setEndereco(request.getParameter("endereco"));
			aluno.setBairro(request.getParameter("Bairro"));
			aluno.setCidade(request.getParameter("cidade"));
			aluno.setCep(request.getParameter("cep"));
			aluno.setComentario(request.getParameter("comentario"));
			aluno.setAprovado('S');
			
			Boolean resultado = alunoDAO.gravar(aluno);
		} else {
			alunoDAO.excluir(Integer.parseInt(request.getParameter("id")));
		}
	}

}
