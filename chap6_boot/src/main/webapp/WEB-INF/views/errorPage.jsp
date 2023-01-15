<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류 발생</title>
</head>
<body>
<h2>오류 발생</h2>
<br>
<hr>
<br>

<c:if test="${errors.update}">오류 메시지: 수정할 권한이 없습니다.<br></c:if>
<c:if test="${errors.delete}">오류 메시지: 삭제할 권한이 없습니다.<br></c:if>

<c:if test="${errors.notfound}">오류 메시지: 등록되지 않은 사용자입니다.<br></c:if>
<c:if test="${errors.email}">오류 메시지: 이메일을 입력하세요.<br></c:if>

<c:if test="${errors.password}">오류 메시지: 암호를 입력하세요.<br></c:if>
<c:if test="${errors.mismatch}">오류 메시지: 암호가 일치하지 않습니다.<br></c:if>

<p>
<a href="list">[목록]</a>

</body>
</html>