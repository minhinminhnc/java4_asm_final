<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container text-center">
	<h1>REGISTRATION</h1>
	<form action="user-edit" method="post">
		<div class="row">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">EMAIL?
				</label> <input name="email" type="text" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="${u.email }">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">PASSWORD?</label>
				<input name="password" type="password" class="form-control"
					id="exampleInputPassword1" placeholder="${u.password }">
			</div>
		</div>

		<div class="row">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">FULLNAME?
				</label> <input name="fullname" type="text" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="${u.fullname }">
			</div>
		</div>
		<div>
			${message }
		</div>
		<button type="submit" class="btn btn-danger" ${button } name="id" value="${u.id }">Update</button>
		<a href="delete?id=${u.id }" class="btn btn-danger ${button }">Delete</a>
	</form>
	<br>
	<jsp:include page="user_list.jsp"></jsp:include>
</div>