<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title><decorator:title default="CapWebMVC" /></title>
<link rel="stylesheet" href="../static/css/main.css" />
<link rel="stylesheet" href="../static/css/menu.css" />
<!--[if lt IE 9]>
            <script src="../static/lib/js/html5.js"></script>
        <![endif]-->
<script src="../static/requirejs/2.0.6/require.min.js"></script>
<script src="../static/main.js"></script>
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
		<nav class="top">
			<ul class="block"></ul>
			<ul class="navmenu">
				<!-- 	<li><a href="index">關於我們</a></li>
                	<li><a href="system/system">系統設定</a></li>
                	<li><a href="sample/sample">範例交易</a></li>
                	<li><a href="batch/batch">排程管理</a></li>
                	 -->
			</ul>
		</nav>
		<div class="clear"></div>
		<div class="main">
			<nav class="sub">
				<ol>
					<li><a href="fileUpdDwn">檔案上下傳</a></li>
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
