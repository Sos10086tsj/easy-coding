<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/jsp/base/baselib.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Easy Coding</title>
<body>


<div class="am-modal am-modal-alert" tabindex="-1" id="session_overdue_alert">
  <div class="am-modal-dialog">
    <div class="am-modal-bd">
      	登陆超时
    </div>
  </div>
</div>

</body>
<script src="${ctx }/resources/component/jQuery/jquery.min.js"></script>
<script src="${ctx }/resources/component/AmazeUI-2.7.2/js/amazeui.min.js"></script>
<script>
	$('#session_overdue_alert').modal({
		dimmer : false
	});
	setTimeout(function() {
		top.location.href = '${ctx}/login';
	}, 2000);
</script>
</html>
