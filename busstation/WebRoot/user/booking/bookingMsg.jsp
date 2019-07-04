<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<%@page import="org.easybooks.bookstore.vo.Businformation" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<style type="text/css">
p.thick {font-weight: bold}
.oblique{
font-style: oblique;
}
</style>
<title>填写信息-君健航空</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"  href="<%=path%>/user/booking/css/booking.css" type="text/css">
<link href="<%=path%>/H-ui/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />


<script type="text/javascript" src="<%=path%>/H-ui/lib/jquery/1.9.1/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery.SuperSlide.2.1.2.source.js"></script>
<script type="text/javascript" src="<%=path %>/js/from_to/fixdiv.js"></script>
<script type="text/javascript" src="<%=path %>/js/from_to/address.js"></script>
<script type="text/javascript" src="<%=path %>/H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=path%>/H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=path%>/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/InputSpinner.js"></script>
<script type="text/javascript" src="<%=path%>/user/booking/js/bookingMsg.js"></script>

<style type="text/css">

.btn-secondary:hover {
    color: #fff;
    background-color: #2f7fbb;
    border-color: #f2eaa1;
}
</style>

</head>

<%-- <!--   <% -->
<!--    		 int findex = Integer.valueOf(request.getParameter("index")) ; -->
<!-- 	%> --> --%>

<body>
<div id="wrapper">
	<div id="left-side">
		 <ul id="left-side-ul">
			<s:iterator value="#request['getinfo']" var="info">
			<s:if test="#request.getinfo!=null">
					<form action="addToCart.action" method="post" onsubmit="return isZero();">
 						<input type="hidden" name="bsid" value="<s:property value="#info.bsid" />">
 						<input type="hidden" id="firstClassP" value="<s:property value="#info.price" />">
 						<input type="hidden" id="firstClassR" value="<s:property value="#info.remain" />">
 						<li><div id="num">预定数量:</div>
 							<div>
								<input id="firstClassNum" name="quantity" type="number" value="0" min="0" max="<s:property value='#info.remain' />" step="1">
							</div>
						</li>
 						<li>	
 							<input type="submit" value="提交订单" style="width:200px;margin-left: 52px;" class=" btn btn-secondary radius size-L" > 
 						</li> 
					</form>
			</s:if>
			</s:iterator>
		</ul> 

	</div>

	<!-- 中间顺序条 -->
	<div id="border"></div>
	<div id="right-side">		
	 	<table id="right-side-table">
			<s:if test="#request.getinfo!=null">
				<div id="right-title">尊敬的<s:property value="#session.user.username" />您正在订购的是：</div>
					<thead>
						<tr>
							<th id="flight-name" rowspan="1" colspan="5" >
								<i  class="Hui-iconfont" style="color: #fe4a4a;">&#xe603;</i>
								-------------班次-------------
							</th>
						</tr>
						</thead>
					<tbody>
						<s:iterator value="#request['getinfo']" var="info">
						<tr>
							<td rowspan="1" colspan="3"><s:property value="#info.fromTerminal" /> 
						<i  class="Hui-iconfont" style="color: #fe4a4a;">&#xe67a;</i>
							<s:property value="#info.toTerminal" /></td>
						</tr>
						<tr>
							<td rowspan="1" colspan="3"><font color="red"><s:date name="#info.startDate" format="YYY-MM-dd" /></font>当天<font color="red"><s:property value="#info.startTime" /></font>发车</td>
						</tr>
						<tr>
							<td rowspan="1" colspan="2"><i  class="Hui-iconfont" style="color: #fe4a4a;">&#xe690;</i><s:property value="#info.spendTime"/>
							<font size="3" color="green">&nbsp;&nbsp;&nbsp;车辆类型：</font><s:property value="#info.busclass" /></td>
						</tr>
						<div id="border1"></div>
						<tr><td><a href="javascript:;" target="_blank">乘车、退票说明</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						票价：<font color="red">￥<s:property value="#info.price" /></font></td>
						</tr>
					   <div id="border2"></div>
						<td>联系电话：&nbsp;&nbsp;&nbsp;<s:property value="#session.user.phone" /></td>
 						<tr><td><a href="javascript:;" target="_blank">已阅读并同意《购票协议》和《投保须知》</a></td></tr>
					</s:iterator>
					</tbody>
			</s:if>
		</table> 
		<div id="total">
			<ul>
				<li>
					<div>已选数量：<span id="totalNum">0</span></div>
				</li>
				<li>
					<div>总计：￥<span id="moneyNum">0</span></div>
				</li>
			</ul>
		</div>
	</div>
</div>
</body>

<script type="text/javascript">
	function isZero() {
		if ($("#totalNum").text() == "0") {
			$.Huimodalalert("预订张数不能为0", 45);
			return false;
		} else {
			return true;
		}
	}
</script>
</html>
