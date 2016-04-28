<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="codetype.title">
        <!--語系-->
    </spring:message></title>
</head>
<body>
    <script>
          loadScript('js/system/codetype');
        </script>
    <div>
        <form id="mform" onsubmit="return false;">
            <!--<fieldset class="row">
                -->
            <input type="text" id="oid" name="oid" class="hide" /><input type="text" id="mtype" name="mtype" class="hide" />
            <table class="row-data">
                <tr>
                    <th><spring:message code="codetype.local">
                            <!--語系-->
                        </spring:message></th>
                    <td><select id="locale" name="locale" combokey="lang" class="validate[required]"></select></td>
                    <th></th>
                    <td></td>
                </tr>
                <tr>
                    <th><spring:message code="codetype.codeType">
                            <!--代碼-->
                        </spring:message></th>
                    <td><input type="text" id="codeType" name="codeType" maxlength="32" class="validate[required,funcCall[maxUTF8[32]]]" /></td>
                    <th><spring:message code="codetype.codeVal">
                            <!--值-->
                        </spring:message></th>
                    <td><input type="text" id="codeValue" maxlength="48" name="codeValue" class="validate[required,funcCall[maxUTF8[48]]]" /></td>
                </tr>
                <tr>
                    <th><spring:message code="codetype.codeDesc">
                            <!--描述-->
                        </spring:message></th>
                    <td><input type="text" id="codeDesc" name="codeDesc" maxlength="100" class="validate[funcCall[maxUTF8[100]]]" /></td>
                    <th><spring:message code="codetype.codeOrder">
                            <!--排序-->
                        </spring:message></th>
                    <td><input type="text" id="codeOrder" name="codeOrder" maxlength="3" size="3" class="validate[required,custom[integer],funcCall[maxUTF8[3]]] numeric" /></td>
                </tr>
            </table>
            <!--</fieldset>-->
        </form>
        <div class="btns" colspan="4" style="text-align: right">
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
            <button id="clear" type="button" class="btn1">
                <spring:message code="btn.clear">
                    <!--清除-->
                </spring:message>
            </button>
        </div>
        <div id="gridview"></div>
    </div>
</body>
</html>
