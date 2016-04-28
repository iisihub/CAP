<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="form">
<title><spring:message code="ruleTb.title">
        <!--語系-->
    </spring:message></title>
</head>
<body>
    <script>
          loadScript('js/division/ruleTbMnt_Page');
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
    <form id="mform" onsubmit="return false;">
        <div class="button-menu funcContainer">
            <button type="button" id="save_btn">
                <span class="ui-icon ui-icon-jcs-04"></span>儲存
            </button>
            <button type="button" id="testDrools">
                <span class="ui-icon ui-icon-circle-zoomout"></span>試算
            </button>
            <button type="button" id="dwnload">
                <span class="ui-icon ui-icon-jcs-01"></span>匯出DecisionXls
            </button>
            <button type="button" id="close_btn" onclick="window.close();">
                <span class="ui-icon ui-icon-jcs-01"></span>離開
            </button>
        </div>
        <div class="clear"></div>
        <!-- **********************************************內容 Start *******************************************-->
        <div class="tit2 color-black"></div>
        <div class="tabCtx-warp ui-widget-content" style="padding: 1em 1.4em;">
            <input type="text" class="hide" style="display: none" id="oid" name="oid" />
            <fieldset>
                <legend>條件設定</legend>
                <table class="tb2" width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                        <tr>
                            <td width="13%" class="hd1"><span class="color-red">＊</span>規則表代碼</td>
                            <td width="20%"><input type="text" id="divRlNo" name="divRlNo" size='10' value=""></td>
                            <td width="13%" class="hd1"><span class="color-red">＊</span>規則表名稱</td>
                            <td width="20%"><input type="text" id="divRlNm" name="divRlNm" value=""></td>
                        </tr>
                        <tr>
                            <td width="13%" class="hd1">均分量化方式</td>
                            <td width="53%" colspan="3"><input name="RadioGroup1" value="A" id="RadioGroup1" type="radio" />金額平均 <input name="RadioGroup1" value="B" id="RadioGroup1" type="radio" />件數平均
                                <input name="RadioGroup1" value="C" id="RadioGroup1" type="radio" />人數平均 <input name="RadioGroup1" value="D" id="RadioGroup1" type="radio" />新增金額平均 <input
                                name="RadioGroup1" value="E" id="RadioGroup1" type="radio" />新增件數平均</td>
                        </tr>
                    </tbody>
                </table>
            </fieldset>
            <fieldset>
                <legend>規則資訊</legend>
                <div class="RuleContainer">
                    <button type="button" id="addRuleBtn">
                        <span class="text-only">新增</span>
                    </button>
                </div>
                <div id="conditionGrid" class="capgrid" />
            </fieldset>
            <fieldset id="ruleMap" name="ruleMap">
                <legend>規則組合</legend>
                <div class="funcContainer">
                    <button type="button" id="removeBtn">
                        <span class="text-only">移除</span>
                    </button>
                    <!--
				<button id="edit_btn1"><span class="text-only">修改</span></button>
				<button id="del_btn1"><span class="text-only">刪除</span></button>
				<button id="close_btn1"><span class="text-only">關閉</span></button>
				-->
                </div>
                <div id="" style="width: 100%;">
                    <table width="100%">
                        <tr>
                            <td width="60%"><div id="ruleMapGrid" class="capgrid" /></td>
                            <td width="40%">
                                <button type="button" id="up_btn">
                                    <span class="text-only">提高優先序</span>
                                </button> <br />
                                <button type="button" id="dwn_btn">
                                    <span class="text-only">降低優先序</span>
                                </button>
                            </td>
                        </tr>
                    </table>
                </div>
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
        </div>
    </form>
    <!-- dialog start-->
    <!--Start : 新增修改值域-->
    <div id="factorVal_Dialog" title="編輯因子值域明細" class="popup_cont" style="display: none">
        <form id="facform" onsubmit="return false;">
            <fieldset>
                <legend>值域資訊</legend>
                <table class="tb2" border="0" cellpadding="0" cellspacing="0" width="100%">
                    <tbody>
                        <tr>
                            <td class="hd1" width="20%"><span class="color-red">＊</span>值域一</td>
                            <td width="30%"><input type="text" id="val1" size='20'></td>
                        </tr>
                        <tr>
                            <td class="hd1" width="20%">值域二</td>
                            <td width="30%"><input type="text" id="val2" size='20'></td>
                        </tr>
                        <tr>
                            <td class="hd1" width="20%"><span class="color-red">＊</span>順序</td>
                            <td width="30%"><input type="text" id="seqn" size='10'></td>
                        </tr>
                    </tbody>
                </table>
            </fieldset>
        </form>
    </div>
    <!--Start : 啟動停用-->
    </div>
    <!-- **********************************************內容 end *******************************************-->
</body>
</html>