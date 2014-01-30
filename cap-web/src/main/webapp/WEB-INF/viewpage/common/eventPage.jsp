<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
</head>
<body>
	<script>
		loadScript('js/common/eventPage');
	</script>
	<div class="clear"></div>
		<!--Start : 提醒通知登錄-->
		<div id="EDIT">
            <form id="JForm">
	            <fieldset>
					<legend><spring:message code="event.title"><!--提醒通知登錄--></spring:message></legend>
	                <table class="tb2" width="99%" border="0" cellspacing="0" cellpadding="0">
	                    <tbody>
	                        <tr>
	                            <td width="20%" class="hd1">
	                                <spring:message code="scopeTyp"></spring:message></td>
	                            <td width="30%">
	                                <select id="scopeTyp" name="scopeTyp" combokey="scopeTyp" combotype="2"></select>
	                                <input type="text" size="12" id="scopePid" name="scopePid" maxlength="10" class="validate[required]"/>
	                            </td>
	                            <td width="20%" class="hd1">
	                                <spring:message code="startDate"></spring:message></td>
	                            <td width="30%">
	                                <input type="text" id="startDate" name="startDate" class="date validate[required]"/>
	                                <select id="sHour" name="sHour" combokey="hours" combotype="2"></select><spring:message code="hour"></spring:message></td>
	                                <select id="sMinute" name="sMinute" combokey="minutes" combotype="2"></select><spring:message code="minute"></spring:message></td>
	                            </td>
	                            <td width="20%" class="hd1">
	                                <spring:message code="endDate"></spring:message></td>
	                            <td width="30%">
	                                <input type="text" id="endDate" name="endDate" class="date validate[required]"/>
	                                <select id="eHour" name="eHour" combokey="hours" combotype="2"></select><spring:message code="hour"></spring:message></td>
	                                <select id="eMinute" name="eMinute" combokey="minutes" combotype="2"></select><spring:message code="minute"></spring:message></td>
	                            </td>
	                        </tr>
	                        <tr>
	                            <td class="hd1">
	                                <spring:message code="content"></spring:message></td>
	                            <td colspan="5">
	                                <textarea name="content" id="content" cols="33" rows="3" class="txt_mult" style="width:580px;height:40px;"></textarea>
	                            </td>
	                        </tr>
	                    </tbody>
	                </table>
	                <div id="btns">
						<button id="add" type="button" class="btn1">
							<spring:message code="btn.add">
								<!--新增-->
							</spring:message>
						</button>
						<button id="delete" type="button" class="btn1">
							<spring:message code="btn.delete">
								<!--刪除-->
							</spring:message>
						</button>
					</div>
					<div id="gridview"></div>
                </fieldset>
            </form>
        </div>
		<!-- dialog end-->
		<!--Start : 新增通知方式-->
		<div id="DETAIL" style="display:none">
            <form id="mForm">
                <table class="tb2" width="99%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                        <tr>
                            <td width="20%" class="hd1">
                                <spring:message code="js.styleTyp"></spring:message></td>
                            <td width="30%">
                                <select id="styleTyp" name="styleTyp" combokey="styleTyp" combotype="2"></select>
                            </td>
                        <tr>
                        </tr>
                            <td width="20%" class="hd1">
                                <spring:message code="js.styleNum"></spring:message></td>
                            <td width="30%">
                                <input type="text" size="10" id="style" name="style" maxlength="5" class="number validate[required]"/>
                            </td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1">
                                <spring:message code="js.styleUnit"></spring:message></td>
                            <td width="30%">
                                <select id="unit" name="unit" combokey="unitMins" combotype="2"></select>
                            </td>
                        <tr>
                    </tbody>
                </table>
            </form>
        </div>
		<!-- dialog end-->
</body>
</html>
