<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>
<div class="card">
	<div class="card-header" id="headingTwo">
		<h2 class="mb-0">
			<button class="btn btn-link collapsed" type="button"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="false" aria-controls="collapseTwo">Teacher image</button>
		</h2>
	</div>
	<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
		data-parent="#accordionExample">
		<div class="card-body">
			<div class="courses-cards acordion-form">
				<form method="post" action="upload" enctype="multipart/form-data"
					class="needs-validation" novalidate id="signinForm">
					<div class="form-group">
						<label for="exampleInputEmail1">Select file to upload:</label> <input
							type="file" name="file" size="60" /><br />
						<div class="invalid-feedback">Please select a valid image.</div>
					</div>
					<button type="submit" class="btn btn-success btn-account">Upload image</button>
				</form>
			</div>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
