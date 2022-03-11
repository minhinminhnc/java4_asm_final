<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container">
	<header
		class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
		<a href="${pageContext.request.contextPath}/home/admin"
			class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
			<svg class="bi me-2" width="40" height="32">
					<use xlink:href="" /></svg>
			<span class="fs-4">ADMINISTRATION TOOL </span>
		</a>

		<ul class="nav nav-pills">
			<li class="nav-item"><a
				href="${pageContext.request.contextPath}/home/admin"
				class="nav-link">HOME</a></li>
			<li class="nav-item"><a href="${pageContext.request.contextPath}/admin/videos" class="nav-link">VIDEOS</a></li>
			<li class="nav-item"><a href="${pageContext.request.contextPath}/admin/users" class="nav-link">USERS</a></li>
			<li class="nav-item"><a href="${pageContext.request.contextPath}/admin/reports" class="nav-link">REPORTS</a></li>
			<li class="nav-item"><a href="${pageContext.request.contextPath}/logoff-admin" class="nav-link">LOGOFF</a></li>
		</ul>
		<div>
			${sessionScope.user.email }
		</div>
	</header>
</div>