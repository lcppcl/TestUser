<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/daterangepicker/daterangepicker.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/select2.min.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/select2.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/daterangepicker/moment.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/daterangepicker/daterangepicker.js"></script>

</head>
<script type="text/javascript">
	$(document).ready(function() {
		$('#datetimepicker').daterangepicker({
			singleDatePicker : true,
			startDate : moment().subtract(6, 'days')
		})
	});
	/* 	$(document).ready(function() {
	 $('#datetimepicker').daterangepicker('update')
	 }); */
</script>
<body>
	<h1>添加用户</h1>
	<div class="container">
		<div class="row">
			<div class="span12">
				<form class="form-horizontal"
					action="${pageContext.request.contextPath}/user/addUser.do"
					method="post">
					<div class="control-group">
						<label class="control-label" for="number">编码</label>
						<div class="controls">
							<input id="number" type="text" value="${uer.number }"
								name="number" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="name">姓名</label>
						<div class="controls">
							<input id="name" type="text" value="${uer.name }" name="name" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password">密码</label>
						<div class="controls">
							<input id="password" type="password" value="${user.password }"
								name="password" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="remark">备注</label>
						<div class="controls">
							<input id="remark" type="text" value="${user.remark}"
								name="remark" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="type">注册时间</label>
						<div>
							<input type="text" value="2012-05-15 21:05" id="datetimepicker"
								data-date-format="yyyy-mm-dd hh:ii" name="createTime">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="type">帐号类型</label>
						<div>
							<select class="combox" id="sel_recommender" name="type">
								<option value="">请选择...</option>
								<optgroup>
									<option value="老师">老师</option>
									<option value="学生">学生</option>
								</optgroup>
							</select>
						</div>
					</div>

					<div class="control-group">
						<div class="controls">
							<button type="submit" class="btn">提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
