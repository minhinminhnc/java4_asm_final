<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="container">
	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Youtube ID</th>
				<th scope="col">Video Title</th>
				<th scope="col">View Count</th>
				<th scope="col">Status</th>
				<th scope="col">#</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="video" items="${video }">
				<tr>
					<th scope="row">${video.id }</th>
					<td>${video.url }</td>
					<td>${video.title }</td>
					<td>${video.views }</td>
					<td>${video.active }</td>
					<td><a href="${pageContext.request.contextPath}/admin/video-edit?id=${video.id}">Edit</a></td>
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