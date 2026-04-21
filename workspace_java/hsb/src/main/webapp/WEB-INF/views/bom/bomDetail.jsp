<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>BOM 상세</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<%
    Map<String,Object> row = (Map<String,Object>) request.getAttribute("bom");
%>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "BOM 상세"); request.setAttribute("pageSubTitle", "BOM 상세 정보를 확인하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <table class="detail-table">
                    <tr><th>BOM ID</th><td><%= row.get("bomId") %></td></tr><tr><th>품목코드</th><td><%= row.get("itemCode") %></td></tr><tr><th>품목명</th><td><%= row.get("itemName") %></td></tr><tr><th>버전</th><td><%= row.get("versionNo") %></td></tr><tr><th>사용여부</th><td><%= row.get("useYn") %></td></tr><tr><th>비고</th><td><%= row.get("remark") %></td></tr>
                </table>
                <div class="btn-area">
                    <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/bom/list'">목록</button>
                    <button type="button" class="btn-primary" onclick="location.href='${pageContext.request.contextPath}/bom/updateForm?bomId=<%= row.get("bomId") %>'">수정</button>
                </div>
            </div>

            <div class="sub-card">
                <div class="sub-top">
                    <h3 style="margin:0;">BOM 자재 목록</h3>
                    <button type="button" class="btn-primary" onclick="location.href='${pageContext.request.contextPath}/bomDetail/insertForm?bomId=<%= row.get("bomId") %>'">자재 추가</button>
                </div>
                <table class="list-table">
                    <thead><tr><th>상세ID</th><th>자재코드</th><th>자재명</th><th>소요량</th><th>단위</th></tr></thead>
                    <tbody>
                    <%
                        List<Map<String,Object>> details = (List<Map<String,Object>>) request.getAttribute("bomDetailList");
                        if (details != null) for (Map<String,Object> d : details) {
                    %>
                        <tr>
                            <td><%= d.get("bomDetailId") %></td>
                            <td><%= d.get("itemCode") %></td>
                            <td><%= d.get("itemName") %></td>
                            <td><%= d.get("qtyRequired") %></td>
                            <td><%= d.get("unit") %></td>
                        </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>

        </div>
    </main>
</div>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
</body>
</html>
