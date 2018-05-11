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
		<title></title>
		<link href="../skins/css/bootstrap.css" rel="stylesheet" type="text/css" />
		<link href="../skins/css/main.css" rel="stylesheet" type="text/css" />
		<link href="../skins/css/pagination.css" rel="stylesheet" type="text/css" />
		<link href="../skins/css/message.css" rel="stylesheet" type="text/css"/>
		<link rel="stylesheet" type="text/css" href="../skins/css/common.css" />
		<link rel="stylesheet" type="text/css" href="../skins/css/index.css" />
		<script src="../skins/js/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="../skins/js/bootstrap.js"></script>
		<script type="text/javascript" src="../skins/js/arttemplate.js"></script>
		<script type="text/javascript" src="../skins/js/jquery.pagination.js"></script>
		<script type="text/javascript" src="../skins/js/message.min.js"></script>
		<script src="../skins/js/index.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
	<%--<div class="myHead">
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
	</div>--%>
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

		<div id="content">
			<div id="menu">
				<div class="left_menu">
					<div id="item1" class="item">
						<a href="#">
							<span>前端开发</span>
							<i>></i>
						</a>
					</div>
					<div id="item2" class="item">
						<a href="#">
							<span>后端开发</span>
							<i>></i>
						</a>
					</div>
					<div id="item3" class="item">
						<a href="#">
							<span>移动开发</span>
							<i>></i>
						</a>
					</div>
					<div id="item4" class="item">
						<a href="#">
							<span>数据库</span>
							<i>></i>
						</a>
					</div>
					<div id="item5" class="item">
						<a href="#">
							<span>云计算&大数据</span>
							<i>></i>
						</a>
					</div>
					<div id="item6" class="item">
						<a href="#">
							<span>运维&测试</span>
							<i>></i>
						</a>
					</div>
					<div id="item7" class="item">
						<a href="#">
							<span>视觉设计</span>
							<i>></i>
						</a>
					</div>
				</div>
				<div class="sub_menu" style="background-image: url(../skins/imge/fe.png);">
					<div>
						<h3>分类目录</h3>
						<p>
							<strong>基础：</strong>
							<a href="">HTML/CSS</a> /
							<a href="">JavaScript</a> /
							<a href="">JQuery</a>
						</p>
						<p>
							<strong>进阶：</strong>
							<a href=""> HTML5 </a> /
							<a href=""> CSS3 </a> /
							<a href=""> Node.js </a> /
							<a href=""> AngularJS </a> /
							<a href=""> Bootstrap </a> /
							<a href=""> React </a> /
							<a href=""> Sass/Less </a> /
							<a href=""> Vue.js </a> /
							<a href=""> WebApp </a>
						</p>
						<p>
							<strong>其他：</strong>
							<a href="">前端工具</a>
						</p>
					</div>
					<div>
						<h3>推荐</h3>
						<p>
							<a href="">课程 | CSS深入理解之overflow</a>
						</p>
						<p>
							<a href="">课程 | 前端开发工具技巧介绍—Sublime篇</a>
						</p>
						<p>
							<a href="">课程 | 移动端开发框架Zepto.js入门</a>
						</p>
					</div>
				</div>
				<div class="sub_menu" style="background-image: url(../skins/imge/be.png);">
					<div>
						<h3>分类目录</h3>
						<p>
							<a href=""> PHP </a>/
							<a href=""> Java </a>/
							<a href=""> Python </a>/
							<a href=""> C </a>/
							<a href=""> C++ </a>/
							<a href=""> GO </a>/
							<a href=""> C# </a>
						</p>
					</div>
					<div>
						<h3>推荐</h3>
						<p>
							<a href="">课程 | C语言入门</a>
						</p>
						<p>
							<a href="">课程 | JAVA生成二维码</a>
						</p>
						<p>
							<a href="">课程 | 数据结构探险—栈篇</a>
						</p>
					</div>
				</div>
				<div class="sub_menu" style="background-image: url(../skins/imge/mobile.png);">
					<div>
						<h3>分类目录</h3>
						<p>
							<a href=""> Android </a>/
							<a href=""> IOS </a>/
							<a href=""> Unity 3D </a>/
							<a href=""> Cocos2d-x </a>
						</p>
					</div>
					<div>
						<h3>推荐</h3>
						<p>
							<a href="">课程 | Android-仿微信语音聊天</a>
						</p>
						<p>
							<a href="">课程 | Android自定义任意层级树形控件</a>
						</p>
						<p>
							<a href="">课程 | 中国首届swift开发者大会</a>
						</p>
					</div>
				</div>
				<div class="sub_menu" style="background-image: url(../skins/imge/data.png);">
					<div>
						<h3>分类目录</h3>
						<p>
							<a href=""> MySQL </a>/
							<a href=""> MongoDB </a>/
							<a href=""> Oracle </a>/
							<a href=""> Oracle </a>
						</p>
					</div>
					<div>
						<h3>推荐</h3>
						<p>
							<a href="">课程 | MongoDB复制集—容灾核心选举</a>
						</p>
						<p>
							<a href="">课程 | MongoDB读写分离的适用性</a>
						</p>
						<p>
							<a href="">课程 | Duang~MySQLi扩展库来袭</a>
						</p>
					</div>
				</div>
				<div class="sub_menu" style="background-image: url(../skins/imge/yjs.png);">
					<div>
						<h3>分类目录</h3>
						<p>
							<a href=""> 大数据 </a>/
							<a href=""> 云计算 </a>
						</p>
					</div>
					<div>
						<h3>推荐</h3>
						<p>
							<a href="">课程 | R语言基础</a>
						</p>
						<p>
							<a href="">课程 | 阿里云助力弹性伸缩服务</a>
						</p>
						<p>
							<a href="">课程 | OpenStack+ 企业实践论坛</a>
						</p>
					</div>
				</div>
				<div class="sub_menu" style="background-image: url(../skins/imge/yw.png);">
					<div>
						<h3>分类目录</h3>
						<p>
							<a href=""> 测试 </a>/
							<a href=""> Linux </a>
						</p>
					</div>
					<div>
						<h3>推荐</h3>
						<p>
							<a href="">课程 | Shell典型应用之主控脚本实现</a>
						</p>
						<p>
							<a href="">课程 | Shell典型应用之主控脚本实现</a>
						</p>
						<p>
							<a href="">课程 | Shell典型应用之系统信息及运行状态获取</a>
						</p>
					</div>
				</div>
				<div class="sub_menu" style="background-image: url(../skins/imge/photo.png);">
					<div>
						<h3>分类目录</h3>
						<p>
							<a href=""> Photoshop </a>/
							<a href=""> Maya </a>/
							<a href=""> Premiere </a>/
							<a href=""> ZBrush </a>
						</p>
					</div>
					<div>
						<h3>推荐</h3>
						<p>
							<a href="">课程 | Maya3D建模攻略——葵花宝典</a>
						</p>
						<p>
							<a href="">课程 | “Doge”变化术</a>
						</p>
						<p>
							<a href="">课程 | PS入门教程——新手过招</a>
						</p>
					</div>
				</div>
			</div>

			<div class="introduce">
				<div class="practise">
					<div class="title">
						实战推荐
						<a href="http://localhost:8080/daoshan-school/jsp/search.jsp?">更多 ></a>
					</div>
					<div class="item_class" data-id="310f02b2-5f35-41ef-8f1e-1a3f1f9b2328">
						<img src="../skins/imge/prictise1.jpg" height="124" width="100%" />
						<div class="item_class_intro">
							<h3>多领域通用的Python秘籍</h3>
							<p>只要用Python就一定用的到的多领域通用开发秘籍</p>
						</div>
						<div class="item_class_bottom">
							<span class="left">￥168.00</span>
							<span class="right">52人在学</span>
						</div>
					</div>
					<div class="item_class" data-id="3695cb4e-0377-4e90-9c4a-f82c2e3a6452">
						<img src="../skins/imge/prictise2.jpg" height="124" width="100%" />
						<div class="item_class_intro">
							<h3>所向披靡的响应式开发</h3>
							<p>忘记设备尺寸，一套代码适配多终端，响应式开发让用户体验和开发效率完美结合</p>
						</div>
						<div class="item_class_bottom">
							<span class="left">￥168.00</span>
							<span class="right">52人在学</span>
						</div>
					</div>
					<div class="item_class" data-id="6c529ac6-48ee-4f28-89a4-654eeaed3836">
						<img src="../skins/imge/prictise3.jpg" height="124" width="100%" />
						<div class="item_class_intro">
							<h3>飞速上手的跨平台App开发</h3>
							<p>最具潜力的HTML5移动App开发框架Ionic，天然的跨平台属性，通吃Android及iOS，简洁、易用，让你飞速上手</p>
						</div>
						<div class="item_class_bottom">
							<span class="left">￥168.00</span>
							<span class="right">52人在学</span>
						</div>
					</div>
					<div class="item_class"  data-id="896385a9-6c61-4dbd-9830-3d47a0007eb0">
						<img src="../skins/imge/prictise4.jpg" height="124" width="100%" />
						<div class="item_class_intro">
							<h3>打造扛得住的MySQL数据库架构</h3>
							<p>面面俱到讲解影响MySQL性能的各个因素，让你将MySQL架构了然于胸。</p>
						</div>
						<div class="item_class_bottom">
							<span class="left">￥168.00</span>
							<span class="right">52人在学</span>
						</div>
					</div>
					<div class="item_class"  data-id="5b44fd6a-fa00-4550-9584-6e6f496ea84c" style="margin-right: 0;">
						<img src="../skins/imge/prictise5.jpg" height="124" width="100%" />
						<div class="item_class_intro">
							<h3>7天搞定Node.js微信公众号开发</h3>
							<p>用Koa框架、ES2015新特性及MongoDB数据库，开发微信公众号。</p>
						</div>
						<div class="item_class_bottom">
							<span class="left">￥168.00</span>
							<span class="right">52人在学</span>
						</div>
					</div>

				</div>
				<div class="free">
					<div class="title">
						免费课程
						<a href="http://localhost:8080/daoshan-school/jsp/search.jsp?">更多 ></a>
					</div>
					<div class="item_class" data-id="ee0b79bf-4f66-44c3-9caa-791572251bf5">
						<img src="../skins/imge/free1.jpg" height="124" width="100%" />
						<div class="item_class_intro">
							<h3>
								<i>初</i>
								 HTML+CSS基础课程
							</h3>
							<p> 8小时带领大家步步深入学习标签的基础知识，掌握各种样式的基本用法。</p>
						</div>
						<div class="item_class_bottom">
							<span class="left" style="color: grey;">446679人在学</span>
							<!--<span class="right">52人在学</span>-->
						</div>
					</div>
					<div class="item_class" data-id="82f379f8-e8c5-4f7d-a2f6-4a1600bcc4cf">
						<img src="../skins/imge/free2.jpg" height="124" width="100%" />
						<div class="item_class_intro">
							<h3>
								<i>初</i>
								 Java入门第一季
							</h3>
							<p> 从环境搭建、基础语法开始，带你入门</p>
						</div>
						<div class="item_class_bottom" >
							<span class="left" style="color: grey;">446679人在学</span>
						</div>
					</div>
					<div class="item_class" data-id="92382ecb-ddff-418b-9382-907414963cfe">
						<img src="../skins/imge/free3.jpg" height="124" width="100%" />
						<div class="item_class_intro">
							<h3>
								<i>初</i>
								 PS入门教程——新手过招
							</h3>
							<p> PS的基本使用方法，带你入门。</p>
						</div>
						<div class="item_class_bottom">
							<span class="left" style="color: grey;">446679人在学</span>
						</div>
					</div>
					<div class="item_class" data-id="71f9f48e-d1ea-4983-86fb-0f5f02d3de53">
						<img src="../skins/imge/free4.jpg" height="124" width="100%" />
						<div class="item_class_intro">
							<h3>
								<i>初</i>
								 JavaScript入门篇
							</h3>
							<p> 做为一名Web攻城狮的必备技术，让您从糊涂到明白，快速认识JavaScript。</p>
						</div>
						<div class="item_class_bottom">
							<span class="left" style="color: grey;">446679人在学</span>
						</div>
					</div>
					<div class="item_class" data-id="fdb42d50-e64f-4888-af58-458c397696e7" style="margin-right: 0;">
						<img src="../skins/imge/free5.jpg" height="124" width="100%" />
						<div class="item_class_intro">
							<h3>
								<i>初</i>
								 C语言入门
							</h3>
							<p> 进入编程世界的必修课-C语言</p>
						</div>
						<div class="item_class_bottom">
							<span class="left" style="color: grey;">446679人在学</span>
						</div>
					</div>
				</div>
			</div>

			<div class="web_learn">
				<div class="web_l">
					<p>web<br/>前端工程师</p>
					<a id="pro_path" href="#">职业路径 ></a>
					<div class="web_l_bottom">
						<a href="#">JQuery源码探索之旅</a>
					</div>
				</div>
				<div class="web_m">
					<div class="web_m_top">
						<p>前端经典案例集萃之“图片、信息展示”</p>
					</div>
					<div class="web_m_bottom">
						<p>像搭积木一样的组件式开发</p>
					</div>
				</div>
				<div class="web_m2">
					<div class="item_class web_m2_top" data-id="de3f1376-7771-4d79-8e05-20e0bb31e1d7">
						<img src="../skins/imge/web1.jpg" height="124" width="100%" />
						<div class="item_class_intro">
							<h3>
								<i>中</i>
								 oeasy教你玩转css花园
							</h3>
							<p> 36个设计让你彻底了解css</p>
						</div>
						<div class="item_class_bottom">
							<span class="left" style="color: grey;">24772人在学</span>
						</div>
					</div>
					<div class="item_class web_m2_bottom " data-id="58e47520-9955-4b94-8fe5-a66bb1dd0f89">
						<img src="../skins/imge/web2.jpg" height="124" width="100%" />
						<div class="item_class_intro">
							<h3>
								<i>初</i>
								帝堵抢车位动画制作
							</h3>
							<p> 带领大家做一个抢车动画效果。</p>
						</div>
						<div class="item_class_bottom">
							<span class="left" style="color: grey;">22499人在学</span>
						</div>
					</div>
				</div>

				<div class="item_class web_r" data-id="6b9ea1bc-248e-469b-a424-c41de3a5fd8b">
					<img src="../skins/imge/web3.jpg" height="124" width="100%" />
					<div class="item_class_intro">
						<h3>
								<i>高</i>
								移动端开发框架Zepto.js
							</h3>
						<p> 移动端开发必学框架---Zepto.js</p>
					</div>
					<div class="item_class_bottom">
						<span class="left" style="color: grey;">22499人在学</span>
					</div>
					<div class="list">
						<ul>
							<li>
								<a href="#">阿里D2前端技术论坛——2015融合</a>
							</li>
							<li>
								<a href="#">QQ空间时光轴特效</a>
							</li>
							<li>
								<a href="#">node+mongodb 建站攻略（一期）</a>
							</li>
							<li>
								<a href="#">图片展示特效</a>
							</li>
							<li>
								<a href="#">JS实现“旋转木马”幻灯片效果</a>
							</li>
						</ul>
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
					©CopyRight 2018-2019  朱同 版权所有 17862979628
				</div></div></div></div>
	</body>
	<script type="text/javascript">
        global.context = "<%=request.getContextPath()%>";
	</script>
</html>