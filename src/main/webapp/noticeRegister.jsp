<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SafeFood::공지사항</title>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script src="<c:url value="/resources/js/button.js"/>"></script>
<script src="<c:url value="/resources/js/init.js"/>"></script>

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
			<div class="title-one">공지사항 작성</div>
			<div class="title-two">건강한 삶을 위한 먹거리 프로젝트</div>
		</div>
	</div>

	<section>
		<div class="notice-register-board">
			<form action="registerNotice.do" method="post">
				<input type="hidden" name="writer" value="${sessionScope.member.id}">
				<table>
					<tr>
						<th>제목</th>
						<td><textarea class="notice-title" name="title" cols="100"
								rows="1" placeholder="제목을 입력하세요." required="required"></textarea></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea class="notice-content" name="content"
								cols="100" rows="20" placeholder="내용을 입력하세요."></textarea></td>
					</tr>
				</table>
				<div class="notice-btns">
					<button id="register-btn" type="submit">등록</button>
					<button id="cancel-btn">취소</button>
				</div>
			</form>
		</div>
	</section>

	<footer>
		<jsp:include page="footer.jsp" flush="true" />
	</footer>
</body>
</html>