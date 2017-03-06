<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<#import "/spring.ftl" as spring />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/datatables/jquery.dataTables.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="${pageContext.request.contextPath}/static/datatables/jquery.dataTables.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#table_id_example').DataTable();
	});
</script>
</head>

<body>
	${userList }
	<table id="table_id_example" class="display">
		<thead>
			<tr>
				<th>编码</th>
				<th>姓名</th>
				<th>备注</th>
				<th>状态</th>
				<th>帐号类型</th>
				<th>创建时间</th>
				<th>最后登录时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<#if userList?? && (userList?size > 0)>
							<#list userList as user >
									<td>${user.number }</td>
									<td>${user.name }</td>
									<td>${user.password }</td>
									<td>${user.remark }</td>
									<td>${user.status }</td>
									<td>${user.createTime }</td>
									<td>${user.lastLoginTime }</td>
									<td>${user.type }</td>
									<td><a href="#">删除</a><a href="#">修改</a></td>
							</#list>		
				<#eles>
					数据为空
				</#if>
						
							
	</table>
</body>
</html>