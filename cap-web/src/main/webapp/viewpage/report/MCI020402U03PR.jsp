<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
    <head>
        <title>营销策略「${tacticsName}」启用内容说明</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="webroot/css/yui_reset.css" />
        <!--[if lt IE 9]>
            <script src="webroot/js/html5.js"></script>
        <![endif]--><style>
            @page {
                size: A4 landscape;
            }
            
            .main {
                width: 210mm;
                height: 297mm;
                margin: 0 auto;
                border: #AAA 1px solid;
            }
            
            section {
                margin: 20px;
            }
            
            section, .field-row {
                display: block;
                width: 100%;
            }
            
            .field-row {
                padding: 12px 0;
            }
            
            .field-th, .field-td {
                display: inline-block;
                width: 22%;
                /* border: #AAA 1px solid;*/
                vertical-align: top;
            }
            
            .field-th {
                text-align: right;
                padding-right: 10px;
            }
            
            .field-td {
                text-align: left;
            }
            
            table {
                width: 195mm;
            }
            
            table tr.tb-title {
                font-weight: bold;
            }
            
            table tr {
                text-align: center;
            }
            
            table, td, tr {
                border: #000 1px solid;
            }
            
            table td {
                padding: 2px 5px;
            }
        </style>
    </head>
    <body>
        <div class="main">
            <section>
                <div class="field-row">
                    <span class="field-th">策略名称：</span>
                    <span class="field-td">${tacticsName}</span>
                    <span class="field-th">策略编号：</span>
                    <span class="field-td">${tacticsNbr}</span>
                </div>
                <div class="field-row">
                    <span class="field-th">策略描述：</span>
                    <span class="field-td"><pre>${tacticsDesc}</pre></span>
                </div>
                <div class="field-row">
                    <span class="field-th">上架时间：</span>
                    <span class="field-td">${startDt}</span>
                    <span class="field-th">下架时间：</span>
                    <span class="field-td">${endDt}</span>
                </div>
                <div class="field-row">
                    <span class="field-th">营销商品一级类别：</span>
                    <span class="field-td">${oneCatgy}</span>
                    <span class="field-th">营销商品二级类别：</span>
                    <span class="field-td">${twoCatgy}</span>
                </div>
                <div class="field-row">
                    <span class="field-th">营销商品三级类别：</span>
                    <span class="field-td">${threeCatgy}</span>
                </div>
                <div class="field-row">
                    <span class="field-th">营销商品名称：</span>
                    <span class="field-td">${commName}</span>
                    <span class="field-th">商品适合客户类型：</span>
                    <span class="field-td">${commType}</span>
                </div>
                <div class="field-row">
                    <span class="field-th">营销模式：</span>
                    <span class="field-td">${purpNbr}</span>
                </div>
                <div class="field-row">
                    <span class="field-th">营销主页：</span>
                    <span class="field-td">${mktUrl}</span>
                </div>
                <div class="field-row">
                    <span class="field-th">入口素材类型：</span>
                    <span class="field-td">${mktMatlType}</span>
                </div>
                <div class="field-row">
                    <c:choose>
                        <c:when test="${mktMatlTypeNbr == '1'}">
                            <div class="field-row">
                                <span class="field-th">内容：</span>
                                <span class="field-td">${mktMatl}</span>
                            </div>
                        </c:when>
                        <c:when test="${mktMatlTypeNbr == '2'}">
                            <div class="field-row">
                                <img border="0" width="677px" height="95px" src="${mktMatl}"/>
                            </div>
                        </c:when>
                        <c:when test="${mktMatlTypeNbr == '3'}">
                            <div class="field-row">
                                <img border="0" width="150px" height="120px" src="${mktMatl}"/>
                            </div>
                        </c:when>
                        <c:when test="${mktMatlTypeNbr == '4'}">
                            <div class="field-row">
                                <object classid='clsid:D27CDB6E-AE6D-11cf-96B8-444553540000 codebase='http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0'  width='500px' height='300px' id='myMovieName'>
                                    <embed src='${mktMatl}' quality='high' pluginspage='http://www.macromedia.com/go/getflashplayer' type='application/x-shockwave-flash' width='500px' height='300px'>
                                    </embed>
                                </object>
                                <img border="0" width="500px" height="300px" src="${mktMatl}"/>
                            </div>
                        </c:when>
                    </c:choose>
                </div>
            </section>
            <section>
                <table>
                    <tr class="tb-title">
                        <td>
                            条件类别
                        </td>
                        <td>
                            主条件
                        </td>
                        <td>
                            筛选方式
                        </td>
                        <td>
                            起始区间
                        </td>
                        <td>
                            结束区间
                        </td>
                    </tr>
                    <c:forEach items="${mktFilters}" var="mf">
                        <tr>
                            <td>
                                ${mf.filterTypeNbr}
                            </td>
                            <td>
                                ${mf.mainFilter}
                            </td>
                            <td>
                                ${mf.filterMode}
                            </td>
                            <td>
                                ${mf.begVal}
                            </td>
                            <td>
                                ${mf.endVal}
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </section>
            <section>
                <div class="field-row">
                    <span class="field-th">优惠积分描述：</span>
                    <span class="field-td"><pre>${benfDesc}</pre></span>
                </div>
                <div class="field-row">
                    <span class="field-th">营销策略挂载渠道：</span>
                    <span class="field-td">${chls}</span>
                </div>
                <div class="field-row">
                    <span class="field-th">营销策略挂载场景：</span>
                    <span class="field-td">${drivTrd}</span>
                    <span class="field-th">营销策略营销点：</span>
                    <span class="field-td">${mktPt}</span>
                </div>
                <div class="field-row">
                    <span class="field-th">营销机会处理渠道：</span>
                    <span class="field-td">${forwardChlNbr}</span>
                </div>
            </section>
        </div>
    </body>
</html>
