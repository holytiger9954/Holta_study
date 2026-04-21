<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>작업지시 등록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "작업지시 등록"); request.setAttribute("pageSubTitle", "새로운 작업지시 정보를 등록하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <form action="${pageContext.request.contextPath}/workOrder/insert" method="post">
                    <div class="form-row">
            <div class="form-group">
                <label for="planId">계획ID</label>
                <input type="number" id="planId" name="planId" required>
            </div>

            <div class="form-group">
                <label for="itemId">품목ID</label>
                <input type="number" id="itemId" name="itemId" required>
            </div>

            <div class="form-group">
                <label for="startDate">시작일</label>
                <input type="date" id="startDate" name="startDate" required>
            </div>

            <div class="form-group">
                <label for="endDate">종료일</label>
                <input type="date" id="endDate" name="endDate" required>
            </div>

            <div class="form-group">
                <label for="orderQty">지시수량</label>
                <input type="number" id="orderQty" name="orderQty" required>
            </div>

            <div class="form-group">
                <label for="status">상태</label>
                <input type="text" id="status" name="status" required>
            </div>
        </div>
                    <div class="btn-area">
                        <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/workOrder/list'">목록</button>
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
