<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>EMP 목록</h1>
	<%--     ${list} --%>
	<select is="size">
		<option value=5 selected="selected">5</option>
		<option value=10>10</option>
		<option value=15>15</option>
		<option value=20>20</option>
	</select>
	<br>
	<table border=1>
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>job</th>
			<th>mgr</th>
			<th>hiredate</th>
			<th>sal</th>
			<th>comm</th>
			<th>deptno</th>
		</tr>
		<tbody>
			<c:forEach var="dto" items="${map.list}">
				<tr>
					<td>${dto.empno}</td>
					<td>${dto.ename}</td>
					<td>${dto.job}</td>
					<td>${dto.mgr}</td>
					<td>${dto.hiredate}</td>
					<td>${dto.sal}</td>
					<td>${dto.comm}</td>
					<td>${dto.deptno}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<%
	Map map = (Map) request.getAttribute("map");
	int total = (int) map.get("totalCount");
	int size = (int) map.get("size");

	int totalpage = (int) Math.ceil((double) total / size);

	int section = 5; // 한번에 보여줄 페이지들의 수 
	int pageNum = (int) map.get("page");

	int end_section = (int) Math.ceil((double) pageNum / section) * section;
	//     int start_section = end_section - (section-1);
	int start_section = end_section - section + 1;

	if (end_section > totalpage) {
		end_section = totalpage;
	}
	%>

	<c:if test="<%=start_section == 1%>">
        [이전]
    </c:if>
	<c:if test="<%=start_section != 1%>">
        [<a href="list?page=<%=start_section - 1%>&size=10">이전</a>]
    </c:if>

	<c:forEach var="i" begin="<%=start_section%>" end="<%=end_section%>">
		<a href="list?page=${i}&size=10"> <c:if test="${map.page eq i }">
				<strong> ${i} </strong>
			</c:if> <c:if test="${map.page ne i }">
                ${i}
            </c:if>
		</a>

	</c:forEach>

	<c:if test="<%=end_section == totalpage%>">
        [다음]
    </c:if>
	<c:if test="<%=end_section != totalpage%>">
        [<a href="list?page=<%=end_section + 1%>">다음</a>]
    </c:if>

	<script>
		// select의 change 이벤트에서
		let size = document.querySelector("#size").value
		let url = "list?page=1&size=" + size
		//location.href = url
	</script>
</body>
</html>