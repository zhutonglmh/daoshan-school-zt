"use strict";
var global = {
    context: null
};

$(function () {
    initPageDom();
    initPageEvent();
});

function initPageDom(){
    //queryAllStudent()
}
function initPageEvent(){

   /* $(document).on("keyup", ".input-input > input", inputValid);
    $(document).on("focus", ".input-input > input", inputValid);*/

    //使用js来调用实现tab页的切换
    $("#nav2 a").on("click",function (e) {
        $(this).tab('show');
    });
    //tab页事件类型
    $("#nav2 a").on("show.bs.tab", function () {
        alert('调用 tab 时触发！');
    });

    //图片轮播
    $("#myCarousel").carousel({
        //设置自动播放2秒
        interval:2000,
        //设置暂停按钮事件
        pause:'hover',
        //设置只轮播一次
        //wrap:false,
    });
    //轮播插件的各种事件
    $("#carousel-btn1").on("click",function(){
        $("#myCarousel").carousel('cycle');
    });
    $("#carousel-btn2").on("click",function(){
        $("#myCarousel").carousel('pause');
    });
    $("#carousel-btn3").on("click",function(){
        $("#myCarousel").carousel(3);
    });
    $("#carousel-btn4").on("click",function(){
        $("#myCarousel").carousel('prev');
    });
    $("#carousel-btn5").on("click",function(){
        $("#myCarousel").carousel('next');
    });
    //轮播的两个事件
    /*  $("#myCarousel").on("slide.bs.carousel", function () {
          alert('当调用 slide 实例方式时立即触发');
      });
      $('#myCarousel').on('slid.bs.carousel', function () {
          alert('当轮播完成一个幻灯片触发');
      });*/
}