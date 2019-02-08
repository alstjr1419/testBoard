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
	<section id="container">
		<form role="form" method="post" autocomplete="off" >
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
				<button id="modify_btn">수정</button>
				<button id="delete_btn">삭제</button>
				
				<script type="text/javascript">
					//폼을 변수에 저장
					var formObj = $("form[role='form']")
					
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
		단일정보 조회
	</footer>
</body>
</html>