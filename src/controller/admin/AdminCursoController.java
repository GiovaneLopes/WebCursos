package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
@WebServlet("/AdminCursoController")
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
		CursosDAO cursosDAO = new CursosDAO();
		Cursos curso;
		ArrayList resultado = cursosDAO.getLista();
		PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");
        for(int i=0; i < resultado.size(); i++) {
        	curso = (Cursos) resultado.get(i);
        	out.print(curso.getNome());
        	out.print(curso.getId());
        }
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
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cursos curso = new Cursos();
		curso.setId(Integer.parseInt(request.getParameter("id")));
		CursosDAO cursoDAO = new CursosDAO();
		cursoDAO.excluir(curso.getId());
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
