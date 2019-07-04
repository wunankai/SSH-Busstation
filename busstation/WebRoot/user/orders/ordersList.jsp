<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单列表-网上客运</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/H-ui/static/h-ui/css/H-ui.css" />
	<link rel="stylesheet" href="<%=path %>/css/head.css" type="text/css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/H-ui/lib/Hui-iconfont/1.0.8/iconfont.css" />
    
	<script type="text/javascript" src="<%=path %>/H-ui/lib/jquery/1.9.1/jquery.js"></script>
	<script type="text/javascript" src="<%=path %>/js/clock.js"></script>
	
	<script type="text/javascript" src="<%=path %>/H-ui/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
	<script type="text/javascript" src="<%=path %>/H-ui/lib/laypage/1.2/laypage.js"></script>
	
	<script type="text/javascript" src="<%=path %>/H-ui/static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript" src="<%=path %>/H-ui/lib/layer/2.4/layer.js"></script> 
	<script type="text/javascript" src="<%=path %>/user/orders/js/orders.js"></script>
	<script type="text/javascript" src="<%=path %>/js/judgeLogin.js"></script>
	<script type="text/javascript" src="<%=path %>/js/index.js"></script>

  </head>
  
  <body>
  <style type="text/css">
h2.pos_abs
{
position:absolute;
left:1000px;
top:500px
}
</style>
</head>

<body>
<h2 class="pos_abs">消费金额:<s:property value="#session.cart.totalPrice"/>元&nbsp;&nbsp;&nbsp;<a href="saving.action">购买</a></h2>
</body>
 <script type="text/javascript">
function chcolor(){
document.getElementById("t").style.color="red";
}
</script> 
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
					<li ><a href="searchAll.action">车票查询</a></li>
					<li class="current dropDown dropDown_hover">
						<a href="javascript:;">我的账户<i class="Hui-iconfont">&#xe6d5;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a onclick="showMyMsg('<s:property value="#session.userName"/>','个人信息','<%=path %>/user/userMsg.jsp','500','400')" href="javascript:;">我的信息</a></li>
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
					<s:if test="#session.user.username!=null">
						<li class="dropDown dropDown_hover" style=" float:right; ">
							<a href="javascript:;">欢迎您：<s:property value="#session.user.username"/><i class="Hui-iconfont">&#xe6d5;</i></a>
								<ul class="dropDown-menu menu radius box-shadow">
									<li><a href="logout.action">退出</a></li>
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
		<a class="maincolor" href="javascript:;">我的账户</a>
		<span class="c-666 en">&gt;</span>
		我的订单
	</nav>
  
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
							style="width: 100.2px;" aria-label="出发城市: 升序排列" width="100">出发地</th>
						<th class="sorting" tabindex="0"
							aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
							style="width: 100.2px;" aria-label="目的城市: 升序排列" width="100">目的地</th>
						<th class="sorting" tabindex="0"
							aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
							style="width: 130.2px;" aria-label="出发时间: 升序排列" width="130">出发时间</th>
						<th class="sorting" tabindex="0"
							aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
							style="width: 130.2px;" aria-label="大约用时: 升序排列" width="130">大约用时</th>	
						<th class="sorting" tabindex="0"
							aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
							style="width: 130.2px;" aria-label="订单时间: 升序排列" width="130">订单时间</th>
						<th class="sorting" tabindex="0"
							aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
							style="width: 100.2px;" aria-label="总费用: 升序排列" width="100">总费用</th>	
						<th class="sorting_disabled" tabindex="0" rowspan="1" colspan="1"
							style="width: 60.2px;" aria-label="状态: 升序排列" width="60">状态</th>			
						<th class="sorting_disabled" rowspan="1" colspan="1"
							style="width: 100.2px;" aria-label="操作" width="100">操作</th>
					</tr>
				</thead>
				<tbody>
				
					<s:set var="items" value="#session.cart.items"/>
   				  <s:if test="#items.size!=0">	
   				  <s:iterator value="#items">
		  				<tr id="trvalue.businformation.banciId" class="text-c odd" role="row">
			  				<td>
			  					<u style="cursor:pointer" class="text-primary" onclick="orders_show('订单详细信息','<%=path %>/user/orders/ordersMsg.jsp?myOrderIndex=<s:property value="#st.index"/>','1000','600')">
			  						<s:property value="value.businformation.banciId"/>
			  					</u>
			  				</td>			 <!-- 航班号 -->			
							<td><s:property value="value.businformation.fromcity"/>-<s:property value="value.businformation.fromTerminal"/></td>				 <!-- 出发城市 -->	
							<td><s:property value="value.businformation.tocity"/>-<s:property value="value.businformation.toTerminal"/></td>				     <!-- 目的城市 -->	
							<td><s:date name="value.businformation.startDate" format="yyyy-MM-dd" />  <s:property value="value.businformation.startTime"/></td>  <!-- 出发时间 -->	
							<td><s:property value="value.businformation.spendTime"/></td>	
							<td><s:property value="#session.cart.orderdate"/></td>   		 <!-- 订单时间 -->	
							<td>￥<s:property value="#session.cart.totalPrice"/></td>			 <!-- 总费用 -->	
							<td><s:property value="order.state"/></td>		 		 <!-- 状态 -->	
							<td class="td-manage"> 											
								<a href="updateCart.action">更新</a>
							</td>
					</tr>	
					</s:iterator>
					</s:if>
					<s:else>
					对不起，您还没有购票
					</s:else>
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
