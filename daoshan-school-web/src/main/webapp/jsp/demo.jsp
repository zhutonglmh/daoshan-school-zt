<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/11/21
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%--以移动为优先   整合手机端--%>
   <meta name="viewport" content="width=device-width, intial-scale=1,maximu-scale=1, user-scalble=no">
    <title>CSS练习</title>
    <link href="../skins/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <style>
        .a {
            height: 50px;
            background: royalblue;
            border: 1px solid darkgrey;
        }
        h1{
            background: red;
        }
    </style>
</head>
<body style="margin: 100px">
<%----%>
<button class="btn btn-info">张崇宝</button>
    <p>Bootstrap框架</p>
    <p>Bootstrap框架</p>
    <p>Bootstrap框架</p>
    <p>Bootstrap框架</p>
<div>
    <h1>标题</h1>
    <h2><small>标题</small></h2>
    <h3><small>标题</small></h3>
    <h4>标题</h4>
    <h5>标题</h5>
    <h6>标题</h6>
</div>
<%--只是想定义一个效果的话用span--%>
<span class="h1">标题</span>
<%--列表排版--%>
<ul class="list-unstyled list-inline">
    <li>横向li标签</li>
    <li>BootStrap框架</li>
    <li>BootStrap框架</li>
    <li>BootStrap框架</li>
    <li>BootStrap框架</li>
</ul>
<%--内联文本元素--%>
<div>
    <p><mark>MARK</mark></p>
    <P><DEL>删除</DEL></P>
    <P><ins>插入</ins></P>
    <p><u>下划线</u></p>
    <p><strong>加粗</strong></p>
    <p><em>倾斜</em></p>
    <p class="text-left">左对齐</p>
    <p class="text-center">居中</p>
    <p class="text-right">右对齐</p>
    <p class="text-nowrap">不换行</p>
    <h1><abbr class="initialism">全大写bootstarp</abbr></h1>
    <address>地址</address>
</div>
<div>
    <p>引用文本</p>
    <blockquote>引用文本</blockquote>
    <blockquote class="blockquote-reverse">引用文本</blockquote>
    <blockquote class="pull-right">引用文本</blockquote>
</div>
<div>
    <p>dl使用  标题  内容</p>
    <dl>
        <dt>标题</dt>
        <dd>这是内容 哈哈哈哈哈</dd>
    </dl>
    <dl class="dl-horizontal">
        <dt>标题</dt>
        <dd>这是内容 哈哈哈哈哈</dd>
    </dl>
</div>
<p>代码</p>
<code>ssssssss</code>
<pre>hen duo de  dai ma</pre>
<h1 style="background: red">表格和按钮</h1>

<table class="table table-striped table-hover">
    <thead>BootStrap 表格样式</thead>
    <tbody>
        <tr class="sr-only">
            <td>表格</td>
            <td>表格</td>
            <td>表格</td>
            <td>表格</td>
        </tr>
        <tr>
            <td>表格</td>
            <td>表格</td>
            <td>表格</td>
            <td>表格</td>
        </tr>
        <tr>
            <td>表格</td>
            <td>表格</td>
            <td>表格</td>
            <td>表格</td>
        </tr>
        <tr>
            <td>表格</td>
            <td>表格</td>
            <td>表格</td>
            <td>表格</td>
        </tr>
    </tbody>
</table>
<pre>响应式表格在body中加 .table-responsive</pre>
<a href="#" class="btn btn-default">a标签按钮</a>
<a href="#" class="btn btn-info">btn-info</a>
<a href="#" class="btn btn-success">btn-success</a>
<input type="button" class="btn btn-default">
<button class="btn btn-default">btn-default</button>
<button class="btn btn-info">btn-info</button>
<button class="btn btn-info btn-lg">btn-lg</button>
<button class="btn btn-info btn-xs">btn-xs</button>
<button class="btn btn-info btn-sm">btn-sm</button>
<button class="btn btn-info btn-block">btn-block</button>
<button class="btn btn-info btn-block">可用active</button>
<button class="btn btn-info btn-block disabled">不可用active</button>
<p></p>
<p></p>
<h1 style="background: red">表单和图片部分</h1>
<pre>表单样式</pre>
<form style="margin-bottom: 30px">
    <div class="form-group">
    <label>电子邮件</label><input class="form-control" type="email" placeholder="form-control">
    </div>
    <div class="form-group">
    <label>电子邮件</label><input class="form-control" type="password" placeholder="请输入您的密码">
    </div>
    <div class="form-group">
        <label>电子邮件</label><input class="form-control" type="email" placeholder="请输入您的电子邮件">
    </div>
</form>
<pre>内联表单 使所有的表单内元素横向</pre>
<form class="form-inline" style="margin-bottom: 30px">
    <div class="form-group">
        <label>电子邮件</label><input class="form-control" type="email" placeholder="form-control">
    </div>
    <div class="form-group">
        <label>电子邮件</label><input class="form-control" type="password" placeholder="请输入您的密码">
    </div>
    <div class="form-group">
        <label>电子邮件</label><input class="form-control" type="email" placeholder="请输入您的电子邮件">
    </div>
</form>

<pre>表单合组</pre>
    <form style="margin-bottom: 30px" class="form-horizontal">
        <div class="form-group has-success has-feedback">
            <label class="col-sm-2 control-label">电子邮件</label>
            <div class="col-sm-9">
            <input class="form-control input-lg" type="email" placeholder="是可以校验状态的哦 如右边">
                <span class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>
        </div>
        <div class="form-group has-error has-feedback">
            <label class="col-sm-2 control-label" >电子邮件</label>
            <div class="col-sm-9">
                <input class="form-control input-sm" type="email" placeholder="form-control">
                <span class="glyphicon glyphicon-eye-close form-control-feedback"></span>
            </div>
        </div>
        <div class="form-group ">
            <label class="col-sm-2 control-label" >价格</label>
            <div class="col-sm-9">
                    <div class="input-group">
                        <div class="input-group-addon ">￥</div>
                            <input type="text" class="form-control" placeholder="form-control">
                         <div class="input-group-addon">.00</div>
                    </div>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">复选框</label>
            <div class="col-sm-9">
               <%-- <div class="checkbox"> <input type="checkbox" value="苹果" name="apple">竖装</div>--%>
                   <label class="checkbox-inline disabled"><input type="checkbox" value="香蕉" name="banana" disabled="disabled">香蕉</label>
                   <label class="checkbox-inline"><input type="checkbox" value="梨" name="li">梨</label>
                   <label class="checkbox-inline"><input type="radio" value="梨" name="li">梨</label>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">下拉列表</label>
            <div class="col-sm-9">
                <select class="form-control">
                    <option>下拉列表</option>
                    <option>下拉列表</option>
                    <option>下拉列表</option>
                    <option>下拉列表</option>
                    <option>下拉列表</option>
                </select>
            </div>
        </div>
    </form>
<pre>
    添加图片三种形状
</pre>
<div>
    <img src="../skins/imge/p02.jpg" alt="" class="img-rounded">
    <img src="../skins/imge/p02.jpg" alt="" class="img-circle">
    <img src="../skins/imge/p02.jpg" alt="" class="img-thumbnail img-responsive">
</div>
<h1>栅格系统</h1>
<p></p>
<p></p>
<div class="container" style="background: darkgrey">
    <div class="row">
        <div class="col-md-1 a">1</div>
        <div class="col-md-1 a">1</div>
        <div class="col-md-1 a">1</div>
        <div class="col-md-1 a">1</div>
        <div class="col-md-1 a">1</div>
        <div class="col-md-1 a">1</div>
        <div class="col-md-1 a">1</div>
        <div class="col-md-1 a">1</div>
        <div class="col-md-1 a">1</div>
        <div class="col-md-1 a">1</div>
        <div class="col-md-1 a">1</div>
        <div class="col-md-1 a">1</div>
    </div>
    <div class="row">
        <div class="col-md-9 a">9</div>
        <div class="col-md-3 a">3</div>
    </div>
    <div class="row">
        <div class="col-sm-6 col-md-4 col-lg-3 a">4</div>
        <div class="col-sm-6 col-md-4 col-lg-3 a">4</div>
        <div class="col-sm-6 col-md-4 col-lg-3 a">4</div>
        <div class="col-sm-6 col-md-4 col-lg-3 a">4</div>
    </div>
