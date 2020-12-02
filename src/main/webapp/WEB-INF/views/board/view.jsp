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
	<p>번호 : ${board.bno}</p>
	<p>제목 : ${board.title}</p>
	<p>작성자 : ${board.author}</p>
	<p>내용 : ${board.content}</p>
	
	<form action="/board/${board.bno }" method="post">
	  <input type="hidden" name="_method" value="delete" />
	  <button type="submit">삭제</button>
	</form>
	
</body>
</html>