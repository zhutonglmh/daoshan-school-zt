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

}
function initPageEvent() {

    $(document).on("click","#search-begin", toSearch);
    $(document).on("click",".search-item", toPlay);
    $(document).on("click","#hide", hideUser);

    $(document).on("click","#user-name", showUser);

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