</div>
<h1>辅助类和自适应工具</h1>
<p class="text-muted">text-muted柔和灰</p>
<p class="text-primary">text-primary主要蓝</p>
<p class="text-success">text-success成功绿</p>
<p class="text-info">text-info信息蓝</p>
<p class="text-warning">text-warning警告黄</p>
<p class="text-danger">text-danger危险红</p>
<pre>背景色</pre>
<p class="bg-muted">bg-muted柔和灰</p>
<p class="bg-primary">bg-primary主要蓝</p>
<p class="bg-success">bg-success成功绿</p>
<p class="bg-info">bg-info信息蓝</p>
<p class="bg-warning">bg-warning警告黄</p>
<p class="bg-danger">bg-danger危险红</p>
<pre>关闭按钮</pre>
<button class="close">&times;</button>
<pre>浮动</pre>
<div class="pull-left">左边浮动</div>
<div class="pull-right">右边浮动</div>
<div class="center-block">中间</div>

<div class="pull-left">清除浮动</div>
<div class="clearfix"></div>
<div class="pull-right">清除浮动</div>
<pre>响应式隐藏显示</pre>
<div class="visible-xs-block a">超小显示</div>
<div class="visible-lg-block a">大屏幕显示</div>
<div class="hidden-lg a">大屏幕隐藏</div>
<div class="hidden-xs a">超小隐藏</div>
<h1>图标菜单等组件工具</h1>
<pre>图标<a href="http://v3.bootcss.com/components/#glphions">http://v3.bootcss.com/components/#glphions</a></pre>
<span class="glyphicon glyphicon-star"></span>
<span class="glyphicon glyphicon-star-empty"></span>
<button class="btn btn-info glyphicon glyphicon-star-empty"></button>
<p></p>
<pre>下拉菜单</pre>
<div class="dropdown"><%--必须有--%>
    <button class="btn btn-default" data-toggle="dropdown">下拉菜单
        <span class="caret"></span>
    </button>
    <ul class="dropdown-menu">
        <li><a href="">下拉列表一</a></li>
        <li><a href="">下拉列表二</a></li>
        <li><a href="">下拉列表三</a></li>
        <li><a href="">下拉列表四</a></li>
    </ul>
</div>
<p></p>
<pre>上拉菜单dropup</pre>
<div class="dropup"><%--必须有--%>
    <button class="btn btn-default" data-toggle="dropdown">下拉菜单
        <span class="caret"></span>
    </button>
    <ul class="dropdown-menu">
        <li><a href="">下拉列表一</a></li>
        <li><a href="">下拉列表二</a></li>
        <li><a href="">下拉列表三</a></li>
        <li><a href="">下拉列表四</a></li>
    </ul>
</div>
<p></p>
<pre>设置选择标题  以及分割线  不可用选项等</pre>
<div class="dropdown">
    <a class="btn btn-default" data-toggle="dropdown">效果下拉框<span class="caret"></span></a>
    <ul class="dropdown-menu">
        <li class="dropdown-header">标题头</li>
        <li><a>正常枚举</a></li>
        <li class="divider"><a>设置分割线</a></li>
        <li class="disabled"><a>设置不可用</a></li>
    </ul>
</div>
<p></p>
<pre>按钮组组件</pre>
<button class="btn btn-info">左</button>
<button class="btn btn-info">中</button>
<button class="btn btn-info">右</button>
<pre>btn-group</pre>
<div class="btn-group">
    <button class="btn btn-info">左</button>
    <button class="btn btn-info">中</button>
    <button class="btn btn-info">右</button>
</div>
<pre>嵌套一个分组  例如嵌套一个下拉菜单</pre>
<div class="btn-group">
    <button class="btn btn-info">左</button>
    <button class="btn btn-info">中</button>
    <button class="btn btn-info">右</button>
    <div class="btn-group">
        <button class="btn btn-info dropdown-toggle" data-toggle="dropdown">下拉菜单
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
            <li><a href="">下拉列表一</a></li>
            <li><a href="">下拉列表二</a></li>
            <li><a href="">下拉列表三</a></li>
            <li><a href="">下拉列表四</a></li>
        </ul>
    </div>
</div>
<pre>垂直排列</pre>
<div class="btn-group-vertical">
    <button class="btn btn-info">左</button>
    <button class="btn btn-info">中</button>
    <button class="btn btn-info">右</button>
</div>
<p></p>
<pre>实现占满一行a justified</pre>
<div class="btn-group-justified"><%--button不行 a 行--%>
    <a class="btn btn-info">左</a>
    <a class="btn btn-info">中</a>
    <a class="btn btn-info">右</a>
</div>
<p></p>
<pre>实现button占满一行 justified 大btn-group包含每一个button占用一个btn-group</pre>
<div class="btn-group-justified"><%--button不行 a 行--%>
    <div class="btn-group">
    <button class="btn btn-info">左</button>
    </div>
    <div class="btn-group">
    <button class="btn btn-info">中</button>
    </div>
    <div class="btn-group">
    <button class="btn btn-info">右</button>
    </div>
</div>
<p></p>
<pre>分裂式下拉菜单</pre>
<div class="btn-group">
<button class="btn btn-info disabled">下拉菜单</button>
<button class="btn btn-info dropdown-toggle" data-toggle="dropdown">
    <span class="caret"></span>
</button>

<ul class="dropdown-menu">
    <li><a href="">下拉列表一</a></li>
    <li><a href="">下拉列表二</a></li>
    <li><a href="">下拉列表三</a></li>
    <li><a href="">下拉列表四</a></li>
</ul>
</div>
<br>
<h1>输入框和导航组件</h1>
<pre>输入框</pre>
<div class="input-group">
    <span class="input-group-addon">$</span>
    <input type="text" class="form-control" placeholder="输入框样式">
</div>
<br>
<div class="input-group">
    <input type="text" class="form-control" placeholder="在两侧添加文字">
    <span class="input-group-addon">@163.com</span>
</div>
<br>
<div class="input-group">
    <span class="input-group-addon">@</span>
    <input type="text" class="form-control" placeholder="在两侧添加文字">
    <span class="input-group-addon">@163.com</span>
</div>
<br>
<div class="input-group">
    <input type="text" class="form-control">
    <span class="input-group-addon"><input type="radio">男</span>
</div>
<br>
<div class="input-group">
    <span class="input-group-addon"><input type="checkbox">男</span>
    <input type="text" class="form-control">
</div>
<br>
<div class="input-group">
    <input type="text" class="form-control" placeholder="整合下拉菜单">
    <div class="input-group-btn dropdown" >
        <button class="btn btn-default" data-toggle="dropdown">下拉菜单
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
            <li><a href="">下拉列表一</a></li>
            <li><a href="">下拉列表二</a></li>
            <li><a href="">下拉列表三</a></li>
            <li><a href="">下拉列表四</a></li>
        </ul>
    </div>
</div>
<br>
<pre>导航条  导航栏 实现方式nav nav-tabs</pre>
<ul class="nav nav-tabs">
    <li class="active"><a href="#">首页</a></li>
    <li><a href="#">咨询</a></li>
    <li><a href="#">产品</a></li>
    <li><a href="#">关于</a></li>
</ul>
<br>
<pre>胶囊式 nav nav-pills</pre>
<ul class="nav nav-pills">
    <li class="active"><a href="">首页</a></li>
    <li><a href="#">咨询</a></li>
    <li><a href="#">产品</a></li>
    <li><a href="#">关于</a></li>
</ul>
<br>
<pre>两端对齐式nav nav-justified</pre>
<ul class="nav nav-justified">
    <li class="active"><a href="">首页</a></li>
    <li><a href="#">咨询</a></li>
    <li><a href="#">产品</a></li>
    <li><a href="#">关于</a></li>
</ul>
<br>
<pre>垂直式nav nav-divider</pre>
<ul class="nav nav-divider">
    <li class="active"><a href="">首页</a></li>
    <li><a href="#">咨询</a></li>
    <li><a href="#">产品</a></li>
    <li><a href="#">关于</a></li>
</ul>
<br>
<pre>带有下拉菜单的</pre>
<ul class="nav nav-tabs">
    <li class="active"><a href="">首页</a></li>
    <li><a href="#">咨询</a></li>
    <li><a href="#">产品</a></li>
    <li>
        <a href="#" class="dropdown" data-toggle="dropdown">关于
            <span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            <li><a href="">下拉列表一</a></li>
            <li><a href="">下拉列表二</a></li>
            <li><a href="">下拉列表三</a></li>
            <li><a href="">下拉列表四</a></li>
        </ul>
    </li>
