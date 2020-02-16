<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="model.AlunosDAO, utils.Alunos, java.util.ArrayList, java.io.File"%>
<%
	out.print(session.getAttribute("userId"));
	AlunosDAO alunosDAO = new AlunosDAO();
	Alunos aluno = alunosDAO.getAlunoPorID((int) session.getAttribute("userId"));
%>

<jsp:include page="../header.jsp"></jsp:include>
<div class="container container-tables">
	<div class="principal-title">
		<h1 class="welcome">Forms</h1>
		<p>Lorem Ipsum is simply dummy text of the printing and
			typesetting industry.Lorem Ipsum is simply dummy text of the printing
			and typesetting industry.</p>
		<p>* Required fields</p>
		<a href="./turmas.jsp" class="btn btn-primary">Histórico</a>
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
	<form method="post" action="/App/admin/aluno/edit"
		class="needs-validation" novalidate id="studant-form">
		<div class="form-group">
			<label for="exampleInputEmail1">Cpf*</label> <input pattern=".{11}"
				type="text" class="form-control" id="studant-form" name="cpf"
				aria-describedby="emailHelp" value="<%=aluno.getCpf()%>" required>
			<div class="invalid-feedback">Please digit student's cpf, min
				length 3.</div>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Name*</label> <input
				pattern=".{3,}" type="text" class="form-control" name="nome"
				id="studant-name" required value="<%=aluno.getNome()%>">
			<div class="invalid-feedback">Please digit student's name, min
				length 3.</div>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">E-mail*</label> <input
				type="email" class="form-control" id="studant-email" name="email"
				value="<%=aluno.getEmail()%>" required>
			<div class="invalid-feedback">Please digit student's email.</div>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Phone*</label> <input
				pattern=".{3,}" type="text" class="form-control" id="studant-phone"
				name="celular" value="<%=aluno.getCelular()%>" required>
			<div class="invalid-feedback">Please digit student's phone, min
				length 3.</div>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Login*</label> <input
				pattern=".{3,}" type="text" class="form-control" name="login"
				value="<%=aluno.getLogin()%>" id="studant-login" required>
			<div class="invalid-feedback">Please digit student's login, min
				length 3.</div>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Password*</label> <input
				pattern=".{8,}" type="password" name="senha"
				value="<%=aluno.getSenha()%>" class="form-control"
				id="studant-password" required>
			<div class="invalid-feedback">Please digit student's password,
				min length 8.</div>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Address*</label> <input
				pattern=".{3,}" type="text" class="form-control" name="endereco"
				value='<%=aluno.getEndereco() == null ? "" : aluno.getEndereco()%>'
				id="studant-studant-address" required>
			<div class="invalid-feedback">Please digit student's address,
				min length 3.</div>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">City*</label> <input
				pattern=".{3,}" type="text" class="form-control" name="cidade"
				value='<%=aluno.getCidade() == null ? "" : aluno.getCidade()%>'
				id="studant-city" required>
			<div class="invalid-feedback">Please digit student's city, min
				length 3.</div>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Neighborhood*</label> <input
				pattern=".{3,}" type="text" name="bairro"
				value='<%=aluno.getBairro() == null ? "" : aluno.getBairro()%>'
				class="form-control" id="studant-neighborhood" required>
			<div class="invalid-feedback">Please digit student's
				neighborhood, min length 3.</div>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">CEP*</label> <input
				pattern=".{3,}" type="text" class="form-control" name="cep"
				value='<%=aluno.getCep() == null ? "" : aluno.getCep()%>'
				id="studant-cep" required>
			<div class="invalid-feedback">Please digit student's cep, min
				length 3.</div>
		</div>
		<input type="hidden" name="id" value="<%=aluno.getId()%>" />
		<button type="submit" class="btn btn-success btn-account">Send</button>

	</form>
</div>
<jsp:include page="../footer.jsp"></jsp:include>