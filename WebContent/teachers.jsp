<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>
<%@ page
	import="model.InstrutoresDAO, utils.Instrutores, java.util.ArrayList, java.io.File"%>
<%
	InstrutoresDAO instrutoresDAO = new InstrutoresDAO();
	ArrayList<Instrutores> instrutores = instrutoresDAO.getLista();
%>

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
			for (int i = 0; i < instrutores.size(); i++) {
		%>
		<div class="card card-courses" style="width: 18rem;">
			<%
				File image = new File(
							request.getContextPath() + "/assets/fotos/instrutores/" + instrutores.get(i).getId() + ".png");
					if (image.exists() && image.isFile()) {
			%>
			<img
				src='<%=request.getContextPath() + "/assets/fotos/instrutores/" + instrutores.get(i).getId()
							+ ".png"%>'
				class="card-img-top" alt="...">
			<%
				} else {
			%>
			<img
				src='<%=request.getContextPath() + "/assets/images/teacher2.jpg"%>'
				class="card-img-top" alt="...">
			<%
				}
			%>
			<div class="card-body text-comments">
				<h5 class="card-title">
					Nome:
					<%=instrutores.get(i).getNome()%></h5>
				<div class="card-text">
					<ul>
						<li>Email: <%=instrutores.get(i).getEmail()%>
						</li>
						<li>Login: <%=instrutores.get(i).getLogin()%>
						</li>
						<li>Experiencia: <%=instrutores.get(i).getExperiencia()%>
						</li>
						<li>Valor Hora: <%=instrutores.get(i).getValor_hora()%>
						</li>
						<li>Valor a receber: <%=instrutores.get(i).getValor_receber()%>
						</li>
					</ul>
					<%
						//if(session.getAttribute("tipoUser") != null && (int) session.getAttribute("tipoUser") == 3) {
					%>
					<form id="deletar_professor">
						<input type="hidden" value="<%=instrutores.get(i).getId()%>"
							name="id">
						<button type="submit" class="btn btn-danger">Deletar
							professor</button>
					</form>
					<a
						href="/App/admin/instrutor/edit?id=<%=instrutores.get(i).getId()%>"><button
							type="button" class="btn btn-primary">Editar</button></a> <a
						href="/App/admin/upload?id=<%=instrutores.get(i).getId()%>&classe=instrutores"><button
							type="button" class="btn btn-primary">Upload de imagem</button></a>
					<%
						// }
					%>
				</div>
			</div>
		</div>
		<%
			}
		%>

	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<script>
	$('form#deletar_professor').submit(function(ev) {
		ev.preventDefault()
		let id_professor = $(this).children('input[name=id]').val().trim()
		$.ajax({
			url : '/App/admin/instrutor?id=' + id_professor,
			type : 'DELETE',
			complete : function(result) {
				console.log(result)
				if (result.status == 200) {
					alert("Professor deletado!")
					location.reload()
				} else {
					alert("Erro ao deletar professor")
				}
			},
		});
	})
</script>