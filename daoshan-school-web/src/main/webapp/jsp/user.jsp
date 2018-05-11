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
    <link href="../skins/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="../skins/css/bootstrap-fileinput.css" rel="stylesheet">
    <link href="../skins/css/main.css" rel="stylesheet" type="text/css"/>
    <link href="../skins/css/pagination.css" rel="stylesheet" type="text/css"/>
    <link href="../skins/css/message.css" rel="stylesheet" type="text/css"/>
    <link href="../skins/css/user.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<div class="myHead">
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a id="my-navbar-brand" class="navbar-brand" href="#"><span class="glyphicon glyphicon-book"></span>道山学海</a>
            </div>
            <div>
                <div id="myNav" class="nav navbar-nav" style="line-height: 60px; color: #44f30c;margin-left: 60px;">
                    爱学习&nbsp;&nbsp;不设限&nbsp;&nbsp;我们与你同在！
                </div>
                <div id="search">
                    <input type="text" name="search" id="search-info" placeholder="输入搜索内容" value=""/>
                    <label><a id="search-begin">搜索</a></label>
                    <label><a>我的学习</a></label>
                    <label><a>我的收藏</a></label>
                    <label><a>我的余额</a></label>
                    <label id="goto-login"><a  href="login.jsp">登录/注册</a></label>
                    <img id="head-image2" src="../skins/imge/prictise5.jpg"><label><a id="user-name" style="display: none"></a></label>
                </div>
            </div>
        </div>
        <ul class="user-info-message">
            <li id="update-message"><a href="user.jsp">修改资料</a></li>
            <li id="my-order"><a href="user.jsp">我的订单</a></li>
            <li id="my-money"><a href="user.jsp">我的余额</a></li>
            <li id="log-out"><a href="user.jsp">退出登录</a></li>
            <li id="hide">隐藏</li>
        </ul>
    </nav>
