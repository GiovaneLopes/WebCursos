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
@WebServlet("/admin/curso/edit")
public class AdminCursoEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Cursos curso = new Cursos();
    private CursosDAO cursoDAO = new CursosDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCursoEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		curso = cursoDAO.getCursoPorID(id);
		request.setAttribute("objetoToUpdate", curso);
		RequestDispatcher resposta = request.getRequestDispatcher("tables.jsp");
		resposta.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		curso = new Cursos();
		curso.setId(Integer.parseInt(request.getParameter("id")));
		curso.setNome(request.getParameter("nome"));
		curso.setRequisito(request.getParameter("requisito"));
		curso.setEmenta(request.getParameter("ementa"));
		curso.setCarga_horaria(Integer.parseInt(request.getParameter("carga_horaria")));
		curso.setPreco(Double.parseDouble(request.getParameter("preco")));
		
		boolean resultado = cursoDAO.gravar(curso);
		request.setAttribute("objetoToUpdate", curso);
		request.setAttribute("resultadoReq", resultado);
		RequestDispatcher resposta = request.getRequestDispatcher("../../tables.jsp");
		resposta.forward(request, response);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		curso = new Cursos();
		curso.setId(Integer.parseInt(request.getParameter("id")));
		cursoDAO.excluir(curso.getId());
	}

}
