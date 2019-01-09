<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/11/26
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>道山学海-余额管理</title>
    <link href="../skins/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="../skins/css/main.css" rel="stylesheet" type="text/css" />
    <link href="../skins/css/pagination.css" rel="stylesheet" type="text/css" />
    <link href="../skins/css/message.css" rel="stylesheet" type="text/css"/>

    <link href="../skins/css/main.css" rel="stylesheet" type="text/css" />
    <link href="../skins/css/search.css" rel="stylesheet" type="text/css"/>

    <script src="../skins/js/jquery.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" src="../skins/js/bootstrap.js"></script>
    <script type="text/javascript" src="../skins/js/arttemplate.js"></script>
    <script type="text/javascript" src="../skins/js/jquery.pagination.js"></script>
    <script type="text/javascript" src="../skins/js/message.min.js"></script>
    <script type="text/javascript" src="../skins/js/money.js"></script>

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
                    <label id="vip"><a href="order.jsp">我的订单</a></label>
                    <label id="vip2"><a href="collect.jsp">我的收藏</a></label>
                    <label id="vip3"><a href="money.jsp">我的余额</a></label>
                    <%--  <label id="goto-login"><a  href="login.jsp">登录/注册</a></label>--%>
                    <img id="head-image2" ><label><a id="user-name" style="display: none"></a></label>
                </div>
            </div>
        </div>
        <ul class="user-info-message">
            <li id="update-message"><a href="user.jsp">修改资料</a></li>
            <li id="my-order"><a href="order.jsp">我的订单</a></li>
            <li id="my-money"><a href="money.jsp">我的余额</a></li>
            <li id="log-out"><a>退出登录</a></li>
            <li id="hide">隐藏</li>
        </ul>
    </nav>
</div>

<div class="container" style="background: #efefef;">
    <ol class="breadcrumb">
        <li><a href="index.jsp">首页</a></li>
        <li><a >余额管理</a></li>
    </ol>
    <div style="    padding-left: 30px;">
    <div id="message" class="search-total" style="color: #e26635;"></div>
    <div  class="money" style="color: #e26635;"><div id= "money"></div><button style="margin-top: -25px;
    float: right;
    margin-left: 20px;
    height: 30px;
    line-height: 10px;" class="btn btn-info" id="show_pay">查看消费记录</button><button style="margin-top: -25px;
    float: right;
    margin-left: 200px;
    height: 30px;
    line-height: 10px;" id="go_chongzhi" class="btn btn-info">充值</button>
    </div>
    </div>

    <div style="height: 500px">
    <div id="controll">
    <div class="my_table" style="    padding-left: 30px;
    padding-right: 30px;">
        <table id="money_table" class="table table-striped">

        </table>
    </div>
    <div  align="right" class="m-style M-box3"></div>
    </div>
    </div>
</div>
<%--模态框声明--%>
<div class="modal fade" id="Mydialog4">
    <%--窗口声明--%>
    <div class="modal-dialog">
        <%--内容声明--%>
        <div class="modal-content" style="    height: 500px;">
            <div class="modal-header">
                <button class="close" data-dismiss="modal"><span>&times;</span></button>
                <div class="modal-title buy-titlt">充值</div>
            </div>
           <div style="    padding: 25px;
    color: #ce2be0;">
               <p>请使用支付宝扫码付款，请备注充值金额，充值账户，稍后管理员会进行处理，将在两个工作日内完成！如未到账请联系管理员178629979628</p>
               <img src="../skins/imge/pay.jpg" style="    width: 200px;
    margin-left: 170px;
">
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
                ©CopyRight 2018-2019  张崇宝 版权所有 17862979628
            </div></div></div></div>

</body>
<script id="money-template" type="text/html">
    <caption>用户消费一览表</caption>
    <thead>
    <tr>
        <th>订单号</th>
        <th>收支类型</th>
        <th>收支原因</th>
        <th>金额</th>
        <th>创建人</th>
        <th>创建时间</th>
    </tr>
    </thead>
    <tbody>
    {{each data as data2}}
    <tr>
        <td>{{data2.billNo}}</td>
        {{if data2.type == 1}}
        <td>消费支出</td>
        <td>{{data2.cause}}</td>
        <td>-{{data2.money}}.00</td>
        {{/if}}
        {{if data2.type == 2}}
        <td>收入</td>
        <td>{{data2.cause}}</td>
        <td>+{{data2.money}}.00</td>
        {{/if}}

        <td>{{data2.createUser}}</td>
        <td>{{data2.time}}</td>
    </tr>
    {{/each}}
    </tbody>
</script>
<script type="text/javascript">
    global.context = "<%=request.getContextPath()%>";
</script>
</html>