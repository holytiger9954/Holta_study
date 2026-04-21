<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>직원 관리</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "직원 관리"); request.setAttribute("pageSubTitle", "직원 등록 및 조회 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <div class="page-actions">
                    <h3 style="margin:0;">직원 목록</h3>
                    <button type="button" class="btn-primary">직원 등록</button>
                </div>
                <table class="table-basic">
                    <thead><tr><th>사번</th><th>이름</th><th>부서코드</th><th>직급</th><th>상태</th><th>권한</th></tr></thead>
                    <tbody>
                    <%
                        List<Map<String,Object>> empList = (List<Map<String,Object>>) request.getAttribute("empList");
                        if (empList != null) for (Map<String,Object> e : empList) {
                    %>
                        <tr>
                            <td><%= e.get("empNo") %></td>
                            <td><%= e.get("empName") %></td>
                            <td><%= e.get("deptCode") %></td>
                            <td><%= e.get("positionName") %></td>
                            <td><%= e.get("status") %></td>
                            <td><%= e.get("roleName") %></td>
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
