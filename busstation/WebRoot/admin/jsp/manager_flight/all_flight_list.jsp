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
		班次管理
		<span class="c-gray en">&gt;</span>
		班次列表
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新"> 
			<i class="Hui-iconfont">&#xe68f;</i>
		</a> 
	</nav>
	
	<div class="page-container">
	
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l">
				<a href="javascript:;"onclick="flight_add('添加班次','<%=path %>/admin/jsp/manager_flight/flight_add.jsp','1000','')"class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>添加班次</a>
			</span> 
		</div>
	
		<div class="mt-20">
			<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			
				<thead>
					<tr class="text-c">
						<th width="80">班次编号</th>
						<th width="130">出发时间</th>
						<th width="130">出发城市-到达城市</th>
						<th width="130">始发站-终点站</th>
						<th width="80">车辆类型</th>
						<th width="80">大约用时</th>					
						<th width="80">价格</th>
						<th width="80">剩余票数</th>
						<th width="100">操作</th>
					</tr>
				</thead>
				
				<tbody>
					<s:if test="#request['buses']!=null">
						<s:iterator value="#request['buses']" var="bus" status="st">
							<tr class="text-c">
								<td>
								<span id="businessClassRemain"><s:property value="#bus.banciId"/></span>
								<input id="businessClassRemainInput" type="text"  style="width:120px;display:none" class="input-text size-L radius">
								</td>
								
								<td>
								<span id="St"> <s:date name="#bus.startDate" format="yyyy-MM-dd" /></span>
								<input id="StInput" type="text"  style="width:120px;display:none" class="input-text size-L radius">
								<span id="firstClassPrice"> <s:property value="#bus.startTime"/></span>
								<input id="firstClassPriceInput"  type="text" style="width:120px;display:none" class="input-text size-L radius">
								</td>
								
								<td><s:property value="#bus.fromcity"/>-<s:property value="#bus.tocity"/></td>
								
								<td><span id="firstClassRemain"><s:property value="#bus.fromTerminal"/></span>
								<input id="firstClassRemainInput" type="text"  style="width:120px;display:none" class="input-text size-L radius">
								-<span id="businessClassPrice"><s:property value="#bus.toTerminal"/></span>
								<input id="businessClassPriceInput" type="text" style="width:120px;display:none" class="input-text size-L radius">
								</td>
								
								
								<td><span id="touristClassPrice"><s:property value="#bus.spendTime"/></span>
								<input id="touristClassPriceInput" type="text" style="width:120px;display:none" class="input-text size-L radius">
								</td>
								
								<td><s:property value="#bus.busclass"/></td>
								
								<td>￥<span id="touristClassRemain"><s:property value="#bus.price"/></span>
								<input id="touristClassRemainInput" type="text" style="width:120px;display:none" class="input-text size-L radius">
								</td>
								
								<td>
									<span id="Remain"><s:property value="#bus.remain"/></span>
									<input id="RemainInput" type="text" max='<s:property value="#bus.remain"/>' style="width:120px;display:none" class="input-text size-L radius">
								</td>
								
									<td class="f-14 td-manage">
										<a style="text-decoration:none" id="edit" onclick="changeFlight(this);" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
										
										<a style="text-decoration:none;display:none;" id="cancelEdit" onclick="cancelEdit(this);" href="javascript:;" title="取消编辑"><i class="Hui-iconfont">&#xe706;</i></a>  
										
										<a style="text-decoration:none;display:none;" id="submitt" onclick="submitFlight(this,'<s:property value="#bus.bsid"/>');" href="javascript:;" title="提交"><i class="Hui-iconfont">&#xe632;</i></a>  
										
										<a style="text-decoration:none" class="ml-5" id="cancelFlight" onClick="flight_cancel(this,'<s:property value="#bus.bsid"/>')" href="javascript:;" title="取消班次"><i class="Hui-iconfont">&#xe6de;</i></a>
										
										<a style="text-decoration:none" class="ml-5" id="cancelFlight" onClick="layer_show('删除班次','deleBusinfo.action?bsid=<s:property value="#bus.bsid"/>','1000','600')"><i class="Hui-iconfont">&#xe6e2;</i></a>
										<a style="text-decoration:none;display:none;" id="fly" onclick="flight_readyFly(this,'<s:property value="#bus.bsid"/>')" href="javascript:;" title="重新发布"><i class="Hui-iconfont">&#xe642;</i></a>
									</td>
								</tr>		
				</s:iterator>
				</s:if>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="../footer.jsp" flush="true" />

	<script type="text/javascript" src="<%=path%>/admin/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=path%>/admin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="<%=path%>/admin/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="<%=path %>/admin/jsp/manager_flight/js/flight.js"></script>
</body>
</html>
