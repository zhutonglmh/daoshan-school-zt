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
    <meta charset="utf-8"/>
    <title></title>
    <link href="../skins/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="../skins/css/main.css" rel="stylesheet" type="text/css"/>
    <link href="../skins/css/pagination.css" rel="stylesheet" type="text/css"/>
    <link href="../skins/css/message.css" rel="stylesheet" type="text/css"/>
    <link href="../skins/css/search.css" rel="stylesheet" type="text/css"/>
    <link href="../skins/css/tabNav.css" rel="stylesheet" type="text/css"/>
    <link href="../skins/css/order.css" rel="stylesheet" type="text/css"/>

    <script src="../skins/js/jquery.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" src="../skins/js/bootstrap.js"></script>
    <script type="text/javascript" src="../skins/js/arttemplate.js"></script>
    <script type="text/javascript" src="../skins/js/jquery.pagination.js"></script>
    <script type="text/javascript" src="../skins/js/message.min.js"></script>
    <script type="text/javascript" src="../skins/js/order.js"></script>
    <script type="text/javascript" src="../skins/js/tabNav.js"></script>

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
                    <label><a id="goto-login" href="login.jsp">登录/注册</a></label>
                    <img id="head-image2" src="../skins/imge/prictise5.jpg"><label><a id="user-name"
                                                                                      style="display: none"></a></label>
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

