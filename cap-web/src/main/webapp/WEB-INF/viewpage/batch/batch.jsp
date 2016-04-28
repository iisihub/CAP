<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title><spring:message code="tit.batch">
        <!--批次設定-->
    </spring:message></title>
</head>
<body>
    <ol>
        <li><a href="schedule">排程設定</a></li>
        <li><a href="jobs">排程Job清單</a></li>
        <li><a href="jobexecution">排程監控</a></li>
    </ol>
</body>
</html>
