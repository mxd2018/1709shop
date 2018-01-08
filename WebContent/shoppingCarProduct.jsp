<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/messages_zh.js"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车详情</title>
<style>
	table{
		border-color:#999;
	}
	caption{
		font-size:30px;
		font-weight:bold;
	}
	#head_tr{
		height:40px;
		font-weight:bold;
	}
	tr{
		height:80px;
	}
	
	#add{
		width:120px;
		height:40px;
		font-size:20px;
		font-weight:bold;
	}
	#pay{
		width:80px;
		height:40px;
		font-size:20px;
		font-weight:bold;
	}
	#delete{
		width:80px;
		height:40px;
		font-size:20px;
		font-weight:bold;
	}
	#checkAll{
		width:18px;
		height:18px;
		
	}
</style>
</head>
<body>
	<table width="100%" cellpadding="0px" cellspacing="0px" border="1px">
		<caption>购物车列表</caption>
		
		<tr align="right">
			<td colspan="7">
				<button id="add" onclick="location.href='${pageContext.request.contextPath}/pageProductServlet'">添加商品</button>
			</td>
		</tr>
		<tr id="head_tr">
			<td align="center">序号</td>
			<td align="center">图片</td>
			<td align="center">名称</td>
			<td align="center">门店价格</td>
			<td align="center">是否热门</td>
			<td align="center">数量</td>
			<td align="center">删除</td>
		</tr>
	<form id="carform" action="${pageContext.request.contextPath}/addOrderServlet" method="post">
		<!--购物车商品显示  -->
		<c:forEach items="${pList}" var="pro" varStatus="vs">
			<tr>
				<td align="center">${vs.count }</td>
				<td align="center">
					<img src="${pro.pimage}" width="40px" height="45px">
				</td>
				<td align="center">${pro.pname }</td>
				<td align="center">${pro.shop_price}</td>
				<td align="center">${pro.is_hot==1?"是":"否" }</td>
				<td align="center">
					<a href="javascript:void(0)" onclick="addCount()">1</a>
				</td>
				<td align="center">
					
					<input type="checkbox" name="checkSingleBox"  onclick="chooseBox()" value="${pro.pid}">
				</td>
			</tr>
		</c:forEach>
		<!-- 购物车商品删除与结算 -->
			<tr>
				<td align="right" colspan="7">
					
					<input type="submit" id="pay" value="结算" onclick="location.href='${pageContext.request.contextPath}/addOrderServlet'">&nbsp;&nbsp;
					
					<input type="button" id="delete" value="删除" onclick="submit1()">&nbsp;&nbsp;&nbsp;
					全选<input type="checkbox"  name="checkAllBox" id="checkAll">&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
			<%-- <tr>
				<td align="right" colspan="7">
				<button id="pay" onclick="location.href='${pageContext.request.contextPath}/addOrderServlet'">结算</button>&nbsp;&nbsp;
				</td>
			</tr> --%>
		</form>	
		
	</table>
</body>

<script>
	function submit1(){
		document.getElementById("carform").action="${pageContext.request.contextPath}/deleteCheckedShoppingCarProductServlet";
		document.getElementById("carform").submit();
	}

/* 	$("#pay").click(function{
		$("#carform").attr("action","${pageContext.request.contextPath}/addOrderServlet");
		$("#carform").submit();
	});
	
	onclick="confirm('亲！你真的不要我了吗？')"
	
	$("#delete").click(function{
		$("#carform").attr("action","${pageContext.request.contextPath}/deleteCheckedShoppingCarProductServlet");
		$("#carform").submit();
	}); */
	
	/* $(function(){
		$("#delete").click(
				function(){
					$.post(
							"${pageContext.request.contextPath}/deleteCheckedShoppingCarProductServlet",
							{"uname":this.value},
							function(data){
								alert("商品已删除");
							},
							null;
						)
				}
		);
	}); */
</script>

<script type="text/javascript">
	function addProduct(){
		location.href="${pageContext.request.contextPath}/categoryServlet";
	}
	
	function addCount(){
		location.href="${pageContext.request.contextPath}/showEditProductServlet?pid="+pid;
	}
</script>

<!-- <script>
	$(function(){
		$("#checkAll").change(function(){
			$(".checkSingleBox").attr("checked",this.checked);
		});
		
	});
	
</script> -->

<script type="text/javascript">
	//全选与全不选功能
	var checkAll= document.getElementById("checkAll");
	var checkSingle = document.getElementsByName("checkSingleBox");
	checkAll.onclick=function(){
		if(checkAll.checked==true){
			for(var i=0;i<checkSingle.length;i++){
				checkSingle[i].checked=true;
			}
		}else{
			for(var i=0;i<checkSingle.length;i++){
				checkSingle[i].checked=false;
			}
		}
	}
	
	function chooseBox(){
		var flag=true;
		for(var i=0;i<checkSingle.length;i++){
			if(checkSingle[i].checked==false){
				flag=false;
				break;
			}
		}
		if(flag){
			checkAll.checked=true;
		}else{
			checkAll.checked=false;
		}
	}
	

</script>

</html>