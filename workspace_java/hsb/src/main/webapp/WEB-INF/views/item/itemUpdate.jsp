<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>품목 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<%
    Map<String,Object> row = (Map<String,Object>) request.getAttribute("item");
%>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "품목 수정"); request.setAttribute("pageSubTitle", "기존 품목 정보를 수정하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <form action="${pageContext.request.contextPath}/item/update" method="post">
                    <input type="hidden" name="itemId" value="<%= row.get("itemId") %>">
                    <div class="form-row">
            <div class="form-group">
                <label for="itemCode">품목코드</label>
                <input type="text" id="itemCode" name="itemCode" value="<%= row.get("itemCode") == null ? "" : row.get("itemCode") %>" required>
            </div>

            <div class="form-group">
                <label for="itemName">품목명</label>
                <input type="text" id="itemName" name="itemName" value="<%= row.get("itemName") == null ? "" : row.get("itemName") %>" required>
            </div>

            <div class="form-group">
                <label for="itemType">품목유형</label>
                <input type="text" id="itemType" name="itemType" value="<%= row.get("itemType") == null ? "" : row.get("itemType") %>" required>
            </div>

            <div class="form-group">
                <label for="unit">단위</label>
                <input type="text" id="unit" name="unit" value="<%= row.get("unit") == null ? "" : row.get("unit") %>" required>
            </div>

            <div class="form-group">
                <label for="safetyStock">안전재고</label>
                <input type="number" id="safetyStock" name="safetyStock" value="<%= row.get("safetyStock") == null ? "" : row.get("safetyStock") %>" required>
            </div>

            <div class="form-group">
                <label for="useYn">사용여부</label>
                <input type="text" id="useYn" name="useYn" value="<%= row.get("useYn") == null ? "" : row.get("useYn") %>" required>
            </div>
        </div>
                    <div class="btn-area">
                        <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/item/detail?itemId=<%= row.get("itemId") %>'">취소</button>
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
