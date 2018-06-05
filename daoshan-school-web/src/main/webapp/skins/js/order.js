"use strict";
var global = {
    context: null,
    data:null
};

$(function () {
    initPageDom();
    initPageEvent();
    initUser();
    initList();


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
function initList() {

    var url = encodeURI(global.context + "/dsxh/order/findDataForPage");
    var JsonData = {

    }
    $.ajax({
        url: url,
        type: "POST",
        async:false,
        data: JSON.stringify(JsonData),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {
            if(data.data == null){
                message2("没有订单信息！","info");
            }
            /*var temp = template('order-template', {"data": data.data.all});
            $("#one > tbody").empty().html(temp);*/
            global.data = data.data;

            initItem1(1,data.data.all,$(".M-box3").parent().find("table > tbody"));
            initItem1(1,data.data.zero,$(".M-box4").parent().find("table > tbody"));
            initItem1(1,data.data.one,$(".M-box5").parent().find("table > tbody"));
            initItem1(1,data.data.two,$(".M-box6").parent().find("table > tbody"));
            initItem1(1,data.data.three,$(".M-box7").parent().find("table > tbody"));
            initItem1(1,data.data.four,$(".M-box8").parent().find("table > tbody"));
            initItem1(1,data.data.five,$(".M-box9").parent().find("table > tbody"));
            initPage1(data.data.all);
            initPage2(data.data.zero);
            initPage3(data.data.one);
            initPage4(data.data.two);
            initPage5(data.data.three);
            initPage6(data.data.four);
            initPage7(data.data.five);

        },
        error: function () {
        }
    });
}
function initPageDom(){

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

function initPageEvent() {

    $(document).on("click","#search-begin", toSearch);
    $(document).on("click",".search-item", toPlay);
    $(document).on("click","#hide", hideUser);

    $(document).on("click","#user-name", showUser);

    //登出
    $(document).on("click","#log-out", loginOut2);
   // $(document).on("click",".mybtn", updateOrder());

    $(document).on("click",".mybtn", updateOrder);

}
/**
 * 用户登出
 */
function loginOut2() {

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

//加载分页组件all
function initPage1(data) {


   if(data == null){
       $(".M-box3").parent().empty().html("未查询到订单信息");
       return;
   }
    $(".M-box3").empty();
    var totalCount = data.length;
    var pageTotal = Math.ceil(totalCount / 5);
    if (pageTotal > 1) {
        $(".M-box3").pagination({
            pageCount: pageTotal,
            jump: true,
            coping: true,
            homePage: '首页',
            endPage: '末页',
            prevContent: '上页',
            nextContent: '下页',
            callback: function (api) {
                var $target = $(".M-box3").parent().find("table > tbody");
                initItem1(api.getCurrent(),global.data.all,$target);
            }
        });
    }
}
//加载分页组件1
function initPage2(data) {

    if(data == null){
        $(".M-box4").parent().empty().html("未查询到订单信息");
        return;
    }
    $(".M-box4").empty();
    var totalCount = data.length;
    var pageTotal = Math.ceil(totalCount / 5);
    if (pageTotal > 1) {
        $(".M-box4").pagination({
            pageCount: pageTotal,
            jump: true,
            coping: true,
            homePage: '首页',
            endPage: '末页',
            prevContent: '上页',
            nextContent: '下页',
            callback: function (api) {
                var $target = $(".M-box4").parent().find("table > tbody");
                initItem(api.getCurrent(),global.data.zero,$target);
            }
        });
    }
}
//加载分页组件1
function initPage3(data) {

    if(data == null){
        $(".M-box5").parent().empty().html("未查询到订单信息");
        return;
    }
    $(".M-box5").empty();
    var totalCount = data.length;
    var pageTotal = Math.ceil(totalCount / 5);
    if (pageTotal > 1) {
        $(".M-box5").pagination({
            pageCount: pageTotal,
            jump: true,
            coping: true,
            homePage: '首页',
            endPage: '末页',
            prevContent: '上页',
            nextContent: '下页',
            callback: function (api) {
                var $target = $(".M-box5").parent().find("table > tbody");
                initItem(api.getCurrent(),global.data.all,$target);
            }
        });
    }
}
//加载分页组件1
function initPage4(data) {

    if(data == null){
        $(".M-box6").parent().empty().html("未查询到订单信息");
        return;
    }
    $(".M-box6").empty();
    var totalCount = data.length;
    var pageTotal = Math.ceil(totalCount / 5);
    if (pageTotal > 1) {
        $(".M-box6").pagination({
            pageCount: pageTotal,
            jump: true,
            coping: true,
            homePage: '首页',
            endPage: '末页',
            prevContent: '上页',
            nextContent: '下页',
            callback: function (api) {
                var $target = $(".M-box6").parent().find("table > tbody");
                initItem(api.getCurrent(),global.data.all,$target);
            }
        });
    }
}
//加载分页组件1
function initPage5(data) {

    if(data == null){
        $(".M-box7").parent().empty().html("未查询到订单信息");
        return;
    }
    $(".M-box7").empty();
    var totalCount = data.length;
    var pageTotal = Math.ceil(totalCount / 5);
    if (pageTotal > 1) {
        $(".M-box7").pagination({
            pageCount: pageTotal,
            jump: true,
            coping: true,
            homePage: '首页',
            endPage: '末页',
            prevContent: '上页',
            nextContent: '下页',
            callback: function (api) {
                var $target = $(".M-box7").parent().find("table > tbody");
                initItem(api.getCurrent(),global.data.all,$target);
            }
        });
    }
}
//加载分页组件1
function initPage6(data) {

    if(data == null){
        $(".M-box8").parent().empty().html("未查询到订单信息");
        return;
    }
    $(".M-box8").empty();
    var totalCount = data.length;
    var pageTotal = Math.ceil(totalCount / 5);
    if (pageTotal > 1) {
        $(".M-box8").pagination({
            pageCount: pageTotal,
            jump: true,
            coping: true,
            homePage: '首页',
            endPage: '末页',
            prevContent: '上页',
            nextContent: '下页',
            callback: function (api) {
                var $target = $(".M-box8").parent().find("table > tbody");
                initItem(api.getCurrent(),global.data.all,$target);
            }
        });
    }
}
function initPage7(data) {

    if(data == null){
        $(".M-box9").parent().empty().html("未查询到订单信息");
        return;
    }
    $(".M-box9").empty();
    var totalCount = data.length;
    var pageTotal = Math.ceil(totalCount / 5);
    if (pageTotal > 1) {
        $(".M-box9").pagination({
            pageCount: pageTotal,
            jump: true,
            coping: true,
            homePage: '首页',
            endPage: '末页',
            prevContent: '上页',
            nextContent: '下页',
            callback: function (api) {
                var $target = $(".M-box9").parent().find("table > tbody");
                initItem(api.getCurrent(),global.data.all,$target);
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
function initItem1(page,data,$object) {

    if(data != null && data.length > 0 ) {

        if (page == 1) {
            var newary = data.slice(0, 5);
            var temp = template('order-template', {"data": newary});
            $object.empty().html(temp);
        }
        else {
            var newary = data.slice((page - 1) * 5, page * 5);
            var temp = template('order-template', {"data": newary});
            $object.empty().html(temp);
        }

    }
}

//修改订单状态
function updateOrder(){

    var orderId = $(this).attr("data-id");
    var status = $(this).attr("data-status");
    var data = {
        "id":orderId,
        "status":status
    }
    var url = encodeURI(global.context + "/dsxh/order/updateOrder");
    $.ajax({
        url: url,
        type: "POST",
        async:true,
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {

            if (data.data.data == "false") {
                message2("操作失败！请重试","error");
            }
            else{
                message2("操作成功","success");

                window.location.reload();
            }
        },
        error: function () {
        }
    });
}