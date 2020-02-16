<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>
<%@ page
	import="model.AlunosDAO, utils.Alunos, java.util.ArrayList, java.io.File"%>
<%
	AlunosDAO alunosDAO = new AlunosDAO();
	ArrayList<Alunos> alunos = alunosDAO.getLista();
%>

<div class="container">
	<%
		if (request.getAttribute("resultadoReq") != null) {
			if ((boolean) request.getAttribute("resultadoReq") == true) {
				out.print("<div class='alert alert-success' role='alert'>Usu�rio aprovado com sucesso!</div>");
			} else {
				out.print("<div class='alert alert-danger' role='alert'>Erro ao cadastrar usu�rio!</div>");
			}
		}
	%>
	<div class="principal-title">
		<h1 class="welcome">Our Students!</h1>
		<p>Lorem Ipsum is simply dummy text of the printing and
			typesetting industry.Lorem Ipsum is simply dummy text of the printing
			and typesetting industry.</p>
	</div>
	<div class="courses-cards">
		<%
			for (int i = 0; i < alunos.size(); i++) {
		%>
		<div class="card card-courses" style="width: 18rem;">
			<%
				File image = new File( request.getContextPath() + "/assets/fotos/alunos/" + alunos.get(i).getId() + ".png");
					if (image.exists() && image.isFile()) {
			%>
			<img
				src='<%= request.getContextPath() + "/assets/fotos/alunos/" + alunos.get(i).getId() + ".png"%>'
				class="card-img-top" alt="...">
			<%
				} else {
			%>
			<img src='<%=request.getContextPath() + "/assets/images/teacher2.jpg"%>' class="card-img-top" alt="...">
			<%
				}
			%>
			<div class="card-body text-comments">
				<h5 class="card-title">
					Nome:
					<%=alunos.get(i).getNome()%></h5>
				<div class="card-text">
					<ul>
						<li>Cpf: <%=alunos.get(i).getCpf()%>
						</li>
						<li>Celular: <%=alunos.get(i).getCelular()%>
						</li>
						<li>Email: <%=alunos.get(i).getEmail()%>
						</li>
						<li>Login: <%=alunos.get(i).getLogin()%>
						</li>
						<li>Endereco: <%=alunos.get(i).getEndereco()%>
						</li>
						<li>Cidade: <%=alunos.get(i).getCidade()%>
						</li>
						<li>Bairro: <%=alunos.get(i).getBairro()%>
						</li>
						<li>Cep: <%=alunos.get(i).getCep()%>
						</li>
						<li>Comentario: <%=alunos.get(i).getComentario()%>
						</li>
						<li>Aprovado: <%=alunos.get(i).getAprovado()%>
						</li>
					</ul>
					<% if(alunos.get(i).getAprovado() == 'N') { %>
					<form action="/App/admin/aprovacao" method="post">
						<input type="hidden" value="<%= alunos.get(i).getId() %>" name="id">
						<input type="hidden" value="S" name="aprovado">
						<button type="submit" class="btn btn-success">Aprovar aluno</button>
					</form>
					<% } %>
					<form id="deletar_aluno">
						<input type="hidden" value="<%=alunos.get(i).getId()%>"
							name="id">
						<button type="submit" class="btn btn-danger">Deletar</button>
					</form>
					<a href="/App/admin/aluno/edit?id=<%= alunos.get(i).getId() %>"><button type="button" class="btn btn-primary">Editar</button></a>
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
	$('form#deletar_aluno').submit(function(ev) {
		ev.preventDefault()
		let id_aluno = $(this).children('input[name=id]').val().trim()
		$.ajax({
			url : '/App/admin/alunos?id=' + id_aluno,
			type : 'DELETE',
			complete : function(result) {
				console.log(result)
				if (result.status == 200) {
					alert("Aluno deletado!")
					location.reload()
				} else {
					alert("Erro ao deletar aluno")
				}
			},
		});
	})
</script>