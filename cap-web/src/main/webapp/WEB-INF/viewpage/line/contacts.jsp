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
            <button id="sendMsg" type="button" class="btn1">
                <spring:message code="btn.sendmsg">
                    <!--傳送訊息-->
                </spring:message>
            </button>
            <button id="broadcast" type="button" class="btn1">廣播</button>
            <button id="retrive" type="button" class="btn1">重新取得資訊</button>
        </div>
        <div id="gridview"></div>
        <!-- dialog start-->
        <!--Start : send-->
        <div id="send" style="display: none">
            <form id="sendForm">
                <input type="hidden" id="mid" name="mid" />
                <table class="tb2">
                    <tbody>
                        <tr>
                            <td width="30%" class="hd1"><span class="color-red">＊</span>訊息</td>
                            <td width="70%"><textarea rows="4" cols="50" id="msg" name="msg" class="validate[required]" data-prompt-position="bottomLeft:0"></textarea></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <!-- dialog end-->
    </div>
</body>
</html>
