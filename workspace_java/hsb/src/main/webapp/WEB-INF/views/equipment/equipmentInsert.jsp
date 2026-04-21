<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>설비 등록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "설비 등록"); request.setAttribute("pageSubTitle", "새로운 설비 정보를 등록하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <form action="${pageContext.request.contextPath}/equipment/insert" method="post">
                    <div class="form-row">
            <div class="form-group">
                <label for="equipmentCode">설비코드</label>
                <input type="text" id="equipmentCode" name="equipmentCode" required>
            </div>

            <div class="form-group">
                <label for="equipmentName">설비명</label>
                <input type="text" id="equipmentName" name="equipmentName" required>
            </div>

            <div class="form-group">
                <label for="modelName">모델명</label>
                <input type="text" id="modelName" name="modelName" required>
            </div>

            <div class="form-group">
                <label for="location">위치</label>
                <input type="text" id="location" name="location" required>
            </div>

            <div class="form-group">
                <label for="manufacturer">제조사</label>
                <input type="text" id="manufacturer" name="manufacturer" required>
            </div>

            <div class="form-group">
                <label for="useYn">사용여부</label>
                <input type="text" id="useYn" name="useYn" required>
            </div>
        </div>
                    <div class="btn-area">
                        <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/equipment/list'">목록</button>
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
