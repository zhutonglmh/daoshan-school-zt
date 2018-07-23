<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2017/11/26
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>道山学海-收藏</title>
    <link href="../skins/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="../skins/css/bootstrap-fileinput.css" rel="stylesheet">
    <link href="../skins/css/main.css" rel="stylesheet" type="text/css"/>
    <link href="../skins/css/pagination.css" rel="stylesheet" type="text/css"/>
    <link href="../skins/css/message.css" rel="stylesheet" type="text/css"/>
    <link href="../skins/css/user.css" rel="stylesheet" type="text/css"/>

    <script type="text/javascript" src="../skins/js/jquery.js"></script>
    <script type="text/javascript" src="../skins/js/bootstrap.js"></script>
    <script type="text/javascript" src="../skins/js/message.min.js"></script>
    <script type="text/javascript" src="../skins/js/bootstrap-fileinput.js"></script>
    <script type="text/javascript" src="../skins/js/addVedio.js"></script>

</head>

<body>
<div class="myHead">
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a id="my-navbar-brand" class="navbar-brand" href="index.jsp"><span class="glyphicon glyphicon-book"></span>道山学海</a>
            </div>
            <div>
                <div id="myNav" class="nav navbar-nav" style="line-height: 60px; color: #44f30c;margin-left: 60px;">
                    爱学习&nbsp;&nbsp;不设限&nbsp;&nbsp;我们与你同在！
                </div>
                <div id="search">
                    <input type="text" name="search" id="search-info" placeholder="输入搜索内容" value=""/>
                    <label><a id="search-begin">搜索</a></label>
                    <label><a href="order.jsp">我的订单</a></label>
                    <label><a href="collect.jsp">我的收藏</a></label>
                    <label><a href="money.jsp">我的余额</a></label>
                    <%--  <label id="goto-login"><a  href="login.jsp">登录/注册</a></label>--%>
                    <img id="head-image2" ><label><a id="user-name" style="display: none"></a></label>
                </div>
            </div>
        </div>
        <ul class="user-info-message">
            <li id="update-message"><a href="user.jsp">修改资料</a></li>
            <li id="my-order"><a href="order.jsp">我的订单</a></li>
            <li id="my-money"><a href="user.jsp">我的余额</a></li>
            <li id="log-out"><a>退出登录</a></li>
            <li id="hide">隐藏</li>
        </ul>
    </nav>
</div>

<div class="container" style="height:400px;">
    <form id="uploadForm" enctype='multipart/form-data' style="margin-left: 50px;
                                                                     margin-top: 100px;">
        <div class="form-group">
            <div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload">

                <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                <div>
                        <span class="btn btn-primary btn-file">
                            <span class="fileinput-new" style="    margin-left: 15px;">选择文件</span>
                            <input type="file" name="file" id="file" accept="video/*"<%--accept="../image/gif,image/jpeg,image/x-png"--%>/>
                        </span>
                    <a href="javascript:;" id="remove" class="btn btn-warning fileinput-exists" data-dismiss="fileinput">移除</a>
                </div>
            </div>
        </div>
        <button style="
                                margin-top: -105px;
                                margin-left: 130px;
                                color: #fff;
                                background-color: #337ab7;
                                border-color: #2e6da4;" type="button" id="uploadSubmit" class="btn btn-info ">提交</button>
    </form>
    <video id="vedio" height=400 width=600   src="http://localhost:8080/daoshan-school/upload/getVedio/b0bd0229-6932-4e1a-bdd2-baf9f6b7acd7" controls></video>
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
            </div></div></div></div>
</body>


<script id="item-template" type="text/html">
    {{each data as data2}}
    <div class="search-item" data-id="{{data2.id}}">
        <img class="search-img" src="{{data2.pictureAddress}}">
        <div class="course-info"> {{data2.courseName}}</br>道山学海(zt.com)为您提供海量优质课程</div>
    </div>
    {{/each}}
</script>
<script type="text/javascript">
    global.context = "<%=request.getContextPath()%>";
</script>
</html>