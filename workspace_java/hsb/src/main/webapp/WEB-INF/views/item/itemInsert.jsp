<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>품목 등록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "품목 등록"); request.setAttribute("pageSubTitle", "새로운 품목 정보를 등록하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <form action="${pageContext.request.contextPath}/item/insert" method="post">
                    <div class="form-row">
            <div class="form-group">
                <label for="itemCode">품목코드</label>
                <input type="text" id="itemCode" name="itemCode" required>
            </div>

            <div class="form-group">
                <label for="itemName">품목명</label>
                <input type="text" id="itemName" name="itemName" required>
            </div>

            <div class="form-group">
                <label for="itemType">품목유형</label>
                <input type="text" id="itemType" name="itemType" required>
            </div>

            <div class="form-group">
                <label for="unit">단위</label>
                <input type="text" id="unit" name="unit" required>
            </div>

            <div class="form-group">
                <label for="safetyStock">안전재고</label>
                <input type="number" id="safetyStock" name="safetyStock" required>
            </div>

            <div class="form-group">
                <label for="useYn">사용여부</label>
                <input type="text" id="useYn" name="useYn" required>
            </div>
        </div>
                    <div class="btn-area">
                        <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/item/list'">목록</button>
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
