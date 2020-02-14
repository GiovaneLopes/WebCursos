package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AlunosDAO;
import utils.Alunos;

/**
 * Servlet implementation class Aluno
 */
@WebServlet("/aluno")
public class AlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlunoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		AlunosDAO aluno = new AlunosDAO();
//		Alunos print;
//		ArrayList resultado = aluno.getLista();
//		PrintWriter out = response.getWriter();
//
//        out.println("<html>");
//        out.println("<body>");
//        for(int i=0; i < resultado.size(); i++) {
//        	print = (Alunos) resultado.get(i);
//        	out.print(print.getNome());
//        	out.print(print.getId());
//        }
//        doGet(request, response);
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher resposta = request.getRequestDispatcher("register.jsp");
		resposta.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Alunos aluno = new Alunos();
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
		
		AlunosDAO alunoDAO = new AlunosDAO();
		boolean resultado = alunoDAO.gravar(aluno);
		request.setAttribute("resultadoReq", resultado);
		RequestDispatcher resposta = request.getRequestDispatcher("register.jsp");
		resposta.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		aluno.setAprovado(request.getParameter("aprovado").charAt(0));
		
		AlunosDAO alunoDAO = new AlunosDAO();
		boolean resultado = alunoDAO.gravar(aluno);
	}

}
