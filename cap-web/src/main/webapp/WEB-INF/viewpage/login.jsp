<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=7" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BDQ青岛银行</title>
    </head>
    <body class="claro">
        <div style="margin: auto; width: 960px;">
            <form action="loginCheck" method="post">
                id : <input type="text" id="id" name="id" value="1234567890" />
                <br/>
                password:<input type="password" id="pssword" name="password" />
                <button type="submit">
                    submit
                </button>
            </form>
        </div>
    </body>
</html>
