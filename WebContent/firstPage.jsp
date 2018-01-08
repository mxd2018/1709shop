
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
		<title>商城首页</title>
		<link rel="stylesheet" href="css/shopcss.css"/>
	</head>
	<body>
		<div id="fater">
		
		<!--logol模块-->
		<jsp:include page="/firstPageHead.jsp"></jsp:include>
			
			
		<!-- 商品展示部分 -->	
	
			<div id="pic_left1">
					<img src="images/img/banner_left.jpg" style='width:225px;height:514px'>
			</div>
			
			<div id="pic_right1">	
			<c:forEach items="${pageBean.pageData}" var="pro">
				<div  style='width:25%;float:left;padding-top:10px;text-align:center;width:223px;height:250px;'>
					
						<img  width="100px" height="100px" src="${pageContext.request.contextPath}/${pro.pimage }" onclick="location.href='${pageContext.request.contextPath}/buyProductServlet?pid=${pro.pid}'"><br/>
						<p>${pro.pname}<br/>${pro.shop_price }￥</p><br/>
						
						<a href="${pageContext.request.contextPath}/buyProductServlet?pid=${pro.pid}" style="text-decoration: none">立即购买</a>
						<a href="${pageContext.request.contextPath}/addProductToCarServlet?pid=${pro.pid}&pname=${pro.pname}" style="text-decoration: none">加入购物车</a>
							
				</div>			
			</c:forEach>		
			</div>
	
			<!--商品栏2-->
			<div>
				<img src="images/img/tittle2.png" width="100%">
			</div>
			<!--商品信息2-->
			<div id="pic_left2">
					<img src="images/img/banner_left2.jpg" style='width:225px;height:514px'>
			</div>
			
			<div id="pic_right2">	
			<c:forEach items="${pageBean.pageData}" var="pro">
				<div  style='width:25%;float:left;padding-top:10px;text-align:center;width:223px;height:260px;'>
					
						<img  width="100px" height="100px" src="${pageContext.request.contextPath}/${pro.pimage }" onclick="location.href='${pageContext.request.contextPath}/buyProductServlet?pid=${pro.pid}'"><br/>
						<div width="223px" height="63px">
							<p>${pro.pname}<br/>${pro.shop_price }￥</p><br/>
						</div>
						
						<a href="${pageContext.request.contextPath}/buyProductServlet?pid=${pro.pid}" style="text-decoration: none">立即购买</a>
						<a href="${pageContext.request.contextPath}/addProductToCarServlet?pid=${pro.pid}&pname=${pro.pname}" style="text-decoration: none">加入购物车</a>
							
				</div>			
			</c:forEach>		
			</div>
			
			<div class="clearn"></div>
			
		<!-- 分页模块 -->
			<div>
				<div style="text-align:center">
					<ul id="ul_page">
						<c:if test="${pageBean.currentPage!=1 }">
							<li><a href="${pageContext.request.contextPath}/pageProductServlet?currentPage=${pageBean.currentPage-1}">上一页</a></li>
						</c:if>
						<c:if test="${pageBean.currentPage==1 }">
							<li>上一页</li>
						</c:if>

						<c:forEach begin="1" end="${pageBean.totalPage }" var="page">
							<c:if test="${page!=pageBean.currentPage }">
								<li>
								<a href="${pageContext.request.contextPath}/pageProductServlet?currentPage=${page}">${page}</a>
								</li>
							</c:if>
							<c:if test="${page==pageBean.currentPage }">
								<li><font size="40px">${page}</font></li>
							</c:if>
						</c:forEach>
					
						<c:if test="${pageBean.currentPage!=pageBean.totalPage }">
							<li><a href="${pageContext.request.contextPath}/pageProductServlet?currentPage=${pageBean.currentPage+1}">下一页</a></li>
						</c:if>
						<c:if test="${pageBean.currentPage==pageBean.totalPage }">
							<li>下一页</li>
						</c:if>
					</ul>
				</div>
			</div>
			
			<!--bottom模块-->
			
			<jsp:include page="/firstPageButtom.jsp"></jsp:include>
			
		</div>	
	</body>
<!-- <script src="js/1709shop_js"></script> -->
<!--有问题待解决  -->
<script>

	function intoProductInfo(){
		location.href="${pageContext.request.contextPath}/buyProductServlet?pid="+${pro.pid};
	}
</script>

</html>
