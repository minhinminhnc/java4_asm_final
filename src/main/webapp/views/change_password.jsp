<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="container text-center">
	<h1>CHANGE PASSWORD</h1>
	<form action="change-password" method="post">
		<div class="row">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">USERNAME?
				</label> <input type="email" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" readonly placeholder="${sessionScope.user.email }">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">CURRENT
					PASSWORD?</label> <input name="cp" type="password" class="form-control"
					id="exampleInputPassword1">
			</div>
		</div>

		<div class="row">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">NEW
					PASSWORD? </label> <input name="np" type="password" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">CONFIRM
					NEW PASSWORD ?</label> <input name="cnp" type="password" class="form-control"
					id="exampleInputPassword1">
			</div>
		</div>
		<div>${message }</div>
		<button class="btn btn-primary">Change</button>
	</form>
</div>