<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台商品展示页面</title>

<script type="text/javascript">
	window.onload=function(){
		var is="${value.is_hot}";
		var ih=document.getElementById("ih");
		var options=ih.getElementsByTagName("option");
		for(var i=0;i<options.length;i++){
			if(options[i].value==is){
				options[i].selected=true;
			}
		}
		
		var c="${value.cid}";
		var sc=document.getElementById("sc");
		var options_sc=sc.getElementsByTagName("option");
		for(var i=0;i<options_sc.length;i++){
			if(options_sc[i].value==c){
				options_sc[i].selected=true;
			}
		}
	}
</script>
</head>
<body>
	<table width="100%" cellpadding="0px" cellspacing="0px" border="1px">
		<caption>商品列表</caption>
		<tr>
			<form action="${pageContext.request.contextPath}/adminSearchProductServlet" method="post">
				<td colspan="7" width="100%">
					商品名称<input type="text" name="pname" value="${value.pname}">&nbsp;&nbsp;&nbsp;
					是否热门<select name="is_hot" id="ih">
							<option value="">"===请选择==="</option>
							<option value="1">是</option>
							<option value="0">否</option>
						</select>&nbsp;&nbsp;&nbsp;
					所属分类<select name="cid" id="sc">
							<option value="">===请选择===</option>
							<c:forEach items="${cList}" var="category" >
								<option value="${category.cid}">${category.cname}</option>
							</c:forEach>
						</select>&nbsp;&nbsp;&nbsp;
					<input type="submit" value="搜索">
				</td>	
			</form>
		</tr>
		<tr align="right">
			<td colspan="7">
				<button onclick="addProduct()">添加商品</button>
			</td>
		</tr>
		<tr>
			<td align="center">序号</td>
			<td align="center">图片</td>
			<td align="center">名称</td>
			<td align="center">门店价格</td>
			<td align="center">是否热门</td>
			<td align="center">编辑</td>
			<td align="center">删除</td>
		</tr>
	
	<!-- 分页显示模块 -->
	<form action="${pageContext.request.contextPath}/adminDeleteCheckedProductServlet" method="post">
		<c:forEach items="${pagebean.pageData}" var="pro" varStatus="vs">
			<tr>
				<td align="center">${vs.count }</td>
				<td align="center">
					<img src="${pro.pimage}" width="40px" height="45px">
				</td>
				<td align="center">${pro.pname }</td>
				<td align="center">${pro.shop_price}</td>
				<td align="center">${pro.is_hot==1?"是":"否" }</td>
				<td align="center">
					<a href="javascript:void(0)" onclick="editPro('${pro.pid}')">编辑</a>
				</td>
				<td align="center">
					<%-- <a href="javascript:void(0)" onclick="deletePro('${pro.pid}')">删除</a> --%>
					<input type="checkbox" name="checkSingleBox" onclick="chooseBox()" value="${pro.pid}">
				</td>
			</tr>
		</c:forEach>
		
			<tr>
				<td align="right" colspan="7">
					全选<input type="checkbox" name="checkAllBox" id="checkAll">
					<input type="submit" value="删除" onclick="confirm('请不要删除我？')">
				</td>
			</tr>
			<tr>
				<td colspan="7">
					<div style="text-align:center">
					<ul id="admin_ul">
						<c:if test="${pagebean.currentPage!=1 }">
							<li><a href="${pageContext.request.contextPath}/adminPageProductServlet?currentPage=${pagebean.currentPage-1}">上一页</a></li>
						</c:if>
						<c:if test="${pagebean.currentPage==1 }">
							<li>上一页</li>
						</c:if>

						<c:forEach begin="1" end="${pagebean.totalPage }" var="page">
							<c:if test="${page!=pagebean.currentPage }">
								<li>
								<a href="${pageContext.request.contextPath}/adminPageProductServlet?currentPage=${page}">${page}</a>&nbsp;&nbsp;&nbsp;
								</li>
							</c:if>
							<c:if test="${page==pagebean.currentPage }">
								<li><font size="40px">${page}</font></li>
							</c:if>
						</c:forEach>
					
						<c:if test="${pageBean.currentPage!=pageBean.totalPage }">
							<li><a href="${pageContext.request.contextPath}/adminPageProductServlet?currentPage=${pageBean.currentPage+1}">下一页</a></li>
						</c:if>
						<c:if test="${pageBean.currentPage==pageBean.totalPage }">
							<li>下一页</li>
						</c:if>
					</ul>
				</div>
				</td>
			</tr>
		</form>	
	</table>
</body>
<style>
	#admin_ul li{
		display:inline;
		text-decoration:none;
	}
	#admin_ul a{
		text-decoration:none;
	}
</style>

<script>
	//删除提示框
	function deletePro(pid){
		var conf = confirm('你确定要删除吗？');
		if(conf==true){
			location.href="${pageContext.request.contextPath}/adminDeleteProductServlet?pid="+pid;
		}
	}
</script>

<script type="text/javascript">
	//添加商品
	function addProduct(){
		location.href="${pageContext.request.contextPath}/categoryServlet";
	}
	//编辑商品
	function editPro(pid){
		location.href="${pageContext.request.contextPath}/showEditProductServlet?pid="+pid;
	}
</script>

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