<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.SimpleDateFormat" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>航班列表-君健航空</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<jsp:include page="../meta.jsp" flush="true"></jsp:include>
</head>

<body>
	<nav class="breadcrumb"> 
		<i class="Hui-iconfont">&#xe67f;</i> 
		首页
		<span class="c-gray en">&gt;</span> 
		订单管理
		<span class="c-gray en">&gt;</span>
		订单列表
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新"> 
			<i class="Hui-iconfont">&#xe68f;</i>
		</a> 
	</nav>
	
	<div class="page-container">
	
		<div class="mt-20">
			<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			
				<thead>
					<tr class="text-c">
						<th width="80">订单号</th>
						<th width="80">用户姓名</th>
						<th width="80">出发城市</th>
						<th width="80">目的城市</th>
						<th width="130">出发时间</th>
						<th width="50">大约用时</th>
						<th width="100">价格</th>
						<th width="130">订单时间</th>				
						<th width="80">状态</th>
					</tr>
				</thead>
				
				<tbody>
					<s:if test="#request['order']!=null">
						<s:iterator value="#request['order']" var="orderInfo" status="st">
							<tr class="text-c">
								<td><s:property value="#orderInfo.orderId"/></td>
								
								<td><s:property value="#orderInfo.userId" /></td>
								
								<td><s:property value="#businformation.fromCity" />  <s:property value="#businformation.fromTerminal" /></td>
								
								<td><s:property value="#businformation.toCity" />  <s:property value="#businformation.toTerminal" /></td>
								
								<td><s:date name="#businformation.startDate" format="yyyy-MM-dd" />  <s:property value="#businformation.startTime" /></td>
								
								<td><s:property value="#businformation.spendTime"/></td>
								
								<td><s:property value="#orderInfo.ordersTime"/></td>
								
								<td><s:property value="#orderInfo.state"/></td>									
							</tr>
						</s:iterator>
					</s:if> <!-- End 判断列表是否为空 -->
					<s:else>
					没有数据
					</s:else>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="../footer.jsp" flush="true" />
	<script type="text/javascript" src="<%=path%>/admin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="<%=path%>/admin/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="<%=path %>/admin/jsp/manager_orders/js/orders.js"></script>
</body>
</html>
