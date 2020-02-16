<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="utils.Instrutores, utils.Cursos"%>
<%
	Object objetoToUpdate = request.getAttribute("objetoToUpdate");
	Instrutores instrutor = null;
	Cursos curso = null;
	if (objetoToUpdate instanceof Instrutores) {
		instrutor = (Instrutores) objetoToUpdate;
		out.print(instrutor);
		out.print(instrutor.getId());
		if (instrutor.getId() == 0) {
			response.sendRedirect("/App/index.jsp");
		}
	} else if (objetoToUpdate instanceof Cursos) {
		curso = (Cursos) objetoToUpdate;
		if (curso.getId() == 0) {
			response.sendRedirect("/App/index.jsp");
		}
	} else {
		response.sendRedirect("/App/index.jsp");
	}
%>
<jsp:include page="../header.jsp"></jsp:include>
<%
	if (instrutor != null) {
%>
<div class="container container-signin">
	<div class="principal-title">
		<h1 class="welcome">Upload image!</h1>
		<p>Lorem Ipsum is simply dummy text of the printing and
			typesetting industry.Lorem Ipsum is simply dummy text of the printing
			and typesetting industry.</p>
	</div>
	<div class="courses-cards">
		<form method="post" action="/App/admin/upload"
			enctype="multipart/form-data" class="needs-validation" novalidate
			id="signinForm">
			<div class="form-group">
				<label for="exampleInputEmail1">Select file to upload:</label> <input
					type="file" name="file" size="60" /><br />
				<div class="invalid-feedback">Please select a valid image.</div>
			</div>
			<input type="hidden" name="id" value="<%= instrutor.getId() %>">
			<input type="hidden" name="classe" value="instrutores">
			<button type="submit" class="btn btn-success btn-account">Upload</button>
		</form>
	</div>
</div>
<%
	} else if (curso != null) {
%>
<
<div class="container container-signin">
	<div class="principal-title">
		<h1 class="welcome">Upload image!</h1>
		<p>Lorem Ipsum is simply dummy text of the printing and
			typesetting industry.Lorem Ipsum is simply dummy text of the printing
			and typesetting industry.</p>
	</div>
	<div class="courses-cards">
		<form method="post" action="/App/admin/upload"
			enctype="multipart/form-data" class="needs-validation" novalidate
			id="signinForm">
			<div class="form-group">
				<label for="exampleInputEmail1">Select file to upload:</label> <input
					type="file" name="file" size="60" /><br />
				<div class="invalid-feedback">Please select a valid image.</div>
			</div>
			<input type="hidden" name="id" value="<%= curso.getId() %>">
			<input type="hidden" name="classe" value="cursos">
			<button type="submit" class="btn btn-success btn-account">Upload</button>
		</form>
	</div>
</div>
<%
	}
%>
<jsp:include page="../footer.jsp"></jsp:include>
