<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <body>
        <input id="appUserId" type="text" placeholder="유저 아이디를 입력해주세요.">
        <button onclick="searchUserById()">검색</button> HINT : 1480483910
        <br/>
        <ul id="userList">
            <li>idx/ 아이디/ 닉네임/ 가입날짜</li>
        </ul>
    </body> 
</html>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
function searchUserById(){
    let appUserId = $("#appUserId").val();
    $.ajax({
		type : "GET",
		url : "api/user",
		dataType : "json",
		data : "appUserId=" + appUserId,
		success : function(res){
            let id = res[0].appUserId;
            let nickname = res[0].nickname;
            let createdAt = res[0].createdAt;
            $('#userList').append('<li>' + 1 + '/' + id + '/' + nickname + '/' + createdAt + 
                '<input id="newNickname" type="text" placeholder="새로운 닉네임 입력">' +
                '<button onclick="editUserInfo()">닉네임 수정</button>' +
                '<button onclick="deleteUser()">삭제</button></li>');	
		},
		error : function(err){
			alert("error line31in search.js  : " + JSON.stringify(err));
		}
	});
}
function editUserInfo(){
    let appUserId = $("#appUserId").val();
    let newNickname = $("#newNickname").val();
    $.ajax({
		type : "PUT",
		url : "api/user",
		dataType : "json",
		data : "newNickname=" + newNickname + "&appUserId=" + appUserId,
		success : function(res){
            if(res == 200){
                alert("수정 되었습니다.");
                location.href="/person";
            }
		},
		error : function(err){
			alert("error line46 in search.js  : " + JSON.stringify(err));
		}
	}); 
}
function deleteUser(){
    let appUserId = $("#appUserId").val();
    $.ajax({
		type : "DELETE",
		url : "api/user",
		dataType : "json",
		data : "appUserId=" + appUserId,
		success : function(res){
            if(res == 200){
                alert("삭제 되었습니다.");
                location.href="/person";
            }
		},
		error : function(err){
			alert("error line46 in search.js  : " + JSON.stringify(err));
		}
	}); 
}
</script>