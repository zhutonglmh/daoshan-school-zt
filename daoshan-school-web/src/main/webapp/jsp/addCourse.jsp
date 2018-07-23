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
    <title>道山学海-课程管理</title>
    <link href="../skins/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="../skins/css/bootstrap-fileinput.css" rel="stylesheet">
    <link href="../skins/css/main.css" rel="stylesheet" type="text/css"/>
    <link href="../skins/css/pagination.css" rel="stylesheet" type="text/css"/>
    <link href="../skins/css/message.css" rel="stylesheet" type="text/css"/>
    <link href="../skins/css/user.css" rel="stylesheet" type="text/css"/>
    <link href="../skins/css/search.css" rel="stylesheet" type="text/css"/>
    <link href="../skins/css/course.css" rel="stylesheet" type="text/css"/>

    <script type="text/javascript" src="../skins/js/jquery.js"></script>
    <script type="text/javascript" src="../skins/js/bootstrap.js"></script>
    <script type="text/javascript" src="../skins/js/arttemplate.js"></script>
    <script type="text/javascript" src="../skins/js/jquery.pagination.js"></script>
    <script type="text/javascript" src="../skins/js/message.min.js"></script>
    <script type="text/javascript" src="../skins/js/bootstrap-fileinput.js"></script>
    <script type="text/javascript" src="../skins/js/addCourse.js"></script>

</head>

<body>
<div class="myHead">
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a id="my-navbar-brand" class="navbar-brand" href="index.jsp"><span
                        class="glyphicon glyphicon-book"></span>道山学海</a>
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
    <ol class="breadcrumb">
        <li><a href="index.jsp">首页</a></li>
        <li><a >新增课程</a></li>
    </ol>
    <div style="        margin-top: 40px;">
        <form style="margin-bottom: 30px" class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label" style="    line-height: 20px;">课程名称：</label>
                <div class="col-sm-5">
                    <input id="courseName" class="form-control input-sm" type="text" placeholder="课程名称">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">课程所属类别：</label>
                <div class="col-sm-3">
                    <select id="select" class="form-control">
                        <option>前端开发</option>
                        <option>后端开发</option>
                        <option>移动开发</option>
                        <option>数据库</option>
                        <option>云计算&大数据</option>
                        <option>运维&测试</option>
                        <option>视觉设计</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" style="    line-height: 20px;">课程所属技术：</label>
                <div class="col-sm-5">
                    <input id="childre" class="form-control input-sm" type="text" placeholder="如：spring MVC">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" style="    line-height: 20px;">课程原作者：</label>
                <div class="col-sm-5">
                    <input id="zuozhe" class="form-control input-sm" type="text" placeholder="作者">
                </div>
            </div>
            <div class="form-group ">
                <label class="col-sm-2 control-label" >价格：</label>
                <div class="col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon ">￥</div>
                        <input id="prise" type="text" class="form-control" placeholder="请输入课程单价">
                        <div class="input-group-addon">.00元</div>
                    </div>
                </div>
            </div>
        </form>
        <label id="user-image" style="display: block;
    margin-left: 85px;">课程图片展示：</label>
        <form id="uploadForm" enctype='multipart/form-data' style="    margin-left: 212px;
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
        <div>
            <label style="display: block;
    margin-left: 85px;">课程包含章节：</label>
            <button id="show" style="       float: left;
    margin-left: 210px;
    margin-top: -30px;
    margin-bottom: 10px;">添加</button>
            <div class="my_table" style=" padding-left: 210px;
    padding-right: 30px;
    width: 60%;
    margin-top: -30px;
">

            </div>
            <div class="form-group" style="    margin-top: 50px;
    margin-left: 98px;">
                <label class="col-sm-2 control-label" style="    line-height: 20px;">课程介绍：</label>
                <div class="col-sm-5">
                    <input id="message8" style="    margin-left: -100px;" class="form-control input-sm" type="text" placeholder="请输入课程介绍">
                </div>
            </div>
            <div style="    margin-top: 100px;
    margin-left: 200px;
    margin-bottom: 30px;">
                <button id="save2" class="btn btn-info">保存</button>
                <button id="fanhui2" class="btn btn-info">返回</button>
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
<%--模态框声明--%>
<div class="modal fade" id="Mydialog4">
    <%--窗口声明--%>
    <div class="modal-dialog">
        <%--内容声明--%>
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal"><span>&times;</span></button>
                <div class="modal-title buy-titlt">添加章节</div>
            </div>
            <div class="modal-body buy-body">
                <form style="margin-bottom: 30px" class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-4 control-label" style="    line-height: 20px;">章节名称：</label>
                        <div class="col-sm-8">
                            <input id="name" class="form-control input-sm" type="text" placeholder="课程名称">
                        </div>
                    </div>
                </form>
                <label id="user-image2" style="    display: block;
    margin-left: 18px;">课程视频：</label>
                <form id="uploadForm2" enctype='multipart/form-data' style="margin-left: 50px;
                                                                     margin-top: -20px;">
                    <div class="form-group" style="    margin-left: 60px;">
                        <div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload2">
                            <%--<div class="fileinput-new thumbnail" style="width: 200px;height: auto;max-height:150px;">
                                <img id='picImg' style="width: 100%;height: auto;max-height: 140px;" src="../skins/imge/noimage.jpg" alt="" />
                            </div>--%>
                            <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                            <div>
                        <span class="btn btn-primary btn-file">
                            <span class="fileinput-new" style="    margin-left: 15px;">选择文件</span>
                            <span class="fileinput-exists">换一个</span>
                            <input type="file" name="file" id="file2" accept="video/*"<%--accept="../image/gif,image/jpeg,image/x-png"--%>/>
                        </span>
                                <a href="javascript:;" id="remove2" class="btn btn-warning fileinput-exists" data-dismiss="fileinput">移除</a>
                            </div>
                        </div>
                    </div>
                    <button style="
                                margin-top: -105px;
                                margin-left: 190px;
                                color: #fff;
                                background-color: #337ab7;
                                border-color: #2e6da4;" type="button" id="uploadSubmit2" class="btn btn-info ">提交</button>
                </form>

                <div style="    margin-top: 40px;
    padding-left: 110px;">
                    <button id="save" class="btn btn-info">保存</button>
                    <button id="cancel" class="btn btn-info">取消</button>
                </div>
            </div>

        </div>
    </div>
</div>

<script id="item-template" type="text/html">

    <table id="money_table" class="table table-striped">
        <thead>
        <tr>
            <th>章节序号</th>
            <th>章节名称</th>
            <th>章节视频</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        {{each data as data2}}
        <tr data-id = {{data2.address}}>
            <td>第{{data2.no}}章</td>
            <td>{{data2.name}}</td>
            <td>已上传</td>
            <td><button class="add-vedio">添加</button><button id="delete-vedio" class="" data-id="{{data2.no}}">删除</button></td>
        </tr>
        {{/each}}
        </tbody>
    </table>
</script>

</body>
<script type="text/javascript">
    global.context = "<%=request.getContextPath()%>";
</script>
</html>