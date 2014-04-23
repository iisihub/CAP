<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="users.title" /></title>
</head>
<body>
  <script>
      loadScript('js/admin/userSet');
    </script>
  <div>
    <div class="btns" style="text-align: right">
      <button id="filter" type="button" class="btn1">
        <spring:message code="btn.filter" />
      </button>
      <button id="add" type="button" class="btn1">
        <spring:message code="btn.add" />
      </button>
      <button id="modify" type="button" class="btn1">
        <spring:message code="btn.modify" />
      </button>
      <button id="delete" type="button" class="btn1">
        <spring:message code="btn.delete" />
      </button>
      <button id="lock" type="button" class="btn1">
        <spring:message code="btn.lock" />
      </button>
      <button id="unlock" type="button" class="btn1">
        <spring:message code="btn.unlock" />
      </button>
    </div>
    <div id="gridview"></div>
  </div>
  <div id="addDialog" class="hide">
    <form id="mform" onsubmit="return false;">
      <input type="text" id="oid" name="oid" class="hide" /><input type="text"
        id="mtype" name="mtype" class="hide" />
      <table class="row-data">
        <tr>
          <th><spring:message code="users.userid" /></th>
          <td><input type="text" id="userId" name="userId" maxlength="20"
            class="validate[required,funcCall[maxUTF8[60]]]" /></td>
          <th><spring:message code="users.username" /></th>
          <td><input type="text" id="userName" maxlength="48"
            name="userName" class="validate[required,funcCall[maxUTF8[48]]]" />
          </td>
        </tr>
        <tr id="pwdArea">
          <th><spring:message code="users.password1" /></th>
          <td><input type="password" id="password" name="password"
            maxlength="48" class="validate[required]" /></td>
          <th><spring:message code="users.password2" /></th>
          <td><input type="password" id="confirm" maxlength="48" name="confirm"
            class="validate[required]" /></td>
        </tr>
        <tr>
          <th><spring:message code="users.email" /></th>
          <td><input type="text" id="email" maxlength="48" name="email"
            class="validate[required,funcCall[maxUTF8[48]]]" /></td>
          <th id="statusArea"><spring:message code="users.status" /></th>
          <td><span id="status"></span></td>
        </tr>
      </table>
      <div id="roleGrid"></div>
    </form>
  </div>
  <div id="qryDailog">
    <form id="qform" onsubmit="return false;">
      <table class="row-data">
        <tr>
          <th><spring:message code="users.userid" /></th>
          <td><input type="text" id="qUserId" name="qUserId" maxlength="32" /></td>
          <th><spring:message code="users.username" /></th>
          <td><input type="text" id="qUserName" maxlength="48"
            name="qUserName" /></td>
        </tr>
      </table>
      <div id="qRoleGrid"></div>
      <div id="statusGrid"></div>
    </form>
  </div>
</body>
</html>
