<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script src="<c:url value="/resources/js/button.js"/>"></script>
<script src="<c:url value="/resources/js/init.js"/>"></script>

</head>
<body>
	<header>
		<jsp:include page="../../header.jsp" flush="true" />
	</header>

	<nav>
		<jsp:include page="../../nav.jsp" flush="true" />
	</nav>

	<div class="banner">
		<div class="banner-top">
			<div class="title-one">공지사항</div>
			<div class="title-two">건강한 삶을 위한 먹거리 프로젝트</div>
		</div>
	</div>

	<section>
		<div class="notice-view-board">
			<table>
				<thead>
					<tr>
						<td>
							<div class="title-up">
								<span class="title">${notice.title}</span> <span class="date">${notice.date}</span>
							</div>
							<div class="title-bottom">작성자: ${notice.writer}</div>
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${notice.content}</td>
					</tr>
				</tbody>
			</table>
			<div class="view-btns">
				<button class="notice-list-btn">목록</button>
				<c:if test="${member.id == notice.writer}">
				<button class="notice-update-btn">수정</button>
				<button class="notice-delete-btn" id="${notice.idx}">삭제</button>
				</c:if>
			</div>
		</div>
	</section>

	<footer>
		<jsp:include page="../../footer.jsp" flush="true" />
	</footer>
</body>
</html>