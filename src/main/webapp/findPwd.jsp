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
<script src="<c:url value="/resources/js/signupInvalid.js"/>"></script>

</head>
<body>
	<header>
		<jsp:include page="header.jsp" flush="true" />
	</header>

	<nav>
		<jsp:include page="nav.jsp" flush="true" />
	</nav>

	<div class="banner">
		<div class="banner-top">
			<div class="title-one">패스워드 찾기</div>
			<div class="title-two">건강한 삶을 위한 먹거리 프로젝트</div>
		</div>
	</div>

	<section>
		<div class="find-pwd-board">
			<form action="findPwd.do" method="post">
				<table>
					<tr>
						<th>
							아이디
						</th>
						<td>
							<input type="text" name="id" placeholder="아이디를 입력해주세요." required="required">
						</td>
					</tr>
					<tr>
						<th>
							연락처
						</th>
						<td>
							<input type="text" id="cellPhone" name="phone" placeholder="연락처를 입력해주세요." required="required">
						</td>
					</tr>
				</table>
				<div class="find-btns">
					<button type="submit">찾기</button>
					<button id="go-home">취소</button>
				</div>
			</form>
		</div>
	</section>

	<footer>
		<jsp:include page="footer.jsp" flush="true" />
	</footer>
</body>
</html>