<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"/>
<div class="container container-register">
	<div class="principal-title">
		<h1 class="welcome">Sign up!</h1>
		<p>Lorem Ipsum is simply dummy text of the printing and
			typesetting industry.Lorem Ipsum is simply dummy text of the printing
			and typesetting industry.</p>
	</div>
	<% 
		if(request.getAttribute("resultadoReq") != null) {
			if((boolean)request.getAttribute("resultadoReq") == true){
				out.print("<div class='alert alert-success' role='alert'>Usuário cadastrado com sucesso!</div>");
			} else{
				out.print("<div class='alert alert-danger' role='alert'>Erro ao cadastrar usuário!</div>");
			}
		}
		%>
	<div class="courses-cards">
		<form method="post" action="aluno" class="needs-validation" novalidate>
			<div class="form-group">
				<label for="exampleInputName1">Name</label> 
				<input pattern=".{3,}" name="nome" type="text" class="form-control" id="exampleInputName1" aria-describedby="emailHelp" required>
				<div class="invalid-feedback">Please digit your name, min length 3.</div>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Email address</label> <input
					type="email" name="email"  class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" required>
				<div class="invalid-feedback">Please digit your e-mail.</div>
			</div>
			<div class="form-group">
				<label for="exampleInputLogin">Login</label> <input
					type="text" name="login"  class="form-control" id="exampleInputLogin"
					aria-describedby="emailHelp" required>
				<div class="invalid-feedback">Please digit your login.</div>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					pattern=".{8,}" type="password" name="senha"  class="form-control"
					id="exampleInputPassword1" required>
				<div class="invalid-feedback">Please digit your password, min
					length 8.</div>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Confirm Password</label> <input
					pattern=".{8,}" type="password" class="form-control"
					id="exampleInputPassword1" required>
				<div class="invalid-feedback">Please confirm your password,
					min length 8.</div>
			</div>
			<div class="form-group">
				<label for="exampleInputCpf">CPF</label> <input
					pattern=".{11}" name="cpf" type="text" class="form-control"
					id="exampleInputCpf" required>
				<div class="invalid-feedback">Please digit your CPF,
					min length 11.</div>
			</div>
			<div class="form-group">
				<label for="exampleInputCelular">Celular</label> <input
					pattern=".{8,}" name="celular" type="text" class="form-control"
					id="exampleInputCelular" required>
				<div class="invalid-feedback">Please digit your Celular,
					min length 8.</div>
			</div>
			<div class="form-group">
				<label for="exampleInputEndereco">Endereco</label> <input
					name="endereco" type="text" class="form-control"
					id="exampleInputEndereco">
				<div class="invalid-feedback">Please digit your Endereco.</div>
			</div>
			<div class="form-group">
				<label for="exampleInputCidade">Cidade</label> <input
					name="cidade" type="text" class="form-control"
					id="exampleInputCidade">
				<div class="invalid-feedback">Please digit your Cidade.</div>
			</div>
			<div class="form-group">
				<label for="exampleInputBairro">Bairro</label> <input
					name="bairro" type="text" class="form-control"
					id="exampleInputBairro">
				<div class="invalid-feedback">Please digit your Bairro.</div>
			</div>
			<div class="form-group">
				<label for="exampleInputCEP">CEP</label> <input
					name="cep" type="text" class="form-control"
					pattern=".{8}" id="exampleInputCEP">
				<div class="invalid-feedback">Please digit your CEP.</div>
			</div>
			<button type="submit" class="btn btn-success btn-account">Register</button>
		</form>
	</div>
</div>
<jsp:include page="footer.jsp"/>