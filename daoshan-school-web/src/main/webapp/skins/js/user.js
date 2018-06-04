"use strict";
var global = {
    context: null,
    data:null
};

$(function () {
    initPageDom();
    initPageEvent();
    initUser();

    //$("#user-image").attr("src","/daoshan-school/upload/getImage/");

});
$.ajaxSetup({
    complete: function (xhr, status) {
        //拦截器实现超时跳转到登录页面
        // 通过xhr取得响应头
        var REDIRECT = xhr.getResponseHeader("REDIRECT");
        //如果响应头中包含 REDIRECT 则说明是拦截器返回的
        if (REDIRECT == "REDIRECT") {
            var win = window;
            while (win != win.top) {
                win = win.top;
            }
            //重新跳转到 login.html
            win.location.href = global.context+"/jsp/login.jsp";
        }
    }});
function initPageDom(){

}

function initPageEvent(){

    //搜索
    $(document).on("click","#search-begin", toSearch);

    //隐藏用户
    $(document).on("click","#hide", hideUser);

    //显示用户
    $(document).on("click","#user-name", showUser);

    $(document).on("blur","#user-name-1", checkName);

    $(document).on("blur","#input-name", checkName2);
    $(document).on("blur","#email-input", checkEmail);

    $(document).on("click","#checkEmail", sendEmail);

    $(document).on("click","#uploadSubmit", uploadImage);

    $(document).on("click","#add-iphone", addIphone);

    $(document).on("click","#get-card", sendSms);

    $(document).on("blur","#iphone-input", checkNumber);

    $(document).on("click","#check-iphone", checkIphone);

    $(document).on("click","#update-iphone", addIphone);

    $(document).on("click","#update-email", updateEmail);

    $(document).on("click","#cancel-update", cancelUpdateEmail);

    $(document).on("click","#remove", removeImage);

    $(document).on("click","#checkEmail-2", checkEmails);

    //校验qq格式
    $(document).on("blur","#QQ-number", checkQQNumber);

    //保存
    $(document).on("click","#save", saveInfo);

    $(document).on("click","#user-name", showUser2);
    //登出
    $(document).on("click","#log-out", loginOut3);
}
function showUser2() {
    $(".user-info-message").show();
}

/**
 * 用户登出
 */
function loginOut3() {

    var url = encodeURI(global.context + "/dsxh/user/loginOut");
    $.ajax({
        url: url,
        type: "POST",
        async:false,
        //data: JSON.stringify(JsonData),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {
            window.location.href= global.context+"/jsp/login.jsp";
        },
        error: function () {
        }
    });
}
//保存
function saveInfo() {

    var userName = $("#user-name-1").val();
    var userSex =  $('#sex input[name="sex"]').val();
    var headImageAddress = $("#user-image").attr("data-address");
    var userMessage = $(".user-info-textarea").val();
    var userReallyName = $("#input-name").val();
    var userEmail = "shandongsunzhi@126.com"//$("#emailaddress").attr("data-email");
    var userIphone = "17862979628"//$("#user-iphone").attr("data-iphone");
    var userQqNumber = $("#QQ-number").val();

    if("" == userName){
        message2("用户昵称不能为空","error");
        return;
    }
    if("" == userSex){
        message2("用户性别不能为空","error");
        return;
    }
    if("" == headImageAddress){
        message2("将使用默认头像","info");
    }
    if("" == userReallyName){
        message2("用户未开启真实姓名","info");
    }
    if("" == userEmail){
        message2("邮箱信息不能为空","error");
        return;
    }if("" == userIphone){
        message2("手机号码不能为空","error");
        return;
    }
    if("" == userQqNumber){
        message2("QQ号码不能为空","error");
        return;
    }

    var data = {
        "userName":userName,
        "userSex":userSex,
        "headImageAddress":headImageAddress,
        "userMessage":userMessage,
        "userReallyName":userReallyName,
        "userEmail":userEmail,
        "userIphone":userIphone,
        "userQqNumber":userQqNumber,

    }
    var url = encodeURI(global.context + "/dsxh/userDetail/updUserInfo");
    $.ajax({
        url: url,
        type: "POST",
        async:true,
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {

            if("success" == data.data){
               message2("保存成功!","success");
                window.location.reload();
            }else {
                message2(data.data,"success");
            }
        },
        error: function () {
        }
    });
}

//校验qq
function checkQQNumber() {

    var qq = $("#QQ-number").val();
    var regex = /[1-9][0-9]{4,14}/;
    if(regex.test(qq)){
        $("#message7").show();
        $("#message8").hide();
        $("#qq-number-2").attr("data-number",qq);
    }else {
        $("#message7").hide();
        $("#message8").show();
    }

}
//校验邮箱
function checkEmails() {

    var emailadd = $("#email-input").val();
    var code = $("#email-caode").val();

    if("" == code){
        message2("请填写验证码","warning");
        return;
    }
    if("" == emailadd){
        message2("请填写邮箱地址","warning");
        return;
    }

    var patter_special_char = /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/;

    if(!patter_special_char.test(emailadd)){
        message2("邮箱格式不正确","warning");
        return;
    }

    var data = {
        "userEmail":emailadd,
        "card":code
    }
    var url = encodeURI(global.context + "/dsxh/common/checkEmail");
    $.ajax({
        url: url,
        type: "POST",
        async:true,
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {

            if("success" == data.data){
                $("#emailaddress").attr("data-email",emailadd);
                $("#upd-email").show();
                $("#upd-email > label").html(emailadd);
                $("#add-email").hide();
            }else {
                message2("验证码不正确！","warning");
            }
        },
        error: function () {
        }
    });
}

