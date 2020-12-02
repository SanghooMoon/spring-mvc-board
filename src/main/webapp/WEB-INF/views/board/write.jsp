<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="myform" method="post">
		제목 : <input type="text" name="title" value="${board.title}"><br>
		작성자: <input type="text" name="author" value="${board.author}"><br>
		내용 : <input type="text" name="content" value="${board.content}"><br>
		<c:if test="${board eq null }">
			<button type="button"  onclick="goWrite()">등록</button>
		</c:if>
		<c:if test="${board ne null }">
				<input type="hidden" name="_method" value="put">
				<button type="button"  onclick="goEdit()">수정</button>
		</c:if>
		<!--  button 태그가 type에 대한 말이 없으면 
		submit 버튼
		성격이 무조건 서버로 전송 : 한번 누르면 서브밋이 2번 
		서버를 두번 호출  그래서 type을 별도로 지정해서 
		type="button"이라고 넣어줘야 한다  -->
	</form>
</body>
<script>
	function goWrite() {
		frm = document.myform;
		frm.action="/board/new";
		frm.submit();
	}
	function goEdit() {
		frm = document.myform;
		frm.action="/board/${board.bno}";
		frm.submit();
	}
</script>
</html>



