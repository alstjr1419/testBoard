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
			<%@include file="include/header.jsp" %>
		</header>
		<hr>
		<nav>
			<%@include file="include/nav.jsp" %>
		</nav>
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
			
			<div>
				<ul>
					<c:if test="${pageMaker.prev}">
						<li><a href="listPage${pageMaker.makeQuery(pageMaker.startPage -1) }">이전</a></li>
					</c:if>
					
					<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
						<li><a href="listPage${pageMaker.makeQuery(idx) }">${idx }</a></li>
					</c:forEach>
					
					<c:if test="${pageMaker.next }">
						<li><a href="listPage${pageMaker.makeQuery(pageMaker.endPage +1) }">다음</a></li>
					</c:if>
				</ul>
			</div>
			
		</section>
		
		<hr>
		<footer>
			<%@include file="include/footer.jsp" %>
		</footer>
	</div>
</body>
</html>