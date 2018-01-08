
<%@page import="java.util.*,com.qianfeng.domain.*"%>
<%@page import="java.util.*,com.qianfeng.domain.vo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#ul_page{
		display:inline;
	}
	#ul_page li{
		font-size:30px;
		margin-right: 10px;
	}
</style>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>firstPageHead</title>
		<link rel="stylesheet" href="css/shopcss.css"/>
	</head>
	<body>
		
			<!--logol-->
			<div id="log">
				<div id="log_left">
					<img src="images/img/mylogo.png">
				</div>
				<c:if test="${empty user}">
					<div id="log_right">
					<a href="${pageContext.request.contextPath}/login.jsp">登录</a>
					<a href="${pageContext.request.contextPath}/regist.jsp">注册</a>
					<a href="${pageContext.request.contextPath}/shoppingCarServlet">购物车</a>
					<a onclick="checkLogin()">我的订单</a>
					</div>
				</c:if>
				<c:if test="${!empty user}">
					<div id="log_right">
					
					<a href="#">Welcome Dear ${user.uname}!</a>
					<a href="${pageContext.request.contextPath}/exitServlet">退出登录</a>
					<a href="${pageContext.request.contextPath}/shoppingCarServlet">购物车</a>
					<a href="${pageContext.request.contextPath}/orderHistoryServlet">我的订单</a>
					</div>
				</c:if>
				
				<div class="clearn"></div>
			</div>
			<!--广告栏-->
			<div>
				<div>
					<img width="100%" height="300px" src="images/img/ad2.bmp" style="display: none;" id="img">
				</div>
			</div>
			<!--导航栏-->
			<div class="daohang">
				<ul id="daohang">
					<a href=""><li>首页</li></a>
					<a href="#"><li>手机</li></a>
					<a href="#"><li>家用电器</li></a>
					<a href="#"><li>鞋帽箱包</li></a>
				</ul>
				
				<input>
			</div>
			<!--banner栏-->
			<div>
				<img id="banner" src="images/img/b1.jpg" width="100%">
			</div>
			<!--商品栏1-->
			<div>
				<img src="images/img/tittle1.png" width="100%">
			</div>
			
		
			
			
	</body>
<!-- <script src="js/1709shop_js"></script> -->
<script>
		
		var i =1;
		var banner = document.getElementById("banner");
		setInterval(changeimg,2000);
		function changeimg(){
			if(i==1){
				banner.src="images/img/b2.jpg";
				i++;
			}else{
				banner.src="images/img/b1.jpg";
				i=1;	
			}
		}
	</script>
	<script>
		var img=document.getElementById("img");
		var set =setTimeout(show_ad,2000);
		function show_ad(){
			img.style.display="block";
			clearTimeout(set);
			setTimeout(hidden_ad,5000);
		}
		function hidden_ad(){
			img.style.display="none";
		}
	</script>
	
	<script>
	function checkLogin(){
		if(${empty user}){
			alert("请先登录账户！")
		}
	}
	</script>
</html>
