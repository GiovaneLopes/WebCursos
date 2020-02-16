<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.*, utils.*, java.util.ArrayList"%>
<%
	if (request.getParameter("instrutor_id") == null || request.getParameter("turma_id") == null) {
		response.sendRedirect("./index.jsp");
	}
	InstrutoresDAO instrutoresDAO = new InstrutoresDAO();
	TurmasDAO turmasDAO = new TurmasDAO();
	CursosDAO cursosDAO = new CursosDAO();
	AlunosDAO alunosDAO = new AlunosDAO();
	Instrutores instrutor = instrutoresDAO
			.getInstrutoresPorID(Integer.parseInt(request.getParameter("instrutor_id")));
	MatriculasDAO matriculasDAO = new MatriculasDAO();
	ArrayList<Matriculas> matriculas = matriculasDAO
			.getMatriculasPorTurma(Integer.parseInt(request.getParameter("turma_id")));
%>
<jsp:include page="../header.jsp"></jsp:include>
<div class="container">
	<%
		if (request.getAttribute("resultadoReq") != null) {
			if ((boolean) request.getAttribute("resultadoReq") == true) {
				out.print("<div class='alert alert-success' role='alert'>Ação realizada com sucesso'!</div>");
			} else {
				out.print("<div class='alert alert-danger' role='alert'>Erro ao realizar ação!</div>");
			}
		}
	%>
	<div class="principal-title">
		<h1 class="welcome">Meet our teachers!</h1>
		<p>Lorem Ipsum is simply dummy text of the printing and
			typesetting industry.Lorem Ipsum is simply dummy text of the printing
			and typesetting industry.</p>
	</div>
	<div class="courses-cards">
		<%
			for (int i = 0; i < matriculas.size(); i++) {
		%>
		<div class="card card-courses" style="width: 18rem;">
			<div class="card-body text-comments">
				<form method="post" action="/App/instrutor/nota">
					<h5 class="card-title">
						Nome:
						<%=alunosDAO.getNomePorMatricula(matriculas.get(i).getId())%>
						<br> Nota: <input type="text" class="form-control"
							name="nota" value="<%=matriculas.get(i).getNota()%>" required>
					</h5>
					<input type="hidden" value="<%=matriculas.get(i).getId()%>"
						name="id">
					<button type="submit" class="btn btn-primary">Dar nota</button>
				</form>
			</div>
		</div>
		<%
			}
		%>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>