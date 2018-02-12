$(function(){
    $("#myCarousel").carousel({
    //设置自动播放/2 秒
    interval : 2000,
    });
    //调整轮播器箭头位置
    $('.carousel-control').css('line-height', $('.carousel-inner img').height() + 'px');
    $(window).resize(function() {
            var $height = $('.carousel-inner img').eq(0).height() |
                $('.carousel-inner img').eq(1).height() |
                $('.carousel-inner img').eq(2).height();
            $('.carousel-control').css('line-height', $height + 'px');
    });
    //内容
    //设置文字垂直居中
    $('.text').eq(0).css('margin-top', ($('.auto').eq(0).height() - $('.text').eq(0).height()) / 2 + 'px');
    $(window).resize(function () {
        $('.text').eq(0).css('margin-top', ($('.auto').eq(0).height() - $('.text').eq(0).height()) / 2 + 'px');
    });

    $('.text').eq(1).css('margin-top', ($('.auto').eq(1).height() - $('.text').eq(1).height()) / 2 + 'px');
    $(window).resize(function () {
        $('.text').eq(1).css('margin-top', ($('.auto').eq(1).height() - $('.text').eq(1).height()) / 2 + 'px');
    });

});