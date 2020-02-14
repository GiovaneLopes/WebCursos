package controller;

import java.io.IOException;
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
		RequestDispatcher resposta = request.getRequestDispatcher("../listAlunos.jsp");
		resposta.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		char aprovado = request.getParameter("aprovado").toCharArray()[0];
		AlunosDAO alunoDAO = new AlunosDAO();
		boolean resultado = false;
		if(aprovado == 'S') {
			Alunos aluno = new Alunos();
			aluno.setId(Integer.parseInt(request.getParameter("id")));
			aluno.setAprovado('S');
			
			resultado = alunoDAO.aprovaAluno(aluno);
		}
		request.setAttribute("resultadoReq", resultado);
		RequestDispatcher resposta = request.getRequestDispatcher("../listAlunos.jsp");
		resposta.forward(request, response);
	}

}
