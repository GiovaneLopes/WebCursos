<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"/>
<div class="container container-tables">
	<div class="principal-title">
		<h1 class="welcome">Forms</h1>
		<p>Lorem Ipsum is simply dummy text of the printing and
			typesetting industry.Lorem Ipsum is simply dummy text of the printing
			and typesetting industry.</p>
		<p>* Required fields</p>
	</div>
	<div class="courses-cards">
		<div class="accordion" id="accordionExample">
			<div class="card">
				<div class="card-header" id="headingOne">
					<h2 class="mb-0">
						<button class="btn btn-link" type="button" data-toggle="collapse"
							data-target="#collapseOne" aria-expanded="true"
							aria-controls="collapseOne">Courses</button>
					</h2>
				</div>

				<div id="collapseOne" class="collapse" aria-labelledby="headingOne"
					data-parent="#accordionExample">
					<div class="card-body">
						<div class="courses-cards acordion-form">
							<form class="needs-validation" novalidate id="course-form">
								<div class="form-group">
									<label for="exampleInputEmail1">Name*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										id="course-name" aria-describedby="emailHelp" required>
									<div class="invalid-feedback">Please digit course's name,
										min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Requirement*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										id="course-requirement" required>
									<div class="invalid-feedback">Please digit course's
										requirement, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Menu*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										id="course-menu" required>
									<div class="invalid-feedback">Please digit course's menu,
										min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Workload*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										id="course-workload" required>
									<div class="invalid-feedback">Please digit course's
										workload, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Price*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										id="course-price" required>
									<div class="invalid-feedback">Please digit course's
										price, min length 3.</div>
								</div>
								<button type="submit" class="btn btn-success btn-account">Send</button>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header" id="headingTwo">
					<h2 class="mb-0">
						<button class="btn btn-link collapsed" type="button"
							data-toggle="collapse" data-target="#collapseTwo"
							aria-expanded="false" aria-controls="collapseTwo">
							Teachers</button>
					</h2>
				</div>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionExample">
					<div class="card-body">
						<div class="courses-cards acordion-form">
							<form class="needs-validation" novalidate id="teacher-form">
								<div class="form-group">
									<label for="exampleInputEmail1">Name*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										id="teacher-name" aria-describedby="emailHelp" required>
									<div class="invalid-feedback">Please digit teacher's
										name, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">E-mail*</label> <input
										type="email" class="form-control" id="teacher-email" required>
									<div class="invalid-feedback">Please digit teacher's
										email.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Salary*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										id="teacher-salary" required>
									<div class="invalid-feedback">Please digit teacher's
										salary, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Login*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										id="teacher-login" required>
									<div class="invalid-feedback">Please digit teacher's
										login, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Password*</label> <input
										pattern=".{8,}" type="password" class="form-control"
										id="teacher-password" required>
									<div class="invalid-feedback">Please digit teacher's
										password, min length 8.</div>
								</div>
								<button type="submit" class="btn btn-success btn-account">Send</button>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header" id="headingThree">
					<h2 class="mb-0">
						<button class="btn btn-link collapsed" type="button"
							data-toggle="collapse" data-target="#collapseThree"
							aria-expanded="false" aria-controls="collapseThree">
							Registration</button>
					</h2>
				</div>
				<div id="collapseThree" class="collapse"
					aria-labelledby="headingThree" data-parent="#accordionExample">
					<div class="card-body">
						<div class="courses-cards acordion-form">
							<form class="needs-validation" novalidate id="registration-form">
								<div class="form-group">
									<label for="exampleInputEmail1">Registration Date*</label> <input
										type="date" class="form-control" id="registration-date"
										aria-describedby="emailHelp" required>
									<div class="invalid-feedback">Please digit registration's
										start date.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Test Score*</label> <input
										type="text" class="form-control" id="registration-score"
										required>
									<div class="invalid-feedback">Please digit registration's
										test score.</div>
								</div>
								<button type="submit" class="btn btn-success btn-account">Send</button>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header" id="headingFour">
					<h2 class="mb-0">
						<button class="btn btn-link collapsed" type="button"
							data-toggle="collapse" data-target="#collapseFour"
							aria-expanded="false" aria-controls="collapseFour">
							Class</button>
					</h2>
				</div>
				<div id="collapseFour" class="collapse"
					aria-labelledby="headingFour" data-parent="#accordionExample">
					<div class="card-body">
						<div class="courses-cards acordion-form">
							<form class="needs-validation" novalidate id="class-form">
								<div class="form-group">
									<label for="exampleInputEmail1">Start Date*</label> <input
										type="date" class="form-control" id="class-start"
										aria-describedby="emailHelp" required>
									<div class="invalid-feedback">Please digit class's start
										date.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">End Date*</label> <input
										type="date" class="form-control" id="class-end" required>
									<div class="invalid-feedback">Please digit class's end
										date.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Workload*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										id="class-worload" required>
									<div class="invalid-feedback">Please digit class's
										workload, min length 3.</div>
								</div>
								<button type="submit" class="btn btn-success btn-account">Send</button>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header" id="headingFive">
					<h2 class="mb-0">
						<button class="btn btn-link collapsed" type="button"
							data-toggle="collapse" data-target="#collapseFive"
							aria-expanded="false" aria-controls="collapseFive">
							Administrator</button>
					</h2>
				</div>
				<div id="collapseFive" class="collapse"
					aria-labelledby="headingFive" data-parent="#accordionExample">
					<div class="card-body">
						<div class="courses-cards acordion-form">
							<form class="needs-validation" novalidate id="administrator-form">
								<div class="form-group">
									<label for="exampleInputEmail1">Name*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										id="administrator-name" aria-describedby="emailHelp" required>
									<div class="invalid-feedback">Please digit
										administrator's name, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Login*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										id="administrator-login" required>
									<div class="invalid-feedback">Please digit
										administrator's login, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Password*</label> <input
										pattern=".{8,}" type="password" class="form-control"
										id="administrator-password" required>
									<div class="invalid-feedback">Please digit
										administrator's password, min length 8.</div>
								</div>
								<button type="submit" class="btn btn-success btn-account">Send</button>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header" id="headingSix">
					<h2 class="mb-0">
						<button class="btn btn-link collapsed" type="button"
							data-toggle="collapse" data-target="#collapseSix"
							aria-expanded="false" aria-controls="collapseSix">
							Students</button>
					</h2>
				</div>
				<div id="collapseSix" class="collapse" aria-labelledby="headingSix"
					data-parent="#accordionExample">
					<div class="card-body">
						<div class="courses-cards acordion-form">
							<form class="needs-validation" novalidate id="studant-form">
								<div class="form-group">
									<label for="exampleInputEmail1">Cpf*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										id="studant-form" aria-describedby="emailHelp" required>
									<div class="invalid-feedback">Please digit student's cpf,
										min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Name*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										id="studant-name" required>
									<div class="invalid-feedback">Please digit student's
										name, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">E-mail*</label> <input
										type="email" class="form-control" id="studant-email" required>
									<div class="invalid-feedback">Please digit student's
										email.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Phone*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										id="studant-phone" required>
									<div class="invalid-feedback">Please digit student's
										phone, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Login*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										id="studant-login" required>
									<div class="invalid-feedback">Please digit student's
										login, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Password*</label> <input
										pattern=".{8,}" type="password" class="form-control"
										id="studant-password" required>
									<div class="invalid-feedback">Please digit student's
										password, min length 8.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Address*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										id="studant-studant-address" required>
									<div class="invalid-feedback">Please digit student's
										address, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">City*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										id="studant-city" required>
									<div class="invalid-feedback">Please digit student's
										city, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Neighborhood*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										id="studant-neighborhood" required>
									<div class="invalid-feedback">Please digit student's
										neighborhood, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">CEP*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										id="studant-cep" required>
									<div class="invalid-feedback">Please digit student's cep,
										min length 3.</div>
								</div>
								<button type="submit" class="btn btn-success btn-account">Send</button>

							</form>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp"/>
