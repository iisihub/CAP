<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="adm2040.title"><!--參數設定--></spring:message></title>
</head>
<body>
	<script>
		loadScript('js/admin/adm2040');
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
		<!--Start : 查詢-->
						<div id="SEARCH" style="display:none;">
                <table class="tb2" width="95%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                        <tr>
                            <td width="70%" class="hd1">公告主旨</td>
                            <td width="30%">
                                <input name="field" type="text" size="40" />
                            </td>
                        </tr>
                        <tr>
                            <td  class="hd1">狀態</td>
                            <td>
                                <select>
																			<option value="1">啟用</option>
																			<option value="2">不啟用</option>
																		</select>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!--Start : 編輯-->
						<div id="edit_dialog1" style="display:none;">
                <table class="tb2" width="95%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                        <tr>
                            <td width="60%" class="hd1"><span class="color-red">＊</span>公告主旨</td>
                            <td width="40%" colspan="3">
                                <input name="field" type="text" size="40" />
                            </td>
                        </tr>
                        <tr>
                            <td class="hd1"><span class="color-red">＊</span>公告內容</td>
                            <td colspan="3">
                                <textarea name="e_content" class="required" id="e_content" rows="10" cols="50"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="hd1"><span class="color-red">＊</span>公告等級</td>
                            <td>
                                <select>
																			<option value="1">置頂</option>
																			<option value="2">普通</option>
																			<option value="3">重要</option>
																		</select>
                            </td>
                            <td class="hd1"><span class="color-red">＊</span>狀態</td>
                            <td>
                                <select>
																			<option value="1">啟用</option>
																			<option value="2">不啟用</option>
																		</select>
                            </td>
                        </tr>
                        <tr>
                            <td class="hd1"><span class="color-red">＊</span>公告起日</td>
                            <td >
                                <input name="field" type="text" size="10" class="date"/>
                            </td>
                            <td class="hd1"><span class="color-red">＊</span>公告迄日</td>
                            <td >
                                <input name="field" type="text" size="10" class="date"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="hd1"><span class="color-red">＊</span>語言別</td>
                            <td >
                                <select>
																			<option value="1">繁體zh_TW</option>
																			<option value="2">簡中zh_CN</option>
																			<option value="2">英文en</option>
																		</select>
                            </td>
                            <td class="hd1"></td>
                            <td >
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
	</div>
</body>
</html>
