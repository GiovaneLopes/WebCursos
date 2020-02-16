<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="model.AlunosDAO, utils.Alunos, utils.Matriculas, model.MatriculasDAO, model.CursosDAO, java.util.ArrayList, java.io.File"%>
<%
	if(request.getParameter("id") == null){
		response.sendRedirect("./index.jsp");
	}
	AlunosDAO alunosDAO = new AlunosDAO();
	MatriculasDAO matriculasDAO = new MatriculasDAO();
	CursosDAO cursosDAO = new CursosDAO();
	Alunos aluno = alunosDAO.getAlunoPorID(Integer.parseInt(request.getParameter("id")));
	ArrayList<Matriculas> matriculas = matriculasDAO.getMatriculasPorAluno(aluno.getId());
%>
<jsp:include page="../header.jsp"></jsp:include>
<div class="container">
	<div class="principal-title">
		<h1 class="welcome">Our Student's comments!</h1>
		<p>Lorem Ipsum is simply dummy text of the printing and
			typesetting industry.Lorem Ipsum is simply dummy text of the printing
			and typesetting industry.</p>
	</div>
	<div class="courses-cards">
		<div class="card card-courses" style="width: 18rem;">
			<div class="card-body text-comments">
				<h5 class="card-title">
					<%=aluno.getNome()%></h5>
				<div class="card-text">
					<% for(int i=0; i < matriculas.size(); i++) { %>
						<div class="card-text">
							<%= cursosDAO.getNomeCurso(matriculas.get(i).getTurmas_id()) %>: <%= matriculas.get(i).getNota()%>
						</div>	
					<% } %>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>