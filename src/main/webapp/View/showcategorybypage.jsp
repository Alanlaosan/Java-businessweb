<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="View/addcategory.jsp">添加类别</a>

	<h1>欢迎登录电商管理后台系统</h1>
<form action="category" method="get">
	<table>
		<tr>
			<th>商品类别</th>
			<th>类别描述</th>
			<th>类别库存</th>
		</tr>
		<c:forEach items="${pageFind.data}" var="category">
			<tr>
				<td>${category.name}</td>
				<td>${category.desc}</td>
				<td>${category.stock}</td>
				<td><a href="category?operation=5&id=${category.id}">修改</a> 
				<a href="category?operation=4&id=${category.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>

	<c:forEach begin="1" end="${pageFind.totalpage}" step="1" var="current">

		<c:choose>
			<c:when test="${pageFind.currentpage==current}">
				<a style="color: red" href="categorybypage.do?pageNo=${current}">${current}</a>
			</c:when>
			<c:when test="${pageFind.currentpage!=current}">
				<a href="categorybypage.do?pageNo=${current}">${current}</a>
			</c:when>
		</c:choose>
	</c:forEach>


</form>
</body>
</html>