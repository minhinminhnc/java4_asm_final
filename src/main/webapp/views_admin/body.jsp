<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="container">
	<div class="row text-center">
		<c:forEach var="video" items="${videoList}">
			<div class="card" style="width: 22rem;">
				<a href="${pageContext.request.contextPath}/video-detail"><img
					height="300" width="300" src="${video.poster }"></a>
				<div class="card-body">
					<h5 class="card-title">${video.title }</h5>
					<button class="btn btn-primary">Like</button>
					<button class="btn btn-primary">Share</button>
				</div>
			</div>
		</c:forEach>
	</div>
	<div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</div>

