<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta name="decorator" content="none">
<title>使用者密碼變更</title>
</head>
<body>
    <script>
          loadScript('js/admin/pwdchange');
        </script>
    <div>
        <form id="mform" onsubmit="return false;">
            <input type="text" id="oid" name="oid" class="hide" /><input type="text" id="mtype" name="mtype" class="hide" />
            <table class="row-data">
                <tr>
                    <th>目前密碼</th>
                    <td><input type="password" id="password" name="password" maxlength="48" class="validate[required,funcCall[maxUTF8[48]]]" /></td>
                </tr>
                <tr>
                    <th>新密碼</th>
                    <td><input type="password" id="newPwd" name="newPwd" maxlength="48" class="validate[required,funcCall[maxUTF8[48]]]" /></td>
                </tr>
                <tr>
                    <th>密碼確認</th>
                    <td><input type="password" id="confirm" name="confirm" maxlength="48" class="validate[funcCall[maxUTF8[48]]]" /></td>
                </tr>
            </table>
        </form>
        <div class="btns" style="text-align: right">
            <button id="change" type="button" class="btn1">確定</button>
            <button id="clear" type="button" class="btn1">清除</button>
        </div>
    </div>
</body>
</html>
