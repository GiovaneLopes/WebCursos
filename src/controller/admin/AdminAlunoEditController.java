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
@WebServlet("/admin/aluno/edit")
public class AdminAlunoEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlunosDAO alunoDAO = new AlunosDAO();
	private Alunos aluno;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAlunoEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		aluno = alunoDAO.getAlunoPorID(id);
		request.setAttribute("objetoToUpdate", aluno);
		RequestDispatcher resposta = request.getRequestDispatcher("../../tables.jsp");
		resposta.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		aluno = new Alunos();
		aluno.setId(Integer.parseInt(request.getParameter("id")));
		aluno.setNome(request.getParameter("nome"));
		aluno.setEmail(request.getParameter("email"));
		aluno.setSenha((String) request.getAttribute("senha"));
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
		request.setAttribute("objetoToUpdate", aluno);
		request.setAttribute("resultadoReq", resultado);
		RequestDispatcher resposta = request.getRequestDispatcher("../../tables.jsp");
		resposta.forward(request, response);
	}

}
