
<%@page import="java.util.*,com.qianfeng.domain.*"%>
<%@page import="java.util.*,com.qianfeng.domain.vo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/messages_zh.js"></script>



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
		<title>商城</title>
		<link rel="stylesheet" href
		="css/shopcss.css"/>
	</head>
	<body>
		<div id="fater">
			<!--logol-->
			<div id="log">
				<div id="log_left">
					<img src="images/img/mylogo.png">
				</div>
				<c:if test="${empty user}">
					<div id="log_right">
					<a href="${pageContext.request.contextPath}/login.jsp">登录</a>
					<a href="#">注册</a>
					<a href="#">购物车</a>
					</div>
				</c:if>
				<c:if test="${!empty user}">
					<div id="log_right">
					
					<a href="#">Welcome Dear ${user.uname}!</a>
					<a href="${pageContext.request.contextPath}/exitServlet">退出登录</a>
					<a href="#">购物车</a>
					</div>
				</c:if>
				
				<div class="clearn"></div>
			</div>
			<!--广告栏-->
			<div>
				<div>
					<img width="100%" height="70px" src="images/img/ad2.bmp" style="display: none;" id="img">
				</div>
			</div>
			<!--导航栏-->
			<div class="daohang">
				<ul>
					<a href="${pageContext.request.contextPath}/pageProductServlet"><li>首页</li></a>
					<a href="#"><li>手机</li></a>
					<a href="#"><li>家用电器</li></a>
					<a href="#"><li>鞋帽箱包</li></a>
				</ul>
			</div>
			<!--banner栏-->
			<div>
				<img id="banner" src="images/img/b1.jpg" width="100%">
			</div>
			<!--商品栏1-->
			<div>
				<img src="images/img/tittle1.png" width="100%">
			</div>
			<p align="center" size="40px" >请登录首页</p>
			
			<!--搜索栏  -->
			<div align="center" style="height:150px">
				<div>
					<input type="text" id="search" size="86px" onkeyup="seachfn(this)"><button>搜索</button></br>
				</div>
				<div style="position:relative;width:675px">
					<div id="searchContentDiv" style="position:absolute;border:1px solid #999999;width:631px;display:none">
						
					</div>
				</div>
			</div>
			
			<!--商家承诺-->
			<div>
				<img src="images/img/bottom.png" width="100%">
			</div>
			<!--版权信息-->
			<div id="button">
				<a href="#">关于我们</a>
				<a href="#">联系我们</a>
				<a href="#">招贤纳士</a>
				<a href="#">法律声明</a>
				<a href="#">友情链接</a>
				<a href="#">支付方式</a>
				<a href="#">配送方式</a>
				<a href="#">广告声明</a>
				<a href="${pageContext.request.contextPath}/admin/index.jsp">后台登录</a>
			</div>
			<div id="button_2">
				Copyright &copy;2010-2017  &nbsp;千锋商城  &nbsp;版权所有
			</div>
			
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
	function seachfn(obj){
		$.post(
			"${pageContext.request.contextPath }/searchServlet",
			{"info":obj.value},
			
			function(data){
				
				var content="";
				if(data!=null){
					for(var i=0;i<data.length;i++){
						content+="<div onmouseover='overfn(this)' onclick='clickfn(this)' onmouseout='outfn(this)'>"+data[i].pname+"</div>";
					}
					$("#searchContentDiv").html(content);
					$("#searchContentDiv").css("display","block");
				}
				
			},
			"json"
		);
	}
	
	
	function outfn(obj){
		$(obj).css("background-color","#fff");
		
	}
	
	
	function overfn(obj){
		$(obj).css("background-color","#999");
		
	}
	function clickfn(obj){
		$("#search").val($(obj).html());
	}
</script>
</html>
