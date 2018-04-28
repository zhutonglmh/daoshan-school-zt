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
    $(document).on("click","#buy-cancel", cancelBuy);//取消
    $(document).on("click",".control-play-icon", function () {
        alert("sddsd");
    }); //评论评论
    $(document).on("click","#search-begin", toSearch);

    $(document).on("click","#hide", hideUser);

    $(document).on("click","#user-name", showUser);

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
function toBuy() {
    $('#Mydialog4').modal('show');
    var courseId = $("#course_name").attr("data-id");
    var courseName = $("#course_name").html().trim();
    var priceStr = $("#course_name").html().trim();
    var price = $("#course_name").attr("data-price");

    $("#label-course-name").parent().attr("data-id",courseId);
    $("#label-course-name").html(courseName);
    $("#label-course-price").parent().attr("data-id",price);
    $("#label-course-price").html(priceStr);

}
//购买
function commitBuy() {
    $('#Mydialog4').modal('hide');
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
                $("#vedio").attr("src",dataResult.vedioAddress);
                $("#toIndex1").attr("data-bigTypeId",dataResult.bigTypeId);
                $("#toIndex1").html(dataResult.bigTypeName);
                $("#toIndex2").attr("data-bigTypeId",dataResult.typeId);
                $("#toIndex2").html(dataResult.typeName);
                $("#toIndex3").attr("data-bigTypeId",dataResult.bigTypeId);
                $("#toIndex3").html(dataResult.childTypeName);
                $("#toIndex4").attr("data-bigTypeId",dataResult.id);
                $("#toIndex4").html(dataResult.courseName);
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

