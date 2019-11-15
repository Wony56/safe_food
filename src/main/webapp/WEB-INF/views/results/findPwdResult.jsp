<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SafeFood::패스워드 찾기</title>
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
			<div class="title-one">패스워드 찾기</div>
			<div class="title-two">건강한 삶을 위한 먹거리 프로젝트</div>
		</div>
	</div>

	<section>
		<div class="find-pwd-result-board">
			<c:choose>
				<c:when test="${result == 'ok' }">
					<div class="result_success">
						패스워드: ${pwd}
					</div>
					<button id="go-home">메인으로</button>
				</c:when>
				<c:otherwise>
					<div class="result_fail">
						존재하지 않는 정보입니다.
					</div>
					<button id="find-pwd">다시찾기</button>
				</c:otherwise>
			</c:choose>
		</div>
	</section>

	<footer>
		<jsp:include page="../../../footer.jsp" flush="true" />
	</footer>
</body>
</html>