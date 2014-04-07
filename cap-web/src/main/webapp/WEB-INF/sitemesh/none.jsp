<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<html>
<head>
<title><decorator:title /></title>
<style>
	html { display:none; } 
</style>
<script>
	if (self == top) {
		document.documentElement.style.display = 'block';
	} else {
		top.location = self.location;
	}
</script>
<decorator:getProperty property="i18n" default="" />
<decorator:head />
</head>
<body>
	<decorator:body />
</body>
</html>
