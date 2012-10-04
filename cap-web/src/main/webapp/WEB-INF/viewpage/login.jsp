<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=7" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="decorator" content="none">
        <title>cap login</title>
    </head>
    <body class="claro">
        <div style="margin: auto; width: 960px;">
            <form action="../j_spring_security_check" method="post">
                id : <input type="text" id="j_username" name="j_username" value="1234567890" />
                <br/>
                password:<input type="password" id="j_password" name="j_password" />
                <button type="submit">
                    submit
                </button>
            </form>
        </div>
        <h2>${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</h2>
    </body>
</html>
