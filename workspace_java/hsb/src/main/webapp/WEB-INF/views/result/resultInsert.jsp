<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>생산실적 등록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "생산실적 등록"); request.setAttribute("pageSubTitle", "새로운 생산실적 정보를 등록하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <form action="${pageContext.request.contextPath}/result/insert" method="post">
                    <div class="form-row">
            <div class="form-group">
                <label for="workOrderId">작업지시ID</label>
                <input type="number" id="workOrderId" name="workOrderId" required>
            </div>

            <div class="form-group">
                <label for="itemId">품목ID</label>
                <input type="number" id="itemId" name="itemId" required>
            </div>

            <div class="form-group">
                <label for="resultDate">실적일자</label>
                <input type="date" id="resultDate" name="resultDate" required>
            </div>

            <div class="form-group">
                <label for="goodQty">양품수량</label>
                <input type="number" id="goodQty" name="goodQty" required>
            </div>

            <div class="form-group">
                <label for="defectQty">불량수량</label>
                <input type="number" id="defectQty" name="defectQty" required>
            </div>

            <div class="form-group">
                <label for="status">상태</label>
                <input type="text" id="status" name="status" required>
            </div>
        </div>
                    <div class="btn-area">
                        <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/result/list'">목록</button>
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
