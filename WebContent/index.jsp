<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>
<%@ page
	import="model.CursosDAO, utils.Cursos, java.util.ArrayList, java.io.File, java.util.Date"%>
<%
	CursosDAO cursosDAO = new CursosDAO();
	ArrayList<Cursos> cursos = cursosDAO.getLista();
%>

<div class="container">
	<div class="principal-title">
		<h1 class="welcome">Welcome!</h1>
		<h2 class="our-courses">Our Courses</h2>
	</div>
	<div class="courses-cards">
		<%
			for (int i = 0; i < cursos.size(); i++) {
		%>
		<div class="card card-courses" style="width: 18rem;">
			<%
				File image = new File(
							System.getProperty("user.home") + "/fotos/instrutores/" + cursos.get(i).getId() + ".png");
					if (image.exists() && image.isFile()) {
			%>
			<img
				src='<%=System.getProperty("user.home") + "/fotos/instrutores/" + cursos.get(i).getId() + ".png"%>'
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
			<div class="card-body card-body-courses">
				<h5 class="card-title course-title"><%= cursos.get(i).getNome() %></h5>
				<p class="course-title p-title"><%= cursos.get(i).getPreco() %></p>
				<a href="#" class="btn btn-success"><i
					class="fas fa-dollar-sign"></i> Buy</a>
			</div>
		</div>
		<%
			}
		%>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>