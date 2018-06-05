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
function initPageDom(){
    initList();
}
function initPageEvent() {
    $(document).on("click","#search-begin", toSearch);
    $(document).on("click",".search-item", toPlay);
    $(document).on("click","#hide", hideUser);
//登出
    $(document).on("click","#log-out", loginOut5);
    $(document).on("click","#user-name", showUser);

}
/**
 * 用户登出
 */
function loginOut5() {

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
function hideUser() {
    $(".user-info-message").hide();
}
function showUser() {
    $(".user-info-message").show();
}

function toPlay() {
    var courseId = $(this).attr("data-id");
    window.location.href= global.context+"/jsp/main.jsp?"+courseId;
}
function toSearch() {

    var search = $("#search-info").val();
    window.location.href= global.context+"/jsp/search.jsp?"+search;
}

function initList() {

    /*var url2 = window.location.href;
    var myArray=new Array();
    myArray = url2.split("?");
    var queryString = myArray[1];
    queryString= decodeURI(queryString
    var JsonData = {
        "queryString" : queryString
    })*/

    var url = encodeURI(global.context + "/dsxh/collect/getCollect");;
    $.ajax({
        url: url,
        type: "POST",
        async:false,
        // data: JSON.stringify(JsonData),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {

            var dataResult = data.data.data;
            if (dataResult != null && dataResult.length > 0) {
                global.data = dataResult;
                $(".search-total").html("共"+dataResult.length+"门课程");
                initItem(1,dataResult);
                initPage(dataResult);
            }
            else{
                $(".search-total").html("还没有收藏课程，快去添加自己喜爱的课程吧");
                $(".search-content").empty();
            }
        },
        error: function () {
        }
    });
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