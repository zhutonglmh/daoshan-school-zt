"use strict";
var global = {
    context: null,
    data:null
};

$(function () {
    initPageDom();
    initPageEvent();
});

function initPageDom(){

    initDate();
    //initComments();
    initUser();
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
//加载评论
function initComments(page,data) {

    if(data != null && data.length > 0 ){

        if(page == 1){
            var newary = data.slice(0, 5);
            var temp2 = template('comments_children', {"data" : newary});
            $("#temp").empty().html(temp2);
        }
        else{
            var newary = data.slice((page-1) * 5, page * 5);
            var temp2 = template('comments_children', {"data" : newary});
            $("#temp").empty().html(temp2);
        }
    }
}
function initPageEvent(){
    $(document).on("click","#comments", commentsHide);
    $(document).on("click",".comments", commentsShow);

    $(document).on("click",".comments_one", commentsLove); //点赞
    $(document).on("click",".comments_two", commentsHate); //点踩
    $(document).on("click",".comments_three", commentsChild); //子评论
    $(document).on("click",".btn_comments", CreateComments); //评论课程
    $(document).on("click",".btn_comments_child", CreateCommentsChild); //评论评论

    $(document).on("click",".to-buy", toBuy);
    $(document).on("click","#buy-commit", commitBuy);//购买
    $(document).on("click","#buy-commit-2", commitOrder);//加入订单window.location.href = "http://www.jb51.net";
    $(document).on("click","#buy-cancel", cancelBuy);//取消

    $(document).on("click",".mulu_title", toChild);//子目录跳转
    $(document).on("click",".control-play-icon", function () {
        alert("sddsd");
    }); //评论评论
    $(document).on("click","#search-begin", toSearch);

    $(document).on("click","#hide", hideUser);

    $(document).on("click","#user-name", showUser);

    //添加收藏
    $(document).on("click","#collect", collect);

    $(document).on("click","#to-collect", collect);
    //取消收藏
    $(document).on("click","#cancel-collect", cancelCollect);

    $(document).on("click","#cancel-collect1", cancelCollect);
    //分享
    $(document).on("click","#spare", spare);
    //登出
    $(document).on("click","#log-out", loginOut2);

    //注册回车事件
    $("#search-info").keyup(function (event) {
        if(event.keyCode ==13){
            toSearch();
        }
    });

    $(document).on("click","#log-out", loginOut2);
}
function toChild() {

    var id = $(this).attr("data-id");
    window.location.href = global.context + "/jsp/main.jsp?"+id;
}
//分享
function spare() {
    message2("功能尚未开放！敬请期待","info");
}
//取消收藏
function cancelCollect() {
    var courseId = $("#course_name").attr("data-id");
    var JsonData = {
        "courseId": courseId
    };
    var url = encodeURI(global.context + "/dsxh/collect/delete");
    $.ajax({
        url: url,
        type: "POST",
        async: false,
        data: JSON.stringify(JsonData),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {
            if(data.data == "failure"){
                message2("操作失败！", "error");
            }else {
                message2("操作成功！", "success");
                $("#collect").show();
                $("#cancel-collect").hide();
                $("#to-collect").show();
                $("#cancel-collect1").hide();
            }
        },
        error: function () {
            message2("收藏失败！", "error");
        }
    });
}
//添加收藏
function collect() {

    var courseId = $("#course_name").attr("data-id");
    var courseName = $("#toIndex4").val();
    var JsonData = {
        "courseId": courseId,
        "courseName": courseName
    }
    var url = encodeURI(global.context + "/dsxh/collect/add");
    $.ajax({
        url: url,
        type: "POST",
        async: false,
        data: JSON.stringify(JsonData),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {
            if(data.data == "failure"){
                message2("收藏失败！", "error");
            }else {
                message2("添加收藏成功！", "success");
                $("#collect").hide();
                $("#cancel-collect").show();
                $("#to-collect").hide();
                $("#cancel-collect1").show();
            }
        },
        error: function () {
            message2("收藏失败！", "error");
        }
    });
}
function hideUser() {
    $(".user-info-message").hide();
}
function showUser() {
    $(".user-info-message").show();
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
function toSearch() {
    var search = $("#search-info").val();
    window.location.href= global.context+"/jsp/search.jsp?"+search;
}
function toBuy() {
    $('#Mydialog4').modal('show');
    var courseId = $("#course_name").attr("data-id");
    var courseName = $("#course_name").html().trim();
    var priceStr = $(".price").attr("data-price");
    var price = $(".price").attr("data-price");

    $("#label-course-name").parent().attr("data-id",courseId);
    $("#label-course-name").html(courseName);
    $("#label-course-price").attr("data-money",price);
    $("#label-course-price").html(priceStr+".00元");
    var money = $("#my-money").attr("data-money");
    $("#label-course-amt").attr("data-money",money)
    $("#label-course-amt").html(money+".00元")

}

//稍后购买
function commitOrder() {
    var courseId = $("#label-course-name").parent().attr("data-id");
    var courseName = $("#label-course-name").html();
    var price = $("#label-course-price").attr("data-money");
    var JsonData = {
        "courseId": courseId,
        "courseName": courseName,
        "price": price,
        "status":0
    }
    var url = encodeURI(global.context + "/dsxh/order/addOrder");
    $.ajax({
        url: url,
        type: "POST",
        async: false,
        data: JSON.stringify(JsonData),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {
            if(data.data.data == "false"){
                message2("创建订单失败！", "error");
                window.location.reload();
            }else {
                message2("创建订单成功！", "success");
                $('#Mydialog4').modal('hide');
            }
        },
        error: function () {
            message2("购买失败！", "error");
        }
    });

}
//购买
function commitBuy() {


    var courseId = $("#label-course-name").parent().attr("data-id");
    var courseName = $("#label-course-name").html();
    var price = $("#label-course-price").attr("data-money");
    var JsonData = {
        "courseId": courseId,
        "courseName": courseName,
        "price": price,
        "status":1
    }
    var url = encodeURI(global.context + "/dsxh/order/addOrder");
    $.ajax({
        url: url,
        type: "POST",
        async: false,
        data: JSON.stringify(JsonData),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {
            if(data.data.data == "false"){
                message2("购买失败！", "error");

            }else {
                message2("购买成功！", "success");
                $('#Mydialog4').modal('hide');
                window.location.reload();
            }
        },
        error: function () {
            message2("购买失败！", "error");
        }
    });


}
//取消
function cancelBuy() {
    $('#Mydialog4').modal('hide');
}
//点赞
function commentsLove() {

    var flag = $(this).parent().attr("data-flag");
    if(flag == "love"){
        message2("您已赞过！","warning");
        return;
    }else if(flag == "hate"){
        message2("您已踩过！","warning");
        return;
    }
        var $accuracyType = $(this);
        var id = $(this).parent().parent().attr("data-id");
        var num = $(this).html();
        var strArr = new Array();
        strArr = num.split("（");
        var str2 = strArr[1];
        strArr = str2.split("）");

        num = Number(strArr[0]);
        var commentLoves =num  + 1;
        var JsonData = {
            "id" : id,
            "commentLoves":commentLoves

        }
        var url = encodeURI(global.context + "/dsxh/comments/updateComments");
        $.ajax({
            url: url,
            type: "POST",
            async: false,
            data: JSON.stringify(JsonData),
            contentType: "application/json",
            dataType: "JSON",
            success: function (data) {
                global.love = "yes";
                $accuracyType.text("顶（"+commentLoves+"）");
                $accuracyType.addClass("love");
                $accuracyType.parent().attr("data-flag","love");
            },
            error: function () {
            }
        });

}
//点踩
function commentsHate() {

    var flag = $(this).parent().attr("data-flag");
    if(flag == "love"){
        message2("您已赞过！","warning");
        return;
    }else if(flag == "hate"){
        message2("您已踩过！","warning");
        return;
    }
        var $accuracyType = $(this);
        var id = $(this).parent().parent().attr("data-id");
        var num = $(this).html();
        var strArr = new Array();
        strArr = num.split("（");
        var str2 = strArr[1];
        strArr = str2.split("）");
        num = Number(strArr[0]);
        var commentHates =num  + 1;

        var JsonData = {
            "id" : id,
            "commentHates":commentHates

        }
        var url = encodeURI(global.context + "/dsxh/comments/updateComments");
        $.ajax({
            url: url,
            type: "POST",
            async: false,
            data: JSON.stringify(JsonData),
            contentType: "application/json",
            dataType: "JSON",
            success: function (data) {
                global.hate = "yes";
                $accuracyType.text("踩（"+commentHates+"）");
                $accuracyType.addClass("love");
                $accuracyType.parent().attr("data-flag","hate");
            },
            error: function () {
            }
        });
}
function commentsChild() {

   var flag = $(this).attr("data-flag");
   if("yes" == flag){
        $(this).parent().parent().find(".comments_children").hide();
       $(this).attr("data-flag","no");
   }else {
       $(this).parent().parent().find(".comments_children").show();
       $(this).attr("data-flag","yes");
   }
}
function CreateComments() {


    var courseId = $("#toIndex4").attr("data-bigTypeId");
    var commentMessage = $(".my_textarea").val();
    if(commentMessage != null || commentMessage != ""){
        var JsonData = {
            "courseId":courseId,
            "commentLoves":0,
            "commentHates":0,
            "commentMessage":commentMessage
        }
        var url = encodeURI(global.context + "/dsxh/comments/addComments");
        $.ajax({
            url: url,
            type: "POST",
            async: false,
            data: JSON.stringify(JsonData),
            contentType: "application/json",
            dataType: "JSON",
            success: function (data) {

                message2("评论成功！","info");
                initComments(1, data.data.data2);
                initPage(data.data.data2);
            },
            error: function () {
            }
        });
    }else {
        message2("评论内容不能为空","warning");
    }
}
function CreateCommentsChild() {

    var courseId = $("#toIndex4").attr("data-bigTypeId");
    var commentMessage =  $(this).parent().parent().find(".my_textarea_child").val();
    var parentId = $(this).parent().parent().parent().attr("data-id");
    var $children = $(this).parent().parent();

    if (commentMessage != null && commentMessage != "") {

            var JsonData = {
                "courseId": courseId,
                "parentId": parentId,
                "commentLoves": 0,
                "commentHates": 0,
                "commentMessage": commentMessage
            }
            var url = encodeURI(global.context + "/dsxh/comments/addComments");
            $.ajax({
                url: url,
                type: "POST",
                async: false,
                data: JSON.stringify(JsonData),
                contentType: "application/json",
                dataType: "JSON",
                success: function (data) {
                    message2("评论成功！", "info");
                    var temp2 = template('comments_children2', {"data": data.data.data2});
                    $children.empty().html(temp2);
                },
                error: function () {
                }
            });
        } else {
            message2("评论内容不能为空", "warning");
        }

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


function commentsHide() {
    $(".my_content").hide();
}
function commentsShow() {
    $("#my_content").show();
}
function initDate() {

    var url2 = window.location.href;
    var myArray=new Array();
    myArray = url2.split("?");
    var id = myArray[1];

    var JsonData = {
        "id" : id
    }
    var url = encodeURI(global.context + "/dsxh/course/getCourseInfo");;
    $.ajax({
        url: url,
        type: "POST",
        async:false,
        data: JSON.stringify(JsonData),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {

            var dataResult = data.data.data;
            if (dataResult != null) {

                $("#toIndex1").attr("data-bigTypeId",dataResult.bigTypeId);
                $("#toIndex1").attr("href","search.jsp?"+dataResult.bigTypeName);
                $("#toIndex1").html(dataResult.bigTypeName);
                $("#toIndex2").attr("data-bigTypeId",dataResult.typeId);
                $("#toIndex2").attr("href","search.jsp?"+dataResult.typeName);
                $("#toIndex2").html(dataResult.typeName);
                $("#toIndex3").attr("data-bigTypeId",dataResult.bigTypeId);
                $("#toIndex3").html(dataResult.childTypeName);
                $("#toIndex3").attr("href","search.jsp?"+dataResult.childTypeName);
                $("#toIndex4").attr("data-bigTypeId",dataResult.id);
                $("#toIndex4").html(dataResult.courseName);
                $("#toIndex4").attr("href","search.jsp?"+dataResult.courseName);
                $("#teacher").html(dataResult.teacherName);
                $("#course_teacher_name").html(dataResult.teacherName);
                $(".price").html("¥ " +dataResult.coursePrice+".00");
                $(".price").attr("data-price",dataResult.coursePrice);
                $("#course_name").html(dataResult.courseName);
                $("#course_name").attr("data-id",dataResult.id);
                var str = dataResult.dsxhCourseDetail.courseMessage;
                var reg = new RegExp(/\r\n/,"g");
                $("#my_content_one > p").html(str.replace(reg,"</br>"));

                var temp = template('weather', {"data" : dataResult.dsxhCourseChildren});
                $("#mulu_content2").html(temp);

                //判断当前用户是否已经购买了此课程
                if(dataResult.isBuy == 1){
                    $("#vedio").attr("src",dataResult.vedioAddress);
                    $(".to-buy").html("已购买");
                    $(".to-buy").attr("disabled","disabled");
                }else {
                    //$("#vedio").attr("src","../");
                }
                if(dataResult.isCollect == 1){
                    $("#collect").hide();
                    $("#cancel-collect").show();
                    $("#to-collect").hide();
                    $("#cancel-collect1").show();
                }else {
                    $("#collect").show();
                    $("#cancel-collect").hide();
                    $("#to-collect").show();
                    $("#cancel-collect1").hide();
                }
                global.data =  dataResult.commentsList;
                if(global.data != null && global.data.length > 0 ) {

                    initComments(1, dataResult.commentsList);
                    initPage(dataResult.commentsList);
                }
            }
            else{
            }
        },
        error: function () {
        }
    });
}

//加载分页组件
function initPage(data) {

    $('.M-box3').empty();
    var totalCount = data.length;
    var pageTotal = Math.ceil(totalCount / 5);
    if(pageTotal > 1){
        $('.M-box3').pagination({
            pageCount: pageTotal,
            jump: true,
            coping: true,
            homePage: '首页',
            endPage: '末页',
            prevContent: '上页',
            nextContent: '下页',
            callback: function (api) {
                initComments(api.getCurrent(),global.data);
            }
        });
    }
    
}

