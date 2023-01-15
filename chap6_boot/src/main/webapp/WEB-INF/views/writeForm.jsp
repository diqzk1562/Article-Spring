<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 쓰기</title>
</head>
<body>
<form action="write" method="post">
제목: <p>
<input type="text" name="title"> <p>
내용: <p>
<input type="text" name="content"> <p>
<input type="submit" value="새 글 등록"> <p>
</form>
</body>
</html>