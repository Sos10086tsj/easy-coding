var register = {
	//初始化表单验证
	initValidation : function(){
		$('#register_form').validator({
			onValid: function(validity) {
				$(validity.field).closest('.am-form-group').find('.am-alert').hide();
			},
			onInValid: function(validity) {
				var $field = $(validity.field);
				var $group = $field.closest('.am-form-group');
				var $alert = $group.find('.am-alert');
				// 使用自定义的提示信息 或 插件内置的提示信息
				var msg = '';
				
				//用户名
				if(register.isUsernameAjaxValidate(validity)){
					if(register.isUsernameLegal()){
						msg = '邮箱已经被注册';
					}else{
						msg = '请输入正确的邮箱地址';
					}
				}else{
					msg = $field.data('validationMessage') || this.getValidationMessage(validity);
				}
				
				if($(validity.field).is('.ajax_verify_code')  && $('#verifyCode').val().length == 4){
					msg = '验证码错误';
				}
					
				if (!$alert.length) {
				  $alert = $('<div class="am-alert am-alert-danger"></div>').hide().appendTo($group);
				}
				$alert.html(msg).show();
		   },
		   validate : function(validity){
			   //用户名唯一性验证
			   if (register.isUsernameAjaxValidate(validity)) {
				   if(register.isUsernameLegal()){
					   $.ajax({
						   url : ctx + '/register/exist',
						   data : {username : $('#username').val()},
						   async : false,
						   success : function(responseText){
							   if($.parseJSON(responseText).success){
								   validity.valid = true;
							   }else{
								   validity.valid = false;
							   }
						   }
					   });
				   }else{
					   validity.valid = false;
				   }
				   return validity;
			   };
			   //验证码校验
			   if($(validity.field).is('.ajax_verify_code') && $('#verifyCode').val().length == 4){
				   $.ajax({
					   url : ctx + '/captcha/validate',
					   data : {code : $('#verifyCode').val()},
					   async : false,
					   success : function(responseText){
						   if($.parseJSON(responseText).success){
							   validity.valid = true;
						   }else{
							   validity.valid = false;
						   }
					   }
				   })
				   return validity;
			   }
		   }
		});
	},
	
	isUsernameAjaxValidate : function(validity){
		if($(validity.field).is('.ajax_username') && $('#username').val().length > 0){
			return true;
		}
		return false;
	},
	
	isUsernameLegal : function(){
		var val = $('#username').val();
		var pattern = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
		var reg = new RegExp(pattern);
		if(reg.test(val)){
			return true;
		}else{
			return false;
		}
	},
	
	rememberMeClick : function(){
		var checked = $(this).prop('checked');
		if(checked){
			$('#register_btn').removeAttr('disabled')
		}else{
			$('#register_btn').attr('disabled','disabled');
			$('#remember-me_div').removeClass('am-form-success');
			$(this).removeClass('am-field-valid');
		}
	}
}
$(function () {
	register.initValidation();
	$('#remember-me').click(register.rememberMeClick);
})