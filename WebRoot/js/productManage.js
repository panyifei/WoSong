$(document).ready(function(){


	$(".shelfFood").click(function(){
		var foodId=$(this).parents(".row").find("img").attr("data-food-id");
		$.post("shelfFood",
				  {
				    foodId:foodId
				  },
				  function(data,status){
					  var url = window.location.href;
					  var arg=url.split("/");
					  if(arg[arg.length-1]=="changeProduct"||arg[arg.length-1]=="addProduct"){
						  window.location.href="http://localhost/adminManage/allProductsManage?pageSize=10&pageidx=1&main-nav-li=2&second-nav-li=5";
					  }else{
					  location.reload();
					  }
				  });
	});
	
	$(".unshelfFood").click(function(){
		var foodId=$(this).parents(".row").find("img").attr("data-food-id");
		$.post("unshelfFood",
				  {
				    foodId:foodId
				  },
				  function(data,status){
					  var url = window.location.href;
					  var arg=url.split("/");
					  if(arg[arg.length-1]=="changeProduct"||arg[arg.length-1]=="addProduct"){
						  window.location.href="http://localhost/adminManage/allProductsManage?pageSize=10&pageidx=1&main-nav-li=2&second-nav-li=5";
					  }else{
					  location.reload();
					  }
				  });
	});
	
	$(".recommendFood").click(function(){
		var foodId=$(this).parents(".row").find("img").attr("data-food-id");
		$.post("recommendFood",
				  {
				    foodId:foodId
				  },
				  function(data,status){
					  var url = window.location.href;
					  var arg=url.split("/");
					  if(arg[arg.length-1]=="changeProduct"||arg[arg.length-1]=="addProduct"){
						  window.location.href="http://localhost/adminManage/allProductsManage?pageSize=10&pageidx=1&main-nav-li=2&second-nav-li=5";
					  }else{
					  location.reload();
					  }
				  });
	});
	$(".unrecommendFood").click(function(){
		var foodId=$(this).parents(".row").find("img").attr("data-food-id");
		$.post("unrecommendFood",
				  {
				    foodId:foodId
				  },
				  function(data,status){
					  var url = window.location.href;
					  var arg=url.split("/");
					  if(arg[arg.length-1]=="changeProduct"||arg[arg.length-1]=="addProduct"){
						  window.location.href="http://localhost/adminManage/allProductsManage?pageSize=10&pageidx=1&main-nav-li=2&second-nav-li=5";
					  }else{
					  location.reload();
					  }
				  });
	});
	
	//翻页js
	$(".previous-page").click(function(){
		if($(this).parent().hasClass('disabled')){
		}else{
		//一进来根据url确定是哪个管理页面
		var url = window.location.href;
		var arg=url.split("?");
		var args=arg[1].split("&");
		var pageSize=args[args.length-4].split("=");
		var pageidx=args[args.length-3].split("=");
		pageidx[1]=pageidx[1]*1-1;
		var newUrl=arg[0]+"?"+pageSize.join("=")+"&"+pageidx.join("=")+"&"+args[args.length-2]+"&"+args[args.length-1];
		window.location.href=newUrl;
		}
	});
	
	$(".next-page").click(function(){
		if($(this).parent().hasClass('disabled')){
		}else{
		//一进来根据url确定是哪个管理页面
		var url = window.location.href;
		var arg=url.split("?");
		var args=arg[1].split("&");
		var pageSize=args[args.length-4].split("=");
		var pageidx=args[args.length-3].split("=");
		pageidx[1]=pageidx[1]*1+1;
		var newUrl=arg[0]+"?"+pageSize.join("=")+"&"+pageidx.join("=")+"&"+args[args.length-2]+"&"+args[args.length-1];
		window.location.href=newUrl;
		}
	});
	
	
	//修改
	$(".change-food-btn").click(function(){
		//window.location.href="http://localhost/adminManage/shelfedProductsManage?pageSize=10&pageidx=1&main-nav-li=2&second-nav-li=1";
	});
	
});