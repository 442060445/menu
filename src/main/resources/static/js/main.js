jQuery(document).ready(function($){
	$(".mainmenu-area").sticky({topSpacing:0});
    
    
    $('.product-carousel').owlCarousel({
        loop:true,
        nav:true,
        margin:20,
        responsiveClass:true,
        responsive:{
            0:{
                items:1,
            },
            600:{
                items:3,
            },
            1000:{
                items:5,
            }
        }
    });  
    
    $('.related-products-carousel').owlCarousel({
        loop:true,
        nav:true,
        margin:20,
        responsiveClass:true,
        responsive:{
            0:{
                items:1,
            },
            600:{
                items:2,
            },
            1000:{
                items:2,
            },
            1200:{
                items:3,
            }
        }
    });  
    
    $('.brand-list').owlCarousel({
        loop:true,
        nav:true,
        margin:20,
        responsiveClass:true,
        responsive:{
            0:{
                items:1,
            },
            600:{
                items:3,
            },
            1000:{
                items:4,
            }
        }
    });    
    
    
    // Bootstrap Mobile Menu fix
    $(".navbar-nav li a").click(function(){
        $(".navbar-collapse").removeClass('in');
    });    
    
    // jQuery Scroll effect
    $('.navbar-nav li a, .scroll-to-up').bind('click', function(event) {
        var $anchor = $(this);
        var headerH = $('.header-area').outerHeight();
        $('html, body').stop().animate({
            scrollTop : $($anchor.attr('href')).offset().top - headerH + "px"
        }, 1200, 'easeInOutExpo');

        event.preventDefault();
    });    
    
    // Bootstrap ScrollPSY
    $('body').scrollspy({ 
        target: '.navbar-collapse',
        offset: 95
    });      
	

/*    var abtns = document.querySelectorAll(".add");
    ccount.innerHTML = totalCount;
    for(var i = 0, len = abtns.length; i < len; i++) {
        abtns[i].onclick = function() {
            var li = this.parentNode.parentNode;
            var pid = li.getAttribute("pid");//获取自定义属性
            var arrs = li.children;//获取所有子节点
            if(checkObjByPid(pid)) {
                listObj = updateObjById(pid, 1)
            } else {
                var imgSrc = $(".btn")[1].parentNode.parentNode.children[0].children[0].src;
                var pName = $(".btn")[1].parentNode.parentNode.children[1].children[0].innerHTML;
                var pDesc = $(".btn")[1].parentNode.parentNode.children[1].children[1].innerHTML;
                var price = $(".btn")[1].parentNode.parentNode.children[1].children[2].children[0].innerHTML;
                var obj = {
                    pid: pid,
                    pImg: imgSrc,
                    pName: pName,
                    pDesc: pDesc,
                    price: price,
                    pCount: 1
                };
                listObj.push(obj)
                listObj = updateData(listObj);
            }
            ccount.innerHTML = getTotalCount();
        }
    }*/
	//加的效果  
/*	 for(var i = 0, len = abtns.length; i < len; i++) {
        abtns[i].onclick = function() {  
            $(this).prevAll().css("display", "inline-block");  
            var n = $(this).prev().text();  
            var num = parseInt(n) + 1;  
            if (num == 0) { return; }  
            $(this).prev().text(num);  
            var danjia = $(this).next().text();//获取单价  
            var a = $("#totalpriceshow").html();//获取当前所选总价  
            $("#totalpriceshow").html((a * 1 + danjia * 1).toFixed(2));//计算当前所选总价  
              
            var nm = $("#totalcountshow").html();//获取数量  
            $("#totalcountshow").html(nm*1+1);  
            jss();//<span style='font-family: Arial, Helvetica, sans-serif;'></span>   改变按钮样式
        } 
	//减的效果  
    var mbtns = document.querySelectorAll(".minus");
    for(var i = 0, len = mbtns.length; i < len; i++) {
        mbtns[i].onclick = function() { 
    		var n = $(this).next().text();  
    		var num = parseInt(n) - 1;  
    		$(this).next().text(num);//减1  
    		if (num <= 0) {  
    			$(this).next().css("display", "none");  
    			$(this).css("display", "none");  
    			jss();//改变按钮样式  
    			 return  
    		} 
        }  
    }
	function jss() {  
		var m = $("#totalcountshow").html();  
		if (m > 0) {  
			$(".right").find("a").removeClass("disable");  
		} else {  
		   $(".right").find("a").addClass("disable");  
		}  
	};*/
});