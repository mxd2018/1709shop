<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,com.qianfeng.domain.*"%>
<%@page import="java.util.*,com.qianfeng.domain.vo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  `oid` varchar(100) DEFAULT NULL,
  `ordertime` varchar(100) DEFAULT NULL,
  `pcount` int(11) DEFAULT NULL,
 
  `state` varchar(50) DEFAULT NULL,
  uno
  `totalprice` double DEFAULT NULL -->
  
  <table width="800px" cellpadding="0px" cellspacing="0px" border="1px" align="center">
  		<caption style="font-size:30px;font-weight:bold;">订单表</caption>
  		<tr align="center">
  			
  			<td>订单号</td>
  			<td>下单时间</td>
  			
  			
  			<td>数量</td>
  			<td>订单状态</td>
  			<td>商品总价</td>
  			<td>选择订单</td>
  			
  		</tr>
  		
  			<tr height="40px" align="center">
				<td align="center">${order.oid }</td>
				<td align="center">${order.getOrdertime() }</td>
				
				
				
			
				<td align="center">${order.pcount }</td>
				<td align="center">${order.state }</td>
				<td align="center">${order.totalprice }</td>
				<td>
				<input type="checkbox" name="checkSingleBox" >
				</td>
			</tr>
			<tr height="40px">
				<td align="right" colspan="6">
					<input type="submit" name="order_detail"  onclick="chooseBox()" value="支付">&nbsp;&nbsp;
					<button onclick='location.href="${pageContext.request.contextPath }/order_detailServlet"'>订单详情</button>&nbsp;&nbsp;
					<input type="button" onclick="history.go(-1)" value="返回" />&nbsp;&nbsp;
				</td>
			
			</tr>
  		
  </table>
</body>
</html>