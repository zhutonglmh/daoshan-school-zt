<%--
  Created by IntelliJ IDEA.
  User: zhuto
  Date: 2018/2/12
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>道山学海</title>
    <link href="../skins/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="../skins/css/index.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../skins/js/jquery.js"></script>
    <script type="text/javascript" src="../skins/js/bootstrap.js"></script>
    <script type="text/javascript" src="../skins/js/myJs/index.js"></script>
</head>
<body>


    <nav class="navbar navbar-default navbar-static-top"><%----%>
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand">图标</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a>首页</a></li>
                <li><a>咨询</a></li>
                <li><a>产品</a></li>
                <li class="disabled"><a>弃用</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="使导航条固定在顶部navbar-fixed-top 底部-bottom">
                    <div class="input-group-btn">
                        <button class="btn btn-default">提交</button>
                    </div>
                </div>
            </form>
            <button class="btn btn-default navbar-btn ">按钮</button>
            <p class="navbar-text">我是文本<a>连接</a></p>
        </div>
    </nav>
    <div class="container">
        <%--图片轮播--%>
        <div id="myCarousel" class="carousel slide">
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="item active">
                    <img src="../skins/imge/p01.jpg" alt="第一张">
                    <div class="carousel-caption">第一张图片</div>
                </div>
                <div class="item">
                    <img src="../skins/imge/p02.jpg" alt="第二张">
                    <div class="carousel-caption">第一张图片</div>
                </div>
                <div class="item">
                    <img src="../skins/imge/p03.jpg" alt="第三张">
                    <div class="carousel-caption">第一张图片</div>
                </div>
            </div>
            <a href="#myCarousel" data-slide="prev" class="carousel-control left">&lsaquo;</a>
            <a href="#myCarousel" data-slide="next" class="carousel-control right">&rsaquo;</a>
        </div>
    </div>
</body>
</html>
