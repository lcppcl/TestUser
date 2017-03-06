<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
</head>
<body>
	<h1>欢迎使用</h1>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<ul class="nav nav-tabs">
					<li class="active"><a
						href="${pageContext.request.contextPath}/jsp/homepage.jsp"
						target="bottom">首页</a></li>
					<li><a
						href="${pageContext.request.contextPath}/jsp/addUser.jsp"
						target="bottom">添加</a></li>
					<li><a
						href="${pageContext.request.contextPath}/user/showAll.do"
						target="bottom">查看</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
