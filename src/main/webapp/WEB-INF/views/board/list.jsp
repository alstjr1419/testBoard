<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>게시판</title>
</head>

<body>
	<div id="root">
		<header>
			<h1>게시판</h1>
		</header>
		<hr>
		<nav>처음화면 - 글쓰기 - 로그인</nav>
		<hr>
		<section id="container">
			<h2>글 목록</h2>
			
			<table>
				<tr>
					<th>글 번호</th>
					<th>글 목록</th>
					<th>작성자</th>
					<th>작성일자</th>
				</tr>
				
				<!-- list -->
				<c:forEach items="${list}" var="item">
					<tr>
						<td>${item.bno}</td>
						<td><a href="/board/read?bno=${item.bno}">${item.title}</a></td>
						<td>${item.writer}</td>
						<td><fmt:formatDate value="${item.regDate}" pattern="yyyy-mm-dd"/></td>
					</tr>
				</c:forEach>
			</table>
		</section>
		
		<hr>
		<footer>
			목록
		</footer>
	</div>
</body>
</html>