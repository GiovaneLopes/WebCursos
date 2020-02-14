package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

/**
 * Servlet implementation class UploadImage
 */
@WebServlet("/aluno/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1MB
		maxFileSize = 1024 * 1024 * 4, // 4MB
		maxRequestSize = 1024 * 1024 * 4 // 4MB
)
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/upload.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
	    InputStream fileContent = filePart.getInputStream();
	    String dir = System.getProperty("user.home") +  "/fotos/alunos/"; // Mudar para pegar o tipo de usuario na sessao
	    String idAluno = request.getParameter("idAluno"); // Mudar para pegar o id na sessao do usuario
	    idAluno = "1";
	    
	    try{
	    	Files.createDirectories(Paths.get(dir));
	    } 
	    catch(SecurityException se){
	    	System.out.println("security: " + se);
	    }        
	    
	    File file = new File(dir, idAluno + ".png");
	    try (InputStream input = fileContent) {
	        Files.copy(input, file.toPath());
	    } catch(Exception e) {
	    	System.out.println(e);
	    }
	}
}
