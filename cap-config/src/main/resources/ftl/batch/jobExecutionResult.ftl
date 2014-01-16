<?xml version="1.0" encoding="UTF-8"?>
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
</head>
<body>
	<#assign table1="border-collapse:collapse;border-spacing:0;border:1px solid #AAAAAA;font-size:14px;width:100%;">
	<#assign th1="background-color:#FAFAFA;border:1px solid #AAAAAA;width:17%;text-align:right;padding:5px;">
	<#assign th2="background-color:#FAFAFA;border:1px solid #AAAAAA;text-align:center;padding:5px;">
	<#assign td1="border:1px solid #AAAAAA;padding:5px;">
    <div id="exeDetail" title="Job執行明細">
		<table style="${table1}">
			<tr>
				<th style="${th1}">排程代碼</th>
				<td style="${td1}">${JOB_NAME!}</td>
				<th style="${th1}">ID</th>
				<td style="${td1}">${JOB_EXECUTION_ID!}</td>
			</tr>
			<tr>
				<th style="${th1}">開始時間</th>
				<td style="${td1}">${START_TIME!}</td>
				<th style="${th1}">花費時間</th>
				<td style="${td1}">${duration!}</td>
			</tr>
			<tr>
				<th style="${th1}">啟動狀態</th>
				<td style="${td1}">${STATUS!}</td>
				<th style="${th1}">執行結果狀態</th>
				<td style="${td1}">${EXIT_CODE!}</td>
			</tr>
			<tr>
				<th style="${th1}">執行者</th>
				<td style="${td1}">${EXECUTOR!}</td>
				<th style="${th1}">Parent ID</th>
				<td style="${td1}">${JOB_INSTANCE_ID!}</td>
			</tr>
			<tr>
				<th style="${th1}">排程參數</th>
				<td style="${td1}" colspan="3">${jobParams!}</td>
			</tr>
			<tr>
				<th style="${th1}">執行結果資訊</th>
				<td style="${td1}" colspan="3">${EXIT_MESSAGE!}</td>
			</tr>
		</table>
		<br/>
		<table title="Step Execution Status" style="${table1}">
			<tr>
				<th style="${th2}">StepName</th>
				<th style="${th2}">Reads</th>
				<th style="${th2}">Writes</th>
				<th style="${th2}">Commits</th>
				<th style="${th2}">Rollbacks</th>
				<th style="${th2}">Duration</th>
				<th style="${th2}">Status</th>
			</tr>
			<#list stepInfos as step>
				<tr>
					<td style="${td1}">${step.STEP_NAME!}</td>
					<td style="${td1}" align="right">${step.READ_COUNT!}</td>
					<td style="${td1}" align="right">${step.WRITE_COUNT!}</td>
					<td style="${td1}" align="right">${step.COMMIT_COUNT!}</td>
					<td style="${td1}" align="right">${step.ROLLBACK_COUNT!}</td>
					<td style="${td1}">${step.duration!}</td>
					<td style="${td1}">${step.EXIT_CODE!}</td>
				</tr>
				<tr>
					<th style="${th2}">ExitMessage</th>
					<td style="${td1}" colspan="6">${step.EXIT_MESSAGE!}</td>
				</tr>
			</#list>
		</table>
	</div>
</body>
</html>
