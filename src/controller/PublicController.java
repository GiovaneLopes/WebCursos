package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AlunosDAO;
import utils.Alunos;

/**
 * Servlet implementation class PublicController
 */
@WebServlet("/index")
public class PublicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher resposta = request.getRequestDispatcher("index.jsp");
		resposta.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Alunos aluno = new Alunos();
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
		
		AlunosDAO alunoDAO = new AlunosDAO();
		boolean resultado = alunoDAO.gravar(aluno);
	}

}
