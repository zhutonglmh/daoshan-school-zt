<%--
  Created by IntelliJ IDEA.
  User: zhuto
  Date: 2018/3/29
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link href="../skins/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="../skins/css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="myHead">
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a id="my-navbar-brand" class="navbar-brand" href="#"><span class="glyphicon glyphicon-book"></span>道山学海</a>
        </div>
        <div>
            <ul id="myNav" class="nav navbar-nav">
                <li class="active"><a href="#">iOS</a></li>
                <li><a href="#">SVN</a></li>
                <li class="active"><a href="#">iOS</a></li>
                <li><a href="#">SVN</a></li>
            </ul>
            <div id="search">
                <input type="text" name="search" placeholder="输入搜索内容" value="" />
                <label><a>搜索</a></label>
                <label><a>我的学习</a></label>
                <label><a>我的收藏</a></label>
                <label><a>我的余额</a></label>
                <label><a href="login.jsp">登录/注册</a></label>
            </div>
        </div>
    </div>
</nav>
</div>
<div class="container">
<ol class="breadcrumb">
    <li><a>首页</a></li>
    <li><a>课程列表</a></li>
    <li><a>课程详情</a></li>
    <li><a>Jquery</a></li>
    <li><a>韩版2017年时尚卫衣</a></li>
</ol>
<iframe id="vedio" height=400 width=600 frameborder=0 allowfullscreen></iframe>
    <div class="message_info">
        <div class="title">
            <label>一生的计划</label>
        </div>
        <div class="handle">
            <span class="glyphicon glyphicon-new-window"></span>
            <span class="glyphicon glyphicon-star-empty"></span>
            <span class="glyphicon glyphicon-star"></span>
        </div>
        <p><span class="glyphicon glyphicon-user">User</span>
            <label>讲师：柏永辉</label>
        </p>

        <div class="price">
            ¥ 1.00
        </div>
        <div id="my_btns">
            <button class="btn btn-info" data-toggle="modal" data-target="#Mydialog4">立即购买</button><%--<button  class="btn btn-info">立即购买</button>--%>
            <button class="btn btn-info">加入收藏</button>
        </div>
    </div>

    <ul class="nav nav-pills my_nav">
        <li class="active"><a href="#my_content_one" data-toggle="tab">介绍</a></li>
        <li><a href="#my_content_two" data-toggle="tab">目录</a></li>
        <li><a href="#my_content_three" data-toggle="tab">笔记</a></li>
        <li><a href="#my_content_four" data-toggle="tab">评论区</a></li>
    </ul>

    <div class="tab-content">

        <div id="my_content_one" class="my_content tab-pane active fade in" >
            <p>标准通用标记语言下的一个应用 HTML 标准自 19 年 12 月发布的 HTML4.01后，后继的 HTML5 和其它标准被束之高阁，为了推动 Web 标准化运动的发展，一些公司联合起来，成立了一个叫做 Web Hypertext Aplication Technolgy Working Group（Web 超文本应用技术工作组 -WHATWG） 的组织。WHATWG 致力于 Web 表单和应用程序，而 W3C（World Wide Web Consortium，万维网联盟） 专注于 XHTML2.0。在 206 年，双方决定进行合作，来创建一个新版本的 HTML。</p>
        </div>
        <div id="my_content_two" class="my_content tab-pane fade" id="bootstrap3">
            <p>Botsrap，来自 Twiter，是目前很受欢迎的前端框架。Botsrap 是基于 HTML、CS、JAVSCRIPT 的，它简洁灵活，使得 Web 开发更加快捷。[1] 它由 Twiter的设计师 Mark Oto 和 Jacob Thornton 合作开发，是一个 CS/HTML 框架。Botsrap提供了优雅的 HTML 和 CS 规范，它即是由动态 CS 语言 Les 写成。Botsrap 一经推出后颇受欢迎，一直是 GitHub 上的热门开源项目，包括 NAS 的 MSNBC（微软全国广播公司）的 Breaking News 都使用了该项目。[2] 国内一些移动开发者较为熟悉的框架，如 WeX前端开源框架等，也是基于 Botsrap 源码进行性能优化而来。[3] </p>
        </div>

        <div id="my_content_three" class="my_content tab-pane fade" id="jquery3">
            <p>JQuery 是继 protype 之后又一个优秀的 Javscript 库。它是轻量级的 js库 ，它兼容 CS3，还兼容各种浏览器（IE 6.0+, F 1.5+, Safri 2.0+, Opera 9.0+），jQuery2.0 及后续版本将不再支持 IE6/78 浏览器。jQuery 使用户能更方便地处理 HTML（标准通用标记语言下的一个应用）、evnts、实现动画效果，并且方便地为网站提供 AJX交互。jQuery 还有一个比较大的优势是，它的文档说明很全，而且各种应用也说得很详细，同时还有许多成熟的插件可供选择。jQuery 能够使用户的 html 页面保持代码和 html 内容分离，也就是说，不用再在 html 里面插入一堆 js 来调用命令了，只需要定义 id 即可。</p>
        </div>
        <div id="my_content_four" class="my_content tab-pane fade" id="extjs3">
            <p>ExtJS 可以用来开发 RIA 也即富客户端的 AJX 应用，是一个用 javscript写的，主要用于创建前端用户界面，是一个与后台技术无关的前端 ajx 框架。因此，可以把 ExtJS 用在.Net、Jav、Php 等各种开发语言开发的应用中。ExtJs 最开始基于 YUI 技术，由开发人员 JackSlocum 开发，通过参考 JavSwing 等机制来组织可视化组件，无论从 UI 界面上 CS 样式的应用，到数据解析上的异常处理，都可算是一款不可多得的JavScript 客户端技术的精品。</p>
        </div>
        <div class = "information">
            <div class="information_top">
                <div class="child1 child">
                    柏云辉
                </div>
                <div class="child2 child">
                    HBDI 美国赫曼全脑优势授证讲师｜<br>
                    国家认证职业生涯规划咨询师｜<br>
                    ECC创业生涯规划咨询师｜<br>
                    国家认证职业生涯规划咨询师｜<br>
                    ECC创业生涯规划咨询师｜
                </div>
            </div>
            <div class="information_main">
                <div class="child1 child">
                    咨询
                </div>
                <div class="child2 child">
                    <div class = "consult">
                        <span class="glyphicon glyphicon-headphones" aria-hidden="true"></span>   服务咨询
                    </div>
                    <p>可在此在线咨询关于课程的内容、价格、售前、售后服务等相关信息</p>
                </div>
            </div>
            <div class="information_bottom">
                <div class="child1 child">
                    所属系列课程
                </div>
                <div class="child2 child">
                    跟职场教练柏永辉学人生进阶术
                </div>
            </div>
            <div class="information_comments">
                <div class="child1 child">
                    评价
                </div>
                <div class="child2 child">
                    HBDI 美国赫曼全脑优势授证讲师｜<br>
                    国家认证职业生涯规划咨询师｜<br>
                    ECC创业生涯规划咨询师｜
                </div>
            </div>
        </div>
    </div>
    <div class="my_content" >
        <p>标准通用标记语言下的一个应用 HTML 标准自 19 年 12 月发布的 HTML4.01后，后继的 HTML5 和其它标准被束之高阁，为了推动 Web 标准化运动的发展，一些公司联合起来，成立了一个叫做 Web Hypertext Aplication Technolgy Working Group（Web 超文本应用技术工作组 -WHATWG） 的组织。WHATWG 致力于 Web 表单和应用程序，而 W3C（World Wide Web Consortium，万维网联盟） 专注于 XHTML2.0。在 206 年，双方决定进行合作，来创建一个新版本的 HTML。</p>
    </div>
