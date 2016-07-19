<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title><decorator:title default="CapWebMVC" /></title>
<link rel="stylesheet" href="../static/css/main.css" />
<link rel="stylesheet" href="../static/css/menu.css" />
<link rel="stylesheet" href="../static/lib/css/common.message.css" />
<!-- common.message (iLog) -->
<!--[if lt IE 9]>
            <script src="../static/lib/js/html5.js"></script>
        <![endif]-->
<script>
  var baseUrl = "../static";
</script>
<script src="../static/requirejs/2.0.6/require.min.js"></script>
<script src="../static/main.js"></script>
<decorator:getProperty property="prop" default="" />
<decorator:head />
</head>
<body>
    <script>
          // loadScript('js/common/cust.socket');
        </script>
    <div class="mainBody">
        <header>
            <div class="logo">
                <a><img src="../static/images/logo.png"></a>
            </div>
            <ol style="height: 18px; width: 35px; right: 140px;">
                <li class="lang"><a href="../j_spring_security_logout">登出</a></li>
            </ol>
            <ol style="height: 18px;">
                <li class="lang"><a href="#language">&nbsp;LANGUAGE&nbsp;</a></li>
                <li>&nbsp;-<a href="?lang=zh_TW">&nbsp;正體&nbsp;</a></li>
                <li>&nbsp;-<a href="?lang=zh_CN">&nbsp;简体&nbsp;</a></li>
                <li>&nbsp;-<a href="?lang=en">&nbsp;ENGLISH&nbsp;</a></li>
            </ol>
            <ol style="height: 18px; width: 35px; right: 140px;">
                <li class="lang"><a href="../j_spring_security_logout">登出</a></li>
            </ol>
        </header>
        <nav class="top">
            <ul class="block"></ul>
            <ul class="navmenu"></ul>
        </nav>
        <div class="clear"></div>
        <div class="main">
            <nav class="sub">
                <ol>
                </ol>
            </nav>
            <article id="article"></article>
        </div>
        <div class="clear"></div>
        <footer>
            <div class="copyright">資拓宏宇國際股份有限公司 © 2012 版權所有</div>
        </footer>
        <div class="bg-around right">&nbsp;</div>
        <div class="bg-around left">&nbsp;</div>
    </div>
</body>
</html>
