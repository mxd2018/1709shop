
<%@page import="java.util.*,com.qianfeng.domain.*"%>
<%@page import="java.util.*,com.qianfeng.domain.vo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>firstPageButtom</title>
		<link rel="stylesheet" href
		="css/shopcss.css"/>
	</head>
	<body>
		
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
				<a href="${pageContext.request.contextPath}/admin/adminIndex.jsp">后台登录</a>
			</div>
			<div id="button_2">
				Copyright &copy;2010-2017  &nbsp;千锋商城  &nbsp;版权所有
			</div>
			
			
	</body>

</html>
