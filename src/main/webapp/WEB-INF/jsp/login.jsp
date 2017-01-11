<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/jsp/base/baselib.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Easy Coding Login Page">
<meta name="keywords" content="easycoding login">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!-- <link rel="icon" type="image/png" href="assets/i/favicon.png"> 浏览器图标-->

<link rel="stylesheet" href="${ctx }/resources/component/AmazeUI-2.7.2/css/amazeui.min.css?${version}" />
<link rel="stylesheet" href="${ctx }/resources/component/AmazeUI-2.7.2/css/amazeui.datatables.min.css?${version}" />
<link rel="stylesheet" href="${ctx }/resources/css/login.css?${version}" />
<title>Easy Coding</title>
</head>
<body class="theme-white">

	<div class="am-g tpl-g">
		<div class="tpl-login">
			<div class="tpl-login-content">
				<div class="tpl-login-logo"></div>
				<c:if test="${not empty  errorMessage}">
					<div class="error_message">${errorMessage }</div>
				</c:if>
				<div>
					<form class="am-form tpl-form-line-form" id="login_form" action="${ctx }/login" method="post">
						<div class="am-form-group">
							<input type="text" class="tpl-form-input" name="username" placeholder="请输入账号" required>
						</div>
						<div class="am-form-group">
							<input type="password" class="tpl-form-input" name="password" placeholder="请输入密码" required>
						</div>
<!-- 						<div class="am-form-group tpl-login-remember-me"> -->
<!-- 							<input id="remember-me" type="checkbox"> -->
<!-- 							<label for="remember-me">记住密码</label> -->
<!-- 						</div> -->
						<div class="am-form-group">
							<button type="submit" class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn">提交</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	
</body>
<script src="${ctx }/resources/component/jQuery/jquery.min.js?${version}"></script>
<script src="${ctx }/resources/component/AmazeUI-2.7.2/js/amazeui.min.js?${version}"></script>
<script>
	if (window != top){
		top.location.href = '${ctx}/login';
	}
</script>
<script src="${ctx }/resources/js/login.js?${version}"></script>
</html>
