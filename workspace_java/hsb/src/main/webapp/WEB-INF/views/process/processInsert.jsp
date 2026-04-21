<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>공정 등록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "공정 등록"); request.setAttribute("pageSubTitle", "새로운 공정 정보를 등록하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <form action="${pageContext.request.contextPath}/process/insert" method="post">
                    <div class="form-row">
            <div class="form-group">
                <label for="processCode">공정코드</label>
                <input type="text" id="processCode" name="processCode" required>
            </div>

            <div class="form-group">
                <label for="processName">공정명</label>
                <input type="text" id="processName" name="processName" required>
            </div>

            <div class="form-group">
                <label for="useYn">사용여부</label>
                <input type="text" id="useYn" name="useYn" required>
            </div>
        </div>
                    <div class="btn-area">
                        <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/process/list'">목록</button>
                        <button type="submit" class="btn-primary">등록</button>
                    </div>
                </form>
            </div>
        </div>
    </main>
</div>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
</body>
</html>
