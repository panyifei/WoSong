<!DOCTYPE html>
<!-- saved from url=(0046)http://v3.bootcss.com/examples/justified-nav/# -->
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zh-cn"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="http://v3.bootcss.com/docs-assets/ico/favicon.png">

    <title>WoSong管理页面</title>

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/justified-nav.css" rel="stylesheet">
    <script src="/js/jquery.min.js"></script>
    <script src="/js/commonUse.js"></script>
    <script src="/js/productManage.js"></script>
    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">

      <div class="masthead">
      <div class="clearfix">
        <div class="pull-left">
        <h3 class="text-muted">WoSong(<%=request.getSession().getAttribute("school")%>)</h3>
        </div>
        <div class="pull-right">
        <h4><%=request.getSession().getAttribute("admin_name")%>,欢迎使用<a href="quitLogin">退出</a></h4>
        </div>
        </div>
        <ul class="nav nav-justified main-nav-ul">
          <li><a href="orderManage?pageSize=10&pageidx=1&main-nav-li=1&second-nav-li=1">订单管理</a></li>
          <li><a href="shelfedProductsManage?pageSize=10&pageidx=1&main-nav-li=2&second-nav-li=1">商品管理</a></li>
          <li><a href="userManage?pageSize=10&pageidx=1&main-nav-li=3&second-nav-li=1">用户管理</a></li>
          <li><a href="#">敬请期待</a></li>
        </ul>
      </div>
      
      




<div class="row main-div">
<div class="col-lg-2">
<ul class="nav  second-nav-ul">
          <li><a href="shelfedProductsManage?pageSize=10&pageidx=1&main-nav-li=2&second-nav-li=1">上架商品</a></li>
          <li><a href="addProductsManage?main-nav-li=2&second-nav-li=2">添加商品</a></li>
          <li><a href="recommendProductsManage?pageSize=10&pageidx=1&main-nav-li=2&second-nav-li=3">推荐商品</a></li>
          <li><a href="unShelfedProductsManage?pageSize=10&pageidx=1&main-nav-li=2&second-nav-li=4">下架商品</a></li>
          <li><a href="allProductsManage?pageSize=10&pageidx=1&main-nav-li=2&second-nav-li=5">所有商品</a></li>
        </ul>
</div>
<div class="col-lg-10">

      <div class="list-group-item">
      <form enctype="multipart/form-data" method='post'  action='addProduct'>
        	<div class="row">
		        <div class="col-lg-2">食物名字</div>
 				<div class="col-lg-2"><input type="text" name="food_name"/></div>
           </div> 
   		   <div class="row">
		        <div class="col-lg-2">食物详细</div>
 				<div class="col-lg-2"><input type="text" name="food_detail"/></div>
           </div>
           <div class="row">
		        <div class="col-lg-2">学校</div>
 				<div class="col-lg-2"><input type="text" name="school"/></div>
           </div> 
           <div class="row">
		        <div class="col-lg-2">价格</div>
 				<div class="col-lg-2"><input type="text" name="price"/></div>
           </div> 
           <div class="row">
		        <div class="col-lg-2">商店名</div>
 				<div class="col-lg-2"><input type="text" name="shop_name" placeholder="personal"/></div>
           </div> 
           <div>
           <input type="file" name="file" size="50" />
			<input type="submit" value="upload" />
           </div>
      </form>
      </div>

      </div><!-- 右边的 -->
      </div><!-- 全部-->


      <!-- Site footer -->
      <div class="footer">
        <p>© 鸣谢  潘逸飞</p>
      </div>

     

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  

</body></html>