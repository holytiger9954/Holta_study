<!-- html 주석 -->
<%--jsp 주석 --%>
<%--
	디렉티브 태그
	"<%@"로 시작되는 태그
	1. page		: 페이지 설정 및 import
	2. include	: 다른 jsp 가져오기
	3. taglib	: custom tag library를 사용할 수 있게 해줌
 --%>
<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.List"
    import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function() {
		console.log("jsp_1.jsp")
	}
</script>
</head>
<body>
	<h1>hello world</h1>
	<!-- 스크립틀릿 Scriptlet -->
	<%
		// 여기는 자바 영역
		System.out.println("java Baby~~~");
	%>

<table border=1>
	<% for(int i = 0; i < 5; i++){ %>
		 <tr>
		 <td>제목1</td>
		 <td>내용1</td>
		 </tr>
	<% } %>
	
	<%
		for(int i = 0; i < 5; i++){
			out.write("<tr>");
		    out.write("<td>제목2</td>");
		    out.write("<td>내용2</td>");
		    out.write("</tr>");			
		}
	%>
	
	<%
		String name = request.getParameter("name");
		System.out.println("name: " + name);
		
		int a= 10;
	%>
</table>

	<!-- 표현식 -->
	<%= a %>
	<br>
	<%= request.getParameter("name") %>
	
	<!-- 선언문 -->
	<%!
		String title = "보스";
		String getTitle() {
			return this.title;
		}
	%>
	<br>
	<%= getTitle() %>
	
	<hr>
	<!-- 구구단 2단 출력 -->
	<%
		for(int i = 1; i <= 9; i++) {
			out.println("2 X " + i + " = " + (2 * i) + "<br>");		
		}
	%>
	
	<hr>
	
	<% for(int i = 1; i <= 9; i++) { %>
		3 X	<%= i %> = <%= (3 * i) %><br>	
	<% } %>
	
	<%@ include file="footer.jsp" %>
</body>
</html>




















