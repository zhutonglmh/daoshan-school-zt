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
	$("#vedio").attr("src","http://player.youku.com/embed/XMzQ3NTA3MTQ0NA==")//http://player.youku.com/embed/XMzUyMjA5OTEzNg==

    $(document).on("click",".loginOut a", loginOut);
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
                $(".userRegister a" ).show();
                $(".loginOut a" ).hide();
        },
        error: function () {
        }
    });
}
/**
 * 初始化获取当前登录用户
 */
function initPageDom() {

    var url = encodeURI(global.context + "/dsxh/user/getUserLoginInfo");
    $.ajax({
        url: url,
        type: "POST",
        async:false,
        //data: JSON.stringify(JsonData),
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {

            if (data.data.data != "failure") {
				$(".userInfo a" ).show();
                $(".loginOut a" ).show();
                $(".userInfo a" ).html(data.data.data.userName);
                $(".userLogin a" ).hide();
                $(".userRegister a" ).hide();
            }
            else{
                $(".userInfo a" ).hide();
                $(".userLogin a" ).show();
                $(".userRegister a" ).show();
                $(".loginOut a" ).hide();
            }
        },
        error: function () {
        }
    });
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