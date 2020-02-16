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

import model.CursosDAO;
import utils.Cursos;

/**
 * Servlet implementation class AdminCursoController
 */
@WebServlet("/admin/curso")
public class AdminCursoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCursoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher resposta = request.getRequestDispatcher("../tables.jsp");
		resposta.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cursos curso = new Cursos();
		curso.setNome(request.getParameter("nome"));
		curso.setRequisito(request.getParameter("requisito"));
		curso.setEmenta(request.getParameter("ementa"));
		curso.setCarga_horaria(Integer.parseInt(request.getParameter("carga_horaria")));
		curso.setPreco(Double.parseDouble(request.getParameter("preco")));
				
		CursosDAO cursoDAO = new CursosDAO();
		boolean resultado = cursoDAO.gravar(curso);
		request.setAttribute("resultadoReq", resultado);
		RequestDispatcher resposta = request.getRequestDispatcher("../tables.jsp");
		resposta.forward(request, response);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id") == null || Integer.parseInt(request.getParameter("id"))== 0) {
			response.sendError(400, "Id invalido");
		}
		Cursos curso = new Cursos();
		curso.setId(Integer.parseInt(request.getParameter("id")));
		CursosDAO cursoDAO = new CursosDAO();
		if(cursoDAO.excluir(curso.getId()) == true) {
			response.getWriter().write("{isSuccess: true}");
		} else {
			response.sendError(400, "Id invalido");
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cursos curso = new Cursos();
		curso.setId(Integer.parseInt(request.getParameter("id")));
		curso.setNome(request.getParameter("nome"));
		curso.setRequisito(request.getParameter("requisito"));
		curso.setEmenta(request.getParameter("ementa"));
		curso.setCarga_horaria(Integer.parseInt(request.getParameter("carga_horaria")));
		curso.setPreco(Double.parseDouble(request.getParameter("preco")));
		
		CursosDAO cursoDAO = new CursosDAO();
		boolean resultado = cursoDAO.gravar(curso);
	}

}
