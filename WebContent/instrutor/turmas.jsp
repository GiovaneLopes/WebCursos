<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="model.InstrutoresDAO, utils.Instrutores, utils.Turmas, model.TurmasDAO, model.CursosDAO, java.util.ArrayList, java.io.File"%>
<%
	if (request.getParameter("id") == null) {
		response.sendRedirect("./index.jsp");
	}
	InstrutoresDAO instrutoresDAO = new InstrutoresDAO();
	TurmasDAO turmasDAO = new TurmasDAO();
	CursosDAO cursosDAO = new CursosDAO();
	Instrutores instrutor = instrutoresDAO.getInstrutoresPorID(Integer.parseInt(request.getParameter("id")));
	ArrayList<Turmas> turmas = turmasDAO.getTurmasPorInstrutor(instrutor.getId());
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
					<%=instrutor.getNome()%></h5>
				<div class="card-text">
					<%
						for (int i = 0; i < turmas.size(); i++) {
					%>
					<div class="card-text">
						<%=cursosDAO.getNomeCurso(turmas.get(i).getId())%>:
						<%=turmas.get(i).getId()%>
						<a href='/App/instrutor/turmaAlunos.jsp?id=<%=turmas.get(i).getId()%>' class="btn btn-primary">Ver alunos</a>
					</div>
					<%
						}
					%>
					<div class="card-text">Salário: <%=instrutor.getValor_receber() %></div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>