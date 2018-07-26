<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <script src="js/echarts.min.js"></script>
    <title></title>
    <style>
        .navbar {
            background-color: #0099CC;
            border-right: 1px #008FBF solid;
        }

        ::webkit-scrollbar{
        display:none;}


        .Administrator{
            font-family: "微软雅黑";
            font-size: 17px;
            font-weight: bold;

            padding-top: 10px;
        }

        a.yuanma:link {color:black;}		/* 未被访问的链接 */
        a.yuanma:visited {color:black;}	/* 已被访问的链接 */
        a.yuanma:hover {color:#0099CC;}	/* 鼠标指针移动到链接上 */
        a.yuanma:active {color:#122B40;}	/* 正在被点击的链接 */



        #hang11{
            height: 70px;
            /*background-color: #D43F3A;*/
        }
        #hang12{
            height: 70px;
            background-color: #0099CC;
        }
        }
        #hang1211{

            padding-top: 5px;
        }
        #hang1212{
            background-color: skyblue;
        }
        #hang1221{
            font-family: "微软雅黑";
            font-size: 35px;
            font-weight: bold;
            text-align: center;
            padding-top: 6px;
            color: #0099CC;
        }
        #2013{
            font-family: "微软雅黑";
            font-size: 30px;
            font-weight: bold;
            color: white;
        }

        .zhuyao1{
            background-color: #17D57E;
            height: 150px;
            margin-top: 20px;
            padding-top: 25px;
        }
        .zhuyao2{

            background-color: #FEC92B;
            height: 150px;
            margin-top: 20px;
            padding-top: 25px;
        }
        .zhuyao3{
            background-color: #2DA3FB;
            height: 150px;
            margin-top: 20px;
            padding-top: 25px;
        }
        .zhuyao4{
            background-color: #C172D8;
            height: 150px;
            margin-top: 20px;
            padding-top: 25px;
        }
        #block{
            width: 50px;
            height: 50px;
            border-radius: 25px;
            background-color: white;
            font-family: "微软雅黑";
            font-size: 25px;
            color: #17D57E;
            text-align:center;
            padding-top: 10px;
            margin-left: 25px;
        }
        .zhuyao12{
            font-family: "微软雅黑";
            font-size: 30px;
            color: white;
            padding-left: 70%;
            margin-top: -50px;
        }
        .zhuyao22{
            font-family: "微软雅黑";
            font-size: 30px;
            color: white;
            padding-left: 70%;
            margin-top: -50px;
        }
        .zhuyao32{
            font-family: "微软雅黑";
            font-size: 30px;
            color: white;
            padding-left: 70%;
            margin-top: -50px;
        }
        .zhuyao42{
            font-family: "微软雅黑";
            font-size: 30px;
            color: white;
            padding-left: 70%;
            margin-top: -50px;
        }
        .zhuyao13{
            margin-top: 20px;
            margin-left: 35%;
        }
        .btn{
            background-color: red;
        }
        .xs{
            width: 50%;
            height: 35px;
            font-family: "微软雅黑";
            color: white;
            text-align: center;

            border-radius: 5px;
            background-color: gray;
        }
        .xiaoshouUl{
            width: 80px;
            height: 20px;
            background-color: #036564;
            text-align: center;
            border-radius: 5px;
        }
        #chuli{
            width: 100%;
            height: 200px;
            background-color: white;
            margin-top: 40px;
        }
        #rexiao{
            width: 100%;
            height: 200px;
            background-color: white;
            margin-top: 40px;
        }
        .daichuli{
            font-family: "微软雅黑";
            font-size: 25px;
            height: 26%;
            padding-top: 7px;
            border-bottom: 1px #F5F5F5 solid;
        }

        .daichuliziti1{
            color: #C0D9EC;
            font: "微软雅黑";
            font-size: 13px;

        }
        .rexiao1,.rexiao2{
            height: 36%;
            font-family: "微软雅黑";
            font-size: 20px;
            padding-top: 20px;
        }
        .rexiao1{
            background-color: #F6F9FB;
        }




    </style>
    <title></title>
</head>

