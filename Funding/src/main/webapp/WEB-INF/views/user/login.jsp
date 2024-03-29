<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.table_view {
	width: 300px;
	margin: 0 auto;
}
.table_view tfoot {
	text-align: center;
}
</style>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script src="<c:url value='/webjars/jquery/3.4.1/dist/jquery.min.js' />"></script>
<script type="text/javascript">
	var msg = "${msg}";
	if(msg==="registered"){
		alert("가입축하! 이메일로 인증해");
	}else if(msg==="sns"){
		alert("가입축하!")
	}

	$(document).ready(function() {
		$("#loginBtn").click(function() {
			var email = $("#email").val();
			if (email == "") {
				alert("아이디 입력해");
				document.getElementById('loginform').email.focus();
				return;
			}
			var pw = $("#pw").val();
			if (pw == "") {
				alert("비빌번호 입력해");
				document.getElementById('loginform').pw.focus();
				return;
			}
			document.getElementById('loginform').submit();
		});
	});
</script>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<form id="loginform" action="/funding/user/loginPOST" method="post">

	<table class="table_view" >
	
	<caption>test 로그인</caption>
	<tr>
		<th colspan="2"><input type="text" name="mem_email" id="email" placeholder="아이디"></th>
	</tr>
	<tr>
		<th colspan="2"><input type="password" name="mem_password" id="pw" placeholder="비밀번호"></th>
	</tr>
	<tr>
		<th><input type="button" name="loginBtn" id="loginBtn" value="로그인"></th>
		<th><a href="<c:url value='/user/join' />" >회원가입</a></th>
	</tr>
	<tr>
		<th colspan="2"><input type="checkbox" name="useCookie" id="useCookie"> 자동로그인 </th>
	</tr>
	<tr>
		<th colspan="2"><a href="<c:url value='/user/userfind' />" >아이디 비밀번호 찾기</a></th>
	</tr>	
	</table>
</form>

<div id="naver_id_login" style="text-align:center">
	<a href="${naverURL }">
		<img width="223" src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png"/>
	</a>
</div>




</body>
</html>