</div>
<div class="user-info">
    <div class="container">
        <ol class="breadcrumb">
            <li><a id="toIndex" href="index.jsp">首页</a></li>
            <li><a id="toIndex1">个人中心</a></li>
            <li><a id="toIndex2">基本资料</a></li>
        </ol>
        <div class="info-message">
            <label class="label-one">完善个人资料是让别人认识你的第一步</label>
            <div class="base-info">基本信息</div>
            <div class="info-one">
                <label>昵称</label><input id="user-name-1" class="user-name" type="text" name="search" placeholder="请输入昵称" value=""/><span id="message1" class="errormesg" style="display: none">输入昵称有误，不得包含特殊字符！</span><span id="message2" class="errormesg" style="display: none">该昵称符合规则可以使用</span><br>
                <label id="user-image" style="margin-top: 30px;">头像</label>
                <form id="uploadForm" enctype='multipart/form-data' style="margin-left: 50px;
                                                                     margin-top: -20px;">
                    <div class="form-group">
                        <div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload">
                            <div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                                <img id='picImg' style="width: 100%;height: auto;max-height: 140px;" src="../skins/imge/noimage.jpg" alt="" />
                            </div>
                            <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                            <div>
                        <span class="btn btn-primary btn-file">
                            <span class="fileinput-new" style="    margin-left: 15px;">选择文件</span>
                            <span class="fileinput-exists">换一张</span>
                            <input type="file" name="file" id="file" accept="image/*"<%--accept="../image/gif,image/jpeg,image/x-png"--%>/>
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

                <div style="margin-top: 30px;">
                    <label style="    color: rgb(102, 102, 102);font-size: 14px;
                                    font-family: 微软雅黑;
                                    font-weight: 400;
                                    padding: 0px 20px 0px 0px;">性别</label>
                    <div class="radio" id="sex" style=" margin-top: -30px;
    margin-left: 50px;">
                        <label>
                            <input class="user-sex" name="sex" type="radio"  value="男"/>
                        </label><span>男</span>
                        <label>
                            <input class="user-sex" name="sex" type="radio" value="女"/>
                        </label><span>女</span>
                        <label>
                            <input class="user-sex" name="sex" type="radio" checked="checked" value="保密"/>
                        </label><span>保密</span>
                    </div>
                </div>
                <div style="margin-top: 30px;">
                    <div  style=" color: rgb(102, 102, 102);
                            font-size: 14px;
                            font-family: 微软雅黑;
                            font-weight: 400;
                            padding: 0px 20px 0px 0px;
                            margin-left: -30px;">详细介绍</div>
                    <textarea class="user-info-textarea" placeholder="用一段话介绍你自己，会在你的个人页面显示，最多输入80字"></textarea>
                </div>
            </div>
            <div class="relation-info" >联系信息</div>
           <div class="label-two-div">
               <div class="label-name" id="label-name">真实姓名</div>
               <div class="label-right">
                   <div class="label-right-top">
                       <input id="input-name" placeholder="请输入您的姓名" type="text"> <span id="message3" class="errormesg" style="display: none">输入姓名有误，不得包含特殊字符！</span><span id="message4" class="errormesg" style="display: none">符合规则</span><br>
                   </div>
                   <div class="label-right-bottom">用于高等教育课程证书登记与发放，不会以任何形式向第三方透露</div>
               </div>
           </div>

            <div class="label-two-div">
                <div class="label-name" id="emailaddress">常用邮箱</div>
                <div class="label-right">
                    <div class="label-right-top" id="add-email" style="display: none">
                        <input id="email-input" type="text" placeholder="请输入您的邮箱"> <span id="cancel-update">取消修改</span> <span id="message5" class="errormesg" style="display: none">邮箱格式不正确</span><span id="message6" class="errormesg" style="display: none">格式正确</span>
                        <div class="check-card"><input id="email-caode" type="text" placeholder="请输入验证码"><button id="checkEmail" class=" btn btn-info mybutton2">发送验证码</button> <button class="btn mybutton2 btn-info" id="checkEmail-2" disabled="disabled">验证</button></div>
                    </div>
                    <div class="label-right-top" id="upd-email">
                        <label style="    margin-right: 10px;color: #1aa939;">shandongsunzhi@126.com</label><button id="update-email" class="btn btn-info mybutton2">修改</button>
                    </div>
                    <div class="label-right-bottom">用于接收来自平台和课程的邮件通知，非常重要</div>
                </div>
            </div>

            <div class="label-two-div">
                <div class="label-name" id="user-iphone">手机号码</div>
                <div class="label-right">
                    <div class="label-right-top" id="iphone-add" style="display: none">
                        <button id="add-iphone" class="btn btn-info mybutton2" >添加</button>
                    </div>
                    <div id="iphone-update" class="label-right-top" >
                        <label style="    margin-right: 10px;color: #1aa939;">17862979628</label><button id="update-iphone" class="btn btn-info mybutton2">修改</button>
                    </div>
                    <div class="label-right-bottom">用于优质课程的学习提醒等服务，手机号不会对外公开，请放心</div>
                </div>
            </div>

            <div class="label-two-div">
                <div class="label-name" id="qq-number-2">QQ号码</div>
                <div class="label-right">
                    <div class="label-right-top">
                        <input id="QQ-number" type="text"> <label id="message7" style="display: none">格式正确</label> <label style="display: none" id="message8">qq号码格式不正确</label>
                    </div>
                    <div class="label-right-bottom">用于课程的高效交流、方便机构及老师答疑解惑</div>
                </div>
            </div>
            <div class="save" >
                <button id="save" class="btn mybutton2 btn-info">保存</button>
                <a href="../jsp/index.jsp" class="btn mybutton2 btn-info">返回</a>
            </div>
        </div>
    </div>
</div>

<%--模态框声明--%>
<div class="modal fade" id="Mydialog4">
    <%--窗口声明--%>
    <div class="modal-dialog">
        <%--内容声明--%>
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal"><span>&times;</span></button>
                <div class="modal-title buy-titlt">绑定手机</div>
            </div>
            <div class="modal-body buy-body">
                <div class="modal-one"> <div class="glyphicon glyphicon-phone"></div><input id="iphone-input" type="text" placeholder="请输入手机号码"></div>
                <div class="modal-two"><div class="glyphicon glyphicon-envelope"></div><input id="getted" type="text" placeholder="请输入验证码"><button id="get-card">获取验证码</button></div>
                <div class="modal-three" style="display: none"></div>
                <button class="modal-four" id="check-iphone">完成</button>
            </div>
        </div>
    </div>
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
                ©CopyRight 2018-2019 朱同 版权所有 17862979628
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="../skins/js/jquery.js"></script>
<script type="text/javascript" src="../skins/js/bootstrap.js"></script>
<script type="text/javascript" src="../skins/js/message.min.js"></script>
<script type="text/javascript" src="../skins/js/bootstrap-fileinput.js"></script>
<script type="text/javascript" src="../skins/js/user.js"></script>
<script type="text/javascript">
    global.context = "<%=request.getContextPath()%>";
</script>
</body>
</html>