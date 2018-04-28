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
    <link href="../skins/css/pagination.css" rel="stylesheet" type="text/css" />
    <link href="../skins/css/message.css" rel="stylesheet" type="text/css"/>
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
                <input type="text" name="search"  id="search-info" placeholder="输入搜索内容" value="" />
                <label><a  id="search-begin">搜索</a></label>
                <label><a>我的学习</a></label>
                <label><a>我的收藏</a></label>
                <label><a>我的余额</a></label>
                <label><a id="goto-login" href="login.jsp">登录/注册</a></label>
                <label><a id="user-name" style="display: none"></a></label>
            </div>
        </div>
    </div>
</nav>
</div>
<ul class="user-info-message">
    <li id="update-message">修改资料</li>
    <li id="my-order">我的订单</li>
    <li id="my-money">我的余额</li>
    <li id="log-out">退出登录</li>
    <li id="hide">隐藏</li>
</ul>
<div class="container">
<ol class="breadcrumb">
    <li><a id="toIndex" href="index.jsp">首页</a></li>
    <li><a id="toIndex1"></a></li>
    <li><a id="toIndex2"></a></li>
    <li><a id="toIndex3"></a></li>
    <li><a id="toIndex4"></a></li>
</ol>
<iframe id="vedio" height=400 width=600 frameborder=0 allowfullscreen></iframe>
    <div class="message_info">
        <div class="title">
            <label id="course_name"></label>
        </div>
        <div class="handle">
            <span class="glyphicon glyphicon-new-window"></span>
            <span class="glyphicon glyphicon-star-empty"></span>
            <span class="glyphicon glyphicon-star"></span>
        </div>
        <p><span class="glyphicon glyphicon-user">User</span>
            <label id="teacher"></label>
        </p>

        <div class="price">

        </div>
        <p class = "dmeo">本网站视频以开放为本，我们承诺不收取任何费用，不过您可以选择购买课程鼓励作者与我们！我们承诺您的资助只会用于本站建设！</p>
        <div id="my_btns">
            <button class="btn btn-info to-buy" >立即购买</button><%--<button  class="btn btn-info">立即购买</button>--%>
            <button class="btn btn-info">加入收藏</button>
        </div>
    </div>

    <ul class="nav nav-pills my_nav">
        <li class="active"><a class="comments" href="#my_content_one" data-toggle="tab">介绍</a></li>
        <li><a class="comments" href="#my_content_two" data-toggle="tab">目录</a></li>
        <li><a class="comments" href="#my_content_three" data-toggle="tab">笔记</a></li>
        <li><a id = "comments" href="#my_content_four" data-toggle="tab">评论区</a></li>
    </ul>
    <div class = "information">
        <div class="information_top">
            <div id="course_teacher_name" class="child1 child">

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
    <div class="tab-content">

        <div id="my_content_one" class="my_content tab-pane active fade in" >
            <p>标准通用标记语言下的一个应用 HTML 标准自 19 年 12 月发布的 HTML4.01后，后继的 HTML5 和其它标准被束之高阁，为了推动 Web 标准化运动的发展，一些公司联合起来，成立了一个叫做 Web Hypertext Aplication Technolgy Working Group（Web 超文本应用技术工作组 -WHATWG） 的组织。WHATWG 致力于 Web 表单和应用程序，而 W3C（World Wide Web Consortium，万维网联盟） 专注于 XHTML2.0。在 206 年，双方决定进行合作，来创建一个新版本的 HTML。</p>
        </div>
        <div id="my_content_two" class="my_content tab-pane fade" id="bootstrap3">
          <p id = "mulu"> 目录 </p>
            <div id = mulu_content2></div>
        </div>

        <div id="my_content_three" class="my_content tab-pane fade" id="jquery3">
            <p>JQuery 是继 protype 之后又一个优秀的 Javscript 库。它是轻量级的 js库 ，它兼容 CS3，还兼容各种浏览器（IE 6.0+, F 1.5+, Safri 2.0+, Opera 9.0+），jQuery2.0 及后续版本将不再支持 IE6/78 浏览器。jQuery 使用户能更方便地处理 HTML（标准通用标记语言下的一个应用）、evnts、实现动画效果，并且方便地为网站提供 AJX交互。jQuery 还有一个比较大的优势是，它的文档说明很全，而且各种应用也说得很详细，同时还有许多成熟的插件可供选择。jQuery 能够使用户的 html 页面保持代码和 html 内容分离，也就是说，不用再在 html 里面插入一堆 js 来调用命令了，只需要定义 id 即可。</p>
        </div>
        <div id="my_content_four" class="tab-pane fade" id="extjs3">
            <div class="edit_comments">
                <p class="commentss"> 课程评论 </p>
                <div>
                    <textarea class="my_textarea" placeholder="请添加你的评论..."></textarea>
                </div>
                <div class="fa_biao">
                    <button class="btn btn-info btn_comments">发布</button>
                </div>
            </div>
            <div id="temp"></div>
            <div  align="right" class="m-style M-box3"></div>
        </div>

    </div>
    <div class="my_content" id="my_content" >
        <p>标准通用标记语言下的一个应用 HTML 标准自 19 年 12 月发布的 HTML4.01后，后继的 HTML5 和其它标准被束之高阁，为了推动 Web 标准化运动的发展，一些公司联合起来，成立了一个叫做 Web Hypertext Aplication Technolgy Working Group（Web 超文本应用技术工作组 -WHATWG） 的组织。WHATWG 致力于 Web 表单和应用程序，而 W3C（World Wide Web Consortium，万维网联盟） 专注于 XHTML2.0。在 206 年，双方决定进行合作，来创建一个新版本的 HTML。</p>
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
                            <div class="modal-title buy-titlt">课程购买</div>
                        </div>
                        <div class="modal-body buy-body">
                            <p>你要购买的课程为：<label id="label-course-name"></label></p>
                            <p>本次购买所需费用：<label id="label-course-price"></label></p>
                            <p>账户余额：<label id="label-course-amt" >1000.00元</label></p>
                            <p>感谢！</p>
                        </div>
                        <div class="modal-footer">
                            <button id="buy-commit" class="btn btn-info buy-button">确认购买</button>
                            <button id="buy-cancel" class="btn btn-info buy-button">取消</button>
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
<script type="text/javascript" src="../skins/js/arttemplate.js"></script>
<script type="text/javascript" src="../skins/js/jquery.pagination.js"></script>
<script type="text/javascript" src="../skins/js/message.min.js"></script>
<script type="text/javascript" src="../skins/js/main.js"></script>

