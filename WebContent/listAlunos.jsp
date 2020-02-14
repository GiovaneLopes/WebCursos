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
				File image = new File(System.getProperty("user.home") + "/fotos/alunos/" + alunos.get(i).getId());
					if (image.exists() && image.isFile()) {
			%>
			<img
				src="<%=System.getProperty("user.home") + "/fotos/alunos/" + alunos.get(i).getId()%>"
				class="card-img-top" alt="...">
			<%
				} else {
			%>
			<img src="assets/images/teacher2.jpg" class="card-img-top" alt="...">
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
				</div>
			</div>
		</div>
		<%
			}
		%>

	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>