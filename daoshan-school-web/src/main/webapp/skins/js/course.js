"use strict";
var global = {
    context: null
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
    $(document).on("click",".tiaozhuan", toPlay);
    $(document).on("click","#query", chakan);
    //登出
    $(document).on("click","#log-out", loginOut);
    $(document).on("click","#delete", deleteCourse);

    $(document).on("click","#toadd", toadd);
    $(document).on("click",".show1", toadd);

}
function tan() {
    message2("暂未开放！","info");
}
function toadd() {
    window.location.href= global.context+"/jsp/addCourse.jsp";
}
//删除课程
function deleteCourse() {
    var id= $(this).parent().parent().attr("data-id");
    var JsonData = {
        "id":id
    }
    var url = encodeURI(global.context + "/dsxh/course/delete");
    $.ajax({
        url: url,
        type: "POST",
        async:false,
        data: JSON.stringify(JsonData),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {
           if(data.data.data == "login"){
               message2("没有权限！","error");
               window.location.href= global.context+"/jsp/login.jsp?";
           }else if(data.data.data == "success"){
               message2("删除成功！","success");
               setTimeout(function () {
                   window.location.reload();
               },1000);
           }else {
               message2("删除失败！","error");
           }
        },
        error: function () {
        }
    });
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
//进入课程
function courseInfo() {
    var courseId = $(this).attr("data-id");
    window.location.href= global.context+"/jsp/main.jsp?"+courseId;
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
                    $("#vip3").empty().html("<a href=\"money.jsp\">余额管理</a>");
                    $("#my-order").empty().html("<a href=\"order.jsp\">订单管理</a>");
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
    initList();
}
//加载分页组件
function initPage(data) {

    $('.M-box3').empty();
    var totalCount = data.length;
    var pageTotal = Math.ceil(totalCount / 15);
    if (pageTotal > 1) {
        $('.M-box3').pagination({
            pageCount: pageTotal,
            jump: true,
            coping: true,
            homePage: '首页',
            endPage: '末页',
            prevContent: '上页',
            nextContent: '下页',
            callback: function (api) {
                initItem(api.getCurrent(),global.data);
            }
        });
    }

}
function initList() {

    var JsonData={};
    var url = encodeURI(global.context + "/dsxh/course/findDataForPage");
    $.ajax({
        url: url,
        type: "POST",
        async:false,
        data: JSON.stringify(JsonData),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {

            var dataResult = data.data.data;
            global.data = dataResult;
            if (dataResult != null && dataResult.length > 0) {
                $(".search-total").html("共"+dataResult.length+"门课程");
                initItem(1,dataResult);
                initPage(dataResult);
            }
            else{
                $(".search-total").html("还没有课程，快去添加课程吧");
                $(".search-content").empty();
            }
        },
        error: function () {
        }
    });

}
function initItem(page,data) {

    if(data != null && data.length > 0 ) {

        if (page == 1) {
            var newary = data.slice(0, 15);
            var temp = template('item-template', {"data": newary});
            $(".search-content").empty().html(temp);
        }
        else {
            var newary = data.slice((page - 1) * 15, page * 15);
            var temp = template('item-template', {"data": newary});
            $(".search-content").empty().html(temp);
        }

    }
}