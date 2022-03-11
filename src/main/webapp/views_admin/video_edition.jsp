<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container text-center">
	<h1>VIDEO EDITION</h1>
	<div class="card mb-3" >
		<div class="row">
			<div class="col-md-4">
				<img src="https://icon-library.com/images/img-icon/img-icon-24.jpg"
					class="img-fluid rounded-start" alt="...">
			</div>
			<div class="col">
				<div class="card-body">
					<form action="video-create" method="post">
						YOUTUBE ID?<br> <input name="url" placeholder="${v.url }"><br>
						VIDEO TITLE?<br> <input name="title"
							placeholder="${v.title }"><br>VIDEO POSTER<br>
						<input name="poster" placeholder="${v.poster }"> <br>
						VIEW COUNT?<br> <input name="views" placeholder="${v.views }"><br>
						<input name="active" type="radio" value="1">ACTIVE <input
							name="active" type="radio" value="0">INACTIVE <br>
						DESCRIPTION?<br>
						<textarea name="description" rows="5" cols="35"
							placeholder="${v.description }"></textarea>
						<br> ${message }<br>
						<button type="submit" class="btn btn-danger" ${button2 }>Create</button>
						<button class="btn btn-danger" ${button } name="update" value="${v.id }">Update</button>
						<button class="btn btn-danger " ${button } name="delete" value="${v.id }">
							Delete
						</button>
						<a href="${pageContext.request.contextPath}/admin/videos"
							class="btn btn-danger">Reset</a>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div></div>
	<br> <br>
	<h1>VIDEO LIST</h1>
	<div>
		<jsp:include page="video_list.jsp"></jsp:include>
	</div>
</div>