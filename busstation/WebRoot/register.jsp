<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>网上客运-安全，快捷</title>
			<script type="text/javascript" src="<%=path %>/js/registerPage.js"></script>
			<link rel="stylesheet" href="<%=path %>/css/base.css" type="text/css">
			<link rel="stylesheet" href="<%=path %>/css/register.css" type="text/css">
			<link rel="stylesheet" href="<%=path %>/css/head.css" type="text/css">
			
			<script type="text/javascript" src="<%=path %>/H-ui/lib/jquery/1.9.1/jquery.js"></script>
			<script type="text/javascript" src="<%=path %>/H-ui/static/h-ui/js/H-ui.js"></script>
			<script type="text/javascript" src="<%=path %>/js/index.js"></script>
				
			
			<link rel="stylesheet" href="<%=path %>/H-ui/static/h-ui/css/H-ui.css" type="text/css" >
			<link href="<%=path %>/H-ui/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
			
			<style type="text/css">
				a:hover{
					text-decoration:underline;
					color:#FF0000
				}
			</style>
			<script type="text/javascript" src="dwr/engine.js"></script>
	<script type="text/javascript" src="dwr/util.js"></script>
	<script type="text/javascript" src="dwr/interface/UserDAOAjax.js"></script>
	<script type="text/javascript">	
		/*function show(boolean){
			if(boolean){
				alert("用户已经存在！");
			}
		}
		function validate(){
		var name=form1.name.value;
		UserDAOAjax.exitUser(name,show);
		}*/
		
	</script>
	</head>

<body onload="createCode()">	

