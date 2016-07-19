<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta name="decorator" content="none">
<link rel="stylesheet" href="../static/lib/js/jquery/plugin/sceditor/themes/modern.min.css" type="text/css" media="all" />
<title>ProtoTyping Editor</title>
</head>
<body>
    <script>
          loadScript('js/sample/sceditor_example');
        </script>
    <button id="ok" type="button" class="btn1">ok</button>
    <button id="reset" type="button" class="btn1">reset</button>
    <div class="preview">
        <div class="script"></div>
    </div>
    <hr>
    <div>
        <textarea id="tt" name="tt" style="height: 280px; width: 730px;">
<div id='gridview'>&nbsp;</div>
 <script>
    var grid = $('#gridview').jqGrid({
      url : 'webroot/codetypehandler/query',
      sortname : 'codeType',
      sortorder : 'desc',
      height : 250,
      colModel : [ {
        name : 'oid',
        hidden : true
      }, {
        header : 'A',
        name : 'codeType',
        width : 110,
        align : 'center'
      }, {
        header : 'B',
        name : 'codeValue',
        width : 80,
        align : 'center'
      }, {
        header : 'C',
        name : 'codeDesc',
        width : 80,
        align : 'center'
      }, {
        header : 'D',
        name : 'codeOrder',
        width : 80,
        align : 'center'
      }, {
        header : 'E',
        name : 'updater',
        width : 80,
        align : 'center'
      }, {
        header : 'F',
        name : 'updateTime',
        width : 80,
        align : 'center'
      } ],
      onSelectRow : function() {
        var ret = grid.getSelRowDatas();
        if (ret)
          mform.injectData(ret);
      }
    });
  </script>
			</textarea>
        <p>If you are using IE9+ or any other browser then it should automatically replace :) and other emoticon codes with theit emoticon images.</p>
    </div>
    <p>
        SCEditor is licensed under the <a href="http://www.opensource.org/licenses/mit-license.php">MIT</a>
    </p>
</body>
</html>