function removeImage() {
    $("#uploadSubmit").removeAttr("disabled");
    $("#user-image").removeAttr("data-address");
}
//取消修改邮箱
function cancelUpdateEmail() {
    $("#upd-email").show();
    $("#add-email").hide();
}
//修改邮箱
function updateEmail() {

    $("#upd-email").hide();
    $("#add-email").show();
    var email = $("#upd-email > label").html();
    $("#email-input").val(email);
}
//校验手机验证码
function checkIphone() {

    var iphone = $("#iphone-input").val();
    var code = $("#getted").val();

    if(!(/^1[3|4|5|7|8][0-9]\d{4,8}$/.test(iphone))){
        $(".modal-three").html("不是正确的手机号！");
        $(".modal-three").show();
        return;
    }else {
        $(".modal-three").hide();
    }

    if("" == code){
        $(".modal-three").html("验证码不能为空！");
        $(".modal-three").show();
        return;
    }
    else {
        $(".modal-three").hide();
    }

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
                $("#user-iphone").attr("data-iphone",iphone);
                $('#Mydialog4').modal('hide');
                $("#iphone-update").show();
                $("#iphone-update > label").html(iphone);
            }else {
                $(".modal-three").html("验证码不正确！");
                $(".modal-three").show();
            }
        },
        error: function () {
        }
    });


}

//校验手机格式
function checkNumber() {

    var sMobile = $("#iphone-input").val();
    if(!(/^1[3|4|5|7|8][0-9]\d{4,8}$/.test(sMobile))){
        $(".modal-three").html("不是正确的手机号！");
        $(".modal-three").show();
        return;
    }else {
        $(".modal-three").hide();
    }
}
//发送手机验证码
function sendSms() {


    var sMobile = $("#iphone-input").val();
    if(!(/^1[3|4|5|7|8][0-9]\d{4,8}$/.test(sMobile))){
        $(".modal-three").html("不是正确的手机号！");
        $(".modal-three").show();
        return;
    }else {
        $(".modal-three").hide();
    }

    var sMobile = $("#iphone-input").val();


    $("#get-card").attr("disabled","disabled");
    $("#get-card").html("发送中...");
    var data = {
        "userIphone": sMobile
    }
    var url = encodeURI(global.context + "/dsxh/common/sendIphone");
    $.ajax({
        url: url,
        type: "POST",
        async:true,
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {

            if("success" == data.data.result){
                $("#get-card").html("重新获取");
                $(".modal-three").hide();
            }else {
                $(".modal-three").html("验证码发送失败！");
                $("#get-card").removeAttr("disabled");
                $(".modal-three").show();
                $("#get-card").html("发送验证码");
            }
        },
        error: function () {
        }
    });
}
//弹窗
function addIphone() {
    $('#Mydialog4').modal('show');
    var iphone = $("#iphone-update > label").html();
    $("#iphone-input").val(iphone);
}

// 文件上传
function uploadImage() {

    var url = encodeURI(global.context + "/upload/uploadImage");
    var data = new FormData($('#uploadForm')[0]);

    $.ajax({
        url: url,
        type: 'POST',
        data: data,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success: function (data) {
            if(data.data == "失败"){
                message2("上传失败","error");
            }else{
                $("#user-image").attr("data-address",data.data);
                $("#uploadSubmit").html("已提交");
                $("#uploadSubmit").attr("disabled","disabled");
            }
        },
        error: function (data) {
            console.log(data.status);
        }
    });
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
                $("#checkEmail-2").removeAttr("disabled");
            }else {
                message2("验证码发送失败，请检查邮箱重试！！","error");
                $("#checkEmail").removeAttr("disabled");
                $("#checkEmail-2").removeAttr("disabled");
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
                $("#my-money").attr("data-money",data.data.data.money);

                if(data.data.data.dsxhUserDetail != null){
                    $("#head-image2").attr("src","/daoshan-school/upload/getImage/"+data.data.data.dsxhUserDetail.headImageAddress);
                    $("#user-name-1").val(data.data.data.userName);
                    $("#user-image").attr("data-address",data.data.data.dsxhUserDetail.headImageAddress);
                    $("#picImg").attr("src","/daoshan-school/upload/getImage/"+data.data.data.dsxhUserDetail.headImageAddress);

                    $('#sex input[value='+data.data.data.dsxhUserDetail.userSex+']').attr("checked","checked");
                    $(".user-info-textarea").html(data.data.data.dsxhUserDetail.userMessage);
                    $("#input-name").val(data.data.data.dsxhUserDetail.userReallyName);
                    $("#emailaddress").attr("data-email",data.data.data.dsxhUserDetail.userEmail);
                    $("#upd-email > label").html(data.data.data.dsxhUserDetail.userEmail);
                    $("#user-iphone").attr("data-iphone",data.data.data.dsxhUserDetail.userIphone);
                    $("#iphone-update").val(data.data.data.dsxhUserDetail.userIphone);
                    $("#QQ-number").val(data.data.data.dsxhUserDetail.userQqNumber);

                }

            }
        },
        error: function () {
        }
    });
}