
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

	<c:if test="${not empty login}">
<p>${login.mem_name }님  로그인했음</p>
	<a href="<c:url value='/user/logout'/>" >로그아웃</a><br>
	<a href="<c:url value='/user/myinfo?mem_idx=${login.mem_idx}'/>" >내정보</a><br><br>

	
<c:choose>
	<c:when test="${empty maker_idx }">
		<a href="<c:url value='/maker/maker?mem_idx=${login.mem_idx }'/>" > 메이커 등록</a><br>
	</c:when>
	<c:when test="${not empty maker_idx }">
		<a href="<c:url value='/maker/makerinfo?mem_idx=${login.mem_idx }'/>" >메이커 정보</a><br>
													<!-- mem_idx를 해야 하나? maker_idx를 해야 하나?? ㅇㅁㅇ... -->
	</c:when>
</c:choose>
		

	</c:if>
	<c:if test="${empty login}">
<a href="<c:url value='/user/join'/>" >회원가입</a>
<a href="<c:url value='/user/login'/>" >로그인</a>
	</c:if>



</body>
</html>
