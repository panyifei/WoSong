$(document).ready(function(){

	//一进来根据url确定是哪个管理页面
	var url = window.location.href;
	var arg=url.split("?");
	if(arg.length>1){
	var args=arg[1].split("&");
	var args1=args[args.length-2].split("=");
	var args2=args[args.length-1].split("=");
	switch (args1[1]){
	case '1':
		$("ul.main-nav-ul li").eq(0).addClass("active");
		break;
	case '2':
		$("ul.main-nav-ul li").eq(1).addClass("active");
		break;
	case '3':
		$("ul.main-nav-ul li").eq(2).addClass("active");
		break;
	case '4':
		$("ul.main-nav-ul li").eq(3).addClass("active");
		break;
	default:
		$("ul.main-nav-ul li").eq(0).addClass("active");
		break;
	}
	switch (args2[1]){
	case '1':
		$("ul.second-nav-ul li").eq(0).addClass("active");
		break;
	case '2':
		$("ul.second-nav-ul li").eq(1).addClass("active");
		break;
	case '3':
		$("ul.second-nav-ul li").eq(2).addClass("active");
		break;
	case '4':
		$("ul.second-nav-ul li").eq(3).addClass("active");
		break;
	case '5':
		$("ul.second-nav-ul li").eq(4).addClass("active");
		break;
	case '6':
		$("ul.second-nav-ul li").eq(5).addClass("active");
		break;
	}
	}
	
	
	//设置senter的select
	$(".setSenter").change(function(){
		var senterId=$(this).find("option:selected").attr("data-senter-id");
		var orderId=$(this).parents(".row").siblings().find(".order-detail").attr("data-order-id");
		  $.post("setSenter",
				  {
				    senterId:senterId,
				    orderId:orderId
				  },
				  function(data,status){
				    alert("Data: " + data + "\nStatus: " + status);
				  });
	});
	
	
	$(".li-style").hover(function(){
		$(this).find(".common-operation").toggle();
		
	});
	
	$(".cancelOrder").click(function(){
		var orderId=$(this).parents(".common-operation").siblings().find(".order-detail").attr("data-order-id");
		$.post("cancelOrder",
				  {
				    orderId:orderId
				  },
				  function(data,status){
					  location.reload();
				  });
	});
	
	
	
});