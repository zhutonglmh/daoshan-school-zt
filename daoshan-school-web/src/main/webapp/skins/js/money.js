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
    initList2();
}
function initPageEvent() {
    $(document).on("click","#search-begin", toSearch);
    $(document).on("click",".search-item", toPlay);
    $(document).on("click","#hide", hideUser);
//登出
    $(document).on("click","#log-out", loginOut5);
    $(document).on("click","#user-name", showUser);

    $(document).on("click","#show_pay", controll);

    $(document).on("click","#go_chongzhi", showMydialog4);
}
function showMydialog4() {
    $('#Mydialog4').modal('show');
}
function controll() {

    var flag = $(this).attr("data-flag");

    if(flag == 0 || flag == null){
        $("#controll").show();
        $(this).attr("data-flag",1);
        $(this).html("关闭消费记录");
    }else {
        $("#controll").hide();
        $(this).attr("data-flag",0);
        $(this).html("查看消费记录");
    }

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

function initList2() {

    var JsonData = {
        "start":0,
        "limit":1000
    }
    var url = encodeURI(global.context + "/dsxh/money/findDataForPage");;
    $.ajax({
        url: url,
        type: "POST",
        async:false,
         data: JSON.stringify(JsonData),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {

            var dataResult = data.data.data;
            if (dataResult != null && dataResult.length > 0) {
                var temp = template('money-template', {"data": dataResult});
                $("#money_table").empty().html(temp);
                initPage(dataResult);
            }else {
                $("#money_table").empty().html("暂无消费信息")
            }
            $("#controll").hide();
        },
        error: function () {
        }
    });
}
// function initList() {
//
//     /*var url2 = window.location.href;
//     var myArray=new Array();
//     myArray = url2.split("?");
//     var queryString = myArray[1];
//     queryString= decodeURI(queryString
//     var JsonData = {
//         "queryString" : queryString
//     })*/
//
//     var url = encodeURI(global.context + "/dsxh/collect/getCollect");;
//     $.ajax({
//         url: url,
//         type: "POST",
//         async:false,
//         // data: JSON.stringify(JsonData),
//         contentType: "application/json",
//         dataType: "JSON",
//         success: function (data) {
//
//             var dataResult = data.data.data;
//             if (dataResult != null && dataResult.length > 0) {
//                 global.data = dataResult;
//                 $(".search-total").html("共"+dataResult.length+"门课程");
//                 initItem(1,dataResult);
//                 initPage(dataResult);
//             }
//             else{
//                 $(".search-total").html("还没有收藏课程，快去添加自己喜爱的课程吧");
//                 $(".search-content").empty();
//             }
//         },
//         error: function () {
//         }
//     });
// }
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
    var pageTotal = Math.ceil(totalCount / 10);
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
                var start = 10*(api.getCurrent()-1);
                var limit = 10*(api.getCurrent());
                var JsonData = {
                    "start":start,
                    "limit":limit
                }
                var url = encodeURI(global.context + "/dsxh/money/findDataForPage");;
                $.ajax({
                    url: url,
                    type: "POST",
                    async:false,
                    data: JSON.stringify(JsonData),
                    contentType: "application/json",
                    dataType: "JSON",
                    success: function (data) {
                        var dataResult = data.data.data;
                        if (dataResult != null && dataResult.length > 0) {
                            var temp = template('money-template', {"data": dataResult});
                            $("#money_table").empty().html(temp);
                        }
                    },
                    error: function () {
                    }
                });
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
                if(data.data.data.vip == 1){
                    $("#vip").empty().html("<a href=\"course.jsp\">课程管理</a>");
                    $("#vip2").empty().html("<a href=\"order.jsp\">订单管理</a>");
                    $("#vip3").empty().html("<a href=\"money.jsp\">余额管理</a>");
                    $("#my-order").empty().html("<a href=\"order.jsp\">订单管理</a>");
                }
                if(data.data.data.dsxhUserDetail != null){
                    $("#head-image2").attr("src","/daoshan-school/upload/getImage/"+data.data.data.dsxhUserDetail.headImageAddress);
                }else {
                    $("#head-image2").attr("src","/daoshan-school/upload/getImage/head");
                }
                $("#user-name").html(data.data.data.userName);
                $("#user-name").show();
                $("#goto-login").hide();
                $("#my-money").attr("data-money",data.data.data.money);
                $("#message").html("敬爱的用户，"+data.data.data.userName+"。您好！");
                $("#money").html("您的账户余额为:  "+data.data.data.money+".00")
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