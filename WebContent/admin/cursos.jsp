<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../header.jsp"></jsp:include>
<%@ page
	import="model.CursosDAO, utils.Cursos, java.util.ArrayList, java.io.File"%>
<%
	CursosDAO cursosDAO = new CursosDAO();
	ArrayList<Cursos> cursos = cursosDAO.getLista();
%>

<div class="container">
	<div class="principal-title">
		<h1 class="welcome">Our Courses!</h1>
		<p>Lorem Ipsum is simply dummy text of the printing and
			typesetting industry.Lorem Ipsum is simply dummy text of the printing
			and typesetting industry.</p>
	</div>
	<div class="courses-cards">
		<%
			for (int i = 0; i < cursos.size(); i++) {
		%>
		<div class="card card-courses" style="width: 18rem;">
			<%
				File image = new File(request.getContextPath() + "/assets/fotos/cursos/" + cursos.get(i).getId() + ".png");
					if (image.exists() && image.isFile()) {
			%>
			<img
				src='<%=request.getContextPath() + "/assets/fotos/cursos/" + cursos.get(i).getId() + ".png"%>'
				class="card-img-top" alt="...">
			<%
				} else {
			%>
			<img
				src='<%=request.getContextPath() + "/assets/images/curso-image.jpg"%>'
				class="card-img-top" alt="...">
			<%
				}
			%>
			<div class="card-body text-comments">
				<h5 class="card-title">
					Nome:
					<%=cursos.get(i).getNome()%></h5>
				<div class="card-text">
					<ul>
						<li>Requisito: <%=cursos.get(i).getRequisito()%>
						</li>
						<li>Ementa: <%=cursos.get(i).getEmenta()%>
						</li>
						<li>Carga horaria: <%=cursos.get(i).getCarga_horaria()%>
						</li>
						<li>Preco: R$<%=cursos.get(i).getPreco()%>
						</li>
					</ul>
					<form id="deletar_curso">
						<input type="hidden" value="<%=cursos.get(i).getId()%>"
							name="id">
						<button type="submit" class="btn btn-danger">Deletar</button>
					</form>
					<a href="/App/admin/curso/edit?id=<%=cursos.get(i).getId()%>"><button
							type="button" class="btn btn-primary">Editar</button></a> <a
						href="/App/admin/upload?id=<%=cursos.get(i).getId()%>&classe=cursos"><button
							type="button" class="btn btn-primary">Upload de imagem</button></a>
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
	$('form#deletar_curso').submit(function(ev) {
		ev.preventDefault()
		let id_curso = $(this).children('input[name=id]').val().trim()
		$.ajax({
			url : '/App/admin/curso?id=' + id_curso,
			type : 'DELETE',
			complete : function(result) {
				console.log(result)
				if (result.status == 200) {
					alert("Curso deletado!")
					location.reload()
				} else {
					alert("Erro ao deletar curso")
				}
			},
		});
	})
</script>