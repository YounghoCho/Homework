<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
</head>

<body>
	<c:if test="${userId eq null}">
		<a href="https://kauth.kakao.com/oauth/authorize?client_id=3203fb9b237c44cf427b37c2e3cb4319&redirect_uri=http://localhost:8080/oauth&response_type=code">
			<img src="/image/kakao_login_large_wide.png">
		</a>
    </c:if>
    <c:if test="${userId ne null}">
	    로그인 성공!
        <div onClick="test()" style="border:1px solid #666;width:200px;">관리자 페이지로 이동.</div>
    </c:if>
</body>
</html>
<script>
function test(){
	location.href="/user";
}
</script>