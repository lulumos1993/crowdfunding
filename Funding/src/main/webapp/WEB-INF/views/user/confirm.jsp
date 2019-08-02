<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
   
<script src="<c:url value='/webjars/jquery/3.4.1/dist/jquery.min.js' />"></script>
<script type="text/javascript">

	
	var mem_email = "${mem_email}";
 	var msg = "${expired}";
	if(msg=="expired"){
		alert("만료된 링크입니다.");
		self.location='<c:url value="/"/>';
	} else{
		alert(mem_email+" 님 회원가입 완료를 축하드립니다. 로그인 해");
		self.location='<c:url value="/user/login"/>';
	}
		
		
		
	
		

</script>

