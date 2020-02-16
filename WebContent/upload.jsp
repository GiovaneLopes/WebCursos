<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>
<div class="container container-signin">
	<div class="principal-title">
		<h1 class="welcome">Upload image!</h1>
		<p>Lorem Ipsum is simply dummy text of the printing and
			typesetting industry.Lorem Ipsum is simply dummy text of the printing
			and typesetting industry.</p>
	</div>
	<div class="courses-cards">
		<form method="post" action="/App/aluno/upload" enctype="multipart/form-data"
			class="needs-validation" novalidate id="signinForm">
			<div class="form-group">
				<label for="exampleInputEmail1">Select file to upload:</label> <input
					type="file" name="file" size="60" /><br />
				<div class="invalid-feedback">Please select a valid image.</div>
			</div>
			<button type="submit" class="btn btn-success btn-account">Upload</button>
		</form>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>