</ul>
<br>
<pre>导航条</pre>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
        <a class="navbar-brand">图标</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a>首页</a></li>
            <li><a>咨询</a></li>
            <li><a>产品</a></li>
            <li class="disabled"><a>弃用</a></li>
        </ul>
        <form class="navbar-form">
        <div class="input-group">
            <input type="text" class="form-control">
            <div class="input-group-btn">
                 <button class="btn btn-default">提交</button>
            </div>
        </div>
           <%-- <button class="btn btn-default navbar-btn ">按钮</button>--%>
        </form>

    </div>
</nav>
<br>
<nav class="navbar navbar-default navbar-static-top"><%----%>
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand">图标</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a>首页</a></li>
            <li><a>咨询</a></li>
            <li><a>产品</a></li>
            <li class="disabled"><a>弃用</a></li>
        </ul>
        <form class="navbar-form navbar-right">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="使导航条固定在顶部navbar-fixed-top 底部-bottom">
                <div class="input-group-btn">
                    <button class="btn btn-default">提交</button>
                </div>
            </div>
        </form>
        <button class="btn btn-default navbar-btn ">按钮</button>
        <p class="navbar-text">我是文本<a>连接</a></p>
    </div>
</nav>
<br>
<br>
<h1>路径分页标签和徽章组件  面包屑</h1>
<pre>面包屑组件</pre>
<ol class="breadcrumb">
    <li><a>首页</a></li>
    <li><a>产品列表</a></li>
    <li><a>韩版2017年时尚卫衣</a></li>
</ol>
<br>
<pre>分页组件样式</pre>
<ul class="pagination pagination-lg">
    <li><a>上一页</a></li>
    <li><a>1</a></li>
    <li><a>2</a></li>
    <li><a>3</a></li>
    <li><a>4</a></li>
    <li><a>5</a></li>
    <li><a>6</a></li>
    <li><a>下一页</a></li>
</ul>
<ul class="pager">
    <li><a>上一页</a></li>
    <li><a>下一页</a></li>
</ul>
<ul class="pager">
    <li class="previous"><a>上一页</a></li>
    <li class="next disabled"><a>下一页</a></li>
</ul>
<pre>标签</pre>
<span class="label label-success">标签</span>
<a>一共有多少条<span class="badge">badge</span>
</a>
<button class="btn btn-info">按钮<span class="badge">2</span>
</button>
<ul class="nav nav-pills">
    <li class="active"><a>徽章激活<span class="badge">3</span></a></li>
    <li><a>徽章不激活<span class="badge">2</span></a></li>
</ul>
<br>
<h1>巨幕  页头 缩略图 警告框组件</h1>
<pre>巨幕组件 展示网站的关键性区域  固定大小 100%全屏</pre>
<div class="container">
    <div class="jumbotron">
        <h3>网站标题</h3>
        <p>我是网站的详细简介</p>
        <button class="btn btn-default">快速进入</button>
    </div>
</div>
<div class="jumbotron">
    <div class="container">
    <h3>网站标题</h3>
    <p>我是网站的详细简介</p>
    <button class="btn btn-default">快速进入</button>
    </div>
</div>
<pre>页头组件</pre>
<div class="page-header">
    <h2>我是大标题<small>我是小标题</small></h2>
</div>
<pre>缩略图组件thumbnail</pre>
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-xs-6 col-md-4 col-sm-12">
                    <div class="thumbnail">
                    <img src="../skins/imge/p02.jpg" alt="">
                </div>
                <div class="caption">
                    <h3>图片caption</h3>
                    <p>关于图片的详情</p>
                    <button class="btn btn-default">快速进入</button>
                </div>
            </div>
            <div class="col-lg-3 col-xs-6 col-md-4 col-sm-12">
                <div class="thumbnail">
                    <img src="../skins/imge/p02.jpg" alt="">
                </div>
                <div class="caption">
                    <h3>图片caption</h3>
                    <p>关于图片的详情</p>
                    <button class="btn btn-default">快速进入</button>
                </div>
            </div>
            <div class="col-lg-3 col-xs-6 col-md-4 col-sm-12">
                <div class="thumbnail">
                    <img src="../skins/imge/p02.jpg" alt="">
                </div>
                <div class="caption">
                    <h3>图片caption</h3>
                    <p>关于图片的详情</p>
                    <button class="btn btn-default">快速进入</button>
                </div>
            </div>
            <div class="col-lg-3  col-md-4 col-xs-6 col-sm-12">
                <div class="thumbnail">
                    <img src="../skins/imge/p02.jpg" alt="">
                </div>
                <div class="caption">
                    <h3>图片caption</h3>
                    <p>关于图片的详情</p>
                    <button class="btn btn-default">快速进入</button>
                </div>
            </div>

        </div>
    </div>
<pre>警告框组件</pre>
<div class="alert alert-success">我是一个警告框</div>
<div class="alert alert-warning">我是一个警告框 带关闭
    <button class="close" data-dismiss="alert"><span>&times;</span></button>
</div>
<div class="alert alert-danger">我是一个警告框 自带超链接 alert-link <a class="alert-link">下载最新版本</a></div>
<div class="alert alert-info">我是一个警告框</div>
<br>
<h1>进度条媒体对象和Well组件</h1>
<pre>well组件</pre>
<div class="well">well组件</div>
<div class="well-lg">well组件lg</div>
<pre>进度条组件progress progress-bar</pre>

<div class="progress">
    <div class="progress-bar progress-bar-success" style="min-width: 20px;width: 60%">60%</div>
</div>

<div class="progress">
    <div class="progress-bar progress-bar-success" style="min-width: 20px;width: 0%">0%</div>
</div>

<pre> 条纹状 危险色</pre>
<div class="progress">
    <div class="progress-bar progress-bar-danger progress-bar-striped" style="min-width: 20px;width: 60%">60%</div>
</div>
<pre> 必须条纹状 成功色 动画效果active</pre>
<div class="progress">
    <div class="active progress-bar progress-bar-success progress-bar-striped" style="min-width: 20px;width: 60%">60%</div>
</div>
<pre>必须条纹 堆叠色</pre>
<div class="progress">
    <div class="active progress-bar progress-bar-danger progress-bar-striped" style="min-width: 20px;width: 20%">20%</div>
    <div class="active progress-bar progress-bar-warning progress-bar-striped" style="min-width: 20px;width: 20%">40%</div>
    <div class="active progress-bar progress-bar-success progress-bar-striped" style="min-width: 20px;width: 20%">60%</div>
</div>
<br>
<pre>媒体对象组件 </pre>
<div class="media">
    <div class="media-left media-top">
        <img src="../skins/imge/p02.jpg" class="media-object">
    </div>
    <div class="media-body">
        <h4 class="media-heading">标题</h4>
        <p>鞠婧祎，1994年6月18日出生于四川省遂宁市，中国内地流行乐女歌手、影视演员，SNH48成员。2013年11月2日，以《剧场女神》公演正式出道。2014年7月26日，获得SNH48第一届总选举第4位。2015年7月25日，获得SNH48第二届总选举第2位；11月，参与湖南卫视综艺节目《全员加速中》。2016年1月，主演玄幻剧《九州天空城》；6月，主演网剧《热血长安》；7月30日，获得SNH48第三届总选举第1位。2016年1月，主演玄幻剧《九州天空城》[5]  ；6月，主演网剧《热血长安》；7月30日，获得SNH48第三届总选举第1位。2017年7月，主演古装电视剧《芸汐传》；7月29日，获得SNH48第四届总选举第1位，成为SNH48首位总选举连霸成员。</p>
    </div>
</div>
<div class="media">
    <div class="media-body">
        <h4 class="media-heading">标题</h4>
        <p>鞠婧祎，1994年6月18日出生于四川省遂宁市，中国内地流行乐女歌手、影视演员，SNH48成员。2013年11月2日，以《剧场女神》公演正式出道。2014年7月26日，获得SNH48第一届总选举第4位。2015年7月25日，获得SNH48第二届总选举第2位；11月，参与湖南卫视综艺节目《全员加速中》。2016年1月，主演玄幻剧《九州天空城》；6月，主演网剧《热血长安》；7月30日，获得SNH48第三届总选举第1位。2016年1月，主演玄幻剧《九州天空城》[5]  ；6月，主演网剧《热血长安》；7月30日，获得SNH48第三届总选举第1位。2017年7月，主演古装电视剧《芸汐传》；7月29日，获得SNH48第四届总选举第1位，成为SNH48首位总选举连霸成员。</p>
    </div>
    <div class="media-right media-top">
        <img src="../skins/imge/p02.jpg" class="media-object">
    </div>
