"use strict";
var global = {
    context: "/daoshan-school"
};

$(function () {
    initPageDom();
    initPageEvent();
});

function initPageDom(){
    //queryAllStudent()
}
function initPageEvent(){

    //d登录
    $(document).on("click","#login", loginClick);
    //注册
    $(document).on("click","#register", signClick);

    $(document).on("blur","#user_sign", checkName4());
    //校验用户名是否已经被使用
    $(document).on("blur","#userName_sign", checkName3);

    $(document).on("click","#forget_pwd", Mydialog4Show);

    $(document).on("click","#find", find);

    $(document).on("click","#check", check);

    $(document).on("click","#commit", commit);
    
    //登录回车事件
    $("#passwordLogin").keyup(function (event) {
        if(event.keyCode ==13){
            loginClick();
        }
    });

    //注册回车事件
    $("#password_try").keyup(function (event) {
        if(event.keyCode ==13){
            signClick();
        }
    });
}
//确认修改
function commit() {

    var iphone =  $("#zt_01").attr("data-iphone");
    var code = $("#pwd").val();
    var data = {
        "id": iphone,
        "pwd":code
    }
    var url = encodeURI(global.context + "/dsxh/user/upd");
    $.ajax({
        url: url,
        type: "POST",
        async:true,
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {

            if("success" == data.data.data){
                $('#Mydialog4').modal('hide');
            }else {
                $("#message4").empty().html("修改失败！").show();
            }
        },
        error: function () {
        }
    });
}
function check() {

    var iphone =  $("#zt_01").attr("data-id");
    var code = $("#input_two").val();
    var data = {
        "userIphone":iphone,
        "card":code
    }
    var url = encodeURI(global.context + "/dsxh/common/checkIphone");
    $.ajax({
        url: url,
        type: "POST",
        async:true,
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {

            if("success" == data.data){
                $("#two").show();
                $("#one").hide();
                $("#message4").hide();
            }else {
                $("#message4").empty().html("验证码不正确！").show();
            }
        },
        error: function () {
        }
    });
}
function find() {

    var name = $("#input_one").val();
    var url = encodeURI(global.context + "/dsxh/user/find");
    var JsonData = {
        "name" : name
    }
    $.ajax({
        url: url,
        type: "POST",
        async:false,
        data: JSON.stringify(JsonData),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {

            if (data.data.data == null) {
                $("#message4").empty().html("无此用户！").show();
            }
            else if(data.data.data.dsxhUserDetail == null){
                $("#message4").empty().html("此用户未绑定手机，请联系管理员17862979628找回密码！").show();
            }
            else{
                $("#zt_01").attr("data-id",data.data.data.dsxhUserDetail.userIphone);
                $("#zt_01").attr("data-iphone",data.data.data.id);
                $("#zt_01").empty().html("您正在找回用户:"+data.data.data.name+"的密码！");
                $("#one").show();
                $("#iphone").empty().html("请输入手机号"+data.data.data.dsxhUserDetail.userIphone+"收到的验证码");
                $("#title").hide();
            }
        },
        error: function () {
        }
    });
}
//找回密码
function Mydialog4Show() {

    $('#Mydialog4').modal('show');
    $("#title").show();
    $("#one").hide();
    $("#two").hide();
    $("#message4").hide();

}
//校验用户昵称
function checkName4() {
    var name = $(this).val();

    if(name ==null || name == ""){
        $("#message2").hide();
        $("#message1").show();
        return ;
    }

    var patter_special_char = /[,;；，《》]+/;

    var matchResult = name.match(patter_special_char);
    if(matchResult != null){
        $("#message").show();
        return ;
    }else {
        $("#message").hide();
    }
}
//校验名称是否可用
function checkName3() {

    var name = $(this).val();

    if(name ==null || name == ""){
        $("#message2").hide();
        $("#message1").show();
        return ;
    }

    var patter_special_char = /[,;；，《》]+/;

    var matchResult = name.match(patter_special_char);
    if(matchResult != null){
        $("#message2").hide();
        $("#message3").show();
        return ;
    }else {

        var url = encodeURI(global.context + "/dsxh/user/checkUser");
        var JsonData = {
            "name" : name
        }
        $.ajax({
            url: url,
            type: "POST",
            async:false,
            data: JSON.stringify(JsonData),
            contentType: "application/json",
            dataType: "JSON",
            success: function (data) {

                if (data.data.data == "success") {
                    $("#message3").hide();
                    $("#message2").hide();
                    return;
                }
                else{
                    $("#message3").hide();
                    $("#message2").show();
                    return;
                }
            },
            error: function () {
            }
        });

    }
}
//注册
function signClick() {

    var user = $("#userName_sign").val();
    var userName = $("#user_sign").val();
    var password = $("#password_sign").val();
    var password2 = $("#password_try").val();
    if(user == ""){
        message2("用户名不能为空","warning");
        return;}
    if(userName == ""){
        message2("用户昵称不能为空!","warning");
        return;}
    if(password == ""){
        message2("密码不能为空!","warning");
        return;}
    if(password != password2){
        message2("两次输入密码不一致!","warning");
        return;}

    var url = encodeURI(global.context + "/dsxh/user/insert");

    var JsonData = {
        "name" : user,
        "pwd" : password,
        "userName" : userName
    }

    $.ajax({
        url: url,
        type: "POST",
        async:false,
        data: JSON.stringify(JsonData),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {

            if (data.data.data == "success") {
                message2("注册成功！获得系统将赠送您10000元代金券。将要跳转到首页！","success")
                setTimeout(function () {
                    window.location.href= global.context+"/jsp/index.jsp?";
                },2000);
            }
            else{
            }
        },
        error: function () {
        }
    });
}

