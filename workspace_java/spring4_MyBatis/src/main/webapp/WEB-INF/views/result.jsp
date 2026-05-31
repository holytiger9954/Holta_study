<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>사번 검색 결과</h3>
	<ul>
		<li>사원번호 : ${empno.empno}</li>
		<li>이름 : ${empno.ename}</li>
		<li>직무 : ${empno["job"]}</li>
	</ul>

	<h3>이름 검색 결과</h3>
	<c:forEach var="item" items="${list}">
       	사원번호: ${item.empno}<br> 이름: ${item.ename}<br> 직무: ${item.job} <hr>
	</c:forEach>
	
	<h3>직무 검색 결과</h3>
	<c:forEach var="job" items="${list}">
       	사원번호: ${job.empno}<br> 이름: ${job.ename}<br> 직무: ${job.job} <hr>
	</c:forEach>
	
	<h3>직무&이름 검색 결과</h3>
	<c:forEach var="jobEname" items="${list}">
       	사원번호: ${jobEname.empno}<br> 이름: ${jobEname.ename}<br> 직무: ${jobEname.job} <hr>
	</c:forEach>
</body>
</html>