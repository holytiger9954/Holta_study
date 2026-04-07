<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<c:set var="str" value="영일이삼사오육칠팔구삼사" />

\${str} : ${str}<br>
길이 : \${fn:length(str)} : ${fn:length(str)}<br>
자르기 : \${fn:substring(str, 3, 6)} : ${fn:substring(str, 3, 6)}<br>
치환 : \${fn:replace(str, "삼사", "34")} : ${fn:replace(str, "삼사", "34")}<br>
위치 찾기(있을 때) : \${fn:indexOf(str, "삼사")} : ${fn:indexOf(str, "삼사")}<br>
위치 찾기(없을 때) : \${fn:indexOf(str, "삼사2")} : ${fn:indexOf(str, "삼사2")}<br>
	
</body>
</html>