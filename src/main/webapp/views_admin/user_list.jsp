<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<h1>USER LIST</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Email</th>
				<th scope="col">Password</th>
				<th scope="col">Fullname</th>
				<th scope="col">Role</th>
				<th scope="col">#</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="u" items="${user }">
				<tr>
					<th scope="row">${u.id }</th>
					<td>${u.email }</td>
					<td type="password">${u.password }</td>
					<td>${u.fullname }</td>
					<td>${u.admin }</td>
					<td><a class="btn btn-danger" href="user-edit?id=${u.id }">Edit</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="text-center">
		<button type="button" class="btn btn-danger">|<</button>
		<button type="button" class="btn btn-danger"><<</button>
		<button type="button" class="btn btn-danger">>></button>
		<button type="button" class="btn btn-danger">>|</button>
	</div>
</div>