//登录
function loginClick() {

    var username = $("#userNameLogin").val();
    var password = $("#passwordLogin").val();
    if(null == username  || username == ""){
        message2("用户名不能为空！","warning");
        return;
    }
    if(null == password  || password == ""){
        message2("密码不能为空！","warning");
        return;
    }
    var url = encodeURI(global.context + "/dsxh/user/userLogin");
    var JsonData = {
        "name" : username,
        "pwd" : password
    }
    $.ajax({
        url: url,
        type: "POST",
        async:false,
        data: JSON.stringify(JsonData),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {

            if (data.data.data.result == "success") {
                window.location.href= global.context+"/jsp/index.jsp?"+data.data.data.data.id;
            }
            else{
                message2("用户名或密码错误！","error");
            }
        },
        error: function () {
        }
    });
}













function cambiar_login() {
  document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";  
document.querySelector('.cont_form_login').style.display = "block";
document.querySelector('.cont_form_sign_up').style.opacity = "0";               

setTimeout(function(){  document.querySelector('.cont_form_login').style.opacity = "1"; },400);  
  
setTimeout(function(){    
document.querySelector('.cont_form_sign_up').style.display = "none";
},200);  
  }

function cambiar_sign_up(at) {
  document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_sign_up";
  document.querySelector('.cont_form_sign_up').style.display = "block";
document.querySelector('.cont_form_login').style.opacity = "0";
  
setTimeout(function(){  document.querySelector('.cont_form_sign_up').style.opacity = "1";
},100);  

setTimeout(function(){   document.querySelector('.cont_form_login').style.display = "none";
},400);  


}

function message2(message, type) {

    $.message({
        message:message,    //提示信息
        time:'2000',           //显示时间（默认：2s）
        type:type,        //显示类型，包括4种：success.error,info,warning
        showClose:false,       //显示关闭按钮（默认：否）
        autoClose:true,
    });
}

function ocultar_login_sign_up() {

document.querySelector('.cont_forms').className = "cont_forms";  
document.querySelector('.cont_form_sign_up').style.opacity = "0";               
document.querySelector('.cont_form_login').style.opacity = "0"; 

setTimeout(function(){
document.querySelector('.cont_form_sign_up').style.display = "none";
document.querySelector('.cont_form_login').style.display = "none";
},500);  
  
  }