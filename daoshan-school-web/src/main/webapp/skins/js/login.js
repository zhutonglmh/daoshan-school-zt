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
                window.location.href= global.context+"/jsp/index.jsp?";
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
    var password = $("#userNameLogin").val();
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