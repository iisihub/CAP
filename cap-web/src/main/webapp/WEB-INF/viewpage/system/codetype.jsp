<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        
    </head>
    <body>
    <script type="text/javascript" src="webroot/static/js/page/codetype.js">
            //require(['webroot/js/page/codetype']);
        </script>
        <div ng-controller="codetypeCtrl">
            <form id="mform" onsubmit="return false;">
                <!--<fieldset class="row">--><input type="text" id="oid" name="oid" class="hide" /><input type="text" id="mtype" name="mtype" class="hide" />
                <table class="row-data">
                    <tr>
                        <th>
                            <spring:message code="codetype.codeType">
                                <!--代碼-->
                            </spring:message>
                        </th>
                        <td>
                            <input type="text" id="cdeType" name="cdeType" maxlength="32" class="validate[required,funcCall[maxUTF8[32]]]" ng-model="todo" value="{{mmm}}"/>
                        </td>
                        <th>
                            <spring:message code="codetype.codeVal">
                                <!--值-->
                            </spring:message>
                        </th>
                        <td>
                            <input type="text" id="cdeVal" maxlength="48" name="cdeVal" class="validate[required,funcCall[maxUTF8[48]]]" />
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <spring:message code="codetype.codeDesc">
                                <!--描述-->
                            </spring:message>
                        </th>
                        <td>
                            <input type="text" id="cdeDesc" name="cdeDesc" maxlength="100" class="validate[funcCall[maxUTF8[100]]]"/>
                        </td>
                        <th>
                            <spring:message code="codetype.codeOrder">
                                <!--排序-->
                            </spring:message>
                        </th>
                        <td>
                            <input type="text" id="cdeOrd" name="cdeOrd" maxlength="3" size="3" class="validate[required,custom[integer],funcCall[maxUTF8[3]]] numeric" />
                        </td>
                    </tr>
                </table><!--</fieldset>-->
            </form>
            <div class="btns" colspan="4" style="text-align:right">
                <button id="add" type="button" class="btn1">
                    <spring:message code="btn.add">
                        <!--新增-->
                    </spring:message>
                </button>
                <button id="modify" type="button" class="btn1">
                    <spring:message code="btn.modify">
                        <!--修改-->
                    </spring:message>
                </button>
                <button id="delete" type="button" class="btn1">
                    <spring:message code="btn.delete">
                        <!--刪除-->
                    </spring:message>
                </button>
                <button id="clear" type="button" class="btn1">
                    <spring:message code="btn.clear">
                        <!--清除-->
                    </spring:message>
                </button>
            </div>
            <div id="gridview" />
        </div>
    </body>
</html>