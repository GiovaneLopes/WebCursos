package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TurmasDAO;
import utils.Turmas;

/**
 * Servlet implementation class AdminTurmaController
 */
@WebServlet("/admin/turma/edit")
public class AdminTurmaEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TurmasDAO turmaDAO = new TurmasDAO();
	private Turmas turma;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTurmaEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		turma = turmaDAO.getTurmaPorID(id);
		request.setAttribute("objetoToUpdate", turma);
		RequestDispatcher resposta = request.getRequestDispatcher("tables.jsp");
		resposta.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		turma = new Turmas();
		turma.setId(Integer.parseInt(request.getParameter("id")));
		turma.setInstrutores_id(Integer.parseInt(request.getParameter("instrutores_id")));
		turma.setCursos_id(Integer.parseInt(request.getParameter("cursos_id")));
		turma.setCarga_horaria(Integer.parseInt(request.getParameter("carga_horaria")));
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		try {
			turma.setData_inicio(formato.parse(request.getParameter("data_inicio")));
			turma.setData_final(formato.parse(request.getParameter("data_final")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			turma.setData_inicio(new Date());
			turma.setData_final(new Date());
		}
		
		boolean resultado = turmaDAO.gravar(turma);
		request.setAttribute("objetoToUpdate", turma);
		request.setAttribute("resultadoReq", resultado);
		RequestDispatcher resposta = request.getRequestDispatcher("../../tables.jsp");
		resposta.forward(request, response);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Turmas turma = new Turmas();
		turma.setId(Integer.parseInt(request.getParameter("id")));
		TurmasDAO turmaDAO = new TurmasDAO();
		turmaDAO.excluir(turma.getId());
	}

}
