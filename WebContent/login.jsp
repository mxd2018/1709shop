<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
	table{
		background-image:url(images/img/regist2.jpg);
		
	}
	caption{
		
	}
</style>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录界面</title>
</head>
<body>
	
	<form action="${pageContext.request.contextPath}/checkLoginServlet" method="post">
		<table align="center" cellspacing="0px" cellpadding="0px" border="1px" width="650px">
			<caption style="font-size:40px;">
			用户登录
			</caption>
			
			<tr height="550px" style="font-size:28px">
				
				<td align="center">
				${loginfaile==null?"":loginfaile }<br/>
				账号<input type="text" name= "uname" size="40px" style="height:30px"><br/>
				<br/>
				密码<input type="password" name= "password" size="40px" style="height:30px"><br/>
				<br/>
				验证码<input type="text" name="checkcode" style="height:30px"  size="25px">
				<img onclick="changeimg(this)" src="/1709shop/checkImgServlet" height="30px"><br/><br/>
				
				自动登录<input type="checkbox" name="autologin" value="autologin" style="width:20px;height:20px;"><br/><br/>		
				
				<input type="submit" value= "登录" style="width:100px;height:30px;font-size:20px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button onclick="history.go(-1)" style="width:100px;height:30px;font-size:20px">返回</button>
				
				</td>
				
					
			</tr>	
			
			
				
			
			
		</table>
	</form>
</body>
<script type="text/javascript">
function changeimg(obj){
	obj.src="${pageContext.request.contextPath}/checkImgServlet?time="+new Date().getTime();
}
</script>
</html>