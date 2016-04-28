<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="tit.schedule">
        <!--排程設定-->
    </spring:message></title>
</head>
<body>
    <script>
          loadScript('js/batch/schedule');
        </script>
    <div>
        <div class="btns">
            <button id="qry" type="button" class="btn1">
                <spring:message code="btn.query">
                    <!--查詢-->
                </spring:message>
            </button>
            <button id="add" type="button" class="btn1">
                <spring:message code="btn.add">
                    <!--新增-->
                </spring:message>
            </button>
            <button id="delete" type="button" class="btn1">
                <spring:message code="btn.delete">
                    <!--刪除-->
                </spring:message>
            </button>
        </div>
        <div id="gridview"></div>
        <div id="qryDailog" class="hide" title="<spring:message code="btn.query" />">
            <form id="qform" onsubmit="return false;">
                <table class="row-data">
                    <tr>
                        <th><spring:message code="js.schId">
                                <!--排程代碼-->
                            </spring:message></th>
                        <td><input type="text" id="schId" name="schId" maxlength="80" /></td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="editDialog" class="hide" title="<spring:message code="jobs.editDialog" />">
            <form id="mform" onsubmit="return false;">
                <table class="row-data">
                    <tr>
                        <th><spring:message code="js.schId">
                                <!--排程代碼-->
                            </spring:message></th>
                        <td><input type="text" id="schId" name="schId" maxlength="80" class="validate[required]" /></td>
                    </tr>
                    <tr>
                        <th><spring:message code="js.schDesc">
                                <!--說明-->
                            </spring:message></th>
                        <td><input type="text" id="schDesc" name="schDesc" size="70" maxlength="300" class="validate[funcCall[maxUTF8[300]]]" /></td>
                    </tr>
                    <tr>
                        <th><spring:message code="sch.jobId">
                                <!--JOB代碼-->
                            </spring:message></th>
                        <td><select id="jobId" name="jobId">
                                <c:forEach items="${batchJob}" var="job">
                                    <option value="<c:out value="${job.jobId}"/>"><c:out value="${job.jobId}" />-
                                        <c:out value="${job.jobDesc}" /></option>
                                </c:forEach>
                        </select></td>
                    </tr>
                    <tr>
                        <th><spring:message code="js.isenable">
                                <!--是否啟用-->
                            </spring:message></th>
                        <td><label><input type="radio" id="isEnabled" name="isEnabled" value="Y" /> <spring:message code="js.yes" /></label> <label><input type="radio" id="isEnabled"
                                name="isEnabled" value="N" checked="checked" /> <spring:message code="js.no" /></label></td>
                    </tr>
                    <tr>
                        <th><spring:message code="sch.exeHost">
                                <!--執行主機-->
                            </spring:message></th>
                        <td><select id="exeHost" name="exeHost">
                                <c:forEach items="${schExeHost}" var="eh">
                                    <option value="<c:out value="${eh.key}"/>"><c:out value="${eh.value}" /></option>
                                </c:forEach>
                        </select></td>
                    </tr>
                    <tr>
                        <th><spring:message code="sch.jobData">
                                <!--執行參數-->
                            </spring:message></th>
                        <td><textarea id="jobData" name="jobData" cols="70" rows="2" maxlength="2000" class="validate[funcCall[maxUTF8[2000]]]"></textarea><br /> Ex.key=value,key2=value2</td>
                    </tr>
                    <tr>
                        <th><spring:message code="sch.priority">
                                <!--優先順序-->
                            </spring:message></th>
                        <td><input type="text" id="priority" name="priority" value="5" size="5" maxlength="10" class="integer" /></td>
                    </tr>
                    <tr>
                        <th><spring:message code="js.schType">
                                <!--類別-->
                            </spring:message></th>
                        <td><label><input type="radio" id="schType" name="schType" value="C" checked="checked" /> <spring:message code="sch.schType.C" /></label> <label><input
                                type="radio" id="schType" name="schType" value="T" /> <spring:message code="sch.schType.T" /></label></td>
                    </tr>
                    <tr class="schTypeC show">
                        <th><spring:message code="sch.cronExpression">
                                <!--執行週期-->
                            </spring:message></th>
                        <td><input type="text" id="cronExpression" name="cronExpression" size="30" maxlength="120" />(<a target="_blank"
                            href="http://docs.oracle.com/cd/E12058_01/doc/doc.1014/e12030/cron_expressions.htm"><spring:message code="js.explain" /></a>)</td>
                    </tr>
                    <tr class="schTypeC show">
                        <th><spring:message code="sch.timeZoneId">
                                <!--時區代碼-->
                            </spring:message></th>
                        <td><select id="timeZoneId" name="timeZoneId">
                                <c:forEach items="${timeZoneId}" var="tz">
                                    <option value="<c:out value="${tz.key}"/>"><c:out value="${tz.value}" /></option>
                                </c:forEach>
                        </select></td>
                    </tr>
                    <tr class="schTypeT hide">
                        <th><spring:message code="sch.repeatInterval">
                                <!--時間區間-->
                            </spring:message></th>
                        <td><input type="text" id="repeatInterval" name="repeatInterval" size="10" maxlength="10" class="integer" /> <spring:message code="js.second">
                                <!--秒-->
                            </spring:message></td>
                    </tr>
                    <tr class="schTypeT hide">
                        <th><spring:message code="sch.repeatCount">
                                <!--重覆次數-->
                            </spring:message></th>
                        <td><input type="text" id="repeatCount" name="repeatCount" size="10" maxlength="10" value="0" class="integer" /></td>
                    </tr>
                    <tr>
                        <th><spring:message code="sch.isNotify">
                                <!--e-mail通知-->
                            </spring:message></th>
                        <td><label><input type="radio" id="isNotify" name="isNotify" value="Y" /> <spring:message code="js.yes" /></label> <label><input type="radio" id="isNotify"
                                name="isNotify" value="N" checked="checked" /> <spring:message code="js.no" /></label></td>
                    </tr>
                    <tr class="notify hide">
                        <th><spring:message code="js.sch.jobExitCode">
                                <!--JOB執行結果-->
                            </spring:message></th>
                        <td><c:forEach items="${jobExitCode}" var="st">
                                <label><input type="checkbox" id="notifyStatus" name="notifyStatus" value="<c:out value="${st.key}"/>" /> <c:out value="${st.value}" /></label>
                            </c:forEach></td>
                    </tr>
                    <tr class="notify hide">
                        <th><spring:message code="js.mailto">
                                <!--收信人-->
                            </spring:message></th>
                        <td><textarea id="notifyTo" name="notifyTo" cols="70" rows="2" maxlength="200" class="validate[funcCall[maxUTF8[200]]]"></textarea><br /> <spring:message
                                code="js.CommaSeparate" /></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
