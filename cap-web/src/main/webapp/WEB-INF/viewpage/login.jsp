<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="decorator" content="login">
<title>cap login</title>
</head>
<body>
	<script>
	loadScript('js/login');
    </script>
	<div style="margin: auto; width: 960px;">
		<form onsubmit="return false;">
			<table class="row-data">
				<tr>
					<th>帳號</th>
					<td><input type="text" id="j_username" name="j_username" /></td>
				</tr>
				<tr>
					<th>密碼</th>
					<td><input type="password" id="j_password" name="j_password" /></td>
				</tr>
			</table>
			<table id="pwdchgArea" class="row-data hide">
				<tr>
					<th>新密碼</th>
					<td><input type="password" id="newPwd" name="newPwd"
						maxlength="48" class="validate[required,funcCall[maxUTF8[48]]]" /></td>
				</tr>
				<tr>
					<th>密碼確認</th>
					<td><input type="password" id="confirm" name="confirm"
						maxlength="48" class="validate[funcCall[maxUTF8[48]]]" /></td>
				</tr>
			</table>
			<table id="captchaArea" class="row-data hide">
				<tr>
					<th>圖形驗證碼</th>
					<td><input id="captcha" name="captcha" class="captcha"
						type="text" /></td>
				</tr>
			</table>
			<button type="button" id="submit">
				<spring:message code="btn.login"></spring:message>
			</button>
		</form>
	</div>
</body>
</html>
