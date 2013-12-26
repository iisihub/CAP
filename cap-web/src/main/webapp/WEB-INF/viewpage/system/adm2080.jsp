<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="adm2080.title"><!--參數設定--></spring:message></title>
</head>
<body>
	<script>
		loadScript('js/system/adm2080');
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
                                <td width="40%" class="hd1">狀況代碼</td>
                                <td width="60%">
                                    <input type="text" size="20" id="code" maxlength="20">
                                </td>
                            </tr>
                            <!-- <tr>
                                <td class="hd1">語言別</td>
                                <td>
                                    <select id="brekFlag" name="brekFlag">
                                        <option value="1">繁體zh_TW</option>
                                        <option value="2">簡中zh_CN</option>
                                        <option value="3">英文en</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="hd1">系統別</td>
                                <td>
                                    <select id="brekFlag" name="brekFlag">
                                        <option value="N">徵信系統</option>
                                        <option value="Y">授信系統</option>
                                        <option value="Y">債清系統</option>
                                        <option value="Y">逾催系統</option>
                                    </select>
                                </td>
                            </tr> -->
                        </tbody>
                    </table>
                </form>
            </div>
		<!--Start : 編輯-->
						<div id="EDIT" style="display:none">
                <form id="JForm">
                    <table class="tb2" width="99%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                            <tr>
                                <td width="20%" class="hd1">
                                    <span class="color-red">＊</span>狀況代碼</td>
                                <td width="30%">
                                    <input type="text" size="20" id="code" name="code" maxlength="20" class="required">
                                </td>
                                <!-- <td width="20%" class="hd1">
                                    <span class="color-red">＊</span>語言別</td>
                                <td width="30%">
                                    <select id="brekFlag" name="brekFlag">
                                        <option value="1">繁體zh_TW</option>
                                        <option value="2">簡中zh_CN</option>
                                        <option value="3">英文en</option>
                                    </select>
                                </td> -->
                            </tr>
                            <tr>
                                <!-- <td width="20%" class="hd1">
                                    <span class="color-red">＊</span>系統別</td>
                                <td width="30%">
                                    <select id="brekFlag" name="brekFlag">
                                        <option value="N">徵信系統</option>
                                        <option value="Y">授信系統</option>
                                        <option value="Y">債清系統</option>
                                        <option value="Y">逾催系統</option>
                                    </select>
                                </td> -->
                                <td width="20%" class="hd1">等級</td>
                                <td width="30%">
                                    <select id="severity" name="severity">
                                        <option value="INFO">INFO</option>
                                        <option value="WARN">WARN</option>
                                        <option value="ERROR">ERROR</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td width="20%" class="hd1">狀況說明</td>
                                <td>
                                    <textarea type="text" rows="5" cols="50" id="message" name="message" maxlength="512">
                                    </textarea>
                                </td>
                            </tr>
                            <tr>
                                <td width="20%" class="hd1">建議處理方式</td>
                                <td>
                                    <textarea id="suggestion" name="suggestion" rows="5" cols="50">
                                    </textarea>
                                </td>
                            </tr>
                            <tr>
                                <td width="20%" class="hd1">是否送監控</td>
                                <td>
                                    <select id="sendMon" name="sendMon">
                                        <option value="N">N</option>
                                        <option value="Y">Y</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td width="20%" class="hd1">HELPURL</td>
                                <td>
                                    <input type="text" size="50" id="helpURL" name="helpURL" maxlength="100">
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
