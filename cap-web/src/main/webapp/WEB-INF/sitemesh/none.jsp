<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<html>
    <head>
        <title><decorator:title/></title>
        <decorator:getProperty property="i18n" default="" />
    </head>
    <body>
        <decorator:body/>
    </body>
</html>
