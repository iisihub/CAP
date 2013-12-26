<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="org.springframework.security.core.AuthenticationException"%>
<%@ page import="org.springframework.security.web.WebAttributes" %>

 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="decorator" content="none">
        <link rel="stylesheet" href="../static/css/main.css" />
        <title>cap login</title>
    </head>
    <body class="claro">
    	<div style="margin: auto; width: 960px;">
            <form action="../j_spring_security_check" method="post">
                id : <input type="text" id="j_username" name="j_username" />
                <br/>
                <!-- password:<input type="password" id="j_pssword" name="j_password" /> -->
                <button type="submit">
                    submit
                </button>
            </form>
        </div>
        <div class="text-red">
        	<%= session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION)!=null?((AuthenticationException) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION)).getLocalizedMessage():"" %>
        </div>
    </body>
</html>
