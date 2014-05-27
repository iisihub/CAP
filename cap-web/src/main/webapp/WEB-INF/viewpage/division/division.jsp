<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title><spring:message code="mu.division"><!--分案管理--></spring:message></title>
</head>
<body>
	<ol>
   		<li><a href="division/groupStng">群組設定</a></li>
   		<li><a href="division/factorMnt">因子維護</a></li>
   		<li><a href="division/conditionMnt">條件維護</a></li>
   		<li><a href="division/ruleTbMnt">規則維護</a></li>
   		<li><a href="division/batchMnt">計劃維護</a></li>
   	</ol>
</body>
</html>
