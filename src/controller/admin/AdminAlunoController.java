package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AlunosDAO;
import utils.Alunos;

/**
 * Servlet implementation class AdminAlunoController
 */
@WebServlet("/admin/alunos")
public class AdminAlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlunosDAO alunoDAO = new AlunosDAO();
	private Alunos aluno;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAlunoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher resposta = request.getRequestDispatcher("listAlunos.jsp");
		resposta.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		aluno = new Alunos();
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
		
		boolean resultado = alunoDAO.gravar(aluno);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		aluno = new Alunos();
		aluno.setId(Integer.parseInt(request.getParameter("id")));
		alunoDAO.excluir(aluno.getId());
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		aluno = new Alunos();
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
		aluno.setAprovado(request.getParameter("aprovado").charAt(0));
		
		boolean resultado = alunoDAO.gravar(aluno);
	}

}
