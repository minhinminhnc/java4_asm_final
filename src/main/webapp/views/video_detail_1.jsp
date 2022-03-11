<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="container">
	<div class="row text-center">
		<div class="card" style="width: 33rem;">
			<iframe src="${video.url }" width="500" height="300"></iframe>
			<div class="card-body">
				<h5 class="card-title">${video.title }</h5>
				<p class="card-text">${video.description }</p>
				<button class="btn btn-primary">Like</button>
				<button class="btn btn-primary">Share</button>
			</div>
		</div>
		<jsp:include page="video_detail_2.jsp"></jsp:include>
	</div>
</div>