</div>
<pre>媒体列表对象 主要用于评论回复</pre>
<ul class="media-list">
    <li class="media">
        <div class="media-left media-top">
            <img src="../skins/imge/p02.jpg" class="media-object">
        </div>
        <div class="media-body">
            <h4 class="media-heading">标题</h4>
            <p>鞠婧祎，1994年6月18日出生于四川省遂宁市，中国内地流行乐女歌手、影视演员，SNH48成员。2013年11月2日，以《剧场女神》公演正式出道。2014年7月26日，获得SNH48第一届总选举第4位。2015年7月25日，获得SNH48第二届总选举第2位；11月，参与湖南卫视综艺节目《全员加速中》。2016年1月，主演玄幻剧《九州天空城》；6月，主演网剧《热血长安》；7月30日，获得SNH48第三届总选举第1位。2016年1月，主演玄幻剧《九州天空城》[5]  ；6月，主演网剧《热血长安》；7月30日，获得SNH48第三届总选举第1位。2017年7月，主演古装电视剧《芸汐传》；7月29日，获得SNH48第四届总选举第1位，成为SNH48首位总选举连霸成员。</p>
            <div class="media">
                <div class="media-left media-top">
                    <img src="../skins/imge/p02.jpg" class="media-object">
                </div>
                <div class="media-body">
                    <h4 class="media-heading">标题</h4>
                    <p>鞠婧祎，1994年6月18日出生于四川省遂宁市，中国内地流行乐女歌手、影视演员，SNH48成员。2013年11月2日，以《剧场女神》公演正式出道。2014年7月26日，获得SNH48第一届总选举第4位。2015年7月25日，获得SNH48第二届总选举第2位；11月，参与湖南卫视综艺节目《全员加速中》。2016年1月，主演玄幻剧《九州天空城》；6月，主演网剧《热血长安》；7月30日，获得SNH48第三届总选举第1位。2016年1月，主演玄幻剧《九州天空城》[5]  ；6月，主演网剧《热血长安》；7月30日，获得SNH48第三届总选举第1位。2017年7月，主演古装电视剧《芸汐传》；7月29日，获得SNH48第四届总选举第1位，成为SNH48首位总选举连霸成员。</p>
                </div>
            </div>
        </div>
    </li>
    <li class="media">
        <div class="media-left media-top">
            <img src="../skins/imge/p02.jpg" class="media-object">
        </div>
        <div class="media-body">
            <h4 class="media-heading">标题</h4>
            <p>鞠婧祎，1994年6月18日出生于四川省遂宁市，中国内地流行乐女歌手、影视演员，SNH48成员。2013年11月2日，以《剧场女神》公演正式出道。2014年7月26日，获得SNH48第一届总选举第4位。2015年7月25日，获得SNH48第二届总选举第2位；11月，参与湖南卫视综艺节目《全员加速中》。2016年1月，主演玄幻剧《九州天空城》；6月，主演网剧《热血长安》；7月30日，获得SNH48第三届总选举第1位。2016年1月，主演玄幻剧《九州天空城》[5]  ；6月，主演网剧《热血长安》；7月30日，获得SNH48第三届总选举第1位。2017年7月，主演古装电视剧《芸汐传》；7月29日，获得SNH48第四届总选举第1位，成为SNH48首位总选举连霸成员。</p>
        </div>
    </li>
</ul>
<br>
<h1>列表组面板和嵌入组件</h1>
<pre>列表组组件 比较适合做侧栏列表list</pre>
<ul class="list-group" style="width: 200px">
    <li class="list-group-item">第一页</li>
    <li class="list-group-item">第二页<span class="badge">2</span></li>
    <li class="list-group-item list-group-item-success">第三页</li>
    <li class="list-group-item list-group-item-danger">第四页</li>
</ul>
<ul class="list-group" style="width: 200px">
    <a href="#" class="list-group-item"><h4>列表标题</h4><p>详细内容……………………</p></a>
    <a href="#" class="list-group-item">第二页<span class="badge">2</span></a>
    <a href="#" class="list-group-item list-group-item-success active">首选项</a>
    <a href="#" class="list-group-item list-group-item-danger disabled">第四页</a>
</ul>
<ul class="list-group" style="width: 200px">
    <button class="list-group-item">第一页</button>
    <button class="list-group-item">第二页<span class="badge">2</span></button>
    <button class="list-group-item list-group-item-success active">首选项</button>
    <button class="list-group-item list-group-item-danger disabled">第四页</button>
</ul>
<br>
<pre>面板组件panel 加 表格  列表 无缝连接</pre>
<div class="panel panel-default">
    <div class="panel-heading">我是标题区域</div>
    <div class="panel-body">我是一个面板容器</div>
        <table class="table">
            <tr>
                <td>表格</td>
                <td>表格</td>
                <td>表格</td>
                <td>表格</td>
            </tr>
            <tr>
                <td>表格</td>
                <td>表格</td>
                <td>表格</td>
                <td>表格</td>
            </tr>
            <tr>
                <td>表格</td>
                <td>表格</td>
                <td>表格</td>
                <td>表格</td>
            </tr>
        </table>
        <ul class="list-group">
            <li class="list-group-item">列表</li>
            <li class="list-group-item">列表</li>
            <li class="list-group-item">列表</li>
            <li class="list-group-item">列表</li>
        </ul>
    <div class="panel-footer">我是面板底部</div>
</div>
<br>
<pre>响应式嵌入组件</pre>
<div clas="embed-responsivembed-responsive-16by9">
    <embed width="10%" height="10%"
           src="http:/www.tudou.com/vOUG5JBZ8udc/&bid=05&rpid=5079543&resourceId=5079543_05_05_9/v.swf" type="aplication/x-shockwave-flash"
           alowscriptaces="always" alowfulscren="true" wmode="opaque"></embed>
</div>
<br>
<h1>模态框插件的使用 </h1>
<pre>模态框   三层 模态框 窗口声明 内容声明 一般用于弹窗 可调节大小</pre>
<%--模态框声明--%>
<div class="modal" id="Mydialog">
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
<button class="btn btn-primary" data-toggle="modal" data-target="#Mydialog">弹出窗口正常</button>
<div class="modal" id="Mydialog2">
    <%--窗口声明--%>
    <div class="modal-dialog modal-lg">
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
<button class="btn btn-primary" data-toggle="modal" data-target="#Mydialog2">弹出窗口大号</button>
<div class="modal" id="Mydialog3">
    <%--窗口声明--%>
    <div class="modal-dialog modal-sm">
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
<button class="btn btn-primary" data-toggle="modal" data-target="#Mydialog3">弹出窗口小号</button>
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
<button class="btn btn-primary" data-toggle="modal" data-target="#Mydialog4">淡入淡出fade</button>
<%--模态框声明--%>
<div class="modal fade" id="Mydialog5" tabindex="-1">
    <%--窗口声明--%>
    <div class="modal-dialog">
        <%--内容声明--%>
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal"><span>&times;</span></button>
                <div class="modal-title">标题</div>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row">
                        <span class="col-md-3 col-sm-4">栅格系统</span>
                        <span class="col-md-3 col-sm-4">栅格系统</span>
                        <span class="col-md-3 col-sm-4">栅格系统</span>
                        <span class="col-md-3 col-sm-4">栅格系统</span>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-info">登录</button>
                <button class="btn btn-primary">注册</button>
            </div>
        </div>
    </div>
</div>
<button class="btn btn-primary" data-toggle="modal" data-target="#Mydialog5">设置为流体</button>
<%--模态框声明--%>
<div class="modal fade" id="Mydialog6" tabindex="-1">
    <%--窗口声明--%>
    <div class="modal-dialog">
        <%--内容声明--%>
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal"><span>&times;</span></button>
                <div class="modal-title">标题</div>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row">
                        <span class="col-md-3 col-sm-4">栅格系统</span>
                        <span class="col-md-3 col-sm-4">栅格系统</span>
                        <span class="col-md-3 col-sm-4">栅格系统</span>
                        <span class="col-md-3 col-sm-4">栅格系统</span>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-info">登录</button>
                <button class="btn btn-primary">注册</button>
            </div>
        </div>
    </div>
