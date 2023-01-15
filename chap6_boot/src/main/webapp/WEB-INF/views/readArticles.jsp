<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 읽기</title>
</head>
<body>
<table border="1">
	<tr>
		<th>번호</th>
		<td>${article.article_no}</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${article.name}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${article.title}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${content}</td>
	</tr>
	<tr>
		<th> </th>
		<td><a href="list">[목록]</a> <a href="update?article_no=${article.article_no}">[게시글 수정]</a> <a href="delete?article_no=${article.article_no}">[게시글 삭제]</a> </td>
	</tr>
</table>
</body>
</html>