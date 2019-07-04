/**
 * 
 */
$(function(){
	$("#form-plane-add").validate({
		rules:{
			'bus.busesclass':{
				required:true,
				minlength:1,
				maxlength:20
			},
			'bus.drivername':{
				required:true,
			},
			'bus.driverphone':{
				required:true,
			},
			'bus.numbers':{
				required:true,
				digits:true
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			var options = {   
	            type: 'POST',  
	            url: 'saveNewCar.action',                 
	            dataType: 'json', 
	            success:function(data){
	            	alert(XMLHttpRequest.status);
					alert(XMLHttpRequest.readyState);
					alert(textStatus);    
	               	console.debug("data="+data);
	               	parent.layer.msg('保存失败，稍后再试试吧！', {icon:5,time:1000});
				},
				error:function(data,XMLHttpRequest, textStatus, errorThrown){
	               	console.debug("data="+data);
					parent.layer.msg('保存成功!', {icon:6,time:1000});	
					var index = parent.layer.getFrameIndex(window.name);
					parent.setTimeout('location.replace(location.href)',1500); //延迟刷新父窗口
					parent.layer.close(index);
	            }  
        	}; 			
        	$(form).ajaxSubmit(options);
		}
	});
});

/**
 * 判断可输入字数
 * @param which
 * @param max
 */
function checkLength(which, max) {
	var maxChars = max;
	if (which.value.length > maxChars)
		which.value = which.value.substring(0, maxChars);
	var curr = maxChars - which.value.length;
	document.getElementById("currentLength").innerHTML = curr.toString();
}


var isPhone=false;//全局变量 定义是否输入了手机号码

function checkPhone() //检验手机号码
{  
	var phonestr=$("#phoneInput");
    var bValidate = RegExp(/^(0|86|17951)?(13[0-9]|15[012356789]|18[0-9]|14[57])[0-9]{8}$/).test(phonestr.val());  
    
    if(phonestr.val()=='')
    	{
    		/*$("span[id='PhoneNumError']").text("* 请输入手机号码");
    		$("#PhoneNumDiv").next().css("display","block");*/
    		$.Huimodalalert('请输入手机号码',1000);
    		isPhone=false;
    	}
   else if(bValidate){
    	console.debug("bValidate="+bValidate);
    	console.debug("newPhone="+$("#phoneInput").val());
    	if($("#phoneInput").val()==phonestr.val()){
    		isPhone = true;
    	}else{
    	  	$.post(
        			"userAjaxAction!checkRepeat",
        			{'bus.driverphone':phonestr.val()},
        			
        			function(data){
    					console.debug("data="+data);
    			 		console.debug(data=="repeat");
    			 		if(data=="repeat"){
    			    		/*$("span[id='PhoneNumError']").html("* 很抱歉，该用户名已经被注册");
    			        	$("#PhoneNumDiv").next().css("display","block");*/
    			 			$.Huimodalalert('很抱歉，该手机号已被使用',1000);
    			    		isPhone=false;
    			    	}
    			    	else{
    			    		/*$("#PhoneNum").attr("class","input-text valid");
    			    		$("span[id='PhoneNumError']").html("* 恭喜您，该用户名没有被注册！");
    			        	$("#PhoneNumDiv").next().css("display","block");*/
    			    		$.Huimodalalert('恭喜您，该手机号可以使用',1000);
    			    		isPhone=true;
    			    	}
        	});
    	}
  
    }
    else if(!bValidate){
    	/*$("span[id='PhoneNumError']").text("* 手机号码不合法！！！");
		$("#PhoneNumDiv").next().css("display","block");*/
    	$.Huimodalalert('手机号码不合法',1000);
		isPhone=false;
    }
   /*
    if(!isPhone){
		$("#PhoneNum").attr("class","input-text valid error");
	}else{
		$("#PhoneNum").attr("class","input-text valid");
	}*/
    
    return isPhone;
}  
