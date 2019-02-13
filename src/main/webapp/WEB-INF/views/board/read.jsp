<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>게시판</title>
	<!-- 제이쿼리 -->
 	<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
</head>
<body>
	<header>
		<%@include file="include/header.jsp" %>
	</header>
	
	<nav>
		<%@include file="include/nav.jsp" %>
	</nav>
	
	<section id="container">
		<form role="form" method="post" autocomplete="off" >
			<input type="hidden" id="page" name="page" value="${scri.page }">
			<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum }">
			<input type="hidden" id="searchType" name="searchType" value="${scri.searchType }">
			<input type="hidden" id="keyword" name="keyword" value="${scri.keyword }">
			
			<p>
				<label for="bno">글 번호</label><input type="text" id="bno" name="bno" value="${read.bno}" readonly="readonly">
			</p>
			
		</form>	
			<p>
				<label for="title">글 제목</label><input type="text" id="title" name="title" value="${read.title}" readonly="readonly">
			</p>
			
			<p>
				<label for="content">글 내용</label><input type="text" id="content" name="content" value="${read.content}" readonly="readonly">
			</p>
			
			<p>
				<label for="writer">작성자</label><input type="text" id="writer" name="writer" value="${read.writer}" readonly="readonly"> <br/>
				<label for="regDate">작성날짜</label><span><fmt:formatDate value="${read.regDate}" pattern="yyyy-MM-dd"/></span>
			</p>
			<p>
				<button id="list_btn">목록</button>
				<button id="modify_btn">수정</button>
				<button id="delete_btn">삭제</button>
				
				<script type="text/javascript">
					//폼을 변수에 저장
					var formObj = $("form[role='form']")
					
					//목록버튼 클릭
					$("#list_btn").click(function () {
						self.location = "/board/listSearch?"
									+ "page=${scri.page}$perPageNum=${scri.perPageNum}"
									+ "&searchType=${scri.searchType}&keyword=${scri.keyword}";
					})
					
					//수정버튼 클릭
					$("#modify_btn").click(function () {
						formObj.attr("action", "/board/modify");
						formObj.attr("method", "get");
						formObj.submit();
					});
					
					//삭제버튼 클릭
					$("#delete_btn").click(function () {
						formObj.attr("action", "/board/delete");
						formObj.attr("method", "get");
						formObj.submit();
					});
				</script>
			</p>
			
		
	</section>
	<hr>
			
	<footer>
		<%@include file="include/footer.jsp" %>
	</footer>
</body>
</html>