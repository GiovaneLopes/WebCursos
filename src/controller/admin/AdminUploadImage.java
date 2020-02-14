package controller.admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.CursosDAO;
import model.InstrutoresDAO;
import utils.Cursos;
import utils.Instrutores;

/**
 * Servlet implementation class AdminUploadImage
 */
@WebServlet("/admin/upload")
public class AdminUploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUploadImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id") == null || request.getParameter("classe") == null ) {
			RequestDispatcher resposta = request.getRequestDispatcher("../tables.jsp");
			resposta.forward(request, response);
		}else {
			int id = Integer.parseInt(request.getParameter("id"));
			String classe = request.getParameter("classe");
			if(classe == "instrutores") {
				InstrutoresDAO instrutorDAO = new InstrutoresDAO();
				Instrutores instrutor = instrutorDAO.getInstrutoresPorID(id);
				if(instrutor != null && instrutor.getId() == id) {
					request.setAttribute("objetoToUpdate", instrutor);
					RequestDispatcher resposta = request.getRequestDispatcher("upload.jsp");
					resposta.forward(request, response);
				}
			} else if(classe == "cursos") {
				CursosDAO cursoDAO = new CursosDAO();
				Cursos curso = cursoDAO.getCursoPorID(id);
				if(curso != null && curso.getId() == id) {
					request.setAttribute("objetoToUpdate", curso);
					RequestDispatcher resposta = request.getRequestDispatcher("upload.jsp");
					resposta.forward(request, response);
				}
			} else {
				RequestDispatcher resposta = request.getRequestDispatcher("../tables.jsp");
				resposta.forward(request, response);
			}
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classe = request.getParameter("classe");
		String id = request.getParameter("id");
		String filename = id + ".png";
		Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
	    InputStream fileContent = filePart.getInputStream();
	    String dir = System.getProperty("user.home") +  "/fotos/" + classe; // Mudar para pegar o tipo de usuario na sessao
	    
	    try{
	    	Files.createDirectories(Paths.get(dir));
	    } 
	    catch(SecurityException se){
	    	System.out.println("security: " + se);
	    }        
	    
	    File file = new File(dir, filename);
	    try (InputStream input = fileContent) {
	        Files.copy(input, file.toPath());
	    } catch(Exception e) {
	    	System.out.println(e);
	    }
	}

}
