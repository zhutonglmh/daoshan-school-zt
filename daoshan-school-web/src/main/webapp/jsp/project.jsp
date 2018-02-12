<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2017/11/26
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta name="viewport" content="width=device-width, intial-scale=1,maximu-scale=1, user-scalble=no">
    <title>项目实战自适应首页</title>
    <link href="../skins/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="../skins/css/project.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <a href="#" class="navbar-brand" style="margin: 0;padding: 0">
                    <img src="../skins/imge/logo.png">
                </a>
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
                    <span class=sr-only>切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div id="navbar-collapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span> 首页</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-list"></span> 资讯</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-fire"></span> 案例</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-question-sign"></span> 关于</a></li>
            </ul>
            </div>
        </div>
    </nav>
    <div id="myCarousel" class="carousel slide" style="margin-top: 50px">
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="item active" style="background: #223240;">
                <a href="#"><img src="../skins/imge/slide1.png" alt="第一张"></a>
                <div class="carousel-caption">第一张图片</div>
            </div>
            <div class="item" style="background: #F5E4DC;">
                <a href="#"><img src="../skins/imge/slide2.png" alt="第二张"></a>
                <div class="carousel-caption">第二张图片</div>
            </div>
            <div class="item" style="background: #DE2A2D;">
                <a href="#"><img src="../skins/imge/slide3.png" alt="第三张"></a>
                <div class="carousel-caption">第三张图片</div>
            </div>
        </div>
       <%-- <a href="#myCarousel" data-slide="prev" class="carousel-control left">&lsaquo;</a>
        <a href="#myCarousel" data-slide="next" class="carousel-control right">&rsaquo;</a>--%>
        <a href="#myCarousel" data-slide="prev" class="carousel-control left">
            <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <a href="#myCarousel" data-slide="next" class="carousel-control right">
            <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
    </div>
    <div class="tab1">
        <div class="container">
            <h2 class="tab-h2">「为什么选择瓢城企业培训」</h2>
            <p class="tab-p">强大的师资力量，完美的实战型管理课程，让您的企业实现质的腾飞！</p>
            <div class="row">
                <div class="col-md-6 col">
                    <div class="media">
                        <div class="media-left">
                            <a href="#"><img src="../skins/imge/tab1-1.png" class="media-object" alt=""></a>
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">课程内容</h4>
                            <p class="text-muted">其他：高校不知名的讲师编写，没有任何实战价值的教材！</p>
                            <p>我们：知名企业家、管理学大师联合编写的具有实现性教材！</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col">
                    <div class="media">
                        <div class="media-left">
                            <a href="#"><img src="../skins/imge/tab1-2.png" class="media-object" alt=""></a>
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">师资力量</h4>
                            <p class="text-muted">其他：非欧美正牌大学毕业的、业界没有知名度的讲师！</p>
                            <p>我们：美国哈佛、耶鲁等世界一流高校、享有声誉的名牌专家！</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col">
                    <div class="media">
                        <div class="media-left">
                            <a href="#"><img src="../skins/imge/tab1-3.png" class="media-object" alt=""></a>
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">课时安排</h4>
                            <p class="text-muted">其他：无法保证上课效率、没有时间表，任务无法完成！</p>
                            <p>我们：保证按时间表的上课、效率高、当天的任务当天完成！</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col">
                    <div class="media">
                        <div class="media-left">
                            <a href="#"><img src="../skins/imge/tab1-4.png" class="media-object" alt=""></a>
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">服务团队</h4>
                            <p class="text-muted">其他：社会招聘的、服务水平参差不齐的普通员工！</p>
                            <p>我们：内部培养、经受过良好高端服务培训的高标准员工！</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="tab2">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-sm-6 tab2-img">
                    <img src="../skins/imge/tab2.png" class="auto img-responsive center-block" alt="">
                </div>
                <div class="text col-md-6 col-sm-6 tab2-text">
                    <h3>强大的学习体系</h3>
                    <p>经过管理学大师层层把关、让您的企业突飞猛进。</p>
                </div>
            </div>
        </div>
    </div>


    <div class="tab3">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-sm-6">
                    <img src="../skins/imge/tab3.png" class="auto img-responsive center-block" alt="">
                </div>
                <div class="text col-md-6 col-sm-6">
                    <h3>完美的管理方式</h3>
                    <p>最新的管理培训方案，让您的企业赶超同行。</p>
                </div>
            </div>
        </div>
    </div>
    <iframe height=498 width=510 src='http://player.youku.com/embed/XMzE4Mjg2OTU2MA==' frameborder=0 'allowfullscreen'></iframe>
    <footer id="footer">
        <div class="container">
            <p>企业培训 | 合作事宜 | 版权投诉</p>
            <p>苏ICP 备12345678. © 2009-2016 瓢城企训网. Powered by Bootstrap.</p>
        </div>
    </footer>
<script type="text/javascript" src="../skins/js/jquery.js"></script>
<script type="text/javascript" src="../skins/js/bootstrap.js"></script>
<script type="text/javascript" src="../skins/js/project.js"></script>
</body>
</html>
