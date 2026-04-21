<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>BOM 자재 추가</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "BOM 자재 추가"); request.setAttribute("pageSubTitle", "BOM에 자재를 추가하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <form action="${pageContext.request.contextPath}/bomDetail/insert" method="post">
                    <div class="form-row">
                        <div class="form-group"><label for="bomId">BOM ID</label><input type="number" id="bomId" name="bomId" required></div>
                        <div class="form-group"><label for="itemId">자재 품목ID</label><input type="number" id="itemId" name="itemId" required></div>
                    </div>
                    <div class="form-row">
                        <div class="form-group"><label for="qtyRequired">소요량</label><input type="number" id="qtyRequired" name="qtyRequired" step="0.001" required></div>
                        <div class="form-group"><label for="unit">단위</label><input type="text" id="unit" name="unit" required></div>
                    </div>
                    <div class="btn-area">
                        <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/bom/list'">목록</button>
                        <button type="submit" class="btn-primary">추가</button>
                    </div>
                </form>
            </div>
        </div>
    </main>
</div>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
</body>
</html>