</div>
<button class="btn btn-primary" id="myButton">通过js调用</button>
<button class="btn btn-primary" id="myButton2">通过js调用</button>
<br>
<h1>下拉菜单和滚动监听事件</h1>
<pre>下拉菜单</pre>
<div class="dropdown" id="myDropdown">
    <button class="btn btn-primary" data-toggle="dropdown">下拉菜单
        <span class="caret"></span>
    </button>
    <ul class="dropdown-menu">
        <li><a>下拉项</a></li>
        <li><a>下拉项</a></li>
        <li><a>下拉项</a></li>
        <li><a>下拉项</a></li>
    </ul>
</div>
<pre>下拉按钮在外部</pre>
<button class="btn btn-primary" data-toggle="dropdown" data-target="#dropdown2">下拉菜单
    <span class="caret"></span>
</button>
<div class="dropdown" id="dropdown2">
    <ul class="dropdown-menu">
        <li><a>下拉项</a></li>
        <li><a>下拉项</a></li>
        <li><a>下拉项</a></li>
        <li><a>下拉项</a></li>
    </ul>
</div>
<br>
<pre>滚动监听插件 以及删除内容元素刷新滚动监听</pre>
<nav class="navbar navbar-default <%--navbar-fixed-top--%>" id="myNav">
    <div class="navbar-header">
    <a href="#" class="navbar-brand">Web开发</a>
    </div>
    <ul class="nav navbar-nav">
        <li><a href="#html5" class="active">Html5</a></li>
        <li><a href="#bootstrap">Bootstrap</a></li>
        <li class="dropdown">
            <a href="#" data-toggle="dropdown">javaScript
                <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <li><a href="#jquery">jQuery</a></li>
                <li><a href="#yui">Yui</a></li>
                <li><a href="#extjs">Extjs</a></li>
            </ul>
        </li>
    </ul>
</nav>
<div id="content2" data-offset="0" data-spy="scroll" data-target="#myNav" style="height: 200px;overflow: auto;position: relative;padding:0 10px;">
    <section >
        <h4 id=html5>HTML5</h4>
        <p>标准通用标记语言下的一个应用 HTML 标准自 19 年 12 月发布的 HTML4.01后，后继的 HTML5 和其它标准被束之高阁，为了推动 Web 标准化运动的发展，一些公司联合起来，成立了一个叫做 Web Hypertext Aplication Technolgy Working Group（Web 超文本应用技术工作组 -WHATWG） 的组织。WHATWG 致力于 Web 表单和应用程序，而 W3C（World Wide Web Consortium，万维网联盟） 专注于 XHTML2.0。在 206 年，双方决定进行合作，来创建一个新版本的 HTML。</p>
    </section>
    <section id="sec">
        <h4 id="bootstrap">Botsrap<a onclick="removeSec(this)">Botsrap删除本节</a></h4>
        <p>Botsrap，来自 Twiter，是目前很受欢迎的前端框架。Botsrap 是基于 HTML、CS、JAVSCRIPT 的，它简洁灵活，使得 Web 开发更加快捷。[1] 它由 Twiter的设计师 Mark Oto 和 Jacob Thornton 合作开发，是一个 CS/HTML 框架。Botsrap提供了优雅的 HTML 和 CS 规范，它即是由动态 CS 语言 Les 写成。Botsrap 一经推出后颇受欢迎，一直是 GitHub 上的热门开源项目，包括 NAS 的 MSNBC（微软全国广播公司）的 Breaking News 都使用了该项目。[2] 国内一些移动开发者较为熟悉的框架，如 WeX前端开源框架等，也是基于 Botsrap 源码进行性能优化而来。[3] </p>
    </section>
    <section>
        <h4 id="jquery">jQuery</h4>
        <p>JQuery 是继 protype 之后又一个优秀的 Javscript 库。它是轻量级的 js库 ，它兼容 CS3，还兼容各种浏览器（IE 6.0+, F 1.5+, Safri 2.0+, Opera 9.0+），jQuery2.0 及后续版本将不再支持 IE6/78 浏览器。jQuery 使用户能更方便地处理 HTML（标准通用标记语言下的一个应用）、evnts、实现动画效果，并且方便地为网站提供 AJX交互。jQuery 还有一个比较大的优势是，它的文档说明很全，而且各种应用也说得很详细，同时还有许多成熟的插件可供选择。jQuery 能够使用户的 html 页面保持代码和 html 内容分离，也就是说，不用再在 html 里面插入一堆 js 来调用命令了，只需要定义 id 即可。</p>
    </section>
    <section>
        <h4 id="yui">Yui</h4>
        <p>近几年随着 jQuery、Ext 以及 CS3 的发展，以 Botsrap 为代表的前端开发框架如雨后春笋般挤入视野，可谓应接不暇。不论是桌面浏览器端还是移动端都涌现出很多优秀的框架，极大丰富了开发素材，也方便了大家的开发。这些框架各有特点，本文对这些框架进行初步的介绍与比较，希望能够为大家选择框架提供一点帮助，也为后续详细研究这些框架的抛砖引玉。</p>
    </section>
    <section>
        <h4 id="extjs">Extjs</h4>
        <p>ExtJS 可以用来开发 RIA 也即富客户端的 AJX 应用，是一个用 javscript写的，主要用于创建前端用户界面，是一个与后台技术无关的前端 ajx 框架。因此，可以把 ExtJS 用在.Net、Jav、Php 等各种开发语言开发的应用中。ExtJs 最开始基于 YUI 技术，由开发人员 JackSlocum 开发，通过参考 JavSwing 等机制来组织可视化组件，无论从 UI 界面上 CS 样式的应用，到数据解析上的异常处理，都可算是一款不可多得的JavScript 客户端技术的精品。</p>
    </section>
</div>
<br>
<pre>滚动监听插件 通过js事件调用  </pre>
<nav class="navbar navbar-default <%--navbar-fixed-top--%>" id="myNav2">
    <div class="navbar-header">
        <a href="#" class="navbar-brand">Web开发</a>
    </div>
    <ul class="nav navbar-nav" id="nav">
        <li><a href="#html51" class="active">Html5</a></li>
        <li><a href="#bootstrap1">Bootstrap</a></li>
        <li class="dropdown">
            <a href="#" data-toggle="dropdown">javaScript
                <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <li><a href="#jquery1">jQuery</a></li>
                <li><a href="#yui1">Yui</a></li>
                <li><a href="#extjs1">Extjs</a></li>
            </ul>
        </li>
    </ul>
</nav>
<div id="content" style="height: 200px;overflow: auto;position: relative;padding:0 10px;">
    <section>
        <h4 id=html51>HTML5</h4>
        <p>标准通用标记语言下的一个应用 HTML 标准自 19 年 12 月发布的 HTML4.01后，后继的 HTML5 和其它标准被束之高阁，为了推动 Web 标准化运动的发展，一些公司联合起来，成立了一个叫做 Web Hypertext Aplication Technolgy Working Group（Web 超文本应用技术工作组 -WHATWG） 的组织。WHATWG 致力于 Web 表单和应用程序，而 W3C（World Wide Web Consortium，万维网联盟） 专注于 XHTML2.0。在 206 年，双方决定进行合作，来创建一个新版本的 HTML。</p>
    </section>
    <section >
        <h4 id="bootstrap1"></h4>
        <p>Botsrap，来自 Twiter，是目前很受欢迎的前端框架。Botsrap 是基于 HTML、CS、JAVSCRIPT 的，它简洁灵活，使得 Web 开发更加快捷。[1] 它由 Twiter的设计师 Mark Oto 和 Jacob Thornton 合作开发，是一个 CS/HTML 框架。Botsrap提供了优雅的 HTML 和 CS 规范，它即是由动态 CS 语言 Les 写成。Botsrap 一经推出后颇受欢迎，一直是 GitHub 上的热门开源项目，包括 NAS 的 MSNBC（微软全国广播公司）的 Breaking News 都使用了该项目。[2] 国内一些移动开发者较为熟悉的框架，如 WeX前端开源框架等，也是基于 Botsrap 源码进行性能优化而来。[3] </p>
    </section>
    <section>
        <h4 id="jquery1">jQuery</h4>
        <p>JQuery 是继 protype 之后又一个优秀的 Javscript 库。它是轻量级的 js库 ，它兼容 CS3，还兼容各种浏览器（IE 6.0+, F 1.5+, Safri 2.0+, Opera 9.0+），jQuery2.0 及后续版本将不再支持 IE6/78 浏览器。jQuery 使用户能更方便地处理 HTML（标准通用标记语言下的一个应用）、evnts、实现动画效果，并且方便地为网站提供 AJX交互。jQuery 还有一个比较大的优势是，它的文档说明很全，而且各种应用也说得很详细，同时还有许多成熟的插件可供选择。jQuery 能够使用户的 html 页面保持代码和 html 内容分离，也就是说，不用再在 html 里面插入一堆 js 来调用命令了，只需要定义 id 即可。</p>
    </section>
    <section>
        <h4 id="yui1">Yui</h4>
         <p>近几年随着 jQuery、Ext 以及 CS3 的发展，以 Botsrap 为代表的前端开发框架如雨后春笋般挤入视野，可谓应接不暇。不论是桌面浏览器端还是移动端都涌现出很多优秀的框架，极大丰富了开发素材，也方便了大家的开发。这些框架各有特点，本文对这些框架进行初步的介绍与比较，希望能够为大家选择框架提供一点帮助，也为后续详细研究这些框架的抛砖引玉。</p>
    </section>
    <section>
        <h4 id="extjs1">Extjs</h4>
        <p>ExtJS 可以用来开发 RIA 也即富客户端的 AJX 应用，是一个用 javscript写的，主要用于创建前端用户界面，是一个与后台技术无关的前端 ajx 框架。因此，可以把 ExtJS 用在.Net、Jav、Php 等各种开发语言开发的应用中。ExtJs 最开始基于 YUI 技术，由开发人员 JackSlocum 开发，通过参考 JavSwing 等机制来组织可视化组件，无论从 UI 界面上 CS 样式的应用，到数据解析上的异常处理，都可算是一款不可多得的JavScript 客户端技术的精品。</p>
    </section>
