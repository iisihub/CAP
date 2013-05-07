<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title>預約開戶申請</title>
<style type="text/css">
table th {color: blue;font-weight: bolder;}
table th b{color: red;}
</style>
</head>
<body>
	<script>
		loadScript('js/report/reserveOpen');
	</script>
	<div>
		<form id="mform" onsubmit="return false;">
			<table class="row-data">
				<tr>
					<th><b>＊</b>姓名</th>
					<td><input type="text" name="custName" id="custName" class="validate[required]"/></td>
				</tr>
				<tr>
					<th>英文户名</th>
					<td><input type="text" name="c001" id="c001"/></td>
				</tr>
				<tr>
					<th><b>＊</b>身分别</th>
					<td><label><input type="radio" name="c002" id="ri021" value="1" checked/>本国人</label>
						<label><input type="radio" name="c002" id="ri022" value="2"/>公司户</label>
					</td>
				</tr>
				<tr>
					<th><b>＊</b>身分证</th>
					<td><input type="text" name="custId" id="custId" class="validate[required]"/></td>
				</tr>
				<tr>
					<th><b>＊</b>出生年月日</th>
					<td><input type="text" name="c003" id="c003" class="date validate[required]"/></td>
				</tr>
				<tr>
					<th><b>＊</b>户籍地址</th>
					<td><input type="text" name="c004" id="c004" class="validate[required]" size="90"/></td>
				</tr>
				<tr>
					<th><b>＊</b>通讯地址</th>
					<td><label><input type="radio" name="r051" id="ri051" value="1" />同户籍地</label>
						<label><input type="radio" name="r051" id="ri052" value="2" checked/>另行输入</label><br/><br/>
					<input type="text" name="c005" id="c005" class="validate[required]" size="90"/></td>
				</tr>
				<tr>
					<th>连络电话</th>
					<td><input type="text" name="c006" id="c006" /></td>
				</tr>
				<tr>
					<th>行动电话</th>
					<td><input type="text" name="c007" id="c007" /></td>
				</tr>
				<tr>
					<th><b>＊</b>E-mail信箱</th>
					<td><input type="text" name="c008" id="c008" size="60"/></td>
				</tr>
				<tr>
					<th><b>＊</b>开户类别</th>
					<td><label><input type="radio" name="c009" id="ri091" value="1" checked/>本国币</label>
						<label><input type="radio" name="c009" id="ri092" value="2" />外币</label></td>
				</tr>
				<tr>
					<th><b>＊</b>产品种类</th>
					<td><label><input type="radio" name="c010" id="ri101" value="1" checked/>一般户</label>
						<label><input type="radio" name="c010" id="ri102" value="2" />证券户</label></td>
				</tr>
				<tr>
					<th><b>＊</b>存摺种类</th>
					<td><label><input type="radio" name="c011" id="ri111" value="1" checked/>有摺</label>
						<label><input type="radio" name="c011" id="ri112" value="2" />无摺</label></td>
				</tr>
				<tr>
					<th><b>＊</b>综合夺帐单</th>
					<td><label><input type="radio" name="c012" id="ri121" value="1" checked/>邮寄</label>
						<label><input type="radio" name="c012" id="ri122" value="2" />自取</label></td>
				</tr>
				<tr>
					<th><b>＊</b>电子夺帐单</th>
					<td><label><input type="radio" name="c013" id="ri131" value="1" checked/>申请</label>
						<label><input type="radio" name="c013" id="ri132" value="2" />不申请</label></td>
				</tr>
				<tr>
					<th><b>＊</b>网路银行</th>
					<td><label><input type="radio" name="c014" id="ri141" value="1" checked/>申请</label>
						<label><input type="radio" name="c014" id="ri142" value="2" />不申请</label></td>						
				</tr>
				<tr>
					<th><b>＊</b>语音服务</th>
					<td><label><input type="radio" name="c015" id="ri151" value="1" checked/>申请</label>
						<label><input type="radio" name="c015" id="ri152" value="2" />不申请</label></td>						
				</tr>
				<tr>
					<th><b>＊</b>约定转入帐严</th>
					<td><table><tr><td>转入银行代码</td><td>转入银行帐严</td></tr>
							   <tr><td><input type="text" size="10" name="c016" id="c016"/></td><td><input type="text" size="40" name="c017" id="c017"/></td></tr>
							   <tr><td><input type="text" size="10" name="c018" id="c018"/></td><td><input type="text" size="40" name="c019" id="c019"/></td></tr>
							   <tr><td><input type="text" size="10" name="c020" id="c020"/></td><td><input type="text" size="40" name="c021" id="c021"/></td></tr>
							   <tr><td><input type="text" size="10" name="c022" id="c022"/></td><td><input type="text" size="40" name="c023" id="c023"/></td></tr>
							   <tr><td><input type="text" size="10" name="c024" id="c024"/></td><td><input type="text" size="40" name="c025" id="c025"/></td></tr>
						</table>
					</td>						
				</tr>
				<tr>
					<th><b>＊</b>预约开户分行</th>
					<td><select id="c026" name="c026">
							<option value="b001">第一分行</option>
							<option value="b002">第二分行</option>
							<option value="b003">第三分行</option>
							<option value="b004">第四分行</option>
							<option value="b005">第五分行</option>
						</select></td>						
				</tr>
			</table>
			<p align="center" ><button id="sendData" type="button" class="btn1">送出资料</button></p>
		</form>
		<div style="margin:10px">
				注：<br/> 您所提供的资料，我们仅会基于您的申请事项之目的及范围，于业务所需执行期间，在本公司所在地区以合理方式，搜集、处理、利用您所留下之姓名、电话等个人资料，而在您点选「送出资料」时表示您对前述内容及本公司之隐私权保护声明已充分了解并同意
		</div>
	</div>
</body>
</html>
