<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>欢迎${acc.username}登录电商后台管理系统</h1>
<a href="View/addproduct.jsp">添加商品</a>
<!-- <br/>
<a href="View/product?operation=2">查看商品</a>
<br/>
<a href="View/showfindbyid.jsp">搜索商品</a> -->
<br/>
<a href="productbypage.do?pageNo=1">查询商品</a> 

<br/>
<a href="View/addcategory.jsp">添加类别</a>
<br/>
<a href="View/category?operation=2">查询类别</a>
<br/>
<a href="View/addcart.jsp">增加购物车</a>
<br/>
<a href="View/cart?operation=2">查询购物车</a>
</body>
</html> --%>





<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
    <script src="js/echarts.min.js"></script>
</head>
<style>
    .navbar {
        background-color: #0099CC;
        border-right: 1px #008FBF solid;

    }
    .l1{
        list-style-type: none;
        margin: 10px;
    }

    a.houtaiLeft:link {text-decoration: none; color:#293038;}		/* 未被访问的链接 */
    a.houtaiLeft:visited {color:#293038;}	/* 已被访问的链接 */
    a.houtaiLeft:hover {color:#FF00FF;}	/* 鼠标指针移动到链接上 */
    a.houtaiLeft:active {color:#0000FF;}	/* 正在被点击的链接 */


    a.houtaiLeft1:link {text-decoration: none; color:#0099CC;}		/* 未被访问的链接 */
    a.houtaiLeft1:visited {color:#0099CC;}	/* 已被访问的链接 */
    a.houtaiLeft1:hover {color:#22282E;}	/* 鼠标指针移动到链接上 */
    a.houtaiLeft1:active {color:#22282E;}	/* 正在被点击的链接 */

    .list-group{
        margin-top: -19px;
    }

    #open {
        margin-top: 0px;
    }

    .houtaiLeft1 {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    #home {
        margin-top: 15px;
    }
</style>
<html>
<body class="container-fluid">
<div class="row">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                &nbsp;&nbsp;<span id="home" class="glyphicon glyphicon-home"></span>&nbsp;
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a target="iframe" class="houtai1" href="#">管理控制台 <span class="sr-only">(current)</span></a>
                    </li>

                    <li class="dropdown">
                        <a class="houtai1" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">产品与服务 <span class="caret"></span></a>
                        <ul class="dropdown-menu">

                            <li>
                                &nbsp;&nbsp;
                            <li class="glyphicon glyphicon-road">&nbsp;云服务器ECS
                            </li>
                            <li role="separator" class="divider"></li>
                            <li>
                                &nbsp;&nbsp;
                            <li class="glyphicon glyphicon-picture">&nbsp;云服务器ECS
                            </li>
                            <li role="separator" class="divider"></li>
                            <li>
                                &nbsp;&nbsp;
                            <li class="glyphicon glyphicon-gift">&nbsp;云服务器ECS
                            </li>
                        </ul>
                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="houtai1" href="#"><span class="glyphicon glyphicon-bell">0</span></a>
                    </li>
                    <li>
                        <a class="houtai1" href="#"><span class="glyphicon glyphicon-search">搜索</span></a>
                    </li>
                    <li class="dropdown">
                        <a class="houtai1" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">帮助与文档 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#">帮助与文档</a>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li>
                                <a href="#">论坛</a>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li>
                                <a href="#">博客</a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="houtai1" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">1231213@163.com <span
                                class="caret"></span></a>
                        <ul class="dropdown-menu">

                            <li>
                                <a href="#">退出</a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="houtai1" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">换肤 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#">蓝色</a>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li>
                                <a href="#">蓝色</a>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li>
                                <a href="#">蓝色</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div><!--抬头结束-->


<!--<h1>欢迎${acc.username}登录电商后台管理系统</h1>-->
<!--<a href="View/addproduct.jsp">添加商品</a>-->
<!--&lt;!&ndash; <br/>-->
<!--<a href="View/product?operation=2">查看商品</a>-->
<!--<br/>-->
<!--<a href="View/showfindbyid.jsp">搜索商品</a> &ndash;&gt;-->
<!--<br/>-->
<!--<a href="productbypage.do?pageNo=1">查询商品</a>-->

<!--<br/>-->
<!--<a href="View/addcategory.jsp">添加类别</a>-->
<!--<br/>-->
<!--<a href="View/category?operation=2">查询类别</a>-->
<!--<br/>-->
<!--<a href="View/addcart.jsp">增加购物车</a>-->
<!--<br/>-->
<!--<a href="View/cart?operation=2">查询购物车</a>-->


<!--左侧页面-->
<div class="row">
    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-12">


        <!--<ul id="open" >-->
        <!--<li >-->
        <!--<a class="houtaiLeft1" href=""><span-->
        <!--class="glyphicon glyphicon-chevron-down"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品管理</a>-->

        <!--<ul style="display: none" >-->
        <!--<li  >-->
        <!--<a class="houtaiLeft" href="accountManage.html"-->
        <!--target="wodeguanli">&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;&nbsp;&nbsp;添加商品</a>-->
        <!--</li>-->
        <!--<li >-->
        <!--<a class="houtaiLeft" href="newsCentre.html" target="wodeguanli">-->
        <!--&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-envelope"></span>&nbsp;&nbsp;&nbsp;&nbsp;查询商品</a>-->
        <!--</li>-->
        <!--</ul>-->
        <!--</li>-->
        <!--</ul>-->
        <!--<div id="glone">

        </div>-->

        <!--<ul id="open2" class="list-group">-->
        <!--<li class="list-group-item">-->
        <!--<a class="houtaiLeft1" href="">
        -->
        <!--<span>class="glyphicon glyphicon-chevron-down"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类别管理</a>-->
        <!--</li>-->
        <!--</ul>-->
        <!--<div id="gltwo" style="display: none">-->
        <!--<ul class="list-group" >-->
        <!--<li class="list-group-item">-->
        <!--<a class="houtaiLeft" href="usermanage.html " target="wodeguanli">&nbsp;&nbsp;&nbsp;&nbsp;<span-->
        <!--class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;&nbsp;&nbsp;添加类别</a>-->
        <!--</li>-->
        <!--<li class="list-group-item">-->
        <!--<a class="houtaiLeft" href="productManage.html"-->
        <!--target="wodeguanli">&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-gift"></span>&nbsp;&nbsp;&nbsp;&nbsp;查询类别</a>-->
        <!--</li>-->
        <!--</ul>-->
        <!--</div>-->


        <ul id="open"  class="list-group">
            <li class="list-group-item">
                <a href="#" class="houtaiLeft1"><span class="glyphicon glyphicon-chevron-down">&nbsp;商品管理</span>

                </a>
                <ul style="display: none;">
                    <li class="l1"><a class="houtaiLeft" href="View/addproduct.jsp" class="lis" target="wodeguanli">添加商品</a></li>
                    <li class="l1"><a class="houtaiLeft" href="productbypage.do?pageNo=1" class="lis" target="wodeguanli">查询商品</a></li>
                </ul>
            </li>

            <li class="list-group-item">
                <a href="#" class="houtaiLeft1"><span class="glyphicon glyphicon-chevron-down">&nbsp;类别管理</span>

                </a>
                <ul style="display: none;">
                    <li class="l1"><a class="houtaiLeft" href="View/addcategory.jsp" class="lis" target="wodeguanli">添加类别</a></li>
                    <li class="l1"><a class="houtaiLeft" href="View/category?operation=2" class="lis" target="wodeguanli">查询类别</a></li>
                </ul>
            </li>

            <li class="list-group-item">
                <a href="#" class="houtaiLeft1"><span style="margin-left: 13px" class="glyphicon glyphicon-chevron-down">&nbsp;购物车管理</span>

                </a>
                <ul style="display: none;">
                    <li class="l1"><a class="houtaiLeft" href="View/addcart.jsp" class="lis" target="wodeguanli">添加购物车</a></li>
                    <li class="l1"><a class="houtaiLeft" href="View/cart?operation=2" class="lis" target="wodeguanli">查询购物车</a></li>
                </ul>
            </li>
        </ul>

    </div>


    <!--右侧-->
    <div style="background-color: #F0F4F6; height: 600px;" class="col-lg-10 col-md-10 col-sm-8 col-xs-12">
        <iframe name="wodeguanli" src="huanying.jsp" width="100%" height="100%" frameborder="0"></iframe>
    </div>
</div><!--容器结尾-->


<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>

<script>

    $(function () {

        $("#open>li>a").click(function () {
            $(this).next().toggle()
            /* .parent().siblings() */
            /* .next().hide(); */
        })



    })

</script>


</body>
</html>