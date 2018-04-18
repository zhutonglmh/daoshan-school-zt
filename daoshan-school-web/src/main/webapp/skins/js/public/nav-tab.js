'use strict';
var global = {
    context: null,
    domain: {}
};
$(function () {
    //Initialize page elements
    initLanguageList();
    //Initialize page events
    $('#nav-tab a.taglib').on("click", navToggleClick);
    $('#nav-tab-right a.taglib').on("click", navToggleClick);
    $('.menu-content').on("click", showHideClick);
    $('#lang-close').on("click", hideClick);
    $("#header-search-btn").on("click", searchClick);
    $("#search-input").keydown(function (event) {
        if (event.keyCode == 13) {
            $("#header-search-btn").click();
            return false;
        }
    });
    initClick();
    propertyClick();
    initSuggestInput();
});

/* Json array value template */
function initLanguageList() {
    $.ajax({
        type: 'GET',
        url: '../../jsp/data/lang-select.json',
        dataType: 'json',
        success: function (language) {
            var languageSet = language;
            if (languageSet.length > 0) {
                var temp = template("language-tpl", {
                    "languageSet": languageSet
                });
                $("#language-down").append(temp);
            } else {
                $("#language-down").html('<div class="empty">暂时没有搜索历史</div>');
            }
        },
        error: function (data, status, e) {
            //alert("服务器异常2");
        }
    })
}

//Switch the navigation bar tag
function navToggleClick() {
    $(this).tab('show');
}

//The lang-content show and hide
function showHideClick(e) {
    $('#lang-content').toggle();
    e.stopImmediatePropagation();
}

//The lang-content close
function hideClick() {
    $('#lang-content').hide();
}

//Take the value of the input box
function searchClick() {
    var doc = $("#search-input").val();
    if (doc && (!(doc.trim() == ""))) {
        document.location.href = global.context + "/jsp/kb/search-item.jsp?keywords=" + doc;
    } else {
        $.dialog({
            type: 'alert',
            content: '请输入要搜索的条目！'
        });
    }

}

function initSuggestInput(start,limit) {
    $("#search-input").keyup(function () {
        var item = [];
        if ($(this).val()) {
            $(".search-item-message").show();
            $.ajax({
                url: global.context + "/service/kb/item/searchItems",
                type: "POST",
                async: false,
                data: JSON.stringify({"keyword": $(this).val(),
                    "start": start || 0,
                    "limit": limit || 20
                }),
                contentType: "application/json;charset=utf-8",
                dataType: "JSON",
                success: function (data) {
                    $(".none-hint").hide();
                    item = data.data;
                    if (!item.length > 0) {
                        var nonHint = $("<div class='none-hint'>找不到匹配项目</div>");
                        $("#search-back-message").append(nonHint).show();
                        $(".search-item-message").hide();
                    } else {
                        $("#search-input").AutoComplete({
                            "data": item,
                            "messageLocation":"#search-item",
                            "maxItems": 7,          //提示信息的数量
                            "width": 200,           //提示框的宽度
                            "listStyle": "custom",  //样式
                            "maxHeight": 300,    //设置提示框的高度
                            "createItemHandler": function (index, data) {
                                var div = $("<a class='li-href-div' href='check-item.jsp?entityId=" + data.id + "'>" +
                                    "<div class='bfont'>" + data.value + "</div>" +
                                    "</a>");
                                if (data.description) {
                                    $("<div>" + data.description + "</div>").appendTo(div);
                                }
                                return div;
                            }
                        }).AutoComplete("show");
                    }
                    $(".add-message").show();
                },
                error: function () {
                    alert("查询失败!");
                }
            });
        }else {
            $(".none-hint").hide();
            $(".add-message").hide();
            $(".search-item-message").hide();
        }
    });

}

function initClick() {
    var url = window.location.href;
    var index = url.indexOf("=");
    var itemId = "";
    if(!(index == -1)) {
        itemId = url.substring(index + 1);
        $('.check-item').click(function () {
            document.location.href = global.context + "/jsp/kb/check-item.jsp?entityId=" + itemId;
        });
        $('.edit-item').click(function () {
            document.location.href = global.context + "/jsp/kb/edit-item.jsp?entityId=" + itemId;
        });
        $('.item-history').click(function () {
            document.location.href = global.context + "/jsp/kb/item-history.jsp?entityId=" + itemId;
        });
    }
};

function propertyClick() {
    var url = window.location.href;
    var index = url.indexOf("=");
    var propertyId = "";
    if(!(index == -1)) {
        propertyId = url.substring(index + 1);
        $('.check-property').click(function () {
            document.location.href = global.context + "/jsp/kb/check-property.jsp?entityId=" + propertyId;
        });
        $('.edit-property').click(function () {
            document.location.href = global.context + "/jsp/kb/edit-property.jsp?entityId=" + propertyId;
        });
        $('.property-history').click(function () {
            document.location.href = global.context + "/jsp/kb/property-history.jsp?entityId=" + propertyId;
        });
        $('.tab5-main-discussion').click(function () {
            document.location.href = global.context + "/jsp/kb/main-discussion.jsp?entityId=" + propertyId;
        });
        $('.tab2-check-property').click(function () {
            document.location.href = global.context + "/jsp/kb/check-property.jsp?entityId=" + propertyId;
        });
    }
};
