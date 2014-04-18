<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<link rel="stylesheet" href="static/css/report/samplePDF.css" />
	<style type='text/css'>
		* { font-family: 'Microsoft JhengHei'; }
	</style>
</head>
<body>
	<#assign count1=1>
	<#assign pageNo=1>
	<#assign changePage=0>
	<#assign countNum=0>
	<h1 class="th0">使用者軌跡紀錄報表</h1>
	<br/>
    <div id="exeDetail" title="使用者軌跡紀錄報表查詢">
		<table class="table2">
			<tr>
				<th width="7%"><img src="static/images/emoticons/face.png"/></th>
				<th class="p1">使用者代號：${userId!}</th>
				<th class="p2">列印日期：${printDate!}</th>
			</tr>
			<tr>
				<th width="7%"><img src="static/images/emoticons/face.png"/></th>
				<th class="p1">資料範圍：${dataRange!}</th>
				<th class="p2">印表人員：${printer!}</th>
			</tr>
		</table>
		<table class="table1">
			<tr>
				<th class="th1">使用者</th>
				<th class="th1">IP</th>
				<th class="th3">作業代號</th>
				<th class="th2">功能</th>
				<th class="th1">執行時間</th>
			</tr>
			<#list mapList as data>
				<#assign countNum=countNum+1>
			<#if count1 <= 30 & pageNo <=1 >
				<tr>
					<td class="td1">${data.userId!}</td>
					<td class="td1">${data.ipAddress!}</td>
					<td class="td1">${data.funcName!}</td>
					<td class="td1">${data.actionName!}</td>
					<td class="td1" style="font-size:13px">${data.execDate!}</td>
				</tr>
				<#if count1==30>
					<p class="p3">第${pageNo}頁／共${totalPageNo!}頁</p>
				</#if>
				<#if mapList?size==countNum>
					<p class="p3">第${pageNo}頁／共${totalPageNo!}頁</p>
				</#if>
				<#assign count1=count1+1>
				<#if count1==30>
					<#assign changePage=1>
				</#if>
			<#elseif  count1 <= 35>
				<#if changePage == 1>
					<#assign pageNo=pageNo+1>
					<#assign count1=1>
					<p style="page-break-after:always;"> </p>
					<tr>
						<th class="th1">使用者</th>
						<th class="th1">IP</th>
						<th class="th3">作業代號</th>
						<th class="th2">功能</th>
						<th class="th1">執行時間</th>
					</tr>
				</#if>
				<#assign changePage=0>
				<#assign count1=count1+1>
				<tr>
					<td class="td1">${data.userId!}</td>
					<td class="td1">${data.ipAddress!}</td>
					<td class="td1">${data.funcName!}</td>
					<td class="td1">${data.actionName!}</td>
					<td class="td1" style="font-size:13px">${data.execDate!}</td>
				</tr>
				<#if mapList?size==countNum>
					<p class="p3">第${pageNo}頁／共${totalPageNo!}頁</p>
				</#if>
				<#if count1==35>
					<p class="p3">第${pageNo}頁／共${totalPageNo!}頁</p>
					<#assign changePage=1>
				</#if>
			</#if>
			</#list>
		</table>
		<br/>
	</div>
</body>
</html>
