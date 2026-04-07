<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="forward.TodoDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	forward로 전달 받은 request에서
	num, map을 뽑아서
	syso도, html로도 출력하기 
-->

<%
	int num = (int)request.getAttribute("num");
	Map map = (Map)request.getAttribute("map");
	
	System.out.println("jsp > num : " + num);
	System.out.println("jsp > map : " + map);
	
	out.println("map: " + map);
%>
<br>
<%= request.getAttribute("num") %><br>
<%= map %>
<hr>
<%
	List list = (List)request.getAttribute("list");
	Map map2 = (Map)list.get(2);
%>
<%-- <%= list %> --%>
<%= map2.get("점심") %>
<br>
<%= map2.get("개수") %>
<hr>
<%
	String[] arr = (String[])request.getAttribute("arr");
%>
<% for(int i = 0; i < arr.length; i++) { %>
		<%= arr[i] %><br>
<% } %>
<hr>
<% TodoDTO todoDTO = (TodoDTO)request.getAttribute("todoDTO"); %>
<%= todoDTO %><br>

</body>
</html>