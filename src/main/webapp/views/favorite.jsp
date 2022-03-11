<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="row text-center">
	<c:forEach begin="1" end="3">
		<div class="card" style="width: 18rem;">
			<img src="https://www.youtube.com/img/desktop/yt_1200.png"
				class="card-img-top">
			<div class="card-body">
				<h5 class="card-title">Video Title</h5>
				<button class="btn btn-primary">Like</button>
				<button class="btn btn-primary">Share</button>
			</div>
		</div>
	</c:forEach>
</div>