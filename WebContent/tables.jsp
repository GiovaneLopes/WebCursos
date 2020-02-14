<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ page import="model.*, utils.*, java.util.ArrayList"%>
<%
	Object objetoToUpdate = request.getAttribute("objetoToUpdate");
	Instrutores instrutor = null;
	Alunos aluno = null;
	Turmas turma = null;
	Matriculas matricula = null;
	Cursos curso = null;
	if (objetoToUpdate instanceof Alunos) {
		aluno = (Alunos) objetoToUpdate;
	} else if (objetoToUpdate instanceof Instrutores) {
		instrutor = (Instrutores) objetoToUpdate;
	} else if (objetoToUpdate instanceof Cursos) {
		curso = (Cursos) objetoToUpdate;
	} else if (objetoToUpdate instanceof Turmas) {
		turma = (Turmas) objetoToUpdate;
	} else if (objetoToUpdate instanceof Matriculas) {
		matricula = (Matriculas) objetoToUpdate;
	}
	InstrutoresDAO instrutoresDAO = new InstrutoresDAO();
	ArrayList<Instrutores> instrutores = instrutoresDAO.getLista();
	CursosDAO cursosDAO = new CursosDAO();
	ArrayList<Cursos> cursos = cursosDAO.getLista();
%>
<jsp:include page="header.jsp" />
<div class="container container-tables">
	<div class="principal-title">
		<h1 class="welcome">Forms</h1>
		<p>Lorem Ipsum is simply dummy text of the printing and
			typesetting industry.Lorem Ipsum is simply dummy text of the printing
			and typesetting industry.</p>
		<p>* Required fields</p>
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
	<%
		if (aluno != null) {
	%>
	<form method="post" action="/App/admin/aluno/edit" class="needs-validation"
		novalidate id="studant-form">
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
	<%
		} else if (instrutor != null) {
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
				value="<%=instrutor.getValor_hora()%>" name="valor_hora" id="teacher-salary" required>
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
	<%
		} else if (curso != null) {
	%>
	<form method="post" action="/App/admin/curso/edit" class="needs-validation"
		novalidate id="course-form">
		<div class="form-group">
			<label for="exampleInputEmail1">Name*</label> <input pattern=".{3,}"
				type="text" class="form-control" name="nome"
				value="<%=curso.getNome()%>" name="nome" id="course-name"
				aria-describedby="emailHelp" required>
			<div class="invalid-feedback">Please digit course's name, min
				length 3.</div>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Requirement*</label> <input
				name="requisito" pattern=".{3,}" type="text" name="requisito"
				value="<%=curso.getRequisito()%>" class="form-control"
				id="course-requirement" required>
			<div class="invalid-feedback">Please digit course's
				requirement, min length 3.</div>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Menu*</label> <input
				pattern=".{3,}" type="text" name="ementa"
				value="<%=curso.getEmenta()%>" class="form-control"
				id="course-menu" required>
			<div class="invalid-feedback">Please digit course's menu, min
				length 3.</div>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Workload*</label> <input
				pattern=".{3,}" type="text" class="form-control"
				name="carga_horaria" value="<%=curso.getCarga_horaria()%>"
				id="course-workload" required>
			<div class="invalid-feedback">Please digit course's workload,
				min length 3.</div>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Price*</label> <input
				pattern=".{3,}" type="text" class="form-control" name="preco"
				value="<%=curso.getPreco()%>" id="course-price" required>
			<div class="invalid-feedback">Please digit course's price, min
				length 3.</div>
		</div>
		<input type="hidden" name="id" value="<%=curso.getId()%>" />
		<button type="submit" class="btn btn-success btn-account">Send</button>
	</form>
	<%
		} else if (turma != null) {
	%>
	<form method="post" action="/App/admin/turma/edit" class="needs-validation"
		novalidate id="class-form">
		<label for="instrutorTurma">Select instructor*</label> <select
			id="instrutorTurma" name="instrutor_id" class="custom-select">
			<%
				for (int i = 0; i < instrutores.size(); i++) {
			%>
			<%
				if (instrutores.get(i).getId() == turma.getInstrutores_id()) {
			%>
			<option selected value=<%=instrutores.get(i).getId()%>><%=instrutores.get(i).getNome()%></option>
			<%
				} else {
			%>
			<option value=<%=instrutores.get(i).getId()%>><%=instrutores.get(i).getNome()%></option>
			<%
				}
					}
			%>
		</select> <label for="courseTurma">Select course*</label> <select
			id="courseTurma" name="course_id" class="custom-select">
			<%
				for (int i = 0; i < cursos.size(); i++) {
			%>
			<%
				if (cursos.get(i).getId() == turma.getCursos_id()) {
			%>
			<option selected value=<%=cursos.get(i).getId()%>><%=cursos.get(i).getNome()%></option>
			<%
				} else {
			%>
			<option value=<%=cursos.get(i).getId()%>><%=cursos.get(i).getNome()%></option>
			<%
				}
					}
			%>
		</select>
		<div class="form-group">
			<label for="exampleInputEmail1">Start Date*</label> <input
				type="date" class="form-control" id="class-start"
				value="<%=turma.getData_inicio()%>" name="data_inicio"
				aria-describedby="emailHelp" required>
			<div class="invalid-feedback">Please digit class's start date.</div>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">End Date*</label> <input
				name="data_final" type="date" value="<%=turma.getData_final()%>"
				class="form-control" id="class-end" required>
			<div class="invalid-feedback">Please digit class's end date.</div>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Workload*</label> <input
				name="carga_horaria" pattern=".{3,}" type="text"
				value="<%=turma.getCarga_horaria()%>" class="form-control"
				id="class-worload" required>
			<div class="invalid-feedback">Please digit class's workload,
				min length 3.</div>
		</div>
		<input type="hidden" name="id" value="<%=turma.getId()%>" />
		<button type="submit" class="btn btn-success btn-account">Send</button>
	</form>
	<%
		} else {
	%>
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
							<form method="post" action="/App/admin/curso" class="needs-validation"
								novalidate id="course-form">
								<div class="form-group">
									<label for="exampleInputEmail1">Name*</label> <input
										pattern=".{3,}" type="text" class="form-control" name="nome"
										id="course-name" aria-describedby="emailHelp" required>
									<div class="invalid-feedback">Please digit course's name,
										min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Requirement*</label> <input
										name="requisito" pattern=".{3,}" type="text"
										class="form-control" id="course-requirement" required>
									<div class="invalid-feedback">Please digit course's
										requirement, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Menu*</label> <input
										name="ementa" pattern=".{3,}" type="text" class="form-control"
										id="course-menu" required>
									<div class="invalid-feedback">Please digit course's menu,
										min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Workload*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										name="carga_horaria" id="course-workload" required>
									<div class="invalid-feedback">Please digit course's
										workload, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Price*</label> <input
										pattern=".{3,}" type="text" class="form-control" name="preco"
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
							<form method="post" action="/App/admin/instrutor"
								class="needs-validation" novalidate id="teacher-form">
								<div class="form-group">
									<label for="exampleInputEmail1">Name*</label> <input
										pattern=".{3,}" type="text" class="form-control" name="nome"
										id="teacher-name" aria-describedby="emailHelp" required>
									<div class="invalid-feedback">Please digit teacher's
										name, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">E-mail*</label> <input
										name="email" type="email" class="form-control"
										id="teacher-email" required>
									<div class="invalid-feedback">Please digit teacher's
										email.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Salary*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										name="valor_hora" id="teacher-salary" required>
									<div class="invalid-feedback">Please digit teacher's
										salary, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Login*</label> <input
										pattern=".{3,}" type="text" class="form-control" name="login"
										id="teacher-login" required>
									<div class="invalid-feedback">Please digit teacher's
										login, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Password*</label> <input
										name="senha" pattern=".{8,}" type="password"
										class="form-control" id="teacher-password" required>
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
							<form method="post" action="/App/admin/turma" class="needs-validation"
								novalidate id="class-form">
								<label for="instrutorTurma">Select instructor*</label> <select
									id="instrutorTurma" name="instrutores_id" class="custom-select">
									<%
										for (int i = 0; i < instrutores.size(); i++) {
									%>
									<option value=<%=instrutores.get(i).getId()%>><%=instrutores.get(i).getNome()%>
									</option>
									<%
										}
									%>
								</select> <label for="courseTurma">Select course*</label> <select
									id="courseTurma" name="cursos_id" class="custom-select">
									<%
										for (int i = 0; i < cursos.size(); i++) {
									%>
									<option value=<%=cursos.get(i).getId()%>><%=cursos.get(i).getNome()%></option>
									<%
										}
									%>
								</select>
								<div class="form-group">
									<label for="exampleInputEmail1">Start Date*</label> <input
										type="date" class="form-control" id="class-start"
										name="data_inicio" aria-describedby="emailHelp" required>
									<div class="invalid-feedback">Please digit class's start
										date.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">End Date*</label> <input
										name="data_final" type="date" class="form-control"
										id="class-end" required>
									<div class="invalid-feedback">Please digit class's end
										date.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Workload*</label> <input
										name="carga_horaria" pattern=".{3,}" type="text"
										class="form-control" id="class-worload" required>
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
							<form method="post" action="/App/admin/alunos" class="needs-validation"
								novalidate id="studant-form">
								<div class="form-group">
									<label for="exampleInputEmail1">Cpf*</label> <input
										pattern=".{3,}" type="text" class="form-control" name="cpf"
										id="studant-form" aria-describedby="emailHelp" required>
									<div class="invalid-feedback">Please digit student's cpf,
										min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Name*</label> <input
										pattern=".{3,}" type="text" class="form-control" name="nome"
										id="studant-name" required>
									<div class="invalid-feedback">Please digit student's
										name, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">E-mail*</label> <input
										type="email" class="form-control" name="email"
										id="studant-email" required>
									<div class="invalid-feedback">Please digit student's
										email.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Phone*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										name="celular" id="studant-phone" required>
									<div class="invalid-feedback">Please digit student's
										phone, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Login*</label> <input
										pattern=".{3,}" type="text" class="form-control" name="login"
										id="studant-login" required>
									<div class="invalid-feedback">Please digit student's
										login, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Password*</label> <input
										pattern=".{8,}" type="password" name="senha"
										class="form-control" id="studant-password" required>
									<div class="invalid-feedback">Please digit student's
										password, min length 8.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Address*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										name="endereco" id="studant-studant-address" required>
									<div class="invalid-feedback">Please digit student's
										address, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">City*</label> <input
										pattern=".{3,}" type="text" class="form-control"
										id="studant-city" name="cidade" required>
									<div class="invalid-feedback">Please digit student's
										city, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Neighborhood*</label> <input
										pattern=".{3,}" name="bairro" type="text" class="form-control"
										id="studant-neighborhood" required>
									<div class="invalid-feedback">Please digit student's
										neighborhood, min length 3.</div>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">CEP*</label> <input
										pattern=".{3,}" type="text" name="cep" class="form-control"
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
	<%
		}
	%>

</div>

<jsp:include page="footer.jsp" />