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
		<h1 class="welcome">Our Student's comments!</h1>
		<p>Lorem Ipsum is simply dummy text of the printing and
			typesetting industry.Lorem Ipsum is simply dummy text of the printing
			and typesetting industry.</p>
	</div>
	<div class="courses-cards">
		<%
			for (int i = 0; i < alunos.size(); i++) { if(alunos.get(i).getComentario() != null){
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
			<img src='<%=request.getContextPath() + "/assets/images/teacher2.jpg"%>' class="card-img-top" alt="...">
			<%
				}
			%>
			<div class="card-body text-comments">
				<h5 class="card-title">
					<%=alunos.get(i).getNome()%></h5>
				<div class="card-text">
					<%=alunos.get(i).getComentario()%>
				</div>
			</div>
		</div>
		<%
			}}
		%>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>