<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
	function checkForm() {
		var number = $("#number").val();
		var password = $("#password").val();
		if (number == null || number == "") {
			$("#error").html("帐号不能为空！");
			return false;
		}
		if (password == null || password == "") {
			$("#error").html("密码不能为空！");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/login.do"
		method="post" onsubmit="return checkForm()">
		number:<input type="text" name="number" value="${user.number }"
			id="number" /><br /> password:<input type="password"
			name="password" value="${user.password }" id="password"><br />
		<input type="submit" value="login"/><span><font
			color="red" id="error">${errorInfo }</font></span>
	</form>
</body>
</html>