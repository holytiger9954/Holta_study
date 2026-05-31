<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
	<tiles:insertAttribute name="title" />
</title>
<style>
	div {
		border: 1px solid red;
	}
	
	.wrapper {
		display: flex;
	}
	.wrapper .aside {
		flex-grow: 2;
	}
	.wrapper .content {
		flex-grow: 8;
	}
</style>
<script>
	window.onload = function() {
		alert(1)
	}
	window.addEventListener('load', function(){
		alert(11)		
	})
</script>
</head>
<body>

<header>
	header
	<tiles:insertAttribute name="header" />
	<nav>메뉴1, 메뉴2</nav>
</header>

<section class="wrapper">
	<aside class="aside">
		aside
		<tiles:insertAttribute name="side" />		
	</aside>
	<article class="content">
		article
		<tiles:insertAttribute name="content" />
	</article>
</section>

<footer>
	footer
	<tiles:insertAttribute name="footer" />
</footer>

</body>
</html>