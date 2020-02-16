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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher resposta = request.getRequestDispatcher("../../tables.jsp");
		resposta.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Instrutores instrutor = new Instrutores();
		instrutor.setNome(request.getParameter("nome"));
		instrutor.setEmail(request.getParameter("email"));
		instrutor.setSenha((String) request.getAttribute("senha"));
		instrutor.setLogin(request.getParameter("login"));
		instrutor.setSenha((String) request.getAttribute("senha"));
		instrutor.setExperiencia(request.getParameter("experiencia"));
		instrutor.setValor_hora(Integer.parseInt(request.getParameter("valor_hora")));

		InstrutoresDAO instrutorDAO = new InstrutoresDAO();
		boolean resultado = instrutorDAO.gravar(instrutor);
		request.setAttribute("resultadoReq", resultado);
		RequestDispatcher resposta = request.getRequestDispatcher("../tables.jsp");
		resposta.forward(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("id") == null || Integer.parseInt(request.getParameter("id")) == 0) {
			response.sendError(400, "Id invalido");
		}
		Instrutores instrutor = new Instrutores();
		instrutor.setId(Integer.parseInt(request.getParameter("id")));
		InstrutoresDAO instrutorDAO = new InstrutoresDAO();
		if (instrutorDAO.excluir(instrutor.getId()) == true) {
			response.getWriter().write("{isSuccess: true}");
		} else {
			response.sendError(400, "Id invalido");
		}
	}
}
