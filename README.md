# HOMEWORK
A user management service development using Kakao login API.
<br/>


## Summary 
<ol>
<li><strong>Development environment</strong></li>
	<ul>	- JSP, Jquery, Springbootv2.3.4, MySQLv5.7.31</ul>
	<ul>	- HOST : locahost</ul>
	<ul>	- OS : MAC</ul>
<li><strong>REST API</li>
<li>Problem solving strategy</li>
<li>How to build and run the project</strong></li>
</ol>
<br/>


## REST API Description
<strong>User Login</strong>
URL | Description | Prameters
:---|:---|:---
`GET /oauth` | Receive a verification code from Kakao  | `code`
`GET /profile` | Get my profile | 'accessToken'
`POST /logout` | Logout | 'accessToken, userId'
`POST /withdraw` | Withdraw user | 'userId'

<br/>

<strong>User Management</strong>
URL | Description | Prameters
:---|:---|:---
`GET /api/users` | Get all users | `code`
`GET /api/users/{nickname}` | Search a specific user | 'nickname'
`GET /api/user/{appUserId}` | Search a user by id | 'appUserId'
`PUT /api/user/{appUserId}` | Edit a user's information | 'appUserId'
`DELETE /api/user/{appUserId}` | Delete a user's information | 'appUserId'

<br/>


## Problem solving strategy

<ol>
<li><strong>Login with Kakao API</strong></li>
<ul>로그인/로그아웃 기능은 Kakao 로그인 REST API를 사용하여 구현을 한다.</ul>
<ul>사용자의 정보들을 저장해야하므로 back-end에서 호출 및 처리한다.</ul>
<ul>사용자의 로그인 상태는 세션과 발급받은 토큰으로 관리한다.</ul>

<li><strong>User Management</strong></li>
<ul>사용자 관리는 전체 사용자 검색과 개인 사용자 관리로 구분한다.</ul>
<ul>REST API 개발 요건에 맞게 API를 구현한다.</ul>

<li><strong>Collecting HTTP Logs</strong></li>
<ul>Servlet Filter를 사용하여 사용자의 HTTP 요청과 응답을 기록한다.</ul>
<ul>요청과 응답이 발생한 시간을 기준으로 로그를 저장 및 관리한다.</ul>

<li><strong>Test Code</strong></li>
<ul>Junit5를 사용해 단위 테스트를 진행한다.</ul>
<ul>데이터베이스 연결 테스트와 MVC 테스트를 수행한다.</ul>
</ol>
<br/>


## How to build and run the project
<pre>
$ git clone https://github.com/YounghoCho/Homework.git

$ run Eclipse > import Homework.zip

$ Project > Run as > Springboot Application

(*This zip has only source files, not war & jar)
</pre>