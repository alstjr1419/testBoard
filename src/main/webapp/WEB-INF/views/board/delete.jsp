<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>삭제</title>
	<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
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
			<form role="form" method="post" autocomplete="off" >
				<p>
					<label for="bno">글 번호</label>
					<input type="text" id="bno" name="bno" value="${delete}" readonly="readonly">
				</p>
				
				<p>정말로 삭제하시겠습니까?</p>
				
				<p>
					<button type="submit">예 삭제합니다.</button><br>
					<button type="button" id="cancel_btn">아니오, 삭제하지 않겠습니다.</button>
				</p>
				
				<script type="text/javascript">
					//폼을 변수에 저장
					var formObj = $("form[role='form']");
					
					//취소버튼 클릭.
					$("#cancel_btn").click(function () {
						self.location = "/board/read?bno=${delete}"
										+"&page=${scri.page}"
										+"&perPageNum=${scri.perPageNum}"
										+"&searchType=${scri.searchType}"
										+"&keyword=${scri.keyword}"
					})
				</script>
			</form>
		</section>
	</div>
	<footer>
		<%@include file="include/footer.jsp" %>
	</footer>
</body>
</html>