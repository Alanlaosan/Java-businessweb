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

	<a href="addproduct.jsp">添加商品</a>

	<h1>欢迎登录电商管理后台系统</h1>

	<table>
		<tr>
			<th>商品id</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品图片</th>
			<th>商品规格</th>
			<th>商品库存</th>
			<th>商品描述</th>
			<th>商品操作</th>
		</tr>
		<c:forEach items="${PaGeFind.data}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.image}</td>
				<td>${product.rule}</td>
				<td>${product.stock}</td>
				<td>${product.desc}</td>
				<td><a href="product?operation=5&id=${product.id}">修改</a> <a
					href="product?operation=4&id=${product.id}">删除</a>
					<a href="View/cart?operation=6&id=${product.id}">加入购物车</a>
					</td>
			</tr>
		</c:forEach>
	</table>

	<c:forEach begin="1" end="${PaGeFind.totalpage}" step="1" var="current">

		<c:choose>
			<c:when test="${PaGeFind.currentpage==current}">
				<a style="color: red" href="product?operation=2&pageNo=${current}&pageSize=4">${current}</a>
			</c:when>
			<c:when test="${PaGeFind.currentpage!=current}">
				<a href="product?operation=2&pageNo=${current}&pageSize=4">${current}</a>
			</c:when>
		</c:choose>
	</c:forEach>



</body>
</html>