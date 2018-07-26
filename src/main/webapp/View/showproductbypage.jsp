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

	<a href="View/addproduct.jsp">添加商品</a>

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
		<c:forEach items="${pageFind.data}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.image}</td>
				<td>${product.rule}</td>
				<td>${product.stock}</td>
				<td>${product.desc}</td>
				<td><a href="View/product?operation=5&id=${product.id}">修改</a>
					<a href="View/product?operation=4&id=${product.id}">删除</a>
				    <a href="View/cart?operation=6&id=${product.id}">加入购物车</a>
				</td>
			</tr>
		</c:forEach>
	</table>

	<c:forEach begin="1" end="${pageFind.totalpage}" step="1" var="current">

		<c:choose>
			<c:when test="${pageFind.currentpage==current}">
				<a style="color: red" href="productbypage.do?pageNo=${current}">${current}</a>
			</c:when>
			<c:when test="${pageFind.currentpage!=current}">
				<a href="productbypage.do?pageNo=${current}">${current}</a>
			</c:when>
		</c:choose>
	</c:forEach>



</body>
</html>