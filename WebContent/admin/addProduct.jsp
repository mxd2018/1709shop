<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品页面</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/addProductServlet" method="post">
	<table width="100%" border="1px" cellpadding="0px" cellspacing="0px">
		<caption>添加商品</caption>
		<tr>
			<td align="center">商品名称</td>
			<td>
				<input type="text" name="pname" size="50">
			</td>
		</tr>
		<tr>
			<td align="center">商场价格</td>
			<td>
				<input type="text" name="market_price" size="50" >
			</td>
		</tr>
		<tr>
			<td align="center">门店价格</td>
			<td>
				<input type="text" name="shop_price" size="50">
			</td>
		</tr>
		<tr>
			<td align="center">商品图片</td>
			<td>
				<input type="file" name="pimage">
			</td>
		</tr>
		<tr>
			<td align="center">所属分类</td>
			<td>
				<select name="cid">
					<option value="">===请选择===</option>
					<c:forEach items="${cList}" var="category" >
						<option value="${category.cid}">${category.cname }</option>
					</c:forEach>	
				</select>
			</td>
		</tr>
		<tr>
			<td align="center">商品描述</td>
			<td>
				<textarea name="pdesc" rows="10" cols="30"></textarea>
			</td>
		</tr>
		<tr>
			<td align="center">是否热门</td>
			<td>
				<select name="is_hot">
					<option value="1">是</option>
					<option value="0">否</option>
				</select>	
			</td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<input type="submit" value="添加">
				<input type="reset" value="重置">
				<button onclick="history.go(-1)">返回</button>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>