<div class="mp-home-page-wrapper">
	<!-- 顶部导航栏 -->
	<div class="mynavbar-wrapper">
		<div class="mynavbar mynavbar-black">
			<div class="container cl">
				<span class="logos mynavbar-slogan " style="margin-left: 20px;"
					id="clock"></span> <a
					class="logos mynavbar-logos f-l mr-10 hidden-xs" href="<%=path %>/index.jsp">网上客运</a>
				<span class="logos mynavbar-slogan f-l mr-10 hidden-xs">安全&middot;快捷 &middot; 舒适</span>
				<nav class="mynav mynavbar-mynav mynav-collapse" role="mynavigation"id="Hui-mynavbar">

				<ul class="cl">
					<li ><a href="<%=path %>/index.jsp">首页</a></li>
					
					<li><a href="searchAll.action">车票查询</a></li>
					
					<li class="dropDown dropDown_hover">
						<a href="javascript:;">我的账户<i class="Hui-iconfont">&#xe6d5;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a onclick="showMyMsg('<s:property value="#session.userName"/>','个人信息','<%=path %>/user/userMsg.jsp','500','300')" href="javascript:;">我的信息</a></li>
							<li><a onclick="return isLogin('<s:property value="#session.userName"/>')" href="ordersManagerAction!queryUserOrdersListByUsersId">我的订单</a></li>
						</ul>	
					</li>
					
					<li class="dropDown dropDown_hover">
						<a href="#">关于我们<i class="Hui-iconfont">&#xe6d5;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a href="<%=path %>/html/chezhanjianjie.html" target="_blank">车站简介</a></li>
							<li><a href="<%=path %>/html/tuipiaogaiqian.html" target="_blank">退票改签须知</a></li>
							<li><a href="<%=path %>/html/privacy.html" target="_blank">隐私保护</a></li>
							<li><a href="<%=path %>/html/registerAgreement.html" target="_blank">用户注册协议</a></li>
						</ul>
					</li>
					
					<s:if test="#session.userName!=null">
						<li class="dropDown dropDown_hover" style=" float:right; ">
							<a href="javascript:;">欢迎您：<s:property value="#session.userName"/><i class="Hui-iconfont">&#xe6d5;</i></a>
								<ul class="dropDown-menu menu radius box-shadow">
									<li><a  href="logout.action">注销</a></li>
								</ul>
						</li>
					</s:if>
					<s:else>
						<li class="current" style=" float:right; "><a href="<%=path %>/register.jsp">注册</a></li>
						<li style=" float:right; "><a href="<%=path %>/login.jsp">登录</a></li>
					</s:else>
					
				</ul>

				</nav>
			</div>
		</div>
	</div>


	<div class="from-div">
		<div class="register-div">
			<p style="margin-left:60px;margin-top:50px;">填写账户信息，以下信息均为必填:</p>
				<form action="register.action" method="post" name="form1" onSubmit="return check();">
					<ul class="register-info">
						<li>
							<div class="reg-col-1 fl" style="margin:0 0 0 10%">姓名：</div>
							<div id="usernameDiv" class="reg-col-2 fl">	
								<input class="input-text valid " type="text" id="username" name="user.name"  autocomplete="off"
								style="height: 36px; width: 253px; size:20" onblur="checkUserName();">	
							</div>
							<span id="LoginSpan" class="error-con">* 姓名不能为空</span>	
						</li>
						<li>
							<div class="reg-col-1 fl" style="margin:0 0 0 10%">用户名：</div>
							<div id="nameDiv" class="reg-col-2 fl">	
								<input type="text" id="name" name="user.username"  autocomplete="off"
								style="height: 36px; width: 253px; size:20" onblur="validate();">	
							</div>
							<span id="Usernamespan" class="error-con">* 用户名不能为空</span>	
						</li>
						<li>
							<div class="reg-col-1 fl" style="margin:0 0 0 10%">手机：</div>
							<div id="PhoneNumDiv" class="reg-col-2 fl">
									<input type="text" id="PhoneNum" name="user.phone" autocomplete="off"
									style="height: 36px; width: 253px; size:20" onblur="checkPhone(); " >
							</div>
							<span id="PhoneNumError" class="error-con">* 手机号码不合法</span>
						</li>
				
						<li>
							<div class="reg-col-1 fl" style="margin:0 0 0 10%">登录密码：</div>
							<div id="passwordDiv" class="reg-col-2 fl">
									<input type="password" id="password" name="user.password" placeholder="6-20位字符,可由大小写英文,数字,字符组成"autocomplete="off"size="20" style="height: 36px; width: 253px;" onblur="checkPassword();">
							</div>
								<span name="PwdError" class="error-con">* 密码不合法</span>
						</li>
					
						<li>
							<div class="reg-col-1 fl" style="margin:0 0 0 10%">确认密码：</div>
							<div id="confirmPasswordDiv" class="reg-col-2 fl" >
									<input type="password" id="confirmPassword" name="confirmPassword" autocomplete="off"
									style="height: 36px; width: 253px;"  onblur="confirmPwd();">
							</div>
							<span  class="error-con">* 两次密码输入不一致</span>
						</li>
					
						<li>
							<div class="reg-col-1 fl" style="margin:0 0 0 10%">性别：</div>
								<div class="skin-minimal">
									  <div class="radio-box">
									    <input type="radio" id="radio-1" name="user.sex" value="男" checked="checked">
									    <label for="radio-1">男</label>
									  </div>
									  <div class="radio-box">
									    <input type="radio" id="radio-2" name="user.sex" value="女">
									    <label for="radio-2">女</label>
									  </div>
								</div>
							<span class="error-con">* 请选择性别</span>
						</li>
		
						<li>
							<div  class="reg-col-1 fl" style="margin:0 0 0 10%">身份证号:</div>
							<div id="idCardDiv" class="reg-col-2 fl"   >
								<input type="text" id="idCard" name="user.idCard" 
									style="height: 36px; width: 253px; size:20" onblur="checkIdCard()">	
							</div>
							<span name="idCardError" class="error-con">* 请输入身份证</span>
						</li>										
						<li>
							<div class="reg-col-1 fl" style="margin:0 0 0 10%">验证码：</div>
							
							<div  class="reg-col-2 fl">
								<input type="text" id="CodeNum" name="CodeNum" autocomplete="off" onblur="checkCodeNum();"
								style="height: 36px; width: 253px; size:20">			
							</div>
							
							<div id="CodeNumDiv" class="reg-col-2 fl">
								<input type="text" onclick="createCode()" readonly="readonly" id="checkCode" 
											class="unchanged" style='width: 78px; height: 36px;  color: #FF0000; border-color: #FFFFFF; 
											font-style: normal; font-size: 16px; font-family: "Trebuchet MS", Sans-Serif; font-weight: bold; 
											border-style: none'>
											<img src="<%=path %>/img/yanzm.png" onclick="createCode()" style="cursor:pointer;"/>
							</div>						
								<span name="CodeErrorSpan" class="error-con">* 验证码不正确</span>			
						</li>
					</ul>
				
		
				<div style="margin:2% 0 0 22%">
					<table>
						<tr>
							<td><input id="checkbox" type="checkbox" name="Agreement" value="Agreement"
								backgroundcolor="#FF8C00" onclick="isCheckbox()" /> <a alt="用户注册协议" href="./html/registerAgreement.html"><font face=" Microsoft YaHei"
								color="#FF8C00" size="3"> &nbsp;我已阅读并同意 《用户注册协议》 </font></a></td>
						</tr>
					</table>
				</div>
		
				<div style="margin:4% 0 0 28%;border-radius: 5px 5px 5px 5px;">		
					<input id="submitBtn"  class="btn btn-primary radius disabled" type="submit" value="注           册" style="height: 55px; width: 170px;"  >	
				</div>
		
				<div style="margin:2% 0 0 22%;border-radius: 5px 5px 5px 5px;">
					<font color="#C0C0C0" size="3"> <a href="javascript:;"> 你忘记密码了吗？</a> 
					<a href="<%=path %>/login.jsp">我已有账号，我要登录</a>
					</font>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="./html/foot.html" flush="true"/>
</div>	
</body>
</html>
