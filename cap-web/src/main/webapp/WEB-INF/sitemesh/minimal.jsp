<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" href="../../static/css/main.css" />
<link rel="stylesheet" href="../../static/lib/css/common.message.css" />
<!-- common.message (iLog) -->
<script type="text/javascript">
  var baseUrl = "../../static";
</script>
<script src="../../static/requirejs/2.0.6/require.min.js"></script>
<script src="../../static/main.js"></script>
<decorator:getProperty property="reqJSON" default="" />
<decorator:head />
</head>
<body>
    <div class="mainBody">
        <header>
            <div class="logo">
                <a><img src="../static/images/logo.png"></a>
            </div>
            <ol style="height: 18px;">
                <li class="lang"><a href="#language">&nbsp;LANGUAGE&nbsp;</a></li>
                <li>&nbsp;-<a href="?lang=zh_TW">&nbsp;正體&nbsp;</a></li>
                <li>&nbsp;-<a href="?lang=zh_CN">&nbsp;简体&nbsp;</a></li>
                <li>&nbsp;-<a href="?lang=en">&nbsp;ENGLISH&nbsp;</a></li>
            </ol>
        </header>
        <decorator:body />
        <div class="clear"></div>
        <footer>
            <div class="copyright">資拓宏宇國際股份有限公司 © 2012 版權所有</div>
        </footer>
        <div class="bg-around right">&nbsp;</div>
        <div class="bg-around left">&nbsp;</div>
    </div>
</body>
</html>