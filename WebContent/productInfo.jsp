<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购买详情页</title>
<link rel="stylesheet" href="css/buyinfo.css"/>
</head>
<body>
	<div id="buyfather">
		
		<div width="100%">
			<div id="picture_left">
				<img src="${pageContext.request.contextPath}/${pro.pimage}" width="350px" height="350px">
			</div>
			<div id="info_right" >
				<div width="100px">
					<p style="font-size:20px;font-weight:bold">${pro.pname}</p><br/>
					<p>促销价格：${pro.market_price}</p><br/>
					<p>专柜价格：${pro.shop_price}</p><br/>
					<p>上架日期：${pro.pdate}</p><br/><br/>
				</div>
				<div id="buy" align="center" >
					<!-- <a href="#" >立即购买</a> -->
					<input type="button" value="立即购买" style="width:150px;height:30px">
				</div>
				<div id="add" align="center">
					<%-- <a href="${pageContext.request.contextPath}/addProductToCarServlet?pid=${pro.pid}&pname=${pro.pname}">加入购物车</a> --%>
					
					<input type="button" value="加入购物车" onclick="location.href='${pageContext.request.contextPath}/addProductToCarServlet?pid=${pro.pid}&pname=${pro.pname}'" style="width:150px;height:30px">
				</div>
				
			</div>
			<div class="clearn"></div>
		</div>
		
		
		<div id="pdesc">
			<p style="font-size:20px">商品描述：${pro.pdesc}</p>
		</div>
	</div>
</body>
</html>