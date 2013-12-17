<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="minimal">
<title><spring:message code="factor.title">
		<!--語系-->
	</spring:message></title>
</head>
<body>
<script>
	loadScript('js/division/factorMntPage');
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
		<button type="button">
			<span class="ui-icon ui-icon-jcs-04"></span>儲存
		</button>
		<button type="button">
			<span class="ui-icon ui-icon-circle-zoomout"></span>試算
		</button>
		<button type="button" onclick="window.close();">
			<span class="ui-icon ui-icon-jcs-01"></span>離開
		</button>
	</div>
	<div class="clear"></div>
	<!-- **********************************************內容 Start *******************************************-->
	<div class="tit2 color-black"></div>

	<div class="tabCtx-warp ui-widget-content" style="padding: 1em 1.4em;">
		<fieldset>
			<legend>基本資訊</legend>
			<form action="">
				<table class="tb2" width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tbody>
						<tr>
							<td width="13%" class="hd1"><span class="color-red">＊</span>條件代碼</td>
							<td width="20%"><input type="text" size='10' value="A000001"></td>
							<td width="13%" class="hd1"><span class="color-red">＊</span>條件名稱</td>
							<td width="20%"><input type="text" value="協商組-前置協商"></td>
							<td width="13%" class="hd1">狀態</td>
							<td width="20%"><input type="radio" name="normal" />啟動&nbsp;
								<input type="radio" name="normal" />停用</td>
						</tr>
					</tbody>
				</table>
			</form>
		</fieldset>

		<fieldset>
			<legend>組合資訊</legend>
			<table class="tb2" width="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tbody>
					<tr>
						<td width="13%" class="hd1"><span class="color-red">＊</span>因子項目</td>
						<td width="20%"><select name="sel3" style="WIDTH: 150px">
								<option value="">產品項目</option>
								<option value="">催收人員</option>
								<option value="">逾期天數</option>
								<option value="">逾期金額</option>
						</select>
							<button id="">
								<span class="text-only">查詢</span>
							</button></td>
						<td width="13%" class="hd1" rowspan="2"><span
							class="color-red">＊</span>值域</td>
						<td width="53%" rowspan="2">
							<div id="ftRsGrid" class="capgrid">
							</div>
						</td>
					</tr>
					<tr>
						<td width="13%" class="hd1"><span class="color-red"></span>排序</td>
						<td width="20%"><select name="sel3" style="WIDTH: 100px">
								<option value="">無</option>
								<option value="">遞增</option>
								<option value="">遞減</option>
						</select></td>
					</tr>
				</tbody>
			</table>

			<div class="funcContainer">
				<button id="new_btn1">
					<span class="text-only">新增</span>
				</button>
				<button id="edit_btn1">
					<span class="text-only">修改</span>
				</button>
				<button id="del_btn1">
					<span class="text-only">刪除</span>
				</button>
				<button id="assign_btn">
					<span class="text-only"></span>案件分派設定
				</button>
			</div>
			<div id="ftDtlGrid" class="capgrid" >
			</div>
		</fieldset>

		<fieldset>
			<legend>異動記錄</legend>
			<table class="tb2" border="0" cellpadding="0" cellspacing="0"
				width="100%">
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
		
		<!-- dialog start-->
		<!--Start : 設定催收人員權限-->
		<div id="edit_dialog1" title="新增因子值域明細" class="popup_cont"
			style="display: none">

			<fieldset>
				<legend>值域資訊</legend>
				<table class="tb2" border="0" cellpadding="0" cellspacing="0"
					width="100%">
					<tbody>
						<tr>
							<td class="hd1" width="20%"><span class="color-red">＊</span>值域註解</td>
							<td width="30%"><input type="text" size='40'></td>
						</tr>
						<tr>
							<td class="hd1" width="20%"><span class="color-red">＊</span>值域一</td>
							<td width="30%"><input type="text" size='20'></td>
						</tr>
						<tr>
							<td class="hd1" width="20%">值域二</td>
							<td width="30%"><input type="text" size='20'></td>
						</tr>
						<tr>
							<td class="hd1" width="20%"><span class="color-red">＊</span>順序</td>
							<td width="30%"><input type="text" size='10'></td>
						</tr>
					</tbody>
				</table>
			</fieldset>

		</div>

		<div id="edit_dialog2" title="分派組別/狀態" class="popup_cont"
			style="display: none">

			<fieldset>
				<legend>分派資訊</legend>
				<table class="tb2" border="0" cellpadding="0" cellspacing="0"
					width="100%">
					<tbody>
						<tr>
							<td class="hd1" width="20%"><span class="color-red">＊</span>分派組別</td>
							<td width="30%"><select name="assignSel"
								style="WIDTH: 150px">
									<option value=""></option>
									<option value="">電催組</option>
									<option value="">協商組</option>
									<option value="">協議組</option>
									<option value="">法務組</option>
									<option value="">委外組</option>
									<option value="">特殊組</option>
									<option value="">其他組</option>
							</select></td>
						</tr>
						<tr>
							<td class="hd1" width="20%"><span class="color-red">＊</span>分派人員</td>
							<td width="30%"><select name="assignSel"
								style="WIDTH: 150px">
									<option value=""></option>
									<option value="">件數平均</option>
									<option value="">金額平均</option>
									<option value="">人數平均</option>
									<option value="">新增金額平均</option>
									<option value="">新增案件平均</option>
							</select></td>
						</tr>
						<tr>
							<td class="hd1" width="20%"><span class="color-red">＊</span>分派狀態</td>
							<td width="30%"><select name="statusSel"
								style="WIDTH: 150px">
									<option value=""></option>
									<option value="">已分案</option>
									<option value="">分案待處理</option>
									<option value="">分案待指派</option>
									<option value="">未分案</option>
							</select></td>
						</tr>
						<tr>
							<td class="hd1" width="20%"><span class="color-red">＊</span>備註</td>
							<td width="30%"><input type="text" size='30'></td>
						</tr>
					</tbody>
				</table>
			</fieldset>

		</div>
		<!-- dialog end-->
		<!-- dialog start-->
		<!--Start : 啟動停用-->

		<!-- dialog end-->
	</div>
	<!-- **********************************************內容 end *******************************************-->
	</div>
</body>
</html>
