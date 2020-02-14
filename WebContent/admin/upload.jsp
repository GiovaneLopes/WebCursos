<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="utils.Instrutores, utils.Cursos"%>	
<%
Object objetoToUpdate = request.getAttribute("objetoToUpdate");
Instrutores instrutor = null;
Cursos curso = null;
if(objetoToUpdate instanceof Instrutores){
	instrutor = (Instrutores) objetoToUpdate;
	if(instrutor.getId() == 0){
		response.sendRedirect("/App/index.jsp");
	}
} else if(objetoToUpdate instanceof Cursos){
	curso = (Cursos) objetoToUpdate;
	if(curso.getId() == 0) {
		response.sendRedirect("/App/index.jsp");	
	}
} else {
	response.sendRedirect("/App/index.jsp");
}
%>
<jsp:include page="../header.jsp"></jsp:include>
<% if(instrutor != null) {%>
<div class="card">
	<div class="card-header" id="headingTwo">
		<h2 class="mb-0">
			<button class="btn btn-link collapsed" type="button"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="false" aria-controls="collapseTwo">Teacher's
				image</button>
		</h2>
	</div>
	<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
		data-parent="#accordionExample">
		<div class="card-body">
			<div class="courses-cards acordion-form">
				<form method="post" action="/App/admin/upload" enctype="multipart/form-data"
					class="needs-validation" novalidate id="signinForm">
					<div class="form-group">
						<label for="exampleInputEmail1">Select file to upload:</label> <input
							type="file" name="file" size="60" /><br />
						<div class="invalid-feedback">Please select a valid image.</div>
					</div>
					<input type="hidden" name="id" value="<%= instrutor.getId() %>">
					<input type="hidden" name="classe" value="instrutores">
					<button type="submit" class="btn btn-success btn-account">Upload
						image</button>
				</form>
			</div>
		</div>
	</div>
</div>
<% } else if(curso != null) { %>
<div class="card">
	<div class="card-header" id="headingTwo">
		<h2 class="mb-0">
			<button class="btn btn-link collapsed" type="button"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="false" aria-controls="collapseTwo">Curso's
				image</button>
		</h2>
	</div>
	<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
		data-parent="#accordionExample">
		<div class="card-body">
			<div class="courses-cards acordion-form">
				<form method="post" action="/App/admin/upload" enctype="multipart/form-data"
					class="needs-validation" novalidate id="signinForm">
					<div class="form-group">
						<label for="exampleInputEmail1">Select file to upload:</label> <input
							type="file" name="file" size="60" /><br />
						<div class="invalid-feedback">Please select a valid image.</div>
					</div>
					<input type="hidden" name="id" value="<%= curso.getId() %>">
					<input type="hidden" name="classe" value="cursos">
					<button type="submit" class="btn btn-success btn-account">Upload
						image</button>
				</form>
			</div>
		</div>
	</div>
</div>
<% } %>
<jsp:include page="../footer.jsp"></jsp:include>
