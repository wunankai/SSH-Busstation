<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'plane_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<jsp:include page="../meta.jsp" flush="true"></jsp:include>
  </head>
  
 <body>
<article class="page-container">
	<form action="" onsubmit="" method="post" class="form form-horizontal" id="form-flight-add">
	
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>班次编号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text"  id="banciId" name="businformation.banciId" class="input-text size-L radius">
				<i class="Hui-iconfont " id="rightIcon" style="color:green;position: absolute;font-size:15px;display:none;right: 20px;bottom: 5px;z-index: 1;margin-bottom: 0;">&#xe6e1;</i>
				<i class="Hui-iconfont " id="repeatIcon" style="color:red;font-size:15px;display:none;position: absolute;right: 20px;bottom: 5px;z-index: 1;margin-bottom: 0;">&#xe6dd;</i>
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>出发日期：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input id="StartDate" name="startDateString" type="text"   class="input-text size-L radius Wdate">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>出发时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input id="startTime" name="startTimeString" type="text"  class="input-text size-L radius">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>出发城市：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text"  id="flightFromCity" name="businformation.fromcity" class="input-text size-L radius">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>到达城市：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text"  id="toCity" name="businformation.tocity" class="input-text size-L radius">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>始发站：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text"  id="flightFromTerminal" name="businformation.fromTerminal" class="input-text size-L radius">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>终点站：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text"  id="flightToTerminal" name="businformation.toTerminal" class="input-text size-L radius">			
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>车辆类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text"  id="Busclass" name="businformation.busclass" class="input-text size-L radius">			
			</div>
		</div>			
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>大约用时：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text"  id="SpendTime" name="businformation.spendTime" class="input-text size-L radius">			
			</div>
		</div>	
				
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>价格：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input id="Price" name="businformation.price" type="text" value="0" class="input-text size-L radius">
					</div>
				</div>
						
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>剩余票数<br>(最多可设置&nbsp;&nbsp;45&nbsp;&nbsp;张)：</label>
					<div class="formControls col-xs-8 col-sm-9">  
						<input type="text"  id="Remain" name="businformation.remain" class="input-text size-L radius">
					</div>
				</div>
				
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>

<jsp:include page="../footer.jsp" flush="true" />

<!--请在下方写此页面业务相关的脚本--> 
<script type="text/javascript" src="<%=path %>/admin/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=path %>/admin/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="<%=path %>/admin/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="<%=path %>/admin/lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript" src="<%=path %>/js/laydate/laydate.js"></script>
<script type="text/javascript" src="<%=path %>/admin/jsp/manager_flight/js/flight_add.js"></script>

</body>
</html>
