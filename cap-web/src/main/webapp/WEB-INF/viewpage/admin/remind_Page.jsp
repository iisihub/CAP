<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="form">
<title><spring:message code="event.title">
        <!--提醒通知-->
    </spring:message></title>
</head>
<body>
    <script>
          loadScript('js/admin/remind_Page');
        </script>
    <div class="button-menu funcContainer">
        <button type="button" id="save_btn">
            <spring:message code="btn.save"></spring:message>
            <!-- 儲存  -->
        </button>
        <button type="button" id="close_btn" onclick="window.close();">
            <spring:message code="btn.leave"></spring:message>
            <!-- 離開  -->
        </button>
    </div>
    <div class="clear"></div>
    <!--Start : 提醒通知登錄-->
    <div id="EDIT">
        <form id="mForm">
            <fieldset>
                <legend>
                    <spring:message code="event.title">
                        <!--提醒通知登錄-->
                    </spring:message>
                </legend>
                <table class="tb2" width="99%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                        <tr>
                            <td width="8%" class="hd2 rt"><spring:message code="scopeTyp"></spring:message></td>
                            <td width="22%"><select id="scopeTyp" name="scopeTyp" combokey="scopeTyp" combotype="2"></select> <input type="text" size="12" id="scopePid" name="scopePid"
                                maxlength="10" class="validate[required]" /></td>
                            <td width="8%" class="hd2 rt"><spring:message code="startDate"></spring:message></td>
                            <td width="25%"><input type="text" id="startDate" name="startDate" class="validate[required] date" /> <input type="text" id="startTime" name="startTime"
                                class="validate[required] time" size="7" maxlength="5" value="00:00" /></td>
                            <td width="8%" class="hd2 rt"><spring:message code="endDate"></spring:message></td>
                            <td width="25%"><input type="text" id="endDate" name="endDate" class="validate[required] date" /> <input type="text" id="endTime" name="endTime"
                                class="validate[required] time" size="7" maxlength="5" value="00:00" /></td>
                        </tr>
                        <tr>
                            <td class="hd2 rt"><spring:message code="content"></spring:message></td>
                            <td colspan="5"><textarea name="content" id="content" cols="33" rows="3" class="txt_mult" style="width: 580px; height: 40px;"></textarea></td>
                        </tr>
                    </tbody>
                </table>
                <div class="btns">
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
    <div id="DETAIL" style="display: none">
        <form id="dForm">
            <table class="tb2" width="99%" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                    <tr>
                        <td width="20%" class="hd1"><spring:message code="js.styleTyp"></spring:message></td>
                        <td width="30%"><select id="styleTyp" name="styleTyp" combokey="styleTyp" combotype="2"></select></td>
                    <tr>
                    </tr>
                    <td width="20%" class="hd1"><spring:message code="js.styleNum"></spring:message></td>
                    <td width="30%"><input type="text" size="10" id="style" name="style" maxlength="5" class="number validate[required]" /></td>
                    </tr>
                    <tr>
                        <td width="20%" class="hd1"><spring:message code="js.styleUnit"></spring:message></td>
                        <td width="30%"><select id="unit" name="unit" combokey="unitMins" combotype="2"></select></td>
                    <tr>
                </tbody>
            </table>
        </form>
    </div>
    <!-- dialog end-->
</body>
</html>
