"use strict";
var global = {
    context: null,
    data:null
};

$(function () {
    initPageDom();
    initPageEvent();
    initUser();
});

function initPageDom(){

    $('#Mydialog4').modal('show');
}

function initPageEvent(){

    $(document).on("click","#search-begin", toSearch);

    $(document).on("click","#hide", hideUser);

    $(document).on("click","#user-name", showUser);

    $(document).on("blur","#user-name-1", checkName);

    $(document).on("blur","#input-name", checkName2);
    $(document).on("blur","#email-input", checkEmail);

    $(document).on("click","#checkEmail", sendEmail);

}


//校验邮箱
function checkEmail() {

    var email = $("#email-input").val();
    var patter_special_char = /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/;

    if(patter_special_char.test(email)){
        $("#message5").hide();
        $("#message6").show();
    }else {

        $("#message6").hide();
        $("#message5").show();
    }
}
//校验昵称
function checkName() {

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
        $("#message1").show();
        return ;
    }else {
        $("#message1").hide();
        $("#message2").show();
    }
}

//发送邮件验证码
function sendEmail() {

    var userEmail = $("#email-input").val();
    var patter_special_char = /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/;


    if(patter_special_char.test(userEmail)){

    }else {
        message2("邮箱格式不正确，请检查！","error");
        return;
    }

    $("#checkEmail").attr("disabled","disabled");
    $("#checkEmail").html("发送中...");
    var data = {
        "userEmail": userEmail
    }
    var url = encodeURI(global.context + "/dsxh/common/sendEmail");
    $.ajax({
        url: url,
        type: "POST",
        async:true,
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {

            if("success" == data.data.result){
                $("#checkEmail").html("已发送");
                $("#checkEmail-2").attr("disabled","");
            }else {
                message2("验证码发送失败，请检查邮箱重试！！","error");
                $("#checkEmail").attr("disabled","");
                $("#checkEmail").html("发送验证码");
            }
        },
        error: function () {
        }
    });
}




function checkName2() {

    var name = $(this).val();

    if(name ==null || name == ""){
        $("#message4").hide();
        $("#message3").show();
        return ;
    }

    var patter_special_char = /[,;；，《》]+/;

    var matchResult = name.match(patter_special_char);
    if(matchResult != null){
        $("#message4").hide();
        $("#message3").show();
        return ;
    }else {
        $("#message3").hide();
        $("#message4").show();
    }
}


function hideUser() {
    $(".user-info-message").hide();
}
function showUser() {
    $(".user-info-message").show();
}

function toSearch() {
    var search = $("#search-info").val();
    window.location.href= global.context+"/jsp/search.jsp?"+search;
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


function initUser() {
    var url = encodeURI(global.context + "/dsxh/user/getUserLoginInfo");
    $.ajax({
        url: url,
        type: "POST",
        async:false,
        //data: JSON.stringify(JsonData),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {

            if (data.data.data == "failure") {
                $("#user-name").hide();
                $("#goto-login").show();
            }
            else{
                $("#user-name").attr("data-id",data.data.data.id);
                $("#user-name").html(data.data.data.userName);
                $("#user-name").show();
                $("#goto-login").hide();
            }
        },
        error: function () {
        }
    });
}