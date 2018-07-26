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

	<h1>购物车信息</h1>

	<table>
		<tr>
			<th>购物车id</th>
			<th>商品id</th>
			<th>商品数量</th>
		</tr>
		<c:forEach items="${pagefind.data}" var="cart">
			<tr>
				<td>${cart.id}</td>
				<td>${cart.productid}</td>
				<td>${cart.productNum}</td>
				<td><a href="cart?operation=5&id=${cart.id}">修改</a> 
				    <a href="cart?operation=4&id=${cart.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<c:forEach begin="1" end="${pagefind.totalpage}" step="1" var="current">

		<c:choose>
			<c:when test="${pagefind.currentpage==current}">
				<a style="color: red" href="cart?operation=2&pageNo=${current}&pageSize=4">${current}</a>
			</c:when>
			<c:when test="${pagefind.currentpage!=current}">
				<a href="cart?operation=2&pageNo=${current}&pageSize=4">${current}</a>
			</c:when>
		</c:choose>
	</c:forEach>
	

</body>
</html>