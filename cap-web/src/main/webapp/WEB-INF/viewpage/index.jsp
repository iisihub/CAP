<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
</head>
<body>
	<input type="file" id="ufile" name="ufile" />
	<button id="upload" type="button" class="btn1">
		<spring:message code="btn.upload">
			<!--上傳-->
		</spring:message>
	</button>
	<button id="dwnload" type="button" class="btn1">
		<spring:message code="btn.dwnload">
			<!--下載-->
		</spring:message>
	</button>
	<!-- <script type="text/javascript" src="../static/js/page/ifile.js"></script> -->
	<script type="text/javascript">
	
		loadScript('../static/js/page/ifile.js');
		loadScript('../static/js/page/loadPageSample.js');
	</script>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br /> page-link
	<input type="text" id="page" name="page" value="system/codetype" />
	<button id="loadcodetype" type="button" class="bt1">Load</button>
	<script type="text/javascript">
		
	</script>
</body>
</html>
