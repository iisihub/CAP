<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="auditData.title"><!--使用者操作記錄查詢--></spring:message></title>
</head>
<body>
	<script>
		loadScript('js/admin/auditData');
	</script>
	<div>
		<div class="btns">
			<button id="qry" type="button" class="btn1">
				<spring:message code="btn.query">
					<!--查詢-->
				</spring:message>
			</button>
			<button id="detail" type="button" class="btn1">
				<spring:message code="btn.detail">
					<!--操作資料內容-->
				</spring:message>
			</button>
		</div>
		<div id="gridview"></div>
		<!-- dialog start-->
		<!-- 查詢視窗-->
        <div id="SEARCH" style="display:none">
            <form id="searchForm" name="searchForm">
                <table class="tb2" width="95%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                        <tr>
                            <td width="20%" class="hd1">
                                <spring:message code="js.sno">
                                    <!-- 序號 -->
                                </spring:message>
                            </td>
                            <td colspan="1">
                                <input type="text" size="15" id="sno" name="sno">
                            </td>
                            <td width="20%" class="hd1">
                                <spring:message code="userId">
                                    <!-- 員工編號 -->
                                </spring:message>
                            </td>
                            <td width="30%">
                                <input type="text" size="15" id="userId" name="userId" maxlength="6">
                            </td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1">
                                <spring:message code="date">
                                    <!-- 記錄日期 -->
                                </spring:message>
                            </td>
                            <td width="30%">
                                <input type="text" size="15" id="sdate" name="sdate" class="date">
                            </td>
                            <td width="20%" class="hd1" nowrap="true">
                                <spring:message code="time">
                                    <!-- 記錄時間(時:分) -->
                                </spring:message>
                            </td>
                            <td width="30%">
                                <input type="text" size="8" id="time" name="time" maxlength="8"/>
                                <spring:message code="after">
                                    <!-- (以後) -->
                                </spring:message>
                            </td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1">
                                <spring:message code="js.sys">
                                    <!-- 系統代碼 -->
                                </spring:message>
                            </td>
                            <td width="30%"  colspan="3">
                                <select id="sysId" name="sysId" combokey="subsystem"></select>
                            </td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1">
                                <spring:message code="mainId">
                                    <!-- 文件序號 -->
                                </spring:message>
                            </td>
                            <td width="30%" colspan="3">
                                <input type="text" size="50" id="mainId" name="mainId" maxlength="32"/>
                            </td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1">
                                <spring:message code="invokeTarget">
                                    <!-- 事件對象 -->
                                </spring:message>
                            </td>
                            <td width="30%" colspan="3">
                                <input type="text" size="50" id="invokeTarget" name="invokeTarget" maxlength="100"/>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div><!-- 明細視窗-->
        <div id="DETAIL" style="display:none">
            <div id="logData"></div>
        </div>
        <div id="dataIn" style="display:none">
            <fieldset>
                <legend>
                    <spring:message code="in">
                        <!-- 輸入 -->
                    </spring:message>
                </legend>
                <textarea id="data" rows="7" cols="63"></textarea>
            </fieldset>
        </div>
        <div id="dataOut" style="display:none">
            <fieldset>
                <legend>
                    <spring:message code="out">
                        <!-- 輸出 -->
                    </spring:message>
                </legend>
                <textarea id="data" rows="7" cols="63"></textarea>
            </fieldset>
        </div>
	</div>
</body>
</html>
