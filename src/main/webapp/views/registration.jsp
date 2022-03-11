<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container text-center">
	<h1>REGISTRATION</h1>
	<form action="registration" method="post">
		<div class="row">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">EMAIL ADDRESS?
				</label> <input name="email" type="email" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">PASSWORD?</label>
				<input name="password" type="password" class="form-control"
					id="exampleInputPassword1">
			</div>
		</div>

		<div class="row">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">FULLNAME?
				</label> <input name="fullname" type="text" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp">
			</div>
		</div>
		<div>
			${message }
		</div>
		<button type="submit" class="btn btn-primary">Sign Up</button>
	</form>
</div>