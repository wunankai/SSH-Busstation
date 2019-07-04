<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="org.easybooks.bookstore.vo.Businformation" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>车票查询-网上客运</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/H-ui/static/h-ui/css/H-ui.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/H-ui/lib/Hui-iconfont/1.0.8/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/user/booking/css/booking.css" />
	<link rel="stylesheet" href="<%=path %>/css/head.css" type="text/css">
	
	
	<script type="text/javascript" src="<%=path %>/H-ui/lib/jquery/1.9.1/jquery.js"></script>
	<script type="text/javascript" src="<%=path %>/js/clock.js"></script>
	
	<script type="text/javascript" src="<%=path %>/H-ui/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
	<script type="text/javascript" src="<%=path %>/H-ui/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="<%=path %>/H-ui/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/H-ui/static/h-ui/js/H-ui.js"></script> 
	<script type="text/javascript" src="<%=path %>/user/booking/js/booking.js"></script>
	<script type="text/javascript" src="<%=path %>/js/index.js"></script>
	<script type="text/javascript" src="<%=path %>/js/judgeLogin.js"></script>

  </head>  	
  	<body>
  	<!-- 顶部导航栏 -->
	<div class="mynavbar-wrapper">
		<div class="mynavbar mynavbar-black">
			<div class="container cl">
				<span class="logos mynavbar-slogan " style="margin-left: 20px;" id="clock"></span> 
				<a class="logos mynavbar-logos f-l mr-10 hidden-xs" href="./index.jsp">网上客运</a>
				<span class="logos mynavbar-slogan f-l mr-10 hidden-xs">安全&middot;快捷 &middot; 舒适</span>
				<nav class="mynav mynavbar-mynav mynav-collapse" role="mynavigation"id="Hui-mynavbar">

				<ul class="cl">
					<li ><a href="<%=path %>/index.jsp">首页</a></li>
					<li class="current"><a href="searchAll.action">车票查询</a></li>
					
					<li class="dropDown dropDown_hover">
						<a href="javascript:;">我的账户<i class="Hui-iconfont">&#xe6d5;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a onclick="showMyMsg('<s:property value="#session.user.username"/>','个人信息','<%=path %>/user/userMsg.jsp','500','400')" href="javascript:;">我的信息</a></li>
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
					<li class="dropDown dropDown_hover">
						<a href="http://www.zuoche.com/">查询路线</a>
					</li>
					<s:if test="#session.user!=null">
						<li class="dropDown dropDown_hover" style=" float:right; ">
							<a href="javascript:;">欢迎您：<s:property value="user.username"/><i class="Hui-iconfont">&#xe6d5;</i></a>
								<ul class="dropDown-menu menu radius box-shadow">
									<li><a  href="logout.action">注销</a></li>
								</ul>
						</li>
					</s:if>
					<s:else>
						<li style=" float:right; "><a href="<%=path %>/register.jsp">注册</a></li>
						<li style=" float:right; "><a href="<%=path %>/login.jsp">登录</a></li>
					</s:else>
				</ul>

				</nav>
			</div>
		</div>
	</div>

	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 
		<a class="maincolor" href="<%=path %>/index.jsp">首页</a>
		<span class="c-666 en">&gt;</span>
		车票查询
	</nav>

	<!-- 班次列表 -->
	<div class="mt-20" style="margin-left: 20px;margin-right: 20px;">
		<div id="DataTables_Table_0_wrapper" class="dataTables_wrapper no-footer">	
			<table class="table table-border table-bordered table-hover table-bg table-sort dataTable no-footer" id="DataTables_Table_0" role="grid" aria-describedby="DataTables_Table_0_info">
				<thead>
					<tr class="text-c" role="row">
						<th class="sorting" tabindex="0"
							aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
							style="width: 100.2px;" aria-label="班次号: 升序排列" width="100">班次号</th>
						<th class="sorting" tabindex="0"
							aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
							style="width: 130.2px;" aria-label="出发时间: 升序排列" width="130">出发时间</th>
						<th class="sorting" tabindex="0"
							aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
							style="width: 130.2px;" aria-label="始发站: 升序排列" width="130">始发站-终点站</th>
						<th class="sorting" tabindex="0"
							aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
							style="width: 100.2px;" aria-label="大约用时: 升序排列" width="100">大约用时</th>
						<th class="sorting" tabindex="0"
							aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
							style="width: 100.2px;" aria-label="车辆类型: 升序排列" width="100">车辆类型</th>
						<th class="sorting" tabindex="0"
							aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
							style="width: 100.2px;" aria-label="价格: 升序排列" width="100">价格</th>
						<th class="sorting" tabindex="0"
							aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
							style="width: 100.2px;" aria-label="剩余票数: 升序排列" width="100">剩余票数</th>	
						<th class="sorting_disabled" rowspan="1" colspan="1"
							style="width: 100.2px;" aria-label="操作" width="100">操作</th>
					</tr>
				</thead>
				<tbody>		
		  				
			  				 		
		  			<s:iterator value="#request['buses']" var="bus" status="st" >
		  				<s:if test="#bus.remain=='45'">
			  				<tr id="tr#bus.banciId" class="text-c odd" role="row">						
				  				<td><s:property value="#bus.banciId"/></td>
								<td><s:date name="#bus.startDate" format="yyyy-MM-dd" /> <s:date name="#bus.startTime" format="HH:MM"/></td>
								<td><s:property value="#bus.fromTerminal"/>-<s:property value="#bus.toTerminal"/></td>
								<td><s:property value="#bus.spendTime"/></td>
								<td><s:property value="#bus.busclass"/></td>
								<td>￥<s:property value="#bus.price"/></td>
								<td><s:property value="#bus.remain"/></td>
								<td class="td-manage"> 
									<a title="购买" href="javascript:;" onclick="booking_show('<s:property value="#session.user.username"/>','订购机票','Getinfo.action?id=<s:property value="#bus.bsid"/>','1000','600')" class="ml-5" style="text-decoration:none">
										<i class="Hui-iconfont">&#xe670;</i>
									</a>
								</td>
							</tr>
						</s:if>
					</s:iterator>	
					
				</tbody>	
			</table>
		</div>
	</div>
	
	
</body>	
<script type=text/javascript>
	var clock = new Clock();
	clock.display(document.getElementById("clock"));
</script>
</html>
