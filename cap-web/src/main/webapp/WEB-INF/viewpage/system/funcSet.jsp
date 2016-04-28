<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="funcset.title">
        <!--系統功能-->
    </spring:message></title>
</head>
<body>
    <script>
          loadScript('js/system/funcSet');
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
                            <td width="40%" class="hd1"><spring:message code="sysType1"></spring:message></td>
                            <td width="60%"><select id="sysType" name="sysType" combokey="authSysId" combotype="2"></select></td>
                        </tr>
                        <tr>
                            <td class="hd1"><spring:message code="js.funclevel"></spring:message></td>
                            <td><select id="level" name="level" combokey="funcLevel" combotype="2"></select></td>
                        </tr>
                        <tr>
                            <td class="hd1"><spring:message code="js.funccode"></spring:message></td>
                            <td><input type="text" size="6" id="code" name="code" maxlength="6"></td>
                        </tr>
                        <tr>
                            <td class="hd1"><spring:message code="js.funcname"></spring:message></td>
                            <td><input type="text" size="15" id="name" name="name" maxlength="162"></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <!-- dialog end-->
    </div>
</body>
</html>
