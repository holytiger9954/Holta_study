<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>BOM 등록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "BOM 등록"); request.setAttribute("pageSubTitle", "새로운 BOM 정보를 등록하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <form action="${pageContext.request.contextPath}/bom/insert" method="post">
                    <div class="form-row">
            <div class="form-group">
                <label for="itemId">기준 품목ID</label>
                <input type="number" id="itemId" name="itemId" required>
            </div>

            <div class="form-group">
                <label for="versionNo">버전</label>
                <input type="number" id="versionNo" name="versionNo" required>
            </div>

            <div class="form-group">
                <label for="useYn">사용여부</label>
                <input type="text" id="useYn" name="useYn" required>
            </div>

            <div class="form-group">
                <label for="remark">비고</label>
                <input type="text" id="remark" name="remark" required>
            </div>
        </div>
                    <div class="btn-area">
                        <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/bom/list'">목록</button>
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
