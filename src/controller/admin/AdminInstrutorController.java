package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InstrutoresDAO;
import utils.Instrutores;

/**
 * Servlet implementation class AdminInstrutorController
 */
@WebServlet("/admin/instrutor")
public class AdminInstrutorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInstrutorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InstrutoresDAO instrutorDAO = new InstrutoresDAO();
		Instrutores instrutor;
		ArrayList resultado = instrutorDAO.getLista();
		PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");
        for(int i=0; i < resultado.size(); i++) {
        	instrutor = (Instrutores) resultado.get(i);
        	out.print(instrutor.getNome());
        	out.print(instrutor.getId());
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Instrutores instrutor = new Instrutores();
		instrutor.setNome(request.getParameter("nome"));
		instrutor.setEmail(request.getParameter("email"));
		instrutor.setSenha(request.getParameter("senha"));
		instrutor.setLogin(request.getParameter("login"));
		instrutor.setSenha(request.getParameter("senha"));
		instrutor.setExperiencia(request.getParameter("experiencia"));
		instrutor.setValor_hora(Integer.parseInt(request.getParameter("valor_hora")));
		
		InstrutoresDAO instrutorDAO = new InstrutoresDAO();
		boolean resultado = instrutorDAO.gravar(instrutor);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Instrutores instrutor = new Instrutores();
		instrutor.setId(Integer.parseInt(request.getParameter("id")));
		InstrutoresDAO instrutorDAO = new InstrutoresDAO();
		instrutorDAO.excluir(instrutor.getId());
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Instrutores instrutor = new Instrutores();
		instrutor.setId(Integer.parseInt(request.getParameter("id")));
		instrutor.setNome(request.getParameter("nome"));
		instrutor.setEmail(request.getParameter("email"));
		instrutor.setSenha(request.getParameter("senha"));
		instrutor.setLogin(request.getParameter("login"));
		instrutor.setSenha(request.getParameter("senha"));
		instrutor.setExperiencia(request.getParameter("experiencia"));
		instrutor.setValor_hora(Integer.parseInt(request.getParameter("valor_hora")));
		
		InstrutoresDAO instrutorDAO = new InstrutoresDAO();
		boolean resultado = instrutorDAO.gravar(instrutor);
	}
}
