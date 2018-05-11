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

function initPageEvent() {

    $(document).on("click",".loginOut a", loginOut);

    $(document).on("click",".item_class", courseInfo);

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
                $(".userInfo a" ).hide();
                $(".userLogin a" ).show();
                $(".loginOut a" ).hide();
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
/**
 * 显示子菜单栏
 */
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