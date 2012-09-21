<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    </head>
    <body>
        index
        <input type="file" id="ufile" name="ufile" />
        <button id="upload" type="button" class="btn1">
             <spring:message code="btn.upload">
                 <!--上傳-->
             </spring:message>
         </button>
         <script type="text/javascript" src="../static/js/page/ss.js"></script>
    </body>
</html>
