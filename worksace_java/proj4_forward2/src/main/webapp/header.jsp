<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
	<div>이거 해더임</div>
	<div>로고 here</div>
	<div>${param.id }님 환영합니다</div>
	
	<c:if test="${ not empty param.msg }]">
		<div class="mag">
		${ param.msg }
<!-- 		아이디나 비밀번호를 확인해주세요 -->
		</div>
	</c:if>
	
</header>

<script>
	const msg = '${param.msg}'
	let a = dom.value;
	
</script>
