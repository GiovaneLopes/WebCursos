<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../header.jsp"></jsp:include>
<%@ page
	import="model.TurmasDAO, model.CursosDAO, model.InstrutoresDAO, utils.Turmas, utils.Cursos, utils.Instrutores, java.util.ArrayList, java.io.File"%>
<%
	TurmasDAO turmasDAO = new TurmasDAO();
	CursosDAO cursosDAO = new CursosDAO();
	InstrutoresDAO instrutoresDAO = new InstrutoresDAO();
	ArrayList<Turmas> turmas = turmasDAO.getLista();
	Instrutores instrutor;
	Cursos curso;
%>

<div class="container">
	<div class="principal-title">
		<h1 class="welcome">Our Classes!</h1>
		<p>Lorem Ipsum is simply dummy text of the printing and
			typesetting industry.Lorem Ipsum is simply dummy text of the printing
			and typesetting industry.</p>
	</div>
	<div class="courses-cards">
		<%
			for (int i = 0; i < turmas.size(); i++) {
		%>
		<div class="card card-courses" style="width: 18rem;">
			<div class="card-body text-comments">
				<h5 class="card-title">
					ID:
					<%=turmas.get(i).getId()%></h5>
				<div class="card-text">
					<ul>
						<%
							instrutor = instrutoresDAO.getInstrutoresPorID(turmas.get(i).getInstrutores_id());
						%>
						<li>Professor: <%=instrutor.getNome()%>
						</li>
						<%
							curso = cursosDAO.getCursoPorID(turmas.get(i).getCursos_id());
						%>
						<li>Curso: <%=curso.getNome()%>
						</li>
						<li>Carga horaria: <%=turmas.get(i).getCarga_horaria()%>
						</li>
						<li>Data de início: <%=turmas.get(i).getData_inicio()%>
						</li>
						<li>Data de fim: <%=turmas.get(i).getData_final()%>
						</li>
					</ul>
					<form id="deletar_turma">
						<input type="hidden" value="<%=turmas.get(i).getId()%>"
							name="id">
						<button type="submit" class="btn btn-danger">Deletar</button>
					</form>
					<a href="/App/admin/turma/edit?id=<%=turmas.get(i).getId()%>"><button
							type="button" class="btn btn-primary">Editar</button></a>
				</div>
			</div>
		</div>
		<%
			}
		%>

	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
<script>
	$('form#deletar_turma').submit(function(ev) {
		ev.preventDefault()
		let id_turma = $(this).children('input[name=id]').val().trim()
		$.ajax({
			url : '/App/admin/turma?id=' + id_turma,
			type : 'DELETE',
			complete : function(result) {
				console.log(result)
				if (result.status == 200) {
					alert("Turma deletada!")
					location.reload()
				} else {
					alert("Erro ao deletar turma")
				}
			},
		});
	})
</script>