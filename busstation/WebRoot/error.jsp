<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>      

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'menu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
<style type="text/css">
t.pos_abs
{
position:absolute;
left:200px;
top:200px
}
t1.pos_abs
{
position:absolute;
left:500px;
top:200px
}
</style>
  
  <body>

   				
   				<t class="pos_abs"><img src="<%=path %>/img/weixin.png" onclick="" style="cursor:pointer;"/></t>
   				<t1 class="pos_abs"><img src="<%=path %>/img/zhifubao.png" onclick="" style="cursor:pointer;"/></t1>
   				  <h3><s:property value="#session.username"/>请您选择支付方式！</h3>
   				  <s:property value="#request.order.orderid"/>
   				  <a href="logout.action">退出登录</a>
 
  </body>
</html>
