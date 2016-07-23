<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="contacts.title">
    </spring:message></title>
</head>
<body>
    <script>
          loadScript('js/line/contacts');
        </script>
    <div>
        <div class="btns">
            <button id="delete" type="button" class="btn1">
                <spring:message code="btn.sendmsg">
                    <!--傳送訊息-->
                </spring:message>
            </button>
        </div>
        <div id="gridview"></div>
        <!-- dialog start-->
        <!--Start : send-->
        <div id="send" style="display: none">
            <form id="sendForm">
                <table class="tb2" width="99%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    </tbody>
                </table>
            </form>
        </div>
        <!-- dialog end-->
    </div>
</body>
</html>
