<%--
  Created by IntelliJ IDEA.
  User: zhuto
  Date: 2018/4/9
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../skins/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="../skins/css/search.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="myHead">
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a id="my-navbar-brand" class="navbar-brand" href="#">道山学海</a>
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
<script type="text/javascript" src="../skins/js/jquery.js"></script>
<script type="text/javascript" src="../skins/js/bootstrap.js"></script>
<script type="text/javascript" src="../skins/js/main.js"></script>
</body>
</html>
