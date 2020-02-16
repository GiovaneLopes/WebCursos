package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AlunosDAO;
import model.MatriculasDAO;
import utils.Alunos;
import utils.Matriculas;

/**
 * Servlet implementation class InstrutorController
 */
@WebServlet("/instrutor/nota")
public class InstrutorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InstrutorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("nota") == null || request.getParameter("id") == null) {
			RequestDispatcher resposta = request.getRequestDispatcher("../instrutor/turmaAlunos.jsp");
			resposta.forward(request, response);
		} else {
			MatriculasDAO matriculaDAO = new MatriculasDAO();		
			boolean resultado = false;
			Matriculas matricula = new Matriculas();
			matricula.setId(Integer.parseInt(request.getParameter("id")));
			matricula.setNota(Integer.parseInt(request.getParameter("nota")));
			resultado = matriculaDAO.darNotaAluno(matricula);

			request.setAttribute("resultadoReq", resultado);
			RequestDispatcher resposta = request.getRequestDispatcher("../instrutor/turmaAlunos.jsp");
			resposta.forward(request, response);
		}
	}

}
