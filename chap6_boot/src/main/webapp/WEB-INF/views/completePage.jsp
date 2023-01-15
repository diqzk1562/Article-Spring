<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실행 완료</title>
</head>
<body>
<h2>실행 완료</h2>
<br>
<hr>
<br>
<c:if test="${complete.update}">실행 메시지 : 정상적으로 수정되었습니다.<br></c:if>
<c:if test="${complete.delete}">실행 메시지 : 정상적으로 삭제되었습니다.<br></c:if>
<br>
<a href="list">[목록]</a><br>

</body>
</html>