<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="tit.webSocket">
        <!--語系-->
    </spring:message></title>
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
</style>
</head>
<body>
    <script>
          loadScript('js/sample/websocket');
        </script>
    <style>
body {
  padding: 20px;
}

#console {
  height: 400px;
  overflow: auto;
}

.username-msg {
  color: orange;
}

.connect-msg {
  color: green;
}

.disconnect-msg {
  color: red;
}

.send-msg {
  color: #888
}
</style>
    <script>
          
        </script>
    <h1>Netty-socketio Demo Chat</h1>
    <br />
    <div id="console" class="well"></div>
    <form onsubmit="return false;">
        <input id="msg" class="input-xlarge" type="text" placeholder="Type something..." />
        <button type="button" id="send" class="btn">Send</button>
        <button type="button" id="disconnect" class="btn">Disconnect</button>
    </form>
</body>
</body>
</html>
