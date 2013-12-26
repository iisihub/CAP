<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="adm5020.title"><!--參數設定--></spring:message></title>
</head>
<body>
	<script>
		loadScript('js/admin/adm5020');
	</script>
	<div>
		<div class="btns">
			<button id="qry" type="button" class="btn1">
				<!--<spring:message code="btn.query">-->
					使用者查詢
				<!--</spring:message>-->
			</button>
			線上使用者人數:<span></span>
		</div>
		<div id="gridview"></div>
		<!--Start : 查詢-->
						<div id="SEARCH" style="display:none">
                <form id="searchForm">
                    <table class="tb2" border="0" cellspacing="0" cellpadding="0" width="100%">
                        <tbody>
                            <tr>
                                <td width="50%" class="hd1">UserId</td>
                                <td width="50%">
                                    <input type="text" size="15" id="userId">
                                </td>
                            </tr>
                            <tr>
                                <td class="hd1">單位名稱</td>
                                <td>
                                    <select id="branchId">
                                        <option value=""></option>
                                        <option value="1">001分行</option>
                                        <option value="2">002分行</option>
                                        <option value="3">003分行</option>
                                        <option value="4">004分行</option>
                                    </select>
                                </td>
                            </tr>
							<!-- 							<tr>
                                <td class="hd1">子系統</td>
                                <td>
                                    <select id="branchId">
                                        <option value=""></option>
                                        <option value="1">COL</option>
                                        <option value="2">CES</option>
                                        <option value="3">SNR</option>
                                        <option value="4">ADM</option>
                                    </select>
                                </td>
                            </tr> -->
                        </tbody>
                    </table>
                </form>
            </div>
						<!-- dialog end-->
	</div>
</body>
</html>