<body style="background-color: #F0F4F6;">
<div class="row">
    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
        <div id="hang11">
            <div class="Administrator">Administrator，</div>
            <div class="huanyi">
                欢迎登录管理系统！
                <a class="yuanma" href="#">JSPGOU</a>
            </div>
        </div>
    </div>

    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 col-lg-push-5 col-md-push-5 col-sm-5">
        <div id="hang12">
            <div class="col-lg-7 col-ma-7 col-sm-7">
                <div style="background-color: #0099CC; height: 30px; color: white; padding-top: 5px;" id="hang1211">
                    星期二
                </div>
                <div id="hang1212">
                    <div class="col-lg-5 col-md-5 col-sm-5">
                        <div style="font-family: '微软雅黑'; font-size: 30px; color: white; margin-left: -15px;" id="2013">2013</div>
                    </div>
                    <div style="color: white; padding-top: 18px; font-size: 12px;" class="col-lg-7 col-md-7 col-sm-7">
                        年2月15日
                    </div>
                </div>
            </div>
            <div style="background-color: white; height: 70px;" class="col-lg-5 col-ma-5 col-sm-5">
                <div id="hang1221">
                    9:00
                </div>

            </div>
        </div>

    </div>
</div>

<div class="row">

    <div class="col-lg-3 col-md-3 col-sm-3">
        <div class="zhuyao1">
            <div class="zhuyao11">
                <div id="block"><span class="glyphicon glyphicon-yen"></span></div>
            </div>
            <div class="zhuyao12">0</div>
            <div class="zhuyao13">
                <div id="xiaoshou" class="xs">
                    近期销售额<span class="glyphicon glyphicon-triangle-bottom"></span>
                </div>
                <div id="xiaoshou1">
                    <ul>
                        <li class="xiaoshouUl">电子商品类</li>
                        <li class="xiaoshouUl">服装饰品类</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div class="col-lg-3 col-md-3 col-sm-3">
        <div class="zhuyao2">
            <div class="zhuyao11">
                <div id="block"><span style="color: #FEC92B;" class="glyphicon glyphicon-briefcase"></span></div>
            </div>
            <div class="zhuyao22">20</div>
            <div class="zhuyao13">
                <div id="dingdan" class="xs">
                    近期订单数<span class="glyphicon glyphicon-triangle-bottom"></span>
                </div>
                <div id="dingdan1">
                    <ul>
                        <li class="xiaoshouUl">历史订单</li>
                        <li class="xiaoshouUl">今日订单</li>
                    </ul>
                </div>

            </div>
        </div>
    </div>

    <div class="col-lg-3 col-md-3 col-sm-3">
        <div class="zhuyao3">
            <div class="zhuyao11">
                <div id="block"><span style="color: #2DA3FB;" class="glyphicon glyphicon-th-list"></span></div>
            </div>
            <div class="zhuyao32">49</div>
            <div class="zhuyao13">
                <div id="chushou" class="xs">
                    出售商品数<span class="glyphicon glyphicon-triangle-bottom"></span>
                </div>
                <div id="chushou1">
                    <ul>
                        <li class="xiaoshouUl">优惠商品类</li>
                        <li class="xiaoshouUl">无促销商品类</li>
                    </ul>
                </div>

            </div>
        </div>
    </div>

    <div class="col-lg-3 col-md-3 col-sm-3">
        <div class="zhuyao4">
            <div class="zhuyao11">
                <div id="block"><span style="color: #C172D8;" class="glyphicon glyphicon-user"></span></div>
            </div>
            <div class="zhuyao42">530</div>
            <div class="zhuyao13">
                <div id="huiyuan" class="xs">
                    总会员数<span class="glyphicon glyphicon-triangle-bottom"></span>
                </div>
                <div id="huiyuan1">
                    <ul>
                        <li class="xiaoshouUl">历史会员数</li>
                        <li class="xiaoshouUl">今日会员数</li>
                    </ul>
                </div>

            </div>
        </div>
    </div>

</div>

