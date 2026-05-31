<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<body>
	현재 로그인 사번: [${sessionScope.loginEmpno}]
	<hr>

    <form method="post"
		action="${pageContext.request.contextPath}/updateEmp">
        <input type="hidden" name="empno" value="${empDTO.empno}">

        이름:
        <input type="text" name="ename" value="${empDTO.ename}"
			<c:if test="${empty sessionScope.loginEmpno}">readonly</c:if>>
        <br>

        직무:
        <input type="text" name="job" value="${empDTO.job}"
			<c:if test="${empty sessionScope.loginEmpno}">readonly</c:if>>
        <br>

        급여:
        <input type="text" name="sal" value="${empDTO.sal}"
			<c:if test="${empty sessionScope.loginEmpno}">readonly</c:if>>
        <br>

        상사:
        <input type="text" name="mgr" value="${empDTO.mgr}"
			<c:if test="${empty sessionScope.loginEmpno}">readonly</c:if>>
        <br>

        입사일:
        <input type="date" name="hiredate" value="${empDTO.hiredate}"
			<c:if test="${empty sessionScope.loginEmpno}">readonly</c:if>>
        <br>

        커미션:
        <input type="text" name="comm" value="${empDTO.comm}"
			<c:if test="${empty sessionScope.loginEmpno}">readonly</c:if>>
        <br>

        부서번호:
        <input type="text" name="deptno" value="${empDTO.deptno}"
			<c:if test="${empty sessionScope.loginEmpno}">readonly</c:if>>
        <br>

        <c:if test="${not empty sessionScope.loginEmpno}">
            <button type="submit">수정</button>
        </c:if>
    </form>

    <c:if test="${not empty sessionScope.loginEmpno}">
        <form method="post"
			action="${pageContext.request.contextPath}/deleteEmp">
            <input type="hidden" name="empno" value="${empDTO.empno}">
            <button type="submit">삭제</button>
        </form>
    </c:if>

    <c:if test="${empty sessionScope.loginEmpno}">
        <p>수정/삭제는 로그인 후 가능합니다.</p>
        <a href="${pageContext.request.contextPath}/loginForm">로그인하기</a>
    </c:if>

    <a href="${pageContext.request.contextPath}/list">목록으로</a>
</body></body>

</html>