<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>설비 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<%
    Map<String,Object> row = (Map<String,Object>) request.getAttribute("equipment");
%>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "설비 수정"); request.setAttribute("pageSubTitle", "기존 설비 정보를 수정하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <form action="${pageContext.request.contextPath}/equipment/update" method="post">
                    <input type="hidden" name="equipmentId" value="<%= row.get("equipmentId") %>">
                    <div class="form-row">
            <div class="form-group">
                <label for="equipmentCode">설비코드</label>
                <input type="text" id="equipmentCode" name="equipmentCode" value="<%= row.get("equipmentCode") == null ? "" : row.get("equipmentCode") %>" required>
            </div>

            <div class="form-group">
                <label for="equipmentName">설비명</label>
                <input type="text" id="equipmentName" name="equipmentName" value="<%= row.get("equipmentName") == null ? "" : row.get("equipmentName") %>" required>
            </div>

            <div class="form-group">
                <label for="modelName">모델명</label>
                <input type="text" id="modelName" name="modelName" value="<%= row.get("modelName") == null ? "" : row.get("modelName") %>" required>
            </div>

            <div class="form-group">
                <label for="location">위치</label>
                <input type="text" id="location" name="location" value="<%= row.get("location") == null ? "" : row.get("location") %>" required>
            </div>

            <div class="form-group">
                <label for="manufacturer">제조사</label>
                <input type="text" id="manufacturer" name="manufacturer" value="<%= row.get("manufacturer") == null ? "" : row.get("manufacturer") %>" required>
            </div>

            <div class="form-group">
                <label for="useYn">사용여부</label>
                <input type="text" id="useYn" name="useYn" value="<%= row.get("useYn") == null ? "" : row.get("useYn") %>" required>
            </div>
        </div>
                    <div class="btn-area">
                        <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/equipment/detail?equipmentId=<%= row.get("equipmentId") %>'">취소</button>
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