<div class="row">
    <div class="col-lg-6 col-md-6 col-sm-6">
        <div id="chuli">
            <div class="col-lg-12 col-md-12 col-sm-12 daichuli">待处理</div>
            <div class="col-lg-1 col-md-1 col-sm-1"></div>
            <div class="col-lg-2 col-md-2 col-sm-2">
                <span style="  font-size: 30px; padding-top: 30px; color: #C0D9EC;" class="glyphicon glyphicon-plane"></span><br/>
                <span class="daichuliziti1">待发货</span>
                <br><span class="daichuliNum">123</span>
            </div>
            <div class="col-lg-2 col-md-2 col-sm-2">
                <span style="font-size: 30px; padding-top: 30px; color: #C0D9EC;" class="glyphicon glyphicon-gift"></span><br>
                <span class="daichuliziti1">待付款</span>
                <br><span class="daichuliNum">34</span>
            </div>
            <div class="col-lg-2 col-md-2 col-sm-2">
                <span style="font-size: 30px; padding-top: 30px; color: #C0D9EC;" class="glyphicon glyphicon-shopping-cart"></span>
                <br><span class="daichuliziti1">退货/退款</span>
                <br><span class="daichuliNum">23</span>
            </div>

            <div class="col-lg-2 col-md-2 col-sm-2">
                <span style="font-size: 30px; padding-top: 30px; color: #C0D9EC;" class="glyphicon glyphicon-alert"></span>
                <br><span class="daichuliziti1">库存预警</span>
                <br><span class="daichuliNum">3</span>
            </div>
            <div class="col-lg-2 col-md-2 col-sm-2">
                <span style="font-size: 30px; padding-top: 30px; color: #C0D9EC;" class="glyphicon glyphicon-comment"></span>
                <br><span class="daichuliziti1">商品咨询</span>
                <br><span class="daichuliNum">98</span>
            </div>
            <div class="col-lg-1 col-md-1 col-sm-1"></div>

        </div>
    </div>
    <div class="col-lg-6 col-md-6 col-sm-6">
        <div id="rexiao">
            <div class="col-lg-12 col-md-12 col-sm-12 daichuli">
                热销商品
                <div style="margin-left: 40%;" class="btn-group" role="group">
                    <button type="button" class="btn btn-default">年</button>
                    <button type="button" class="btn btn-default">月</button>
                    <button type="button" class="btn btn-default">总</button>
                </div>
            </div>
            <div class="col-lg-7 col-md-7 col-sm-7 rexiao1">
                商品名称
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 rexiao1">
                分类
            </div>
            <div class="col-lg-2 col-md-2 col-sm-2 rexiao1">
                销量
            </div>

            <div class="col-lg-7 col-md-7 col-sm-7 rexiao2">
                快乐学习
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 rexiao2">
                日用百货
            </div>
            <div class="col-lg-2 col-md-2 col-sm-2 rexiao2">
                3
            </div>

        </div>

    </div>
</div>

<div class="row">
    <div class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
        <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
        <div id="main" style="height:400px;"></div>
        <script type="text/javascript">
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('main'));

            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '各类商品销售图'
                },
                tooltip: {},
                legend: {
                    data: ['销量']
                },
                xAxis: {
                    data: ["电子类", "鞋包类", "衣物类", "食品类", "饰品类", "进口类"]
                },
                yAxis: {},
                series: [{
                    name: '销量',
                    type: 'bar',
                    data: [5, 20, 36, 10, 10, 20]
                }]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        </script>
    </div>


</div>

<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>

<script>
    var chushou = document.querySelector("#chushou");
    var flag = true;
    chushou.onclick = function() {
        var chushou = document.querySelector("#chushou1");
        if(flag) {
            chushou.style.display = "none"
            flag = false;
        } else {
            chushou.style.display = "block"
            flag = true;
        }
    }
</script>
<script>
    var huiyuan = document.querySelector("#huiyuan");
    var flag = true;
    huiyuan.onclick = function() {
        var huiyuan = document.querySelector("#huiyuan1");
        if(flag) {
            huiyuan.style.display = "none"
            flag = false;
        } else {
            huiyuan.style.display = "block"
            flag = true;
        }
    }
</script>
<script>
    var xiaoshou = document.querySelector("#xiaoshou");
    var flag = true;
    xiaoshou.onclick = function() {
        var xiaoshou = document.querySelector("#xiaoshou1");
        if(flag) {
            xiaoshou.style.display = "none"
            flag = false;
        } else {
            xiaoshou.style.display = "block"
            flag = true;
        }
    }
</script>
<script>
    var dingdan = document.querySelector("#dingdan");
    var flag = true;
    dingdan.onclick = function() {
        var dingdan = document.querySelector("#dingdan1");
        if(flag) {
            dingdan.style.display = "none"
            flag = false;
        } else {
            dingdan.style.display = "block"
            flag = true;
        }
    }
</script>

</body>

</html>