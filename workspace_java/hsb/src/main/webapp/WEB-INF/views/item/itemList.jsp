<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>품목 관리</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "품목 관리"); request.setAttribute("pageSubTitle", "품목 등록 및 조회 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <div class="page-actions">
                    <form class="search-box">
                        <input type="text" placeholder="검색어 입력">
                        <button type="button" class="btn-secondary">검색</button>
                    </form>
                    <button type="button" class="btn-primary" onclick="location.href='${pageContext.request.contextPath}/item/insertForm'">품목 등록</button>
                </div>
                <table class="table-basic">
                    <thead><tr><th>ID</th><th>품목코드</th><th>품목명</th><th>유형</th><th>단위</th><th>안전재고</th><th>사용여부</th><th>관리</th></tr></thead>
                    <tbody>
                    <%
                        List<Map<String,Object>> list = (List<Map<String,Object>>) request.getAttribute("itemList");
                        if (list != null) for (Map<String,Object> row : list) {
                    %>
                        <tr>
                            <td><%= row.get("itemId") %></td><td><%= row.get("itemCode") %></td><td><%= row.get("itemName") %></td><td><%= row.get("itemType") %></td><td><%= row.get("unit") %></td><td><%= row.get("safetyStock") %></td><td><%= row.get("useYn") %></td>
                            <td>
                                <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/item/detail?itemId=<%= row.get("itemId") %>'">상세</button>
                                <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/item/updateForm?itemId=<%= row.get("itemId") %>'">수정</button>
                            </td>
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
