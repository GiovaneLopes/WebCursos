<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	int tipoUser = (int) session.getAttribute("tipoUser");
%>
<!-- DOCTYPE html> -->
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- FontAwesome -->
<link rel="stylesheet" href="assets/fontawesome/css/all.css">

<!-- Css -->
<link rel="stylesheet" href="assets/css/style.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="assets/css/bootstrap.css">

<title>WebCursos - Sign on</title>
<script>
	// Example starter JavaScript for disabling form submissions if there are invalid fields
	(function() {
		'use strict';
		window.addEventListener('load', function() {
			// Fetch all the forms we want to apply custom Bootstrap validation styles to
			var forms = document.getElementsByClassName('needs-validation');
			// Loop over them and prevent submission
			var validation = Array.prototype.filter.call(forms, function(form) {
				form.addEventListener('submit', function(event) {
					if (form.checkValidity() === false) {
						event.preventDefault();
						event.stopPropagation();
					}
					form.classList.add('was-validated');
				}, false);
			});
		}, false);
	})();
</script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark principalMenu">
		<a class="navbar-brand" href="#">WebCursos</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="index.jsp"><i
						class="fas fa-home"></i> Home </a></li>
				<li class="nav-item"><a class="nav-link" href="about.jsp"><i
						class="far fa-building"></i> About</a></li>
				<li class="nav-item"><a class="nav-link" href="comments.jsp"><i
						class="far fa-comment"></i> Comments </a></li>
				<li class="nav-item"><a class="nav-link" href="teachers.jsp"><i
						class="fas fa-graduation-cap"></i> Teachers</a></li>
				<%
					if (tipoUser == 1) {
				%>
				<%
					} else if (tipoUser == 2) {
				%>
				<%
					} else if (tipoUser == 3) {
				%>
				<li class="nav-item"><a class="nav-link" href="tables.jsp"><i
						class="fas fa-table"></i> Tables </a></li>
				<%
					} else {
				%>
				<li class="nav-item"><a class="nav-link " href="register.jsp"><i
						class="far fa-user-circle"></i> Register </a></li>
				<li class="nav-item"><a class="nav-link" href="signin.jsp"><i
						class="far fa-user"></i> Sign in</a></li>
				<%
					}
				%>
			</ul>
		</div>
	</nav>