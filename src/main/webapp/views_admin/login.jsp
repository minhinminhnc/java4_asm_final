<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container">
	<form action="admin" method="post">
		<h1>LOGIN</h1>
		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label"> USERNAME?</label>
			<input name="email" type="email" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp">
			<div id="emailHelp" class="form-text">We'll never share your
				email with anyone else.</div>
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">PASSWORD</label>
			<input name="password" type="password" class="form-control"
				id="exampleInputPassword1">
		</div>
		<div class="mb-3 form-check">
			<input name="remember" type="checkbox" class="form-check-input" id="exampleCheck1">
			<label class="form-check-label" for="exampleCheck1">REMEMBER
				ME?</label>
		</div>
		<label>${message }</label><br>
		<button class="btn btn-primary">LOGIN</button>
	</form>
</div>