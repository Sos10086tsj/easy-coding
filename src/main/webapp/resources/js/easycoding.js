var easycoding = {
	validate : {
		defaultValidation : function(form){
			form.validator({
				onValid: function(validity) {
					$(validity.field).closest('.am-form-group').find('.am-alert').hide();
				},
				onInValid: function(validity) {
					var $field = $(validity.field);
				    var $group = $field.closest('.am-form-group');
				    var $alert = $group.find('.am-alert');
				    // 使用自定义的提示信息 或 插件内置的提示信息
				    var msg = $field.data('validationMessage') || this.getValidationMessage(validity);
				    if (!$alert.length) {
				      $alert = $('<div class="am-alert am-alert-danger"></div>').hide().appendTo($group);
				    }
				    $alert.html(msg).show();
				}
			});
		}
	}
}
$(function () {
	$.ajaxSetup({
        complete: function (response, textStatus) {
            var c = parseInt(response.status);
            if (c == 401) {
                // TODO
                top.location.href = ctx;
                return false;
            }
        }
    });
	
	Date.prototype.format = function (format) {
        /*
         * eg:format="yyyy-MM-dd hh:mm:ss";
         */
        var o = {
            "M+": this.getMonth() + 1, // month
            "d+": this.getDate(), // day
            "h+": this.getHours(), // hour
            "m+": this.getMinutes(), // minute
            "s+": this.getSeconds(), // second
            "q+": Math.floor((this.getMonth() + 3) / 3), // quarter
            "S": this.getMilliseconds()
            // millisecond
        }

        if (/(y+)/.test(format)) {
            format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4
                - RegExp.$1.length));
        }

        for (var k in o) {
            if (new RegExp("(" + k + ")").test(format)) {
                format = format.replace(RegExp.$1, RegExp.$1.length == 1
                    ? o[k]
                    : ("00" + o[k]).substr(("" + o[k]).length));
            }
        }
        return format;
    }
})