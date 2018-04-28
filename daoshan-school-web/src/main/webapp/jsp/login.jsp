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
      <div class="cont_info_log_sign_up">
        <div class="col_md_login">
          <div class="cont_ba_opcitiy">
            <h2>LOGIN</h2>
            <p style="font-size: smaller; color: #b656b7; margin-bottom: 14px;">未来的你，一定会感谢如今努力的自己！</p>
            <button class="btn_login" onclick="cambiar_login()">LOGIN</button>
          </div>
        </div>
        <div class="col_md_sign_up">
          <div class="cont_ba_opcitiy">
            <h2>SIGN UP</h2>
            <p style="font-size: smaller; color: #b656b7; margin-bottom: 14px;">加入我们，勇敢做最完美的自己！</p>
            <button class="btn_sign_up" onclick="cambiar_sign_up()">SIGN UP</button>
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
          <button id ="login" class="btn_login" onclick="cambiar_login()">LOGIN</button>
        </div>
        <div class="cont_form_sign_up"> <a href="#" onclick="ocultar_login_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
          <h2>SIGN UP</h2>
          <input id = "userName_sign" type="text" placeholder="用户名" />
          <input id="user_sign" type="text" placeholder="昵称" />
          <input id="password_sign" type="password" placeholder="密码" />
          <input id="password_try" type="password" placeholder="确认密码" />
          <button id = "register" class="btn_sign_up" onclick="cambiar_sign_up()">SIGN UP</button>
        </div>
      </div>
    </div>
  </div>
</div>
<div id="myAlert" class="alert alert-warning">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>警告！</strong>账户名或密码不正确！
</div>
<script type="text/javascript" src="../skins/js/jquery.js"></script>
<script type="text/javascript" src="../skins/js/bootstrap.js"></script>
<script type="text/javascript" src="../skins/js/message.min.js"></script>
<script src="../skins/js/login.js"></script>
<script type="text/javascript">
    global.context = "<%=request.getContextPath()%>";
</script>
</body>

</body>
</html>
