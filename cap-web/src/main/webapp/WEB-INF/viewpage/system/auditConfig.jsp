<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="auditConfig.title"><!--操作記錄設定--></spring:message></title>
</head>
<body>
	<script>
		loadScript('js/system/auditConfig');
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
			<div id="SEARCH" style="display:none">
                <form id="JForm">
                    <table class="tb2" width="550" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                            <tr>
                                <td width="20%" class="hd1" nowrap="true"><spring:message code="js.grid1"><!-- 不需記錄的Handler名稱 --></spring:message></td>
                                <td width="60%">
                                    <input type="text" id="targetName" size="55"/>
                                </td>
                            </tr>
                            <tr>
                                <td width="20%" class="hd1" nowrap="true"><spring:message code="js.grid2"><!-- 不需記錄的類型 --></spring:message></td>
                                <td>
                                    <select id="disableType" name="disableType" combokey="DisableType" space="true"></select>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
		<!-- dialog end-->
	</div>
</body>
</html>
