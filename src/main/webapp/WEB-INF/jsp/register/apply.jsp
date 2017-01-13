<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/jsp/base/baselib.jspf"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Easy Coding Login Page">
<meta name="keywords" content="easycoding login">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="stylesheet"
	href="${ctx }/resources/component/AmazeUI-2.7.2/css/amazeui.min.css?${version}" />
<link rel="stylesheet"
	href="${ctx }/resources/component/AmazeUI-2.7.2/css/amazeui.datatables.min.css?${version}" />
<title>Easy Coding</title>
</head>
<body>
	<c:if test="${exist == 1}">
	<div class="am-g tpl-g">
		<div class="tpl-login">
			<div class="tpl-login-content">
				<div class="tpl-login-title">该邮箱已经被注册</div>
				<span class="tpl-login-content-info">忘记密码?</span>
			</div>
			<div class="am-form-group">
				<button type="button" class="am-btn am-btn-default" onclick="window.history.back(-1)">返回</button>
			</div>
		</div>
	</div>
	</c:if>
	<c:if test="${exist == 0}">
		<div class="tpl-login">
			<div class="tpl-login-content">
				<div class="tpl-login-title">我们已经发送一封激活邮件到${email }，激活以后可以登录。</div>
			</div>
		</div>
	</c:if>

</body>
<script src="${ctx }/resources/component/jQuery/jquery.min.js?${version}"></script>
<script src="${ctx }/resources/component/AmazeUI-2.7.2/js/amazeui.min.js?${version}"></script>
</html>
