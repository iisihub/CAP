<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="adm2090.title"><!--參數設定--></spring:message></title>
</head>
<body>
	<script>
		loadScript('js/system/adm2090');
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
                <form id="searchForm">
                    <table class="tb2" width="99%" border="0" cellspacing="0" cellpadding="0" id="searchTable">
                        <tbody>
                            <tr>
                                <td width="40%" class="hd1">不需記錄的Handler名稱</td>
                                <td width="60%">
                                    <input type="text" size="40" id="code" maxlength="40">
                                </td>
                            </tr>
                            <tr>
                                <td class="hd1">不需記錄的類型</td>
                                <td>
                                    <select id="brekFlag" name="brekFlag">
                                        <option value="A">A - 全部不記錄(LOG+DATA)</option>
                                        <option value="D">D - 不記錄明細(DATA)</option>
                                        <option value="C">C - 記錄全部</option>
                                    </select>
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
