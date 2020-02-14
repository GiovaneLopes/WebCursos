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

import model.InstrutoresDAO;
import utils.Instrutores;

/**
 * Servlet implementation class AdminInstrutorController
 */
@WebServlet("/admin/instrutor/edit")
public class AdminInstrutorEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private InstrutoresDAO instrutorDAO = new InstrutoresDAO();
	private Instrutores instrutor;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInstrutorEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		instrutor = instrutorDAO.getInstrutoresPorID(id);
		request.setAttribute("objetoToUpdate", instrutor);
		RequestDispatcher resposta = request.getRequestDispatcher("tables.jsp");
		resposta.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		instrutor = new Instrutores();
		instrutor.setId(Integer.parseInt(request.getParameter("id")));
		instrutor.setNome(request.getParameter("nome"));
		instrutor.setEmail(request.getParameter("email"));
		instrutor.setSenha(request.getParameter("senha"));
		instrutor.setLogin(request.getParameter("login"));
		instrutor.setSenha(request.getParameter("senha"));
		instrutor.setExperiencia(request.getParameter("experiencia"));
		instrutor.setValor_hora(Integer.parseInt(request.getParameter("valor_hora")));
		
		boolean resultado = instrutorDAO.gravar(instrutor);
		request.setAttribute("objetoToUpdate", instrutor);
		request.setAttribute("resultadoReq", resultado);
		RequestDispatcher resposta = request.getRequestDispatcher("../../tables.jsp");
		resposta.forward(request, response);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Instrutores instrutor = new Instrutores();
		instrutor.setId(Integer.parseInt(request.getParameter("id")));
		InstrutoresDAO instrutorDAO = new InstrutoresDAO();
		instrutorDAO.excluir(instrutor.getId());
	}

}
