<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/dtree.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="100%" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<div class="dTree">
					<a href="javascript: d.openAll();">展开所有</a>|<a href="javascript: d.closeAll();">关闭所有</a>
					<script type="text/javascript" src="${pageContext.request.contextPath }/js/dtree.js"></script>
					<script type="text/javascript">
						d=new dTree('d');
						d.add('01',-1,'本店后台管理');
						d.add('0101','01','分类管理模块');
						d.add('010101','0101','分类管理','${pageContext.request.contextPath}/adminCategoryListServlet','','right');
						d.add('0102','01','商品管理模块');
						d.add('010201','0102','商品管理','${pageContext.request.contextPath}/adminPageProductServlet','','right');
						document.write(d);
					</script>
				</div>
			</td>
		</tr>
	</table>
	
</body>
</html>