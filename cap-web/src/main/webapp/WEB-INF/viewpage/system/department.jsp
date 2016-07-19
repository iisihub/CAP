<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="department.title">
        <!--分行資料-->
    </spring:message></title>
</head>
<body>
    <script>
          loadScript('js/system/department');
        </script>
    <div>
        <div class="btns">
            <button id="add" type="button" class="btn1">
                <spring:message code="btn.add">
                    <!--新增-->
                </spring:message>
            </button>
            <button id="modify" type="button" class="btn1">
                <spring:message code="btn.modify">
                    <!--修改-->
                </spring:message>
            </button>
            <button id="delete" type="button" class="btn1">
                <spring:message code="btn.delete">
                    <!--刪除-->
                </spring:message>
            </button>
        </div>
        <div id="gridview"></div>
        <!-- dialog start-->
        <!--Start : 編輯-->
        <div id="EDIT" style="display: none">
            <form id="JForm">
                <table class="tb2" width="99%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                        <tr>
                            <td width="20%" class="hd1"><span class="color-red">＊</span> <spring:message code="js.depcode"></spring:message></td>
                            <td width="30%"><input type="text" size="4" id="code" name="code" maxlength="4" class="validate[required]" /></td>
                            <td width="20%" class="hd1"><spring:message code="js.depname"></spring:message></td>
                            <td width="30%"><input type="text" size="30" id="name" name="name" maxlength="30" /></td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1"><spring:message code="js.depproxy"></spring:message></td>
                            <td width="30%"><input type="text" size="30" id="proxy" name="proxy" maxlength="30" /></td>
                            <td width="20%" class="hd1"><spring:message code="js.depmanager"></spring:message></td>
                            <td width="30%"><input type="text" size="30" id="manager" name="manager" maxlength="30" /></td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1"><spring:message code="js.deptel"></spring:message></td>
                            <td width="30%"><input type="text" size="20" id="tel" name="tel" maxlength="20" /></td>
                            <td width="20%" class="hd1"><spring:message code="js.depstatus"></spring:message></td>
                            <td width="30%"><input type="radio" id="status" name="status" value="Y" /> <spring:message code="js.depon"></spring:message> <input type="radio" id="status"
                                name="status" value="N" /> <spring:message code="js.depoff"></spring:message></td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1"><spring:message code="js.depaddr"></spring:message></td>
                            <td colspan="3"><input type="text" size="5" id="zip" name="zip" maxlength="5" /> <input type="text" size="90" id="addr" name="addr" maxlength="90" /></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <!-- dialog end-->
    </div>
</body>
</html>
