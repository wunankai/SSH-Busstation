<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <base href="<%=basePath%>">
    
    <title>网上客运</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" href="<%=path %>/css/login_page.css">
	<link href="<%=path %>/H-ui/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=path %>/js/jquery-3.2.1.min.js"></script>
 	<script type="text/javascript" src="<%=path %>/H-ui/static/h-ui/js/H-ui.js"></script> 
	<script type="text/javascript" src="<%=path %>/js/judgeLogin.js"></script>
  
  <script type="text/javascript" src="dwr/engine.js"></script>
	<script type="text/javascript" src="dwr/util.js"></script>
	<script type="text/javascript" src="dwr/interface/UserDAOAjax.js"></script>
  </head>
  <body onload="createCode();">
 	
  
	<div class="head">
		<div class="logo">
		<p style="float:left">
			<a href="<%=path %>/index.jsp"><img src="<%=path %>/img/logo-login.png"/></a>
		</p>
		</div>
	</div>
	<div class="center">
		<div class="login">
			<form action="login.action"  method="post" name="form2" onsubmit="return check();">
				<div class="login-page">
					<h2>用户登录</h2>
					<table style="margin:0 auto;border:0px" cellspacing="20" bordercolor="#E0FFFF"> 
						<tr>
							<td >	
								<i class="Hui-iconfont" style="font-size:30px;">&#xe602;</i>
								<input type="text" id="name" name="user.username"  placeholder="用户名" autocomplete="off" style="height: 36px; width: 253px; size:20;border-radius: 5px 5px 5px 5px;" >
				   			</td>
						</tr>
				<!-- 密码 -->
						<tr>
							<td >
							<i class="Hui-iconfont" style="font-size:30px;">&#xe60e;</i>
								<input type="password" id="password" name="user.password" placeholder="密码" autocomplete="off" style="height: 36px; width: 253px;border-radius: 5px 5px 5px 5px;">
				 			</td>
						</tr>

						<tr>
							<td style="padding-left: 40px;">
								<input id="codeNum" type="text" placeholder="验证码" onblur="checkCodeNum();" style="height: 36px; width: 100px;border-radius: 5px 5px 5px 5px;"> 								
								<span id="checkCode" style="color:red;font-size:15px;float:none;"></span>
								<a id="kanbuq" href="javascript:createCode();">看不清，换一张</a>							
							</td>
						</tr>

						<tr>
							<td >	
								<input id="loginSubmit" value="登&nbsp;&nbsp;录" type="submit">
							</td>
						</tr>
	 					<tr>
	 						<td class="black"> 
	 							 <span class="forgetPassword-span"><a id="forget" target="_blank" href="javascript:;">忘记密码？</a></span>
	 							 <span class="register-span"><a target="_blank" href="<%=path %>/register.jsp" title="注册">立即注册</a></span>
	 					 	</td>
		    			</tr> 	
					</table>
				</div>
			</form>
		</div>
	</div>
	
	
  </body>
<!--  <body>
	
	<form action="login.action" method="post">
	用户登录<br>
	姓名:<input type="text" name="user.username"/><br>
	密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="user.password"/><br>
	<input type="submit" value="登录"/><a href="register.jsp">注册</a>
	</form>
				
</body> -->
</html>