<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2017/11/26
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
<meta charset="UTF-8">
<title>道山学海-登录</title>
  <link href="../skins/css/bootstrap.css" rel="stylesheet" type="text/css" />
  <link href="../skins/css/message.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="../skins/css/style.css">


</head>

<body >
<%--<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>--%>
<body>
<div class="cotn_principal">
  <div class="cont_centrar">
    <div class="cont_login">
      <div style="    font-size: 28px;
    position: absolute;
    margin-left: 110px;
    color: #dcffd3;">欢迎登录道山学海开放式网络课堂</div>
      <div class="cont_info_log_sign_up">
        <div class="col_md_login">
          <div class="cont_ba_opcitiy">
            <h2>LOGIN</h2>
            <p style="font-size: smaller; color: #b656b7; margin-bottom: 14px;">未来的你，一定会感谢如今努力的自己！</p>
            <button class="btn_login" onclick="cambiar_login()">登  录</button>
          </div>
        </div>
        <div class="col_md_sign_up">
          <div class="cont_ba_opcitiy">
            <h2>SIGN UP</h2>
            <p style="font-size: smaller; color: #b656b7; margin-bottom: 14px;">加入我们，勇敢做最完美的自己！</p>
            <button class="btn_sign_up" onclick="cambiar_sign_up()">注  册</button>
          </div>
        </div>
      </div>
      <div class="cont_back_info">
        <div class="cont_img_back_grey"> <img src="../skins/imge/po.jpg" alt="" /> </div>
      </div>
      <div class="cont_forms" >
        <div class="cont_img_back_"> <img src="../skins/imge/po.jpg" alt="" /> </div>
        <div class="cont_form_login"> <a href="#" onclick="ocultar_login_sign_up()" ><i class="material-icons">&#xE5C4;</i></a>
          <h2>LOGIN</h2>
          <input id = "userNameLogin" type="text" placeholder="用户名" />
          <input id = "passwordLogin" type="password" placeholder="密码" />
          <div id="forget_pwd" >忘记密码？</div>
          <button id ="login" class="btn_login" onclick="cambiar_login()">登  录</button>

        </div>
        <div class="cont_form_sign_up"> <a href="#" onclick="ocultar_login_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
          <h2>SIGN UP</h2>
          <input id = "userName_sign" type="text" placeholder="用户名" />
          <p id="message2">用户名已存在</p>
          <p id="message3">用户名不支持特殊字符</p>
          <input id="user_sign" type="text" placeholder="昵称" />
          <p id="message">用户昵称不支持特殊字符</p>
          <input id="password_sign" type="password" placeholder="密码" />
          <input id="password_try" type="password" placeholder="确认密码" />
          <button id = "register" class="btn_sign_up" onclick="cambiar_sign_up()">注  册</button>
        </div>
      </div>
    </div>
  </div>
</div>
<div id="myAlert" class="alert alert-warning">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>警告！</strong>账户名或密码不正确！
</div>
<%--模态框声明--%>
<div class="modal fade" id="Mydialog4">
  <%--窗口声明--%>
  <div class="modal-dialog">
    <%--内容声明--%>
    <div class="modal-content" style="    height: 300px;">
      <div class="modal-header">
        <button class="close" data-dismiss="modal"><span>&times;</span></button>
        <div id="zt_01" class="modal-title buy-titlt">找回密码/暂时只支持绑定手机找回</div>
      </div>
      <div id="title"  style="    margin-left: -150px;
    margin-top: 50px;"><label>请输入要找回密码的账号:</label><input id="input_one" type="text" style="    text-align: left;"></div>
      <button id="find" class="btn btn-info" style="    float: right;
    margin-top: -28px;
    margin-right: 150px;
    height: 26px;
    line-height: 13px;">找回</button>
      <div id="one">
      <div id="iphone" style="margin-left: -200px;
    font-weight: 700;margin-top: 20px;">请填写手机号17862979628收到的验证码:</div>
        <div style="    margin-top: 20px;
    margin-bottom: 20px;    margin-left: -320px;">
          <input id="input_two" type="text" style="width: 80px"> <button id="check" class="btn btn-info" style="    height: 26px;    line-height: 13px;">验证</button>
        </div>
    </div>
      <div id="two">
        <label style="    margin-left: -230px;
    margin-right: 10px;">请设置新密码</label><input id="pwd" type="password"><br>
        <label style="    margin-right: 10px;
    margin-left: -142px;
    margin-top: 20px;">请再次输入新密码</label><input type="password">
        <button id="commit" class="btn btn-info" style="height: 26px;
    line-height: 13px;">确认</button>
      </div>
      <div id="message4" class="message" style="    margin-left: -400px;
    color: red;">提示信息</div>
    </div>


    </div>
  </div>
</div>
<script type="text/javascript" src="../skins/js/jquery.js"></script>
<script type="text/javascript" src="../skins/js/bootstrap.js"></script>
<script type="text/javascript" src="../skins/js/message.min.js"></script>
<script src="../skins/js/login.js"></script>
<%--<script type="text/javascript">
    global.context = "<%=request.getContextPath()%>";
</script>--%>
</body>

</body>
</html>
