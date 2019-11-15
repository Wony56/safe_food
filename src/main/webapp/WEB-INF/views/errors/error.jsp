<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error...</title>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script src="<c:url value="/resources/js/button.js"/>"></script>
<script src="<c:url value="/resources/js/init.js"/>"></script>

</head>
<body>
	<header>
		<jsp:include page="../../../header.jsp" flush="true" />
	</header>

	<nav>
		<jsp:include page="../../../nav.jsp" flush="true" />
	</nav>

	<div class="banner">
		<div class="banner-top">
			<div class="title-one">ERROR</div>
			<div class="title-two">건강한 삶을 위한 먹거리 프로젝트</div>
		</div>
	</div>

	<section>
		<div class="error-board">
			<c:choose>
				<c:when test="${error == 'signUp'}">
					<div>중복된 아이디입니다.</div>
				</c:when>
				<c:when test="${error == 'logIn'}">
					<div>아이디 또는 패스워드를 잘못 입력하셨습니다.</div>
				</c:when>
			</c:choose>
			<button onclick="backPage()">뒤로가기</button>
		</div>
	</section>

	<footer>
		<jsp:include page="../../../footer.jsp" flush="true" />
	</footer>
</body>
</html>