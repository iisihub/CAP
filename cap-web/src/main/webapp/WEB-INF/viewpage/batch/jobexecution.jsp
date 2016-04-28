<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="tit.jobexecution">
        <!--排程監控-->
    </spring:message></title>
</head>
<body>
    <script>
          loadScript('js/batch/jobexecution');
        </script>
    <div>
        <div class="btns">
            <button id="qry" type="button" class="btn1">
                <spring:message code="btn.query">
                    <!--查詢-->
                </spring:message>
            </button>
            <button id="jobDetail" type="button" class="btn1">
                <spring:message code="btn.viewDetail">
                    <!--執行明細-->
                </spring:message>
            </button>
            <button id="jobStop" type="button" class="btn1">
                <spring:message code="btn.jobStopRun">
                    <!--中斷執行-->
                </spring:message>
            </button>
            <button id="jobRestart" type="button" class="btn1">
                <spring:message code="btn.jobRestart">
                    <!--重新啟動-->
                </spring:message>
            </button>
        </div>
        <div id="gridview"></div>
        <div id="qryDailog" class="hide" title="<spring:message code="btn.query" />">
            <form id="qform" onsubmit="return false;">
                <table class="row-data">
                    <tr>
                        <th><spring:message code="js.jobId">
                                <!--排程代碼-->
                            </spring:message></th>
                        <td><input type="text" id="jobId" name="jobId" maxlength="32" /></td>
                    </tr>
                    <tr>
                        <th><spring:message code="js.sch.jobExitCode">
                                <!--JOB執行結果-->
                            </spring:message></th>
                        <td><select id="jobExitCode" name="jobExitCode" combokey="jobExitCode" space="true" comboType="2"></select></td>
                    </tr>
                    <tr>
                        <th><spring:message code="js.startTime">
                                <!--開始時間-->
                            </spring:message></th>
                        <td><input type="text" id="startDate" name="startDate" class="date" />&nbsp; <input type="text" id="startTime" name="startTime" class="time" size="7" maxlength="5"
                            value="00:00" /></td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="exeDetailDialog" class="hide" title="<spring:message code="btn.viewDetail" />">
            <form id="jdform" onsubmit="return false;">
                <table class="row-data">
                    <tr>
                        <th><spring:message code="js.jobId">
                                <!--排程代碼-->
                            </spring:message></th>
                        <td><span id="JOB_NAME"></span></td>
                        <th>ID</th>
                        <td><span id="JOB_EXECUTION_ID"></span></td>
                    </tr>
                    <tr>
                        <th><spring:message code="js.startTime">
                                <!--開始時間-->
                            </spring:message></th>
                        <td><span id="START_TIME"></span></td>
                        <th><spring:message code="js.duration">
                                <!--花費時間-->
                            </spring:message></th>
                        <td><span id="duration" class="field"></span></td>
                    </tr>
                    <tr>
                        <th><spring:message code="js.sch.jobStatus">
                                <!--JOB執行狀態-->
                            </spring:message></th>
                        <td><select id="jobStatus" name="jobStatus" combokey="jobStatus" space="true" disabled="disabled" comboType="2"></select></td>
                        <th><spring:message code="js.sch.jobExitCode">
                                <!--JOB執行結果-->
                            </spring:message></th>
                        <td><select id="EXIT_CODE" name="EXIT_CODE" combokey="jobExitCode" space="true" disabled="disabled" comboType="2"></select></td>
                    </tr>
                    <tr>
                        <th><spring:message code="js.executor">
                                <!--執行者-->
                            </spring:message></th>
                        <td><span id="EXECUTOR"></span></td>
                        <th>Parent ID</th>
                        <td><span id="JOB_INSTANCE_ID"></span></td>
                    </tr>
                    <tr>
                        <th><spring:message code="label.jobParameter">
                                <!--排程參數-->
                            </spring:message></th>
                        <td colspan="3"><textarea id="jobParams" name="jobParams" cols="70" rows="2" readonly="readonly"></textarea></td>
                    </tr>
                    <tr class="hide">
                        <th><spring:message code="label.otherMessage">
                                <!--其它資訊-->
                            </spring:message></th>
                        <td colspan="3"><textarea id="exitMessage" name="exitMessage" cols="70" rows="2" readonly="readonly"></textarea></td>
                    </tr>
                </table>
            </form>
            <div id="jobDetailgrid"></div>
        </div>
    </div>
</body>
</html>
