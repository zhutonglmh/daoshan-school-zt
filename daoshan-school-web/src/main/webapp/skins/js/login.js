"use strict";
var global = {
    context: null
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
}

//注册
function signClick() {

    var user = $("#userName_sign").val();
    var userName = $("#user_sign").val();
    var password = $("#password_sign").val();
    var password2 = $("#password_try").val();
    if(password != password2){return;}

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
                $("#myAlert").alert();
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



function ocultar_login_sign_up() {

document.querySelector('.cont_forms').className = "cont_forms";  
document.querySelector('.cont_form_sign_up').style.opacity = "0";               
document.querySelector('.cont_form_login').style.opacity = "0"; 

setTimeout(function(){
document.querySelector('.cont_form_sign_up').style.display = "none";
document.querySelector('.cont_form_login').style.display = "none";
},500);  
  
  }