<div class="container">
    <div class="one-zt">
        <div class="my-order">我的订单</div>

        <div class="menus menus2">
            <ul>
                <div class="bg"></div>
                <li><span>全部订单</span></li>
                <li><span>退购审核</span></li>
                <li><span>交易成功</span></li>
                <li><span>撤销交易</span></li>
            </ul>
            <div class="clear"></div>
            <div class="tab tab1 show" style="background: white;
                                                                   background: white;
                                                                    padding-left: 50px;
                                                                    margin-top: 30px;
                                                                    padding-right: 50px;
                                                                    padding-top: 15px;
                                                                    height: 756px;">
               <table class="my-table">
                   <thead>
                    <th class="table-one">
                        订单信息
                    </th>
                    <th class="table-two">
                        单价(元)
                    </th>
                    <th class="table-three">
                        实付金额(元)
                    </th>
                    <th class="table-four">
                        课程操作
                    </th>
                    <th class="table-five">
                        交易状态
                    </th>
                    <th class="table-six">
                        有效时间
                    </th>
                    <th class="table-seven">
                        交易操作
                    </th>
                   </thead>
                   <tr>
                       <td>
                           <div class="td-top"><label>2018-05-10 19:28</label><label style="    margin-left: 20px;">订单号：1007364857</label></div>
                           <div class="td-bottom">方糖全栈课·PHP+React大系</div>
                       </td>
                       <td>
                           2980
                       </td>
                       <td>
                           2980
                       </td>
                       <td class="go-to-study">
                           去学习
                       </td>
                       <td>
                           支付成功
                       </td>
                       <td style="    color: red;">
                           永久有效
                       </td>
                       <td>
                           <button class="btn btn-info mybtn">申请退款</button>
                       </td>
                   </tr>
                   <tr>

                       <td>
                           <div class="td-top"><label>2018-05-10 19:28</label><label style="    margin-left: 20px;">订单号：1007364857</label></div>
                           <div class="td-bottom">方糖全栈课·PHP+React大系</div>
                       </td>
                       <td>
                           2980
                       </td>
                       <td>
                           2980
                       </td>
                       <td class="go-to-study">
                           去学习
                       </td>
                       <td>
                           支付成功
                       </td>
                       <td style="    color: red;">
                           永久有效
                       </td>
                       <td>
                           <button class="btn btn-info mybtn">申请退款</button>
                       </td>
                   </tr>
                   <tr>

                       <td>
                           <div class="td-top"><label>2018-05-10 19:28</label><label style="    margin-left: 20px;">订单号：1007364857</label></div>
                           <div class="td-bottom">方糖全栈课·PHP+React大系</div>
                       </td>
                       <td>
                           2980
                       </td>
                       <td>
                           2980
                       </td>
                       <td class="go-to-study">
                           去学习
                       </td>
                       <td>
                           支付成功
                       </td>
                       <td style="    color: red;">
                           永久有效
                       </td>
                       <td>
                           <button class="btn btn-info mybtn">申请退款</button>
                       </td>
                   </tr>
                   <tr>

                       <td>
                           <div class="td-top"><label>2018-05-10 19:28</label><label style="    margin-left: 20px;">订单号：1007364857</label></div>
                           <div class="td-bottom">方糖全栈课·PHP+React大系</div>
                       </td>
                       <td>
                           2980
                       </td>
                       <td>
                           2980
                       </td>
                       <td class="go-to-study">
                           去学习
                       </td>
                       <td>
                           支付成功
                       </td>
                       <td style="    color: red;">
                           永久有效
                       </td>
                       <td>
                           <button class="btn btn-info mybtn">申请退款</button>
                       </td>
                   </tr>
                   <tr>

                       <td>
                           <div class="td-top"><label>2018-05-10 19:28</label><label style="    margin-left: 20px;">订单号：1007364857</label></div>
                           <div class="td-bottom">方糖全栈课·PHP+React大系</div>
                       </td>
                       <td>
                           2980
                       </td>
                       <td>
                           2980
                       </td>
                       <td class="go-to-study">
                           去学习
                       </td>
                       <td>
                           支付成功
                       </td>
                       <td style="    color: red;">
                           永久有效
                       </td>
                       <td>
                           <button class="btn btn-info mybtn">申请退款</button>
                       </td>
                   </tr>
               </table>
                <div  align="right" class="m-style M-box3"></div>
            </div>
            <div class="tab tab1">
                tab2
            </div>
            <div class="tab tab1">
                tab3
            </div>
            <div class="tab tab1">
                tab4
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
</body>
<script id="order-template" type="text/html">
    {{each data as data2}}
    <tr>
        <td>
            <div class="td-top"><label>2018-05-10 19:28</label><label style="    margin-left: 20px;">订单号：1007364857</label></div>
            <div class="td-bottom">方糖全栈课·PHP+React大系</div>
        </td>
        <td>
            2980
        </td>
        <td>
            2980
        </td>
        {{if data2.status == 0}}
        <td class="go-to-study">
            去支付
        </td>
        <td>
            待支付
        </td>
        <td style="    color: red;">
            购买有效
        </td>
        <td>
            <button class="btn btn-info mybtn">取消订单</button>
        </td>
        {{/if}}
        {{if data2.status == 1}}
        <td class="go-to-study">
            去学习
        </td>
        <td>
            已完成
        </td>
        <td style="    color: red;">
            永久有效
        </td>
        <td>
            <button class="btn btn-info mybtn">申请退款</button>
        </td>
        {{/if}}
        {{if data2.status == 2}}
        <td class="go-to-study">
            去学习
        </td>
        <td>
            审核中
        </td>
        <td style="    color: red;">
            永久有效
        </td>
        <td>
            <button class="btn btn-info mybtn">取消退款</button>
        </td>
        {{/if}}
        {{if data2.status == 3}}
        <td class="go-to-study">
            重新购买
        </td>
        <td>
            已取消
        </td>
        <td style="    color: red;">
            需重新下单
        </td>
        <td>
            <%--<button class="btn btn-info mybtn">取消退款</button>--%>
        </td>
        {{/if}}

        {{if data2.status == 4}}
        <td class="go-to-study">
            重新购买
        </td>
        <td>
            已退款
        </td>
        <td style="    color: red;">
            需重新购买
        </td>
        <td>
            <%--<button class="btn btn-info mybtn">取消退款</button>--%>
        </td>
        {{/if}}

        {{if data2.status == 5}}
        <td class="go-to-study">
            去学习
        </td>
        <td>
            退款审核失败
        </td>
        <td style="    color: red;">
            永久有效
        </td>
        <td>
            <button class="btn btn-info mybtn">重新提交申请</button>
        </td>
        {{/if}}

    </tr>
    {{/each}}
</script>
<script type="text/javascript">
    global.context = "<%=request.getContextPath()%>";
</script>
</html>