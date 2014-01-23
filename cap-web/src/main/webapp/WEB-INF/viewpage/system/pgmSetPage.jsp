<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="form">
<title><spring:message code="pgmSet.title"><!--系統功能--></spring:message></title>
</head>
<body>
	<script>
		loadScript('js/system/pgmSetPage');
	</script>
	<div class="button-menu funcContainer">
		<button type="button" id="save_btn">
			<spring:message code="btn.save"></spring:message><!-- 儲存  -->
		</button>
		<button type="button" id="close_btn" onclick="window.close();">
			<spring:message code="btn.leave"></spring:message><!-- 離開  -->
		</button>
	</div>
	<div class="clear"></div>
		<!--Start : 編輯-->
		<div id="EDIT">
            <form id="JForm">
	            <fieldset>
					<legend><spring:message code="pgm"></spring:message></legend>
	                <table class="tb2" width="99%" border="0" cellspacing="0" cellpadding="0">
	                    <tbody>
	                        <tr>
	                            <td width="20%" class="hd1">
	                                <span class="color-red">＊</span><spring:message code="sysTyp"></spring:message></td>
	                            <td width="30%">
	                                <select id="sysTyp" name="sysTyp" combokey="authSysId" combotype="2" class="validate[required]"></select>
	                                <select id="sysCode" combokey="sysTyp" class="hide"></select>
	                            </td>
	                            <td width="20%" class="hd1">
	                                <span class="color-red">＊</span><spring:message code="pgmType"></spring:message></td>
	                            <td width="30%">
	                                <select id="step" name="step" combokey="pgmType" combotype="2" class="validate[required]"></select>
	                            </td>
	                        </tr>
	                        <tr>
	                            <td width="20%" class="hd1">
	                                <span class="color-red">＊</span><spring:message code="pgmCode"></spring:message></td>
	                            <td width="30%">
	                                <span id="PGM"></span><input type="text" size="6" id="PGMCODE" name="PGMCODE" maxlength="4" class="validate[required]"/><input type="text" id="code" name="code" class="hide"/>
	                            </td>
	                            <td width="20%" class="hd1">
	                            	<span class="color-red">＊</span><spring:message code="pgmName"></spring:message></td>
	                            <td width="30%">
	                                <input type="text" size="15" id="name" name="name" maxlength="162" class="validate[required]"/>
	                            </td>
	                        </tr>
	                        <tr>
	                            <td width="20%" class="hd1">
	                            	<span class="color-red">＊</span><spring:message code="pgmTyp"></spring:message></td>
	                            <td>
	                                <select id="parent" name="parent" class="validate[required]"></select>
	                            </td>
	                            <td width="20%" class="hd1">
	                            	<span class="color-red">＊</span><spring:message code="seq"></spring:message></td>
	                            <td>
	                                <input type="text" id="seq" name="seq" size="5" maxlength="5" class="validate[required] number">
	                            </td>
	                        </tr>
	                        <tr>
	                            <td width="20%" class="hd1">
	                            	<span class="color-red">＊</span><spring:message code="inputFlg"></spring:message></td>
	                            <td colspan="3">
	                            	<input type="radio" id="inputFlg" name="inputFlg" class="validate[required]" value="1"/><spring:message code="on"></spring:message>
	                            	<input type="radio" id="inputFlg" name="inputFlg" class="validate[required]" value="0"/><spring:message code="off"></spring:message>
	                            </td>
	                            <!-- <td width="20%" class="hd1">
	                            	<span class="color-red">＊</span><spring:message code="autoFlag"></spring:message></td>
	                            <td>
	                            	<input type="radio" id="autoFlag" name="autoFlag" class="validate[required]" value="1"/><spring:message code="js.yes"></spring:message>
	                            	<input type="radio" id="autoFlag" name="autoFlag" class="validate[required]" value="0"/><spring:message code="js.no"></spring:message>
	                            </td> -->
	                        </tr>
	                        <tr>
	                            <td width="20%" class="hd1"><spring:message code="pgmPath"></spring:message></td>
	                            <td colspan="3">
	                                <input type="text" id="path" name="path" size="80" maxlength="40"/>
	                            </td>
	                        </tr>
	                        <tr>
	                            <td width="20%" class="hd1"><spring:message code="pgmDesc"></spring:message></td>
	                            <td colspan="3">
	                                <input type="text" size="80" id="desc" name="desc" maxlength="108"/>
	                            </td>
	                        </tr>
	                    </tbody>
	                </table>
                </fieldset>
                <fieldset>
					<legend><spring:message code="role"></spring:message></legend>
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
        <div id="editRole" style="display:none">
            <form id="mform">
            	<div id="gridviewRole"></div>
            </form>
        </div>
		<!-- dialog end-->
</body>
</html>
