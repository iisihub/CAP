<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="tit.jobs">
        <!--批次清單-->
    </spring:message></title>
</head>
<body>
    <script>
          loadScript('js/batch/jobs');
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
            <button id="jobLoad" type="button" class="btn1">
                <spring:message code="btn.jobLoad">
                    <!--重新註冊-->
                </spring:message>
            </button>
            <button id="jobExe" type="button" class="btn1">
                <spring:message code="btn.jobExecute">
                    <!--手動執行-->
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
                </table>
            </form>
        </div>
        <div id="editDialog" class="hide" title="<spring:message code="jobs.editDialog" />">
            <form id="mform" onsubmit="return false;">
                <table class="row-data">
                    <tr>
                        <th><spring:message code="js.jobId">
                                <!--排程代碼-->
                            </spring:message></th>
                        <td><input type="text" id="jobId" name="jobId" maxlength="32" class="validate[required]" /></td>
                    </tr>
                    <tr>
                        <th><spring:message code="js.jobResource">
                                <!--Job設定檔路徑-->
                            </spring:message></th>
                        <td><span id="jobsRoot"></span><input type="text" id="jobResource" name="jobResource" size="70" maxlength="100" class="validate[required]" /></td>
                    </tr>
                    <tr>
                        <th><spring:message code="js.jobDesc">
                                <!--說明-->
                            </spring:message></th>
                        <td><textarea id="jobDesc" name="jobDesc" cols="70" rows="2" maxlength="300" class="validate[required,funcCall[maxUTF8[300]]]"></textarea></td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="exeDailog" class="hide" title="<spring:message code="btn.jobExecute" />">
            <form id="exeform" onsubmit="return false;">
                <table class="row-data">
                    <tr>
                        <th><spring:message code="js.jobId">
                                <!--排程代碼-->
                            </spring:message></th>
                        <td><span class="filed" id="exeJobId"></span></td>
                    </tr>
                    <tr>
                        <th><spring:message code="label.jobParameter">
                                <!--排程參數-->
                            </spring:message><br /> <br /></th>
                        <td><textarea id="jobParams" name="jobParams" cols="50" rows="4" maxlength="1000" class="validate[funcCall[maxUTF8[1000]]]"></textarea>
                            <div class="memo">
                                keyA=valueA<br />keyB=valueB
                            </div>
                            <button id="jglp" type="button" class="btn1">
                                <spring:message code="btn.jobGetLastParam">
                                    <!--取得最後一次的執行參數-->
                                </spring:message>
                            </button></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
