<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>欢迎登录电商管理后台系统</h1>

<form action="category" method="get">
<!-- 隐藏域 -->
 <input type="hidden" name="operation" value="1"/>
 <table align="center">
 <tr>
 <td>商品类别</td>
 <td><input type="text" name="cname"/></td>
 </tr>
 <tr>
 <td>类别描述</td>
 <td><input type="text" name="cdesc"/></td>
 </tr>
 <tr>
 <td>类别库存</td>
 <td><input type="text" name="stock"/></td>
 </tr>
 <tr>
 <td><input type="submit" value="添加类别"/></td>
 </tr>
 </table>
 </form>

</body>
</html>