</div>
<br>
<h1>标签页和工具提示插件</h1>
<pre>标签页tab页</pre>
<ul class="nav nav-tabs">
    <li class="active"><a href="#html52" data-toggle="tab">HTML5</a></li>
    <li><a href="#bootstrap2" data-toggle="tab">Bootstrap</a></li>
    <li><a href="#jquery2" data-toggle="tab">Jquery</a></li>
    <li><a href="#extjs2" data-toggle="tab">Exijs</a></li>
</ul>
<div class="tab-content">
    <div class="tab-pane active" id="html52">
        <p>标准通用标记语言下的一个应用 HTML 标准自 19 年 12 月发布的 HTML4.01后，后继的 HTML5 和其它标准被束之高阁，为了推动 Web 标准化运动的发展，一些公司联合起来，成立了一个叫做 Web Hypertext Aplication Technolgy Working Group（Web 超文本应用技术工作组 -WHATWG） 的组织。WHATWG 致力于 Web 表单和应用程序，而 W3C（World Wide Web Consortium，万维网联盟） 专注于 XHTML2.0。在 206 年，双方决定进行合作，来创建一个新版本的 HTML。</p>
    </div>
    <div class="tab-pane" id="bootstrap2">
        <p>Botsrap，来自 Twiter，是目前很受欢迎的前端框架。Botsrap 是基于 HTML、CS、JAVSCRIPT 的，它简洁灵活，使得 Web 开发更加快捷。[1] 它由 Twiter的设计师 Mark Oto 和 Jacob Thornton 合作开发，是一个 CS/HTML 框架。Botsrap提供了优雅的 HTML 和 CS 规范，它即是由动态 CS 语言 Les 写成。Botsrap 一经推出后颇受欢迎，一直是 GitHub 上的热门开源项目，包括 NAS 的 MSNBC（微软全国广播公司）的 Breaking News 都使用了该项目。[2] 国内一些移动开发者较为熟悉的框架，如 WeX前端开源框架等，也是基于 Botsrap 源码进行性能优化而来。[3] </p>
    </div>

    <div class="tab-pane" id="jquery2">
        <p>JQuery 是继 protype 之后又一个优秀的 Javscript 库。它是轻量级的 js库 ，它兼容 CS3，还兼容各种浏览器（IE 6.0+, F 1.5+, Safri 2.0+, Opera 9.0+），jQuery2.0 及后续版本将不再支持 IE6/78 浏览器。jQuery 使用户能更方便地处理 HTML（标准通用标记语言下的一个应用）、evnts、实现动画效果，并且方便地为网站提供 AJX交互。jQuery 还有一个比较大的优势是，它的文档说明很全，而且各种应用也说得很详细，同时还有许多成熟的插件可供选择。jQuery 能够使用户的 html 页面保持代码和 html 内容分离，也就是说，不用再在 html 里面插入一堆 js 来调用命令了，只需要定义 id 即可。</p>
    </div>
    <div class="tab-pane" id="extjs2">
        <p>ExtJS 可以用来开发 RIA 也即富客户端的 AJX 应用，是一个用 javscript写的，主要用于创建前端用户界面，是一个与后台技术无关的前端 ajx 框架。因此，可以把 ExtJS 用在.Net、Jav、Php 等各种开发语言开发的应用中。ExtJs 最开始基于 YUI 技术，由开发人员 JackSlocum 开发，通过参考 JavSwing 等机制来组织可视化组件，无论从 UI 界面上 CS 样式的应用，到数据解析上的异常处理，都可算是一款不可多得的JavScript 客户端技术的精品。</p>
    </div>
</div>
<pre>淡入淡出fade  以及胶囊式</pre>
<ul class="nav nav-pills">
    <li class="active"><a href="#html53" data-toggle="tab">HTML5</a></li>
    <li><a href="#bootstrap3" data-toggle="tab">Bootstrap</a></li>
    <li><a href="#jquery3" data-toggle="tab">Jquery</a></li>
    <li><a href="#extjs3" data-toggle="tab">Exijs</a></li>
</ul>
<div class="tab-content">
    <div class="tab-pane active fade in" id="html53">
        <p>标准通用标记语言下的一个应用 HTML 标准自 19 年 12 月发布的 HTML4.01后，后继的 HTML5 和其它标准被束之高阁，为了推动 Web 标准化运动的发展，一些公司联合起来，成立了一个叫做 Web Hypertext Aplication Technolgy Working Group（Web 超文本应用技术工作组 -WHATWG） 的组织。WHATWG 致力于 Web 表单和应用程序，而 W3C（World Wide Web Consortium，万维网联盟） 专注于 XHTML2.0。在 206 年，双方决定进行合作，来创建一个新版本的 HTML。</p>
    </div>
    <div class="tab-pane fade" id="bootstrap3">
        <p>Botsrap，来自 Twiter，是目前很受欢迎的前端框架。Botsrap 是基于 HTML、CS、JAVSCRIPT 的，它简洁灵活，使得 Web 开发更加快捷。[1] 它由 Twiter的设计师 Mark Oto 和 Jacob Thornton 合作开发，是一个 CS/HTML 框架。Botsrap提供了优雅的 HTML 和 CS 规范，它即是由动态 CS 语言 Les 写成。Botsrap 一经推出后颇受欢迎，一直是 GitHub 上的热门开源项目，包括 NAS 的 MSNBC（微软全国广播公司）的 Breaking News 都使用了该项目。[2] 国内一些移动开发者较为熟悉的框架，如 WeX前端开源框架等，也是基于 Botsrap 源码进行性能优化而来。[3] </p>
    </div>

    <div class="tab-pane fade" id="jquery3">
        <p>JQuery 是继 protype 之后又一个优秀的 Javscript 库。它是轻量级的 js库 ，它兼容 CS3，还兼容各种浏览器（IE 6.0+, F 1.5+, Safri 2.0+, Opera 9.0+），jQuery2.0 及后续版本将不再支持 IE6/78 浏览器。jQuery 使用户能更方便地处理 HTML（标准通用标记语言下的一个应用）、evnts、实现动画效果，并且方便地为网站提供 AJX交互。jQuery 还有一个比较大的优势是，它的文档说明很全，而且各种应用也说得很详细，同时还有许多成熟的插件可供选择。jQuery 能够使用户的 html 页面保持代码和 html 内容分离，也就是说，不用再在 html 里面插入一堆 js 来调用命令了，只需要定义 id 即可。</p>
    </div>
    <div class="tab-pane fade" id="extjs3">
        <p>ExtJS 可以用来开发 RIA 也即富客户端的 AJX 应用，是一个用 javscript写的，主要用于创建前端用户界面，是一个与后台技术无关的前端 ajx 框架。因此，可以把 ExtJS 用在.Net、Jav、Php 等各种开发语言开发的应用中。ExtJs 最开始基于 YUI 技术，由开发人员 JackSlocum 开发，通过参考 JavSwing 等机制来组织可视化组件，无论从 UI 界面上 CS 样式的应用，到数据解析上的异常处理，都可算是一款不可多得的JavScript 客户端技术的精品。</p>
    </div>
