<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <body onload=searchAllUsers()>
        <input id="nickname" type="text" placeholder="닉네임을 입력해주세요.">
        <button onclick="searchUserByNickname()">검색</button>
        <br/>
        <ul id="userList">
            <li id="allUsers">전체 사용자 목록</li><br/>
            <li>idx/ 아이디/ 닉네임/ 가입날짜</li>
        </ul>
    </body> 
</html>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
function searchAllUsers(){
    $.ajax({
		type : "GET",
		url : "api/users",
		dataType : "json",
		data : "",
		success : function(res){
            $.each(res, function(index, item) {
                $('#userList').append('<li>' + Number(index+1) + '/' + item.appUserId + '/' + item.nickname + '/' + item.createdAt + '</li>');
            });											
		},
		error : function(err){
			alert("error line22 in search.js  : " + JSON.stringify(err));
		}
	});
}
function searchUserByNickname(){
    let data = $("#nickname").val();
    $.ajax({
		type : "GET",
		url : "api/users?nickname=" + data,
		dataType : "json",
		data : "",
		success : function(res){
            $('#allUsers').remove();
            $('#userList > li').remove();
            let id = res[0].appUserId;
            let nickname = res[0].nickname;
            let createdAt = res[0].createdAt;
            $('#userList').append('<li>' + 1 + '/' + id + '/' + nickname + '/' + createdAt + '</li>');										
		},
		error : function(err){
			alert("error line22 in search.js  : " + JSON.stringify(err));
		}
	});
}
</script>