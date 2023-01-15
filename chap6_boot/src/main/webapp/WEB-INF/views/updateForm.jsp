<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>

<form method="post" action="update" >
	번호: <p>
	${article.article_no} <p>
	<p>
	제목: <p>
	<input type="text" value="${article.title}" name="title"> <p>
	<p>
	내용: <p>
	<input type="text" value="${content}" name="content"> <p>
	<p>
	<input type="hidden" value="${article.article_no}" name="article_no">
	<input type="submit" value="글 수정"> 
	</form>
</body>
</html>