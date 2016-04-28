<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="form">
<title><spring:message code="factor.title">
        <!--語系-->
    </spring:message></title>
</head>
<body>
    <script>
          loadScript('js/division/factorMnt_Page');
        </script>
    <!-- 	<div id="headerarea">
		<div class="header_wrap">
			<table width="100%" class="header" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td width="298" height="74" class="header_logo"></td>
					<td class="ct title"><b>信貸催理系統</b></td>
					<td class="header_content">
						<div class="system_msg clearfix" title="IP 位址：192.168.61.123">
							<ul>
								<li><b>組 別：</b>電催組 <b>授權等級：</b>乙級主管 <br></li>
								<li><b>使用者：</b>翁小芳（03738） <br></li>
							</ul>
						</div>
					</td>
					<td width="20" height="74" class="header_ft"></td>
				</tr>
			</table>
		</div>
	</div> -->
    <div class="button-menu funcContainer">
        <button type="button" id="save_btn">
            <span class="ui-icon ui-icon-jcs-04"></span>儲存
        </button>
        <!-- <button type="button" id="">
			<span class="ui-icon ui-icon-circle-zoomout"></span>試算
		</button> -->
        <button type="button" id="close_btn" onclick="window.close();">
            <span class="ui-icon ui-icon-jcs-01"></span>離開
        </button>
    </div>
    <div class="clear"></div>
    <!-- **********************************************內容 Start *******************************************-->
    <div class="tit2 color-black"></div>
    <div class="tabCtx-warp ui-widget-content" style="padding: 1em 1.4em;">
        <form id="mform" onsubmit="return false;">
            <input type="text" class="hide" style="display: none" id="oid" name="oid" />
            <fieldset>
                <legend>因子資訊</legend>
                <table class="tb2" width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                        <tr>
                            <td width="13%" class="hd1"><span class="color-red">＊</span>因子代碼</td>
                            <td width="20%"><input type="text" id="factorNo" name="factorNo" size='10' value=""></td>
                            <td width="13%" class="hd1"><span class="color-red">＊</span>因子名稱</td>
                            <td width="40%"><input type="text" id="factorNm" name="factorNm" size='40' value=""></td>
                            <td width="13%" class="hd1"><span class="color-red">＊</span>屬性</td>
                            <td><select id="dataType" name="dataType" style="WIDTH: 150px">
                                    <option value="1">數值</option>
                                    <option value="2">字串</option>
                                    <option value="3">布林</option>
                            </select></td>
                        </tr>
                        <tr>
                            <td width="13%" class="hd1"><span class="color-red">＊</span>資料表明稱</td>
                            <td width="20%"><input type="text" id="tableNm" name="tableNm" size='10' value=""></td>
                            <td width="13%" class="hd1"><span class="color-red">＊</span>因子欄位名稱</td>
                            <td width="40%"><input type="text" id="columnNm" name="columnNm" size='40' value=""></td>
                            <td width="13%" class="hd1"></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </fieldset>
            <fieldset>
                <legend>因子值域明細</legend>
                <div class="funcContainer">
                    <button id="new_btn">
                        <span class="text-only">新增</span>
                    </button>
                    <button id="mod_btn">
                        <span class="text-only">修改</span>
                    </button>
                    <button id="del_btn">
                        <span class="text-only">刪除</span>
                    </button>
                </div>
                <div id="ftDtlGrid" class="capgrid" />
            </fieldset>
            <fieldset>
                <legend>異動記錄</legend>
                <table class="tb2" border="0" cellpadding="0" cellspacing="0" width="100%">
                    <tbody>
                        <tr>
                            <td class="hd1" width="20%">文件建立人員</td>
                            <td width="30%">翁小芳(YYY-MM-DD HH:MM)</td>
                            <td class="hd1" width="20%">最後異動人員</td>
                            <td width="30%">翁小芳(YYY-MM-DD HH:MM)</td>
                        </tr>
                    </tbody>
                </table>
            </fieldset>
        </form>
        <!-- dialog start-->
        <div id="edit_dialog" title="因子值域明細" class="popup_cont" style="display: none">
            <form id="facform" name="facform" onsubmit="return false;">
                <input type="hidden" id="mod_colId" name="mod_colId" />
                <fieldset>
                    <legend>值域資訊</legend>
                    <table class="tb2" border="0" cellpadding="0" cellspacing="0" width="100%">
                        <tbody>
                            <tr class="ftType1">
                                <td class="hd1" width="20%">值域一</td>
                                <td width="30%"><input type="text" id="range1" name="range1" size='20'></td>
                            </tr>
                            <tr class="ftType2">
                                <td class="hd1" width="20%">值域</td>
                                <td width="30%"><select id="ftTypeBlnSel" name="ftTypeBlnSel" style="WIDTH: 150px">
                                        <option value="true">true</option>
                                        <option value="false">false</option>
                                </select></td>
                            </tr>
                            <tr class="ftType1">
                                <td class="hd1" width="20%">值域二</td>
                                <td width="30%"><input type="text" id="range2" name="range2" size='20'></td>
                            </tr>
                        </tbody>
                    </table>
                </fieldset>
            </form>
            <!-- dialog end-->
        </div>
        <!-- **********************************************內容 end *******************************************-->
    </div>
</body>
</html>