<script type="text/javascript" src="../skins/js/jquery.js"></script>
<script type="text/javascript" src="../skins/js/bootstrap.js"></script>
<script type="text/javascript" src="../skins/js/main.js"></script>
</div>
<div class="my_foot">
    <div class="container">
        <div class="logo_info"><span class="glyphicon glyphicon-book"></span>道山学海</div>
        <div class="foot_info">
            道山学海(zt.com)旗下实用技能学习平台。与优秀讲师、专业机构、院校合作，为您提供海量优质课程，以及创新的在线学习体验，帮助您获得全新的个人发展和能力提升。
        </div>
        <div class="foot_info_right">
            <a>关于我们</a>
            <a>联系我们</a>
            <a>帮助中心</a>
            <a>企业培训</a>
            <a>中国大学MOOC</a>
            <a>作者信息</a>
            <a>疑难解答</a>
            <div class="copyright">
                ©CopyRight 2018-2019  朱同 版权所有 17862979628
            </div>
            <%--模态框声明--%>
            <%--模态框声明--%>
            <div class="modal fade" id="Mydialog4">
                <%--窗口声明--%>
                <div class="modal-dialog">
                    <%--内容声明--%>
                    <div class="modal-content">
                        <div class="modal-header">
                            <button class="close" data-dismiss="modal"><span>&times;</span></button>
                            <div class="modal-title">标题</div>
                        </div>
                        <div class="modal-body">
                            <p>内容区域</p>
                            <p>内容区域</p>
                            <p>内容区域</p>
                            <p>内容区域</p>
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-info">登录</button>
                            <button class="btn btn-primary">注册</button>
                        </div>
                    </div>
                </div>
            </div>
            </div>
        </div>
    </div>
</div>

</body>

</html>
