<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="forward.EmpDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<EmpDTO> empList = (List<EmpDTO>) request.getAttribute("empList");
	%>

	<h2>사원 목록</h2>

	<%="목록 크기: " + empList.size()%>
	
	<table border="1">
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>직업</th>
			<th>연봉</th>
			<th>입사일</th>
			<th>급여</th>
			<th>보너스</th>
			<th>부서번호</th>
		</tr>

		<%
		for (EmpDTO emp : empList) {
		%>
		<tr>
			<td><%=emp.getEmpno()%></td>
			<td><%=emp.getEname()%></td>
			<td><%=emp.getJob()%></td>
			<td><%=emp.getMgr()%></td>
			<td><%=emp.getHireDate()%></td>
			<td><%=emp.getSal()%></td>
			<td><%=emp.getComm()%></td>
			<td><%=emp.getDeptno()%></td>
		</tr>
		<%
		}
		%>

	</table>
</body>
</html>