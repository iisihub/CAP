<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="captcha.title">
        <!--語系-->
    </spring:message></title>
<style>
</style>
</head>
<body>
    <script>
          loadScript('js/sample/captcha');
        </script>
    <h1>Captcha Demo Chat</h1>
    <br />
    <form onsubmit="return false;">
        <input id="captcha" name="captcha" class="captcha" type="text" />
        <button id="submit">
            <spring:message code="captcha.001">
                <!-- 驗証 -->
            </spring:message>
        </button>
    </form>
</body>
</body>
</html>
