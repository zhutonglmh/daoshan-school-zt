!function(a,b){'object'==typeof exports?module.exports=b(a,require('jquery')):'function'==typeof define&&define.amd?define(['jquery'],function(c){return b(a,c)}):b(a,a.jQuery)}(this,function(a,b,c){b.sticky=function(a,c,d){var e={speed:'fast',autoclose:1e3,duplicates:!1,position:'center',style:'success'};c&&b.extend(e,c);var f=Math.floor(99999*Math.random()),g=(Math.floor(99999*Math.random()),b('.ue-sticky-queue.'+e.position));g.length?e.duplicates||g.empty():(g=b("<div class=\"ue-sticky-queue "+e.position+'" ></div>'),b('body').append(g));var h=b("<div class=\"ue-sticky \" id=\""+f+'"></div>');g.prepend(h),h.append('<span class="ue-sticky-close">X</span>'),h.append('<div class="ue-sticky-note">'+a+'</div>'),h.css('height','auto'),h.addClass(e.style),h.slideDown(e.speed);var i=h.width()/-2;g.css('margin-left',i),h.ready(function(){e.autoclose&&h.delay(e.autoclose).fadeOut(e.speed)}),b('.ue-sticky-close').click(function(){b(this).parent().dequeue().fadeOut(e.speed)});var j={id:f,position:e.position,style:e.style};return d?void d(j):j}});