</div>
<pre>淡入淡出fade  以及胶囊式 使用js事件调用</pre>
<ul class="nav nav-pills" id="nav2">
    <li class="active"><a href="#html54">HTML5</a></li>
    <li><a href="#bootstrap4">Bootstrap</a></li>
    <li><a href="#jquery4">Jquery</a></li>
    <li><a href="#extjs4">Exijs</a></li>
</ul>
<div class="tab-content">
    <div class="tab-pane active fade in" id="html54">
        <p>标准通用标记语言下的一个应用 HTML 标准自 19 年 12 月发布的 HTML4.01后，后继的 HTML5 和其它标准被束之高阁，为了推动 Web 标准化运动的发展，一些公司联合起来，成立了一个叫做 Web Hypertext Aplication Technolgy Working Group（Web 超文本应用技术工作组 -WHATWG） 的组织。WHATWG 致力于 Web 表单和应用程序，而 W3C（World Wide Web Consortium，万维网联盟） 专注于 XHTML2.0。在 206 年，双方决定进行合作，来创建一个新版本的 HTML。</p>
    </div>
    <div class="tab-pane fade" id="bootstrap4">
        <p>Botsrap，来自 Twiter，是目前很受欢迎的前端框架。Botsrap 是基于 HTML、CS、JAVSCRIPT 的，它简洁灵活，使得 Web 开发更加快捷。[1] 它由 Twiter的设计师 Mark Oto 和 Jacob Thornton 合作开发，是一个 CS/HTML 框架。Botsrap提供了优雅的 HTML 和 CS 规范，它即是由动态 CS 语言 Les 写成。Botsrap 一经推出后颇受欢迎，一直是 GitHub 上的热门开源项目，包括 NAS 的 MSNBC（微软全国广播公司）的 Breaking News 都使用了该项目。[2] 国内一些移动开发者较为熟悉的框架，如 WeX前端开源框架等，也是基于 Botsrap 源码进行性能优化而来。[3] </p>
    </div>

    <div class="tab-pane fade" id="jquery4">
        <p>JQuery 是继 protype 之后又一个优秀的 Javscript 库。它是轻量级的 js库 ，它兼容 CS3，还兼容各种浏览器（IE 6.0+, F 1.5+, Safri 2.0+, Opera 9.0+），jQuery2.0 及后续版本将不再支持 IE6/78 浏览器。jQuery 使用户能更方便地处理 HTML（标准通用标记语言下的一个应用）、evnts、实现动画效果，并且方便地为网站提供 AJX交互。jQuery 还有一个比较大的优势是，它的文档说明很全，而且各种应用也说得很详细，同时还有许多成熟的插件可供选择。jQuery 能够使用户的 html 页面保持代码和 html 内容分离，也就是说，不用再在 html 里面插入一堆 js 来调用命令了，只需要定义 id 即可。</p>
    </div>
    <div class="tab-pane fade" id="extjs4">
        <p>ExtJS 可以用来开发 RIA 也即富客户端的 AJX 应用，是一个用 javscript写的，主要用于创建前端用户界面，是一个与后台技术无关的前端 ajx 框架。因此，可以把 ExtJS 用在.Net、Jav、Php 等各种开发语言开发的应用中。ExtJs 最开始基于 YUI 技术，由开发人员 JackSlocum 开发，通过参考 JavSwing 等机制来组织可视化组件，无论从 UI 界面上 CS 样式的应用，到数据解析上的异常处理，都可算是一款不可多得的JavScript 客户端技术的精品。</p>
    </div>
</div>
<pre>工具提示插件tooltip</pre>
<a id="a" href="#"
   data-toggle="tooltip"
   title="提示信息"<%--默认字空符串，提示语的内容。--%>
   data-animation="true"<%--默认 true，在 toltip 上应用一个 CS fade 动画。如果设置 false，则不应用。--%>
   data-html="false"<%--默认 false，不允许提示内容格式为 html。如果设置为 true，则可以设置 html 格式的提示内容。--%>
   data-placement="top"<%--默认值 top，还有 botom、left、right 和 auto。如果 auto 会自行调整合适的位置，如果是 auto left则会尽量在左边显示，但左边不行就靠右边。--%>
   data-original-title="null"<%--默认空字符串，提示语的内容。优先级比 tile 低--%>
   data-trigger="hover foucs"<%--默认值 hover foucs，表示怎么触发 toltip，其他值为：click、manual。多个值用空格隔开，manual手动不能和其他同时设置。--%>
   <%--data-template=""--%><%--更改提示框的 HTML 提示语的模版，默认值为：<div class='toltip'><divclass='toltip-arow'></div><divclass='toltip-iner'></div></div>。--%>
   data-delay="0"<%--默认值 0，延迟触发 toltip(毫秒)，如果传数字则表示 show/hide 的毫秒数如果传对象结构为：{show:50,hide:10}--%>>html5</a>
<a id="a1" href="#"
   data-toggle="tooltip"
   title="提示信息">使用js方式实现</a>
<br>
<h1>弹出框和警告框插件popover</h1>
<pre>弹出窗 跟上面的那个提示工具差不多</pre>
<button id="myBtn2" class="btn btn-info"
    data-toggle="popover"
    title="我是提示信息"
    data-content="我比上面那个提示信息多一个内容"
>popover弹出窗
</button>
<br>
<pre>警告框 alert-warning</pre>
<div class="alert alert-warning">
    <buntton class="close" data-dismiss="alert">
        <span>&times;</span>
    </buntton>
    <p>警告 这是一个警告框！</p>
</div>
<div class="alert alert-success fade in">
<buntton class="close" data-dismiss="alert">
    <span>&times;</span>
</buntton>
<p>警告 这是一个警告框！</p>
</div>
<br>
<h1>按钮和折叠组件</h1>
<pte>暂时点击禁用按钮</pte>
<button class="btn btn-primary" data-toggle="button" onautocomplete="off">一个按钮</button>
<pre>单选按钮</pre>
<div class="btn-group" data-toggle="buttons">
    <label class="btn btn-primary active">
        <input type="radio" name="sex" value="男" checked>男
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="sex" value="女">女
    </label>
</div>
<pre>复选框按钮组</pre>
<div class="btn-group" data-toggle="buttons">
    <label class="btn btn-primary active">
        <input type="checkbox" name="sex" value="男" checked>体育
    </label>
    <label class="btn btn-primary">
        <input type="checkbox" name="sex" value="女">音乐
    </label>
    <label class="btn btn-primary">
        <input type="checkbox" name="sex" value="女">美术
    </label>
    <label class="btn btn-primary">
        <input type="checkbox" name="sex" value="女">语文
    </label>
</div>
<pre>加载状态</pre>
<button id="mybutton" type="button" data-loading-text="Loading..." class="btn btn-primary " onautocomplete="off">
    加载状态
</button>
<pre>折叠插件 collapse</pre>
<button class="btn btn-primary" data-toggle="collapse" data-target="#collapse-content">Bootstrap</button>
<div class="collapse" id="collapse-content">
    <div class="well">这是一个折叠按钮，点击可以显示</div>
</div>
<pre>手风琴式折叠panel-group collapseParent负责展开一个其他隐藏</pre>
<div class="panel-group" id="collapseParent"><%--collapseParent--%>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4><a href="#panel-collapseOne" data-toggle="collapse">第一部分</a></h4>
        </div>
        <div id="panel-collapseOne" style="padding: 0 20px" class="panel-collapse collapse in" data-parent="#collapseParent">
            <p>第一部分内容 这是一个手风琴式折叠  假装有很多内容 假装有很多内容 假装有很多内容 假装有很多内容 假装有很多内容</p>
            <p>假装有很多内容</p>
            <p>假装有很多内容</p>
            <p>假装有很多内容</p>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4><a href="#panel-collapseTwo" data-toggle="collapse">第二部分</a></h4>
        </div>
        <div id="panel-collapseTwo" style="padding: 0 20px" class="panel-collapse collapse" data-parent="#collapseParent">
            <p>第一部分内容 这是一个手风琴式折叠  假装有很多内容 假装有很多内容 假装有很多内容 假装有很多内容 假装有很多内容</p>
            <p>假装有很多内容</p>
            <p>假装有很多内容</p>
            <p>假装有很多内容</p>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4><a href="#panel-collapseThree" data-toggle="collapse">第三部分</a></h4>
        </div>
        <div id="panel-collapseThree" style="padding: 0 20px" class="panel-collapse collapse" data-parent="#collapseParent">
            <p>第一部分内容 这是一个手风琴式折叠  假装有很多内容 假装有很多内容 假装有很多内容 假装有很多内容 假装有很多内容</p>
            <p>假装有很多内容</p>
            <p>假装有很多内容</p>
            <p>假装有很多内容</p>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4><a href="#panel-collapseFour" data-toggle="collapse">第四部分</a></h4>
        </div>
        <div id="panel-collapseFour" style="padding: 0 20px" class="panel-collapse collapse" data-parent="#collapseParent">
            <p>第一部分内容 这是一个手风琴式折叠  假装有很多内容 假装有很多内容 假装有很多内容 假装有很多内容 假装有很多内容</p>
            <p>假装有很多内容</p>
            <p>假装有很多内容</p>
            <p>假装有很多内容</p>
        </div>
    </div>
