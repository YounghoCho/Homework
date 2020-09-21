<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
</head>

<body onload=init(${userId})>
	<div id="head"></div>
	
	<div style="border:1px solid black" onclick="callLogout()">로그아웃</div>
	<div style="border:1px solid black" onclick="callWithdraw(${userId})">회원탈퇴</div>
	<div style="border:1px solid black" onclick="callSearch()">회원 조회</div>
	<div style="border:1px solid black">개인 회원 관리</div>
</body>
</html>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
function init(id){
	$.ajax({
		type : "GET",
		url : "profile",
		dataType : "json",
		data : "id=" + id,
		success : function(res){
			if(res.profile.length != 0){
				let id = res.profile[0].appUserId;
				let nickname = res.profile[0].nickname;
				$('#head').append('<div>' + id +'</div>');
				$('#head').append('<div>' + nickname +'</div>');
			}
		},
		error : function(err){
			alert("error line37 in index.js : " + err);
		}
	});
}

function callLogout(){
	location.href="/logout";
}

function callWithdraw(appUserId){
	$.ajax({
		type : "POST",
		url : "withdraw",
		dataType : "json",
		data : "appUserId=" + appUserId,
		success : function(res){
			console.log("responseCode : " + res);
			if(res == 200){
				logout();
			}
		},
		error : function(err){
			alert("error line56 in index.js  : " + err);
		}
	});
}

function callSearch(){
	location.href="/search";
}
</script>
