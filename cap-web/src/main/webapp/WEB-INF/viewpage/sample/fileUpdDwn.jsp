<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="tit.fileUpdDwn">
        <!--語系-->
    </spring:message></title>
</head>
<body>
    <script>
          loadScript('js/sample/ifile');
        </script>
    <spring:message code="fileInput">
        <!--檔案名稱-->
    </spring:message>
    :
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
    <button id="dwnloadPdf" type="button" class="btn1">
        <spring:message code="btn.dwnload">
            <!--下載-->
        </spring:message>
        PDF
    </button>
</body>
</html>
