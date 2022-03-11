<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="container">
	<div class="row text-center">
		<c:forEach var="video" items="${videoList}">
			<div class="card" style="width: 22rem;">
				<a href="${pageContext.request.contextPath}/video-detail?id=${video.id}"><img
					height="300" width="300" src="${video.poster }"></a>
				<div class="card-body">
					<h5 class="card-title">${video.title }</h5>
					<a class="btn btn-danger" href="my-account/like?id=${video.id }">Like</a>
					<a class="btn btn-danger" href="my-account/like">Share</a>
				</div>
			</div>
		</c:forEach>
	</div>
	<div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</div>

