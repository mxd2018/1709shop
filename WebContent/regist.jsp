<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/messages_zh.js"></script>


<!-- 判断用户名是否被注册 -->
<script type="text/javascript">
	$(function(){
		$("#username").blur(
				function(){
					$.post(
							"${pageContext.request.contextPath}/cheackRegistServlet",
							{"uname":this.value},
							function(data){
								if(data!=null){
									var info =data.uname;
									$("#uname_span").html("用户名已被注册");
								}else{
									$("#uname_span").html("");
								}
							},
							"json"
						)
				}
		);
	});	
</script>

<style>
	table{
		background-image:url(images/img/regist2.jpg);
	}
	tr{
		height:38px;
		
	}
	caption{
		font-size:30px;
	}
</style>

<!-- 表单提示信息样式 -->
<style>
	.error{
		color: #FF0000;
		font-family: "微软雅黑";
		font-size: 10px;
	}
</style>

<!-- 表单验证 -->
<script>
	$(function(){
		$("#registform").validate({
			rules:{
				
				userpassword:{
					required:true,
				},
				password2:{
					required:true,
					equalTo:$("input[name='userpassword']")
					
				},
				realname:{
					required:true,
				},
				email:{
					required:true,
					email:true
				},
				telephone:{
					required:true,
				},
				addr:{
					required:true,
				},
				addr2:{
					required:true,
				},
				birthday:{
					required:true,
					dateISO:true
				},
				sex:{
					required:true,
				},
				job:{
					required:true,
				}
				
				
			},
			messages:{
				
				userpassword:{
					required:"请输入密码",
				},
				password2:{
					required:"请确认密码",
					equalTo:"输入密码不一致"
				},
				realname:{
					required:"请输入您的真实姓名",
				},
				email:{
					required:"请填写有效邮箱",
					email:"邮箱格式不正确"
				},
				telephone:{
					required:"请输入手机号",
				},
				addr:{
					required:"请选择省市",
				},
				birthday:{
					required:"请填写生日",
				},
				job:{
					required:"请选择职业",
				}
			}
		});
	});
</script>
		
		
</script>

