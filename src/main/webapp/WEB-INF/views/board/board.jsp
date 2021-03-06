<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<title>게시판</title>
</head>
<body>
	<div class="container">
		<h2>Dark Striped Table</h2>
		<p>Combine .table-dark and .table-striped to create a dark,
			striped table:</p>
		<table class="table table-white table-striped">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boards}" var="board">
					<tr>
						<td>${board.bno }</td>
						<td>
							<a href="/board/${board.bno}">
								<c:if test="${board.depth > 0}">
									<c:forEach begin="0" end="${board.depth}">
										&nbsp;
									</c:forEach>
									ㄴ
								</c:if>
								${board.title }
							</a>
						</td>
						<td>${board.author }</td>
						<td>${board.write_date }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<a href="/board/new">글 작성</a>
	</div>
</body>
</html>