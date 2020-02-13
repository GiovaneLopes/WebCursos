<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />
<div class="container container-signin">
	<div class="principal-title">
		<h1 class="welcome">Sign in!</h1>
	</div>
	<div class="courses-cards">
		<form method="post" action="login" class="needs-validation" novalidate id="signinForm">
			<div class="form-group">
				<label for="exampleInputEmail1">Email address</label> <input
					type="email" class="form-control" id="exampleInputEmail1" name="email"
					aria-describedby="emailHelp" required>
				<div class="invalid-feedback">Please digit your e-mail.</div>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					pattern=".{8,}" type="password" class="form-control" name="senha"
					id="exampleInputPassword1" required>
				<div class="invalid-feedback">Please digit your password.</div>
			</div>
			<label for="selectTipo">Select type of account</label>
			<select id="selectTipo" name="tipoUser" class="custom-select">
				<option selected value="1">Student</option>
				<option value="2">Teacher</option>
				<option value="3">Administrator</option>
			</select>
			<button type="submit" class="btn btn-success btn-account">Sign in</button>
		</form>
	</div>
</div>
<jsp:include page="footer.jsp" />
