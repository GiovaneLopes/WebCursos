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
		RequestDispatcher resposta = request.getRequestDispatcher("signin.html");
		resposta.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email= request.getParameter("email");
		String password = (String) request.getAttribute("senha");
		int tipoUser = Integer.parseInt(request.getParameter("tipoUser"));
		
		int resultado = doLogin(tipoUser, email, password);
		System.out.println(password);
		System.out.println(resultado);
		if(resultado > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			session.setAttribute("tipoUser", tipoUser);
			session.setAttribute("userId", resultado);
		}else {
			request.setAttribute("resultadoReq", resultado);
		}
	}
	
	public int doLogin(int tipoUser, String email, String senha) {
    	switch(tipoUser) {
    		case 1: 
    			AlunosDAO aluno = new AlunosDAO();
    			Alunos resultAluno = aluno.getLogin(email, senha);
    			if(resultAluno.getNome() != null) {
    				return resultAluno.getId();
    			}
    			break;
    		case 2:
    			InstrutoresDAO instrutor = new InstrutoresDAO();
    			Instrutores resultInstrutor = instrutor.getLogin(email, senha);
    			if(resultInstrutor.getNome() != null) {
    				return resultInstrutor.getId();
    			}
    			break;
    		case 3:
    			LoginDAO admin = new LoginDAO();
    			return admin.doLoginAdmin(email, senha);
    	}
    	return 0;
    }
}
