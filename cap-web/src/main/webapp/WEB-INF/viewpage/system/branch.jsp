<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="branch.title"><!--分行資料--></spring:message></title>
</head>
<body>
	<script>
		loadScript('js/system/branch');
	</script>
	<div>
		<div class="btns">
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
		<!--Start : 編輯-->
		<div id="EDIT" style="display:none">
            <form id="JForm">
                <table class="tb2" width="99%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                        <tr>
                            <td width="20%" class="hd1">
                                <span class="color-red">＊</span><spring:message code="js.departno"></spring:message></td>
                            <td width="30%">
                                <input type="text" size="4" id="departno" name="departno" maxlength="4" class="required"/>
                            </td>
                            <td width="20%" class="hd1">
                                <spring:message code="js.departnm"></spring:message></td>
                            <td width="30%">
                                <input type="text" size="30" id="departnm" name="departnm" maxlength="30"/>
                            </td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1">
                                <spring:message code="js.proxy"></spring:message></td>
                            <td width="30%">
                                <input type="text" size="30" id="depproxy" name="depproxy" maxlength="30"/>
                            </td>
                            <td width="20%" class="hd1"><spring:message code="js.depmanag"></spring:message></td>
                            <td width="30%">
                                <input type="text" size="30" id="depmanag" name="depmanag" maxlength="30"/>
                            </td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1">
                                <spring:message code="js.departel"></spring:message></td>
                            <td width="30%">
                                <input type="text" size="20" id="departel" name="departel" maxlength="20"/>
                            </td>
                            <td width="20%" class="hd1"><spring:message code="js.abrekflg"></spring:message></td>
                            <td width="30%">
                                <input type="radio" id="abrekflg" name="abrekflg" value="Y"/><spring:message code="js.on"></spring:message>
                                <input type="radio" id="abrekflg" name="abrekflg" value="N"/><spring:message code="js.off"></spring:message>
                            </td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1">
                                <spring:message code="js.deparadd"></spring:message></td>
                            <td colspan="3">
                                <input type="text" size="5" id="deparzip" name="deparzip" maxlength="5"/>
                                <input type="text" size="90" id="deparadd" name="deparadd" maxlength="90"/>
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
