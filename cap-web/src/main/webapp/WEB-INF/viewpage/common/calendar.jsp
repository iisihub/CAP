<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="form">
<title><spring:message code="calendar.title"></spring:message></title>
<link href='../../static/lib/css/calendar/fullcalendar.css' rel='stylesheet' />
<style>
#detect {
  padding: 5px;
  background: #ffc0cb;
  border-radius: 5px;
  border: 1px solid #CCC;
  margin-top: 10px;
}

#input {
  border-radius: 2px;
  border: 1px solid #ccc;
  margin-top: 10px;
  padding: 5px;
  width: 400px;
}

#status {
  width: 88px;
  display: block;
  float: left;
  margin-top: 15px;
}

#calendar {
  width: 900px;
  margin: 0 auto;
}
</style>
</head>
<body>
    <script>
          loadScript('js/common/calendar');
        </script>
    <br />
    <div id='calendar'></div>
</body>
</html>
