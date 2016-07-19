<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="pwdpolicy.title" /></title>
</head>
<body>
    <script>
          loadScript('js/system/pwdpolicy');
        </script>
    <div>
        <form id="mform" onsubmit="return false;">
            <input type="text" id="oid" name="oid" class="hide" /><input type="text" id="mtype" name="mtype" class="hide" />
            <table class="row-data">
                <tr>
                    <th><spring:message code="pwdpolicy.expired_day" /></th>
                    <td><input type="text" id="expired_day" name="expired_day" maxlength="32" size="10" class="numeric" /> <spring:message code="pwdpolicy.days" /></td>
                </tr>
                <tr>
                    <th><spring:message code="pwdpolicy.min_length" /></th>
                    <td><input type="text" id="min_length" name="min_length" maxlength="32" size="10" class="numeric" /></td>
                </tr>
                <tr>
                    <th><spring:message code="pwdpolicy.rule" /></th>
                    <td><select id="rule" name="rule" comboType="2" comboKey="pwdrule"></select></td>
                </tr>
                <tr>
                    <th><spring:message code="pwdpolicy.max_history" /></th>
                    <td><input type="text" id="max_history" name="max_history" maxlength="100" size="10" class="numeric" /> <spring:message code="pwdpolicy.generation" /></td>
                </tr>
                <tr>
                    <th><spring:message code="pwdpolicy.captcha_enable" /></th>
                    <td><spring:message code="pwdpolicy.errors" /><input type="text" id="captcha_enable" name="captcha_enable" size="10" maxlength="100" class="numeric" /> <spring:message
                            code="pwdpolicy.times" /></td>
                </tr>
                <tr>
                    <th><spring:message code="pwdpolicy.account_lock" /></th>
                    <td><spring:message code="pwdpolicy.errors" /><input type="text" id="account_lock" name="account_lock" size="10" maxlength="100" class="numeric" /> <spring:message
                            code="pwdpolicy.times" /></td>
                </tr>
                <tr>
                    <th><spring:message code="pwdpolicy.account_disable" /></th>
                    <td><spring:message code="pwdpolicy.continuous" /><input type="text" id="account_disable" name="account_disable" size="10" maxlength="100" class="numeric" /> <spring:message
                            code="pwdpolicy.not_login" /></td>
                </tr>
                <tr>
                    <th><spring:message code="pwdpolicy.account_delete" /></th>
                    <td><spring:message code="pwdpolicy.continuous" /><input type="text" id="account_delete" name="account_delete" size="10" maxlength="100" class="numeric" /> <spring:message
                            code="pwdpolicy.not_login" /></td>
                </tr>
                <tr>
                    <th><spring:message code="pwdpolicy.force_change_pwd" /></th>
                    <td><select id="force_change_pwd" name="force_change_pwd" comboType="2" comboKey="pwdforcechangepwd"></select></td>
                </tr>
                <tr>
                    <th><spring:message code="pwdpolicy.change_interval" /></th>
                    <td><input type="text" id="change_interval" name="change_interval" maxlength="32" size="10" class="numeric" /> <spring:message code="pwdpolicy.days" /></td>
                </tr>
                <tr>
                    <th><spring:message code="pwdpolicy.notify_day" /></th>
                    <td><input type="text" id="notify_day" name="notify_day" maxlength="32" size="10" class="numeric" /> <spring:message code="pwdpolicy.daysbefore" /></td>
                </tr>
            </table>
        </form>
        <div class="btns" style="text-align: right">
            <button id="confirm" type="button" class="btn1">
                <spring:message code="js.sure" />
            </button>
        </div>
    </div>
</body>
</html>
