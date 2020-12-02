<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="myform" method="post">
		제목 : <input type="text" name="title"><br>
		작성자: <input type="text" name="author"><br>
		내용 : <input type="text" name="content"><br>
		
		<!-- 부모글에 대한 정보 -->
		<input type="hidden" name="group_id" value="${board.group_id}" />
		<input type="hidden" name="depth" value="${board.depth}" />
		<input type="hidden" name="g_level" value="${board.g_level}" />
		<button type="button" onclick="goWrite()">댓글등록</button>
		<!--  
			button 태그가 type에 대한 말이 없으면 
			submit 버튼
			성격이 무조건 서버로 전송 : 한번 누르면 서브밋이 2번 
			서버를 두번 호출  그래서 type을 별도로 지정해서 
			type="button"이라고 넣어줘야 한다  
		-->
	</form>
</body>
<script>
	function goWrite() {
		frm = document.myform;
		frm.action = "/board/reply";
		frm.submit();
	}
</script>
</html>



