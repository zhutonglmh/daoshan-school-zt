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
    <meta charset="utf-8"/>
    <title>道山学海-订单管理</title>
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
                    <%--<label id="goto-login"><a  href="login.jsp">登录/注册</a></label>--%>
                    <img id="head-image2"><label><a id="user-name" style="display: none"></a></label>
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

<div class="container">
    <div class="one-zt">
        <div class="my-order">我的订单</div>

        <div class="menus menus2">
            <ul>
                <div class="bg"></div>
                <li><span>全部订单</span></li>
                <li class="my-flag2"><span>未支付 </span></li>
                <li class="my-flag2"><span>已完成</span></li>
                <li><span>退款审核</span></li>
                <li class="my-flag2"><span>已取消</span></li>
                <li><span>已退款</span></li>
            </ul>
            <div class="clear"></div>
            <div class="tab tab1 show" style="background: white;
                                                                   background: white;
                                                                    padding-left: 50px;
                                                                    margin-top: 30px;
                                                                    padding-right: 50px;
                                                                    padding-top: 15px;
                                                                    height: 756px;
margin-bottom: 50px;">
               <table id="one" class="my-table">
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
                   <tbody>

                   </tbody>
               </table>
                <div  align="right" class="m-style M-box3"></div>
            </div>
            <div class="tab tab1" style="background: white;
                                                                   background: white;
                                                                    padding-left: 50px;
                                                                    margin-top: 30px;
                                                                    padding-right: 50px;
                                                                    padding-top: 15px;
                                                                    height: 756px;
margin-bottom: 50px;">
                <table id="two" class="my-table">
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
                    <tbody>

                    </tbody>
                </table>
                <div  align="right" class="m-style M-box4"></div>
            </div>
            <div class="tab tab1" style="background: white;
                                                                   background: white;
                                                                    padding-left: 50px;
                                                                    margin-top: 30px;
                                                                    padding-right: 50px;
                                                                    padding-top: 15px;
                                                                    height: 756px;
margin-bottom: 50px;">
                <table id="three" class="my-table">
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
                    <tbody>

                    </tbody>
                </table>
                <div  align="right" class="m-style M-box5"></div>
            </div>
            <div class="tab tab1" style="background: white;
                                                                   background: white;
                                                                    padding-left: 50px;
                                                                    margin-top: 30px;
                                                                    padding-right: 50px;
                                                                    padding-top: 15px;
                                                                    height: 756px;
margin-bottom: 50px;">
                <table id="four" class="my-table">
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
                    <tbody>

                    </tbody>
                </table>
                <div  align="right" class="m-style M-box6"></div>
            </div>
            <div class="tab tab1" style="background: white;
                                                                   background: white;
                                                                    padding-left: 50px;
                                                                    margin-top: 30px;
                                                                    padding-right: 50px;
                                                                    padding-top: 15px;
                                                                    height: 756px;
margin-bottom: 50px;">
                <table id="five" class="my-table">
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
                    <tbody>

                    </tbody>
                </table>
                <div  align="right" class="m-style M-box7"></div>
            </div>
            <div class="tab tab1" style="background: white;
                                                                   background: white;
                                                                    padding-left: 50px;
                                                                    margin-top: 30px;
                                                                    padding-right: 50px;
                                                                    padding-top: 15px;
                                                                    height: 756px;
margin-bottom: 50px;">
                <table id="six" class="my-table">
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
                    <tbody>

                    </tbody>
                </table>
                <div  align="right" class="m-style M-box8"></div>
            </div>
            <div class="tab tab1" style="background: white;
                                                                   background: white;
                                                                    padding-left: 50px;
                                                                    margin-top: 30px;
                                                                    padding-right: 50px;
                                                                    padding-top: 15px;
                                                                    height: 756px;
margin-bottom: 50px;">
                <table id="fix" class="my-table">
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
                    <tbody>

                    </tbody>
                </table>
                <div  align="right" class="m-style M-box9"></div>
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
                ©CopyRight 2018-2019 张崇宝 版权所有 17862979628
            </div>
        </div>
    </div>
</div>
</body>
<script id="order-template" type="text/html">
    {{each data as data2}}
    <tr data-id={{data2.id}}>
        <td>
            <div class="td-top"><label>{{data2.timeStr}}</label><label style="    margin-left: 20px;">订单号：{{data2.billNo}}</label></div>
            <div class="td-bottom">{{data2.courseName}}</div>
        </td>
        <td >
            {{data2.price}}.00
        </td>
        <td>
            {{data2.priceAmt}}.00
        </td>
        {{if data2.status == 0}}
        <td data-id={{data2.id}} data-course={{data2.courseId}} class="go-to-study">
            <a class="do-main" href="main.jsp?{{data2.courseId}}">去支付</a>
        </td>
        <td data-id={{data2.id}}>
            待支付
        </td>
        <td style="    color: red;">
            购买有效
        </td>
        <td>
            <button data-id={{data2.id}} data-price={{data2.price}}  data-status="3" class="btn btn-info mybtn">取消订单</button>
        </td>
        {{/if}}
        {{if data2.status == 1}}
        <td data-id={{data2.id}} data-course={{data2.courseId}} class="go-to-study">
            <a class="do-main"  href="main.jsp?{{data2.courseId}}">去学习 </a>
        </td>
        <td data-status = {{data2.status}}>
            已完成
        </td>
        <td style="    color: red;">
            永久有效
        </td>
        <td>
            <button data-id={{data2.id}} data-status="2" class="btn btn-info mybtn ">申请退款</button>
        </td>
        {{/if}}
        {{if data2.status == 2}}
        <td data-id={{data2.id}} data-course={{data2.courseId}} class="go-to-study">
            <a class="do-main"  href="main.jsp?{{data2.courseId}}">去学习 </a>
        </td>
        <td>
            审核中
        </td>
        <td style="    color: red;">
            目前有效
        </td>
        <td>
            <button data-id={{data2.id}} data-status="1" class="btn btn-info mybtn my-flag">取消退款</button>
        </td>
        {{/if}}
        {{if data2.status == 3}}
        <td class="go-to-study" data-course={{data2.courseId}}>
            <a class="do-main"  href="main.jsp?{{data2.courseId}}">重新购买 </a>
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
        <td class="go-to-study" data-course={{data2.courseId}}>
            <a class="do-main"  href="main.jsp?{{data2.courseId}}">重新购买 </a>
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
        <td class="go-to-study" data-course={{data2.courseId}}>
            <a class="do-main"  href="main.jsp?{{data2.courseId}}">去学习 </a>
        </td>
        <td>
            退款审核失败
        </td>
        <td style="    color: red;">
            目前有效
        </td>
        <td>
            <button data-id={{data2.id}} data-status="2" class="btn btn-info mybtn">重新提交申请</button>
        </td>
        {{/if}}

    </tr>
    {{/each}}
</script>
<script type="text/javascript">
    global.context = "<%=request.getContextPath()%>";
</script>
</html>