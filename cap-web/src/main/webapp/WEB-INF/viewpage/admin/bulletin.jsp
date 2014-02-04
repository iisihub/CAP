<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="bulletin.title"><!--公告訊息--></spring:message></title>
</head>
<body>
	<script>
		loadScript('js/admin/bulletin');
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
			<form id="searchForm">
                <table class="tb2" width="95%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                        <tr>
                            <td width="20%" class="hd1"><spring:message code="js.bTitle"><!--公告主旨--></spring:message></td>
                            <td width="80%" colspan="3">
                                <input type="text" size="50" id="title" name="title">
                            </td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1"><spring:message code="js.status"><!--狀態--></spring:message></td>
                            <td width="80%">
                                <select id="status" name="status" combokey="status" combotype="2"></select>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
         </div>
         <!--Start : 編輯-->
		 <div id="EDIT" style="display:none;">
		 	<form id="JForm">
                <table class="tb2" width="95%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                        <tr>
                            <td width="20%" class="hd1"><span class="color-red">＊</span><spring:message code="js.bTitle"><!--公告主旨--></spring:message></td>
                            <td width="80%" colspan="3">
                                <input type="text" size="50" class="validate[required]" id="title" name="title" maxlength="100">
                            </td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1"><span class="color-red">＊</span><spring:message code="js.content"><!--公告內容--></spring:message></td>
                            <td width="80%" colspan="3">
                                <textarea name="content" class="validate[required]" id="content" rows="10" cols="50"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1"><span class="color-red">＊</span><spring:message code="js.level"><!--公告等級--></spring:message></td>
                            <td width="30%">
                                <select id="level" name="level" combokey="level" combotype="2" class="validate[required]"></select>
                            </td>
                            <td width="20%" class="hd1"><span class="color-red">＊</span><spring:message code="js.status"><!--狀態--></spring:message></td>
                            <td width="30%">
                                <select id="status" name="status" combokey="status" combotype="2" class="validate[required]"></select>
                            </td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1"><span class="color-red">＊</span><spring:message code="js.startDate"><!--公告起日--></spring:message></td>
                            <td width="30%">
                                <input type="text" size="15" class="validate[required] date" id="startDate" name="startDate">
                            </td>
                            <td width="20%" class="hd1"><span class="color-red">＊</span><spring:message code="js.endDate"><!--公告迄日--></spring:message></td>
                            <td width="30%">
                                <input type="text" size="15" class="validate[required] date" id="endDate" name="endDate">
                            </td>
                        </tr>
                        <tr>
                            <td width="20%" class="hd1"><span class="color-red">＊</span><spring:message code="js.locale"><!--語言別--></spring:message></td>
                            <td width="30%">
                                <select id="locale" name="locale" combokey="lang" combotype="2" class="validate[required]"></select>
                            </td>
                            <td class="hd1"></td>
                            <td >
                            </td>
                        </tr>
                    </tbody>
        		</table>
        	</form>
    	</div>
	</div>
</body>
</html>
