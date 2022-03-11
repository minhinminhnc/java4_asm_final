<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container text-center">
	<h1>EDIT PROFILE</h1>
	<form action="edit-profile" method="post">
		<div class="row">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">EMAIL ADDRESS?
				</label> <input type="email" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="${sessionScope.user.email }" readonly>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">
					FULL NAME?</label> <input name="fullname" type="text" class="form-control"
					placeholder="${sessionScope.user.fullname }">
			</div>
		</div>
		<div>
			${message }
		</div>
		<button type="submit" class="btn btn-primary">Update</button>
	</form>
</div>