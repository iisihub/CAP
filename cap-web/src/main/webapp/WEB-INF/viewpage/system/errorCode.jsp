<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="errorCode.title">
        <!--訊息代碼維護-->
    </spring:message></title>
</head>
<body>
    <script>
          loadScript('js/system/errorCode');
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
        <!--Start : 查詢-->
        <div id="SEARCH" style="display: none">
            <form id="searchForm">
                <table class="tb2" width="99%" border="0" cellspacing="0" cellpadding="0" id="searchTable">
                    <tbody>
                        <tr>
                            <td width="40%" class="hd1"><spring:message code="js.code"></spring:message></td>
                            <td width="60%"><input type="text" size="20" id="code" name="code" maxlength="20" /></td>
                        </tr>
                        <tr>
                            <td class="hd1"><spring:message code="js.locale"></spring:message></td>
                            <td><select id="locale" name="locale" combokey="lang"></select></td>
                        </tr>
                        <!-- 
                        <tr>
                            <td class="hd1"><spring:message code="js.sysId"></spring:message></td>
                            <td>
                                <select id="sysId" name="sysId" combokey="subsystem"></select>
                            </td>
                        </tr>
                         -->
                    </tbody>
                </table>
            </form>
        </div>
        <!--Start : 編輯-->
        <div id="EDIT" style="display: none">
            <form id="JForm">
                <table class="tb2" width="99%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                        <tr>
                            <td width="20%" class="hd1"><span class="color-red">＊</span> <spring:message code="js.code"></spring:message></td>
                            <td width="30%"><input type="text" size="20" id="code" name="code" maxlength="20" class="validate[required]" /></td>
                            <td width="20%" class="hd1"><span class="color-red">＊</span> <spring:message code="js.locale"></spring:message></td>
                            <td width="30%"><select id="locale" name="locale" combokey="lang" space="true" class="validate[required]"></select></td>
                        </tr>
                        <tr>
                            <!-- 
                            <td width="20%" class="hd1">
                                <span class="color-red">＊</span><spring:message code="js.sysId"></spring:message></td>
                            <td width="30%">
                                <select id="sysId" name="sysId" combokey="subsystem" space="true" class="validate[required]"></select>
                            </td>
                             -->
                            <td width="20%" class="hd1"><span class="color-red">＊</span> <spring:message code="js.severity"></spring:message></td>
                            <td width="30%"><select id="severity" name="severity">
                                    <option value="INFO">INFO</option>
                                    <option value="WARN">WARN</option>
                                    <option value="ERROR">ERROR</option>
                            </select></td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1"><span class="color-red">＊</span> <spring:message code="js.message"></spring:message></td>
                            <td colspan="3"><textarea type="text" rows="5" cols="50" id="message" name="message" maxlength="512" class="validate[required]"></textarea></td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1"><spring:message code="js.suggestion"></spring:message></td>
                            <td colspan="3"><textarea id="suggestion" name="suggestion" rows="5" cols="50"></textarea></td>
                        </tr>
                        <!-- 
                        <tr>
                            <td width="20%" class="hd1"><spring:message code="js.sendmon"></spring:message></td>
                            <td colspan="3">
                                <select id="sendMon" name="sendMon">
                                    <option value="N">N</option>
                                    <option value="Y">Y</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1"><spring:message code="js.helpurl"></spring:message></td>
                            <td colspan="3">
                                <input type="text" size="50" id="helpURL" name="helpURL" maxlength="100"/>
                            </td>
                        </tr>
                         -->
                    </tbody>
                </table>
            </form>
        </div>
        <!-- dialog end-->
    </div>
</body>
</html>
