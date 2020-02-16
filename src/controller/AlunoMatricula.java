package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MatriculasDAO;
import model.TurmasDAO;
import utils.Matriculas;
import utils.Turmas;

/**
 * Servlet implementation class AlunoMatricula
 */
@WebServlet("/aluno/matricula")
public class AlunoMatricula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlunoMatricula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		HttpSession session = httpReq.getSession();
		
		if(session.getAttribute("tipoUser") == null || Integer.parseInt((String)session.getAttribute("tipoUser")) != 1) {
			httpResp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		} else {
			int id_curso = Integer.parseInt(request.getParameter("id_curso"));
			TurmasDAO turmasDAO = new TurmasDAO();
			MatriculasDAO matriculasDAO;
			Matriculas matricula;
			ArrayList<Turmas> turmas;
			turmas = turmasDAO.getTurmasPorCurso(id_curso);
			if(turmas.size() > 0) {
				matriculasDAO = new MatriculasDAO();
				matricula = new Matriculas();
				matricula.setAlunos_id(Integer.parseInt((String)session.getAttribute("userId")));
				matricula.setData_matricula(new Date());
				boolean matriculado = false;
				for(int i= 0; i < turmas.size(); i++) {
					if(!turmas.get(i).getData_final().after(new Date())){
						matricula.setTurmas_id(turmas.get(i).getId());
						matriculado = true;
					}
				}
				if(!matriculado) {
					request.setAttribute("resultadoReq", false);
					RequestDispatcher resposta = request.getRequestDispatcher("../index.jsp");
					resposta.forward(request, response);
				} else {
					matriculasDAO.gravar(matricula);
				}
			} else {
				request.setAttribute("resultadoReq", false);
				RequestDispatcher resposta = request.getRequestDispatcher("../index.jsp");
				resposta.forward(request, response);
			}
		}
	}

}