<link rel="stylesheet" href="css/shopcss.css"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册界面</title>
</head>
<body>
	<form  id="registform" action="${pageContext.request.contextPath }/registServlet" method="post">
		<table align="center" cellspacing="0px" cellpadding="0px" border="1px" width="650px" bgcolor="#999">
			<caption align="center" >会员注册</caption>
			<!-- <input type="hidden" name="uid"> -->
			<tr>
				<td width="50%" align="center" >
					用户名
				</td>
				<td>
					<input type="text" name="uname" id="username" placeholder="请输入用户名">
					<span id="uname_span"></span>
				</td>
			</tr>
			<tr >
				<td width="50%" align="center">
					密码
				</td>
				<td>
					<input type="password" name="userpassword" id="password1" placeholder="请输入密码">
					
				</td>
			</tr>
			<tr >
				<td width="50%" align="center">
					确认密码
				</td>
				<td>
					<input type="password" name="password2" id="password2" placeholder="请再次输入密码">
				</td>
			</tr>
			<tr >
				<td width="50%" align="center">
					真实姓名
				</td>
				<td>
					<input type="text" name="realname" id="realname">
				
				</td>
			</tr>
			<tr >
				<td width="50%" align="center">
					邮箱
				</td>
				<td>
					<input type="text" name="email" id="email">
					
				</td>
			</tr>
			<tr >
				<td width="50%" align="center">
					电话
				</td>
				<td>
					<input type="text" name="telephone" id="telephone">
					
				</td>
			</tr>
			<tr >
				<td width="50%" align="center">
					地址
				</td>
				<td>
					<select name="addr" id="addr" onchange="chooes(this.value)">
						<option value="">---请选择省份---</option>
						<option value="0">浙江省</option>                
						<option value="1">北京省</option>
						<option value="2">江苏省</option>
						<option value="3">上海市</option>
					</select>
					<select name="addr2" id="addr2">
						<option>---请选择市区---</option>	
					</select>
						<label for="addr" class="error"></label>
					<!-- <input type="text" name="addr"> -->
				</td>
			</tr>
			<tr >
				<td width="50%" align="center">                                                                                     
					生日
				</td>
				<td>
					<input type="text" name="birthday">
				</td>
			</tr>
			<tr >
				<td width="50%" align="center">
					性别
				</td>
				<td>
					<input type="radio" name="sex" value="male">男
					<input type="radio" name="sex" value="female">女
					<label for="sex" class="error"></label>
				</td>
			</tr>
			<tr >
				<td width="50%" align="center">
					职业
				</td>
				<td>
					<select name="job">
						<option value="">---请选择---</option>
						<option value="doctor">医生</option>
						<option value="teacher">老师</option>
						<option value="programmer">程序猿</option>
						<option value="engineer">攻城狮</option>
					</select>
					
				</td>
			</tr>
			<!-- <tr >
				<td width="50%">
					爱好
				</td>
				<td>
					<input type="checkbox" name="Allhobby" onchange="change()">全选
					<input type="checkbox" name="hobby" value="food">美食
					<input type="checkbox" name="hobby" value="study">学习
					<input type="checkbox" name="hobby" value="movies">电影-
				</td>
			</tr> -->
			<tr >
				<td width="50%" align="center">
					简介
				</td>
				<td>
					<textarea name="introduce">这是我的简介！</textarea>
				</td>
			</tr>
			<!-- <tr >
				<td width="50%">
					头像
				</td>
				<td>
					<input type="file">
				</td>
			</tr> -->
			<tr >
				<td width="50%" align="center">
					你的头像
				</td>
				<td>
					<input type="image" name="picture" value="images/img/meinv.jpg" src="images/img/meinv.jpg" width="180px" height="100px">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<table width="100%">
						<tr align="center" >
							<td >
								<input type="submit" id="sub" value="注册"/ style="width:100px;height:30px;color:red">&nbsp;&nbsp;
								<input type="reset"  value="重置" style="width:100px;height:30px;color:red"/>&nbsp;&nbsp;
								<input type="button" onclick="history.go(-1)" value="返回" style="width:100px;height:30px;color:red"/>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		</form>
	</body>

	<script>
		//省市选择的二级联动
		function chooes(v){
			var sel =document.getElementById("addr2");
			sel.length=1;
			
			var city=new Array();
			city[0]=new Array("杭州市","台州市","温州市","嘉兴市");
			city[1]=new Array("朝阳区","海淀区","东城区","丰台区");
			city[2]=new Array("南京市","无锡市","定安市");
			city[3]=new Array("黄浦区","徐汇区","松江区","浦东新区");
			
			for(var i=0;i<city[v].length;i++){
				var addoptions=document.createElement("option");
				var options =document.createTextNode(city[v][i])
				
				addoptions.appendChild(options);
				sel.appendChild(addoptions);
			}
		}
	</script>
	<script>
		 
		 
		 function change(){
		 	var Allhobby= document.getElementsByName("Allhobby")[0];
			
			var hobby=document.getElementsByName("hobby");
			
			if(Allhobby.checked){
				for(var i=0;i<hobby.length;i++){
					hobby[i].checked=true;
				}
			}else{
				
				for(var i=0;i<hobby.length;i++){
					hobby[i].checked=false;
				}
			}
			
			for(var i=0;i<hobby.length;i++){
				hobby[i].onchange=function(){
					var flag=true;
					for(var j=0;j<hobby.length;j++){
						if(hobby[j].checked==false){
							flag=false;
						}
					}
					if(flag){
						Allhobby.checked=true;
					}else{
						Allhobby.checked=false;
					}
				}
			}
		
		}
	</script>
</body>
</html>