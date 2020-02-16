<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="model.InstrutoresDAO, utils.Instrutores, java.util.ArrayList, java.io.File"%>
<%
	InstrutoresDAO instrutoresDAO = new InstrutoresDAO();
	Instrutores instrutor = instrutoresDAO.getInstrutoresPorID((int) session.getAttribute("userId"));
%>
<jsp:include page="../header.jsp"></jsp:include>
<div class="container container-tables">
	<div class="principal-title">
		<h1 class="welcome">Forms</h1>
		<p>Lorem Ipsum is simply dummy text of the printing and
			typesetting industry.Lorem Ipsum is simply dummy text of the printing
			and typesetting industry.</p>
		<p>* Required fields</p>
		<a href="./turmas.jsp?id=<%= instrutor.getId() %>" class="btn btn-primary">Your classes</a>
	</div>
	<%
		if (request.getAttribute("resultadoReq") != null) {
			if ((boolean) request.getAttribute("resultadoReq") == true) {
				out.print("<div class='alert alert-success' role='alert'>Ação realizada com sucesso!</div>");
			} else {
				out.print("<div class='alert alert-danger' role='alert'>Erro ao realizar ação!</div>");
			}
		}
	%>
	<form method="post" action="/App/admin/instrutor/edit"
		class="needs-validation" novalidate id="teacher-form">
		<div class="form-group">
			<label for="exampleInputEmail1">Name*</label> <input pattern=".{3,}"
				type="text" class="form-control" name="nome"
				value="<%=instrutor.getNome()%>" name="nome" id="teacher-name"
				aria-describedby="emailHelp" required>
			<div class="invalid-feedback">Please digit teacher's name, min
				length 3.</div>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">E-mail*</label> <input
				name="email" type="email" class="form-control" name="email"
				value="<%=instrutor.getEmail()%>" id="teacher-email" required>
			<div class="invalid-feedback">Please digit teacher's email.</div>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Salary*</label> <input
				pattern=".{3,}" type="text" class="form-control"
				value="<%=instrutor.getValor_hora()%>" name="valor_hora"
				id="teacher-salary" required>
			<div class="invalid-feedback">Please digit teacher's salary,
				min length 3.</div>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Login*</label> <input
				pattern=".{3,}" type="text" class="form-control" name="login"
				value="<%=instrutor.getLogin()%>" name="login" id="teacher-login"
				required>
			<div class="invalid-feedback">Please digit teacher's login, min
				length 3.</div>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Password*</label> <input
				name="senha" pattern=".{8,}" type="password" name="senha"
				value="<%=instrutor.getSenha()%>" class="form-control"
				id="teacher-password" required>
			<div class="invalid-feedback">Please digit teacher's password,
				min length 8.</div>
		</div>
		<input type="hidden" name="id" value="<%=instrutor.getId()%>" />
		<button type="submit" class="btn btn-success btn-account">Send</button>
	</form>
</div>
<jsp:include page="../footer.jsp"></jsp:include>