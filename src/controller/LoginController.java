package controller;

import java.io.IOException;

import javax.crypto.Cipher;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AlunosDAO;
import model.InstrutoresDAO;
import model.LoginDAO;
import utils.Alunos;
import utils.Instrutores;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher resposta = request.getRequestDispatcher("signin.jsp");
		resposta.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login= request.getParameter("login");
		String password = (String) request.getAttribute("senha");
		int tipoUser = Integer.parseInt(request.getParameter("tipoUser"));
		
		int resultado = doLogin(tipoUser, login, password);
		if(resultado > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			session.setAttribute("tipoUser", tipoUser);
			session.setAttribute("userId", resultado);
			request.setAttribute("resultadoReq", true);
		}else {
			request.setAttribute("resultadoReq", false);
		}
		RequestDispatcher resposta = request.getRequestDispatcher("signin.jsp");
		resposta.forward(request, response);
	}
	
	public int doLogin(int tipoUser, String login, String senha) {
    	switch(tipoUser) {
    		case 1: 
    			AlunosDAO aluno = new AlunosDAO();
    			Alunos resultAluno = aluno.getLogin(login, senha);
    			if(resultAluno.getNome() != null) {
    				return resultAluno.getId();
    			}
    			break;
    		case 2:
    			InstrutoresDAO instrutor = new InstrutoresDAO();
    			Instrutores resultInstrutor = instrutor.getLogin(login, senha);
    			if(resultInstrutor.getNome() != null) {
    				return resultInstrutor.getId();
    			}
    			break;
    		case 3:
    			LoginDAO admin = new LoginDAO();
    			return admin.doLoginAdmin(login, senha);
    	}
    	return 0;
    }
}
