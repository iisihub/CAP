<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="adm1030.title"><!--參數設定--></spring:message></title>
</head>
<body>
	<script>
		loadScript('js/admin/adm1030');
	</script>
	<div>
		<div class="btns">
			<button id="qry" type="button" class="btn1">
				<spring:message code="btn.query">
					<!--查詢-->
				</spring:message>
			</button>
			<button id="unlock" type="button" class="btn1">
				<spring:message code="btn.unlock">
					<!--解除編輯鎖定-->
				</spring:message>
			</button>
		</div>
		<div id="gridview"></div>
		<!--Start : 查詢-->
		<div id="SEARCH" style="display:none;">
                <table class="tb2" width="95%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                        <tr>
                            <td width="20%" class="hd1">系統別</td>
                            <td width="30%">
                                <select>
																			<option value="1">徵信</option>
																			<option value="2">逾催</option>
																		</select>
                            </td>
                            <td width="20%" class="hd1" nowrap="true">編輯人員編號</td>
                            <td width="30%">
                                <input name="field" type="text" size="10" />
                            </td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1">分行</td>
                            <td width="30%">
                                <select>
									<option value="1">分行1</option>
									<option value="2">分行2</option>
									<option value="3">分行3</option>
									<option value="4">分行4</option>
									<option value="5">分行5</option>
								</select>
                            </td>
                            <td width="20%" class="hd1" nowrap="true">
                            </td>
                            <td width="30%">
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
	</div>
</body>
</html>
