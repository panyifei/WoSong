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
		<div class="list-group-item clearfix">
			<form class="clearfix" action="findProcucts?pageSize=10&pageidx=1&main-nav-li=2&second-nav-li=<c:if test="${products_type=='shelfedProducts'}">1</c:if><c:if test="${products_type=='unShelfedProducts'}">4</c:if><c:if test="${products_type=='allProducts'}">5</c:if><c:if test="${products_type=='recommendProducts'}">3</c:if>" method="post">
			<input type="text"  name="products_type" value="${products_type}" style="display:none;">
			<div class="pull-left">
            <input type="text" name="detail" class="form-control" placeholder="先选择类型">
            </div>
            <div class="pull-left">
           <select class="form-control" style="outline:none;" name="find_type">
			  <option>食物名</option>
			  <option>详细信息</option>
			  <option>学校</option>
			  <option>价格</option>
			  <option>商店名称</option>
			</select>
            </div>
            <div class="pull-left">
            <button type="submit" class="btn btn-primary">查询</button>
            </div>
            
             <ul class="pager pull-right">
             
			  <li class="<c:if test="${pageidx==1}">disabled</c:if>"><a class="previous-page">&larr;上一页</a></li>
			  <li class="<c:if test="${pageidx>=pageCount}">disabled</c:if>"><a class="next-page">下一页&rarr;</a></li>
			  <input type="text" class="page-input" value="${pageidx}">/${pageCount}<a href="#">跳转</a>
			</ul>
          </form>
          

          </div>
      <div class="list-group-item">
        <div class="row">
		        <div class="col-lg-2">食物图片</div>
		        <div class="col-lg-1">食物名</div>
		        <div class="col-lg-2">详细信息 </div>
                <div class="col-lg-1">学校</div>
                <div class="col-lg-1">价格 </div>
                <div class="col-lg-1">是否上架</div>
                <div class="col-lg-1">是否推荐</div>
                <div class="col-lg-1">商店名称</div>
           </div>    
      </div>
  <!-- Jumbotron -->
      <div class="order-list-div">
      <ul class="list-group">
      
      <c:forEach items="${foods}" var="foods">
      <li class="list-group-item clearfix li-style">
      <div class="row">
        <div class="col-lg-2">
        <img data-food-id="${foods.id}" class="food-img" src="${foods.food_img}"></img>
                </div>
        <div class="col-lg-1">
        ${foods.food_name}
               </div>
        <div class="col-lg-2">
        ${foods.food_detail}
                </div>
                <div class="col-lg-1">
      ${foods.school}
                </div>
                <div class="col-lg-1">
        ${foods.price}
                </div>
                <div class="col-lg-1">
                 <c:if test="${foods.if_shelf=='false'}"> 
	                                                未上架
	        		 </c:if>
	            <c:if test="${foods.if_shelf=='true'}"> 
	                                                 已上架
	        		 </c:if>
                </div>
                
                <div class="col-lg-1">
                 <c:if test="${foods.if_recommend=='false'}"> 
	                                                 未推荐
	        		 </c:if>
	             <c:if test="${foods.if_recommend=='true'}"> 
	                                                 已推荐
	        		 </c:if>
                </div>
                
                <div class="col-lg-1">
        ${foods.shop_name}
                </div>
                
                
		
                
		        <!--      这里判断food是否已被推荐 -->	   
			   <c:choose>
				<c:when test="${foods.if_recommend=='false'}">
				<div class="pull-right common-operation" style="display:none">
		      <a class="recommendFood"><span title="推荐商品"  class="glyphicon glyphicon-star" style="font-size:24px"></span></a>
		      <a class="changeFood" href="changeFood?foodId=${foods.id}&main-nav-li=2&second-nav-li=6"><span title="修改商品信息" class="glyphicon glyphicon-edit" style="font-size:24px"></span></a>
		      </div>
				</c:when>
				
				<c:otherwise>
			  <div class="pull-right common-operation" style="display:none">
		      <a class="unrecommendFood"><span title="取消推荐"  class="glyphicon glyphicon-star-empty" style="font-size:24px"></span></a>
		      <a class="changeFood" href="changeFood?foodId=${foods.id}&main-nav-li=2&second-nav-li=6"><span  title="修改商品信息" class="glyphicon glyphicon-edit" style="font-size:24px"></span></a>
		      </div>
				</c:otherwise>
				</c:choose>
	   
				    <!--      这里判断food是否已上架 -->
				    <c:choose>
					<c:when test="${foods.if_shelf=='false'}">
					<div class="pull-right common-operation" style="display:none">
			      <a class="shelfFood"><span title="上架商品" class="glyphicon glyphicon-arrow-up" style="font-size:24px"></span></a>
			      </div>
					</c:when>
					<c:otherwise>
				  <div class="pull-right common-operation" style="display:none">
			      <a class="unshelfFood"><span title="下架商品" class="glyphicon glyphicon-arrow-down" style="font-size:24px"></span></a>
			      </div>
					</c:otherwise>
					</c:choose>
	         
	   
           </div>
         </li>
        </c:forEach>
       </ul>
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