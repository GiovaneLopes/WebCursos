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
				File image = new File(System.getProperty("user.home") + "/fotos/instrutores/" + instrutores.get(i).getId());
					if (image.exists() && image.isFile()) {
			%>
			<img
				src="<%=System.getProperty("user.home") + "/fotos/instrutores/" + instrutores.get(i).getId()%>"
				class="card-img-top" alt="...">
			<%
				} else {
			%>
			<img  src='<%=request.getContextPath() + "/assets/images/teacher2.jpg"%>' class="card-img-top" alt="...">
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
				</div>
			</div>
		</div>
		<%
			}
		%>

	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>