<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.qianfeng.domain.*"%>
<%@page import="com.qianfeng.domain.vo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="900px" cellpadding="0px" cellspacing="0px" border="1px" align="center">
  		<caption style="font-size:30px;font-weight:bold;">订单详情表</caption>
  		<!--  pname,market_price,pimage,pdesc -->
  		<tr>
  			<td align="left" colspan="9">
  				收货人：
  				 ${list.get(0).uname} 
  				<br/>
  				联系电话：${list.get(0).telephone} 
  				<br/>
  				寄送地址： ${list.get(0).addr} ${list.get(0).addr2}
  				<br/>
  				下单时间：${order.getOrdertime() }
  				<br/>
  				订单编号：${order.oid }
  				<br/>
  				订单状态：${order.state }
  			</td>
  		</tr>
  		<tr align="center">
  			<td>商品名称</td>
  			<td>商品图片</td>
  			<td>市场价格</td>
  			<td>商品描述</td>
  			
  			<td>数量</td>
  			
  		</tr>
  		
  			<c:forEach items="${list}" var="pros">
  				<tr>
  					<td align="center">${pros.pname }</td>
  					<td align="center">
  					<img width="60px" height="60px" src="${pageContext.request.contextPath}/${pros.pimage }"/>
  					</td>
  					<td align="center">${pros.market_price }</td>
  					<td align="center">${pros.pdesc }</td>
  					
  					<td align="center">${order.pcount }</td>
  					
  					<%-- <td align="center">${order.oid }</td>
					<td align="center">${order.getOrdertime() }</td>
					
					<td align="center">${order.state }</td> --%>
						
  				</tr>
  			</c:forEach>
  			
			<tr height="40px" style="font-size:15px;font-weight:bold;">
				<td align="right" colspan="9">
					商品总价：${order.totalprice}￥
				</td>
			</tr>	
			
			<tr height="40px">
				<td align="right" colspan="9">
					<input type="submit" name="order_detail"  onclick="chooseBox()" value="支付">&nbsp;&nbsp;
					<input type="button" onclick="history.go(-1)" value="返回" />&nbsp;&nbsp;
				</td>
			</tr>
  		
  </table>
</body>
</html>