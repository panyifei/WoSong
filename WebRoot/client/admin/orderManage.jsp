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
    <link href="/css/orderManage.css" rel="stylesheet">

    <script src="/js/jquery.min.js"></script>
    <script src="/js/commonUse.js"></script>
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
          <li><a href="orderManage?pageSize=10&pageidx=1&main-nav-li=1&second-nav-li=1">未分配订单</a></li>
          <li><a href="unpayOrdersManage?pageSize=10&pageidx=1&main-nav-li=1&second-nav-li=2">未付款订单</a></li>
          <li><a href="endedOrdersManage?pageSize=10&pageidx=1&main-nav-li=1&second-nav-li=3">完结订单</a></li>
          <li><a href="allOrdersManage?pageSize=10&pageidx=1&main-nav-li=1&second-nav-li=4">全部订单</a></li>
        </ul>
</div>
<div class="col-lg-10">
      
      <div class="list-group-item">
        <div class="row">
        <div class="col-lg-1">
         		用户名
                </div>
        <div class="col-lg-1">
    		    时间
               </div>
        <div class="col-lg-1">
   			地址
                </div>
                <div class="col-lg-1">
   			  总价
                </div>
                <div class="col-lg-1">
    		电话
                </div>
                <div class="col-lg-1">
       		是否配送
                </div>
                
                  <c:choose>
				<c:when test="${order_type=='unsentOrders'}">
				<div class="col-lg-1">
      		               分配配送人
                </div>
				</c:when>	
				<c:otherwise>
				<div class="col-lg-1">
      		               配送人
                </div>
				</c:otherwise>
				</c:choose>
                
                
                 <div class="col-lg-1">
      		  是否付款
                </div>
                <c:if test="${order_type=='allOrders'}"> 
	          <div class="col-lg-1">
      		  是否取消
                </div>
                
	         
	         </c:if>
           </div>    
      </div>

  <!-- Jumbotron -->
      <div class="order-list-div">
      <ul class="list-group">
      
      <c:forEach items="${orders}" var="orders">
      <li class="list-group-item clearfix li-style">
      <div class="row">
        <div class="col-lg-1">
         ${orders.user_name}
                </div>
        <div class="col-lg-1">
        ${orders.create_time}
               </div>
        <div class="col-lg-1">
        ${orders.address}
                </div>
                <div class="col-lg-1">
      ${orders.sum_price}元
                </div>
                <div class="col-lg-1">
        ${orders.tel_phone}
                </div>
                <div class="col-lg-1">
                 <c:if test="${orders.if_sent=='false'}"> 
	                                                 未配送
	        		 </c:if>
	            <c:if test="${orders.if_sent=='true'}"> 
	                                                 已配送
	        		 </c:if>
                </div>
                
                
                
                <!--      这里判断是否是未分配order界面 -->
                 <c:choose>
				<c:when test="${order_type=='unsentOrders'}">
				<div class="col-lg-1">
	             <select class="form-control setSenter" style="width:60px;padding:0;">
	              <option>没有</option>
	             <c:forEach items="${senters}" var="senters">
				  <option data-senter-id="${senters.id}">${senters.senter_name}</option>
				  </c:forEach>
				</select>
				</div>
				</c:when>	
				<c:otherwise>
				<div class="col-lg-1">
       			${orders.senter_name}
                </div>
				</c:otherwise>
				</c:choose>
                
                

                
                <div class="col-lg-1">
                 <c:if test="${orders.if_pay=='false'}"> 
	                                                 未付款
	        		 </c:if>
	             <c:if test="${orders.if_pay=='true'}"> 
	                                                 已付款
	        		 </c:if>
                </div>
        
                
                
         <!--      这里判断是否是全部order界面 -->
                 <c:if test="${order_type=='allOrders'}"> 
                  <div class="col-lg-1">
	          		<c:if test="${orders.if_cancel=='false'}"> 
	                                                                           未取消
	        			 </c:if>
	           			  <c:if test="${orders.if_cancel=='true'}"> 
	                 	       已取消
	        			 </c:if>
                 </div>
	             </c:if>
      </div>
      
      <!--      这里判断order是否可以取消界面 -->
      <c:if test="${orders.if_cancel=='false'}"> 
	  <div class="pull-right common-operation" style="display:none">
      <a class="cancelOrder"><span class="glyphicon glyphicon-remove" title="取消订单" style="font-size:24px"></span></a>
      </div>
	   </c:if>
      
      
         <div class="clearfix">
         <div class="pull-left">
              <h4>订单详情:</h4>
	         </div>
           <div class="pull-left order-detail" data-order-id="${orders.id}">
            
	         <c:forEach items="${order_details}" var="order_details">
	         <c:if test="${order_details.order_id==orders.id}"> 
	            <h4>${order_details.food_name} ${order_details.count}份</h4>
	         </c:if>
	         </c:forEach>
	         
	         </div>
         
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