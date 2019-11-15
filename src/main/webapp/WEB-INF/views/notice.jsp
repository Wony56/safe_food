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
		<div class="notice-board">
			<table>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>					
					<th>작성일</th>					
				</tr>
				<c:forEach var="notice" items="${noticeList}" varStatus="i">
				<tr>
					<td>${noticeList.size() - i.count + 1}</td>
					<td><a href="getNotice.do?idx=${notice.idx}">${notice.title}</a></td>
					<td>${notice.writer}</td>
					<td>${notice.date}</td>
				</tr>
				</c:forEach>
			</table>
			<c:if test="${sessionScope.member != null }">
			<button id="notice-register-btn">작성하기</button>
			</c:if>
		</div>
	</section>

	<footer>
		<jsp:include page="../../footer.jsp" flush="true" />
	</footer>
</body>
</html>