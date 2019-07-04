/**
 * 
 */
/**
 * 
 */
$(function(){
	$("#form-flight-add").validate({
		rules:{
			'businformation.banciId':{
				required:true,
				minlength:2,
				maxlength:15
			},
			'businformation.startDate':{
				required:true,
				dateISO:true
			},
			'businformation.startTime':{
				required:true,
			},
			'businformation.fromCity':{
				required:true,
				minlength:2
			},
			'businformation.toCity':{
				required:true,
				minlength:2
			},
			'businformation.fromTerminal':{
				required:true,
				minlength:2
			},
			'businformation.toTerminal':{
				required:true,
				minlength:2
			},
			'businformation.spendTime':{
				required:true,
			},
			'businformation.remain':{
				required:true,
				digits:true
			},
			'businformation.price':{
				required:true,
				number:true
			},
			
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			var options = {   
	            type: 'POST',  
	            url: 'saveNewBusinfo.action',                 
	            dataType: 'json', 
	            success:function(data){
	            	console.debug("data="+data);
	               	parent.layer.msg('保存失败!', {icon:5,time:1000});	
					//parent.setTimeout('location.replace(location.href)',1500);
				},
	            error : function(data) {              
	            	console.debug("data="+data);
					parent.layer.msg('保存成功!', {icon:6,time:1000});
					var index = parent.layer.getFrameIndex(window.name);
					parent.setTimeout('location.replace(location.href)',1500);
					parent.layer.close(index);	
	               	//parent.setTimeout('location.replace(location.href)',1500);
	            }  
        	};   
        	$(form).ajaxSubmit(options);
        	//console.debug("suceed="+succeed);
			//parent.layer.close(index);			
		}
	});
});

/*function submitNewFlight(){
	$.ajax({
		type:"POST",
		url: 'adminAjaxAction!saveNewFlight',                 
        dataType: 'json', 
        success:function(data){
			console.debug("data="+data);
			console.debug("data=123456789");
			parent.layer.msg('保存成功!', {icon:6,time:1000});			
			parent.setTimeout('location.replace(location.href)',1500);
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);	
		},
        error : function(data) {              
           	console.debug("data="+data);
           	parent.layer.msg('保存失败!', {icon:5,time:1000});	
           //	parent.setTimeout('location.replace(location.href)',1500);
           	//var index = parent.layer.getFrameIndex(window.name);
           //	parent.layer.close(index);	
        }  
	});
}*/

/*function checkFlightNameRepeat(){
	if($("#flightName").val()==''){
		layer.msg('航班编号不可为空', {icon : 0,time : 1000});
	}else{
		$.ajax({
			type : 'POST',
			url : "adminAjaxAction!checkFlightNameRepeat",
			data : {'flightName' : $("#flightName").val()},
			success : function(data) {
				console.debug("data=" + data);
				if(data=='noRepeat'){
					//layer.msg('客机编号可以使用', {icon : 1,time : 1000});
					$("#rightIcon").show();
					$("#repeatIcon").hide();
					return true;
				}else{
					layer.msg('航班编号已被占用，请重新输入!', {icon : 0,time : 1000});
					 $("#flightName").focus();
					 $("#repeatIcon").show();
					 $("#rightIcon").hide();
					return false;
				}
				
			},
			error : function(data) {
				console.debug(data);
				layer.msg('系统出错了，稍后再试试吧!', {icon : 5,time : 1000});
				return false;
			},
		});
	}
	
}

function focusOnFlightNameInput(){
	$("#rightIcon").hide();
	$("#repeatIcon").hide();
}
*/