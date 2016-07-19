<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="sysparm.title">
        <!--參數設定-->
    </spring:message></title>
</head>
<body>
    <script>
          loadScript('js/system/sysparm');
        </script>
    <div>
        <div class="btns">
            <button id="qry" type="button" class="btn1">
                <spring:message code="btn.query">
                    <!--查詢-->
                </spring:message>
            </button>
            <button id="add" type="button" class="btn1">
                <spring:message code="btn.add">
                    <!--新增-->
                </spring:message>
            </button>
            <button id="delete" type="button" class="btn1">
                <spring:message code="btn.delete">
                    <!--刪除-->
                </spring:message>
            </button>
        </div>
        <div id="gridview"></div>
        <div id="qryDailog" class="hide" title="<spring:message code="btn.query" />">
            <form id="qform" onsubmit="return false;">
                <table class="row-data">
                    <tr>
                        <th><spring:message code="js.parmId">
                                <!--參數代碼-->
                            </spring:message></th>
                        <td><input type="text" id="parmId" name="parmId" maxlength="30" class="validate[required]" /></td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="editDialog" class="hide" title="<spring:message code="editDialog" />">
            <form id="mform" onsubmit="return false;">
                <table class="row-data">
                    <tr>
                        <th><spring:message code="js.parmId">
                                <!--參數代碼-->
                            </spring:message></th>
                        <td><input type="text" id=parmId name="parmId" maxlength="30" class="validate[required]" /></td>
                    </tr>
                    <tr>
                        <th><spring:message code="js.parmValue">
                                <!--參數值-->
                            </spring:message></th>
                        <td><input type="text" id="parmValue" name="parmValue" size="70" maxlength="300" class="validate[required,funcCall[maxUTF8[300]]]" /></td>
                    </tr>
                    <tr>
                        <th><spring:message code="js.parmDesc">
                                <!--說明-->
                            </spring:message></th>
                        <td><textarea id="parmDesc" cols="70" rows="2" maxlength="300" name="parmDesc" class="validate[required,funcCall[maxUTF8[300]]]"></textarea></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