</div>
<br>
<pre>使用js实现手风琴折叠样式  不建议这么实用  不太好  以及手动控制展开折叠</pre>
<button id="mycollapse" class="btn btn-primary">手动控制手风琴开</button>
<button id="mycollapse2" class="btn btn-primary">手动控制手风琴关</button>
<button id="mycollapse3" class="btn btn-primary">手动控制手风琴反转</button>
<br>
<h1>轮播插件  即图片轮播</h1>
<pre>轮播插件 轮播器myCarousel slide</pre>
<div id="myCarousel" class="carousel slide" style="width: 1000px">
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="item active">
            <img src="../skins/imge/p03.jpg" alt="第一张">
            <div class="carousel-caption">第一张图片</div>
        </div>
        <div class="item">
            <img src="../skins/imge/p03.jpg" alt="第二张">
            <div class="carousel-caption">第一张图片</div>
        </div>
        <div class="item">
            <img src="../skins/imge/p03.jpg" alt="第三张">
            <div class="carousel-caption">第一张图片</div>
        </div>
    </div>
    <a href="#myCarousel" data-slide="prev" class="carousel-control left">&lsaquo;</a>
    <a href="#myCarousel" data-slide="next" class="carousel-control right">&rsaquo;</a>
</div>
<button class=" btn btn-primary" id="carousel-btn1">开始轮播</button>
<button class="btn btn-primary" id="carousel-btn2">停止轮播</button>
<button class="btn btn-primary" id="carousel-btn3">第三条</button>
<button class="btn btn-primary" id="carousel-btn4">上一个</button>
<button class="btn btn-primary" id="carousel-btn5">下一个</button>
<br>
<h1>附加导航插件</h1>
<pre>附加导航插件scroll  在屏幕某处实现锚点功能
<p><a href="scroll.jsp">scroll</a></p>
</pre>

<div class="container">
    <div class="row">
        <div class="col-md-3">

        </div>
        <div class="col-md-9">

        </div>
    </div>
</div>
<script type="text/javascript" src="../skins/js/jquery.js"></script>
<script type="text/javascript" src="../skins/js/bootstrap.js"></script>
<script type="text/javascript">
    //弹出框事件
    $("#myButton").on("click",function(){
        $("#Mydialog6").modal("show");//
    })
    $("#myButton2").on("click",function(){
        $("#Mydialog6").modal({
            show : true,//如果是 true，初始化时，默认显示；如果是 false，初始化时，默认隐藏。
            backdrop : true,//默认值 true，表示背景存在黑灰透明遮罩，且单击空白背景可关闭弹窗；如果为 false，表示背景不存在黑灰透明遮罩，且点击空白背景不可关闭弹窗；是字符串'staic'，表示背景存在黑灰透明遮罩，且点击空白不可关闭弹窗。
            keyboard : true,//如果是 true，按 esc 键会关闭窗口；如果是 false，按 esc 键会不会关闭。
            remote : null//远程获取指定内容填充到 modal-content 容器内。
        });
    })
    $('#Mydialog6').on('show.bs.modal', function () {
        alert('在 show 方法调用时立即触发！');
    });
    $('#Mydialog6').on('shown.bs.modal', function () {
        alert('在模态框显示完毕后触发！');
    });
    $('#Mydialog6').on('hide.bs.modal', function () {
        alert('在 hide 方法调用时立即触发！');
    });
    $('#Mydialog6').on('hiden.bs.modal', function () {
        alert('在模态框显示完毕后触发！');
    });
    $('#myModal').on('loade.bs.modal', function () {
        alert('远程数据加载完毕后触发！');
    });
    //下拉菜单的四种事件
    $("#myDropdown").on('show.bs.dropdown', function () {
        alert('在 show 方法调用时立即触发！');
    });

    //滚动监听插件
    $("#content").scrollspy({ //设置 scrol，将设置滚动容器监听。
        offset:0,//默认值为 10，固定弄内容距滚动容器 10 像素以内，就高亮显示所对应的菜单。
        target:"#myNav2"//设置#nav，绑定指定监听的菜单
    });
    //滚动监听还有个切换到新条目的事件activatebscrolspy 
    $("#nav").on("activate.bs.scrollspy",function () {
        alert("每当一个新条目被激活后都将由滚动监听插件触发此事件");
    });
    //删除一节滚动监听内容并刷新监听区域

    function removeSec(e){
        $(e).parents("#sec").remove();
        $("#content2").scrollspy("refresh"); //删除内容时，刷新一下 DOM，避免导航监听错位
    }
    //使用js来调用实现tab页的切换
    $("#nav2 a").on("click",function (e) {
       // e.prevntDefault();
        $(this).tab('show');
    });
    //tab页事件类型
    $("#nav2 a").on("show.bs.tab", function () {
        alert('调用 tab 时触发！');
    });
    //要使用提示工具插件必须绑定js事件
    $("#a").tooltip();
    //使用js实现呢提示工具类的使用
    $("#a1").tooltip({
        animation:false,
        html:true,
        placement:"auto",
        //selector:"a[rel=toltip]",//默认 false，可以选择绑定指定的选择器。通过父节点选取
        trigger:"foucs hover",
        delay:{
            show:500,
            hide:100,
        },
        template:"<div style='width: 200px;height:40px;background: blueviolet;'>我是提示信息</div>",
    });
    //提示工具也有四种方法
    //显示
    //$("#a1").tooltip('show');
    //隐藏
    //$("#a1").tooltip('hide');
    //反转显示和隐藏
    //$("#a1").tooltip('toggle');
    //隐藏并销毁 以后不再显示
    //$("#a1").tooltip('destroy');
    /**
     * 跟其他的一样有四种事件 触发前  触发后 隐藏前 隐藏后
     */
    //$('#a1').on('show.bs.tooltip', function () {
    //  alert('调用 show 时触发！');
    //popover弹出窗事件 必须有和上面的那个一样
    $("#myBtn2").popover();
    //按钮加载状态
    $("#mybutton").on("click",function(){
        var btn = $(this).button('loading');
        setTimeout(function(){
            btn.button('reset');
        },1000);
    });
    //手动调用展开 收缩手风琴   所有展开等的都有这三种方法show hide toggle反转
    $("#mycollapse").on("click",function(){
            $("#panel-collapseOne").collapse('show');
    })
    $("#mycollapse2").on("click",function(){
        $("#panel-collapseOne").collapse('hide');
    })
    $("#mycollapse3").on("click",function(){
        $("#panel-collapseOne").collapse('toggle');
    })
    //手风琴折叠样式Collapse 插件中事件有四种。与上面相同
    //图片轮播js设置
    $("#myCarousel").carousel({
        //设置自动播放2秒
        interval:2000,
        //设置暂停按钮事件
        pause:'hover',
        //设置只轮播一次
        //wrap:false,
    });
    //轮播插件的各种事件
    $("#carousel-btn1").on("click",function(){
        $("#myCarousel").carousel('cycle');
    });
    $("#carousel-btn2").on("click",function(){
        $("#myCarousel").carousel('pause');
    });
    $("#carousel-btn3").on("click",function(){
        $("#myCarousel").carousel(3);
    });
    $("#carousel-btn4").on("click",function(){
        $("#myCarousel").carousel('prev');
    });
    $("#carousel-btn5").on("click",function(){
        $("#myCarousel").carousel('next');
    });
    //轮播的两个事件
  /*  $("#myCarousel").on("slide.bs.carousel", function () {
        alert('当调用 slide 实例方式时立即触发');
    });
    $('#myCarousel').on('slid.bs.carousel', function () {
        alert('当轮播完成一个幻灯片触发');
    });*/
</script>
</body>

</html>
