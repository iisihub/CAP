<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="form">
<title><spring:message code="funcset.title">
        <!--系統功能-->
    </spring:message></title>
</head>
<body>
    <script>
          loadScript('js/system/funcSet_Page');
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
    <!--Start : 編輯-->
    <div id="EDIT">
        <form id="JForm">
            <fieldset>
                <legend>
                    <spring:message code="func"></spring:message>
                </legend>
                <table class="tb2" width="99%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                        <tr>
                            <td width="20%" class="hd1"><span class="color-red">＊</span> <spring:message code="sysType"></spring:message></td>
                            <td width="30%"><select id="sysType" name="sysType" combokey="authSysId" combotype="2" class="validate[required]"></select> <select id="sysCode" combokey="sysType"
                                class="hide"></select></td>
                            <td width="20%" class="hd1"><span class="color-red">＊</span> <spring:message code="js.funclevel"></spring:message></td>
                            <td width="30%"><select id="level" name="level" combokey="funcLevel" combotype="2" class="validate[required]"></select></td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1"><span class="color-red">＊</span> <spring:message code="js.funccode"></spring:message></td>
                            <td width="30%"><span id="FUNC"></span><input type="text" size="6" id="FUNCCODE" name="FUNCCODE" maxlength="4" class="validate[required]" /><input type="text"
                                id="code" name="code" class="hide" /></td>
                            <td width="20%" class="hd1"><span class="color-red">＊</span> <spring:message code="js.funcname"></spring:message></td>
                            <td width="30%"><input type="text" size="15" id="name" name="name" maxlength="162" class="validate[required]" /></td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1"><span class="color-red">＊</span> <spring:message code="parent"></spring:message></td>
                            <td><select id="parent" name="parent" class="validate[required]"></select></td>
                            <td width="20%" class="hd1"><span class="color-red">＊</span> <spring:message code="js.funcsequence"></spring:message></td>
                            <td><input type="text" id="sequence" name="sequence" size="5" maxlength="5" class="validate[required] number"></td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1"><span class="color-red">＊</span> <spring:message code="funcstatus"></spring:message></td>
                            <td colspan="3"><input type="radio" id="status" name="status" class="validate[required]" value="1" /> <spring:message code="on"></spring:message> <input type="radio"
                                id="status" name="status" class="validate[required]" value="0" /> <spring:message code="off"></spring:message></td>
                            <!-- <td width="20%" class="hd1">
	                            	<span class="color-red">＊</span><spring:message code="autoFlag"></spring:message></td>
	                            <td>
	                            	<input type="radio" id="autoFlag" name="autoFlag" class="validate[required]" value="1"/><spring:message code="js.yes"></spring:message>
	                            	<input type="radio" id="autoFlag" name="autoFlag" class="validate[required]" value="0"/><spring:message code="js.no"></spring:message>
	                            </td> -->
                        </tr>
                        <tr>
                            <td width="20%" class="hd1"><spring:message code="path"></spring:message></td>
                            <td colspan="3"><input type="text" id="path" name="path" size="80" maxlength="40" /></td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1"><spring:message code="desc"></spring:message></td>
                            <td colspan="3"><input type="text" size="80" id="desc" name="desc" maxlength="108" /></td>
                        </tr>
                    </tbody>
                </table>
            </fieldset>
            <fieldset>
                <legend>
                    <spring:message code="role"></spring:message>
                </legend>
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
    <div id="editRole" style="display: none">
        <form id="mform">
            <div id="gridviewRole"></div>
        </form>
    </div>
    <!-- dialog end-->
</body>
</html>
