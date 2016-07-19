<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <div id="shadow">
        <div id="content">
            <div id="location">
                <h1>IISI CAP</h1>
            </div>
            <div class="line"></div>
            <div id="front">
                <br>
            </div>
            <div class="line"></div>
            <div class="item">
                <br>
                <form onsubmit="return false;">
                    <table class="row">
                        <tr>
                            <th width="30%" style="text-align: right; padding: 5px;">帳號</th>
                            <td><input type="text" id="j_username" name="j_username" /></td>
                        </tr>
                        <tr>
                            <th style="text-align: right; padding: 5px;">密碼</th>
                            <td><input type="password" id="j_password" name="j_password" /></td>
                        </tr>
                    </table>
                    <table id="pwdchgArea" class="row hide">
                        <tr>
                            <th width="30%" style="text-align: right; padding: 5px;">新密碼</th>
                            <td><input type="password" id="newPwd" name="newPwd" maxlength="48" class="validate[required,funcCall[maxUTF8[48]]]" /></td>
                        </tr>
                        <tr>
                            <th style="text-align: right; padding: 5px;">密碼確認</th>
                            <td><input type="password" id="confirm" name="confirm" maxlength="48" class="validate[funcCall[maxUTF8[48]]]" /></td>
                        </tr>
                    </table>
                    <table id="captchaArea" class="row hide">
                        <tr>
                            <th width="30%" style="text-align: right; padding: 5px;">圖形驗證碼</th>
                            <td><input id="captcha" name="captcha" class="captcha" type="text" /></td>
                        </tr>
                    </table>
                    <br />
                    <div class="btns" style="text-align: right">
                        <button type="button" id="submit">
                            <spring:message code="btn.login"></spring:message>
                        </button>
                    </div>
                </form>
            </div>
            <div class="line"></div>
            <div id="copy" style="text-align: right">
                <a href="http://www.iisigroup.com/tw/">版權所有 Copyright 2012 © 資拓宏宇股份有限公司</a>
            </div>
        </div>
    </div>
</body>
</html>
