
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
<p>${login.mem_name }��  �α�������</p>
	<a href="<c:url value='/user/logout'/>" >�α׾ƿ�</a><br>
	<a href="<c:url value='/user/myinfo?mem_idx=${login.mem_idx}'/>" >������</a><br><br>

	
<c:choose>
	<c:when test="${empty maker_idx }">
		<a href="<c:url value='/maker/maker?mem_idx=${login.mem_idx }'/>" > ����Ŀ ���</a><br>
	</c:when>
	<c:when test="${not empty maker_idx }">
		<a href="<c:url value='/maker/makerinfo?mem_idx=${login.mem_idx }'/>" >����Ŀ ����</a><br>
													<!-- mem_idx�� �ؾ� �ϳ�? maker_idx�� �ؾ� �ϳ�?? ������... -->
	</c:when>
</c:choose>
		

	</c:if>
	<c:if test="${empty login}">
<a href="<c:url value='/user/join'/>" >ȸ������</a>
<a href="<c:url value='/user/login'/>" >�α���</a>
	</c:if>



</body>
</html>
