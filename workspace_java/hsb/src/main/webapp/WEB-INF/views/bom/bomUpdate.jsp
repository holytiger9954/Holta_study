<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>BOM 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<%
    Map<String,Object> row = (Map<String,Object>) request.getAttribute("bom");
%>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "BOM 수정"); request.setAttribute("pageSubTitle", "기존 BOM 정보를 수정하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <form action="${pageContext.request.contextPath}/bom/update" method="post">
                    <input type="hidden" name="bomId" value="<%= row.get("bomId") %>">
                    <div class="form-row">
            <div class="form-group">
                <label for="itemId">기준 품목ID</label>
                <input type="number" id="itemId" name="itemId" value="<%= row.get("itemId") == null ? "" : row.get("itemId") %>" required>
            </div>

            <div class="form-group">
                <label for="versionNo">버전</label>
                <input type="number" id="versionNo" name="versionNo" value="<%= row.get("versionNo") == null ? "" : row.get("versionNo") %>" required>
            </div>

            <div class="form-group">
                <label for="useYn">사용여부</label>
                <input type="text" id="useYn" name="useYn" value="<%= row.get("useYn") == null ? "" : row.get("useYn") %>" required>
            </div>

            <div class="form-group">
                <label for="remark">비고</label>
                <input type="text" id="remark" name="remark" value="<%= row.get("remark") == null ? "" : row.get("remark") %>" required>
            </div>
        </div>
                    <div class="btn-area">
                        <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/bom/detail?bomId=<%= row.get("bomId") %>'">취소</button>
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
