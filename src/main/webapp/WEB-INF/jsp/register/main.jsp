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
<link rel="stylesheet"
	href="${ctx }/resources/css/register/register.css?${version}" />
<title>Easy Coding</title>
</head>
<body>
	<div class="am-g tpl-g">
		<div class="tpl-login">
			<div class="tpl-login-content">
				<div class="tpl-login-title">注册用户</div>
				<span class="tpl-login-content-info">创建一个新的用户</span>
				<form class="am-form tpl-form-line-form" id="register_form" method="post" action="${ctx }/register/apply">
					<div class="am-form-group">
						<input type="text" class="tpl-form-input" name="company" placeholder="公司名称" required>
					</div>
					<div class="am-form-group">
						<input type="email" class="tpl-form-input ajax_username" id="username" name="username" placeholder="通过邮箱注册" required>
					</div>
					<div class="am-form-group">
						<input type="password" class="tpl-form-input" id="password" name="password" placeholder="请输入密码" required>
					</div>
					<div class="am-form-group">
						<input type="password" class="tpl-form-input" id="confirm_password" name="confirm_password" placeholder="再次输入密码" data-equal-to="#password" required data-validation-message="密码不一致">
					</div>
					<div class="am-form-group">
						<div class="am-fr">
							<img src="${ctx }/captcha" width="100px"/>
						</div>
						<div class="verifyCode am-fr">
							<input type="text" class="tpl-form-input am-fl ajax_verify_code" id="verifyCode" name="verifyCode" placeholder="验证码" required>
						</div>
						<div class="am-cf"></div>
					</div>
					<div class="am-form-group tpl-login-remember-me" id="remember-me_div">
						<input id="remember-me" type="checkbox"> 
						<label for="remember-me"> 我已阅读并同意 <a href="javascript:;">《用户注册协议》</a></label>
					</div>
					<div class="am-form-group">
						<button id="register_btn" type="button" class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn" disabled="disabled">注册</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
<script src="${ctx }/resources/component/jQuery/jquery.min.js?${version}"></script>
<script src="${ctx }/resources/component/AmazeUI-2.7.2/js/amazeui.min.js?${version}"></script>
<script src="${ctx }/resources/js/register/register.js?${version}"></script>
</html>
