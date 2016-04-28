<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="ruleTb.title">
        <!--語系-->
    </spring:message></title>
</head>
<body>
    <script>
          loadScript('js/division/ruleTbMnt');
        </script>
    <div>
        <div class="btns" colspan="4" style="text-align: right">
            <button id="qry" type="button" class="btn1">
                <spring:message code="btn.query">
                    <!--查詢-->
                </spring:message>
            </button>
            <button id="add" type="button" class="btn1">
                <spring:message code="btn.add">
                    <!--新增-->
                </spring:message>
            </button>
            <button id="modify" type="button" class="btn1">
                <spring:message code="btn.modify">
                    <!--修改-->
                </spring:message>
            </button>
            <button id="delete" type="button" class="btn1">
                <spring:message code="btn.delete">
                    <!--刪除-->
                </spring:message>
            </button>
        </div>
        <div id="gridview"></div>
    </div>
</body>
</html>