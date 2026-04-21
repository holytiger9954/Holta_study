<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>생산실적 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<%
    Map<String,Object> row = (Map<String,Object>) request.getAttribute("result");
%>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "생산실적 수정"); request.setAttribute("pageSubTitle", "기존 생산실적 정보를 수정하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <form action="${pageContext.request.contextPath}/result/update" method="post">
                    <input type="hidden" name="resultId" value="<%= row.get("resultId") %>">
                    <div class="form-row">
            <div class="form-group">
                <label for="workOrderId">작업지시ID</label>
                <input type="number" id="workOrderId" name="workOrderId" value="<%= row.get("workOrderId") == null ? "" : row.get("workOrderId") %>" required>
            </div>

            <div class="form-group">
                <label for="itemId">품목ID</label>
                <input type="number" id="itemId" name="itemId" value="<%= row.get("itemId") == null ? "" : row.get("itemId") %>" required>
            </div>

            <div class="form-group">
                <label for="resultDate">실적일자</label>
                <input type="date" id="resultDate" name="resultDate" value="<%= row.get("resultDate") == null ? "" : row.get("resultDate") %>" required>
            </div>

            <div class="form-group">
                <label for="goodQty">양품수량</label>
                <input type="number" id="goodQty" name="goodQty" value="<%= row.get("goodQty") == null ? "" : row.get("goodQty") %>" required>
            </div>

            <div class="form-group">
                <label for="defectQty">불량수량</label>
                <input type="number" id="defectQty" name="defectQty" value="<%= row.get("defectQty") == null ? "" : row.get("defectQty") %>" required>
            </div>

            <div class="form-group">
                <label for="status">상태</label>
                <input type="text" id="status" name="status" value="<%= row.get("status") == null ? "" : row.get("status") %>" required>
            </div>
        </div>
                    <div class="btn-area">
                        <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/result/detail?resultId=<%= row.get("resultId") %>'">취소</button>
                        <button type="submit" class="btn-primary">수정 완료</button>
                    </div>
                </form>
            </div>
        </div>
    </main>
</div>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
</body>
</html>
