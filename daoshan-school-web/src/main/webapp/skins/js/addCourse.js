"use strict";
var global = {
    context: null,
    select : {
        "软件开发":[
            "前端开发",
            "后端开发",
            "移动开发",
            "数据库",
            "云计算&大数据",
            "运维&测试",
            "视觉设计"
        ]
    },
    data : [

    ]
};
window.onload = function() {

    initPageEvent();
    initPageDom();

}
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
    }
});

function chakan() {
    var courseId = $(this).parent().parent().attr("data-id");
    window.location.href= global.context+"/jsp/main.jsp?"+courseId;
}
function toPlay() {
    var courseId = $(this).parent().attr("data-id");
    window.location.href= global.context+"/jsp/main.jsp?"+courseId;
}
function initPageEvent() {

    $(document).on("click","#search-begin", toSearch);
    $(document).on("click","#hide", hideUser);
    $(document).on("click","#user-name", showUser);
    $(document).on("click","#log-out", loginOut);
    $(document).on("click","#soft", select);
    $(document).on("click","#uploadSubmit", uploadImage);
    $(document).on("click","#remove", removeImage);
    $(document).on("click","#remove2", removeVedio);
    $(document).on("click",".add-vedio", toAdd);
    $(document).on("click","#show", toAdd);
    $(document).on("click","#uploadSubmit2", uploadVedio);
    $(document).on("click","#save", save);
    $(document).on("click","#cancel", cancel);
    $(document).on("click","#delete-vedio", deleteVedio);

    $(document).on("click","#save2", save2);
    $(document).on("click","#fanhui2", fanhui2);
}
function save2() {

    var courseName = $("#courseName").val();
    var bigTypeName = "软件开发";
    var typeName = $("#select").val();
    var childTypeName = $("#childre").val();
    var coursePrice = $("#prise").val();;
    var pictureAddress =  $("#user-image").attr("data-address");
    var teacherName = $("#zuozhe").val();
    var dsxhCourseChildren = global.data;
    var courseMessage = $("#message8").val();
    if(courseName == null || courseName == ""){
        message2("请输入课程名称！","error");
        return;
    }
    if(bigTypeName == null || bigTypeName == ""){
        message2("请输入类别名称！","error");
        return;
    }
    if(typeName == null || typeName == ""){
        message2("课程类型为null！","error");
        return;
    }
    if(childTypeName == null || childTypeName == ""){
        message2("课程所属技术为空！","error");
        return;
    }
    if(coursePrice == null || coursePrice == ""){
        message2("课程单价为空！","error");
        return;
    }
    if(pictureAddress == null || pictureAddress == ""){
        message2("请上传图片文件！","error");
        return;
    }
    if(teacherName == null || teacherName == ""){
        message2("请输入作者名称！","error");
        return;
    }
    if(dsxhCourseChildren == null || (dsxhCourseChildren.length == 0)){
        message2("请输入课程名称！","error");
        return;
    }
    if(courseMessage == null || courseMessage == ""){
        message2("请输入课程介绍！","error");
        return;
    }
    var JsonData = {
    "courseName":courseName,
        "bigTypeName":bigTypeName,
        "typeName":typeName,
        "childTypeName":childTypeName,
        "coursePrice":coursePrice,
        "pictureAddress":pictureAddress,
        "teacherName":teacherName,
        "dsxhCourseChildren":dsxhCourseChildren,
        "courseMessage":courseMessage
}
    var url = encodeURI(global.context + "/dsxh/course/addCourseInfo");
    $.ajax({
        url: url,
        type: "POST",
        async:false,
        data: JSON.stringify(JsonData),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {
            if (data.data.data != null) {
               message2("保存成功！","success");
               setTimeout(function () {
                   window.location.href= global.context+"/jsp/course.jsp";
               }),1000
            }
            else{
                message2("保存失败！","error");
            }
        },
        error: function (data) {
            message2("保存失败！","error");
        }
    });

}
function fanhui2() {
    window.location.href= global.context+"/jsp/course.jsp";
}
function deleteVedio() {

    var no = $(this).attr("data-id");
    global.data.splice(no-1,no);
    message2("删除成功！","success");
    init();
}
function cancel() {
    $('#Mydialog4').modal('hide');
}
function init() {

    var temp = template('item-template', {"data": global.data});
    if(global.data.length > 0){
        $(".my_table").empty().html(temp);
    }else {
        $(".my_table").empty();
    }

}
function removeVedio() {

    $("#uploadSubmit2").removeAttr("disabled");
    $("#uploadForm2").removeAttr("data-address");
    $("#uploadSubmit2").html("提交");
}
function save() {

    var address = $("#uploadForm2").attr("data-address");
    var h = global.data.length;
    var name = $("#name").val();
    if( address == null || address == ""){
        message2("视频文件地址错误！","error");
        return;
    }
    if( name == null || address == ""){
        message2("请输入名称！","error");
        return;
    }
    var a = {
        "no": h+1,
        "name" : name,
        "address" :address
    }
    global.data.push(a);
    init();
    $('#Mydialog4').modal('hide');

}
function uploadVedio() {

    var no = $("#no").val();
    var name = $("#name").val();
    var url = encodeURI(global.context + "/upload/uploadVedio");
    var data = new FormData($('#uploadForm2')[0]);

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
                $("#uploadForm2").attr("data-address",data.data);
                $("#uploadSubmit2").html("已提交");
                $("#uploadSubmit2").attr("disabled","disabled");

            }
        },
        error: function (data) {
            console.log(data.status);
        }
    });
}
function toAdd() {
    $('#Mydialog4').modal('show');
}
function removeImage() {
    $("#uploadSubmit").removeAttr("disabled");
    $("#user-image").removeAttr("data-address");
    $("#uploadSubmit").html("提交");
}
function select() {
    $("#select").empty().html("<option>其他</option>");
}
function hideUser() {
    $(".user-info-message").hide();
}
function showUser() {
    $(".user-info-message").show();
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
function toSearch() {

    var search = $("#search-info").val();
    window.location.href= global.context+"/jsp/search.jsp?"+search;
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

/**
 * 用户登出
 */
function loginOut() {
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
/**
 * 初始化获取当前登录用户
 */
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
                if(data.data.data.dsxhUserDetail != null){
                    $("#head-image2").attr("src","/daoshan-school/upload/getImage/"+data.data.data.dsxhUserDetail.headImageAddress);
                }else {
                    $("#head-image2").attr("src","/daoshan-school/upload/getImage/head");
                }
                if(data.data.data.vip == 1){
                    $("#vip").empty().html("<a href=\"course.jsp\">课程管理</a>");
                    $("#vip2").empty().html("<a href=\"order.jsp\">订单管理</a>");
                    $("#vip3").empty().html("<a href=\"course.jsp\">余额管理</a>");
                    $("#my-order").empty().html("<a href=\"order.jsp\">订单管理</a>");
                }else {
                    message2("当前用户无权限操作!","error");
                    setTimeout(function () {
                        window.location.href= global.context+"/jsp/login.jsp";
                    },1000);
                }
                $("#user-name").html(data.data.data.userName);
                $("#user-name").show();
                $("#goto-login").hide();
                $("#my-money").attr("data-money",data.data.data.money);
            }
        },
        error: function () {
        }
    });
}
function initPageDom() {
    initUser();
}


