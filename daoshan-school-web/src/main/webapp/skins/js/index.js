"use strict";
var global = {
    context: null
};
window.onload = function() {

	initPageEvent();
	initPageDom();
	showSubmenu();
	onMenuItemClick();
	tabSlide();
	shadowChanged();

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
function initPageEvent() {

    $(document).on("click",".item_class", courseInfo);
    $(document).on("click","#search-begin", toSearch);
    $(document).on("click","#hide", hideUser);
    $(document).on("click","#user-name", showUser);
    //登出
    $(document).on("click","#log-out", loginOut);
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
}
function showSubmenu() {
	var items = $(".item");
	items.each(function() {
		var index = $(this).index();
		$(this).mouseenter(function() {
			$(this).addClass("select").siblings().removeClass("select");
			$(".sub_menu").eq(index).show().siblings(".sub_menu").hide();
		})

	});

	$("#menu").mouseleave(function() {
		$(".item").removeClass("select");
		$(".sub_menu").hide();
	})
}
/**
 * 菜单栏项被点击
 */
function onMenuItemClick() {
	var items = $(".item");
	items.each(function() {
		var index = $(this).index();
		$(this).click(function() {
			$(this).addClass("select").siblings().removeClass("select");
			$(".sub_menu").eq(index).show().siblings(".sub_menu").hide();
		})

	});
}

/**
 * 卡片的滑动效果
 */
function tabSlide() {
	$(".item_class").mouseenter(function() {
		$(this).children(".item_class_intro").css("top", "30px");
		//			$(this).children(".item_class_intro").children("p").show();
		$(this).css("box-shadow", "5px 0 10px 0 rgba(0,0,0,0.2)," +
			"-5px 0 10px 0 rgba(0,0,0,0.2), 0 5px 10px 0 rgba(0,0,0,0.2)");

	});
	$(".item_class").mouseleave(function() {
		$(this).children(".item_class_intro").css("top", "100px");
		//			$(this).children(".item_class_intro").children("p").hide();
		$(this).css("box-shadow", "0 0");
	});
	$(".web_r").mouseleave(function() {
		$(this).children(".item_class_intro").css("top", "100px");
		//			$(this).children(".item_class_intro").children("p").hide();
		$(this).css("box-shadow", "0 5px 10px 0 rgba(0,0,0,0.2)");
	});
}

/**
 * 阴影的变化
 */
function shadowChanged() {
	$(".web_l, .web_m_top, .web_m .web_m_bottom").hover(function() {
		$(this).css("box-shadow", "5px 0 10px 0 rgba(0,0,0,0.2)," +
			"-5px 0 10px 0 rgba(0,0,0,0.2), 0 5px 10px 0 rgba(0,0,0,0.2)")
	}, function() {
		$(this).css("box-shadow", "0 0");
	});
}