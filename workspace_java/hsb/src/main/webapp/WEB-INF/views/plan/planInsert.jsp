<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>생산계획 등록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "생산계획 등록"); request.setAttribute("pageSubTitle", "새로운 생산계획 정보를 등록하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <form action="${pageContext.request.contextPath}/plan/insert" method="post">
                    <div class="form-row">
            <div class="form-group">
                <label for="itemId">품목ID</label>
                <input type="number" id="itemId" name="itemId" required>
            </div>

            <div class="form-group">
                <label for="planDate">계획일자</label>
                <input type="date" id="planDate" name="planDate" required>
            </div>

            <div class="form-group">
                <label for="planQty">계획수량</label>
                <input type="number" id="planQty" name="planQty" required>
            </div>

            <div class="form-group">
                <label for="lineCode">라인코드</label>
                <input type="text" id="lineCode" name="lineCode" required>
            </div>

            <div class="form-group">
                <label for="status">상태</label>
                <input type="text" id="status" name="status" required>
            </div>
        </div>
                    <div class="btn-area">
                        <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/plan/list'">목록</button>
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