<script type="text/javascript">
    global.context = "<%=request.getContextPath()%>";
</script>


</body>
<script id="weather" type="text/html">
    <div id = mulu_content>
        {{each data as data}}
        <div class="mulu_title" data-id = {{data.courseId}}>
            <label class="one">课时{{data.number}}</label>
            <label class="two">{{data.name}}</label>
            <label class="three"><span class="glyphicon glyphicon-expand " style="
                     margin-right: 5px;"></span>开始学习</label>
        </div>
        {{/each}}
    </div>
</script>
<script id="comments_children" type="text/html">

    {{each data as data2}}
    <div class="course_comments">
        <div class="image"><img src="../skins/imge/head.jpg"></div>
        <div class="comments_content" data-id="{{data2.id}}">
            <div class="comment_head" >{{data2.createUserName}}</div>
            <div class="comment_mid">{{data2.commentMessage}}</div>
            <div class="comment_bottom"><a class="comments_time" >{{data2.createTimeStr}}</a><a class="comments_one glyphicon glyphicon-thumbs-up">顶（{{data2.commentLoves}}）</a><a class="comments_two glyphicon glyphicon-thumbs-down">踩（{{data2.commentHates}}）</a><a class="comments_three glyphicon glyphicon-edit" data-flag="no">评论（{{data2.commentsList.length}}）</a><a class="comments_four glyphicon glyphicon-new-window">收藏</a></div>
            <div class="comments_children">
                {{each data2.commentsList as data3}}
                <div class="child1_comments"  data-id="{{data3.id}}">
                    <div class="image_child_image"><img src="../skins/imge/childHead.jpg"></div>
                    <div class="comments_child_message">
                        <div class="comments_child_head">{{data3.createUserName}}<span>{{data3.createTimeStr}}</span></div>
                        <div class="comments_child_content">{{data3.commentMessage}}</div></div>
                </div>
                {{/each}}
                <div>
                    <textarea id="my_textarea_child" class="my_textarea_child" placeholder="请添加你的评论..."></textarea>
                </div>
                <div class="fa_biao_child">
                    <button class="btn btn-info btn_comments_child">发布</button>
                </div>
            </div>
        </div>
    </div>
    {{/each}}

</script>
<script id="comments_children2" type="text/html">
{{each data as data3}}
<div class="child1_comments"  data-id="{{data3.id}}">
    <div class="image_child_image"><img src="../skins/imge/childHead.jpg"></div>
    <div class="comments_child_message">
        <div class="comments_child_head">{{data3.createUserName}}<span>{{data3.createTimeStr}}</span></div>
        <div class="comments_child_content">{{data3.commentMessage}}</div></div>
</div>
{{/each}}
<div>
    <textarea id="my_textarea_child2" class="my_textarea_child" placeholder="请添加你的评论..."></textarea>
</div>
<div class="fa_biao_child">
    <button class="btn btn-info btn_comments_child">发布</button>
</div>

</script>
</html>
