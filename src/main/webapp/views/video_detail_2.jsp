<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="col">
	<c:forEach var="video" items="${videoList }">
		<div class="card mb-3 border border-dark" style="max-width: 540px;">
			<div class="row g-0">
				<div class="col-md-4">
					<img src="${video.poster }"
						class="img-fluid rounded-start" alt="...">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h5 class="card-title">${video.title }</h5>
						<p class="card-text">${video.description }
							</p>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>